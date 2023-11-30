package login;

import book.domes_booking;
import dbms.JavaConnectionStudy;
import international_book.international_booking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class LoginForm extends JFrame implements ActionListener
{
    JButton b;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;
    LoginForm()
    {
        userLabel = new JLabel();
        userLabel.setText("Username");
        textField1 = new JTextField(15);
        passLabel = new JLabel();
        passLabel.setText("Password");
        textField2 = new JPasswordField(15);
        b = new JButton("SUBMIT");
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);
        newPanel.add(passLabel);
        newPanel.add(textField2);
        b.setBounds(100,175,150,20);
        newPanel.add(b);
        add(newPanel, BorderLayout.CENTER);
        b.addActionListener(this);
        setTitle("FLIGHT BOOKING LOGIN");
    }
    public void actionPerformed(ActionEvent ae)
    {
        String userValue = textField1.getText();
        String passValue = textField2.getText();
        if (userValue.equals("sudeep") && passValue.equals("2004"))
        {
            NewPage page = null;
            try {
                page = new NewPage();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            page.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid username or password. Try again");
        }
    }
}
class LoginFormDemo
{
    public static void main(String [] arg)
    {
        try
        {
            LoginForm form = new LoginForm();
            form.setSize(300,100);
            form.setVisible(true);
        }
        catch(Exception e)
        {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
class NewPage extends JFrame implements ActionListener
{
    Button a;
    JRadioButton df,inf;
    ButtonGroup bg;
    NewPage() throws SQLException {
        JavaConnectionStudy ob1 = new JavaConnectionStudy();

        JFrame j=new JFrame();
        bg=new ButtonGroup();


        df=new JRadioButton("Domestic Flight");
        df.setBounds(25,50,150,20);
        bg.add(df);
        j.add(df);

        inf=new JRadioButton("International Flight");
        inf.setBounds(200,50,150,20);
        bg.add(inf);
        j.add(inf);

        a=new Button("Select");
        a.setBounds(100,75,80,20);
        a.addActionListener(this);
        j.add(a);

        j.setSize(500,200);
        j.setLayout(null);
        j.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if(df.isSelected()){
            try {
                domes_booking ob2 = new domes_booking();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if(inf.isSelected()){
            try {
                international_booking ob3=new international_booking();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
