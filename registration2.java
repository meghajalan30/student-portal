import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
class registration2 extends JFrame implements ActionListener
{
int count=0;
Connection conn;
PreparedStatement pst;
String str="",g="";
String m[]={"jan","feb","mar","apr","may","june","july","aug","sep","oct","nov","dec"};
JFrame fr;
JLabel treg, l1, lpass, lname,lreg,lgen,lcourse,laddress,llanguage,lpassword,ldob;
JTextField tname;
JComboBox cc,dd,mm,yy;
JPasswordField p;
JRadioButton g1,g2;
JCheckBox c1,c2,c3;
JButton b1,b2,b3,b4;
JTextArea ta;
JPanel p1;
ButtonGroup bg1;
registration2()
{
fr=new JFrame();
p1=new JPanel();
p1.setLayout(new GridLayout(5,2));
l1=new JLabel("<html><body><font color=red size=10>Registration Form</font></body></html>");
l1.setBounds(80,0,400,100);
fr.add(l1);
lname=new JLabel("NAME");
tname=new JTextField();
lreg=new JLabel("REGISTRATION");
treg=new JLabel();
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");
pst=conn.prepareStatement("select * from info");
ResultSet rs=pst.executeQuery();
while(rs.next())
count++;
treg.setText("12MCRBS6200"+String.valueOf(count+1));
conn.close();
pst.close();
}
catch(Exception k1)
{
}
laddress=new JLabel("ADDRESS");
ta=new JTextArea();
lpassword=new JLabel("PASSWORD");
p=new JPasswordField();
lcourse=new JLabel("COURSE");
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
p1.add(lname);
p1.add(tname);
p1.add(lreg);
p1.add(treg);
p1.add(laddress);
p1.add(ta);
p1.add(lpassword);
p1.add(p);
p1.add(lcourse);
p1.add(cc);
p1.setBounds(0,100,400,300);
//p1.setBorder(BorderFactory.createTitledBorder(""));

ldob=new JLabel("DATE OF BIRTH");
ldob.setBounds(0,370,120,180);
fr.add(ldob);
dd=new JComboBox();
dd.setBounds(210,450,40,20);
dd.addItem("dd");
for(int i=01;i<=31;i++)
dd.addItem(i);
fr.add(dd);
mm=new JComboBox();
mm.setBounds(270,450,50,20);
mm.addItem("mm");
for(int i=0;i<12;i++)
mm.addItem(m[i]);
fr.add(mm);
yy=new JComboBox();
yy.setBounds(340,450,60,20);
yy.addItem("yyyy");
for(int i=1995;i<=2008;i++)
yy.addItem(i);
fr.add(yy);

b1=new JButton("CLEAR");
b1.setBounds(20,520,150,40);
fr.add(b1);
b1.addActionListener(this);
b2=new JButton("SUBMIT");
b2.setBounds(200,520,150,40);
b2.addActionListener(this);
fr.add(b2);

lpass=new JLabel();
lpass.setBounds(410,110,120,180);
lpass.setBorder(BorderFactory.createTitledBorder(""));
fr.add(lpass);
b3=new JButton("UPLOAD");
b3.setBounds(410,300,120,30);
b3.addActionListener(this);
fr.add(b3);
fr.add(p1);

b4=new JButton("BACK");
b4.setBounds(450,40,80,30);
b4.addActionListener(this);
fr.add(b4);

lgen=new JLabel("GENDER");
g1=new JRadioButton("M");
g2=new JRadioButton("F");
lgen.setBounds(0,360,150,129);
fr.add(lgen);
g1.setBounds(240,400,70,50);
g2.setBounds(320,400,70,50);
bg1=new ButtonGroup();
bg1.add(g1);
bg1.add(g2);
fr.add(g1);
fr.add(g2);

fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}

public void actionPerformed(ActionEvent k)
{
if(k.getSource()==cc)
{
//JOptionPane.showMessageDialog(null,"ok");
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");
pst=conn.prepareStatement("select * from course where name=?");
pst.setString(1,String.valueOf(cc.getSelectedItem()));
ResultSet rs=pst.executeQuery();
if(rs.next())
{

JOptionPane.showMessageDialog(null,"FEE="+rs.getString(3));
}
conn.close();
pst.close();
}
catch(Exception k1)
{
JOptionPane.showMessageDialog(null,"failed="+k1);

}

}
if(k.getSource()==b1)
{
tname.setText("");
treg.setText("");
ta.setText("");
p.setText("");
}

if(k.getSource()==b2)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");

pst=conn.prepareStatement("insert into info values(?,?,?,?,?,?,?,?)");
pst.setString(1,tname.getText());
pst.setString(2,treg.getText());
pst.setString(3,ta.getText());
pst.setString(4,p.getText());
pst.setString(5,String.valueOf(cc.getSelectedItem()));
if(g1.isSelected())
g="m";
if(g2.isSelected())
g="f";
pst.setString(6,g);
pst.setString(7,String.valueOf(dd.getSelectedItem())+"/"+String.valueOf(mm.getSelectedItem())+"/"+String.valueOf(yy.getSelectedItem()));
pst.setString(8,str);
pst.executeUpdate();
conn.close();
pst.close();
JOptionPane.showMessageDialog(null,"Data saved");
}
catch(Exception h)
{
JOptionPane.showMessageDialog(null,"failed"+h);
}
}

if(k.getSource()==b3)
{
JFileChooser ob=new JFileChooser();
ob.showOpenDialog(this);
File f=ob.getSelectedFile();
str=f.getPath();
lpass.setIcon(new ImageIcon(str));
}
if(k.getSource()==b4)
{
fr.dispose();
new  t();
}
}
public static void main(String jg[])
{
new registration2();
}
}

