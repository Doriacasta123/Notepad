import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;

public class Notepad implements ActionListener {

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

    public Notepad() {
        f = new Frame("NOTAS");
        mb = new MenuBar();
        m1 = new Menu("ARCHIVO");
        m2 = new Menu("EDICION");
        m3 = new Menu("ACERCA DE");
        mi1 = new MenuItem("NUEVO");
        mi2 = new MenuItem("ABRIR");
        mi3 = new MenuItem("GUARDAR");
        mi4 = new MenuItem("SALIR");
        mi5 = new MenuItem("DATOS DEL AUTOR");
        mi6 = new MenuItem("VERSION");
        mi7 = new MenuItem("BARRA DE HERRAMIENTAS");

        ta = new TextArea("Escribe aqui");
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

        // Barra de herramientas
        f2 = new JFrame("Barra Herramientas");
        barra = new JToolBar("Herramientas de edicion", JToolBar.HORIZONTAL);
        b1 = new JButton("Cortar");
        b2 = new JButton("Seleccionar");
        b3 = new JButton("Copiar");
        cb = new Checkbox("Copiar");
        cb2 = new Checkbox("Cortar");
        cb3 = new Checkbox("Seleccionar");

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
            filter = new FileNameExtensionFilter("TEXTO PLANO", "txt", "c", "cpp", "java", "bat");
            chooser.setFileFilter(filter);
            int returnVal = chooser.showSaveDialog(f);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                destino = chooser.getSelectedFile().getAbsolutePath();
                FileWriter fw = new FileWriter(destino);
                fw.write(ta.getText());
                fw.close();
                System.out.println("Archivo guardado en: " + destino);
            }
        } catch (IOException e) {
            System.out.println("Error E/S: " + e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mi3) {
            leer();
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }
}