package com.envio.email.core;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static boolean stringIsNullOrEmpty(String value) {
        return (value == null || value.isEmpty() || value.isBlank());
    }

    public static String parseOrDefault(Long objValue, String orDefaultValue) {
        try {
            if (objValue == null) return orDefaultValue;
            return objValue.toString();
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }

    public static String defaultIfEmpty(String objValue, String orDefaultValue) {
        try {
            if (objValue == null || objValue.isEmpty()) return orDefaultValue;
            return objValue;
        } catch (Exception ex) {
            return orDefaultValue;
        }
    }


    public static boolean hasText(String textSearch, String toSearch) {
        return !Arrays.stream(textSearch.split(";")).filter(t -> {
            var textSearchOk = toSearch.trim().toUpperCase();
            var sizeText = t.length();
            var sizeMsg = textSearchOk.length();
            if (sizeText == sizeMsg && t.trim().toUpperCase().contains(textSearchOk)) {
                return true;
            }
            return false;
        }).toList().isEmpty();
    }

    public static String encodeBase64(String text) {
        if (text == null || text.isBlank()) return "";
        return Base64.getEncoder().encodeToString(text.getBytes());
    }

    public static String decodeBase64(String text) {
        if (text == null || text.isBlank()) return "";
        return new String(Base64.getDecoder().decode(text), StandardCharsets.ISO_8859_1);
    }

    public static String decodeBase64(String text, Charset charset) {
        if (text == null || text.isBlank()) return "";
        return new String(Base64.getDecoder().decode(text), charset);
    }


    public static boolean isEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static int countMatches(String text, String str) {
        if (isEmpty(text) || isEmpty(str)) {
            return 0;
        }
        Matcher matcher = Pattern.compile(str).matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static String html5(String body) {
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <title>Email LigContato</title>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "  <body>\n" +
                body +
                "  </body>\n" +
                "</html>";
    }

    public static String unaccent(String src) {
        return Normalizer
                .normalize(src, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
    }

    public static String replaceBarDate(String text) {
        return text.replaceAll(Pattern.quote("/"), "-");
    }

    public static String replaceTemplateColors(String colorPrimaryValue, String text) {
        try {
            var colorPrimary = "#D1D1D1";
            // var colorSecondary = "--secondary: #faf0e6;";
            if (text == null) return "";
            return Pattern.compile(colorPrimary, Pattern.LITERAL | Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)
                    .matcher(text)
                    .replaceAll(Matcher.quoteReplacement(StringUtils.defaultIfEmpty(colorPrimaryValue, "#6495ed")));
        } catch (Exception e) {
            return text;
        }
    }

}
