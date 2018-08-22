package corejava.designpattern.adapter;

public class WildTurkey implements Turkey{

    @Override
    public void goble() {
        System.out.println("Gobble...");
    }

    @Override
    public void fly() {
        System.out.println("Fliessss...");
    }
}
