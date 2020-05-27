package PizzaOrder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PizzaOrderTest {

    @Test
    public void testOneOrder(){
        Pizza p1 = new Pizza();
        p1.setName("Prosciutto");
        p1.setPrice(6.50);
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(p1);
        Assert.assertEquals(6.50, ShoppingCart.calculateTotalPrice(pizzas,2),0.00001);
    }

    @Test
    public void testZeroOrder(){
        List<Pizza> pizzas = new ArrayList<>();
        Assert.assertEquals(0, ShoppingCart.calculateTotalPrice(pizzas,2),0.00001);
    }

    @Test
    public void testTwoOrder(){
        Pizza p1 = new Pizza();
        p1.setName("Prosciutto");
        p1.setPrice(6.50);
        Pizza p2 = new Pizza();
        p2.setName("Funghi & Prosciutto");
        p2.setPrice(7.80);
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(p1);
        pizzas.add(p2);
        Assert.assertEquals(7.80, ShoppingCart.calculateTotalPrice(pizzas,2),0.00001);
    }

    @Test
    public void testFiveOrderEveryThirdIsFree(){
        Pizza p1 = new Pizza();
        p1.setName("Prosciutto");
        p1.setPrice(6.50);
        Pizza p2 = new Pizza();
        p2.setName("Funghi & Prosciutto");
        p2.setPrice(7.80);
        Pizza p3 = new Pizza();
        p3.setName("Parma");
        p3.setPrice(12.00);
        Pizza p4 = new Pizza();
        p4.setName("Margherita");
        p4.setPrice(5.00);
        Pizza p5 = new Pizza();
        p5.setName("Kebap pizza");
        p5.setPrice(8.00);
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(p1);
        pizzas.add(p2);
        pizzas.add(p3);
        pizzas.add(p4);
        pizzas.add(p5);
        Assert.assertEquals(34.3, ShoppingCart.calculateTotalPrice(pizzas,3),0.00001);
    }

    @Test
    public void testTwoOrderEverythingIsFree(){
        Pizza p1 = new Pizza();
        p1.setName("Prosciutto");
        p1.setPrice(6.50);
        Pizza p2 = new Pizza();
        p2.setName("Funghi & Prosciutto");
        p2.setPrice(7.80);
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(p1);
        pizzas.add(p2);
        Assert.assertEquals(0, ShoppingCart.calculateTotalPrice(pizzas,1),0.00001);
    }

}

