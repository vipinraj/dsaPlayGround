package corejava.designpattern;

public class Singleton1Test {
    public static void main(String[] args) {
        // single thread, works fine
        //Singleton1 obj = Singleton1.getInstance();
        //System.out.println(obj.hashCode());
        
        // with threads, faulty
        Thread t1 = new Thread() {
            Singleton1 obj;
            public void run() {
                obj = Singleton1.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        Thread t2 = new Thread() {
            Singleton1 obj;
            public void run() {
                obj = Singleton1.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        t1.start();
        t2.start();
        
    }
}

class Singleton1 {
    private static Singleton1 object;

    private Singleton1() {}
    
    public static Singleton1 getInstance() {

        if (object == null) {

            System.out.println("object is null: ");
            System.out.println(Thread.currentThread().getId());
            object = new Singleton1();
        }
        
        return object;
    }
}