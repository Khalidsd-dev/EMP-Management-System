import controller.EmployeeManager;

import java.util.Scanner;


public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static EmployeeManager employeeManager = new EmployeeManager();

    private static String name;
    private static String surname;
    private static long id;
    private static int workedDays;

    public static void main(String[] args) {

        String[] crud = {"ADD", "UPDATE", "READ", "DELETE", "EXIT"};

        while(true) {

            System.out.println("\n\n************* EMPLOYEE MANAGEMENT SYSTEM ***********\n");

            for (int i = 0; i < crud.length; i++) {
                System.out.println(i + " . " + crud[i]);
            }
            System.out.println("\nSelect Option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    createEmployee();
                    break;

                case 1:
                    System.out.println("****** UPDATE EMPLOYEE DETAILS ******\n");
                    runUpdateDetails();

                    break;
                case 2:
                    employeeManager.viewEmployees();
                    break;

                case 3:
                    removeEmployee();
                    break;

                case 4:

                    System.out.println("\nExiting the system, goodbye!");
                    System.exit(0);
                    break;
            }
        }
    }


    private static void createEmployee() {
        employeeFields();
        employeeManager.addEmployee(name, surname, id, workedDays);
    }

    private static void runUpdateDetails(){

        if (!employeeManager.rosterEmpty()) {
            employeeManager.viewEmployees();

            System.out.println("Please input the key value of an employee to update that employee's details.");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            employeeFields();
            employeeManager.updateEmployee(choice, name, surname, id, workedDays);
        }


    }

    private static void removeEmployee() {

        if (!employeeManager.rosterEmpty()) {
            System.out.println("Please Enter the value Key of an Employee to Delete that Employees Data.");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            // Remove Employee from Roster
            employeeManager.deleteEmployee(choice);
        }


    }


    private static void employeeFields() {
        System.out.println("\n******** CREATE EMPLOYEE ******** \n----- Fill In All Details Below: \n");

        // do While loops for input Validation
        do {
            System.out.print("Name: ");
            name = scanner.nextLine().toUpperCase().trim();
        }
        while(!stringValid(name));


        do {
            System.out.print("Surname: ");
            surname = scanner.nextLine().toUpperCase().trim();
        }
        while (!stringValid(surname));


        do {
            System.out.print("ID Number: ");

            while(!scanner.hasNextLong()) {
                System.out.println("Invalid Input");
                scanner.next();

                System.out.print("ID Number: ");
            }

            id = scanner.nextLong();
        }
        while(!integerValid(id));


        do {
            System.out.println("Days Worked: ");

            while(!scanner.hasNextInt()) {
                System.out.println("Invalid Input, Please Enter In a Number");
                scanner.next();

                System.out.print("Days Worked: ");
            }
            workedDays = scanner.nextInt();
        }
        while (!integerValid(workedDays));


        scanner.nextLine(); // Clear Buffer

    }



    // return true only if input has been given otherwise false
    private static boolean stringValid(String input) {

        if (input == null || input.trim().isEmpty()) {
            System.out.println("\nPlease Fill in info!");
            return false;
        }

        return true;
    }

    // return true only if a value has been given otherwise false
    private static boolean integerValid(long input) {

        if (input <= 0) {
            System.out.println("Please provide a valid value!");
            return false;
        }

        return true;
    }

}
