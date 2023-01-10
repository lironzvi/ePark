import java.util.Arrays;
import java.util.HashMap;

public class User {
    private Guardian guardian;
    private HashMap<Integer, Eticket> eticketMap;
    private String password;
    private String cardDetails;
    private double budget;

    public User(Guardian guardian, String password, String cardDetails, double budget){
        this.budget = budget;
        this.cardDetails = cardDetails;
        this.password = password;
        this.guardian = guardian;
        this.eticketMap = new HashMap<>();
    }
    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public HashMap<Integer, Eticket> GeteticketMap() {
        return eticketMap;
    }

    public void setEticketList(HashMap<Integer, Eticket> eticketMap) {this.eticketMap = eticketMap; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int addKid(String name, double weight, double height, int age, int idBySystem){
        Kid newKid = new Kid(name, weight, height, age, idBySystem);
        Main.systemObjects.add(newKid);
        this.guardian.addKidToList(newKid);
        this.eticketMap.put(newKid.getIdBySystem(), new Eticket(111)); // TODO: should the eticket get id on construction?
        return newKid.getIdBySystem();
    }

    public Eticket getEticketFromKid(int id){
        return this.eticketMap.getOrDefault(id, null);
    }

    public String getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(String cardDetails) {
        this.cardDetails = cardDetails;
    }

    public double getBudget() {
        return budget;
    }

    public void depositMoney(double budget) {
        if (isTransactionApproved(budget))
            this.budget += budget;
    }

    public void charge(double budget){
        this.budget -= budget;
    }
    public Boolean isTransactionApproved(double amount){
        return true;
    }

    public void buyEntries(Device device, int kidId){
        //TODO
        Eticket ticket = eticketMap.get(kidId);
        if (device.getEntryPrice() <= getBudgetExpence(ticket)){
            ticket.addToEntries(device);
            System.out.println("device was added");
        }
        else{
            System.out.println("budget is not enough for this device");
        }
    }

    public void removeEntries(Device device, int kidId){
        Eticket ticket = eticketMap.get(kidId);
        ticket.deleteFromEntry(device.getDeviceId());
        System.out.println("device was removed");
    }


    public double getBudgetExpence(Eticket ticketId){
        return budget - ticketId.getTicketPrice();
    }

    public void goToCheckout(int ticketId){
        // not sure what checkout means
    }

    public void showKidLocation(Kid kid){
        System.out.println("kid: " + kid.getName());
        System.out.println("location: " + Arrays.toString(kid.getBracelet().getLocation()));
    }
}
