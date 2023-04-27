import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;


/**
 * 
 * This program calculates the carbon footprint of a user's journey from one location to another.
 * The user is asked to input their origin, destination and mode of transport.
 * The program then calculates the distance between the two locations using their longitudes and latitudes.
 * The program then calculates the carbon footprint of the journey using the distance and the mode of transport.
 * The program then recommends a more sustainable mode of transport if the user's mode of transport is not sustainable.
 * The program then asks the user if they want to start again.
 * 
 * @author Freda Marie, Aaron Obodai, Philip Mburu
 *  
 * @param args
 * @throws FileNotFoundException
 * @throws IOException
 */

public class FootprintTracker {
    static final int MAXIMUMUM_NUMBER_OF_LOCATIONS=20;
      
    //main method
    public static void main(String args[]){
    try
    {
        double totalActualEmissions=0;
        double totalRecommendedEmissions=0;

        // create a String variable to hold user input for starting again or quitting
        String startAgain;

        // create multiple Scanner objects to get user input from console
        Scanner userInput= new Scanner(System.in);
        Scanner userInput2 = new Scanner(System.in);
        Scanner userInput3 = new Scanner(System.in);
        Scanner userInput4 = new Scanner(System.in);

        // use a do-while loop to keep the program running until the user quits
        do{
        Scanner inputStream = new Scanner (new File("Places.csv")); // create a new Scanner object to read from the "Places.csv" file

        // read the first line of the file and ignore it (assuming it's a header)
        String line = inputStream.nextLine();

        // create arrays to hold location information
        String[] locationName= new String[MAXIMUMUM_NUMBER_OF_LOCATIONS];
        double[] locationLongitude= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];
        double[] locationLatitude= new double[MAXIMUMUM_NUMBER_OF_LOCATIONS];

        // keep track of the number of locations read from the file
        int numberOfLocationss=0;

        // loop through the rest of the file and read each location's information
        while (inputStream.hasNextLine())
        {
            line = inputStream.nextLine();
            String[] locationsStringType = line.split(",");
            locationName[numberOfLocationss]=locationsStringType[0];
            locationLatitude[numberOfLocationss]=Double.parseDouble(locationsStringType[1]) ;
            locationLongitude[numberOfLocationss]=Double.parseDouble(locationsStringType[2]) ;
            numberOfLocationss++;            
        }
        System.out.println("---------------------------------------------------------------------------------");

        System.out.println("\n" + "Hello! This is Footprint Forward, here to help you implement sustainable practices in your daily life.");
        System.out.println("To start, you will have to input your origin, destination, and mode of transport you intend to use.\n");
    
        //creating objects for the different modes of transport
        Level1 bicycle = new Level1("Bicycle",0);
        Level1 walking = new Level1("Walking",0);
        Level1 scooter = new Level1("Scooter",0);
        System.out.println();

        System.out.println("The modes of transport in level 1 are: \n" + scooter.getTransportMode()+"\n"
                                                                       + bicycle.getTransportMode()+"\n"
                                                                       + walking.getTransportMode()
                                                                       );

        Level2 motorbike = new Level2("Motorbike",0.4);
        Level2 bus = new Level2("Bus",0.68);
        Level2 car = new Level2("Car",0.89);
        System.out.println();
        System.out.println("The modes of transport in level 2 are: \n" + motorbike.getTransportMode()+"\n"
                                                                       + bus.getTransportMode()      +"\n"
                                                                       + car.getTransportMode()
                                                                       );

        Level3 train = new Level3("Train",0.17);
        Level3 ship = new Level3("Ship",193.066);
        Level3 airplane = new Level3("Airplane",0.42);
        System.out.println();
        System.out.println("The modes of transport in level 3 are: \n" + train.getTransportMode()+"\n"
                                                                       + ship.getTransportMode() +"\n"
                                                                       + airplane.getTransportMode()
                                                                       );
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        //asking user to enter their origin location
        String origin;
        System.out.println("\n" + "Lets get started!! " +  "\n");
    
        do{
            System.out.print("Please enter your origin: \n");
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
            System.out.print("Enter your destination: \n");
            destination = userInput2.nextLine();
            while(destination.equals(origin)){
                System.out.println("This has been taken as your origin and cannot be your destination\nTry again with a different destination location");
                destination = userInput2.nextLine();
            }
            if (destination.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid location.");
                destination = userInput2.nextLine();
            }
        } while (destination.matches("\\d+"));
        System.out.println();
            
        //asking user to enter the mode of transport they want to use
        String modeName;
        do {
            System.out.print("Enter the mode of transportation you want to use: \n");
            modeName = userInput3.nextLine();
            
            if (modeName.matches("\\d+")) {
                System.out.println("Invalid mode of transport. Please enter a valid mode of transport.");
            }

        } while (modeName.matches("\\d+"));
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------");

        // finding the distance between two locations using their longitudes and latitudes
        double longitude1,longitude2,latitude1,latitude2,c,a;
        double distance=0;
        for(int i=0;i<locationName.length;i++)
        {
            for(int j=0;j<locationName.length;j++){
                if(origin.equalsIgnoreCase(locationName[i]) && destination.equalsIgnoreCase(locationName[j]))
                {
                    longitude1 = locationLongitude[i];
                    latitude1 = locationLatitude[i];
                    longitude2 = locationLongitude[j];
                    latitude2 = locationLatitude[j];
                    a = (Math.sin((Math.toRadians(latitude2)-Math.toRadians(latitude1))/2)*Math.sin((Math.toRadians(latitude2)-Math.toRadians(latitude1))/2))+(Math.cos(Math.toRadians(latitude2))*Math.cos(Math.toRadians(latitude1))*Math.sin((Math.toRadians(longitude2)-Math.toRadians(longitude1))/2)*Math.sin((Math.toRadians(longitude2)-Math.toRadians(longitude1))/2));
                    c = 2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));  //203.66km  126.6miles
                    distance = c*6371*0.621371;
                    System.out.println("The distance between " + origin + " and " + destination + " is " + distance + "miles.");
                }
            }
        }
        System.out.println();

