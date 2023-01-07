public class Restrict {
    private double minHeight;
    private double maxWeight;
    private int minAge;

    public Restrict(){
        this.maxWeight = Double.POSITIVE_INFINITY;
        this.minHeight = 0;
        this.minAge = 0;
    }

    public Restrict(double minHeight, double maxWeight, int minAge) {
        this.minHeight = minHeight;
        this.maxWeight = maxWeight;
        this.minAge = minAge;
    }

    public double getMinHeight() {
        return minHeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMinHeight(double minHeight) {
        this.minHeight = minHeight;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
