package refactorings.extract_method._3_when_reasigning_a_local_variable_case_A;

import refactorings.extract_method._2_when_using_local_variables.additionalclasses.Order;
import refactorings.extract_method._2_when_using_local_variables.additionalclasses.Orders;

import java.util.Enumeration;

//At the bottom see how the class looked like initially
public class ExtractMethod {

    private String _name;
    private Orders _orders;

    void printOwning() {
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    private double getOutstanding() {
        Enumeration e = _orders.elements();
        double result = 0.0;

        while(e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            result += each.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        System.out.println("name:" + _name);
        System.out.println("amount:" + outstanding);
    }

    private void printBanner() {
        System.out.println("**********************");
        System.out.println("*****Customer Owes****");
        System.out.println("**********************");
    }
}

/*
We want to extract the chunk of code that calculates the outstanding.
Observations:
- The method does more than one thing
- There is a comment explaining what a certain part does
- The part that prints that calculates the outstanding modifies a local variable.
- When refactored the Enumeration variable was brought into the extracted method because was
used nowhere eles
- When refactored the outstanding variable was not moved in because it was used by another method

public class ExtractMethod {

    private String _name;
    private Orders _orders;

    void printOwning() {

        Enumeration e = _orders.elements();
        double outstanding = 0.0;

        printBanner();

        //calculate outstanding
        while(e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            outstanding += each.getAmount();
        }

        printDetails(outstanding);
    }

    private void printDetails(double outstanding) {
        System.out.println("name:" + _name);
        System.out.println("amount:" + outstanding);
    }

    private void printBanner() {
        System.out.println("**********************");
        System.out.println("*****Customer Owes****");
        System.out.println("**********************");
    }
}
*/

