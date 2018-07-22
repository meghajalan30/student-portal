import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class dis implements ActionListener
{
int count=2;
Connection conn;
PreparedStatement pst ;
ResultSet rs;

JPanel p;
JTextField t1,t2;
JButton b1,b2,b3;
JFrame fr;
JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;

dis()
{
fr=new JFrame();
l1=new JLabel();
l2=new JLabel();
l3=new  JLabel();
l4=new  JLabel();
l5=new  JLabel();
l6=new  JLabel();
l7=new  JLabel();
l8=new  JLabel();
l9=new  JLabel();
l10=new  JLabel();
l11=new  JLabel();
l6.setBounds(250,70,100,120);
l11.setBounds(200,200,300,30);
l1.setBounds(350,200,300,30);
l7.setBounds(200,230,300,30);
l2.setBounds(350,230,300,30);
l8.setBounds(200,260,300,30);
l3.setBounds(350,260,300,30);
l9.setBounds(200,290,300,30);
l4.setBounds(350,290,300,30);
l10.setBounds(200,320,300,30);
l5.setBounds(350,320,300,30);

b1=new JButton("PREVIOUS");
b1.setBounds(200,400,100,40);
b1.addActionListener(this);
fr.add(b1);
b2=new JButton("BACK");
b2.setBounds(450,30,100,30);
b2.addActionListener(this);
fr.add(b2);
b3=new JButton("NEXT");
b3.setBounds(320,400,100,40);
b3.addActionListener(this);
fr.add(b3);

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("select * from info where regno=? ");
pst.setString(1,"12MCRBS6200"+String.valueOf(count));
rs=pst.executeQuery();

if(rs.next())
{
l1.setText(rs.getString(1));
l2.setText(rs.getString(2));
l3.setText(rs.getString(5));
l4.setText(rs.getString(6));
l5.setText(rs.getString(7));
l6.setIcon(new ImageIcon(rs.getString(8)));
l11.setText("name");
l7.setText("registration no");
l8.setText("course");
l9.setText("gender");
l10.setText("date of birth");
}
else
{
JOptionPane.showMessageDialog(null,"invalid registration no");
}
conn.close();
pst.close();
}
catch(Exception h)
{
System.out.println(h);
}

fr.add(l1);
fr.add(l2);
fr.add(l3);
fr.add(l4);
fr.add(l5);
fr.add(l6);
fr.add(l7);
fr.add(l8);
fr.add(l9);
fr.add(l10);
fr.add(l11);

fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==b3)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("select * from info where regno=?");
pst.setString(1,"12MCRBS6200"+String.valueOf(count+1));
rs=pst.executeQuery();

if(rs.next())
{
l1.setText(rs.getString(1));
l2.setText(rs.getString(2));
l3.setText(rs.getString(5));
l4.setText(rs.getString(6));
l5.setText(rs.getString(7));
l6.setIcon(new ImageIcon(rs.getString(8)));
l11.setText("name");
l7.setText("registration no");
l8.setText("course");
l9.setText("gender");
l10.setText("date of birth");
}
else
{
JOptionPane.showMessageDialog(null,"finish");
}
count++;
conn.close();
pst.close();
}
catch(Exception h)
{
System.out.println(h);
}
}

if(k.getSource()==b1)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("select * from info where regno=?");
pst.setString(1,"12MCRBS6200"+String.valueOf(count-1));
rs=pst.executeQuery();
if(rs.next())
{
l1.setText(rs.getString(1));
l2.setText(rs.getString(2));
l3.setText(rs.getString(5));
l4.setText(rs.getString(6));
l5.setText(rs.getString(7));
l6.setIcon(new ImageIcon(rs.getString(8)));
l11.setText("name");
l7.setText("registration no");
l8.setText("course");
l9.setText("gender");
l10.setText("date of birth");
}
else
{
JOptionPane.showMessageDialog(null,"invalid registration no");
}
count--;
conn.close();
pst.close();
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
new dis();
}
}