package service;

import model.Musteri;
import java.util.ArrayList;
import java.util.List;

public class MusteriService {

    private List<Musteri> musteriler = new ArrayList<>();

    public void ekle(Musteri m) throws IllegalArgumentException {
        if (m == null) {
            throw new IllegalArgumentException("Eklenecek müşteri null olamaz.");
        }
        musteriler.add(m);
    }

    public List<Musteri> liste() {
        return musteriler;
    }
}
