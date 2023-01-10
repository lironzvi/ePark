public class Kid {
    private int idBySystem;
    private int age;
    private double height;
    private double weight;
    private String name;
    private Bracelet bracelet;

    public Kid (String name, double weight, double height, int age, int idBySystem) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.weight = weight;
        this.idBySystem = idBySystem;
        this.bracelet = new Bracelet(); // TODO: should the bracelet get id on construction?
    }

    public int getIdBySystem() {
        return idBySystem;
    }

    public void setIdBySystem(int idBySystem) {
        this.idBySystem = idBySystem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bracelet getBracelet() {
        return bracelet;
    }

    public String toString(){
        String s = "";
        s += "Name: ";
        s += getName();
        s += "\n";
        s += "Height: ";
        s += getHeight();
        s += "\n";
        s += "Weight: ";
        s += getWeight();
        s += "\n";
        s += "Age: ";
        s += getAge();
        return s;
    }
    public void setBracelet(Bracelet bracelet) {
        this.bracelet = bracelet;
    }
}
