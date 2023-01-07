public class Device {
    private int deviceId;
    private String name;
    private boolean extreme;
    private boolean isActive;
    private String manufacturer;
    private double entryPrice;
    private Restrict restriction;

    public Device(int deviceId, String name, boolean extreme, boolean isActive, String manufacturer, double entryPrice, Restrict restriction) {
        this.deviceId = deviceId;
        this.name = name;
        this.extreme = extreme;
        this.isActive = isActive;
        this.manufacturer = manufacturer;
        this.entryPrice = entryPrice;
        this.restriction = restriction;
    }

    public boolean isKidInRestriction(Kid kid){
        return kid.getAge()>= restriction.getMinAge() && kid.getHeight() >= restriction.getMinHeight() && kid.getWeight() <= restriction.getMaxWeight();
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
