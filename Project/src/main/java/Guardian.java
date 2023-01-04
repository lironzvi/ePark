import java.util.ArrayList;

public class Guardian {
    ArrayList<Eticket> eticketList;
    ArrayList<Kid> kidList;
    String name;

    public ArrayList<Eticket> getEticketList() {
        return eticketList;
    }

    public void setEticketList(ArrayList<Eticket> eticketList) {
        this.eticketList = eticketList;
    }

    public ArrayList<Kid> getKidList() {
        return kidList;
    }

    public void setKidList(ArrayList<Kid> kidList) {
        this.kidList = kidList;
    }

    public Guardian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kid getKidId(int id){
        for (Kid kid : kidList) {
            if (kid.getIdBySystem() == id) {
                return kid;
            }
        }
        return null;
    }
}
