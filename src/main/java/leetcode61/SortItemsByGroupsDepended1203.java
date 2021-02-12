package leetcode61;

import java.util.*;

public class SortItemsByGroupsDepended1203 {
    public static void main(String[] args) {
        SortItemsByGroupsDepended1203 p = new SortItemsByGroupsDepended1203();

        int[]n = {8,8};
        int[]m = {2,2};
        int[][]groups = {{-1,-1,1,0,0,1,0,-1},{-1,-1,1,0,0,1,0,-1}};
        Integer[][][] beforeItemss ={{{},{6},{5},{6},{3,6},{},{},{}},{{},{6},{5},{6},{3},{},{4},{}}};
        for (int i = 0; i < beforeItemss.length; i++) {
            List<List<Integer>> beforeItems = new ArrayList<>();

            for (int j = 0; j < beforeItemss[i].length; j++) {
                List<Integer> list = Arrays.asList(beforeItemss[i][j]);
                if(list == null) System.out.println("list == null");
                beforeItems.add(list);
            }
            //System.out.println(beforeItems);
            int[] group = p.sortItems(n[i],m[i],groups[i],beforeItems);

            for (int k : group) {
                System.out.print(k+",");
            }
            System.out.println();
        }
    }
    //1203. 项目管理 并查集合并且排序项目组，
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 并查集合并且排序项目组
        int[] prioritys = new int[group.length];
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < group.length; i++) {
            List<Integer> list = beforeItems.get(i);
            for (int j: list){
                prioritys[j]++;
                unionFind.union(i,j);
            }
        }
        PriorityQueue<Item> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < prioritys.length; i++) {
            priorityQueue.add(new Item(i,prioritys[i]));
        }
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        while (!priorityQueue.isEmpty()){
           Item item =  priorityQueue.poll();
           int p = unionFind.find(item.ind);
           if(hashMap.containsKey(p))hashMap.get(p).add(item.ind);
           else{
               List<Integer> list = new ArrayList<>();
               list.add(item.ind);
               hashMap.put(p,list);
           }
        }
        System.out.println(hashMap);
        boolean[] groupUsed = new boolean[m];
        HashMap<Integer,HashSet<Integer>> itemUsedGroup = new HashMap<>();
        //对同一项目组的未负责项目标记为遇到的第一个负责的小组负责
        for (int i = 0; i < group.length; i++) {
            if(group[i]!=-1){
                groupUsed[group[i]] = true;
                int px = unionFind.find(i);
                if(itemUsedGroup.containsKey(px))itemUsedGroup.get(px).add(group[i]);
                else{
                    HashSet<Integer> set = new HashSet<>();
                    set.add(group[i]);
                    itemUsedGroup.put(px,set);
                }
            }
        }
        System.out.println(itemUsedGroup);
        for (int key : hashMap.keySet()) {
            if(itemUsedGroup.containsKey(key)){
                //该项目组负责的小组数大于2，先不处理
                HashSet<Integer>set = itemUsedGroup.get(key);
                if(set.size()>2)break;
                //该项目组负责的小组数小于2，
                List<Integer> list = hashMap.get(key);
                if(set.size()==1){
                    //mw就是负责这整个项目组的唯一小组
                    int mw = -1;
                    for (int setitem:set) mw = setitem;
                    for (int i=0;i<list.size();i++)group[list.get(i)] = mw;
                }
                else if(set.size() == 2){
                    int i = 0;
                    int mwInd=-1;
                    for (;i<list.size();i++){
                        if(group[list.get(i)] !=-1){
                            if(mwInd==-1)mwInd = group[list.get(i)];
                            else break;
                        }
                    }
                    int mw2 = group[list.get(i)];
                    for (int j = 0; j < list.size(); j++) {
                        if(j<i)group[list.get(j)] = mwInd;
                        else group[list.get(j)] = mw2;
                    }
                }
            }
        }
        return group;
    }
    class UnionFind{
        int[] parent;
        int[] rank;
        public UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        //就此题而言，x依赖y，所以x并入y
        public void union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py)return;
            //x并入y
            parent[x] = py;
            parent[px] = py;
            if(rank[px]==rank[py])rank[py]++;
            if(rank[px]>rank[py])rank[py] = rank[px]+1;
        }
        public int find(int x){
            int p = parent[parent[x]];
            if(parent[x]!=p){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
    class Item implements Comparable{
        public Item(int ind, int priority){
            this.ind = ind;
            this.priority = priority;
        }
        public int ind;
        public int priority;

        @Override
        public int compareTo(Object o) {
            Item i = (Item) o;
            return i.priority - this.priority;
        }
    }
}
