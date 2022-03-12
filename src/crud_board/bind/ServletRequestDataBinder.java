package crud_board.bind;

import javax.servlet.ServletRequest;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class ServletRequestDataBinder {

    public static Object bind(ServletRequest request, Class<?> dataType, String dataName) throws Exception {

        if (isPrimitiveType(dataType)) {
            return createValueObject(dataType, request.getParameter(dataName));
        }

        Set<String> paramNames = request.getParameterMap().keySet();
        Object dataObj = dataType.getDeclaredConstructor().newInstance();
        Method setter = null;

        for (String paramName : paramNames) {
            setter = findSetter(dataType, paramName);

            if (setter != null) {
                setter.invoke(dataObj, createValueObject(setter.getParameterTypes()[0], request.getParameter(paramName)));
            }
        }

        return dataObj;
    }

    private static boolean isPrimitiveType(Class<?> type) {
        if (type.getName().equals("int") || type == Integer.class ||
            type.getName().equals("long") || type == Long.class ||
            type.getName().equals("float") || type == Float.class ||
            type.getName().equals("double") || type == Double.class ||
            type.getName().equals("boolean") || type == Boolean.class ||
            type == String.class || type == Date.class) {
            return true;
        } else {
            return false;
        }
    }

    private static Object createValueObject(Class<?> type, String value) {
        if (type.getName().equals("int") || type == Integer.class) {
            return Integer.valueOf(value);
        } else if (type.getName().equals("long") || type == Long.class) {
            return Long.valueOf(value);
        } else if (type.getName().equals("float") || type == Float.class) {
            return Float.valueOf(value);
        } else if (type.getName().equals("double") || type == Double.class) {
            return Double.valueOf(value);
        } else if (type.getName().equals("boolean") || type == Boolean.class) {
            return Boolean.valueOf(value);
        } else if (type == String.class) {
            return String.valueOf(value);
        } else {
            return java.sql.Date.valueOf(value);
        }
    }

    private static Method findSetter(Class<?> type, String name) {
        Method[] methods = type.getMethods();

        String propName = null;
        for (Method m : methods) {
            if (m.getName().startsWith("set")) {
                propName = m.getName().substring(3);
                if (propName.toLowerCase().equals(name.toLowerCase())) {
                    return m;
                }
            }
        }
        return null;
    }
}
