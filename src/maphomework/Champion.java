package maphomework;


public class Champion {
    private int id;
    private int year;
    private String champion;

    public Champion(){

    }

    public Champion(int id, int year, String champion) {
        this.id = id;
        this.year = year;
        this.champion = champion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }
}
