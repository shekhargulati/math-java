package mathchain;

import java.lang.reflect.Proxy;

public class MathChain {

    public static IntMathChain chain(int value) {
        return create(IntMathChain.class, value);
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(final Class<T> mathChain, int v) {
        return (T) Proxy.newProxyInstance(
                mathChain.getClassLoader(),
                new Class[]{mathChain},
                new MathIntOperationsInvocationHandler(v));
    }
}
