import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.PrintJob.*;
class myfr extends JFrame implements ActionListener,KeyListener
{
  JTextArea t1;
  static Font f;
  JCheckBoxMenuItem item12;
  //int flag=0;
    String str=getTitle();
 myfr(String title)
{
 super(title);
 t1=new JTextArea();
 getContentPane().setLayout(new BorderLayout());
JScrollPane js1 = new JScrollPane();
        js1.setViewportView(t1);

        getContentPane().add(js1, java.awt.BorderLayout.CENTER);
 JMenuBar mbr=new JMenuBar();
 setJMenuBar(mbr);
 JMenu file=new JMenu("File");
 file.setForeground(new java.awt.Color(102, 102, 255));
 JMenuItem item3=new JMenuItem("New");
 file.add(item3);
 JMenuItem item1=new JMenuItem("Open");
 JMenuItem item2=new JMenuItem("Save");
 JMenuItem item13=new JMenuItem("Exit");
 file.add(item1);
 file.add(item2);
 file.add(item13);
 JMenu edit=new JMenu("Edit");
 edit.setForeground(new java.awt.Color(102, 102, 255));
 JMenuItem item4=new JMenuItem("Cut");
 edit.add(item4);
 JMenuItem item5=new JMenuItem("Paste");
 JMenuItem item6=new JMenuItem("Copy");
 JMenuItem item7=new JMenuItem("Select All");
 JMenuItem item8=new JMenuItem("Print");
 edit.add(item5);
 edit.add(item6);
 edit.add(item7);
 edit.add(item8);
 JMenu format=new JMenu("Format");
 format.setForeground(new java.awt.Color(102, 102, 255));
 item12=new JCheckBoxMenuItem("LineWrap");
 format.add(item12);
 JMenu settings=new JMenu("Settings");
 settings.setForeground(new java.awt.Color(102, 102, 255));
 JMenuItem item9=new JMenuItem("Font");
 settings.add(item9);
 mbr.add(file);
 mbr.add(edit);
 mbr.add(settings);
 mbr.add(format);
 item1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,java.awt.event.InputEvent.CTRL_MASK));
 item2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,java.awt.event.InputEvent.CTRL_MASK));
 item3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,java.awt.event.InputEvent.CTRL_MASK));
 item4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
 item5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V,java.awt.event.InputEvent.CTRL_MASK));
 item6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,java.awt.event.InputEvent.CTRL_MASK));
 item7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A,java.awt.event.InputEvent.CTRL_MASK));
 item8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,java.awt.event.InputEvent.CTRL_MASK));
 item9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F,java.awt.event.InputEvent.CTRL_MASK));
 file.setMnemonic('F');
 edit.setMnemonic('E');
 settings.setMnemonic('S');
 format.setMnemonic('O');
 item1.addActionListener(this);
 item2.addActionListener(this);
 item3.addActionListener(this);
 item4.addActionListener(this);
 item5.addActionListener(this);
 item6.addActionListener(this);
 item7.addActionListener(this);
 item8.addActionListener(this);
 item9.addActionListener(this);
 item12.addActionListener(this);
 item13.addActionListener(this);
 addKeyListener(this);
 addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
      
 JOptionPane.showMessageDialog(null,"You are Exiting");
 System.exit(0); 
   /*    int i;
String s1 = "Do you Want to Exit";

       i= JOptionPane.showConfirmDialog(null,s1,"Exit Message", JOptionPane.YES_NO_OPTION);
if(i!=1)
  {
  
  }

MessagePane.setMessagePaneProvider("Want to Save");
MessagePane pane = MessagePane.getDocumentInstance(myfr);
Result result = pane.show(myMessage);
if (result.userChose(Option.SAVE))
{
   // save our document...
}
else if (result.userChose(Option.CANCEL))
{
   // cancel...
}
*/


}
});

 }

public void keyPressed(KeyEvent ke)
{
 
}
public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{   



}
  public void actionPerformed(ActionEvent ae)
 {
   String args=ae.getActionCommand(); 
     

  if(args.equals("Font"))
   {
     font f2=new font("Font",t1);
     f2.setSize(600,70);
     f2.setVisible(true);
     f2.setLocation(300,100);
   } 


if(args.equals("Cut"))
{
 t1.cut();
}
if(args.equals("Paste"))
{
 t1.paste();
}
if(args.equals("Copy"))
{
 t1.copy();
}

 if(args.equals("New"))
   {
      this.setTitle("Notepad");
      t1.setText("");
      t1.setFont(f);
    } 
   if(args.equals("Open"))
   { 
    
    Frame f1=new Frame();    
    FileDialog fd=new FileDialog(f1,"Open Your File");
    fd.setSize(200,200);
    fd.setVisible(true);
    System.out.println(fd.getDirectory());
    System.out.println(fd.getFile());
    try
    {
       t1.setText("");
      FileReader fr=new FileReader(fd.getDirectory()+fd.getFile());
      int i; 
     String s1="";
     while((i=fr.read())!=-1)
     {
      s1+=((char)i);
      
     }
     t1.append(s1);
 
     fr.close();
  }

catch(Exception e)
{
}
}
if(args.equals("Save"))
   { 
      
    //  String str1,str2;
     
//    if(str.equals("Notepad"))// && flag==0)
 //  {
     
    Frame f1=new Frame();
    FileDialog fd=new FileDialog(f1,"Save Your File",FileDialog.SAVE);
    fd.setSize(400,200);
    fd.setVisible(true);
 //   str1=fd.getDirectory();
  //  str2=fd.getFile();
  //System.out.println(fd.getDirectory());
  //System.out.println(fd.getFile());
    this.setTitle(fd.getFile()+"-Notepad");
   // flag=1;
    try 
  {
   FileWriter fw=new FileWriter(fd.getDirectory()+fd.getFile());
   fw.write(t1.getText());
   fw.close();
  }
catch(Exception e)
{
}
 }
 //if(flag==1)
//{
 //  Frame f1=new Frame();
 //try{ 
 // FileWriter fw=new FileWriter(str1+str2);
   //fw.write(t1.getText());
  // fw.close();
//}
//catch(Exception e)
//{}
//}
//}

if(args.equals("Select All"))
{
 t1.selectAll();
}
if(args.equals("Print"))
{
ss s1 = new ss();
 s1.printRecord(t1.getText());

}

 if(item12.isSelected())
{
 t1.setLineWrap(true);
}
else
{
 t1.setLineWrap(false);
}
if(args.equals("Exit"))
{
 System.exit(0);
}

}

}
class Mynotepad 
{ 
 public static void main(String s[])
{
 myfr f=new myfr("Notepad");
 f.setSize(400,400);
 f.setVisible(true);
 f.setLocation(0,0);
}
}   
 class font extends Frame implements ActionListener 
{
 
