package service;

import model.Kurye;
import java.util.ArrayList;
import java.util.List;

public class KuryeService {

    private List<Kurye> kuryeler = new ArrayList<>();

    public void ekle(Kurye k) throws IllegalArgumentException {
        if (k == null) {
            throw new IllegalArgumentException("Eklenecek kurye null olamaz.");
        }
        kuryeler.add(k);
    }

    public List<Kurye> liste() {
        return kuryeler;
    }
}
