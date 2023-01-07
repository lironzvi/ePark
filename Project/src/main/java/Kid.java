public class Kid {
    private int idBySystem;
    private int age;
    private int height;
    private int weight;
    private String name;
    private Bracelet bracelet;

    public Kid (String name, int weight, int height, int age) {
        this.age = age;
        this.height = height;
        this.name = name;
        this.weight = weight;
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

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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

    public void setBracelet(Bracelet bracelet) {
        this.bracelet = bracelet;
    }
}
