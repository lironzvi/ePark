public class Entry {
    Device device;
    int currEntryPrice;
    public Entry(Device device) {
        if (device != null){
            this.device = device;
            this.currEntryPrice = (int)device.getEntryPrice();
        }
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getEntryPrice(){ return this.currEntryPrice; }
}


