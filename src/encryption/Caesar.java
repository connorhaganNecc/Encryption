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
    FileWriter fileWriter;
    
    
    public void encrypt(String fileName)
    {
        try 
        {
            File postEncryption = new File("postEncryption.txt");
            fileReader = new FileReader(fileName);
            fileWriter = new FileWriter("postEncryption.txt");
            int c = -1;
            
            while ((c = fileReader.read())> -1) 
            {

                fileWriter.write(c+3);

            }

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
