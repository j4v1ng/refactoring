package refactorings._8_remove_assignments_to_parameters._when_primitive_type_parameters;

public class RemoveAssignmentsToParameters {

    int discount (final int inputVal, int quantity, int yearToDate) {
        int result = inputVal;
        if(result > 50) result -= 2;
        if(quantity > 100) result -= 1;
        if(yearToDate > 10000) result -= 4;
        return result;
    }

    /*
    The values that are passed as parameters, should be always used just as input data.
    It is a code smell to assign values to them, this can cause unpredicted situations.

    Refactoring instructions(for Example 1):
    - Make a copy of the parameter that is being re assigned.
    - Use the copy in the method rather than the parameter.
    - Make the parameter final so nobody can edit it in the future.

    int discount (int inputVal, int quantity, int yearToDate) {
        if(inputVal > 50) inputVal -= 2;
        if(quantity > 100) inputVal -= 1;
        if(yearToDate > 10000) inputVal -= 4;
        return inputVal;
    }*/
}
