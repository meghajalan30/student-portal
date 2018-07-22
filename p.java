import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class p implements ActionListener
{
int i=0,j=0,x=0,re;
Connection conn;
PreparedStatement pst;
ResultSet rs;
JPanel pa;
JTextField t2,t3;
JButton b1,b;
JComboBox cc;
JFrame fr;
JLabel l,l1,l2,l3,l4,l5,l6,l7;
JTextArea ta;
 JTable jt;
 JScrollPane s;
 Object r[][]=new Object[100][100];
 Object c[]={"NAME","REG NO.","PAYMENT AMT","COURSE","DATE"};
String str1,str2;
p()
{
fr=new JFrame();
pa=new JPanel();
pa.setBounds(15,180,360,100);
pa.setLayout(new GridLayout(3,2));
pa.setBorder(BorderFactory.createTitledBorder(""));
l1=new JLabel("Total Fee:");
l2=new JLabel("Amount paid:");
l3=new JLabel("Remaining Amount:");
l4=new JLabel();
l5=new JLabel();
l6=new JLabel();

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");
pst=conn.prepareStatement("select * from course where name=?");
pst.setString(1,t.str4);
rs=pst.executeQuery();
while(rs.next())
{
str1=rs.getString(3);
re=Integer.parseInt(str1);
l4.setText(str1);
}
conn.close();
pst.close();

}
catch(Exception h)
{
System.out.println(h);
}

try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:Xe","megha","mj");
pst=conn.prepareStatement("select * from payment where regno=?");
pst.setString(1,t.str3);
rs=pst.executeQuery();
while(rs.next())
{
x=x+rs.getInt(3);
}
l5.setText(String.valueOf(x));
conn.close();
pst.close();
}
catch(Exception h)
{
System.out.println(h);
}
l6.setText(" "+(re-x));

pa.add(l1);
pa.add(l4);
pa.add(l2);
pa.add(l5);
pa.add(l3);
pa.add(l6);

ta=new JTextArea();
ta.add(pa);
ta.setBounds(0,0,510,330);
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("select * from  payment where regno=?");
pst.setString(1,t.str3);
ResultSet rs=pst.executeQuery();
while(rs.next())
{
r[i][j++]=rs.getString(1);
r[i][j++]=rs.getString(2);
r[i][j++]=rs.getInt(3);
r[i][j++]=rs.getString(4);
r[i][j++]=rs.getString(5);
j=0;
i++;
}
conn.close();
pst.close();
}
catch(Exception k90)
{
JOptionPane.showMessageDialog(null,"failed="+k90);
}

 jt=new JTable(r,c);
s=new JScrollPane(jt);
ta.add(s);

s.setBounds(0,0,510,160);

fr.add(ta);
b=new JButton("Print");
b.setBounds(50,380,100,30);
fr.add(b);
b.addActionListener(this);


b1=new JButton("BACK");
b1.setBounds(200,380,100,30);
b1.addActionListener(this);
fr.add(b1);

fr.setLayout(null);
fr.setBounds(0,0,600,800);
fr.setVisible(true);
}
public void actionPerformed(ActionEvent k)
{
if(k.getSource()==b)
{
try
{
ta.print();
}
catch(Exception j)
{
}
}
if(k.getSource()==b1)
{
fr.dispose();
new  login();
}
}
public static void main(String jhgd[])
{
new p();
}
}