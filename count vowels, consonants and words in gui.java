/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assingment2fh;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author YK
 */
public class assingment2fhi  implements ActionListener
{
    JLabel countL = new JLabel();
    JLabel countL2 = new JLabel();
    JFrame frame = new JFrame("File Handling");
    JButton browse = new JButton("Browse");
    JButton save = new JButton("Save");
    JButton count = new JButton("Count");
    JTextArea area = new JTextArea(20,30);
  JScrollPane pane = new JScrollPane(area);
   public assingment2fhi()
    {
       
        
        frame.add(countL);
        frame.add(countL2);
        frame.add(browse);
        frame.add(save);
        frame.add(count);
        frame.add(pane);
         browse.addActionListener(this);
        save.addActionListener(this);
        count.addActionListener(this);
        //Setting frame size and visibilty
        frame.setVisible(true);
         frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
     
    public static void main(String[] args) 
    {
        new assingment2fhi();
        
    }
   JFileChooser Filechoser;
   File file;
   String path;
    @Override
    public void actionPerformed(ActionEvent ae)
    {    Filechoser = new JFileChooser("E:");
     
        if(ae.getSource()==browse)
        {
         
    int i =Filechoser.showOpenDialog(null);
            if(i==JFileChooser.APPROVE_OPTION)
            {
                 path = Filechoser.getSelectedFile().getAbsolutePath();
                  file = new File(path);
                  String text="";
     try {
                   
                    
                    Scanner  read = new Scanner(file);
                    while(read.hasNextLine())
                    {
                        
                         text +=read.nextLine()+System.lineSeparator();
                         
                       
                    }
                    area.setText(text);
                    
                } catch (FileNotFoundException ex) {
                 }
                
                
            }
            else if(i==JFileChooser.CANCEL_OPTION)
            {
                JOptionPane.showMessageDialog(null, " NO File selected");
            }
            
        }
       else if(ae.getSource()==save)
        {
            if(path != null)
            {
             
            try {
                  FileWriter fr = new FileWriter(path);
                 String data =area.getText();
                fr.write(data);
                fr.close();
               
            } catch (IOException ex) 
            {
              JOptionPane.showMessageDialog(null, " NO File selected");  
            }
              
           JOptionPane.showMessageDialog(null, "Changes Saved!");
            }
            else{
                JOptionPane.showMessageDialog(null, "No File Selected!");
            }
         }
        
       else if(ae.getSource()== count)
       {
           int words=0,vowels=0,sentences=0,lines=0,letters=0,consonants=0;
           int paragrap=0;
           file = new File(path);
        try {
            Scanner input = new Scanner(file);
            String text=null;
            String data=null;
        while(input.hasNextLine())
        {
        text =input.nextLine();
        data+=text;
        
           if(text.isEmpty())
           {
              paragrap++; 
           }
           else
           { 
           lines++;
           }
         for(int i=0;i<text.length();i++)
             {
              char ch = text.charAt(i);
           if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
           {
               vowels++;
                
           }
                else if(ch=='.')
           {
               sentences++;
              
           }
              else   if(ch==' '||ch=='\n')
              {
                 words++;
              }
                
           else
           {
               consonants++;
           }
              
              if(ch!=' ' && ch!='\n')
              {
                 letters++;
              }
              
              
              }
           }
     
        input.close();
         String[] para =data.split("\r\rn");
         paragrap=para.length;
         }
        catch (IOException ex) {
            Logger.getLogger(assingment2fhi.class.getName()).log(Level.SEVERE, null, ex);
        }
        words+=lines;
       
        
        
        countL.setText("characters: "+letters + ", Words:"+words+ ", vowels:"+vowels+", consonants:"+consonants);
         countL2.setText(",sentences:"+sentences +", lines: "+lines+ ", paragraph: "+paragrap);   
       }
      }
    
}
    


