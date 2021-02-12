package leetcode61;

import java.util.HashMap;
import java.util.HashSet;

public class MostStonesRemoved947 {
    public static void main(String[] args) {
        // 5,3,0,2
        int[][][] stoness = {
                {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}},
                {{0,0},{0,2},{1,1},{2,0},{2,2}},
                {{0,0}},
                {{0,1},{1,0},{1,1}}};

        MostStonesRemoved947 p = new MostStonesRemoved947();
        for (int i = 0; i < stoness.length; i++) {
            int[][] stones = stoness[i];
            System.out.println(p.removeStones(stones));
        }

    }
    //947. 移除最多的同行或同列石头
    //并查集
    public int removeStones(int[][] stones){
        if(stones.length<=1)return 0;
        parent= new int[stones.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] =i;
        }
        HashMap<Integer, Integer> mapx = new HashMap<>();
        HashMap<Integer, Integer> mapy = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            if(mapx.containsKey(stones[i][0]))
                union(mapx.get(stones[i][0]),i);
            else mapx.put(stones[i][0],i);

            if(mapy.containsKey(stones[i][1]))
                union(mapy.get(stones[i][1]),i);
            else mapy.put(stones[i][1],i);
        }
        HashSet<Integer> root = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            root.add(find(i));
        }
        return stones.length - root.size();
    }
    //parent[x]代表stones下标的x点所在子图的根在stones的下标。
    private int []parent;
    //y并入x所在的子图
    private void union(int x,int y){
        int px = find(x);
        int py = find(y);
        parent[y] = px;
        parent[py] = px;
    }
    private int find(int x){
        if(x!=parent[x]){
            parent[x] = parent[parent[x]];
        }
        return parent[x];
    }

    //记录横竖坐标对应的点，遍历移除
    public int removeStones3(int[][] stones) {
        int res =0;
        if(stones.length<=1)return 0;
        //如果坐标x或y轴已经存在，则该点要被合并的，其x/y轴加入合并集
        HashSet<Integer> remx = new HashSet<>();
        HashSet<Integer> remy = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            boolean flag = true;

            //处理横轴其他点
            if(remx.contains(stones[i][0])){
                remy.add(stones[i][1]);
                flag = false;
            }
            //处理竖轴其他点
            if(remy.contains(stones[i][1])){
                remx.add(stones[i][0]);
                flag = false;
            }
            //该点标记移除
            if(!flag)res++;
            else{
                remy.add(stones[i][1]);
                remx.add(stones[i][0]);
            }
        }
        return res;
    }

    //947. 移除最多的同行或同列石头
    //记录横竖坐标对应的点，遍历移除
    //该方法行不通，后面的点无法对前面的点的结果产生影响
    public int removeStones2(int[][] stones) {
        int res =0;
        if(stones.length<=1)return 0;
        HashMap<Integer, HashSet<Integer>> mapx = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> mapy = new HashMap<>();
        boolean[] isRemove = new boolean[stones.length];
        for (int i = 0; i < stones.length; i++) {
            if(mapx.containsKey(stones[i][0])) mapx.get(stones[i][0]).add(i);
            else{
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                mapx.put(stones[i][0],set);
            }
            if(mapy.containsKey(stones[i][1])) mapy.get(stones[i][1]).add(i);
            else{
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                mapy.put(stones[i][1],set);
            }
        }
        HashSet<Integer> resx = new HashSet<>(mapx.keySet());
        HashSet<Integer> resy = new HashSet<>(mapy.keySet());
        for (int i = 0; i < stones.length; i++) {
            boolean flag = isRemove[i];
            if(!resx.contains(stones[i][0]) || !resy.contains(stones[i][1])){
                flag = true;
            }
            //处理横轴其他点
            if(resx.contains(stones[i][0])){
                HashSet<Integer> set = mapx.get(stones[i][0]);
                for (int j : set) isRemove[j] = true;
                resx.remove(stones[i][0]);
            }
            //处理竖轴其他点
            if(resy.contains(stones[i][1])){
                HashSet<Integer> set = mapy.get(stones[i][1]);
                for (int j : set) isRemove[j] = true;
                resy.remove(stones[i][1]);
            }
            //该点已经标记移除
            isRemove[i] = flag;
        }
        for (int i = 0; i < isRemove.length; i++) {
            if(isRemove[i])res++;
        }
        return res;
    }
}
