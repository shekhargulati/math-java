package mathchain;

public interface IntMathChain {
    IntMathChain add(int value);

    IntMathChain subtract(int value);

    IntMathChain multiply(int value);

    int done();
}
