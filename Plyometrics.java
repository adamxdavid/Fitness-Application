public class Plyometrics extends Anaerobic {
    private Muscle[] muscle = {Muscle.Abs, Muscle.Legs, Muscle.Glutes};

    @Override 
    public String description() {
        return "Plyometrics";
    }

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
                met = 7.4;
                break;
            case MEDIUM:
                met = 4.8;
                break;
            case LOW:
                met = 2.5;
                break;
        }


        result = met * weight;
        hours = duration/60.0;
        result = result * hours;
        return result;
    }


}
