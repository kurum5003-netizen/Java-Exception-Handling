package gui;

import service.*;

import javax.swing.*;

public class AnaEkran extends JFrame {

    public AnaEkran() {

        setTitle("Kargo Otomasyonu");
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MusteriService ms = new MusteriService();
        KuryeService ks = new KuryeService();
        KargoService kgs = new KargoService();

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Müşteri", new MusteriPanel(ms));
        tabs.add("Kurye", new KuryePanel(ks));
        tabs.add("Kargo", new KargoPanel(ms, ks, kgs));

        add(tabs);
    }
}
