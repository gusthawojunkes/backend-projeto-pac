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

        private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

        public static Boolean isValid(String email) {
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        public static Boolean isNotValid(String email) {
            return !isValid(email);
        }

    }
}
