public class Swimming extends Aerobic{
    private SwimmingType type;

    //contructer
    public Swimming(SwimmingType type) {
        //enum swimming type
        this.type = type;
    }

    //constructer, defaults to freestyle
    public Swimming() {
        this.type = SwimmingType.Freestyle;
    }

    public void setSwimmingType(SwimmingType type) {
        //sets enum swimming type to the parameter
        this.type = type;
    }

    //returns swimming type
    public SwimmingType getSwimmingType() {
        //gets swimming type
        return this.type;
    }

    //just returns "class name"
    @Override 
    public String description() {
        return "Swimming";
    }
    /*
    *depending on value of this.type, will return different lists of muscles
    * @return Muscle[] muscle, returns list of muscles
    */
    @Override 
    public Muscle[] muscleTargeted() {
        switch (this.type) {
            case Butterflystroke:
                Muscle[] muscle1 = {Muscle.Abs, Muscle.Back, Muscle.Shoulders, Muscle.Biceps, Muscle.Triceps};
                return muscle1;
            case Breaststroke:
                Muscle[] muscle2 = {Muscle.Glutes, Muscle.Cardio};
                return muscle2;
            case Freestyle:
                Muscle[] muscle3 = {Muscle.Arms, Muscle.Legs, Muscle.Cardio};
                return muscle3;
        }
        //returns empty muscle list if for some reason none of cases apply
        Muscle[] muscle = {};
        return muscle;
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
                met = 10.0;
                break;
            case MEDIUM:
                met = 8.3;
                break;
            case LOW:
                met = 6.0;
                break;
            }
        result = met * weight;

        hours = duration/60.0;

        result = result * hours;

        return result;
    }



    
















}
