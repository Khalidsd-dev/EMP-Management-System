package controller;

import model.Employee;


import java.util.HashMap;
import java.util.Map;

public class EmployeeManager {

    private Map<Integer, Employee> employees;
    private int registerCount = 0;

    public  EmployeeManager() {
        employees = new HashMap<>();
    }


    public void addEmployee(String name, String surname, long id, int workedDays) {

        // Create New Employee
        Employee emp = new Employee(name, surname, id, workedDays);



        // Add new Employee to the HashMap => employees as a new object
        employees.put(registerCount, emp);
            System.out.println("\nA new employee has been successfully created and added.\n");
            viewEmployees();
            registerCount++;

    }

    // get index from user to then update the employees details.
    /**
     * We use the index, that we specify in the update method to access and update an employees
     * details in the employees HasMap.
     * We tell hashMap, that we want to update the data at the location of the given index/key.
     * We then get all the necessary data, then we pass all that data to their correct pairs in the hashMap(Employees).
     * @param key
     * @param name
     * @param surname
     * @param id
     * @param workedDays
     */

    public void updateEmployee(int key, String name, String surname, long id, int workedDays) {

        if (!employees.containsKey(key)) {
            System.out.println("Invalid key. Available keys: " + employees.keySet());
            return;
        }

        else {
            Employee newEmp = new Employee(name.trim(), surname.trim(), id, workedDays);
            employees.put(key, newEmp);
            System.out.println("\nSuccessfully Updated!");

            System.out.println("Revised Employee List: \n" + employees.get(key));
        }
        }


    public void viewEmployees() {

        /**
         * Iterate through employees and print the key and value pairs.
         * The user then can see what key is associated with which Employee.
         */

        if (!employees.isEmpty()) {
            for (int key : employees.keySet())
            System.out.print("*********** \nEmployee Key =  " + key + "\n{" + employees.get(key) + "}\n***********\n\n");
        } else System.out.println("\nNo employee has been registered yet!\n");

    }


    public void deleteEmployee(int index) {
            employees.remove(index);
            System.out.println("The employee has been successfully removed!");
    }

    public boolean rosterEmpty() {
        if (employees.isEmpty()) {
            System.out.println("\nEmployee Roster is Empty.");
            return true;
        }
        return false;
    }
}
