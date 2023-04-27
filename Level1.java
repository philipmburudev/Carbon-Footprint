public class Level1 extends ModesOfTransport{


    public Level1(){}
   
    public Level1(String modeName, double emissionPerMile)
    {
        super(modeName, emissionPerMile,0 ,5 );
    }

    
    public void setEmissionPerMile(double emissionPerMile){
        this.emissionPerMile = emissionPerMile;
    }
    
}
