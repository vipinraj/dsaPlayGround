package corejava.designpattern;
// eager initialization
public class Singleton4Test {
    public static void main(String[] args) {
        // single thread, works fine
        //Singleton1 obj = Singleton1.getInstance();
        //System.out.println(obj.hashCode());
        
        // with threads, works fine
        Thread t1 = new Thread() {
            Singleton4 obj;
            public void run() {
                obj = Singleton4.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        Thread t2 = new Thread() {
            Singleton4 obj;
            public void run() {
                obj = Singleton4.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        t1.start();
        t2.start();
        
    }
}

class Singleton4 {
    private static final Singleton4 object = new Singleton4();

    private Singleton4() {}
    
    public static Singleton4 getInstance() {        
        return object;
    }
}