import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class delete implements ActionListener
{
Connection conn;
PreparedStatement pst;
ResultSet rs;

JPanel p;
JTextField t1;
JButton b1,b2;
JFrame fr;
JLabel cname;
JComboBox cc;
delete()
{
fr=new JFrame();
p=new JPanel();
p.setLayout(new GridLayout(1,2));
p.setBounds(100,200,400,50);
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
b1=new JButton("DELETE");
b1.setBounds(250,270,100,30);
b1.addActionListener(this);
fr.add(b1);
p.add(cname);
p.add(cc);
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
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("delete from course where name=?");
pst.setString(1,String.valueOf(cc.getSelectedItem()));
pst.executeUpdate();
JOptionPane.showMessageDialog(null," RECORD DELETED");
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
new delete();
}
}