import javax.print.attribute.standard.Destination;
import java.lang.Math;

//declaring the class ModesOfTransport and its instance variables
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



    //method to calculate the emission
    public double computeEmission(double distance)
    {
        return Math.round(distance*this.emissionPerMile);
    }


    //method to find the lowest emitter
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


