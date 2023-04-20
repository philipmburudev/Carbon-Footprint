public class Level1 extends ModesOfTransport{


    Level1(){}
   
    public Level1(double modeName, double emissionPerMile,double maxDistanceCovered,double minDistanceCovered)
    {
        super(modeName, emissionPerMile,0 ,5 );
        
   }

    
     
   
    public void setEmissionPerMile(double emissionPerMile){
        this.emissionPerMile = emissionPerMile;
    }


    public static void main(String[] args) {
        Level1 walking = new Level1();
        walking.setEmissionPerMile(10);
        
        
    }

   




    
}
