package ru.sbt.hw4;


import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<K> implements CountMap<K> {

    private final Map<K, Integer> map = new HashMap<K, Integer>();

    // добавляет элемент в этот контейнер.
    @Override
    public void add(K o) {
        if (map.get(o) == null) {
            map.put(o, 1);
        } else {
            map.put(o, map.get(o) + 1);
        }
    }

    //Возвращает количество добавлений данного элемента
    @Override
    public int getCount(K o) {
        if (map.containsKey(o)) {
            return map.get(o);
        } else {
            return 0;
        }
    }

    //Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
    @Override
    public int remove(K o) {
        if (map.containsKey(0)) {
            int value = map.get(o);
            map.remove(o);
            return value;
        } else {
            return 0;
        }
    }

    //количество разных элементов
    @Override
    public int size() {
        return map.size();
    }

    //Добавить все элементы из source в текущий контейнер, при совпадении ключей, суммировать значения
    @Override
    public void addAll(CountMap<K> source) {
        for (K key : source.toMap().keySet()) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    @Override
    public Map<K, Integer> toMap() {
        return map;
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    @Override
    public void toMap(Map<K, Integer> destination) {
        for (Map.Entry<K, Integer> entry : map.entrySet()) {
            K key = entry.getKey();
            int value = entry.getValue();

            if (destination.containsKey(entry.getKey())) {
                destination.put(key, value + destination.get(key));
            } else {
                destination.put(key, destination.get(key));
            }
        }
    }
}
