package refactorings._6_separate_querry_from_modifier;

import static refactorings._6_separate_querry_from_modifier.additionalClasses.SomeClass.alert;
import static refactorings._6_separate_querry_from_modifier.additionalClasses.SomeClass.someLaterCode;

public class SeparateQueryFromModifier {

    void sendAlert(String[] people) {
        if(!foundPerson(people).equals(""))
            alert();
    }

    private String foundPerson(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if(people[i].equals("Don")) {
                return "Don";
            }
            if(people[i].equals("John")) {
                return "John";
            }
        }
        return "";
    }

    synchronized void checkSecurity(String[] people) {
        sendAlert(people);
        String found = foundPerson(people);
        someLaterCode(found);
    }

    /*
    This method return a value and also changes the state of an object:
    -It queries for some information(Query)
    -It sends an Alert(Modifier)

    It side effects/multiple responsibilities
    We should replace this with 2 different methods, 1 for each thing.

    Step 1: create a copy of the method but without the side effects
    Step 2: in the original method, replace every return value to a call to the new extracted method
    Step 3: Replace the client to call each of the methods separately, first the modifier and then the query
    Step 4: Make the modifier return void
    Step 5: Rename the modifier if it makes more sense
    Steo 6: Remove duplication from the modifier(see how to "substitute_algorithm")
    Step 7: it is a good practice to make the client method synchronized, this will allow it to function
    correctly in a multithreaded environment.

    String foundMiscreant(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if(people[i].equals("Don")) {
                alert();
                return "Don";
            }
            if(people[i].equals("John")) {
                alert();
                return "John";
            }
        }
        return "";
    }

    void checkSecurity(String[] people) {
        String found = foundMiscreant(people);
        someLaterCode(found);
    }
    */
}
