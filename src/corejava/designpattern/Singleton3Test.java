package corejava.designpattern;
// with synchronized block
// Efficient
public class Singleton3Test {
    public static void main(String[] args) {
        // single thread, works fine
        //Singleton1 obj = Singleton1.getInstance();
        //System.out.println(obj.hashCode());
        
        // with threads, works fine
        Thread t1 = new Thread() {
            Singleton3 obj;
            public void run() {
                obj = Singleton3.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        Thread t2 = new Thread() {
            Singleton3 obj;
            public void run() {
                obj = Singleton3.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        t1.start();
        t2.start();
        
    }
}

class Singleton3 {
    private static Singleton3 object;

    private Singleton3() {}
    
    public static Singleton3 getInstance() {

        if (object == null) {
            synchronized(Singleton3.class) {
                if (object == null) {
                    System.out.println("object is null: ");
                    System.out.println(Thread.currentThread().getId());
                    object = new Singleton3();                 
                }
            }
        }
        
        return object;
    }
}