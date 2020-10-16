package com.example.shopping.util;

import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;

import lombok.extern.slf4j.Slf4j;
import lombok.var;

@Slf4j
public class StringUtil {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String NEW_LINE = System.getProperty("line.separator");

    /**
     * Returns true if the given string is null or empty string. Otherwise returns
     * false.
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        return (value == null || value.trim().length() == 0);
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static Date convertStringToDate(String dateString, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        // set Lenient
        format.setLenient(false);
        Date date = null;

        if (StringUtil.isNotEmpty(dateString)) {
            date = format.parse(dateString, new ParsePosition(0));
        }
        return date;
    }

    public static String convertDateToString(Date date, String dateFormat) {

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);

        String dateStr = "";

        if (date != null) {
            dateStr = format.format(date);
        }

        return dateStr;
    }

    public static String convertCurrency(BigDecimal ammount, String currencyCode) {
        if (currencyCode == null) {
            currencyCode = "IN";
        }
        Currency currency = Currency.getInstance(currencyCode);
        return String.format("%s", currency.getSymbol(), new DecimalFormat("###############.##").format(ammount));
    }

    public static String convertCurrency(BigDecimal ammount) {
        Currency currency = Currency.getInstance(Locale.getDefault());
        return String.format("%s %6.2f", currency.getSymbol(), ammount);
    }

    public static String convertBlobToString(Blob blob) throws SQLException {
        String str = null;
        if (blob != null) {
            try {
                str = new String(blob.getBytes(1, (int) blob.length()));
            } catch (SQLException ex) {
                throw ex;
            }
        }
        return str;
    }

    /*
     * public static Blob convertStringToBlob(String str){ Blob blob = null; if
     * (!isEmpty(str)){ blob = org.hibernate.Hibernate.createBlob(str.getBytes()); }
     * return blob; }
     */

    public static int safeParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            log.error(e.getMessage(), e);
            // Eat Exception
        }
        return 0;
    }

    public static int safeParseIntReturnOne(String s) {
        int retValue = 1;
        if (StringUtil.isNotEmpty(s)) {
            try {
                retValue = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                log.error(e.getMessage(), e);
                // Eat Exception here
            }
        }
        return retValue;
    }

    public static short safeParseShortReturnOne(String s) {
        short retValue = 1;
        if (StringUtil.isNotEmpty(s)) {
            try {
                retValue = Short.parseShort(s);
            } catch (NumberFormatException e) {
                log.error(e.getMessage(), e);
                // Eat Exception here
            }
        }
        return retValue;
    }

    public static int[] stringToArray(String stringToConvert) {
        int[] statusId = new int[2];
        int i = 0;
        StringTokenizer tokens = new StringTokenizer(stringToConvert, ",");
        while (tokens.hasMoreTokens()) {
            statusId[i] = Integer.parseInt(tokens.nextToken());
            i++;
        }
        return statusId;

    }

    /**
     * This method determines if a string object has been modified from its original
     * value.
     *
     * @param originalValue
     * @param newValue
     * @return true if different.
     */
    public static boolean isModified(Object originalValue, Object newValue) {
        if (originalValue != null | newValue != null) {
            // Either one is null or both not null
            if (!(originalValue == null ^ newValue == null)) {
                // Both are not null so compare
                return !originalValue.equals(newValue);
            }
            return true;
        }
        return false;
    }

    /**
     * This method gets the content between the first occurrence of startTag. Its a
     * very light weight function to parse a tag instead of using heavy weight
     * marshalling.
     *
     * and the first occurrence of the endTag.
     *
     * @param xmlString
     * @param startTag
     * @param endTag
     * @return content between the startTag and endTag
     */
    public static String getContentBetweenTags(String xmlString, String startTag, String endTag) {
        String content = null;

        int startPos = xmlString.indexOf(startTag);
        if (startPos > -1) {
            startPos = startPos + startTag.length();
            int endPos = xmlString.indexOf(endTag, startPos);
            if (endPos > -1) {
                content = xmlString.substring(startPos, endPos);
            }
        }

        return content;
    }

    /**
     * Converts a Map to a HTTP Query String in the format like ?K1=V1&K2=V2&K3=V3
     *
     * @param map           - {@code Map<String, String>}
     * @param charStartWith - Char
     * @return
     */
    public static String convertMapToQueryString(Map<String, String> map, char charStartWith) {
        StringBuilder params = new StringBuilder();
        if (map != null && map.size() > 0) {
            params.append(charStartWith);
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                String key = it.next();
                params.append(String.format("%s=%s&", key, map.get(key)));
            }
            params.deleteCharAt(params.length() - 1);
        }
        return params.toString();
    }

    public static boolean compareStrings(String one, String two) {
        if (StringUtil.isEmpty(one) && StringUtil.isEmpty(two)) {
            return true;
        }

        if (StringUtil.isNotEmpty(one)) {
            return one.equals(two);
        }

        if (StringUtil.isNotEmpty(two)) {
            return two.equals(one);
        }
        return false;
    }

    public static String padRightWithExtraPad(String s, int n,int extraPad) {
        if(s!=null && s.length() > n) {
            var totleExtraLen = s.substring(n).length();
            s = s.substring(0,n) +"\n"+String.format("%1$-" + extraPad + "s", " ") +  s.substring(n);
            n = 2*n +totleExtraLen -("\n".length()+ extraPad+1);
        }
        if (s == null) {
            s = "";
        }
        return String.format("%1$-" + n + "s", s + "");
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s + "");
    }

    public static String padCentral(String s, int n) {
        s= getValue(s);
        var stringLen = s.length();
        if(stringLen > n) {
            stringLen = n;
        }
        var pendingLenth = n-stringLen;
        return padRight("", pendingLenth/2)+s;
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s + "");
    }

    public static String getValue(String s) {
        if (s == null) {
            s = "";
        }
        return String.format("%s", s);
    }

    public static String fill(String s , String color) {
        if (s == null) {
            s = "";
        }

        if(color==null) {
            color = ANSI_RED;
        }



        return color+s+ANSI_RESET;
    }

    public static String getValue(String s, int endIndex) {
        if (s == null) {
            s = "";
        }
        return String.format("%s", s.length() > endIndex ? s.substring(0, endIndex) : s);
    }

    public static String getValue(String s, String defaultValue) {
        if (isEmpty(s)) {
            return isEmpty(defaultValue) ? "" : defaultValue;
        }
        return s;
    }

    public static String roundOffTo2DecPlaces(BigDecimal val) {
        return String.format("%.2f", val);
    }

    public static String getCurrentLocaleLanguage() {
        var languageCode = System.getProperty("user.language");
        var countryCode = System.getProperty("user.country");
        return languageCode + "-" + countryCode.toUpperCase();
    }

    public static Double getValue(Double value) {
        return Optional.ofNullable(value).orElse(0.00) ;
    }

}
