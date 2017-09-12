package mathchain;

import java.lang.reflect.Proxy;

public class MathChain {

    public static IntMathOperations chain(int value) {
        return createProxy(IntMathOperations.class, value);
    }

    public static LongMathOperations chain(long value) {
        return createProxy(LongMathOperations.class, value);
    }

    @SuppressWarnings("unchecked")
    private static <T> T createProxy(final Class<T> mathChain, int value) {
        return (T) Proxy.newProxyInstance(
                mathChain.getClassLoader(),
                new Class[]{mathChain},
                new MathIntOperationsInvocationHandler(value));
    }

    @SuppressWarnings("unchecked")
    private static <T> T createProxy(final Class<T> mathChain, long value) {
        return (T) Proxy.newProxyInstance(
                mathChain.getClassLoader(),
                new Class[]{mathChain},
                new MathLongOperationsInvocationHandler(value));
    }
}
