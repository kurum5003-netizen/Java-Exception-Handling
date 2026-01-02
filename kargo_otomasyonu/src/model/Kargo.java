package model;

public class Kargo {

    private static int sayac = 1;

    private int kargoNo;
    private Musteri gonderici;
    private Musteri alici;
    private Kurye kurye;
    private KargoDurumu durum;

    public Kargo(Musteri gonderici, Musteri alici, Kurye kurye) 
            throws IllegalArgumentException {

        if (gonderici == null || alici == null || kurye == null) {
            throw new IllegalArgumentException("Gönderici, alıcı ve kurye boş olamaz.");
        }

        this.kargoNo = sayac++;
        this.gonderici = gonderici;
        this.alici = alici;
        this.kurye = kurye;
        this.durum = KargoDurumu.KABUL_EDILDI;
    }

    public int getKargoNo() {
        return kargoNo;
    }

    public void setDurum(KargoDurumu durum) {
        if (durum == null) {
            throw new IllegalArgumentException("Kargo durumu boş olamaz.");
        }
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Kargo No: " + kargoNo +
               " | Gönderici: " + gonderici +
               " | Alıcı: " + alici +
               " | Kurye: " + kurye +
               " | Durum: " + durum;
    }
}
