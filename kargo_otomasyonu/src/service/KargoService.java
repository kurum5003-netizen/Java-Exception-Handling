package service;

import model.Kargo;
import java.util.ArrayList;
import java.util.List;

public class KargoService {

    private List<Kargo> kargolar = new ArrayList<>();

    public void ekle(Kargo k) throws IllegalArgumentException {
        if (k == null) {
            throw new IllegalArgumentException("Eklenecek kargo null olamaz.");
        }
        kargolar.add(k);
    }

    public List<Kargo> liste() {
        return kargolar;
    }
}
