public class ModesOfTransport{
    protected double modeName;
    protected double emissionPerMile;
    protected double maxDistanceCovered;
    protected double minDistanceCovered;

    ModesOfTransport(){};

    
    public ModesOfTransport(double modeName, double emissionPerMile,double maxDistanceCovered,double minDistanceCovered)
    {
        this.modeName=modeName;
        this.emissionPerMile=emissionPerMile;
    }





    public double getModeName() {
        return modeName;
    }


    public void setModeName(double modeName) {
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

   


}


