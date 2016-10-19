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
public class StaffApp {
    public static void main(String[] args) {
        
        StoreAssistant daniel = new StoreAssistant("Daniel1234", 12);
        StoreSupervisor george = new StoreSupervisor("George9876", 14, 3);
        
        System.out.println("***Store Assistant***");
        System.out.println("Staff ID: "+daniel.getStaffID());
        System.out.println("Total Work Hours: "+daniel.getTotalWorkHours());
        System.out.println("Salary: "+daniel.computeSalary());

        System.out.println("");
        
        System.out.println("***Store Supervisor***");
        System.out.println("Staff ID: "+george.getStaffID());
        System.out.println("Total Admin Hours: "+george.getTotalAdminHours());
        System.out.println("Total Work Hours: "+george.getTotalWorkHours());
        System.out.println("Salary: "+george.computeSalary());
    }
}
