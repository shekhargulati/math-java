package mathchain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

class MathIntOperationsInvocationHandler implements InvocationHandler {

    private static Map<String, String> nameMapping = new HashMap<String, String>() {
        {
            put("add", "addExact");
            put("subtract", "subtractExact");
            put("multiply", "multiplyExact");
            put("increment", "incrementExact");
            put("decrement", "decrementExact");
            put("negate","negateExact");
        }
    };

    private final int value;
    private IntUnaryOperator function;

    public MathIntOperationsInvocationHandler(int value) {
        this.value = value;
        this.function = IntUnaryOperator.identity();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        String methodName = method.getName();
        if (Objects.equals(methodName, "done")) {
            return function.applyAsInt(this.value);
        }
        if (args == null || args.length == 0) {
            Method methodToInvoke = Math.class.getMethod(nameMapping.getOrDefault(methodName, methodName), int.class);
            this.function = this.function.andThen(i -> {
                try {
                    Object[] methodArgs = {i};
                    return (int) methodToInvoke.invoke(null, methodArgs);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        } else if (args.length == 1) {
            Method methodToInvoke = Math.class.getMethod(nameMapping.getOrDefault(methodName, methodName), int.class, int.class);
            this.function = function.andThen(i -> {
                try {
                    Object[] methodArgs = {i, args[0]};
                    return (int) methodToInvoke.invoke(null, methodArgs);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return proxy;
    }

}
