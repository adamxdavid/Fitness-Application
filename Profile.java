public class Profile {
    private int age;
    private double height;
    private double weight;
    private Gender gender;

    public Profile(int age, double height, double weight, Gender gender) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;

    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWeight() {
        return this.weight;
    }

    public int getAge() {
        return this.age;
    }

    public Gender getGender() {
        return this.gender;
    }

    @Override 
    public String toString() {
        String strHeight = String.format("%.1f", this.height);
        return "Age " + this.age + ", Weight " + this.weight + "kg, Height " + strHeight + "m, Gender " + this.gender;
    }

    public double calcBMI() {
        return this.weight/(this.height * this.height);
    }

    public double dailyCalorieIntake() {
        if (this.gender == Gender.MALE) {
            return 66.47 + (13.75 * this.weight) + (5.003 * (this.height*100)) - (6.755 * this.age);
        }
        else {
            return 655.1 + ( 9.563 * this.weight ) + ( 1.85 * (this.height * 100) ) - ( 4.676 * this.age);
        }
    }
}
