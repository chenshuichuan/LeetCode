package leetcode61;

import java.util.HashMap;
import java.util.Map;

public class RedundantConnection684 {
    public static void main(String[] args) {
        //[2,3]
        //[1,4]
        //[4,10]
        int[][][] edgess = { {{1,2}, {1,3}, {2,3}},{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}},
                {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}}};
        RedundantConnection684 p = new RedundantConnection684();
        for (int i = 0; i < edgess.length; i++) {
            int [] res = p.findRedundantConnection(edgess[i]);
            for (int j :res) System.out.print(j+",");
            System.out.println();
        }
    }
    //684. 返回删除的无向图中的最后出现的冗余连接，
    //思路：在访问边的时候构建图的并查集，如果边的两个节点在并查集的find值不相等，说明此两节点未联通，此边可以加入图，
    // 若find值相等则已经联通，此边为冗余边，不加入图
    //
    public int[] findRedundantConnection(int[][] edges) {
        int lastI = 0;
        parent = new int[edges.length+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            if(x!=y)union(x,y);
            else lastI = i;
        }
        return edges[lastI];
    }
    public int[]parent;
    private void union(int x,int y){
        int px = find(x);
        int py = find(y);
        parent[y] = px;
        parent[py] = px;
    }
    private int find(int x){
        if(x !=parent[x]){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
