import java.util.ArrayList;

public class Guardian {
    ArrayList<Eticket> eticketList;
    ArrayList<Kid> kidsList;
    String name;

    public Guardian(String name) {
        this.name = name;
        this.kidsList = new ArrayList<>();
        this.eticketList = new ArrayList<>();
    }

    public ArrayList<Eticket> getEticketList() {
        return eticketList;
    }

    public void setEticketList(ArrayList<Eticket> eticketList) {
        this.eticketList = eticketList;
    }

    public ArrayList<Kid> getKidsList() {
        return kidsList;
    }

    public void setKidsList(ArrayList<Kid> kidsList) {
        this.kidsList = kidsList;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Kid getKidId(int id){
        for (Kid kid : kidsList) {
            if (kid.getIdBySystem() == id) {
                return kid;
            }
        }
        return null;
    }

    public void addKidToList(Kid kid){
        if(kid != null){
            kidsList.add(kid);
        }
    }
}
