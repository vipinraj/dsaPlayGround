package corejava.designpattern.factory;

public class TestsPizzaStors {
    public static void main(String[] args) {
        NYPizzaStore nyStore = new NYPizzaStore();
        ChicagoPizzaStore chStore = new ChicagoPizzaStore();
        
        Pizza nyCheese = nyStore.orderPizza("cheese");
        Pizza nyPep = nyStore.orderPizza("pepperoni");
        Pizza chCheese = chStore.orderPizza("cheese");
        Pizza chpep = chStore.orderPizza("pepperoni");
        System.out.println(nyCheese.getName());
        System.out.println(nyPep.getName());
        System.out.println(chCheese.getName());
        System.out.println(chepo.getName());
    }
}
