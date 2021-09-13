import java.util.ArrayList;

public class DailyExercise {
    private ArrayList <Fitness> exerciseList;
    private int duration;
    private double calorieTarget;
    private Profile profile;

    public DailyExercise(ArrayList<Fitness> exerciseList, int duration, double calorieTarget, Profile profile) {
        this.exerciseList = exerciseList;
        this.duration = duration;
        this.calorieTarget = calorieTarget;
        this.profile = profile;
    }

    public DailyExercise(ArrayList<Fitness> exerciseList, Profile profile) {
        this.exerciseList = exerciseList;
        this.profile = profile;
        this.calorieTarget = 500;
        this.duration = 60;
    }

    public void addExercise(Fitness ex) {
        exerciseList.add(ex);
    }

    /*
    * searches different exercises in list using description method and removes if the same
    * @param Fitness, it is an exercise type like Yoga
    * 
    */
    public void removeExercise(Fitness ex) {
        for (int i = 0; i < this.exerciseList.size(); ++i) {
            if (ex.description() == this.exerciseList.get(i).description()) {
                this.exerciseList.remove(i);
                break;
            }
        }
    }

    public void setExerciseList(ArrayList<Fitness> list) {
        this.exerciseList = list;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setCalorieTarget(double target) {
        this.calorieTarget = target;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ArrayList<Fitness> getExerciseList() {
        return this.exerciseList;
    }

    public int getDuration() {
        return this.duration;
    }

    public double getCalorieTarget() {
        return this.calorieTarget;
    }

    public Profile getProfile() {
        return this.profile;
    }

    /*
    * this looks through list of exercises to see which exercises meet minimum requirements based
    * on which muscles they activate
    * @param Muscle [] targetMuscle, it takes an array of Muscles that need to be activated in exercise
    * @return null, this is if there are no exercises that meet standards
    * @return qualifiedArray, this is the array of approved exercises
    */
    public Fitness[] getExercises(Muscle[] targetMuscle) {
        //making the list that the qualified exercises will go into
        int i;
        int j;
        int k;

        ArrayList <Fitness> qualifiedExercises = new ArrayList<Fitness>();
        int counter = 0;

        for (i = 0; i < exerciseList.size(); ++i) {
            for (j = 0; j < targetMuscle.length; ++j) {
                for (k = 0; k < exerciseList.get(i).muscleTargeted().length; ++k) {
                    if (exerciseList.get(i).muscleTargeted()[k] == targetMuscle[j]) {
                        counter++;
                        break;
                    }
                }
            }
            if (counter == targetMuscle.length) {
                qualifiedExercises.add(exerciseList.get(i));
            }
            counter = 0;
        }

        Fitness[] qualifiedArray = new Fitness[qualifiedExercises.size()];

        if (qualifiedArray.length == 0) {
            return null;
        }

        //adding exercisies to qualified exercises
        for (i = 0; i < qualifiedExercises.size(); ++i) {
            qualifiedArray[i] = qualifiedExercises.get(i);
        }

        return qualifiedArray;


    }



}
