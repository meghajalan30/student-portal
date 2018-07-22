import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class update implements ActionListener
{
Connection conn;
PreparedStatement pst;
ResultSet rs;
JPanel p;
JTextField t1,t2;
JButton b1,b2,b3;
JFrame fr;
JLabel cname,l1,l2,l3,l4,l5,l6,l7,l8;
JComboBox cc;
update()
{

fr=new JFrame();
t1=new JTextField();
t2=new JTextField();
p=new JPanel();
p.setLayout(new GridLayout(1,2));
p.setBounds(100,200,400,40);
cname=new JLabel("COURSE NAME");
cc=new JComboBox();
cc.addActionListener(this);
cc.addItem("SELECT");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");

pst=conn.prepareStatement("select * from course");
ResultSet rs=pst.executeQuery();
while(rs.next())
cc.addItem(rs.getString(1));
conn.close();
pst.close();
}
catch(Exception k)
{
JOptionPane.showMessageDialog(null,"failed="+k);

}
b2=new JButton("BACK");
b2.setBounds(450,30,100,30);
b2.addActionListener(this);
fr.add(b2);
b3=new JButton("UPDATE");
b3.setBounds(250,530,100,30);
b3.addActionListener(this);
fr.add(b3);
p.add(cname);
p.add(cc);
p.setBorder(BorderFactory.createTitledBorder(""));
fr.add(p);
l7=new JLabel();
l7.setBounds(200,330,150,20);
fr.add(l7);
l4=new JLabel( );
l4.setBounds(100,370,150,20);
fr.add(l4);
l1=new JLabel( );
l1.setBounds(270,370,150,20);
fr.add(l1);
l5=new JLabel();
l5.setBounds(100,400,150,20);
fr.add(l5);
l2=new JLabel( );
l2.setBounds(270,400,150,20);
fr.add(l2);
l6=new JLabel();
l6.setBounds(100,430,150,20);
fr.add(l6);
l3=new JLabel();
l3.setBounds(270,430,150,20);
fr.add(l3);
l8=new JLabel("new fee:");
l8.setBounds(100,480,150,20);
fr.add(l8);
t2=new JTextField();
t2.setBounds(270,480,150,20);
fr.add(t2);
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
pst=conn.prepareStatement("select * from course where name=?");
pst.setString(1,String.valueOf(cc.getSelectedItem()));
rs=pst.executeQuery();

if(rs.next())
{
l1.setText(rs.getString(1));
l2.setText(rs.getString(2));
l3.setText(rs.getString(3));
l4.setVisible(true);
l4.setText("course name:");
l5.setVisible(true);
l5.setText("duration:");
l6.setVisible(true);
l6.setText("fee:");
l7.setVisible(true);
l7.setText("COURSE DETAILS:");
}
else
{

l4.setVisible(false);
l5.setVisible(false);
l6.setVisible(false);
l7.setVisible(false);
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

if(k.getSource()==b3)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("update course set fee=? where name=?");
pst.setString(1,t2.getText());
pst.setString(2,String.valueOf(cc.getSelectedItem()));
pst.executeUpdate();
JOptionPane.showMessageDialog(null," RECORD UPDATED");
conn.close();
pst.close();

}
catch(Exception h)
{
JOptionPane.showMessageDialog(null,"failed="+h);
}
}



}


public static void main(String jhgd[])
{
new update();
}
}