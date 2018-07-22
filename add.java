
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class add implements ActionListener
{
Connection conn;
PreparedStatement pst;
ResultSet rs;

JPanel p;
JTextField t1,t2,t3;
JButton b1,b2;
JFrame fr;
JLabel cname,dur,fee;

add()
{
fr=new JFrame();
p=new JPanel();
p.setLayout(new GridLayout(3,2));
p.setBounds(100,200,400,100);
cname=new JLabel("COURSE NAME");
dur=new JLabel("DURATION");
fee=new JLabel("FEE");
t1=new JTextField();
t2=new JTextField();
t3=new JTextField();
b1=new JButton("ADD");
b1.setBounds(250,310,100,40);
b1.addActionListener(this);
fr.add(b1);
b2=new JButton("BACK");
b2.setBounds(450,30,100,30);
b2.addActionListener(this);
fr.add(b2);
p.add(cname);
p.add(t1);
p.add(dur);
p.add(t2);
p.add(fee);
p.add(t3);


p.setBorder(BorderFactory.createTitledBorder(""));
fr.add(p);
fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==b1)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("insert into course values(?,?,?)");
pst.setString(1,t1.getText());
pst.setString(2,t2.getText());
pst.setString(3,t3.getText());
pst.executeUpdate();
conn.close();
pst.close();
JOptionPane.showMessageDialog(null," DATA SAVED");
}
catch(Exception h)
{
System.out.println(h);
}
}

if(k.getSource()==b2)
{
fr.dispose();
new  options();
}
}


public static void main(String jhgd[])
{
new add();
}
}