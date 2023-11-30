package international_book;

import dbms.JavaConnectionStudy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class international_booking implements ActionListener {
    JTextField name, age, date;
    JComboBox fromc, toc, classc, adult, infant, children;
    JButton Submit;
    JLabel lname, lage, ldate, lfromc, ltoc, lclassc, ladult, lchildren, linfant, ltitle;
    ResultSet rs;
    JTextArea jb = new JTextArea();
    JLabel fttitle=new JLabel("Flight ticket");
    JavaConnectionStudy ob2 = new JavaConnectionStudy();

    public international_booking() throws SQLException {

        JFrame j = new JFrame();

        ltitle = new JLabel("International Flight Booking");
        ltitle.setBounds(175, 25, 200, 20);
        j.add(ltitle);

        name = new JTextField();
        name.setBounds(65, 50, 150, 20);
        j.add(name);
        lname = new JLabel("Name:");
        lname.setBounds(25, 50, 150, 20);
        j.add(lname);

        age = new JTextField();
        age.setBounds(65, 75, 150, 20);
        j.add(age);
        lage = new JLabel("Age:");
        lage.setBounds(25, 75, 150, 20);
        j.add(lage);

        date = new JTextField();
        date.setBounds(65, 100, 150, 20);
        j.add(date);
        ldate = new JLabel("Date:");
        ldate.setBounds(25, 100, 150, 20);
        j.add(ldate);

        fromc = new JComboBox();
        fromc.setBounds(65, 125, 150, 20);
        j.add(fromc);
        rs = ob2.Select(4);
        lfromc = new JLabel("From:");
        lfromc.setBounds(25, 125, 150, 20);
        while (rs.next()) {
            String name = rs.getString(1);
            fromc.addItem(name);
        }
        j.add(lfromc);

        toc = new JComboBox();
        toc.setBounds(65, 150, 150, 20);
        j.add(toc);
        rs = ob2.Select(5);
        ltoc = new JLabel("To:");
        ltoc.setBounds(25, 150, 150, 20);
        while (rs.next()) {
            String name = rs.getString(1);
            toc.addItem(name);
        }
        j.add(ltoc);

        String[] sitem = {"Economy", "Business"};
        classc = new JComboBox(sitem);
        classc.setBounds(340, 50, 150, 20);
        j.add(classc);
        lclassc = new JLabel("Class:");
        lclassc.setBounds(250, 50, 150, 20);
        j.add(lclassc);

        String[] adul = {"0", "1", "2", "3", "4", "5", "6", "7"};
        adult = new JComboBox(adul);
        adult.setBounds(340, 75, 50, 20);
        j.add(adult);
        ladult = new JLabel("No of Adults:");
        ladult.setBounds(250, 75, 150, 20);
        j.add(ladult);

        String[] chil = {"0", "1", "2", "3",};
        children = new JComboBox(chil);
        children.setBounds(340, 100, 50, 20);
        j.add(children);
        lchildren = new JLabel("No of Children:");
        lchildren.setBounds(250, 100, 150, 20);
        j.add(lchildren);

        String[] inf = {"0", "1", "2"};
        infant = new JComboBox(inf);
        infant.setBounds(340, 125, 50, 20);
        j.add(infant);
        linfant = new JLabel("No of Infants:");
        linfant.setBounds(250, 125, 150, 20);
        j.add(linfant);

        Submit = new JButton("Book");
        Submit.setBounds(210, 175, 100, 20);
        Submit.addActionListener(this);
        j.add(Submit);

        j.setBackground(Color.white);
        j.setSize(600, 250);
        j.setLayout(null);
        j.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String a1 = name.getText();
        int a2 = Integer.parseInt(age.getText());
        String a3 = date.getText();
        String a4 = fromc.getItemAt(fromc.getSelectedIndex()).toString();
        String a5 = toc.getItemAt(toc.getSelectedIndex()).toString();
        String a6 = classc.getItemAt(classc.getSelectedIndex()).toString();
        int a7 = Integer.parseInt(adult.getItemAt(adult.getSelectedIndex()).toString());
        int a9 = Integer.parseInt(infant.getItemAt(infant.getSelectedIndex()).toString());
        int a8 = Integer.parseInt(children.getItemAt(children.getSelectedIndex()).toString());

        try {
            ob2.insertData("insert into airline.booking(name,age,category,fromc,toc,booking_date,class,adult,children,infant)" + "values('" + a1 + "','" + a2 + "','International','" + a4 + "','" + a5 + "','" + a3 + "','" + a6 + "','" + a7 + "','" + a8 + "','" + a9 + "')");
            JOptionPane.showMessageDialog(null, "Booked");

            JFrame j1=new JFrame();
            rs=ob2.Select(6);
            String data1
                    = "Name: "
                    + a1+ "\n"
                    + "Age: "
                    + a2+ "\n"
                    +"Date: "
                    +a3+ "\n";
            String data2
                    = "Category: "
                    + "International"+ "\n"
                    +"From: "
                    + a4+ "\n"
                    +"To: "
                    + a5+ "\n";
            String data3
                    ="Class: "
                    +a6+ "\n"
                    +"Adults: "
                    + a7+ "\n"
                    +"Children: "
                    + a8+ "\n"
                    +"Infants: "
                    + a9+ "\n";

            jb.setText(data1 + data2 + data3);
            j1.add(fttitle);
            fttitle.setBounds(75,0,150,20);
            jb.setBounds(0,20,250,300);
            jb.setLineWrap(true);
            jb.setVisible(true);
            jb.setEditable(false);
            j1.add(jb);

            j1.setBackground(Color.white);
            j1.setSize(250, 300);
            j1.setLayout(null);
            j1.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
