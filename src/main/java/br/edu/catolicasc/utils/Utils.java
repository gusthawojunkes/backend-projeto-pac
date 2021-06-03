package br.edu.catolicasc.utils;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static class Email {

        private static final String REGEX = "^(.+)@(.+)$";

        public static Boolean isNotValid(String email) {
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(email);
            return !matcher.matches();
        }

    }
}