        // declaring two ModesOfTransport objects to store the user's intended and recommended modes of transport
        ModesOfTransport recommendedModeOfTransport;
        ModesOfTransport intendedModeOfTransport;

        // variable to store the percentage of emissions saved by taking the recommended mode of transport
        double percentageOfEmissionsSaved=0;

        // lists to store the actual and recommended emissions values
        List<Double> actualEmissionsList = new ArrayList<Double>();
        List<Double> recommendedEmissionsList = new ArrayList<Double>();


        // checking the user's input mode name and setting the intended mode of transport accordingly
        if (modeName.equalsIgnoreCase("bicycle"))
        {
            intendedModeOfTransport=bicycle;
        }
        else if (modeName.equalsIgnoreCase("scooter"))
        {
            intendedModeOfTransport=scooter;
        }
        else if (modeName.equalsIgnoreCase("walking"))
        {
            intendedModeOfTransport=walking;
        }
        else if (modeName.equalsIgnoreCase("car"))
        {
            intendedModeOfTransport=car;
        }
        else if (modeName.equalsIgnoreCase("bus"))
        {
            intendedModeOfTransport=bus;
        }
        else if (modeName.equalsIgnoreCase("motorbike"))
        {
            intendedModeOfTransport=motorbike;
        }
        else if (modeName.equalsIgnoreCase("train"))
        {
            intendedModeOfTransport=train;
        }
        else if (modeName.equalsIgnoreCase("ship"))
        {
            intendedModeOfTransport=ship;
        }
        else if (modeName.equalsIgnoreCase("airplane"))
        {
            intendedModeOfTransport=airplane;
        }
        else
        {
            // if the mode name is not valid, setting the intended mode of transport to null
            intendedModeOfTransport=null;
        }

