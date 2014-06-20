package tdd_for_fun;

//Code before refactoring at the bottom
public class Haggis {

    private double _primaryForce;
    private double _mass;
    private int _delay;
    private double _secondaryForce;

    public Haggis(double _primaryForce, double _mass, int _delay, double _secondaryForce, int primaryVel) {
        this._primaryForce = _primaryForce;
        this._mass = _mass;
        this._delay = _delay;
        this._secondaryForce = _secondaryForce;
    }

    double getDistanceTraveled(int time) {
        return isThereSecondaryTime(secondaryTime(time)) ?
                result(time) :
                metaResult(primaryTime(time));
    }

    private double result(int time) {
        return metaResult(primaryTime(time)) + updateResult(secondaryTime(time));
    }

    private double updateResult(int secondaryTime) {
        return primaryVel() * secondaryTime + 0.5 * acc() * secondaryTime * secondaryTime;
    }

    private double acc() {
        return (_primaryForce + _secondaryForce) / _mass;
    }

    private double primaryVel() {
        return primaryAcc() * _delay;
    }

    private double primaryAcc() {
        return _primaryForce / _mass;
    }

    private boolean isThereSecondaryTime(int secondaryTime) {
        return secondaryTime > 0;
    }

    private int secondaryTime(int time) {
        return time - _delay;
    }

    private double metaResult(int primaryTime) {
        return 0.5 * primaryAcc() * primaryTime * primaryTime;
    }

    private int primaryTime(int time) {
        return Math.min(time, _delay);
    }
}