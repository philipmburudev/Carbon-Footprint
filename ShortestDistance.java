import java.io.FileWriter;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.lang.StringBuilder;

public class ShortestDistance 
{
    MAXIMUMUM_NUMBER_OF_POINTS=50;

    try
    {
        Scanner inputStream = new Scanner (new File("Ghana.csv"));         
        
        String line = inputStream.nextLine();
        double[] xCoordinates= new double[MAXIMUMUM_NUMBER_OF_POINTS];
        double[] yCoordinates= new double[MAXIMUMUM_NUMBER_OF_POINTS];

        int numberOfPoints=0;
        while (inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            String[] pointsStringType = line.split(",");
            xCoordinates[numberOfPoints]=Double.parseDouble(pointsStringType[0]) ;
            yCoordinates[numberOfPoints]=Double.parseDouble(pointsStringType[1]) ;
            numberOfPoints++;                
        }
        
        for (int n = 0; n < numberOfPoints; n++) 
        {
            for (int m = 0; m < numberOfPoints-1 - n; m++) {
                if (xCoordinates[m]>xCoordinates[m + 1]) {
                    double swapString = xCoordinates[m];
                    xCoordinates[m] = xCoordinates[m + 1];
                    xCoordinates[m + 1] = swapString;
                    double swapInt = yCoordinates[m];
                    yCoordinates[m] = yCoordinates[m + 1];
                    yCoordinates[m + 1] = swapInt;
                }
            }
        }
    }
    catch (FileNotFoundException e)
    {
        System.out.println("Cannot find file");
    }
}
