package NHF;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GUI extends JFrame {

    private Library konyvtar = new Library(new ArrayList<>());
    public GUI() {

    JFrame frame = new JFrame("Könyvtár");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(600, 400);

    // Create a JPanel to hold the labels and set its layout to FlowLayout
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    JLabel cim = new JLabel();
        cim.setText("<html><center><p>         <br />         <br />--------------------<br />KÖNYVTÁR <br /> By Molnár Botond<br />--------------------<br /></p></center></html>");
        cim.setFont(new Font("Times New Roman", 0, 30));


   panel.add(cim);

   frame.add(panel, BorderLayout.CENTER);

   showMainMenu(frame);

   frame.setVisible(true);
}
    public void showMainMenu(JFrame frame){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Fájl");
        JMenuItem mentes = new JMenuItem("Mentés");
        JMenuItem betoltes = new JMenuItem("Betöltés");
        JMenuItem kilepes = new JMenuItem("Kilépés");

        ImageIcon mentesicon = new ImageIcon("floppy.png");
        ImageIcon betoltesicon = new ImageIcon("folder.png");
        ImageIcon kilepesicon = new ImageIcon("door.png");
        mentes.setIcon(mentesicon);
        betoltes.setIcon(betoltesicon);
        kilepes.setIcon(kilepesicon);

        // Hozzáadjuk a menüpontokat a menühöz
        menu1.add(mentes);
        menu1.add(betoltes);
        menu1.addSeparator(); // Elválasztóvonal hozzáadása
        menu1.add(kilepes);

        mentes.addActionListener(e -> {
            JFrame mentés = new JFrame("Mentés");
            mentés.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            mentés.setResizable(false);
            mentés.setSize(300, 200);
            mentés.setVisible(true);
            JButton button = new JButton("Ok");

            JPanel panel = new JPanel();
            panel.add(new JLabel("Milyen néven szeretné elmenteni:"));
            JTextField hely = new JTextField(10);
            panel.add(hely);
            panel.add(button);

            mentés.add(panel);
            button.addActionListener(e1 -> {
                String hely_m = hely.getText();
                try {
                    konyvtar.save(hely_m);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame, "Sikeres mentés");
                mentés.dispose();
            });

        });

        betoltes.addActionListener(e -> {
            JFileChooser fájl_választó = new JFileChooser();
            int válasz = fájl_választó.showOpenDialog(null);
            if(válasz == JFileChooser.APPROVE_OPTION){
                File fájl = new File(fájl_választó.getSelectedFile().getAbsolutePath());
                try {
                    konyvtar.load(fájl);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(frame, "Sikeres beolvasás");
            }
        });

        kilepes.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(frame, "Biztosan ki szeretne lépni?", "Kilépés", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        JMenu menu2 = new JMenu("Módosítás");

        JMenuItem torles = new JMenuItem("Törlés");
        ImageIcon torlesicon = new ImageIcon("x.png");
        torles.setIcon(torlesicon);
        torles.addActionListener(e -> {
            JFrame könyv_törlés = new JFrame("Törlés");
            könyv_törlés.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            könyv_törlés.setResizable(false);
            könyv_törlés.setSize(300, 200);
            könyv_törlés.setVisible(true);

            JButton button = new JButton("Ok");

            JPanel panel = new JPanel();
            panel.add(new JLabel("Törlendő elem címe:"));
            JTextField torlendo = new JTextField(10);
            panel.add(torlendo);

            panel.add(new JLabel("Törlendő elem típsa:"));
            String[] elemek = {"Könyv", "Film", "Hírlap"};
            JComboBox<String> comboBox = new JComboBox<>(elemek);
            panel.add(comboBox, BorderLayout.CENTER);
            panel.add(button);
            könyv_törlés.add(panel, BorderLayout.CENTER);

            final class AddButtonListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(Objects.equals(torlendo.getText(), "")){
                        JOptionPane.showMessageDialog(könyv_törlés, "Érvénytelen megadás");
                        return;
                    }
                    String torlendo_cim = torlendo.getText();
                    int ID;
                    if(comboBox.getSelectedItem().toString().equals("Könyv")){
                        ID = 0;
                    } else if (comboBox.getSelectedItem().toString().equals("Film")) {
                        ID = 1;
                    }else{
                        ID = 2;
                    }
                    konyvtar.torles(ID,torlendo_cim);
                    JOptionPane.showMessageDialog(frame, "Sikeres törlés");
                    könyv_törlés.dispose();
                }
            }

            button.addActionListener(new AddButtonListener());
        });
        menu2.add(torles);


        JMenu hozzadas = new JMenu("Hozzáadás");
        ImageIcon hozzaadasicon = new ImageIcon("plus.png");
        hozzadas.setIcon(hozzaadasicon);

        JMenuItem hozzaadas_1 = new JMenuItem("Könyv");
        hozzaadas_1.addActionListener(e ->{

            JFrame könyv_hozzáadás = new JFrame("Könyv hozzáadás");
            könyv_hozzáadás.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            könyv_hozzáadás.setResizable(false);
            könyv_hozzáadás.setSize(400, 350);
            könyv_hozzáadás.setLayout(new FlowLayout());
            könyv_hozzáadás.setVisible(true);

            JButton button = new JButton("Ok");

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout használata

            panel.add(new JLabel("Könyv címe:"));
            JTextField cím = new JTextField(10);
            panel.add(cím);


            panel.add(new JLabel("Könyv írója:"));
            JTextField iro = new JTextField(10);
            panel.add(iro);


            panel.add(new JLabel("Könyv kiadója:"));
            JTextField kiad = new JTextField(10);
            panel.add(kiad);



            panel.add(new JLabel("Könyv műfaja:"));
            JTextField mufaj = new JTextField(10);
            panel.add(mufaj);


            panel.add(new JLabel("Könyv besorolása:"));
            JTextField kategoria = new JTextField(10);
            panel.add(kategoria);


            panel.add(new JLabel("Könyv leírása:"));
            JTextField leiras = new JTextField(10);
            panel.add(leiras);


            panel.add(button);
            könyv_hozzáadás.add(panel);

            button.addActionListener( ea ->{
                String k_c = cím.getText();
                String k_i = iro.getText();
                String k_ki = kiad.getText();
                String k_m = mufaj.getText();
                String k_k = kategoria.getText();
                String k_l = leiras.getText();
                konyvtar.add_B(k_c,k_i, k_m, k_k,  k_l,  k_ki);
                könyv_hozzáadás.dispose();
            });

        });

        JMenuItem hozzaadas_2 = new JMenuItem("Film");
        hozzaadas_2.addActionListener(e ->{
            JFrame film_hozzáadás = new JFrame("Film hozzáadás");
            film_hozzáadás.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            film_hozzáadás.setResizable(false);
            film_hozzáadás.setSize(400, 250);
            film_hozzáadás.setLayout(new FlowLayout());
            film_hozzáadás.setVisible(true);

            JButton button = new JButton("Ok");

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout használata

            panel.add(new JLabel("Film címe:"));
            JTextField cím = new JTextField(10);
            panel.add(cím);


            panel.add(new JLabel("Film rendezője:"));
            JTextField iro = new JTextField(10);
            panel.add(iro);


            panel.add(new JLabel("Milyen hordozón tárolják a filmet:"));
            Hordozo[] elemek = {Hordozo.HDD, Hordozo.SSD, Hordozo.LEMEZ};
            JComboBox<Hordozo> comboBox = new JComboBox<>(elemek);
            panel.add(comboBox, BorderLayout.CENTER);
            panel.add(comboBox);


            panel.add(new JLabel("Film leírása:"));
            JTextField mufaj = new JTextField(10);
            panel.add(mufaj);


            panel.add(button);
            film_hozzáadás.add(panel);

            button.addActionListener( ea ->{
                String f_c = cím.getText();
                String f_r = iro.getText();
                String f_l = mufaj.getText();
                Hordozo h = (Hordozo) comboBox.getSelectedItem();
                konyvtar.add_F(f_c,f_r, f_l, h);
                film_hozzáadás.dispose();
            });
        });

        JMenuItem hozzaadas_3 = new JMenuItem("Hírlap");
        hozzaadas_3.addActionListener(e ->{
           JFrame hírlap_hozzáadás = new JFrame("Hírlap hozzáadás");
            hírlap_hozzáadás.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            hírlap_hozzáadás.setResizable(false);
            hírlap_hozzáadás.setSize(400, 300);
            hírlap_hozzáadás.setLayout(new FlowLayout());
            hírlap_hozzáadás.setVisible(true);

            JButton button = new JButton("Ok");

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // BoxLayout használata

            panel.add(new JLabel("Hírlap főcíme:"));
            JTextField cím = new JTextField(10);
            panel.add(cím);


            panel.add(new JLabel("Hírlap főszerkesztője:"));
            JTextField iro = new JTextField(10);
            panel.add(iro);


            panel.add(new JLabel("Milyen nyelvű az adott hírlap:"));
            Nyelv[] elemek = {Nyelv.ANGOL, Nyelv.NÉMET, Nyelv.MAGYAR, Nyelv.ROMÁN};
            JComboBox<Nyelv> comboBox = new JComboBox<>(elemek);
            panel.add(comboBox, BorderLayout.CENTER);
            panel.add(comboBox);

            panel.add(new JLabel("Milyen típusú az adott hírlap:"));
            Tipus[] elemek2 = {Tipus.HETI, Tipus.HAVI, Tipus.NAPI};
            JComboBox<Tipus> comboBox2 = new JComboBox<>(elemek2);
            panel.add(comboBox2, BorderLayout.CENTER);
            panel.add(comboBox2);


            panel.add(new JLabel("Hírlap leírása:"));
            JTextField mufaj = new JTextField(10);
            panel.add(mufaj);


            panel.add(button);
            hírlap_hozzáadás.add(panel);

            button.addActionListener( ea ->{
                String h_c = cím.getText();
                String h_sz = iro.getText();
                String h_l = mufaj.getText();
                Nyelv ny = (Nyelv) comboBox.getSelectedItem();
                Tipus t = (Tipus) comboBox2.getSelectedItem();
                konyvtar.add_H(h_sz, ny, t, h_c, h_l);
                hírlap_hozzáadás.dispose();
            });

        });

        hozzadas.add(hozzaadas_1);
        hozzadas.add(hozzaadas_2);
        hozzadas.add(hozzaadas_3);
        menu2.add(hozzadas);

        JMenu menu3 = new JMenu("Adatok");
        JMenuItem kereses = new JMenuItem("Keresés");
        ImageIcon keresesicon = new ImageIcon("nagyito.png");
        kereses.setIcon(keresesicon);
        kereses.addActionListener(e -> {
            JFrame keresés = new JFrame("Keresés");
            keresés.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            keresés.setResizable(false);
            keresés.setSize(300, 200);
            keresés.setVisible(true);

            JButton button = new JButton("Keress!");

            JPanel panel = new JPanel();
            panel.add(new JLabel("Keresendő elem címét:"));
            JTextField keresendo = new JTextField(10);
            panel.add(keresendo);

            panel.add(new JLabel("Keresendő elem típsa:"));
            String[] elemek = {"Könyv", "Film", "Hírlap"};
            JComboBox<String> comboBox = new JComboBox<>(elemek);
            panel.add(comboBox, BorderLayout.CENTER);
            panel.add(button);
            keresés.add(panel, BorderLayout.CENTER);

            final class AddButtonListener implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    if(Objects.equals(keresendo.getText(), "")){
                        JOptionPane.showMessageDialog(keresés, "Érvénytelen megadás");
                        return;
                    }
                    String keresendo_cim = keresendo.getText();
                    int ID;
                    if(comboBox.getSelectedItem().toString().equals("Könyv")){
                        ID = 0;
                    } else if (comboBox.getSelectedItem().toString().equals("Film")) {
                        ID = 1;
                    }else{
                        ID = 2;
                    }
                    //keresési ciklus
                    konyvtar.kereses(ID,keresendo_cim);


                }
            }

            button.addActionListener(new AddButtonListener());
        });


        JMenu kilist = new JMenu("Kilistázás");
        ImageIcon kilisticon = new ImageIcon("book.png");
        kilist.setIcon(kilisticon);

        JMenuItem kilist_1 = new JMenuItem("Könyv");
        kilist_1.addActionListener(e ->
            konyvtar.kilistazas(0)
        );

        JMenuItem kilist_2 = new JMenuItem("Film");
        kilist_2.addActionListener(e ->
            konyvtar.kilistazas(1)
        );

        JMenuItem kilist_3 = new JMenuItem("Hírlap");
        kilist_3.addActionListener(e ->
            konyvtar.kilistazas(2)
        );

        kilist.add(kilist_1);
        kilist.add(kilist_2);
        kilist.add(kilist_3);

        menu3.add(kereses);
        menu3.add(kilist);

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);


        // Menüsor beállítása az ablakhoz
        frame.add(menuBar, BorderLayout.NORTH);
    }



}
