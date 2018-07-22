import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class t implements ActionListener
{
static String str1,str2,str3,str4;
Connection conn;
PreparedStatement pst;
ResultSet rs;
JPanel p;
JTextField t2;
JPasswordField pass;
JButton b1,b2,b3;

JFrame fr;
JLabel l,luser,lpass,logo,lmsg;
Timer t1;
int count=1;
t()
{
fr=new JFrame();
p=new JPanel();
p.setLayout(new GridLayout(3,2));
p.setBounds(100,510,400,150);
luser=new JLabel("USERNAME");
lpass=new JLabel("PASSWORD");
t2=new JTextField();
pass=new JPasswordField();
b1=new JButton("LOGIN");
b2=new JButton("REGISTER");
b2.addActionListener(this);
b1.addActionListener(this);
p.add(luser);
p.add(t2);
p.add(lpass);
p.add(pass);
p.add(b1);
p.add(b2);

p.setBorder(BorderFactory.createTitledBorder(""));
fr.add(p);
logo=new JLabel();
logo.setBounds(20,10,130,130);
logo.setIcon(new ImageIcon("D:/institute.jpg"));
fr.add(logo); 

lmsg=new JLabel("<html><body><font color=black size=25>EIMT Institute</font></body></html>");
lmsg.setBounds(200,50,500,80);
fr.add(lmsg);

b3=new JButton("ADMIN");
b3.setBounds(450,20,100,30);
b3.addActionListener(this);
fr.add(b3);

l=new JLabel();
l.setBounds(0,150,600,350);
fr.add(l);
t1=new Timer(1000,new ActionListener()
{
public void actionPerformed(ActionEvent h1)
{
if(count==6)
count=1;
l.setIcon(new ImageIcon("s"+count+".jpg"));
count++;
}
}
);
t1.start();
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
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");

pst=conn.prepareStatement("select *  from info  where name=? and password=?");


pst.setString(1,t2.getText());
pst.setString(2,pass.getText());
rs=pst.executeQuery();
if(rs.next())
{
str1=rs.getString(8);
str2=rs.getString(1);
str3=rs.getString(2);
str4=rs.getString(5);
fr.dispose();
new login();

}
else
JOptionPane.showMessageDialog(null," INVALID USER");

conn.close();
pst.close();
System.out.println("Record Deleted!!!");
}
catch(Exception h)
{
System.out.println(h);
}

}
if(k.getSource()==b2)
{
fr.dispose();
new registration2();
}
if(k.getSource()==b3)
{
fr.dispose();
new  admin();
}
}
public static void main(String jhgd[])
{
new t();
}
}