package br.edu.catolicasc.utils;

public class StringUtils {

    public static Boolean isBlank(String string) {
        if (string == null) return true;
        if (string.equals("")) return true;
        if (string.trim().equals("")) return true;
        return false;
    }

    public static Boolean isNotBlank(String string) {
        return !isBlank(string);
    }

}
