package leetcode61;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignHashset705 {


    private static final int hashBase = 769;
    private LinkedList [] set;
    /** Initialize your data structure here. */
    public DesignHashset705() {
        set = new LinkedList[hashBase];
        for (int i = 0; i < hashBase; i++) {
            set[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Iterator<Integer> iter= set[hash].iterator();
        while (iter.hasNext()){
            if( iter.next() == key)return;
        }
        set[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> iter= set[hash].iterator();
        while (iter.hasNext()){
            if( iter.next() == key){
                iter.remove();
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = hash(key);
        Iterator<Integer> iter= set[hash].iterator();
        while (iter.hasNext()){
            if( iter.next() == key){
                return true;
            }
        }
        return false;
    }
    private int hash(int key){
        return key % hashBase;
    }
}
