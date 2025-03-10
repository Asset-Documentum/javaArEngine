package com.asset;

import java.lang.reflect.Method;

/**
 * A utility class for invoking static native methods from the {@code JavaArEngine} class
 * using Java reflection. This class is designed to dynamically load and interact with
 * methods in the {@code JavaArEngine} class, which is assumed to be in the default package.
 *
 * <p>This class is useful when the {@code JavaArEngine} class is not directly accessible
 * or when dynamic method invocation is required.</p>
 *
 * @author Michael Wagdy
 * @version 1.0
 * @since 2025-02-02
 */
public class JavaArEngineReflection {

    private Class<?> javaArEngineClass;

    /**
     * Constructs a new {@code JavaArEngineReflection} instance.
     * This constructor attempts to load the {@code JavaArEngine} class from the default package.
     *
     * @throws RuntimeException if the {@code JavaArEngine} class cannot be found
     */
    public JavaArEngineReflection() {
        try {
            // Load the JavaArEngine class from the default package
            javaArEngineClass = Class.forName("JavaArEngine");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load JavaArEngine class", e);
        }
    }

    /**
     * Invokes a static native method in the {@code JavaArEngine} class by its name.
     *
     * @param methodName the name of the method to invoke
     * @param args       the arguments to pass to the method (can be empty)
     * @return the result of the method invocation
     * @throws RuntimeException if the method cannot be invoked or an error occurs during invocation
     */
    public Object invokeStaticMethod(String methodName, Object... args) {
        try {
            Method method = findMethod(methodName, args);
            return method.invoke(null, args);
        } catch (Exception e) {
            throw new RuntimeException("Failed to invoke method: " + methodName, e);
        }
    }

    /**
     * Finds a method in the {@code JavaArEngine} class that matches the given name and argument count.
     *
     * @param methodName the name of the method to find
     * @param args       the arguments to match the method signature
     * @return the matching method
     * @throws NoSuchMethodException if no method with the given name and argument count is found
     */
    private Method findMethod(String methodName, Object... args) throws NoSuchMethodException {
        for (Method method : javaArEngineClass.getDeclaredMethods()) {
            if (method.getName().equals(methodName) && method.getParameterCount() == args.length) {
                return method;
            }
        }
        throw new NoSuchMethodException("Method " + methodName + " not found");
    }
}
