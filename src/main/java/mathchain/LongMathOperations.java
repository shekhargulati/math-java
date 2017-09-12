package mathchain;

public interface LongMathOperations {

    LongMathOperations add(long value);

    LongMathOperations subtract(long value);

    LongMathOperations multiply(long value);

    LongMathOperations abs();

    LongMathOperations increment();

    LongMathOperations decrement();

    LongMathOperations negate();

    LongMathOperations max(long value);

    LongMathOperations min(long value);

    long done();
}
