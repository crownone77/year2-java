/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffapp;

/**
 *
 * @author Steven
 */
public class Staff {
    protected String staffID;
    protected int totalWorkHours;
    
    public void setStaffID(String id)
    {
        staffID = id;
    }
    
    public String getStaffID()
    {
        return staffID;
    }
    
    public void setTotalWorkHours(int hr)
    {
        totalWorkHours = hr;
    }
    
    public int getTotalWorkHours()
    {
        return totalWorkHours;
    }
    
    public double computeSalary()
    {
        double salary = totalWorkHours * 15;
        return salary;
    }
    
    
}
