public class Entry {
    Device device;
    int numberOfEntries;

    public Entry(int deviceId, int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }
}
