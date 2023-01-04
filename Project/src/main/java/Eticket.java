import java.util.ArrayList;
import java.util.Date;

public class Eticket {
    private int ticketId;
    private ArrayList<Entry> listEntries;
    private Date expirationDate;
    private double ticketPrice;

    public int getEticketId() {
        return ticketId;
    }

    public void setEticketId(int eticketId) {
        this.ticketId = eticketId;
    }

    public ArrayList<Entry> getListEntries() {
        return listEntries;
    }

    public void setListEntries(ArrayList<Entry> listEntries) {
        this.listEntries = listEntries;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public void addToEntries(int deviceId,int num){

    }

    public void deleteFromEntry(Entry entry){

    }

    public boolean isEntryExist(int deviceId){
        for (Entry entry: listEntries){
            if(entry.getDevice().getDeviceId() == deviceId){
                return true;
            }
        }
        return false;
    }

    public void checkout(){

    }
}
