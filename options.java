import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class options implements ActionListener
{
JPanel p;
JTextField t2;
JPasswordField pass;
JButton b1,b2;
JFrame fr;
JLabel l,luser,lpass;
JMenuBar jmb,jmb1;
JMenu m1,m2;
JMenuItem i1,i2,i3,i4,i5,i6,i7,i8;
Timer t1;
int c=1;
options()
{
fr=new JFrame();
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
b2=new JButton("BACK");
b2.setBounds(450,30,100,30);
b2.addActionListener(this);
fr.add(b2);

jmb=new JMenuBar();
jmb.setBounds(200,470,125,30);
m1=new JMenu("COURSE");
i1=new JMenuItem("ADD COURSE");
i1.addActionListener(this);
i2=new JMenuItem("DELETE COURSE ");
i2.addActionListener(this);
i3=new JMenuItem("UPDATE COURSE FEE ");
i3.addActionListener(this);
m1.add(i1);
m1.add(i2);
m1.add(i3);
jmb.add(m1);
fr.add(jmb);

m2=new JMenu("STUDENT");
i4=new JMenuItem("DISPLAY ALL STUDENT");
i4.addActionListener(this);
i5=new JMenuItem("SEARCH STUDENT BY REGISTRATION NO ");
i5.addActionListener(this);
i6=new JMenuItem("DELETE STUDENT ");
i6.addActionListener(this);
i7=new JMenuItem("DISPLAY STUDENT ONE BY ONE ");
i7.addActionListener(this);
//i8=new JMenuItem("CERTIFICATION ");
//i8.addActionListener(this);
//m2.add(i8);
m2.add(i4);
m2.add(i5);
m2.add(i6);
m2.add(i7);
jmb.add(m2);

fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==i1)
{
fr.dispose();
new  add();
}
if(k.getSource()==i2)
{
fr.dispose();
new  delete();
}
if(k.getSource()==i3)
{
fr.dispose();
new  update();
}
if(k.getSource()==i4)
{
new  jtable();
} 
if(k.getSource()==i5)
{
fr.dispose();
new  search1();
}
if(k.getSource()==i6)
{
fr.dispose();
new  del();
}
if(k.getSource()==i7)
{
fr.dispose();
new  dis();
} 
//if(k.getSource()==i8)
//{
//fr.dispose();
//new  cer();
//} 
if(k.getSource()==b2)
{
fr.dispose();
new  admin();
}
}

public static void main(String jhgd[])
{
new options();
}
}