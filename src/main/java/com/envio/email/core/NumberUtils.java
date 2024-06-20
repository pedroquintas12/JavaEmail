package com.envio.email.core;

public class NumberUtils {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) return false;
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static Integer defaultIfEmpty(Integer objValue, Integer orDefaultValue) {
        try {
            if (objValue == null) return orDefaultValue;
            return objValue;
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }

    public static Long defaultIfEmpty(Long objValue, Long orDefaultValue) {
        try {
            if (objValue == null) return orDefaultValue;
            return objValue;
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }

    public static Double defaultIfEmpty(Double objValue, Double orDefaultValue) {
        try {
            if (objValue == null) return orDefaultValue;
            return objValue;
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }

    public static Long parseToNumberOrDefault(String objValue, Long orDefaultValue) {
        try {
            if (objValue == null || objValue.isEmpty()) return orDefaultValue;
            return Long.parseLong(objValue);
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }

    public static Double parseToNumberOrDefault(String objValue, Double orDefaultValue) {
        try {
            if (objValue == null || objValue.isEmpty()) return orDefaultValue;
            return Double.parseDouble(objValue);
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }

    public static String extractNumber(String value) {
        var number = value.replaceAll("\\D+", "");
        return number.replaceAll("\\s+", "");
    }

    public static Long extractNumber(String value, Long orDefaultValue) {
        return parseToNumberOrDefault(extractNumber(value), orDefaultValue);
    }

    public static Double extractNumber(String value, Double orDefaultValue) {
        return parseToNumberOrDefault(extractNumber(value), orDefaultValue);
    }
}
