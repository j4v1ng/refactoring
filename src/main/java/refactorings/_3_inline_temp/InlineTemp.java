package refactorings._3_inline_temp;

import refactorings._3_inline_temp.additional_classes.SomeClass;

public class InlineTemp {

    private SomeClass anOrder = new SomeClass();

    public boolean someMethod() {
        return anOrder.basePrice() > 1000;
    }

    /*
    To avoid proliferation of temp variables it is a good practice to inline the with their callers.
    But the precondition to inline a temp, is that the temp is not re assigned multiple times.

    Step 1: declare the temp final(This will visually confirm that is not assign more than once)
    Step 2: replace all the references to the temp with the right side of the assignment
    Step 3: remove the temp;

    private SomeClass anOrder = new SomeClass();

    public boolean someMethod() {
        double basePrice = anOrder.basePrice();
        return basePrice > 1000;
    }*/
}
