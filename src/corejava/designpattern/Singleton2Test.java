package corejava.designpattern;
// with synchronized method
// Problem: every call to getInstance method is synchronized.
// Once the object is created, subsequent calls does not require synchronized
public class Singleton2Test {
    public static void main(String[] args) {
        // single thread, works fine
        //Singleton1 obj = Singleton1.getInstance();
        //System.out.println(obj.hashCode());
        
        // with threads, works
        Thread t1 = new Thread() {
            Singleton2 obj;
            public void run() {
                obj = Singleton2.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        Thread t2 = new Thread() {
            Singleton2 obj;
            public void run() {
                obj = Singleton2.getInstance();
                System.out.println(obj.hashCode());
            }
        };
        
        t1.start();
        t2.start();
        
    }
}

class Singleton2 {
    private static Singleton2 object;

    private Singleton2() {}
    
    public static synchronized Singleton2 getInstance() {

        if (object == null) {

            System.out.println("object is null: ");
            System.out.println(Thread.currentThread().getId());
            object = new Singleton2();
        }
        
        return object;
    }
}