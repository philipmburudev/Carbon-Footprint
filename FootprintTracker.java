import java.util.Scanner;
import java.io.FileWriter;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.lang.StringBuilder;
import javax.lang.model.util.Elements.Origin;
import java.lang.Math;

public class FootprintTracker {

    static final int MAXIMUMUM_NUMBER_OF_LOCATIONS=20;

    public FootprintTracker(){}

    private String recommendedModeOfTransport;
    private double totalActualEmissions; 
    private double totalRecommendedEmissions;
    
    
    //main method
    public static void main(String args[]){
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

        Scanner userInput= new Scanner(System.in);
        System.out.println("\n" + "Hello! This is Footprint Forward, here to help you implement sustainable practices in your daily life.");
        System.out.println("To start, you will have to input your origin, destination, and mode of transport you intend to use.\n");
        

        
        //creating objects for the different modes of transport
        Level1 bicycle = new Level1("Bicycle",0);
        Level1 walking = new Level1("Walking",0);
        Level1 scooter = new Level1("Scooter",0);
        System.out.println();

        System.out.println("The modes of transport in level 1 are: \n" + scooter.getModeName()+"\n"
                                                                       + bicycle.getModeName()+"\n"
                                                                       + walking.getModeName()
                                                                       );

        Level2 motorbike = new Level2("Motorbike",0.18);
        Level2 bus = new Level2("Bus",0.29);
        Level2 car = new Level2("Car",0.17);
        System.out.println();
        System.out.println("The modes of transport in level 2 are: \n" + motorbike.getModeName()+"\n"
                                                                       + bus.getModeName()      +"\n"
                                                                       + car.getModeName()
                                                                       );

        Level3 train = new Level3("Train",0.17);
        Level3 ship = new Level3("Ship",0.025);
        Level3 airplane = new Level3("Airplane",0.32);
        System.out.println();
        System.out.println("The modes of transport in level 3 are: \n" + train.getModeName()+"\n"
                                                                       + ship.getModeName() +"\n"
                                                                       + airplane.getModeName()
                                                                       );
        System.out.println();

        //asking user to enter their origin location
        String origin;
        System.out.println("\n" + "Lets get started. " +  "\n");
        do 
        {
            System.out.print("Please enter your origin: ");
            origin = userInput.nextLine();
            
            while(origin.matches("\\d+")) 
            {
                System.out.println("Invalid input! Please enter a valid location.");
                origin = userInput.nextLine();
            }
        } while (origin.matches("\\d+"));
        System.out.println();

        //asking user to enter their destitnation location
        String destination;
        do {
            System.out.print("Enter your destination: ");
            destination = userInput.nextLine();
            while(destination.equals(origin)){
                System.out.println("This has been taken as your origin and cannot be your destination\nTry again with a different destination location");
                destination = userInput.nextLine();
            }
            if (destination.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid location.");
                destination = userInput.nextLine();
            }
        } while (destination.matches("\\d+"));
        System.out.println();
        
        //asking user to enter the mode of transport they want to use
        String modeName;
        do {
            System.out.print("Enter the mode of transportation you want to use: ");
            modeName = userInput.nextLine();
            
            if (modeName.matches("\\d+")) {
                System.out.println("Invalid mode of transport. Please enter a valid mode of transport.");
            }
        } while (modeName.matches("\\d+"));



        // Finding the distance between two locations using their longitudes and latitudes
        double longitude1,longitude2,latitude1,latitude2,distance,a;
        for(int i=0;i<locationName.length;i++)
        {
            for(int j=0;j<locationName.length;j++){
                if(origin.equals(locationName[i]) && destination.equals(locationName[j]))
                {
                    longitude1 = locationLongitude[i];
                    latitude1 = locationLatitude[i];
                    longitude2 = locationLongitude[j];
                    latitude2 = locationLatitude[j];
                    a = (Math.sin((Math.toRadians(latitude2)-Math.toRadians(latitude1))/2)*Math.sin((Math.toRadians(latitude2)-Math.toRadians(latitude1))/2))+(Math.cos(Math.toRadians(latitude2))*Math.sin((Math.toRadians(latitude2)-Math.toRadians(latitude1))/2)*Math.sin((Math.toRadians(longitude2)-Math.toRadians(longitude1))/2)*Math.sin((Math.toRadians(longitude2)-Math.toRadians(longitude1))/2));
                    distance = a*Math.cos((Math.sin(Math.toRadians(latitude1))*Math.sin(Math.toRadians(latitude2)))+(Math.cos(Math.toRadians(latitude1))*Math.cos(Math.toRadians(latitude2))*Math.cos(Math.toRadians(longitude2-longitude1))))*6371;
                    System.out.println("The distance between " + origin + " and " + destination + " is " + distance + "km.");
                }
            else{
                System.out.println("Location cannot be found");
            }
        }
        }
    userInput.close(); 
    }
    catch (FileNotFoundException e)
    {
        System.out.println("Cannot find file");
    }
        
        
}

}


        