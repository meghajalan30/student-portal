import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.sql.*;
//import java.util.*;
class login implements ActionListener
{
JLabel  l1,l2,l3,l4,lamt,lcourse,lreg;
JMenuBar jmb;
JMenu m1;
JMenuItem i1,i2,i3;
int total,sum=0,pay1;
Connection conn;
PreparedStatement pst,pst1;
ResultSet rs;
JPanel p,p1;
JTextField t2,tamt;
JButton b1,b2,bsave,breset,b;
JTextArea ta;
JFrame fr;
JLabel l,luser,lpass,lname;
Timer t1;
int count=1,i=0,j=0;
login()
{
fr=new JFrame();
p=new JPanel();
l1=new JLabel();
l2=new JLabel();
l3=new JLabel();
p.setBounds(200,480,300,160);
p.setLayout(new GridLayout(5,2));
p.setBorder(BorderFactory.createTitledBorder(""));
l4=new JLabel("NAME");
l1.setText(t.str2);
lreg=new JLabel("REGNO");
l2.setText(t.str3);
lamt=new JLabel("AMOUNT");
tamt=new JTextField();
lcourse=new JLabel("COURSE");
l3.setText(t.str4);
bsave=new JButton("SAVE");
bsave.addActionListener(this);
breset=new JButton("RESET");

p.add(l4);
p.add(l1);
p.add(lreg);
p.add(l2);
p.add(lamt);
p.add(tamt);
p.add(lcourse);
p.add(l3);
p.add(bsave);
p.add(breset);

fr.add(p);
p.setVisible(false);
l=new JLabel();
l.setBounds(0,30,600,400);
fr.add(l);
t1=new Timer(1000,new ActionListener()
{
public void actionPerformed(ActionEvent h1)
{
if(count==5)
count=1;
l.setIcon(new ImageIcon("s"+count+".jpg"));
count++;
}
}
);
t1.start();
lpass=new JLabel();
lpass.setBounds(20,390,130,180);
lpass.setIcon(new ImageIcon(t.str1));
lname=new JLabel();
lname.setBounds(20,560,300,30);
lname.setText("welcome "+t.str2);
fr.add(lname);
fr.add(lpass);
b1=new JButton("BACK");
b1.setBounds(450,20,100,30);
b1.addActionListener(this);
fr.add(b1);
jmb=new JMenuBar();
jmb.setBounds(200,410,100,30);
m1=new JMenu("OPTIONS");
i1=new JMenuItem("CHECK THE FEE STATUS");
i1.addActionListener(this);
i2=new JMenuItem("PAY FEE ");
i2.addActionListener(this);
//i3=new JMenuItem("CHECK THE CERTIFICATION ");
m1.add(i1);
m1.add(i2);
//m1.add(i3);
jmb.add(m1);
fr.add(jmb);


fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==i1)
{
new p();
}
if(k.getSource()==i2)
{
p.setVisible(true);
}



if(k.getSource()==bsave)
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");

pst=conn.prepareStatement("insert into payment values(?,?,?,?,?)");
pst.setString(1,l1.getText());
pst.setString(2,l2.getText());
pst.setString(3,tamt.getText());
pst.setString(4,l3.getText());
pst.setString(5,String.valueOf(new java.util.Date()));
pst1=conn.prepareStatement("select fee from course where name=?");
pst1.setString(1,l3.getText());
ResultSet rs2=pst1.executeQuery();
if(rs2.next())
total=rs2.getInt(1);
pst1.close();

pst1=conn.prepareStatement("select * from payment where regno=?");
pst1.setString(1,l2.getText());
ResultSet rs3=pst1.executeQuery();
while(rs3.next())
sum=sum+rs3.getInt(3);
pst1.close();
//JOptionPane.showMessageDialog(null,"sum="+sum);
pay1=sum+Integer.parseInt(tamt.getText());
if(pay1<=total)
{
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"Amount Paid");
}
else
JOptionPane.showMessageDialog(null,"FEE Increase by upper limit");
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
fr.dispose();
new  t();
}
}
public static void main(String jhgd[])
{
new login();
}
}