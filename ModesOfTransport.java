import javax.print.attribute.standard.Destination;

public class ModesOfTransport{
    protected String modeName;
    protected double emissionPerMile;
    protected double maxDistanceCovered;
    protected double minDistanceCovered;
  

    //default constructor for creating an object
    public ModesOfTransport(){};


    //constructor to initialize the variables
    public ModesOfTransport(String modeName, double emissionPerMile,double minDistanceCovered,double maxDistanceCovered)
    {
        this.modeName=modeName;
        this.emissionPerMile=emissionPerMile;
        this.maxDistanceCovered=maxDistanceCovered;
        this.minDistanceCovered=minDistanceCovered;
    }

    //method to get the mode name
    public String getModeName() {
        return modeName;
    }

    //method to set the mode name
    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    //method to get the emission per mile
    public double getEmissionPerMile() {
        return emissionPerMile;
    }

    //method to set the emission per mile
    public void setEmissionPerMile(double emissionPerMile) {
        this.emissionPerMile = emissionPerMile;
    }

    //method to get the maximum distance covered
    public double getMaxDistanceCovered() {
        return maxDistanceCovered;
    }

    //method to set the maximum distance covered
    public void setMaxDistanceCovered(double maxDistanceCovered) {
        this.maxDistanceCovered = maxDistanceCovered;
    }


    
    //method to get the minimum distance covered
    public double getMinDistanceCovered() {
        return minDistanceCovered;
    }

    //method to set the minimum distance covered
    public void setMinDistanceCovered(double minDistanceCovered) {
        this.minDistanceCovered = minDistanceCovered;
    }

  

//calculate the distance between two cities
    // int accra = 0;
    // int kumasi = 200;
    // int distance;
    // int bicycle;
    
     
    // public int distance(){
    //     distance = kumasi - accra;
    //     return distance;
    // }


    //method to calculate the emission
    public double computeEmission(double distance)
    {
        return distance*this.emissionPerMile;
    }



}


