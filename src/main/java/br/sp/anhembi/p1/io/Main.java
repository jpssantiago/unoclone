package br.sp.anhembi.p1.io;

import br.sp.anhembi.p1.entities.Game;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String amount;
        do {
            amount = JOptionPane.showInputDialog("Informe a quantidade de jogadores (no mínimo 2 e no máximo 10).");
        } while (!isNumeric(amount));
        new UnoFrame(new Game(Integer.parseInt(amount)));
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}