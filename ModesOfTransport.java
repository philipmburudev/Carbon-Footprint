import java.lang.Math;

//declaring the class ModesOfTransport and its instance variables
public class ModesOfTransport{
    protected String transportMode;
    protected double emissionPerMile;
    protected double maxDistanceCovered;
    protected double minDistanceCovered;
  

    //constructor to initialize the variables
    public ModesOfTransport(String transportMode, double emissionPerMile,double minDistanceCovered,double maxDistanceCovered)
    {

        this.transportMode=transportMode;
        this.emissionPerMile=emissionPerMile;
        this.maxDistanceCovered=maxDistanceCovered;
        this.minDistanceCovered=minDistanceCovered;
    }

    //method to get the mode name
    public String getTransportMode() {
        return transportMode;
        
    }

    //method to set the mode name
    public void settransportMode(String transportMode) {
        this.transportMode = transportMode;
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



    //method to calculate the emission
    public double computeEmission(double distance)
    {
        return Math.round(distance*this.emissionPerMile);
    }

    /**
     * Finds the transportation mode that emits the least amount of emissions for a given distance.
     * @param mode1 A mode of transport which will vary depending on the level
     * @param mode2 A mode of transport which will vary depending on the level
     * @param distanceCovered The distance to be covered by the user depending on the locations they specified
     * @return
     */
    public ModesOfTransport findLowestEmitter(ModesOfTransport mode1,ModesOfTransport mode2, double distanceCovered)
    {
        if(this.computeEmission(distanceCovered)<mode1.computeEmission(distanceCovered) && this.computeEmission(distanceCovered)<mode2.computeEmission(distanceCovered))
        {
            return this;
        }
        else if(mode1.computeEmission(distanceCovered)<this.computeEmission(distanceCovered) && mode1.computeEmission(distanceCovered)<mode2.computeEmission(distanceCovered))
        {
            return mode1;
        }

        return mode2;
        
    }

}


