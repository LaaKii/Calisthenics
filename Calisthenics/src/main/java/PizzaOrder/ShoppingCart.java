package PizzaOrder;

import java.util.Comparator;
import java.util.List;

public class ShoppingCart {

    /*
        @param discount -> Contains discount. E.q. if value = 2 -> Order 2 and the cheapest will be for free
     */
    public static double calculateTotalPrice(List<Pizza> orders, int discount){
        if (orders.size()==0){
            return 0;
        }
        int ordersToSubtract = orders.size() / discount;
        double totalPrice =0;
        orders.sort(Comparator.comparingDouble(Pizza::getPrice).reversed());
        for(int i = 0; i<orders.size()-ordersToSubtract;i++){
            totalPrice+=orders.get(i).getPrice();
        }
        return totalPrice;
    }
}
