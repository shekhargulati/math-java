package mathchain;

abstract class DoubleMath {

    public static double add(double a, double b) {
        if (a == Double.MAX_VALUE) {
            throw new ArithmeticException("double overflow");
        }
        return a + b;
    }

    public static double subtract(double a, double b) {
        if (a == Double.MIN_VALUE) {
            throw new ArithmeticException("double overflow");
        }
        return a - b;
    }

    public static double multiply(double a, double b) {
        // TODO: Check overflow
        return a * b;
    }

    public static double increment(double a) {
        if (a == Double.MAX_VALUE) {
            throw new ArithmeticException("double overflow");
        }
        return a + 1;
    }

    public static double decrement(double a) {
        if (a == Double.MIN_VALUE) {
            throw new ArithmeticException("double overflow");
        }
        return a - 1;
    }

    public static double negate(double a) {
        if (a == Double.MIN_VALUE) {
            throw new ArithmeticException("double overflow");
        }
        return -a;
    }
}
