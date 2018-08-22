package corejava.designpattern.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        Duck duck = new TurkeyAdapter(new WildTurkey());
        duck.quak();
    }
}
