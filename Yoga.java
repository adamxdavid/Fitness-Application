public class Yoga extends Flexibility {
    private Muscle[] muscle = {Muscle.Triceps, Muscle.Biceps};

    @Override 
    public String description() {
        return "Yoga";
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
    //returns the total amount of calorie burnt by the exercise, factors (bodyweight & minutes)
    public double calorieLoss(Intensity intensity, double weight, int duration) {
        double met = 1;
        double result;
        double hours;

        switch (intensity) {
            case HIGH:
                met = 4.0;
                break;
            case MEDIUM:
                met = 3.0;
                break;
            case LOW:
                met = 2.0;
                break;
        }

        result = met * weight;
        hours = duration/60.0;
        result = result * hours;
        return result;
    }
    
}
