package refactorings._4_replace_temp_with_querry._2_more_complex_case.additionalClasses;

import javax.swing.*;
import java.util.Enumeration;

/**
 * Created by ocean on 02/07/14.
 */
public enum Rental {
    ;
    private int frequentRenterPoints;
    private JInternalFrame movie;
    private double charge;

    public Enumeration elements() {
        return null;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public JInternalFrame getMovie() {
        return movie;
    }

    public double getCharge() {
        return charge;
    }
}
