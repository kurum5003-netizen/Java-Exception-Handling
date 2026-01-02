package gui;

import model.Kurye;
import service.KuryeService;

import javax.swing.*;
import java.awt.*;

public class KuryePanel extends JPanel {

    public KuryePanel(KuryeService service) {

        setLayout(new BorderLayout());

        JTextField no = new JTextField();
        JTextField ad = new JTextField();
        JTextField soyad = new JTextField();
        JTextField tel = new JTextField();

        DefaultListModel<Kurye> model = new DefaultListModel<>();
        JList<Kurye> list = new JList<>(model);

        JButton btn = new JButton("Kurye Kaydet");

        btn.addActionListener(e -> {
            try {
                int kuryeNo = Integer.parseInt(no.getText());

                service.ekle(new Kurye(
                        kuryeNo,
                        ad.getText(),
                        soyad.getText(),
                        tel.getText()
                ));

                model.clear();
                service.liste().forEach(model::addElement);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Kurye No sayısal olmalıdır!",
                        "Hata",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        JPanel form = new JPanel(new GridLayout(5,2));
        form.add(new JLabel("Kurye No")); form.add(no);
        form.add(new JLabel("Ad")); form.add(ad);
        form.add(new JLabel("Soyad")); form.add(soyad);
        form.add(new JLabel("Telefon")); form.add(tel);
        form.add(btn);

        add(form, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
    }
}
