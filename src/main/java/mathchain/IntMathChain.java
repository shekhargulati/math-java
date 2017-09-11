package mathchain;

public interface IntMathChain {
    IntMathChain add(int value);

    IntMathChain subtract(int value);

    IntMathChain multiply(int value);

    IntMathChain abs();

    IntMathChain increment();

    IntMathChain decrement();

    IntMathChain negate();

    IntMathChain max(int value);

    IntMathChain min(int value);

    int done();

}
