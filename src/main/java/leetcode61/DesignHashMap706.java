package leetcode61;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignHashMap706 {

    class Pair{
        private int key;
        private int value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }
        public void setKey(int key) {
            this.key = key;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
    }
    private static final int hashBase = 769;
    private LinkedList [] set;
    /** Initialize your data structure here. */
    public DesignHashMap706() {
        set = new LinkedList[hashBase];
        for (int i = 0; i < hashBase; i++) {
            set[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<Pair> iter= set[hash].iterator();
        while (iter.hasNext()){
            if( iter.next().key == key)return;
        }
        set[hash].offerLast(new Pair(key,value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        Iterator<Pair> iter= set[hash].iterator();
        while (iter.hasNext()){
            Pair p = iter.next();
            if( p.key == key)return p.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        Iterator<Pair> iter= set[hash].iterator();
        while (iter.hasNext()){
            Pair p = iter.next();
            if( p.key == key){
                iter.remove();
                return;
            }
        }
    }
    private int hash(int key){
        return key % hashBase;
    }
}
