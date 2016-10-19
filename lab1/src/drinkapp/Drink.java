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


public class Drink 
{
    private String drinkID;
    private double drinkCostPrice;
    private double drinkSellPrice;
    private int drinkQuantitySold;
    
    public Drink()
    {
        drinkID = "";
        drinkCostPrice = 0.0d;
        drinkSellPrice = 0.0d;
        drinkQuantitySold = 0;
    }

    public Drink(String newDrinkID)
    {
        drinkID = newDrinkID;
        drinkCostPrice = 0.0d;
        drinkSellPrice = 0.0d;
        drinkQuantitySold = 0;
    }
    
    public String getDrinkID()
    {
        return drinkID;
    }
    
    public void setDrinkID(String newDrinkID)
    {
        drinkID = newDrinkID;
    }
    
    public double getDrinkCostPrice()
    {
        return drinkCostPrice;
    }
    
    public void setDrinkCostPrice(double cp)
    {
        drinkCostPrice = cp;
    }
    
    public double getDrinkSellPrice()
    {
        return drinkSellPrice;
    }
    
    public void setDrinkSellPrice(double sp)
    {
        drinkSellPrice = sp;
    }
    
    public int getDrinkQuantitySold()
    {
        return drinkQuantitySold;
    }
    
    public void setDrinkQuantitySold(int sp)
    {
        drinkQuantitySold = sp;
    }

    public void updateQuantitySold(int qty)
    {
        drinkQuantitySold += qty;
    }

    public double computeProfit()
    {
        double profit = (getDrinkSellPrice() - getDrinkCostPrice())*getDrinkQuantitySold();
        return profit;
    }

    public String toString()
    {
        String output = "";
        output += getDrinkID();
        output += "   Cost Price: $"+getDrinkCostPrice();
        output += "   Selling Price: $"+getDrinkSellPrice();
        output += "   Quantity Sold: "+getDrinkQuantitySold();
        
        return output;
    }
    
}
