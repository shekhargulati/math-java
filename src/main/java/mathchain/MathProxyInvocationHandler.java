package mathchain;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

class MathProxyInvocationHandler implements InvocationHandler {

    private static Map<String, String> nameMapping = new HashMap<String, String>() {
        {
            put("add", "addExact");
            put("subtract", "subtractExact");
            put("multiply", "multiplyExact");
        }
    };

    private final int value;
    private IntUnaryOperator function;

    public MathProxyInvocationHandler(int value) {
        this.value = value;
        this.function = IntUnaryOperator.identity();
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        if (Objects.equals(method.getName(), "done")) {
            return function.applyAsInt(this.value);
        }
        Method methodToInvoke = Math.class.getMethod(nameMapping.get(method.getName()), int.class, int.class);
        this.function = function.andThen(i -> {
            try {
                Object[] methodArgs = {i, args[0]};
                return (int) methodToInvoke.invoke(null, methodArgs);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
        return proxy;
    }

}
