/*
* this is a custom exception
*/

public class TargetWeightException extends RuntimeException{
    public TargetWeightException() {
        super("Only works to lose weight");
    }
    
}
