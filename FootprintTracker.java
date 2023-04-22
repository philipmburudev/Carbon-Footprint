import java.util.Scanner;

import javax.lang.model.util.Elements.Origin;

public class FootprintTracker {

    public FootprintTracker(){}

    private String recommendedModeOfTransport;
    private double totalActualEmissions; 
    private double totalRecommendedEmissions;
    private String currentModeOfTransport;
    private String location;
    private String origin;
    private String destination;
    private double distanceCovered;
    




    //main method
    public static void main(String args[]){
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
        do {
            System.out.print("Please enter your origin: ");
            origin = userInput.nextLine();
            
            if (origin.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid location.");
            }
        } while (origin.matches("\\d+"));
        System.out.println();



        //asking user to enter their destitnation location
        String destination;
        do {
            System.out.print("Enter a string: ");
            destination = userInput.nextLine();
            
            if (destination.matches("\\d+")) {
                System.out.println("Invalid input! Please enter a valid location.");
            }
        } while (destination.matches("\\d+"));
        System.out.println();



        //asking user to enter the mode of transport they want to use
        String modeName;
        do {
            System.out.print("Enter a string: ");
            modeName = userInput.nextLine();
            
            if (modeName.matches("\\d+")) {
                System.out.println("Invalid mode of transport. Please enter a valid mode of transport.");
            }
        } while (modeName.matches("\\d+"));

    }

}


        