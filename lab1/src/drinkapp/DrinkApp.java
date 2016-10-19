package drinkapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Steven
 */
public class DrinkApp {
    public static void main(String[] args) {
        Drink latte = new Drink("latte");
        latte.setDrinkCostPrice(2.00);
        latte.setDrinkSellPrice(3.50);
        latte.setDrinkQuantitySold(30);
        
        Drink mocca = new Drink("mocca");
        mocca.setDrinkCostPrice(2.00);
        mocca.setDrinkSellPrice(4.00);
        mocca.setDrinkQuantitySold(20);
        
        Drink espresso = new Drink("espresso");
        espresso.setDrinkCostPrice(1.00);
        espresso.setDrinkSellPrice(3.00);
        espresso.setDrinkQuantitySold(20);
        
        mocca.updateQuantitySold(10);

        System.out.println(latte.toString());
        System.out.println(mocca.toString());
        System.out.println(espresso.toString());
        
        System.out.println("");
        
        System.out.println("Profit earned for "+latte.getDrinkID()+": $"+latte.computeProfit());
        System.out.println("Profit earned for "+mocca.getDrinkID()+": $"+mocca.computeProfit());
        System.out.println("Profit earned for "+espresso.getDrinkID()+": $"+espresso.computeProfit());
        
        double totalProfit = latte.computeProfit()+mocca.computeProfit()+espresso.computeProfit();
        System.out.println("");
        System.out.println("Total profit: $"+totalProfit);
    }
}
