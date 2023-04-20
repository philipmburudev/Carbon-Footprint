public abstract class ModesOfTransport{
    private double modeName;
    private double emissionPerMile;
    
    public ModesOfTransport(double modeName, double emissionPerMile)
    {
        this.modeName=modeName;
        this.emissionPerMile=emissionPerMile;
    }

    public double getModeName() {
        return modeName;
    }

    public double getEmissionPerMile() {
        return emissionPerMile;
    }



}


