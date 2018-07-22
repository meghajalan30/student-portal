import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class search1 implements ActionListener
{
Connection conn;
PreparedStatement pst;
ResultSet rs;
JPanel p,p1;
JTextField t1,t2;
JButton b1,b2,b3;
JFrame fr;
JLabel reg,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
JComboBox cc;
search1()
{
fr=new JFrame();
p=new JPanel();
p.setLayout(new GridLayout(1,2));
p.setBounds(100,100,400,40);
p1=new JPanel();
p1.setLayout(new GridLayout(5,2));
p1.setBounds(80,350,300,200);
reg=new JLabel("REGISTRATION NO:");
cc=new JComboBox();
cc.addActionListener(this);
cc.addItem("SELECT");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");

pst=conn.prepareStatement("select * from info");
ResultSet rs=pst.executeQuery();
while(rs.next())
cc.addItem(rs.getString(2));
conn.close();
pst.close();
}
catch(Exception k)
{
JOptionPane.showMessageDialog(null,"failed="+k);

}
l1=new JLabel();
l2=new JLabel();
l3=new JLabel();
l4=new JLabel();
l5=new JLabel();
l6=new JLabel();
l7=new JLabel();
l8=new JLabel();
l9=new JLabel();
l10=new JLabel();
l11=new JLabel();
l11.setBounds(250,200,80,120);
fr.add(l11);
b2=new JButton("BACK");
b2.setBounds(450,20,100,30);
b2.addActionListener(this);
fr.add(b2);
p.add(reg);
p.add(cc);
p.setBorder(BorderFactory.createTitledBorder(""));
p1.add(l6);
p1.add(l1);
p1.add(l7);
p1.add(l2);
p1.add(l8);
p1.add(l3);
p1.add(l9);
p1.add(l4);
p1.add(l10);
p1.add(l5);

fr.add(p1);
fr.add(p);
fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{

if(k.getSource()==cc)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("select * from info where regno=?");
pst.setString(1,String.valueOf(cc.getSelectedItem()));
rs=pst.executeQuery();

if(rs.next())
{
l1.setText(rs.getString(1));
l2.setText(rs.getString(3));
l3.setText(rs.getString(5));
l4.setText(rs.getString(6));
l5.setText(rs.getString(7));
l11.setIcon(new ImageIcon(rs.getString(8)));
l6.setVisible(true);
l6.setText("name");
l7.setVisible(true);
l7.setText("address");
l8.setVisible(true);
l8.setText("course");
l9.setVisible(true);
l9.setText("gender");
l10.setVisible(true);
l10.setText("date of birth");
}
else
{
l6.setVisible(false);
l7.setVisible(false);
l8.setVisible(false);
l9.setVisible(false);
l10.setVisible(false);
}
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
new search1();
}
}