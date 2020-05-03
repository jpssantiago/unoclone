package br.sp.anhembi.p1.io;
import br.sp.anhembi.p1.entities.Card;
import br.sp.anhembi.p1.entities.Game;
import br.sp.anhembi.p1.entities.Player;

import javax.swing.*;

import java.awt.*;
/**
 *
 * @author msn-d
 */
public class UnoFrame extends javax.swing.JFrame {

    private final Player[] players;
    private Game game;

    public UnoFrame(Game game) {
        this.game = game;
        this.players = new Player[this.game.getPlayers().size()];
        loadPlayers();
        initComponents();
    }

    private void loadPlayers() {
        int index = 0;
        for (Player player : this.game.getPlayers()) {
            players[index++] = player;
        }
    }

    public String convertDeckToString(Player player) {
        String msg = "<html>";
        for (Card card : player.getDeck()) {
            msg += card.getLabel() + " - " + card.getColor() + "<br>";
        }
        return msg + "</html>";
    }

    private void initComponents() {
        JTabbedPane mainPanel = new JTabbedPane();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        for (Player player : players) {
            mainPanel.addTab(player.getName(), generateTab(player));
        }

        applyMainPanelLayout(mainPanel);
        pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void applyMainPanelLayout(JTabbedPane mainPanel) {
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel)
        );
    }

    public JPanel generateTab(Player player) {
        JPanel panel = new JPanel();

        for (Card card : player.getDeck()) {
            panel.add(new JLabel(configureCardImage(card.getCardImagePath())));
        }

        panel.setLayout(new GridLayout(2, 3));
        return panel;
    }

    public ImageIcon configureCardImage(String url) {
        ImageIcon imageIcon = new ImageIcon(url);
        Image image = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }
}