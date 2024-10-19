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

public class EmployeeBST {
    private Node root;

    // Inner Node class to represent nodes in the binary search tree.
    private class Node {
        private Employee employee; // Employee object stored in this node.
        private Node left, right; // References to the left and right child nodes.

        // Constructor to create a new node with the given employee.
        public Node(Employee employee) {
            this.employee = employee;
        }
    }

    // Method to insert a new employee into the binary search tree.
    public void insert(Employee employee) {
        root = insertRec(root, employee); // Call the recursive insert method.
        // Print message indicating the employee is inserted (this message is printed only once).
        if (root == null)
            root = new Node(employee);
        else
            insertRec(root, employee);
        System.out.println("Employee inserted: " + employee);
    }

    // Recursive method to insert a new employee into the binary search tree.
    private Node insertRec(Node node, Employee employee) {
        // If the current node is null, create a new node with the employee and return it.
        if (node == null) {
            return new Node(employee);
        }

        // Compare the employee with the employee in the current node.
        // and recursively insert into the left or right subtree accordingly.
        if (employee.compareTo(node.employee) < 0) {
            node.left = insertRec(node.left, employee);
        } else if (employee.compareTo(node.employee) > 0) {
            node.right = insertRec(node.right, employee);
        }

        return node; // Return the modified node.
    }

    // Method to search for an employee by their employee ID.
    public Employee search(int employeeID) {
        Node node = search(root, employeeID); // Call the recursive search method.
        return node == null ? null : node.employee; // Return the found employee or null if not found.
    }

    // Recursive method to search for an employee by their employee ID.
    private Node search(Node node, int employeeID) {
        // If the current node is null or its employee ID matches the target, return the node.
        if (node == null || node.employee.getEmployeeID() == employeeID) {
            return node;
        }

        // Otherwise, recursively search in the left or right subtree based on the employee ID.
        if (employeeID < node.employee.getEmployeeID()) {
            return search(node.left, employeeID);
        } else {
            return search(node.right, employeeID);
        }
    }

    // Recursive method to delete an employee by their employee ID.
    public void delete(int employeeID) {
        root = delete(root, employeeID); // Call the recursive delete method.
    }

    // Recursive method to delete an employee by their employee ID.
    private Node delete(Node node, int employeeID) {
        // If the current node is null, return null.
        if (node == null) {
            return null;
        }

        // If the target employee ID is less than the current node's employee ID,
        // recursively delete from the left subtree.
        if (employeeID < node.employee.getEmployeeID()) {
            node.left = delete(node.left, employeeID);
        } else if (employeeID > node.employee.getEmployeeID()) {
            node.right = delete(node.right, employeeID);
            // If the target employee ID is found in the current node.
        } else {
            // If the current node has no left child, return its right child.
            if (node.left == null) {
                return node.right;
            // If the current node has no right child, return its left child.
            } else if (node.right == null) {
                return node.left;
            }

            // If the current node has both left and right children,
            // find the minimum node in the right subtree (successor).
            Node minNode = findMin(node.right);
            // Replace the current node's employee with the successor's employee.
            node.employee = minNode.employee;
            // Delete the successor from the right subtree.
            node.right = delete(node.right, minNode.employee.getEmployeeID());
        }
        return node; // Return the modified node.
    }

    // Method to find the minimum node in a subtree (used in delete operation).
    private Node findMin(Node node) {
        // Traverse to the leftmost node in the subtree to find the minimum node.
        while (node.left != null) {
            node = node.left;
        }
        return node; // Return the minimum node found.
    }

    // Method to print all employees in the binary search tree.
    public void printAllEmployees() {
        printAllEmployees(root); // Call the recursive print method to print all employees
        System.out.println("----------------------------------------"); // Print a separator line
    }

    // Recursive method to print all employees in a subtree (in-order traversal).
    private void printAllEmployees(Node node) {
        if (node != null) {
            // Recursively print employees in the left subtree.
            printAllEmployees(node.left);
            // Print the employee in the current node.
            System.out.println(node.employee);
            // Recursively print employees in the right subtree.
            printAllEmployees(node.right);
        }
    }
}




