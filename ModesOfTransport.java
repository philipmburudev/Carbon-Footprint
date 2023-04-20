public class ModesOfTransport{
    protected String modeName;
    protected double emissionPerMile;
    protected double maxDistanceCovered;
    protected double minDistanceCovered;

    public ModesOfTransport(){};

    
    public ModesOfTransport(String modeName, double emissionPerMile,double maxDistanceCovered,double minDistanceCovered)
    {
        this.modeName=modeName;
        this.emissionPerMile=emissionPerMile;
        this.maxDistanceCovered=maxDistanceCovered;
        this.minDistanceCovered=minDistanceCovered;
    }

    public String getModeName() {
        return modeName;
    }


    public void setModeName(String modeName) {
        this.modeName = modeName;
    }


    public double getEmissionPerMile() {
        return emissionPerMile;
    }


    public void setEmissionPerMile(double emissionPerMile) {
        this.emissionPerMile = emissionPerMile;
    }


    public double getMaxDistanceCovered() {
        return maxDistanceCovered;
    }


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

   
    public double computeEmission(double distance, double emissionPerMile)
    {
        return distance*emissionPerMile;
    }


}


