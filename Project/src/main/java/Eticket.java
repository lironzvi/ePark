import java.util.ArrayList;
import java.util.Date;

public class Eticket {
    private int ticketId;
    private ArrayList<Entry> listEntries;
    private Date expirationDate;
    private double ticketPrice;

    public Eticket(int ticketId){
        this.listEntries = new ArrayList<>();
        this.ticketId = ticketId;
        this.ticketPrice = 0;
        expirationDate = null;

    }
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

    public void addToEntries(Device device){
        if (device != null){
            Entry newEntry = new Entry(device);
            listEntries.add(newEntry);
            this.ticketPrice += newEntry.getEntryPrice();
        }
    }

    public boolean deleteFromEntry(int deviceId){
        if(!isEntryExist(deviceId)){ return false;}
        for(Entry entry: listEntries){
            if (entry.getDevice().getDeviceId() == deviceId){
                listEntries.remove(entry);
                return true;
            }
        }
        return true;
    }

    public boolean isEntryExist(int deviceId){
        for (Entry entry: listEntries){
            if(entry.getDevice().getDeviceId() == deviceId){
                return true;
            }
        }
        return false;
    }

    public double checkout(){
        if(listEntries.isEmpty()) { return ticketPrice; }
        int sumToRemove = 0;
        for(Entry entry : listEntries){
            sumToRemove += entry.getEntryPrice();
        }
        listEntries.clear();
        ticketPrice -= sumToRemove;
        return ticketPrice;
    }
}
