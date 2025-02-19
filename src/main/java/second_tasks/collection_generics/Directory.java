package second_tasks.collection_generics;

import java.util.*;

public class Directory<K, V> {

    private Map<K, V> directoryMap;
    private List<V> directoryList;
    private Set<V> directorySet;

    public Directory(Map<K, V> directoryMap) {
        this.directoryMap = new HashMap<>();
    }

    public Directory(List<V> directoryList){
        this.directoryList = new ArrayList<>();
    }

    public Directory(Set<V> directorySet){
        this.directorySet = new HashSet<>();
    }


    // Добавление элементов
    public void mapAddElement(K key, V value){
        directoryMap.put(key, value);
    }

    public void listAddElement(V value){
        directoryList.add(value);
    }

    public void setAddElement(V value){
        directorySet.add(value);
    }


    // Удаление элементов
    public void mapElementDelete(K key){
        directoryMap.remove(key);
    }

    public void listElementDelete(V value){
        directoryList.remove(value);
    }

    public void setElementDelete(V value){
        directorySet.remove(value);
    }


    // Проверки наличия элементов
    public boolean mapElementContains(K key){
       return directoryMap.containsKey(key);
    }

    public boolean listElementContains(V value){
        return directoryList.contains(value);
    }

    public boolean setElementContains(V value){
        return directorySet.contains(value);
    }


    // Вывод всех записей в справочниках
    public void mapElementShow(){
        System.out.println(directoryMap);
    }

    public void listElementShow(){
        System.out.println(directoryList);
    }

    public void setElementShow(){
        System.out.println(directorySet);
    }

}
