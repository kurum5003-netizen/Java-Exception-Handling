package model;

public class Musteri extends Kisi {

    private String adres;

    public Musteri(String ad, String soyad, String telefon, String adres)
            throws IllegalArgumentException {

        super(ad, soyad, telefon);

        if (adres == null || adres.trim().isEmpty()) {
            throw new IllegalArgumentException("Adres bilgisi boş olamaz.");
        }

        this.adres = adres;
    }

    public String getAdres() {
        return adres;
    }

    @Override
    public String toString() {
        return getAd() + " " + getSoyad();
    }
}
