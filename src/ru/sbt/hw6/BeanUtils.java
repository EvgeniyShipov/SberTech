package ru.sbt.hw6;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     * <p>
     * param to Object which properties will be set.
     * param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        Method[] methodsFrom = from.getClass().getMethods();
        Method[] methodsTo = to.getClass().getMethods();

        List<Method> getterList = new ArrayList<>();
        List<Method> setterList = new ArrayList<>();

        for (Method method : methodsFrom) {
            if ((method.getName().startsWith("get")) && (method.getParameterTypes().length == 0) && (!void.class.equals(method.getReturnType()))) {
                getterList.add(method);
            }
        }
        for (Method method : methodsTo) {
            if ((method.getName().startsWith("set")) && (method.getParameterTypes().length == 1)) {
                setterList.add(method);
            }
        }

        for (Method method : getterList) {
            if (setterList.contains(method.getName().substring(3))) {
                // берем из геттера и устанавливаем в сеттер. Завтра допишу)
            }
        }
    }
}

