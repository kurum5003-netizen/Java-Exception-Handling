package gui;

import model.*;
import service.*;

import javax.swing.*;
import java.awt.*;

public class KargoPanel extends JPanel {

    private DefaultListModel<Kargo> listModel;
    private JList<Kargo> kargoList;

    public KargoPanel(
            MusteriService ms,
            KuryeService ks,
            KargoService kgs) {

        setLayout(new BorderLayout());

        /* =========================
           ÜST PANEL – KARGO OLUŞTURMA
           ========================= */

        JComboBox<Musteri> cmbGonderici = new JComboBox<>();
        JComboBox<Musteri> cmbAlici = new JComboBox<>();
        JComboBox<Kurye> cmbKurye = new JComboBox<>();

        JButton btnYenile = new JButton("Listeleri Yenile");
        JButton btnOlustur = new JButton("Kargo Oluştur");

        JPanel form = new JPanel(new GridLayout(5, 2));
        form.add(new JLabel("Gönderici:"));
        form.add(cmbGonderici);
        form.add(new JLabel("Alıcı:"));
        form.add(cmbAlici);
        form.add(new JLabel("Kurye:"));
        form.add(cmbKurye);
        form.add(btnYenile);
        form.add(btnOlustur);

        /* =========================
           ORTA PANEL – KARGO LİSTESİ
           ========================= */

        listModel = new DefaultListModel<>();
        kargoList = new JList<>(listModel);
        JScrollPane scroll = new JScrollPane(kargoList);

        /* =========================
           ALT PANEL – DURUM GÜNCELLEME
           ========================= */

        JComboBox<KargoDurumu> cmbDurum =
                new JComboBox<>(KargoDurumu.values());

        JButton btnDurumGuncelle =
                new JButton("Durumu Güncelle");

        JPanel durumPanel = new JPanel();
        durumPanel.add(new JLabel("Yeni Durum:"));
        durumPanel.add(cmbDurum);
        durumPanel.add(btnDurumGuncelle);

        /* =========================
           BUTON OLAYLARI
           ========================= */

        btnYenile.addActionListener(e -> {
            cmbGonderici.removeAllItems();
            cmbAlici.removeAllItems();
            cmbKurye.removeAllItems();

            for (Musteri m : ms.liste()) {
                cmbGonderici.addItem(m);
                cmbAlici.addItem(m);
            }

            for (Kurye k : ks.liste()) {
                cmbKurye.addItem(k);
            }
        });

        btnOlustur.addActionListener(e -> {

            if (cmbGonderici.getSelectedItem() == null ||
                cmbAlici.getSelectedItem() == null ||
                cmbKurye.getSelectedItem() == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Lütfen tüm alanları doldurun!",
                        "Uyarı",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            Kargo kargo = new Kargo(
                    (Musteri) cmbGonderici.getSelectedItem(),
                    (Musteri) cmbAlici.getSelectedItem(),
                    (Kurye) cmbKurye.getSelectedItem()
            );

            kgs.ekle(kargo);
            listModel.addElement(kargo);
        });

        btnDurumGuncelle.addActionListener(e -> {

            Kargo seciliKargo = kargoList.getSelectedValue();

            if (seciliKargo == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Lütfen bir kargo seçin!",
                        "Uyarı",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            seciliKargo.setDurum(
                    (KargoDurumu) cmbDurum.getSelectedItem()
            );

            kargoList.repaint(); // değişiklik ekranda görünür
        });

        /* =========================
           PANELE EKLEME
           ========================= */

        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(durumPanel, BorderLayout.SOUTH);
    }
}
