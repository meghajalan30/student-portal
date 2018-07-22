import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class del implements ActionListener
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
del()
{
fr=new JFrame();
p=new JPanel();
p.setLayout(new GridLayout(1,2));
p.setBounds(100,100,400,40);
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
b1=new JButton("DELETE");
b1.setBounds(250,160,100,30);
b1.addActionListener(this);
b2=new JButton("BACK");
b2.setBounds(450,20,100,30);
b2.addActionListener(this);
fr.add(b1);
fr.add(b2);
p.add(reg);
p.add(cc);
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

pst=conn.prepareStatement("delete from info where regno=?");

pst.setString(1,String.valueOf(cc.getSelectedItem()));
pst.executeUpdate();
JOptionPane.showMessageDialog(null,"Record Deleted!!!");
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
new del();
}
}