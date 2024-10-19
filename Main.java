/*
TABA

Student Name: Fabio A. Steyer
Student ID: 22132848
Programme: Higher Diploma in Science in Computing Information (Software Development)
Year of Study: 2024
Module Title: Distributed System
Lecturer:Sudarshan Deshmukh
Project/Issay Title: Smart Agriculture/farming
Submission Deadline: Monday, 24 April 2024, 11:59 PM
*/

public class Main {
    public static void main(String[] args) {
        EmployeeBST bst = new EmployeeBST();

        // Insert employees
        System.out.println("\nEmployees already added:");
        bst.insert(new Employee(1234, "John Doe", "Development"));
        bst.insert(new Employee(5678, "Jane Smith", "HR"));
        bst.insert(new Employee(9012, "Michael Johnson", "Sales"));
        System.out.println("----------------------------------------");

        // Print all employees
        System.out.println("\nAll employees:");
        bst.printAllEmployees();

        // Insert a new employee
        System.out.println("\nNew employee added:");
        Employee newEmployee = new Employee(3456, "Emily Brown", "Finance");
        bst.insert(newEmployee);
        System.out.println("----------------------------------------");

        // Print all employees after insertion
        System.out.println("\nAll employees after insertion:");
        bst.printAllEmployees();

        // Search for an employee
        int searchID = 5678;
        Employee foundEmployee = bst.search(searchID);
        System.out.println("\nSearching for employee with ID " + searchID + ":");
        if (foundEmployee != null) {
            System.out.println("Employee found: " + foundEmployee);
            System.out.println("----------------------------------------");
        } else {
            System.out.println("Employee not found.");
        }

        // Delete an employee
        int deleteID = 5678;
        System.out.println("\nDeleting employee with ID " + deleteID + ":");
        bst.delete(deleteID);
        System.out.println("Employee deleted.");
        System.out.println("----------------------------------------");

        // Print all employees after deletion
        System.out.println("\nAll employees after deletion:");
        bst.printAllEmployees();
    }
}
