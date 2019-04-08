//create a simple calculator in java.Use a grid layout to arrange buttons 
//for digits and operators and text field to display results andpay attention
//to exceptions 
import java.util.*;
import java.awt.*;  //applet interacts with the user through AWT
import java.awt.event.*;  //the method that receive and process events are defined in interfaces of this package
import java.applet.*;  //applets are small applications accessed on an internet server.
/*
<applet code="Calculator" width=300 height=300></applet>
*/
public class Calculator extends Applet implements ActionListener  //Every applet created must be a subclass of Applet
{
 String msg=" ";
 int v1,v2,result;
 TextField t;
 Button b[]= new Button[10];
 Button add,sub,mul,mod,clr,eq;
 char op;
 public void init()  //first method called in applet but if applet is restarted after it has been used,call start method
 {
     Color k=new Color(255,100,100);  //object created of class Color,and color is light red
     setBackground(k);  //background of display setBackground
     t=new TextField(10);
     GridLayout g=new GridLayout(4,5);
     setLayout(g);
     for(int i=0;i<10;i++)
     {
         b[i]=new Button(""+i);
     }
     add=new Button("add");
     sub=new Button("sub");
     mul=new Button("mul");
     mod=new Button("mod");
     clr=new Button("clr");
     eq=new Button("eq");
     t.addActionListener(this);
     add(t);
     for(int i=0;i<10;i++)
     {
         add(b[i]);
     }
     add(add);
     add(sub);
     add(mul);
     add(mod);
     add(clr);
     add(eq);
     for(int i=0;i<10;i++)
     {
         b[i].addActionListener(this);
     }
     add.addActionListener(this);
     sub.addActionListener(this);
     mul.addActionListener(this);
     mod.addActionListener(this);
     clr.addActionListener(this);
     eq.addActionListener(this);
 }

public void actionPerformed(ActionEvent ae)
{
    String str=ae.getActionCommand();   //command name equal to the label on button like add,sub
    char ch=str.charAt(0);  //returns character at specified index in string
    if(Character.isDigit(ch))  //check whether the char ch is digit or not,wrapped by Character class
      t.setText(t.getText()+str);  //gettext gets the text in t and settext set the text in text
    else
      if(str.equals("add"))
        {
            v1=Integer.parseInt(t.getText());
            op='+';
            t.setText("");
        }
      else if(str.equals("sub"))
            {
             v1=Integer.parseInt(t.getText());
             op='-';
             t.setText("");
            }
           else if(str.equals("mul"))
                {
                 v1=Integer.parseInt(t.getText());
                 op='*';
                 t.setText("");
                }
                 else if(str.equals("mod"))
                      {
                        v1=Integer.parseInt(t.getText());
                        op='%';
                        t.setText("");
                      }
    if(str.equals("eq"))
    {
      v2=Integer.parseInt(t.getText());
      if(op=='+')
        result=v1+v2;
      else if(op=='-')
            result=v1-v2;
           else if(op=='*')
                 result=v1*v2;
                else if(op=='%')
                      result=v1%v2;
     t.setText(""+result);
    }
    if(str.equals("clr"))
       {
         t.setText("");
      }
}
}