import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Object> systemObjects = new ArrayList<>();
//    Main.systemObjects.add(dev);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Epark epark = Epark.getInstance();
        Kid kid;
        epark_init(epark);
        System.out.println("Welcome to ePark ");
        while (true) {
            System.out.println("Please choose an action:");
            System.out.println("1. Register child");
            System.out.println("2. Manage ticket");
            System.out.println("3. Add ride");
            System.out.println("4. Remove ride");
            System.out.println("5. Exit park");
            System.out.println("6. Exit");
            System.out.println("7. Show kids list");
            System.out.println("8. Add budget");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
            }
            if (choice >= 1 && choice <= 8) {
                switch (choice) {
                    case 1:
                        System.out.println("Child Registration:");
                        epark.register_child();
                        break;
                    case 2:
                        System.out.println("Manage ticket:");
                        epark.manage_ticket();
                        break;
                    case 3:
                        System.out.println("Add Ride:");
                        kid = epark.getKidFromUser();
                        epark.addRide(kid, scanner);
                        break;
                    case 4:
                        System.out.println("Remove Ride:");
                        kid = epark.getKidFromUser();
                        epark.removeRide(kid, scanner);
                        break;
                    case 5:
                        System.out.println("Exit park:");
                        epark.exitPark();
                        break;
                    case 6:
                        System.out.println("Exit:");
                        System.out.println("Bye-Bye");
                        return;
                    case 7:
                        System.out.println("showing kids list:");
                        epark.showKidsPerUser();
                        break;
                    case 8:
                        System.out.println("add to budget:");
                        epark.addToBudget();
                        break;
                }
            } else{
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void epark_init(Epark epark){
        Restrict restrict1 = new Restrict(1.4,Double.POSITIVE_INFINITY,12);
        Restrict restrict2 = new Restrict();
        Restrict restrict3 = new Restrict(0, Double.POSITIVE_INFINITY, 8);
        Device device1 = new Device(1,"Mamba Ride", true, true, "China", 10, restrict1);
        Device device2 = new Device(2,"Giant Wheel", false, true, "China", 15, restrict2);
        Device device3 = new Device(3,"Carrousel", false, true, "China", 8, restrict3);
        epark.addDevice(device1);
        epark.addDevice(device2);
        epark.addDevice(device3);
        Guardian guardian1 = new Guardian("Israel");
        User user1 = new User(guardian1,"password", "1234-5678 04/27 123", 0);
        user1.depositMoney(2000);
        epark.addGuardian(guardian1);
        epark.addUser(user1);
        epark.setCurUser(user1);
    }
}
