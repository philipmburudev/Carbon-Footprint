import java.io.FileWriter;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.lang.StringBuilder;

public class ShortestDistance 
{
<<<<<<< HEAD
    static final int MAXIMUMUM_NUMBER_OF_LOCATIONS=20;
    public String[] locationsStringType;
=======

>>>>>>> d70fa2c6a6ac00897007702281daa4feb125ad43
    public static void main(String[] args)

    {

<<<<<<< HEAD
    try
    {
        Scanner inputStream = new Scanner (new File("Ghana.csv"));         
        
        String line = inputStream.nextLine();
        String[] locationName= new String[MAXIMUMUM_NUMBER_OF_LOCATIONS];
        double[] locationLongitude= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];
        double[] locationLatitude= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];

        int numberOfLocationss=0;
        while (inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            String[] locationsStringType = line.split(",");
            locationName[numberOfLocationss]=locationsStringType[0];
            locationLongitude[numberOfLocationss]=Double.parseDouble(locationsStringType[1]) ;
            locationLatitude[numberOfLocationss]=Double.parseDouble(locationsStringType[2]) ;
            numberOfLocationss++;                
        }

        for (int i=0;i<MAXIMUMUM_NUMBER_OF_LOCATIONS;i++)
        {
            System.out.println(locationLatitude[i]);
        }
        
    }
    catch (FileNotFoundException e)
    {
        System.out.println("Cannot find file");
    }}
=======
    
>>>>>>> d70fa2c6a6ac00897007702281daa4feb125ad43
}
