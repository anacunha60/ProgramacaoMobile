package Mobile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializacao {
	
	public static void main(String[] args) 
    {
	
		String filename = "file.ser"; 
		
		Horario object1 = null; 
	  
      // Deserialization 
      try
      {    
          // Reading the object from a file 
          FileInputStream file = new FileInputStream(filename); 
          ObjectInputStream in = new ObjectInputStream(file); 
            
          // Method for deserialization of object 
          object1 = (Horario)in.readObject(); 
            
          in.close(); 
          file.close(); 
            
          System.out.println("Object has been deserialized "); 
          System.out.println(object1);
      } 
        
      catch(IOException ex) 
      { 
          System.out.println("IOException is caught"); 
      } 
        
      catch(ClassNotFoundException ex) 
      { 
          System.out.println("ClassNotFoundException is caught"); 
      } 
    }
}
