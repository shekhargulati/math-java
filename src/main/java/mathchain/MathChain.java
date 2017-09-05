package mathchain;

import java.util.function.Function;

public class MathChain {

    private final int value;
    private Function<Integer, Integer> function;

    private MathChain(int value) {
        this.value = value;
        this.function = i -> i;
    }

    public static MathChain chain(int value) {
        return new MathChain(value);
    }

    public MathChain add(int value) {
        this.function = this.function.andThen(i -> Math.addExact(i, value));
        return this;
    }

    public MathChain subtract(int value) {
        this.function = this.function.andThen(i -> Math.subtractExact(i, value));
        return this;
    }

    public MathChain multiply(int value) {
        this.function = this.function.andThen(i -> Math.multiplyExact(i, value));
        return this;
    }

    public int done() {
        return this.function.apply(this.value);
    }


}
