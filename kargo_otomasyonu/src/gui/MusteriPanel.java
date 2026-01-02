package gui;

import model.Musteri;
import service.MusteriService;

import javax.swing.*;
import java.awt.*;

public class MusteriPanel extends JPanel {

    public MusteriPanel(MusteriService service) {

        setLayout(new BorderLayout());

        JTextField ad = new JTextField();
        JTextField soyad = new JTextField();
        JTextField tel = new JTextField();
        JTextField adres = new JTextField();

        DefaultListModel<Musteri> model = new DefaultListModel<>();
        JList<Musteri> list = new JList<>(model);

        JButton btn = new JButton("Müşteri Kaydet");

        btn.addActionListener(e -> {
            service.ekle(new Musteri(
                    ad.getText(),
                    soyad.getText(),
                    tel.getText(),
                    adres.getText()
            ));
            model.clear();
            service.liste().forEach(model::addElement);
        });

        JPanel form = new JPanel(new GridLayout(5,2));
        form.add(new JLabel("Ad")); form.add(ad);
        form.add(new JLabel("Soyad")); form.add(soyad);
        form.add(new JLabel("Telefon")); form.add(tel);
        form.add(new JLabel("Adres")); form.add(adres);
        form.add(btn);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
    }
}
