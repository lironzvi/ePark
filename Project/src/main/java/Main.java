import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Object> systemObjects = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Epark epark = Epark.getInstance();
        epark_init(epark);
        System.out.println("Welcome to ePark ");
        while (true) {
            System.out.println("Please choose an action:");
            System.out.println("1. Register child");
            System.out.println("2. Manage ticket");
            System.out.println("3. Add ride");
            System.out.println("4. Remove ride");
            System.out.println("5. Exit part");
            System.out.println("6. Exit");

            String input = scanner.nextLine();
            int choice=-1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                choice = -1;
                System.out.println("Invalid choice. Please try again.");
            }
            if (choice >= 1 && choice <= 6) {
                switch (choice) {
                    case 1:
                        System.out.println("You chose Option 1");
                        break;
                    case 2:
                        System.out.println("You chose Option 2");
                        break;
                    case 3:
                        System.out.println("You chose Option 3");
                        break;
                    case 4:
                        System.out.println("You chose Option 4");
                        break;
                    case 5:
                        System.out.println("You chose Option 5");
                        break;
                    case 6:
                        System.out.println("You chose Option 6");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
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
    }
}