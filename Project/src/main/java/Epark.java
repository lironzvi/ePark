import java.util.ArrayList;
import java.util.Scanner;

public class Epark {
    private static Epark instance;
    ArrayList<Device> devices;
    ArrayList<Guardian> guardians;
    ArrayList<Bracelet> bracelets;
    // probably main methods need to add here
    private Epark(){
        devices = new ArrayList<>();
        guardians = new ArrayList<>();
        bracelets = new ArrayList<>();
    }

    public static Epark getInstance() {
        if (instance == null) {
            instance = new Epark();
        }
        return instance;
    }

    public void addDevice(Device dev){
        if (dev != null){
            this.devices.add(dev);
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
        User.addKid(name, weight, height, age);

    }
}

