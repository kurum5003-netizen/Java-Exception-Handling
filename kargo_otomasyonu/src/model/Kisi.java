package model;

public abstract class Kisi {
    private String ad;
    private String soyad;
    private String telefon;

    public Kisi(String ad, String soyad, String telefon) {
        this.ad = ad;
        this.soyad = soyad;
        this.telefon = telefon;
    }

    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getTelefon() { return telefon; }
}
