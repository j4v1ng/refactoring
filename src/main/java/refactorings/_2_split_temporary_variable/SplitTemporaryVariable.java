package refactorings._2_split_temporary_variable;

//Code before refactoring at the bottom
public class SplitTemporaryVariable {

    private double _primaryForce;
    private double _mass;
    private int _delay;
    private double _secondaryForce;
    private int primaryVel;

    double getDistanceTraveled(int time) {
        double result;
        final double primaryAcc = _primaryForce / _mass;
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if (secondaryTime > 0) {
            double primaryVel = primaryAcc * _delay;
            double acc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }
}

/*

public class Haggis {

    private double _primaryForce;
    private double _mass;
    private int _delay;
    private double _secondaryForce;
    private int primaryVel;

    double getDistanceTraveled(int time) {
        double result;
        double acc = _primaryForce / _mass;
        int primaryTime = Math.min(time, _delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - _delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * _delay;
            acc = (_primaryForce + _secondaryForce) / _mass;
            result += primaryVel * secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }
}
*/
