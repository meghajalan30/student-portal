import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
class jtable implements ActionListener
{
Connection conn;
PreparedStatement pst;
int i=0,j=0;
JTextArea ta;
 JButton b;
 JFrame fr;
 JTable jt;
 JScrollPane s;

 Object r[][]=new Object[100][100];
 Object c[]={"NAME","REG","ADDRESS","COURSE"};
jtable()
{
 fr=new JFrame();
ta=new JTextArea();
ta.setBounds(0,0,400,500);
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
conn=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:XE","megha","mj");
pst=conn.prepareStatement("select * from info");
ResultSet rs=pst.executeQuery();
while(rs.next())
{
r[i][j++]=rs.getString(1);
r[i][j++]=rs.getString(2);
r[i][j++]=rs.getString(3);
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
s.setBounds(0,0,400,300);

fr.add(ta);
b=new JButton("Print");
b.setBounds(0,500,100,30);
fr.add(b);
b.addActionListener(this);
fr.setLayout(null);
fr.setBounds(0,0,600,700);
fr.setVisible(true);

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
}
public static void main( String[] args )
 {

new jtable();
	}
}
