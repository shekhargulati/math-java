package mathchain;

import java.util.function.IntUnaryOperator;

public class IntMathChain {

    private final int value;
    private IntUnaryOperator function;

    public IntMathChain(int value) {
        this.function = IntUnaryOperator.identity();
        this.value = value;
    }

    public IntMathChain add(int value) {
        this.function = this.function.andThen(i -> Math.addExact(i, value));
        return this;
    }

    public IntMathChain subtract(int value) {
        this.function = this.function.andThen(i -> Math.subtractExact(i, value));
        return this;
    }

    public IntMathChain multiply(int value) {
        this.function = this.function.andThen(i -> Math.multiplyExact(i, value));
        return this;
    }

    public int done() {
        return this.function.applyAsInt(this.value);
    }

}
