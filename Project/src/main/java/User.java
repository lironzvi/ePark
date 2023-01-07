import com.sun.xml.internal.bind.v2.TODO;
import org.omg.CORBA.WStringSeqHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private Guardian guardian;
    private HashMap<Kid, Eticket> eticketMap;
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

    public HashMap<Kid, Eticket> GeteticketMap() {
        return eticketMap;
    }

    public void setEticketList(HashMap<Kid, Eticket> eticketMap) {this.eticketMap = eticketMap; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addKid(String name, int weight, int height, int age){
        Kid newKid = new Kid(name, weight, height, age);
        Main.systemObjects.add(newKid);
        this.eticketMap.put(newKid, new Eticket(111)); // TODO: should the eticket get id on construction?

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
