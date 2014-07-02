package refactorings._3_replace_temp_with_querry._2_more_complex_case;

import refactorings._3_replace_temp_with_querry._2_more_complex_case.additionalClasses.Rental;

import java.util.Enumeration;

public class ReplaceTempWithQuery {
    private Rental _rentals;
    private String name;
    private Object frequentRenterPoints;

    public String getName() {
        return name;
    }

    private String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental)rentals.nextElement();
            frequentRenterPoints = each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" +each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        //add footer lines
        result += "Amount owned is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return  result;
    }

    public double getTotalCharge() {
        Enumeration rentals = _rentals.elements();
        double result = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental)rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public double getTotalFrequentRenterPoints() {
        Enumeration rentals = _rentals.elements();
        int result = 0;
        while (rentals.hasMoreElements()) {
            Rental each = (Rental)rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}

/*
We want to apply temp with querry to the local variable totalAmount, but in this case it is assigned
more than once. It is assigned once in the loop and once in the message at the end of the method.

1- we can create a querry method and extract the loop that sets the value of totalAmount
Notice how the extracted method getTotalCharge just contains what is needed to calculate the total
a local value result was created to gather the result, since we are no longer using the variable totalAmount

2- also the same was done to the variable frequentRenterPoints

3- now that both of the variables the that the part that calculate the footer are extracted into their own
methods, we can delete the local variables totalAmount and frequentRenterPoints since they were replaced with
query methods

private String statement() {
        double totalAmount = 0;
        int frequent = 0;
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
           Rental each = (Rental)rentals.nextElement();
            frequentRenterPoints = each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" +each.getMovie().getTitle()+ "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }

        //add footer lines
        result += "Amount owned is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return  result;
    }
*/
