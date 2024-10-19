public class Employee implements Comparable<Employee> {
    private int employeeID; // Unique identifier for the employee.
    private String name; // Name of the employee.
    private String department; // Department where the employee works.

    // Constructor to initialize an Employee object with the provided details.
    public Employee(int employeeID, String name, String department) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
    }

    // Getter method to retrieve the employee ID.
    public int getEmployeeID() {
        return employeeID;
    }

    // Getter method to retrieve the employee's name.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the employee's department.
    public String getDepartment() {
        return department;
    }

    // Method to compare two Employee objects based on their employee IDs.
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.employeeID, other.employeeID);
    }

    // Method to generate a string representation of the Employee object.
    @Override
    public String toString() {
        // Return a formatted string containing the employee's ID, name, and department.
        return "Employee ID: " + employeeID + ", Name: " + name + ", Department: " + department;
    }
}

