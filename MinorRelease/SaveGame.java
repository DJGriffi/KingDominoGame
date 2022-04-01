import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveGame implements java.io.Serializable
{
    public static void saveGame(KingDomino kingDomino)
    {
        try
        {   
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("savedGame.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
              
            // Method for serialization of object
            out.writeObject(kingDomino);
              
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
        try
        {   
            // Reading the object from a file
            KingDomino loadedGame = new KingDomino();
            FileInputStream file = new FileInputStream("savedGame.ser");
            ObjectInputStream in = new ObjectInputStream(file);
              
            // Method for deserialization of object
            loadedGame = (KingDomino)in.readObject();
              
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
}