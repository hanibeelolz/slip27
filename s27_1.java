 import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


class Slip13_2 extends JFrame implements ActionListener
{     	 
 JButton b2;
 String sql;
 JPanel p,p1;
 Connection con;
       	 
 JTable t;
Statement stmt ;
ResultSet rs ;
ResultSetMetaData rsmd ;
int columns;
Vector columnNames = new Vector();
Vector data = new Vector();

Slip13_2()
{
	b2 = new JButton("Display College Details");
  b2.addActionListener(this);
  p=new JPanel();
  p1=new JPanel();
  p.add(b2);
  add(p);
  setLayout(new GridLayout(2,1));
  setSize(600,800);
  setVisible(true);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

public void actionPerformed(ActionEvent e)
{
  if((JButton)b2==e.getSource())
{
  try
   {
     Class.forName("org.postgresql.Driver");
     con=DriverManager.getConnection("jdbc:postgresql://localhost/tydb","postgres","");  
     System.out.println("Connected");
     stmt=con.createStatement();
     rs = stmt.executeQuery("select * from college");
     rsmd = rs.getMetaData();
     columns = rsmd.getColumnCount();
     for(int i = 1; i <= columns; i++)
     {
           columnNames.addElement(rsmd.getColumnName(i));
     }
while(rs.next())
	{
   Vector row = new Vector(columns);
   for(int i = 1; i <= columns; i++)
   {
      row.addElement(rs.getObject(i));
    }
    data.addElement(row);
  	}
t = new JTable(data, columnNames);
js = new JScrollPane(t);
p1.add(js);
add(p1);
setSize(600, 600);
setVisible(true);
   }
  catch(Exception e1)
{
 System.out.println(e1);
	}
   }
}
public static void main(String a[]) throws Exception
{
Slip13_2 ob = new Slip13_2();
}
}