        // determine the recommended mode of transport based on the distance and emissions of available modes
        if (distance>0 && distance<=5)
        {
            // find the lowest emitter of greenhouse gases for short distances
            recommendedModeOfTransport=walking.findLowestEmitter(scooter, bicycle, distance);
            
            // check if the intended mode of transport is the same as the recommended mode
            if (recommendedModeOfTransport.getTransportMode().equalsIgnoreCase(modeName)){
                System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getTransportMode()+") you intend to use emits the least greenhouse gases.");
            }else
            {
                    // calculate the percentage of emissions saved and add the actual and recommended emissions to their respective lists
                    percentageOfEmissionsSaved= 100;
                    actualEmissionsList.add(intendedModeOfTransport.computeEmission(distance));
                    recommendedEmissionsList.add(recommendedModeOfTransport.computeEmission(distance));
                    System.out.println("The mode of transport we recommend you use is "+ recommendedModeOfTransport.getTransportMode());
                    System.out.println();
                    System.out.println("With this mode of transport"+recommendedModeOfTransport.getTransportMode()+", you will reduce carbon emissions by " +percentageOfEmissionsSaved + " %");
                    System.out.println();
            }
        }else if (distance>5 && distance<=200)
        {
            // find the lowest emitter of greenhouse gases for medium distances
            recommendedModeOfTransport=motorbike.findLowestEmitter(car, bus, distance);

            // check if the intended mode of transport is the same as the recommended mode
            if (recommendedModeOfTransport.getTransportMode().equalsIgnoreCase(modeName))
            {
                System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getTransportMode()+") you intend to use emits the lease greenhouse gases.");
            }
            else{
                // calculate the percentage of emissions saved and add the actual and recommended emissions to their respective lists
                if (intendedModeOfTransport != null) 
                {
                    if(intendedModeOfTransport.computeEmission(distance)>0)
                    {
                        percentageOfEmissionsSaved= Math.round(Math.abs(((intendedModeOfTransport.computeEmission(distance)-recommendedModeOfTransport.computeEmission(distance))/intendedModeOfTransport.computeEmission(distance))*100));
                        actualEmissionsList.add(intendedModeOfTransport.computeEmission(distance));
                        recommendedEmissionsList.add(recommendedModeOfTransport.computeEmission(distance));
                        System.out.println("The mode of transport we recommend you use is "+ recommendedModeOfTransport.getTransportMode());
                        System.out.println("With this mode of transport "+recommendedModeOfTransport.getTransportMode()+", you will reduce carbon emissions by " +percentageOfEmissionsSaved + " %");

                    }
                    else{
                        System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getTransportMode()+") you intend to use emits the least greenhouse gases.");
                    }

                } 
                else {
                    System.out.println("No valid intended mode of transport was specified");
                }
            }       
            
        }
        // find the lowest emitter of greenhouse gases for long distances
        else if (distance>200 && distance<=1250)
        {
            recommendedModeOfTransport=train.findLowestEmitter(ship, airplane, distance);
            // check if the intended mode of transport is the same as the recommended mode
            if (recommendedModeOfTransport.getTransportMode().equalsIgnoreCase(modeName))
            {
                System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getTransportMode()+") you intend to use emits the lease greenhouse gases.");
            }
            else{
                // calculate the percentage of emissions saved and add the actual and recommended emissions to their respective lists
                if (intendedModeOfTransport != null ) {
                    if(intendedModeOfTransport.computeEmission(distance)>0)
                    {
                        actualEmissionsList.add(intendedModeOfTransport.computeEmission(distance));
                        recommendedEmissionsList.add(recommendedModeOfTransport.computeEmission(distance));
                        percentageOfEmissionsSaved= Math.round(Math.abs(((intendedModeOfTransport.computeEmission(distance)-recommendedModeOfTransport.computeEmission(distance))/intendedModeOfTransport.computeEmission(distance))*100));
            
                        System.out.println("The mode of transport we recommend you use is "+ recommendedModeOfTransport.getTransportMode());
                        System.out.println("With this mode of transport "+recommendedModeOfTransport.getTransportMode()+", you will reduce carbon emissions by " +percentageOfEmissionsSaved + " %");
    
                    }
                    else{
                        System.out.println("Well done! The mode of transport(" + recommendedModeOfTransport.getTransportMode()+") you intend to use emits the least greenhouse gases.");
                    }
                } 
                else {
                    System.out.println("No valid intended mode of transport was specified");
                }


            }
        }


        System.out.println();
        for (int i = 0; i < actualEmissionsList.size(); i++) {
        // looping through the actualEmissionsList to calculate the total actual emissions
            totalActualEmissions+=actualEmissionsList.get(i);
        
        // looping through the recommendedEmissionsList to calculate the total recommended emissions
            totalRecommendedEmissions+=recommendedEmissionsList.get(i);
        } 
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("This is the end for this set\nOn to the next");
        System.out.println("Do you want to start again for another day?\nYes or No");
        System.out.println("---------------------------------------------------------------------------------");

        startAgain = userInput4.nextLine();
        while(!startAgain.equalsIgnoreCase("Yes") && !startAgain.equalsIgnoreCase("No")){
            System.out.println("Your answer is not valid. Answer again");
            startAgain = userInput4.nextLine();
        }
        inputStream.close();

        }while(startAgain.equalsIgnoreCase("Yes"));

        
      
        userInput.close();
        userInput2.close();
        userInput3.close();
        userInput4.close();

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\n" + "For all your trips, the total actual emmissions are: " + totalActualEmissions + "kg of CO2\nFor all your trips, the total recommended emmissions are: " + totalRecommendedEmissions+ "kg of CO2");
        System.out.println();
        System.out.println("The total amount of emissions saved will be: " + (totalActualEmissions - totalRecommendedEmissions) + " kg of CO2/");
        System.out.println("You will save " + Math.round(Math.abs(((totalActualEmissions-totalRecommendedEmissions)/totalActualEmissions)*100)) + "% of CO2.");
        
    
    }
    catch (FileNotFoundException e)
    {
        System.out.println("Cannot find file");
    }
    catch(NumberFormatException b){
        System.out.println("The input is invalid");
    }
        

}

}


        