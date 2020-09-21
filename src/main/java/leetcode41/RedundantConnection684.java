package leetcode41;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RedundantConnection684 {
    public static void main(String[] args) {
        RedundantConnection684 p = new RedundantConnection684();
        int[][] edges ={{1,2}, {1,3}, {2,3}};
        //{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}}
        System.out.println(Arrays.toString(p.findRedundantConnection(edges)));
    }
    public int[] findRedundantConnection(int[][] edges) {
        int lastI = 0;
        Map<Integer,Integer> visited = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            visited.put(edges[i][0],edges[i][1]);
        }
        return edges[lastI];
    }
    public int[] findRedundantConnection2(int[][] edges) {
        int lastI = 0;
        Map<Integer,Integer> visited = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if(visited.containsKey(edges[i][0]))lastI = i;
            else visited.put(edges[i][0],edges[i][0]);
            if(visited.containsKey(edges[i][1])) lastI= i;
            else visited.put(edges[i][1],edges[i][1]);
        }
        return edges[lastI];
    }
}
