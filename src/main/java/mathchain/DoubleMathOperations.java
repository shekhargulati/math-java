package mathchain;

public interface DoubleMathOperations {

    DoubleMathOperations add(double value);

    DoubleMathOperations subtract(double value);

    DoubleMathOperations multiply(double value);

    DoubleMathOperations abs();

    DoubleMathOperations increment();

    DoubleMathOperations decrement();

    DoubleMathOperations negate();

    DoubleMathOperations max(double value);

    DoubleMathOperations min(double value);

    double done();
}
