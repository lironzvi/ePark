import java.util.ArrayList;

public class User {
    private Guardian guardian;
    private ArrayList<Eticket> eticketList;
    private String password;
    private String cardDetails;
    private double budget;

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public ArrayList<Eticket> getEticketList() {
        return eticketList;
    }

    public void setEticketList(ArrayList<Eticket> eticketList) {
        this.eticketList = eticketList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void buyEntries(int eticketId){
        // should ask which entries to add and add them
    }

    public void removeEntries(int eticketId){
        // should ask which entries to remove and remove them
    }

    public double getBudgetExpence(int ticketId){
        // get ticket and return its budget
    }

    public void goToCheckout(int ticketId){
        // not sure what checkout means
    }

    public int[] showKidLocation(){
        // ask for kid's id?
    }
}
