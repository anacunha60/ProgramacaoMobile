package Mobile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class Serializacao 
{ 
    public static void main(String[] args) 
    {    
        Horario object = new Horario(13, 20, 45); 
        String filename = "file.ser"; 
          
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(object); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
  
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
    } 
} 
