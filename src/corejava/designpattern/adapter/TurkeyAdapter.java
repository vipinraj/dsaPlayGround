package corejava.designpattern.adapter;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quak() {
        this.turkey.goble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 3; i++) {
            turkey.fly();
        }
    }
}
