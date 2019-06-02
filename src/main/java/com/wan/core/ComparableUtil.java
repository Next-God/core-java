package com.wan.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ComparableUtil {
    public static <T, R> void listToDo(Collection<T> t, Handler<T, R> c) {
        for (T item : t) {
            if (item == null) continue;
            c.to(item);
        }
    }

    public static <T, R> Map<R, T> listToMap(Collection<T> t, Handler<T, R> c) {
        Map<R, T> map = new HashMap<R, T>();

        for (T item : t) {
            R rValue = c.to(item);
            if (rValue != null)
                map.put(rValue, item);
        }
        return map;
    }

    public static <T, R> void mapToDo(Map<T, R> t, Handler<R, T> c) {
        for (R item : t.values()) {
            c.to(item);
        }
    }

    public static <T, R> Collection<R> listToList(Collection<T> t, Handler<T, R> c) {
        Collection<R> list = null;
        try {
            list = t.getClass().newInstance();
        } catch (Exception e) {
        }
        
        for (T item : t) {
            if (item == null) continue;
            list.add(c.to(item));
        }
        return list;
    }

    public static <T, R> void sort(Collection<T> t, Comparable<R> comparable){

    }

    public interface Handler<T, R> {
        R to(T arg);
    }

}
