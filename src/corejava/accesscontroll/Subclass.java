package corejava.accesscontroll;

public class Subclass extends Superclass {
    public void stubMethod() {
        protectedVaraible = 11;
        variableWithoutModifier = 1;
        // privateVariable = 1; -- non accessable
    }

}
