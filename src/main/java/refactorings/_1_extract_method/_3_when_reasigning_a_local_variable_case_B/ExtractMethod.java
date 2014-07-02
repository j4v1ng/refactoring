package refactorings._1_extract_method._3_when_reasigning_a_local_variable_case_B;

import refactorings._1_extract_method._3_when_reasigning_a_local_variable_case_B.additionalclasses.Order;
import refactorings._1_extract_method._3_when_reasigning_a_local_variable_case_B.additionalclasses.Orders;

import java.util.Enumeration;

//At the bottom see how the class looked like initially
public class ExtractMethod {

    private String _name;
    private Orders _orders;

    void printOwning(double previousAmount) {
        double outstanding = previousAmount * 1.2;
        printBanner();
        outstanding = getOutstanding(outstanding);
        printDetails(outstanding);
    }

    private double getOutstanding(double outstanding) {
        double result = outstanding;
        Enumeration e = _orders.elements();
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
used nowhere else
- When refactored the outstanding variable we passed it as a parameter because it had a non obvious
 initial value and also because it is used in another part which does not belong to the part we want
 to extract.
- After refactoring we could do an inline method to clean up the way the variable outstanding its
initialized:
double outstanding = getOutstanding(previousAmount * 1.2);

 public class ExtractMethod {

    private String _name;
    private Orders _orders;

    void printOwning(double previousAmount) {

        Enumeration e = _orders.elements();
        double outstanding = previousAmount * 1.2;
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