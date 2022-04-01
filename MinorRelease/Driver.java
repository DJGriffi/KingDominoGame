import java.io.IOException;
import java.io.*;

public class Driver implements java.io.Serializable
{   
    static KingDomino kingDomino;

    public static void saveGame()
    {
        try
        {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("savedGame.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
              
            // Method for serialization of object
            out.writeObject(kingDomino);
            out.flush();
            out.close();
            file.close();
              
            System.out.println("Object has been serialized");
  
        }
          
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void loadGame()
    {   
        kingDomino = null;
        try
        {   
            // Reading the object from a file
            FileInputStream file = new FileInputStream("savedGame.ser");
            ObjectInputStream in = new ObjectInputStream(file);
              
            // Method for deserialization of object
            kingDomino = (KingDomino)in.readObject();
            
            in.close();
            file.close();
            
            System.out.println("Object has been deserialized ");
        }
          
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
          
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException 
    {
        kingDomino = new KingDomino();
    }

}