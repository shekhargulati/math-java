package mathchain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

class MathDoubleOperationsInvocationHandler implements InvocationHandler {
    private static Map<String, String> nameMapping = new HashMap<String, String>() {
        {
            put("add", "addExact");
            put("subtract", "subtractExact");
            put("multiply", "multiplyExact");
            put("increment", "incrementExact");
            put("decrement", "decrementExact");
            put("negate", "negateExact");
        }
    };

    private final double value;
    private DoubleUnaryOperator function;

    public MathDoubleOperationsInvocationHandler(double value) {
        this.value = value;
        this.function = DoubleUnaryOperator.identity();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        String methodName = method.getName();
        if (Objects.equals(methodName, "done")) {
            return function.applyAsDouble(this.value);
        }
        if (args == null || args.length == 0) {
            Method methodToInvoke = getMethod(methodName, double.class);
            this.function = this.function.andThen(i -> {
                try {
                    Object[] methodArgs = {i};
                    return (double) methodToInvoke.invoke(null, methodArgs);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        } else if (args.length == 1) {
            Method methodToInvoke = getMethod(methodName, double.class, double.class);
            this.function = function.andThen(i -> {
                try {
                    Object[] methodArgs = {i, args[0]};
                    return (double) methodToInvoke.invoke(null, methodArgs);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return proxy;
    }

    private Method getMethod(String methodName, Class<?>... parameterTypes) {
        try {
            return Math.class.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException ignored) {
        }
        try {
            return DoubleMath.class.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {

        }
        throw new RuntimeException(String.format("%s does not exit", methodName));
    }

}
