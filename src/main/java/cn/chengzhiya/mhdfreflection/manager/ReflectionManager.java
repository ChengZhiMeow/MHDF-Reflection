package cn.chengzhiya.mhdfreflection.manager;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflectionManager {
    /**
     * 获取指定类的构造器实例
     *
     * @param clazz     类实例
     * @param argsTypes 传参类型
     * @return 构造器实例
     */
    @SneakyThrows
    public Constructor<?> getConstructor(Class<?> clazz, Class<?>... argsTypes) {
        return clazz.getConstructor(argsTypes);
    }

    /**
     * 初始化指定构造器实例
     *
     * @param constructor 构造器实例
     * @param args        传入参数
     * @return 类对象
     */
    @SneakyThrows
    public <T> T newInstance(Constructor<?> constructor, Object... args) {
        return (T) constructor.newInstance(args);
    }


    /**
     * 通过反射指定类实例获取指定方法的方法实例
     *
     * @param clazz      类实例
     * @param methodName 方法名称
     * @param accessible 强制访问
     * @param argsTypes  传参类型
     * @return 方法实例
     */
    @SneakyThrows
    public Method getMethod(Class<?> clazz, String methodName, boolean accessible, Class<?>... argsTypes) {
        Method method = clazz.getDeclaredMethod(methodName, argsTypes);
        method.setAccessible(accessible);
        return method;
    }

    /**
     * 通过反射指定类实例获取指定方法的变量实例
     *
     * @param clazz      类实例
     * @param fieldName  变量名称
     * @param accessible 强制访问
     * @return 变量实例
     */
    @SneakyThrows
    public Field getField(Class<?> clazz, String fieldName, boolean accessible) {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(accessible);
        return field;
    }

    /**
     * 通过反射指定方法实例获取返回值
     *
     * @param method 方法实例
     * @param object 对象实例
     * @param args   传入参数
     * @return 返回值
     */
    @SneakyThrows
    public <T> T invokeMethod(Method method, Object object, Object... args) {
        Object invokeObject = method.invoke(object, args);
        if (invokeObject == null) {
            return null;
        }
        return (T) invokeObject;
    }

    /**
     * 获取反射指定变量实例的返回值
     *
     * @param field  变量实例
     * @param object 对象实例
     */
    @SneakyThrows
    public <T> T getFieldValue(Field field, Object object) {
        return (T) field.get(object);
    }

    /**
     * 通过反射指定变量实例的返回值
     *
     * @param field  变量实例
     * @param object 对象实例
     * @param value  修改的值
     */
    @SneakyThrows
    public void setFieldValue(Field field, Object object, Object value) {
        field.set(object, value);
    }
}
