import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class admin implements ActionListener
{
Connection conn;
PreparedStatement pst;
ResultSet rs;
static String str1,str2;
JPanel p;
JTextField t2;
JPasswordField pass;
JButton b1,b2;
JFrame fr;
JLabel l,luser,lpass;
Timer t1;
int c=1;
admin()
{
fr=new JFrame();
p=new JPanel();
p.setLayout(new GridLayout(2,2));
p.setBounds(100,450,400,100);
l=new JLabel();
l.setBounds(0,60,600,400);
fr.add(l);
t1=new Timer(1000,new ActionListener()
{
public void actionPerformed(ActionEvent h1)
{
if(c==5)
c=1;
l.setIcon(new ImageIcon("s"+c+".jpg"));
c++;
}
}
);
t1.start();
luser=new JLabel("USERNAME");
lpass=new JLabel("PASSWORD");
t2=new JTextField();
pass=new JPasswordField();
b1=new JButton("LOGIN");
b1.setBounds(250,560,100,40);
b1.addActionListener(this);
fr.add(b1);
b2=new JButton("BACK");
b2.setBounds(450,30,100,30);
b2.addActionListener(this);
fr.add(b2);
p.add(luser);
p.add(t2);
p.add(lpass);
p.add(pass);


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
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");
pst=conn.prepareStatement("select *  from admin  where name=? and pass=?");
pst.setString(1,t2.getText());
pst.setString(2,pass.getText());
rs=pst.executeQuery();
if(rs.next())
{
fr.dispose();
new options();
}
else
JOptionPane.showMessageDialog(null," INVALID ADMIN");

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
new  t();
}
}


public static void main(String jhgd[])
{
new admin();
}
}