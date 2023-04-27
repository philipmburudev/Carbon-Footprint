

// This class is a subclass of ModesOfTransport and represents the third level of transport modes
public class Level3 extends ModesOfTransport{


    //constructor to initialize the variables of Level3 class
    public Level3(String transportMode, double emissionPerMile)
    {
        //super keyword is used to call the constructor of the parent class
        super(transportMode, emissionPerMile,200 ,1250 ); 
    }

    
}
