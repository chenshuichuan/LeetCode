package leetcode25;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args){

    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i]))hashMap.put(nums[i],hashMap.get(nums[i])+1);
            else hashMap.put(nums[i],1);
        }
        List<Node> nodes = new ArrayList<Node>();
        for (Integer a :
                hashMap.keySet()) {
             nodes.add(new Node(a,hashMap.get(a)));
        }
        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return  o2.value-o1.value;
            }
        });

        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = nodes.get(i).key;
        }
        return results;
    }
    class Node {
        public int key;
        public int value;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }

    }
}

