package refactorings._4_substitute_algorithm;

import java.util.List;

import static java.util.Arrays.asList;

public class SubstituteAlgorithm {

    String foundPerson(String [] people) {
        List candidates = asList("Don", "John", "Kent");
        for (int i = 0; i < people.length; i++) {
            if(candidates.contains(people[i])) {
                return people[i];
            }
        }
        return "";
    }


    /*
    Substitute algorithm is basically replacing the body of a method with a different implementation
    which is better. The suggested way to do it is:

    Step 0: Before starting, make sure the method is not too complex(Decompose it as much as possible before)
    Step 1: Run all your tests and make sure they pass
    Step 2: Prepare the new algorithm in a separate method
    Step 3: Wire it in everywhere the client code was calling the old method and make sure the tests pass
    Step 4: Remove the old method
    Step 5: Rename the new method with the name of the old method


    String foundPerson(String [] people) {
        for (int i = 0; i < people.length; i++) {
            if(people[i].equals("Don")) {
                return "Don";
            }
            if(people[i].equals("John")) {
                return "John";
            }
            if(people[i].equals("Kent")) {
                return "Kent";
            }
        }
                return "";
    }*/
}
