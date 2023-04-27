import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class ShortestDistance 
{
    
    public static void main(String args[]){
        

        Level1 bicycle = new Level1("Bicycle",0);
        Level1 walking = new Level1("Walking",0);
        Level1 scooter = new Level1("Scooter",0);


        Level2 motorbike = new Level2("Motorbike",0.18);
        Level2 bus = new Level2("Bus",0.29);
        Level2 car = new Level2("Car",0.17);
 
        Level3 train = new Level3("Train",0.17);
        Level3 ship = new Level3("Ship",193.066);
        Level3 airplane = new Level3("Airplane",0.42);

        String modeName="car";

        double distance= 211;


        ModesOfTransport recommendedModeOfTransport;
        ModesOfTransport intendedModeOfTransport;

        double percentageOfEmissionsSaved=0;

        List<Double> actualEmissionsList = new ArrayList<Double>();
        List<Double> recommendedEmissionsList = new ArrayList<Double>();



        if (modeName.equalsIgnoreCase("bicycle"))
        {
            intendedModeOfTransport=bicycle;
        }
        else if (modeName.equalsIgnoreCase("scooter"))
        {
            intendedModeOfTransport=scooter;
        }
        else if (modeName.equalsIgnoreCase("walking"))
        {
            intendedModeOfTransport=walking;
        }
        else if (modeName.equalsIgnoreCase("car"))
        {
            intendedModeOfTransport=car;
        }
        else if (modeName.equalsIgnoreCase("bus"))
        {
            intendedModeOfTransport=bus;
        }
        else if (modeName.equalsIgnoreCase("motorbike"))
        {
            intendedModeOfTransport=motorbike;
        }
        else if (modeName.equalsIgnoreCase("train"))
        {
            intendedModeOfTransport=train;
        }
        else if (modeName.equalsIgnoreCase("ship"))
        {
            intendedModeOfTransport=ship;
        }
        else if (modeName.equalsIgnoreCase("airplane"))
        {
            intendedModeOfTransport=airplane;
        }
        else
        {
            intendedModeOfTransport=null;
        }

        if (distance>0 && distance<=5)
        {
            recommendedModeOfTransport=walking.findLowestEmitter(scooter, bicycle, distance);

            if (recommendedModeOfTransport.getModeName().equalsIgnoreCase(modeName))
            {
                System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getModeName()+") you intend to use emits the least greenhouse gases.");
            }
            else
            {
                    percentageOfEmissionsSaved= 100;
                    actualEmissionsList.add(intendedModeOfTransport.computeEmission(distance));
                    recommendedEmissionsList.add(recommendedModeOfTransport.computeEmission(distance));
                    System.out.println("The mode of transport we recommend you use is "+ recommendedModeOfTransport.getModeName());
                    System.out.println("With this mode of transport"+recommendedModeOfTransport.getModeName()+", you will reduce carbon emissions by " +percentageOfEmissionsSaved + " %");
            }
        }
        else if (distance>5 && distance<=200)
        {
            recommendedModeOfTransport=motorbike.findLowestEmitter(car, bus, distance);

            if (recommendedModeOfTransport.getModeName().equalsIgnoreCase(modeName))
            {
                System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getModeName()+") you intend to use emits the lease greenhouse gases.");
            }
            else{
                if (intendedModeOfTransport != null) 
                {
                    if(intendedModeOfTransport.computeEmission(distance)>0)
                    {
                        percentageOfEmissionsSaved= Math.round(Math.abs(((intendedModeOfTransport.computeEmission(distance)-recommendedModeOfTransport.computeEmission(distance))/intendedModeOfTransport.computeEmission(distance))*100));
                        actualEmissionsList.add(intendedModeOfTransport.computeEmission(distance));
                        recommendedEmissionsList.add(recommendedModeOfTransport.computeEmission(distance));
                        System.out.println(recommendedModeOfTransport.computeEmission(distance)+"\n"+intendedModeOfTransport.computeEmission(distance));
                        System.out.println("The mode of transport we recommend you use is "+ recommendedModeOfTransport.getModeName());
                        System.out.println("With this mode of transport "+recommendedModeOfTransport.getModeName()+", you will reduce carbon emissions by " +percentageOfEmissionsSaved + " %");

                    }
                    else{
                        System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getModeName()+") you intend to use emits the least greenhouse gases.");
                    }

                } 
                else {
                    System.out.println("No valid intended mode of transport was specified");
                }
            }       
            
        }
        else if (distance>200 && distance<=1250)
        {
            recommendedModeOfTransport=train.findLowestEmitter(ship, airplane, distance);

            if (recommendedModeOfTransport.getModeName().equalsIgnoreCase(modeName))
            {
                System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getModeName()+") you intend to use emits the lease greenhouse gases.");
            }
            else{
                if (intendedModeOfTransport != null ) {
                    if(intendedModeOfTransport.computeEmission(distance)>0)
                    {
                        actualEmissionsList.add(intendedModeOfTransport.computeEmission(distance));
                        recommendedEmissionsList.add(recommendedModeOfTransport.computeEmission(distance));
                        percentageOfEmissionsSaved= Math.round(Math.abs(((intendedModeOfTransport.computeEmission(distance)-recommendedModeOfTransport.computeEmission(distance))/intendedModeOfTransport.computeEmission(distance))*100));
            
                        System.out.println("The mode of transport we recommend you use is "+ recommendedModeOfTransport.getModeName());
                        System.out.println("With this mode of transport "+recommendedModeOfTransport.getModeName()+", you will reduce carbon emissions by " +percentageOfEmissionsSaved + " %");
    
                    }
                    else{
                        System.out.println("Well done! The mode of transport("+ recommendedModeOfTransport.getModeName()+") you intend to use emits the least greenhouse gases.");
                    }
                } 
                else {
                    System.out.println("No valid intended mode of transport was specified");
                }


            }
        }

      

        double totalActualEmissions=0;
        double totalRecommendedEmissions=0;
        for (int i = 0; i < actualEmissionsList.size(); i++) {
            totalActualEmissions+=actualEmissionsList.get(i);

            totalRecommendedEmissions+=recommendedEmissionsList.get(i);
        }
        System.out.println("actual: "+totalActualEmissions+" \nrecommended: "+ totalRecommendedEmissions);
    }
}