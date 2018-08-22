package corejava.designpattern.adapter;

public class MallardDuck implements Duck {
    @Override
    public void quak() {
        System.out.println("Quak");
    }

    @Override
    public void fly() {
        System.out.println("Flying...");
    }
}
