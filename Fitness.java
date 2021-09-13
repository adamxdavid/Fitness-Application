/* This is the main interface for the various subclasses
*
*
*/

public interface Fitness {
    //returns the muscle that is going to be affected by the fitness
    public Muscle[] muscleTargeted();

    //returns the total amount of calorie burnt by the exercise, factors (bodyweight & minutes)
    public double calorieLoss(Intensity intensity, double weight, int duration);

    //returns a short decription of the fitness type.
    public String description();




}