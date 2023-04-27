

// This class is a subclass of ModesOfTransport and represents the level 2 modes of transport
public class Level2 extends ModesOfTransport {


    //constructor to initialize the variables of Level2 class
    public Level2(String transportMode, double emissionPerMile)
    {
        //super keyword is used to call the constructor of the parent class
        super(transportMode, emissionPerMile,5 ,200 );
    }

    
    
}
