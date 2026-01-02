package main;

import gui.AnaEkran;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->
                new AnaEkran().setVisible(true)
        );
    }
}
