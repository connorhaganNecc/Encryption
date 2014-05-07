package encryption;

/**
 *
 *      The Enigma cipher class         
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Character.*;

public class Enigma
{
    FileReader fileReader;
    BufferedWriter fileWriter;
    
    String outerRingString = "#BDFHJLNPRTVXZACEGIKMOQSUWY";
    char[] outerRing = outerRingString.toCharArray();
    
    String middleRingString = "#GNUAHOVBIPWCJQXDKRYELSZFMT";
    char[] middleRing = middleRingString.toCharArray();
    
    String innerRingString = "#EJOTYCHMRWAFKPUZDINSXBGLQV";
    char[] innerRing = innerRingString.toCharArray();
    
    public char[] shiftRight(char[] inCharArray)
    {
        
        char hold = inCharArray[26];
        
        
        for(int count = 26; count >0 ; count--)
        {
            inCharArray[count]=inCharArray[count-1];
        }
        inCharArray[0]=hold;
        return inCharArray;
    }
    
    public void encryt(String fileName)
    {
        File postEncryption = new File("postEncryption.txt");
        resetInnerRing();
        resetOuterRing();
            
        try {
            fileReader = new FileReader(fileName);
            
            fileWriter = new BufferedWriter(new FileWriter("postEncryption.txt"));
            
            int c = -1;
            
            while ((c = fileReader.read())> -1) 
            {
                
                if(97<=c&&c<=122)//if lower case letter
                {
                    c-=32; //turns it to uppercase
                    c = EnigmaEncode(c);
                    
                }
                else if(65<=c&&c<=90)//if Upper case letter
                {
                    c = EnigmaEncode(c);
                    
                }
                else if(c==32)
                {
                    c=35;
                    c = EnigmaEncode(c);
                }
                
                /*
                if(c==35)//if c equals pound set it to space
                {
                    c= ' ';
                }
                */
                
                fileWriter.write(c);
                
            }
            fileWriter.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Enigma.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(Enigma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void decrypt(String fileName)
    {
        File postDecryption = new File("postDecryption.txt");
        resetInnerRing();
        resetOuterRing();
            
        try {
            fileReader = new FileReader(fileName);
            
            fileWriter = new BufferedWriter(new FileWriter("postDecryption.txt"));
            
            int c = -1;
            
            while ((c = fileReader.read())> -1) 
            {
                
                if(97<=c&&c<=122)//if lower case letter
                {
                    c-=32; //turns it to uppercase
                    c = EnigmaDecode(c);
                    
                }
                else if(65<=c&&c<=90)//if Upper case letter
                {
                    c = EnigmaDecode(c);
                    
                }
                else if(c==35)
                {
                    c = EnigmaDecode(c);
                }
                
                
                if(c==35)//if c equals pound set it to space
                {
                    c= ' ';
                }
                
                
                fileWriter.write(c);
                
            }
            fileWriter.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Enigma.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (IOException ex) {
            Logger.getLogger(Enigma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int EnigmaEncode(int c)
    {
        int placeHold=0;
        
        for(int i = 0; i < 27 ; i++)
        {
            if(innerRing[i]==c)
            {
                placeHold = i;
            }
        }
        c = outerRing[placeHold];
        
        
        for(int i = 0; i < 27 ; i++)
        {
            if(middleRing[i]==c)
            {
                placeHold = i;
            }
        }
        c = outerRing[placeHold];
        shiftRight(innerRing);
        
        if(innerRing.toString()==innerRingString)//if the inner ring returns to it's original position shift the middle ring
        {
            shiftRight(middleRing);
        }
        return c;
    }
    
    public int EnigmaDecode(int c)
    {
        int placeHold=0;

        for(int i = 0; i < 27 ; i++)
        {
            if(outerRing[i]==c)
            {
                placeHold = i;
            }
        }
        c = middleRing[placeHold];
        
        for(int i = 0; i < 27 ; i++)
        {
            if(outerRing[i]==c)
            {
                placeHold = i;
            }
        }
        c = innerRing[placeHold];
        shiftRight(innerRing);
        
        if(innerRing.toString()==innerRingString)//if the inner ring returns to it's original position shift the middle ring
        {
            shiftRight(middleRing);
        }
                
        return c;
    }
    
    
    public void resetInnerRing()
    {
        innerRing = innerRingString.toCharArray();
    }
    
    public void resetOuterRing()
    {
        outerRing = outerRingString.toCharArray();
    }
    public void resetMiddleRing()
    {
        middleRing = middleRingString.toCharArray();
    }
    
    public void returnInnerRing()
    {
        for(int i = 0 ; i < 27 ; i++)
        {
            System.out.print(innerRing[i]);
        }
        System.out.println();
    }
    
   
    
    
    
    public static void main(String args[])
    {
        Enigma test = new Enigma();
        test.returnInnerRing();
        test.encryt("testFile.txt");
        test.returnInnerRing();
        test.decrypt("postEncryption.txt");
        test.returnInnerRing();
        
    }
    
}

