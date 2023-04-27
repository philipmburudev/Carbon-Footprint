import java.lang.Math;

/**
 * Represents a mode of transportation and its emissions and minimum and maximum distance covered.
 */
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

    /**
     * Returns the name of the transportation mode.
     * @return the name of the transportation mode
     */
    public String getTransportMode() {
        return transportMode;
        
    }
    /**
     * Sets the name of the transportation mode.
     * @param transportMode the name of the transportation mode
     */
    public void settransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    /**
     * Returns the emissions per mile of the transportation mode.
     * @return the emissions per mile of the transportation mode
     */
    public double getEmissionPerMile() {
        return emissionPerMile;
    }

    /**
     * Sets the emissions per mile of the transportation mode.
     * @param emissionPerMile the emissions per mile of the transportation mode
     */
    public void setEmissionPerMile(double emissionPerMile) {
        this.emissionPerMile = emissionPerMile;
    }


    /**
     * Returns the maximum distance that can be covered by the transportation mode.
     * @return the maximum distance that can be covered by the transportation mode
     */
    public double getMaxDistanceCovered() {
        return maxDistanceCovered;
    }


   /**
     * Sets the maximum distance that can be covered by the transportation mode.
     * @param maxDistanceCovered the maximum distance that can be covered by the transportation mode
     */
    public void setMaxDistanceCovered(double maxDistanceCovered) {
        this.maxDistanceCovered = maxDistanceCovered;
    }


    /**
     * Returns the minimum distance that can be covered by the transportation mode.
     * @return the minimum distance that can be covered by the transportation mode
     */    
    public double getMinDistanceCovered() {
        return minDistanceCovered;
    }

    /**
     * Sets the minimum distance that can be covered by the transportation mode.
     * @param minDistanceCovered the minimum distance that can be covered by the transportation mode
     */
    public void setMinDistanceCovered(double minDistanceCovered) {
        this.minDistanceCovered = minDistanceCovered;
    }

    /**
     * Calculates the emissions for a given distance.
     * @param distance the distance traveled
     * @return the emissions for the given distance
     */
    public double computeEmission(double distance)
    {
        return Math.round(distance*this.emissionPerMile);
    }

    /**
     * Finds the transportation mode that emits the least amount of emissions for a given distance.
     * @param mode1 A mode of transport which will vary depending on the level
     * @param mode2 A mode of transport which will vary depending on the level
     * @param distanceCovered The distance to be covered by the user depending on the locations they specified
     * @return The mode of transport that emits the least emissions
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


