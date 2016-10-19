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
public class StoreSupervisor extends Staff{
    private int totalAdminHours;
    
    public StoreSupervisor(String id, int newTotalWorkHours, int newTotalAdminHours)
    {
        super();
        staffID = id;
        totalWorkHours = newTotalWorkHours;
        totalAdminHours = newTotalAdminHours;
    }
    
    public int getTotalAdminHours()
    {
        return totalAdminHours;
    }
    
    public double computeSalary()
    {
        double salary = super.computeSalary() + (totalAdminHours*20);
        
        return salary;
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
