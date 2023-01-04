import java.util.Date;

public class Bracelet {
    private Date expirationTime;
    private boolean isInUse;
    private int[] location;
    private Eticket ticket;

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public boolean isInUse() {
        return isInUse;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }

    public int[] getLocation() {
        return location;
    }

    public void setLocation(int[] location) {
        this.location = location;
    }

    public Eticket getTicket() {
        return ticket;
    }

    public void setTicket(Eticket ticket) {
        this.ticket = ticket;
    }
}
