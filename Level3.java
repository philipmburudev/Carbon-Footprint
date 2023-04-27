
/**
 * This class is a subclass of ModesOfTransport and represents the third level of transport modes.
 */
public class Level3 extends ModesOfTransport{

    /**
     * Constructs a new Level3 object with the given transport mode and emission per mile.
     * @param transportMode the name of the transportation mode
     * @param emissionPerMile the emissions per mile of the transportation mode
     */
    public Level3(String transportMode, double emissionPerMile)
    {
        //super keyword is used to call the constructor of the parent class
        super(transportMode, emissionPerMile,200 ,1250 ); 
    }

    
}
