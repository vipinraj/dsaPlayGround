package corejava.accesscontroll.subpackage;
import corejava.accesscontroll.Superclass;

 class Subclass2 extends Superclass {
    public void stubMethod() {
        protectedVaraible = 11;
        // variableWithoutModifier = 1; --non accessable
        // privateVariable = 1; -- non accessable
    }
}
