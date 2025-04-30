import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Notass implements ActionListener {

    Frame f;
    MenuBar mb;
    Menu m1, m2, m3;
    MenuItem mi1, mi2, mi3, mi4, mi5, mi6, mi7;
    TextArea ta;

    JFrame f2;
    JToolBar barra;
    JButton b1, b2, b3;
    Checkbox cb, cb2, cb3;

    JFileChooser chooser;
    FileNameExtensionFilter filter;
    String destino;

    public Notass() {
        f = new Frame("NOTES");
        mb = new MenuBar();
        m1 = new Menu("FILE");
        m2 = new Menu("EDIT");
        m3 = new Menu("ABOUT");
        mi1 = new MenuItem("NEW");
        mi2 = new MenuItem("OPEN");
        mi3 = new MenuItem("SAVE");
        mi4 = new MenuItem("EXIT");
        mi5 = new MenuItem("AUTHOR INFO");
        mi6 = new MenuItem("VERSION");
        mi7 = new MenuItem("TOOLBAR");

        ta = new TextArea("Write here");
        f.add(ta);

        mi2.addActionListener(this);
        mi3.addActionListener(this);

        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);
        m2.add(mi7);
        m3.add(mi5);
        m3.add(mi6);
        f.setMenuBar(mb);

        // Toolbar
        f2 = new JFrame("Toolbar");
        barra = new JToolBar("Editing tools", JToolBar.HORIZONTAL);
        b1 = new JButton("Cut");
        b2 = new JButton("Select");
        b3 = new JButton("Copy");
        cb = new Checkbox("Copy");
        cb2 = new Checkbox("Cut");
        cb3 = new Checkbox("Select");

        barra.add(b1);
        barra.add(b2);
        barra.add(b3);
        barra.addSeparator();
        barra.add(cb);
        barra.add(cb2);
        barra.add(cb3);

        f2.add(barra, BorderLayout.NORTH);

        f.setSize(800, 600);
        f.setVisible(true);

        f2.setSize(300, 200);
        f2.setVisible(true);
    }

    public void leer() {
        try {
            chooser = new JFileChooser();
            filter = new FileNameExtensionFilter("PLAIN TEXT", "txt", "c", "cpp", "java", "bat");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(f);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                destino = chooser.getSelectedFile().getAbsolutePath();
                FileWriter fw = new FileWriter(destino);
                fw.write(ta.getText());
                fw.close();
                System.out.println("File saved at: " + destino);
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mi3) {
            leer();
        }
    }

    public static void main(String[] args) {
        new Notass();
    }
}
