package refactorings._7_replace_method_with_method_object;

public class ReplaceMethodWithMethodObject {

    int gamma(int inputVal, int quantity, int yearToDate) {
        return new Gamma(this, inputVal, quantity, yearToDate).compute();
    }

    public int delta() {
        return 0;
    }
 
    /*
    Extract method would be really useful since clearly there are multiple responsibilities in the
    method gamma. We could do it directly but it will result in multiple methods with duplication in
    their parameter list (e.g importatntValue1(int,int,int)...) 
    We could use replace method with method object to decompose this method in to a class.
    
    1- We create a class and call it by the name of the method(Gamma)
    2- We transform the method parameters into fields.
    3- We also create a final field of the type of the class where we are extracting from.
    4- We initialize all the fields with a parametrized constructor
    5- Create a method called compute and move the behaivour to it. Calls to methods that belong to the
    original class can be used the final field(Change access modifier to those method to public if needed).
    6- The next step is to apply extract method into some parts of the logic in the computhe method.
    For that first we need to make the local values fields.
    7- Finally we need to wire in the logic to the original class
    
    int gamma(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if((yearToDate - importantValue1) > 100)
            importantValue2 -= 20;
        int importantValue3 = importantValue2 * 7;
        //and so on.
        return  importantValue3 - 2 * importantValue1;
    }
    private int delta() {
        return 0;
    }
    */
}
