package ru.sbt.hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? super T> source, int size) {
        if ((source.size() == size) || (source.size() < size)) {
            return source;
        } else {
            return source.subList(0, size);
        }
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    //true если первый лист содержит все элементы второго
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    //true если первый лист содержит хотя-бы 1 второго
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T element : c2) {
            if (c1.contains(element)) {
                return true;
            }
        }
        return false;
    }

    //Нужно создать копию листа, отсортировать его, и вернуть sublist, в котором находятся элементы в диапазоне от min до max.
// Элементы сравнивать через Comparable.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List range(List<? extends T> list, T min, T max) {
        List<? super T> copyList = new ArrayList<>(list);
        Collections.sort(copyList, (o1, o2) -> Integer.compare(o1.hashCode(), o2.hashCode()));
        if (copyList.indexOf(min) < copyList.indexOf(max)) {
            return copyList.subList(copyList.indexOf(min), copyList.indexOf(max));
        } else {
            return newArrayList();
        }
    }

    //Нужно создать копию листа, отсортировать его, и вернуть sublist, в котором находятся элементы в диапазоне от min до max.
// Элементы сравнивать через Comparator.
// Пример range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
    public static <T> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<? super T> copyList = new ArrayList<T>(list);
        Collections.sort(list, comparator);
        if (copyList.indexOf(min) < copyList.indexOf(max)) {
            return copyList.subList(copyList.indexOf(min), copyList.indexOf(max));
        } else {
            return newArrayList();
        }
    }
}