 Choice c1,c2,c3;
 Button b1,b2;
JTextArea t1;
 font(String s,JTextArea jt)
{
    super(s);
    t1=jt;
     c1=new Choice();
     c1.add("Arial");
     c1.add("Adobe Caslon Pro");
     c1.add("Arial Black");
     c1.add("Arial Narrow");
     c1.add("Arial Rounded MT Bold");
     c1.add("Arial Unicode MS");
     c1.add("Arno Pro");
     c1.add("Arno Pro Caption");
     c1.add("Arno Pro Display");
     c1.add("Baskerville Old Face");
     c1.add("Batang");
     c1.add("Bauhaus 93");
     c1.add("Bell Gothic Std Black");
     c1.add("Comic Sans MS");
     c1.add("Consolas");
     c1.add("Cooper Std Black");
     c1.add("Corbel");
     c1.add("DFKai-SB");
     c1.add("DilleniaUPC");
     c1.add("Forte");
     setLayout(new FlowLayout());
     add(new Label("Font"));
     add(c1);
     c2=new Choice();
     c2.add("10");     
     c2.add("12");
     c2.add("14");
     c2.add("16");
     c2.add("18");
     c2.add("20");
     c2.add("22");
     c2.add("24");
     c2.add("28");
     c2.add("32");
     c2.add("36");
     c2.add("40");
     c2.add("44");
     c2.add("48");
     c2.add("60");
     c2.add("72");
     add(new Label("Size"));
     add(c2);
     c3=new Choice();
     c3.add("Bold");
     c3.add("Italic"); 
     c3.add("Plain");    
     add(new Label("Font Style"));
     add(c3);
     b1=new Button("Ok");
     b2=new Button("Cancel");
     b1.addActionListener(this);
     b2.addActionListener(this);
     add(b1);
     add(b2);
    
    addWindowListener(new WindowAdapter()
{
public void windowClosing(WindowEvent we)
{
 setVisible(false);
 }
});     
    }
   
 public void actionPerformed(ActionEvent ae)
  {
Font f=null;
   if(c3.getSelectedItem()=="Bold")
    {
        f=new Font(""+c1.getSelectedItem(),Font.BOLD,Integer.parseInt(c2.getSelectedItem()));
             
    }
     if(c3.getSelectedItem()=="Plain")
    {
        f=new Font(""+c1.getSelectedItem(),Font.PLAIN,Integer.parseInt(c2.getSelectedItem()));
             
    }
     if(c3.getSelectedItem()=="Italic")
    {
        f=new Font(""+c1.getSelectedItem(),Font.ITALIC,Integer.parseInt(c2.getSelectedItem()));
             
    } 
   if(ae.getSource()==b1)
  {
   t1.setFont(f);
   setVisible(false);    
  }
  if(ae.getSource()==b2)
 {
  setVisible(false);
 }
  }     
  

}
 
class ss extends Frame
{

 public  void printRecord(String s)
{
  StringReader sr = new StringReader(s);
  LineNumberReader lnr = new LineNumberReader(sr);
  Font typeface = new Font("Monospaced", Font.PLAIN, 12);						
  Properties p = new Properties();
  PrintJob pjob = getToolkit().getPrintJob(this, "Print report", p);
				
if (pjob != null) 
{
 Graphics pg = pjob.getGraphics();
  if (pg != null) 
{		
 FontMetrics fm = pg.getFontMetrics(typeface);		
 int margin = 20;
 int pageHeight = pjob.getPageDimension().height - margin;
 int fontHeight = fm.getHeight();
 int fontDescent = fm.getDescent();
 int curHeight = margin;	
 String nextLine;
 pg.setFont (typeface);    			

try
{
 do
     {
      nextLine = lnr.readLine();
      if (nextLine != null) 
  {         
     if ((curHeight + fontHeight) > pageHeight)
     { // New Page
       pg.dispose();
      pg = pjob.getGraphics();
     curHeight = margin;
   }
							
 curHeight += fontHeight;

 if (pg != null)
{
  pg.setFont (typeface);
 pg.drawString (nextLine, margin, curHeight - fontDescent);
}
}
	}
	while (nextLine != null);
					
	}
	catch (EOFException eof)
				{
				}
				catch (Throwable t)
				{
					t.printStackTrace();
				}
			}
			pg.dispose();
		}
		if (pjob != null)
			pjob.end();
	}

}
