import java.util.ArrayList;

public class WeeklyExercise {
    private ArrayList <Fitness> exerciseList;
    private int days;
    private double weeklyCalorieTarget;
    private Profile profile;
    /*
    * A constructor, which accepts the list of daily exercises, number of days to workout per week , the amount of calories to be burnt, and a profile of a user.
    * @param exerciselist, this is just a list of exercises
    * @param days, amnt of times to work out per week
    * @param weeklycalorieTarget, the amount of calories person wants to burn
    * @param profile, a profile object thats stores attributes of person
    */
    public WeeklyExercise(ArrayList<Fitness> exerciseList, int days, double weeklyCalorieTarget, Profile profile) {
        this.exerciseList = exerciseList;
        this.days = days;
        this.weeklyCalorieTarget = weeklyCalorieTarget;
        this.profile = profile;
        
    }

    /*
    * A constructor, which accepts the list of daily exercises, and a profile of a user.
    * @param exerciselist, this is just a list of exercises
    * @param profile, a profile object thats stores attributes of person
    */
    public WeeklyExercise(ArrayList<Fitness> exerciseList, Profile profile) {
        this.exerciseList = exerciseList;
        this.profile = profile;
        this.days = 7;
        this.weeklyCalorieTarget = 3500;
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

    public void setDays(int days) {
        this.days = days;
    }

    public void setWeeklyCalorieTarget(double target) {
        this.weeklyCalorieTarget = target;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public ArrayList<Fitness> getExerciseList() {
        return this.exerciseList;
    }

    public int getDays() {
        return this.days;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public double getWeeklyCalorieTarget() {
        return this.weeklyCalorieTarget;
    }



    /*
    * Calculates a list of DailyExercise objects ffor the set amount of days
    * finds duration using FITNESS's calorieloss method
    * @param intensity, this is a modifier that can increase of decrease calories burnt
    * @return weeklyExercises, this will return a list of daily exercise objects
    */
    public ArrayList<DailyExercise> getWeeklyExercises(Intensity intensity) {
        double caloriesPerDay;
        int i;
        ArrayList <DailyExercise> weeklyExercise = new ArrayList<DailyExercise>();
        caloriesPerDay = this.weeklyCalorieTarget/this.days;

        for (i = 0; i < this.days; ++i) {
            //finding the duration in order to pass into the DailyExercise object
            double result = exerciseList.get(i).calorieLoss(intensity, this.profile.getWeight(), 60);
            double ratio = caloriesPerDay / result;
            int calculatedDuration = (int) (60 * ratio);

            //this calculated duration, will be passed into daily exercise for a correct calorieLoss.
            ArrayList <Fitness> singularArrayList = new ArrayList<Fitness>();
            singularArrayList.add(exerciseList.get(i));
            DailyExercise d = new DailyExercise(this.exerciseList, calculatedDuration, caloriesPerDay, this.profile);
            weeklyExercise.add(d);
        }




        return weeklyExercise;
    }









    /*
    * Calculates a list of DailyExercise objects ffor the set amount of days
    * finds duration using FITNESS's calorieloss method
    * @param intensity, this is a modifier that can increase of decrease calories burnt
    * @return weeklyExercises, this will return a list of daily exercise objects
    */
    public ArrayList<DailyExercise>getWeeklyExercises() {
        double caloriesPerDay;
        int i;
        ArrayList <DailyExercise> weeklyExercise = new ArrayList<DailyExercise>();
        caloriesPerDay = this.weeklyCalorieTarget/this.days;

        for (i = 0; i < this.days; ++i) {
            //finding the duration in order to pass into the DailyExercise object
            double result = exerciseList.get(i).calorieLoss(Intensity.LOW, this.profile.getWeight(), 60);
            double ratio = caloriesPerDay / result;
            int calculatedDuration = (int) (60 * ratio);

            //this calculated duration, will be passed into daily exercise for a correct calorieLoss.
            ArrayList <Fitness> singularArrayList = new ArrayList<Fitness>();
            singularArrayList.add(exerciseList.get(i));
            DailyExercise d = new DailyExercise(this.exerciseList, calculatedDuration, caloriesPerDay, this.profile);
            weeklyExercise.add(d);
        }




        return weeklyExercise;
    }

    /*
    * Calculates a plan in order to acheive a target weight within certain days
    * @param targetWeight, this how many KGs the user wants to be at
    * @param withInDays, determines how long the plan lasts for
    * @return a string detailing a plan for how many calories they need to lose
    */
    public String targetedCalorieLoss(double targetWeight, int withInDays) throws RuntimeException{
        if (targetWeight > this.profile.getWeight()) {
            throw new TargetWeightException();
        }

        //how much kg they want to lose
        double shedKG = this.profile.getWeight() - targetWeight;

        //total calories they need to lose
        double totalCaloriesToLose = shedKG * 7000;

        //how many calories per day to reach goal
        double caloriesToLosePerDay = totalCaloriesToLose / withInDays;

        //calculate how much to lower their intake to
        double intake = this.profile.dailyCalorieIntake();
        double reducedIntake = intake - caloriesToLosePerDay;

        //formatting, rounding the decimals
        String strcaloriesToLosePerDay= String.format("%.02f", caloriesToLosePerDay);
        String strintake= String.format("%.02f", intake);
        String strreducedIntake= String.format("%.02f", reducedIntake);
        String strshedKG= String.format("%.02f", shedKG);

        return "You need to lose "+ strcaloriesToLosePerDay +" calories per day or decrease your intake from "+ strintake +" to "+ strreducedIntake +" in order to lose "+ strshedKG +" kg of weight";
    }





}
