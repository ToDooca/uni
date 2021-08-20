package model;

public class Lokacija {
    private int redniBroj;
    private String name;
    private int udaljenost;

    public Lokacija(int redniBroj, String name) {
        this.redniBroj = redniBroj;
        this.name = name;
    }

    public int getUdaljenost() {
        return udaljenost;
    }

    public void setUdaljenost(int udaljenost) {
        this.udaljenost = udaljenost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
