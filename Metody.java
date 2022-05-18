import java.awt.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.text.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Metody implements ActionListener
{
    
    JFrame frame = new JFrame("Poznámkový blok");
    
    JTextArea area = new JTextArea();
    JScrollPane pane = new JScrollPane(area);
    public static String pismo = "Arial";
    public static String rez = "PLAIN";
    public static String velikost = "15";
    public void zobrazeni()
    {     
        frame.setLayout(new GridLayout(1,1));
        frame.setSize(1000,500);
        frame.setVisible(true);
        textovePole();
        menu();
    }
    
    public void textovePole()
    {
       
       frame.add(pane);
    }

    public void menu()
    {
        JMenuBar menu = new JMenuBar();
        JMenu soubor = new  JMenu("Soubor");
        JMenu upravy = new JMenu("Úpravy");
        JMenu zobrazeni = new JMenu("Zobrazení");
        JMenu format = new JMenu("Formát");
        menu.add(soubor);
        menu.add(upravy);
        menu.add(zobrazeni);
        menu.add(format);
        frame.setJMenuBar(menu);
        JMenuItem ulozit = new JMenuItem("Uložit");
        ulozit.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    //saveAs();
            }
        });
        ulozit.addActionListener(this);
        soubor.add(ulozit);
        JMenuItem font = new JMenuItem("Úprava písma");
        font.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev) {
                    uprava();
            }
        });
        format.add(font);
        format.addSeparator();
        JMenu barva = new JMenu("Barva písma");
        JMenu barva_p = new JMenu("Barva pozadí");
        format.add(barva);
        format.add(barva_p);
        
        JMenuItem red = new JMenuItem("červená");
        red.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    red();
            }
        });
        barva.add(red);
        JMenuItem blue = new JMenuItem("modrá");
        blue.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    blue();
            }
        });
        barva.add(blue);
        JMenuItem green = new JMenuItem("zelená");
        green.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    green();
            }
        });
        barva.add(green);
        
        
        JMenuItem red2 = new JMenuItem("červená");
        red2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    red_p();
            }
        });
        barva_p.add(red2);
        JMenuItem blue2 = new JMenuItem("modrá");
        blue2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    blue_p();
            }
        });
        barva_p.add(blue2);
        JMenuItem green2 = new JMenuItem("zelená");
        green2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    green_p();
            }
        });
        JMenuItem kopirovat = new JMenuItem("Kopírovat");
        JMenuItem vlozit = new JMenuItem("Vložit");
        JMenuItem vymazat = new JMenuItem("Vymazat");
        upravy.add(vymazat);
        upravy.add(kopirovat);
        upravy.add(vlozit);
        vymazat.addActionListener(this);
        kopirovat.addActionListener(this);
        vlozit.addActionListener(this);
        JMenuItem tmavy = new JMenuItem("Tmavý režim");
        JMenuItem svetly = new JMenuItem("Světlý režim");
        format.add(tmavy);
        format.add(svetly);
        tmavy.addActionListener(this);
        svetly.addActionListener(this);
        JMenuItem tisk = new JMenuItem("Tisknout");
        soubor.add(tisk);
        tisk.addActionListener(this);
        JMenuItem novy = new JMenuItem("Nový");
        JMenuItem zavrit = new JMenuItem("Zavřít");
        soubor.add(novy);
        soubor.add(zavrit);
        novy.addActionListener(this);
        zavrit.addActionListener(this);
        JMenuItem otevrit = new JMenuItem("Otevřít");
        soubor.add(otevrit);
        otevrit.addActionListener(this);
        
        barva_p.add(green2);
        JLabel l1 = new JLabel();
        menu.add(l1);
    }
    
    public void uprava(){
        JFrame f= new JFrame();  
        DefaultListModel<String> l1 = new DefaultListModel<>();  
          
          String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
          for ( int i = 0; i < fonts.length; i++ )
            {
              l1.addElement(fonts[i]);
            }
          JList list = new JList(l1);
          list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
          list.setVisibleRowCount(6);
          JScrollPane listScrollPane = new JScrollPane(list);
          listScrollPane.setBounds(10,50,170,250);
          JLabel label1 = new JLabel("Písmo");
          label1.setBounds(10,5,50,50);
          f.add(label1);
          f.add(listScrollPane);
          
        DefaultListModel<String> l2 = new DefaultListModel<>();
        l2.addElement("PLAIN");
        l2.addElement("BOLD");
        l2.addElement("ITALIC");
        
        JList list2 = new JList(l2);
        JScrollPane listScrollPane2 = new JScrollPane(list2);
          listScrollPane2.setBounds(190,50,170,250);
          JLabel label2 = new JLabel("Řez písma");
          label2.setBounds(190,5,100,50);
          f.add(label2);
          f.add(listScrollPane2);
        
        DefaultListModel<String> l3 = new DefaultListModel<>();
        for(int i = 1; i <= 100; i++){
            l3.addElement(String.valueOf(i));
        }
        JList list3 = new JList(l3);
        list3.setSelectedIndex(Integer.valueOf(velikost) - 1);
        JScrollPane listScrollPane3 = new JScrollPane(list3);
          listScrollPane3.setBounds(380,50,100,250);
          JLabel label3 = new JLabel("Velikost");
          label3.setBounds(380,5,50,50);
          f.add(label3);
          f.add(listScrollPane3);
          
        JButton ok = new JButton("Ok");
        JButton cancel = new JButton ("Cancel");
        ok.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    if(String.valueOf(list3.getSelectedValue()) == null){
                    }
                    else
                        velikost = String.valueOf(list3.getSelectedValue());
                    pismo = String.valueOf(list.getSelectedValue());
                    rez = String.valueOf(list2.getSelectedValue());
                    System.out.println(String.valueOf(list3.getSelectedValue()));
                    fonty(pismo, rez, velikost);
                    
                    f.dispose();
            }
        });
        cancel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
                    f.dispose();
            }
        });
        
        
          ok.setBounds(300,400,50,20);
          f.add(ok);
          cancel.setBounds(400,400,75,20);
          f.add(cancel);
          
          f.setSize(600,500);
          f.setLayout(null);  
          f.setVisible(true);
    }
    
    public void fonty(String pismo, String rez, String velikost){
        
        int velikost_int = Integer.valueOf(velikost);
        Font font;
        switch(rez){
         case "PLAIN":
            font = new Font(pismo, Font.PLAIN, velikost_int);
            area.setFont(font);
            break;
         case "ITALIC":
            font = new Font(pismo, Font.ITALIC, velikost_int);
            area.setFont(font);
            break;
         case "BOLD":
            font = new Font(pismo, Font.BOLD, velikost_int);
            area.setFont(font);
            break;
        }
        
        
        
    }
    
    public void red(){
        area.setForeground(Color.red);
    }
    
    public void green(){
            area.setForeground(Color.green);
    }
    
    public void blue(){
            area.setForeground(Color.blue);
    }
    
    public void green_p(){
            area.setBackground(Color.green);
    }
    
    public void red_p(){
            area.setBackground(Color.red);
    }
    
    public void blue_p(){
            area.setBackground(Color.blue);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
 
        if (s.equals("Vymazat")) {
            area.cut();
            
        }
        else if (s.equals("Kopírovat")) {
            area.copy();
        }
        else if (s.equals("Vložit")) {
            area.paste();
        }
        else if (s.equals("Tmavý režim")){
            area.setBackground(Color.black);
            area.setForeground(Color.white);
        }
        
        else if(s.equals("Světlý režim")){
            area.setBackground(Color.white);
            area.setForeground(Color.black);
        }
        else if (s.equals("Uložit")) {
            JFileChooser j = new JFileChooser("f:");
            j.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
            j.setAcceptAllFileFilterUsed(false);

            int r = j.showSaveDialog(null);
            
            if (r == JFileChooser.APPROVE_OPTION) {
                File fi = new File(j.getSelectedFile().getAbsolutePath()+".txt");
 
                try {
                    FileWriter wr = new FileWriter(fi, false);
 
                    BufferedWriter w = new BufferedWriter(wr);
 
                    w.write(area.getText());
 
                    w.flush();
                    w.close();
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }
            
            else
                JOptionPane.showMessageDialog(frame, "uživatel přerušil akci");
        }
        
        
        else if (s.equals("Tisknout")) {
            try {
                area.print();
            }
            catch (Exception evt) {
                JOptionPane.showMessageDialog(frame, evt.getMessage());
            }
        }
        
        
        else if (s.equals("Otevřít")) {
            JFileChooser j = new JFileChooser("f:");
 
            int r = j.showOpenDialog(null);
 
            
            if (r == JFileChooser.APPROVE_OPTION) {
                File fi = new File(j.getSelectedFile().getAbsolutePath());
 
                try {
                    String s1 = "", sl = "";
 
                    FileReader fr = new FileReader(fi);
 
                    BufferedReader br = new BufferedReader(fr);
 
                    sl = br.readLine();
 
                    while ((s1 = br.readLine()) != null) {
                        sl = sl + "\n" + s1;
                    }
 
                    area.setText(sl);
                }
                catch (Exception evt) {
                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                }
            }
            
            else
                JOptionPane.showMessageDialog(frame, "uživatel přerušil akci");
        }
        
        
        
        else if (s.equals("Nový")) {
            area.setText("");
        }
        
        
        else if (s.equals("Zavřít")) {
            frame.setVisible(false);
        }
    }
}

