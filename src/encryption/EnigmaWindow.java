/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package encryption;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author CNH
 */
public class EnigmaWindow extends JFrame{
    public static String defaultOuterRingString = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
    
    public static String defaultMiddleRingString = "#EJOTYCHMRWAFKPUZDINSXBGLQV";
    
    public static String defaultInnerRingString = "#GNUAHOVBIPWCJQXDKRYELSZFMT";
    
    public static String outerRingString;
    
    public static String middleRingString;
    
    public static String innerRingString;
    
    public static String inputFileName;
    
    public static String outputFileName;
    
    JFrame frame;
    
    JPanel panel;
    
    JLabel lb_OuterRing;
    JLabel lb_MiddleRing;
    JLabel lb_InnerRing;
    
    JLabel lb_InputFileName;
    JLabel lb_OutputFileName;
    
    JTextField tf_OuterRing;
    JTextField tf_MiddleRing;
    JTextField tf_InnerRing;
    
    JTextField tf_InputFileName;
    JTextField tf_OutputFileName;
    
    JButton encrypt;
    JButton decrypt;
    JButton restoreDefaults;
    
    public EnigmaWindow()
    {
    }
    
    public void buildWindow()
    {
        frame = new JFrame("Enigma Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(800,600);
        
        
        panel = new JPanel();
        panel.setSize(600,600);
        panel.setLocation(320,320);
        panel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        
        JLabel spacer = new JLabel();
        spacer.setText("                  ");
        
        lb_OuterRing = new JLabel();
        lb_OuterRing.setText("Outer Ring Code: ");
        tf_OuterRing = new JTextField();
        tf_OuterRing.setText("Enter 26 letters and a # in outer ring order.");
        
        lb_MiddleRing = new JLabel();
        lb_MiddleRing.setText("Middle Ring Code: ");
        tf_MiddleRing = new JTextField();
        tf_MiddleRing.setText("Enter 26 letters and a # in middle ring order.");
        
        lb_InnerRing = new JLabel();
        lb_InnerRing.setText("Inner Ring Code: ");
        tf_InnerRing = new JTextField();
        tf_InnerRing.setText("Enter 26 letters and a # in inner ring order.");
        
        lb_InputFileName = new JLabel();
        lb_InputFileName.setText("Input File Name: ");
        tf_InputFileName = new JTextField();
        tf_InputFileName.setText("Input file name");
        
        lb_OutputFileName = new JLabel();
        lb_OutputFileName.setText("Output File Name: ");
        tf_OutputFileName = new JTextField();
        tf_OutputFileName.setText("Output file name");
        
        encrypt = new JButton();
        encrypt.setText("Encrypt");
        encrypt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String outer = tf_OuterRing.getText();
                String middle = tf_MiddleRing.getText();
                String inner = tf_InnerRing.getText();
                String inFile = tf_InputFileName.getText();
                String outFile = tf_OutputFileName.getText();
                Enigma encryptEnigma = new Enigma(outer, middle, inner, inFile, outFile);
                encryptEnigma.encryt();
            }
        });
        
        decrypt = new JButton();
        decrypt.setText("Decrypt");
        decrypt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String outer = tf_OuterRing.getText();
                String middle = tf_MiddleRing.getText();
                String inner = tf_InnerRing.getText();
                String inFile = tf_InputFileName.getText();
                String outFile = tf_OutputFileName.getText();
                Enigma decryptEnigma = new Enigma(outer, middle, inner, inFile, outFile);
                decryptEnigma.decrypt();
            }
        });
        
        
        restoreDefaults = new JButton();
        restoreDefaults.setText("Restore Defaults");
        restoreDefaults.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                tf_OuterRing.setText(defaultOuterRingString);
                tf_MiddleRing.setText(defaultMiddleRingString);
                tf_InnerRing.setText(defaultInnerRingString);               
            }
        });
        
        
        panel.setLayout(new GridLayout(7,2, 10, 50));
        
        panel.add(lb_OuterRing);
        panel.add(tf_OuterRing);
        
        panel.add(lb_MiddleRing);
        panel.add(tf_MiddleRing);
        
        panel.add(lb_InnerRing);
        panel.add(tf_InnerRing);
        
        panel.add(lb_InputFileName);
        panel.add(tf_InputFileName);
        
        panel.add(lb_OutputFileName);
        panel.add(tf_OutputFileName);
        
        panel.add(encrypt);
        panel.add(decrypt);
        panel.add(restoreDefaults);
        
        frame.add(panel);
        frame.setVisible(true);
        
        
        
        
        
    }
}
