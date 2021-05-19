import java.util.ArrayList;

abstract class Pizza 
{
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    public String getName() {
        return name;
    }

    public void prepare() {
        System.out.println("Preparing " + name);
    }

    public void bake() {
        System.out.println("Baking...");
    }

    public void cut() {
        System.out.println("Cutting...");
    }

    public void box() {
        System.out.println("Boxing...");
    }

    public String toString() 
    {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (int i = 0; i < toppings.size(); i++) {
            display.append((String) toppings.get(i) + "\n");
        }
        return display.toString();
    }
}

class CheesePizza extends Pizza 
{
    public CheesePizza(String st) 
    {
        name = st+" Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
    }
}

class VeggiePizza extends Pizza {
    public VeggiePizza() {
        name = "Veggie Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Shredded mozzarella");
        toppings.add("Grated parmesan");
        toppings.add("Diced onion");
    }
}

class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
    }
}
class SimplePizzaFactory 
{
    public Pizza createPizza(String type, String style) 
    {
        Pizza pizza = null;
        String st=style;
        if (type.equals("cheese")) 
        {
            pizza = new CheesePizza(st);
        } 
        else if (type.equals("pepperoni")) 
        {
            pizza = new PepperoniPizza();
        } 
        else if (type.equals("veggie")) 
        {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
class PizzaStore 
{
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type, String style) 
    {    
    	Pizza pizza = factory.createPizza(type,style);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}

public class PizzaTestDrive{
	public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese","NyStyle");
        System.out.println(pizza.getName() + " delivered to Harry\n");

        pizza = store.orderPizza("cheese","ChicagoStyle");
        System.out.println(pizza.getName() + " delivered to Ron");
    }
}
