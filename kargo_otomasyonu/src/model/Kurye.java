package model;

public class Kurye extends Kisi {

    private int kuryeNo;

    public Kurye(int kuryeNo, String ad, String soyad, String telefon)
            throws IllegalArgumentException {

        super(ad, soyad, telefon);

        if (kuryeNo <= 0) {
            throw new IllegalArgumentException("Kurye numarası 0 veya negatif olamaz.");
        }

        this.kuryeNo = kuryeNo;
    }

    public int getKuryeNo() {
        return kuryeNo;
    }

    @Override
    public String toString() {
        return kuryeNo + " - " + getAd() + " " + getSoyad();
    }
}
