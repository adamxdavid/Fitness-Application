public class WeightLifting extends Anaerobic{
    private Muscle[] muscle = {Muscle.Shoulders, Muscle.Legs, Muscle.Arms, Muscle.Triceps};

    @Override 
    public String description() {
        return "WeightLifting";
    }

    //will return lists of muscles
    @Override 
    public Muscle[] muscleTargeted() {
        return this.muscle;
    }

    /*
    *
    * @param duration, tells you in mins how the time of exercise
    * @param intensity, this increases or decreases calories burned
    * @return result, the total amount of calories burned
    */
    @Override 
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        double met = 1;
        double result;
        double hours;

        switch (intensity) {
            case HIGH:
                met = 6.0;
                break;
            case MEDIUM:
                met = 5.0;
                break;
            case LOW:
                met = 3.5;
                break;
        }


        result = met * weight;
        hours = duration/60.0;
        result = result * hours;
        return result;
    }



}
