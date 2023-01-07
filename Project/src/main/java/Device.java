public class Device {
    private boolean extreme;
    private int deviceId;
    private boolean isActive;

    private boolean manufactor;
    private double entryPrice;
    private Restrict restrict;

    public boolean isKidInRestriction(Kid kid){
        return kid.getAge()> restrict.getDesirableAge() && kid.getHeight() > restrict.getDesirableHeight();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isExtreme() {
        return extreme;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public double getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(double entryPrice) {
        this.entryPrice = entryPrice;
    }
}
