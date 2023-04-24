import java.io.FileWriter;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.lang.StringBuilder;

public class ShortestDistance 
{
    public static void main(String[] args)

    {
    static final int MAXIMUMUM_NUMBER_OF_LOCATIONS=20;

    try
    {
        Scanner inputStream = new Scanner (new File("Ghana.csv"));         
        
        String line = inputStream.nextLine();
        double[] locationName= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];
        double[] locationLongitude= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];
        double[] locationLatitude= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];

        int numberOfLocationss=0;
        while (inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            String[] locationsStringType = line.split(",");
            locationName[numberOfLocationss]=Double.parseDouble(locationsStringType[0]) ;
            locationLongitude[numberOfLocationss]=Double.parseDouble(locationsStringType[1]) ;
            locationLatitude[numberOfLocationss]=Double.parseDouble(locationsStringType[2]) ;
            numberOfLocationss++;                
        }
        
    }
    catch (FileNotFoundException e)
    {
        System.out.println("Cannot find file");
    }}
}
