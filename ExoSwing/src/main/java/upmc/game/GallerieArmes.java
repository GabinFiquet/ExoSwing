package upmc.game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GallerieArmes extends JPanel implements ActionListener {
    JLabel picture;
    
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {public void run() {
                createAndShowGUI();
            }
        });
    }

    public GallerieArmes() {
        super(new BorderLayout());

        String[] armes = { "Marteau du destin", "Deuillegivre", "Porte-cendre", "Sorcelance", "Tranche-malheur", "Aluneth", "Hurlesang", "Rhok'delar" };

        JComboBox armesList = new JComboBox(armes);
        armesList.setSelectedIndex(0);
        armesList.addActionListener(this);

        picture = new JLabel();
        picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
        picture.setHorizontalAlignment(JLabel.CENTER);
        updateLabel(armes[armesList.getSelectedIndex()]);
        picture.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        picture.setPreferredSize(new Dimension(600, 600+10));

        add(armesList, BorderLayout.PAGE_START);
        add(picture, BorderLayout.PAGE_END);

    }

    
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String armeNom = (String)cb.getSelectedItem();
        updateLabel(armeNom);
    }

    protected void updateLabel(String name) {
        ImageIcon icon = createImageIcon("img/" + name + ".jpg");
        picture.setIcon(icon);
        picture.setToolTipText("A drawing of a " + name.toLowerCase());
        if (icon != null) {
            picture.setText(null);
        } else {
            picture.setText("Image not found");
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private static void createAndShowGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Galerie d'arme");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new GallerieArmes();
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }
}