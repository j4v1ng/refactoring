package refactorings._7_replace_method_with_method_object;

public class Gamma {

    private final ReplaceMethodWithMethodObject replaceMethodWithMethodObject;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    public Gamma(ReplaceMethodWithMethodObject replaceMethodWithMethodObject, int inputVal, int quantity, int yearToDate) {
        this.replaceMethodWithMethodObject = replaceMethodWithMethodObject;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    int compute(){
        importantValue1 = (inputVal * quantity) + replaceMethodWithMethodObject.delta();
        importantValue2 = (inputVal * yearToDate) + 100;
        importantThing();
        importantValue3 = importantValue2 * 7;
        //and so on.
        return  importantValue3 - 2 * importantValue1;
    }

    private void importantThing() {
        if((yearToDate - importantValue1) > 100)
            importantValue2 -= 20;
    }
}
