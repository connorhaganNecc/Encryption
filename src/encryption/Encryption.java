/*
 * 
 *      This class will give you the options to choose which encryptions/
 *          decryptions you want to use
 * 
 */

package encryption;

import java.io.*;
import java.util.Scanner;

public class Encryption 
{
   

    public static void main(String[] args) 
    {
        boolean isDone=false;
        String fileName;
        Scanner input = new Scanner(System.in);
        
        
        while(isDone == false)
        {
            System.out.println("Enter name of your txt file. Make sure you get the case right and include the file extension: ");
            fileName = input.nextLine();
            
            isDone = doesFileExist(fileName); // if doesFileExist finds the file it returns true;
            
            Caesar caesarCiper = new Caesar();
            
            caesarCiper.encrypt(fileName);
            
            caesarCiper.decrypt(fileName);
                    
        }
        
        
    }
    
    
    public static boolean doesFileExist(String filePath)
    {
        boolean doesFileExist = new File(filePath).exists();    //checks to see if the file exists then sets doesFileExist to the result
        System.out.println(doesFileExist);
        return doesFileExist;
    }
    
    
    
    
    
}
