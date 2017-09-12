package mathchain;

public interface IntMathOperations {
    IntMathOperations add(int value);

    IntMathOperations subtract(int value);

    IntMathOperations multiply(int value);

    IntMathOperations abs();

    IntMathOperations increment();

    IntMathOperations decrement();

    IntMathOperations negate();

    IntMathOperations max(int value);

    IntMathOperations min(int value);

    int done();

}
