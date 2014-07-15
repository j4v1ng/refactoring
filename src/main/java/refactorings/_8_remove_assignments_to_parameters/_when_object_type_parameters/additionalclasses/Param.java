package refactorings._8_remove_assignments_to_parameters._when_object_type_parameters.additionalclasses;

import java.util.Date;

public class Param {
    public static void main(String[] args) {
        Date d1 = new Date("1 Apr 98");
        nextDateUpdate(d1);
        System.out.println("d1 after nextDay: " + d1);

        Date d2 = new Date("1 Apr 98");
        nextDateReplace(d2);
        System.out.println("d2 after nextDay: " + d2);

    }

    private static void nextDateUpdate(Date arg) {
        arg.setDate(arg.getDate() + 1);
        System.out.println("arg in nextDay: " + arg);
    }

    private static void nextDateReplace(Date arg) {
        arg = new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
        System.out.println("arg in nextDay: " + arg);
    }


    /*
    In this example the parameters are objects rather than primitives.
    So, when the semantics are pass by reference, we need to check if in the
    calling method/s, the object is used again, so we can avoid undesired situations
    if we modify the object.

    In the above example the second method the parameter is reasigned so it
    eliminates the effect of pass by reference, and therefore the subsequent uses
    of that same object by the client are not affected. We shouldn't be doing that,
    this examples are just to ilustrate the effects of pass by reference.

    The solution to avoid undesired scenarios is:
    - assign the parameter into a temporaty variable
    - make the parameter final
    */

}
