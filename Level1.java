<<<<<<< HEAD
//java documentation








=======
>>>>>>> 2fe7aa1b31b42c8fd7d7c5ceacddc41faed66f4e
//declaring the class Level1 and its instance variables. Level1 inherits from ModesOfTransport

public class Level1 extends ModesOfTransport{


    //constructor to initialize the variables of Level1 class
    public Level1(String transportMode, double emissionPerMile)
    {
        //super keyword is used to call the constructor of the parent class
        super(transportMode, emissionPerMile,0 ,5 );
    }
    
}
