import java.util.*;

public class Epark {
    public static final int maxKids = 100;
    private static Epark instance;
    Map<Integer, Device> devices;
    ArrayList<Guardian> guardians;
    Map<Integer, Bracelet> bracelets;
    ArrayList<User> users;
    User curUser;
    Set<Integer> idToKidBySystem = new HashSet<>();
    // probably main methods need to add here
    private Epark(){
        devices = new HashMap<>();
        guardians = new ArrayList<>();
        bracelets = new HashMap<>();
        users = new ArrayList<>();
        for (int i = 0; i < maxKids; i ++){
            idToKidBySystem.add(i);
        }
    }

    public void addGuardian(Guardian guardian){
        if(guardian != null){
            this.guardians.add(guardian);
            Main.systemObjects.add(guardian);
        }
    }

    public void addUser(User user){
        if(user != null){
            this.users.add(user);
            Main.systemObjects.add(user);
        }
    }

    public void setCurUser(User user){
        if(user != null) {
            this.curUser = user;
        }
    }

    public static Epark getInstance() {
        if (instance == null) {
            instance = new Epark();
        }
        return instance;
    }

    public void addDevice(Device dev){
        if (dev != null){
            this.devices.put(dev.getDeviceId(), dev);
            Main.systemObjects.add(dev);
        }
    }

