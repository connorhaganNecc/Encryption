package encryption;

/**
 *
 *      The Caesar cipher class         
 * 
 */

import java.util.Scanner;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caesar 
{
    
    FileReader fileReader;
    BufferedWriter fileWriter;
    
    
    
    public void encrypt(String fileName)
    {
        try 
        {
            File postEncryption = new File("postEncryption.txt");
            
            fileReader = new FileReader(fileName);
            fileWriter = new BufferedWriter(new FileWriter("postEncryption.txt"));
            int c = -1;
            
            while ((c = fileReader.read())> -1) 
            {
                if(97<=c&&c<=122)//if lower case letter
                {
                    c+=3;
                    if(c>122)   //if it goes outsize the lowercase range (will do with xyz)
                    {
                        c-=26;//shift it back to the begining of the alphabet
                    }
                    
                }
                if(65<=c&&c<=90)//if Upper case letter
                {
                    c+=3;
                    if(c>90)// if it goes outside the upper case range (will do with xyz)
                    {
                        c-=26;//shift it back to the beginning of the alphabet
                    }
                    
                }             
                fileWriter.write(c);

            }
            fileWriter.close();

        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void decrypt(String fileName)
    {
        try
        {
            File postDecryption = new File("postDecryption.txt");
            fileReader = new FileReader("postEncryption.txt");
            fileWriter = new BufferedWriter(new FileWriter("postDecryption.txt"));
            int c = -1;
            
            while ((c = fileReader.read())> -1) 
            {
                if(97<=c&&c<=122)//if lower case letter
                {
                    c-=3;
                    if(c<97)   //if it goes outsize the lowercase range (will do with xyz)
                    {
                        c+=26;//shift it back to the begining of the alphabet
                    }
                    
                }
                if(65<=c&&c<=90)//if Upper case letter
                {
                    c-=3;
                    if(c<65)// if it goes outside the upper case range (will do with xyz)
                    {
                        c+=26;//shift it back to the beginning of the alphabet
                    }
                    
                }
                fileWriter.write(c);

            }
            fileWriter.close();

        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Caesar.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
    }
    
    
    
    
}
