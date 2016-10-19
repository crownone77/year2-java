/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffapp;

import java.text.DecimalFormat;

/**
 *
 * @author Steven
 */
public class StoreAssistant extends Staff{
    
    public StoreAssistant(String id, int newTotalWorkHours)
    {
        staffID = id;
        totalWorkHours = newTotalWorkHours;
    }
    
    public void viewDetails()
    {
        DecimalFormat Currency = new DecimalFormat("$0.00");
        String salary = Currency.format(computeSalary());
        
        String output = "";
        output += "Staff ID: "+staffID;
        output += "     Total Work Hours: "+totalWorkHours;
        output += "     Salary: "+salary;
        
        System.out.println(output);
    }
}
