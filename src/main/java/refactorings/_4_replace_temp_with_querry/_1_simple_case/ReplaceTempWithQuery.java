package refactorings._4_replace_temp_with_querry._1_simple_case;

public class ReplaceTempWithQuery {

    private int _quantity;
    private int _itemPrice;

    public double getPrice() {
        return basePrice() * discountFactor();
    }

    private double discountFactor() {
        double discountFactor;
        if(basePrice() > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return discountFactor;
    }

    private int basePrice() {
        return _quantity * _itemPrice;
    }


    /*

    Both local variables basePrice and discountFactor ar assigned only once.
    1- make local variable final
    2- extract its initialization expression into its own method
    3- inline the local variable with its usages by calling the method

    private int _quantity;
    private int _itemPrice;

    public double getPrice() {
        int basePrice = _quantity * _itemPrice;
        double discountFactor;
        if(basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }
    */
}
