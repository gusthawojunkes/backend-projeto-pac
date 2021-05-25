package br.edu.catolicasc.utils;

import java.util.List;
import java.util.Map;

public class Utils {

    public static Boolean isEmpty(Object value) {
        if (value == null) return true;
        if (value instanceof String) {
            String string = value.toString();
            if (string.equals("")) return true;
            return string.trim().equals("");
        }
        if (value instanceof List) return  ((List<?>) value).isEmpty();
        if (value instanceof Map) return ((Map<?, ?>) value).isEmpty();

        return false;
    }

    public static Boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }

}
