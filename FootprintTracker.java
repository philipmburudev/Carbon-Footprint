import java.util.Scanner;

public class FootprintTracker {

    public FootprintTracker(){}

    private String recommendedModeOfTransport;
    private double totalActualEmissions; 
    private double totalRecommendedEmissions;
    private String location;
    private String origin;
    private String destination;
    private double distance;
    
    public static void main(String args[])
    {
        Scanner userInput= new Scanner(System.in);

        
        Level1 bicycle = new Level1("Bicycle",0);
        Level1 walking = new Level1("Walking",0);
        Level1 scooter = new Level1("Scooter",0);
        System.out.println();
        System.out.println("The modes of transport in level 1 are: \n" + scooter.getModeName()+"\n"
                                                                       + bicycle.getModeName()+"\n"
                                                                       + walking.getModeName()
                                                                       );
        //System.out.println("The modes of transport in level 1 are: " + Level1);

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

    }


}
