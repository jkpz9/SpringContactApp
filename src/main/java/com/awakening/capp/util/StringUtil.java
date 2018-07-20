package com.awakening.capp.util;

/**
 *
 * @author hoangit
 */
public class StringUtil {
    public static String toCommaSeparateString(Object[] items)
    {
        StringBuilder sb = new StringBuilder();
        for (Object item : items){
            sb.append(item).append(",");
        }
        if(sb.length() > 0)
        {
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