    public void register_child(){
        Scanner scanner = new Scanner(System.in);
        String name;
        double height;
        double weight;
        int age;

        while (true) {
            System.out.println("Please enter Child's name: ");
            name = scanner.nextLine();
            if (name.length() > 30)
                System.out.println("Child's name is too long, please try again");
            else if (name.length()==0)
                System.out.println("Child's name can't be empty, please try again");
            else
                break;
        }
        while (true) {
            System.out.println("Please measure kid's height and enter the result in meters");
            String input = scanner.nextLine();
            try {
                height = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            if (height < 3 && height > 0) {
                break;
            } else {
                System.out.println("Invalid height, please try again");
            }
        }
        while (true) {
            System.out.println("Please measure kid's weight and enter the result in kg");
            String input = scanner.nextLine();
            try {
                weight = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            if (weight < 200 && weight > 0) {
                break;
            } else {
                System.out.println("Invalid height, please try again");
            }
        }
        while (true) {
            System.out.println("Please enter kid's age");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            if (age < 120 && age > 0) {
                break;
            } else {
                System.out.println("Invalid age, please try again");
            }
        }
        int idBySystem = idToKidBySystem.stream().findAny().get();
        curUser.addKid(name, weight, height, age, idBySystem);
        System.out.println("Kid registered successfully\nKid's id is: " + idBySystem);
    }

    public void manage_ticket() {
        Eticket ticket;
        Kid kid;
        Scanner scanner = new Scanner(System.in);
        int id;
        String action;
        while (true) {
            System.out.println("Enter Child's Id:");
            try{
                id = new Integer(scanner.nextLine());
            } catch(Exception e){
                System.out.println("Please enter id in digit only format!");
                continue;
            }
            ticket = curUser.getEticketFromKid(id);
            kid = curUser.getGuardian().getKidId(id);
            if (ticket == null){
                System.out.println("Child's name doesn't exist in this user");
            }
            else{
                break;
            }
        }
        while (true) {
            System.out.println("Please choose an action:");
            System.out.println("1. Add ride to ticket");
            System.out.println("2. Remove ride from ticket");
            System.out.println("3. Check if entry exist");
            System.out.println("4. Back to main menu");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
            }
            if (choice >= 1 && choice <= 4) {
                switch (choice) {
                    case 1:
                        addRide(kid, scanner);
                        break;

                    case 2:
                        removeRide(kid, scanner);
                        break;

                    case 3:
                        checkIfDeviceExist(ticket, scanner);
                        break;
                    case 4:
                        return;
                }
            }
        }
    }

    private void checkIfDeviceExist(Eticket ticket, Scanner scanner) {
        System.out.println("Which device would you like to check if exist (enter device ID)");
        String deviceId = scanner.nextLine();
        int deviceIdToCheck;
        try {
            deviceIdToCheck = Integer.parseInt(deviceId);
        } catch (NumberFormatException e) {
            deviceIdToCheck = -1;
        }
        if (ticket.isEntryExist(deviceIdToCheck)) {
            System.out.println("Device is in your ticket");
        }
        else{
            System.out.println("Device is not in your ticket");
        }
    }

    private void removeRide(Kid kid, Scanner scanner) {
        int ridesToDelete = ShowUserCurrentDevices(kid);
        if (ridesToDelete >= 1) {
            System.out.println("Which device would you like to remove (enter device ID)");
            String deviceId = scanner.nextLine();
            int deviceIdint;
            try {
                deviceIdint = Integer.parseInt(deviceId);
            } catch (NumberFormatException e) {
                deviceIdint = -1;
            }
            curUser.removeEntries(devices.get(deviceIdint), kid.getIdBySystem());
        }
        else{
            System.out.println("No entries to delete");
        }
        return;
    }

    private void addRide(Kid kid, Scanner scanner) {
        ArrayList<Integer> rides = ShowAvailableDevices(kid);
        if (rides.size() >= 1) {
            System.out.println("Which device would you like to add (enter device ID)");
            String deviceId = scanner.nextLine();
            int deviceIdint;
            try {
                deviceIdint = Integer.parseInt(deviceId);
            } catch (NumberFormatException e) {
                deviceIdint = -1;
            }

            if (devices.get(deviceIdint)!= null && rides.contains(deviceIdint)) {
                if (devices.get(deviceIdint).isExtreme()) {
                    System.out.println("This device is extreme, are you sure you want to add it?(y/n)");
                    String answer = scanner.nextLine().toLowerCase();
                    if (!answer.equals("y")) {
                        System.out.println("Not adding extreme device");
                        return;
                    }
                    System.out.println("Adding extreme device");
                }
                curUser.buyEntries(devices.get(deviceIdint), kid.getIdBySystem());
            }
            else{
                System.out.println("Invalid device id please try again.");
            }
        }
        else{
            System.out.println("No entries to add");
        }
    }

    private int ShowUserCurrentDevices(Kid kid) {
        Eticket ticket = curUser.getEticketFromKid(kid.getIdBySystem());
        int availableRides = 0;
        ArrayList<Entry> entryList =  ticket.getListEntries();
        for (Entry entry : entryList){
            System.out.println(entry.getDevice());
            availableRides ++;
        }
        System.out.println("overall " + availableRides + " available rides");
        return availableRides;
    }

    public ArrayList <Integer> ShowAvailableDevices(Kid kid){
        ArrayList <Integer> availableRides = new ArrayList<>();
        Device device;
         for (int deviceId : devices.keySet()) {
             device = devices.get(deviceId);
             if(device.isKidInRestriction(kid) && device.isActive()){
                 System.out.println(device);
                 availableRides.add(deviceId);
             }
         }
         System.out.println("overall " + availableRides.size() + " available rides");
         return availableRides;
    }

    public void appLocation() {
        Eticket ticket;
        Kid kid;
        Scanner scanner = new Scanner(System.in);
        int id;
        String action;
        while (true) {
            System.out.println("Enter Child's Id:");
            try{
                id = new Integer(scanner.nextLine());
            } catch(Exception e){
                System.out.println("Please enter id in digit only format!");
                continue;
            }
            ticket = curUser.getEticketFromKid(id);
            kid = curUser.getGuardian().getKidId(id);
            if (ticket == null){
                System.out.println("Child's name doesn't exist in this user");
            }
            else{
                break;
            }
        }
        curUser.showKidLocation(kid);
    }

    public void exitPark() {
        Eticket ticket;
        Kid kid;
        Scanner scanner = new Scanner(System.in);
        int id;
        String action;
        while (true) {
            System.out.println("Enter Child's Id:");
            try{
                id = new Integer(scanner.nextLine());
            } catch(Exception e){
                System.out.println("Please enter id in digit only format!");
                continue;
            }
            ticket = curUser.getEticketFromKid(id);
            kid = curUser.getGuardian().getKidId(id);
            if (ticket == null){
                System.out.println("Child's name doesn't exist in this user");
            }
            else{
                break;
            }
        }
        returnBraclet(kid);
        CheckOutCharge(kid);
        nnRegisterKid(kid);
    }

    private void CheckOutCharge(Kid kid) {
        double price = curUser.getEticketFromKid(kid.getIdBySystem()).getTicketPrice();
        System.out.println("you were charged " + price + " units of money");
    }

    private void nnRegisterKid(Kid kid) {
        idToKidBySystem.add(kid.getIdBySystem());
        ArrayList<Kid> list = curUser.getGuardian().getKidsList();
        list.remove(kid);
        curUser.getGuardian().setKidsList(list);
    }

    private void returnBraclet(Kid kid) {
        bracelets.remove(kid.getBracelet().getBraceletId());
        kid.getBracelet().reset();

    }
}

