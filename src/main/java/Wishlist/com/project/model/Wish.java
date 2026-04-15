package Wishlist.com.project.model;

public class Wish {
    private int id;
    private String titel;
    private double pris;
    private String beskrivelse;
    private String link;


    public Wish(int id, double pris, String titel, String beskrivelse, String link) {
        this.id = id;
        this.pris = pris;
        this.titel = titel;
        this.beskrivelse = beskrivelse;
        this.link = link;

    }

    public double getPris() {
        return pris;
    }

    public int getId() {
        return id;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public String getLink() {
        return link;
    }

    public String getTitel() {
        return titel;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }
}






/* hvad skal indgå i wish

- titel
- pris
- beskrivelse (størellse etc)
- billede
- link

- måske et id ?




*/