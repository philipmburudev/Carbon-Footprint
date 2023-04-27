    /**
     * Constructs a new Level3 object with the given transport mode and emission per mile.
     * @param transportMode the name of the transportation mode
     * @param emissionPerMile the emissions per mile of the transportation mode
     */

public class Level1 extends ModesOfTransport{


    /**
     * Constructs a new Level1 object with the given transport mode and emission per mile.
     * @param transportMode the name of the transportation mode
     * @param emissionPerMile the emissions per mile of the transportation mode
     */
    public Level1(String transportMode, double emissionPerMile)
    {
        //super keyword is used to call the constructor of the parent class
        super(transportMode, emissionPerMile,0 ,5 );
    }
    
}
