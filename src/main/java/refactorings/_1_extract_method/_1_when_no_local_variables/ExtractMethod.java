package refactorings._1_extract_method._1_when_no_local_variables;

import refactorings._1_extract_method._1_when_no_local_variables.additionalclasses.Order;
import refactorings._1_extract_method._1_when_no_local_variables.additionalclasses.Orders;
import java.util.Enumeration;

//At the bottom see how the class looked like initially
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

        //print details
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
We want to extract the chunk of code that prints the banner.
Observations:
- The method does more than one thing
- There is a comment explaining what a certain part does
- The part that prints the banner does not use any local variable
it should be trivial to extract method.

public class ExtractMethod {

    private String _name;
    private Orders _orders;

    void printOwning() {

        Enumeration e = _orders.elements();
        double outstanding = 0.0;

        //print banner
        System.out.println("**********************");
        System.out.println("*****Customer Owes****");
        System.out.println("**********************");

        //calculate outstanding
        while(e.hasMoreElements()) {
            Order each = (Order) e.nextElement();
            outstanding += each.getAmount();
        }

        //print details
        System.out.println("name:" + _name);
        System.out.println("amount:" + outstanding);
    }
}*/

