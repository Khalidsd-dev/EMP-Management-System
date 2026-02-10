package model;
import java.util.ArrayList;
import java.util.List;
public class Employee {

    private long ID;
    private String Emp_name;
    private String Emp_Surname;
    private float Salary;


    private List<Object> Employees = new ArrayList<>();


    // Wage per hour
    private float wagePerHour = 82.50f;
    private final int hoursWorked = 9;
    private int daysWorked;



    public Employee(String emp_Name, String emp_Surname, long id, int daysWorked) {
        this.ID = id;
        this.Emp_name = emp_Name;
        this.Emp_Surname = emp_Surname;
        this.daysWorked = daysWorked;

        // Calculate Salary
        calculate();
    }


    @Override
    public String toString() {

        return "\nName: " + Emp_name + "\nSurname: " + Emp_Surname + "\nID Number: " + ID + "\nThis is my Salary: R " + Salary + "\n";
    }

    private void calculate() {
        // Calculate Net Pay (basically your Salary for all the daysWorked).
        float dailyPay = (wagePerHour * hoursWorked) * daysWorked;
        Salary = dailyPay ;
    }






}
