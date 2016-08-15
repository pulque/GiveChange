package com.lizheblogs.android.change;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class DataDao {

    private static final String PREFERENCES_NAME = "com_lizheblogs_android_change";

    public static final String KEY_YI_JIAO = "KEY_YI_JIAO";
    public static final String KEY_WU_JIAO = "KEY_WU_JIAO";
    public static final String KEY_YI_YUAN = "KEY_YI_YUAN";
    public static final String KEY_YI_YUAN_ZHI = "KEY_YI_YUAN_ZHI";
    public static final String KEY_WU_YUAN = "KEY_WU_YUAN";
    public static final String KEY_SHI_YUAN = "KEY_SHI_YUAN";
    public static final String KEY_ER_SHI_YUAN = "KEY_ER_SHI_YUAN";
    public static final String KEY_WU_SHI_YUAN = "KEY_WU_SHI_YUAN";

    public enum RMB {
        WU_SHI_YUAN,
        ER_SHI_YUAN,
        SHI_YUAN,
        WU_YUAN,
        YI_YUAN_ZHI,
        YI_YUAN,
        WU_JIAO,
        YI_JIAO;
    }

    /**
     * Save change.
     *
     * @param context Context
     * @param key     save key
     * @param size    num of RMB
     */
    public static void save(Context context, String key, int size) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        Editor editor = pref.edit();
        editor.putInt(key, size);
        editor.apply();
    }

    public static void saveAll(Context context, Map<RMB, Integer> nums) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        Editor editor = pref.edit();
        Iterator it = nums.keySet().iterator();
        while (it.hasNext()) {
            RMB key;
            Integer value;
            key = (RMB) it.next();
            value = nums.get(key);
            switch (key) {
                case YI_JIAO:
                    setInt(pref, value, KEY_YI_JIAO);
                    break;
                case WU_JIAO:
                    setInt(pref, value, KEY_WU_JIAO);
                    break;
                case YI_YUAN:
                    setInt(pref, value, KEY_YI_YUAN);
                    break;
                case YI_YUAN_ZHI:
                    setInt(pref, value, KEY_YI_YUAN_ZHI);
                    break;
                case WU_YUAN:
                    setInt(pref, value, KEY_WU_YUAN);
                    break;
                case SHI_YUAN:
                    setInt(pref, value, KEY_SHI_YUAN);
                    break;
                case ER_SHI_YUAN:
                    setInt(pref, value, KEY_ER_SHI_YUAN);
                    break;
                case WU_SHI_YUAN:
                    setInt(pref, value, KEY_WU_SHI_YUAN);
                    break;
                default:
                    setInt(pref, value, KEY_YI_JIAO);
                    break;
            }
        }
        editor.apply();
    }

    private static void setInt(SharedPreferences pref, Integer value, String keyYiJiao) {
        if (value != null) {
            pref.getInt(keyYiJiao, value);
        } else {
            pref.getInt(keyYiJiao, 0);
        }
    }

    /**
     * clear num of RMB
     *
     * @param context Context
     * @param key     key
     */
    public static void clear(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        Editor editor = pref.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * clear all num of RMB
     *
     * @param context Context
     */
    public static void clearAll(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * Give change
     *
     * @param context Context
     * @param key     key
     * @return size
     */
    public static int read(Context context, String key) {
        if (TextUtils.isEmpty(key)) {
            return 0;
        }
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        return pref.getInt(key, 0);
    }

    public static Map<RMB, Integer> readAll(Context context) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_APPEND);
        Map<RMB, Integer> nums = new HashMap<RMB, Integer>();
        nums.put(RMB.YI_JIAO, pref.getInt(KEY_YI_JIAO, 0));
        nums.put(RMB.WU_JIAO, pref.getInt(KEY_WU_JIAO, 0));
        nums.put(RMB.YI_YUAN, pref.getInt(KEY_YI_YUAN, 0));
        nums.put(RMB.YI_YUAN_ZHI, pref.getInt(KEY_YI_YUAN_ZHI, 0));
        nums.put(RMB.WU_YUAN, pref.getInt(KEY_WU_YUAN, 0));
        nums.put(RMB.SHI_YUAN, pref.getInt(KEY_SHI_YUAN, 0));
        nums.put(RMB.ER_SHI_YUAN, pref.getInt(KEY_ER_SHI_YUAN, 0));
        nums.put(RMB.WU_SHI_YUAN, pref.getInt(KEY_WU_SHI_YUAN, 0));
        return nums;
    }
}