package leetcode61;

import java.util.*;

public class SmallestStringWithSwaps1202 {
    public static void main(String[] args) {
        SmallestStringWithSwaps1202 p = new SmallestStringWithSwaps1202();


        String[] res = {"bacd","abcd","abc","dqwyt","deykuy"};
        String[] strings = {"dcab","dcab","cba","qdwyt","udyyek"};
        Integer[][][] pairss = {{{0,3},{1,2}},{{0,3},{1,2},{0,2}},{{0,1},{1,2}},
                {{2,3},{3,2},{0,1},{4,0},{3,2}},
                {{3,3},{3,0},{5,1},{3,1},{3,4},{3,5}}
        };
        for(int i=0;i<strings.length;i++){
            List<List<Integer>> pairs = new ArrayList<>();
            for (int j = 0; j < pairss[i].length; j++) {

                List<Integer> list=Arrays.asList(pairss[i][j]);
                pairs.add(list);
            }
            //System.out.println(pairs);
            String temp = p.smallestStringWithSwaps(strings[i],pairs);
            System.out.println(res[i]+" : "+temp);
        }

    }
    //优化smallestStringWithSwaps， 并查集
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;
        // 第 1 步：将任意交换的结点对输入并查集
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1, index2);
        }
        //并集
        HashMap<Integer,TreeSet<Integer>> setHashMap = new HashMap();
        for (List<Integer> pair : pairs) {
            int i = pair.get(0);
            int j = pair.get(1);
            int p = unionFind.find(i);
            if(setHashMap.containsKey(p)){
                setHashMap.get(p).add(i);
                setHashMap.get(p).add(j);
            }else{
                TreeSet<Integer> set= new TreeSet<>();
                set.add(i);
                set.add(j);
                setHashMap.put(p,set);
            }
        }
        System.out.println(setHashMap.toString());
        char[] charArray = s.toCharArray();
        for (Integer key : setHashMap.keySet()) {
            TreeSet<Integer> set= setHashMap.get(key);
            if(set ==null)continue;
            //计数排序
            int[]count = new int[26];
            for (Integer i : set) {
                count[charArray[i]-'a']++;
            }
            for (int i =0;i<26;i++){
                int j =count[i];
                while(j>0){
                    if(!set.isEmpty())charArray[set.pollFirst()] = (char)('a'+i);
                    j--;
                }
            }
        }
        return new String(charArray);
    }
    private class UnionFind {
        private int[] parent;
        /** 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）*/
        private int[] rank;
        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度仅加了 1
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                // 同理，此时以 rootX 为根结点的树的高度不变
                parent[rootY] = rootX;
            }
        }
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
    // 思路是对的，就是复杂度太高，超时了
    //交换索引的前置后置具有同等地位，都应该被考虑
    //扩展与合并 交换索引下标，即对于[0,1] 和[0,2],可以扩展出[1,2] 交换索引
    public String smallestStringWithSwaps3(String s, List<List<Integer>> pairs) {
        //扩展与合并
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            int c1 = pairs.get(i).get(0);
            int c2 = pairs.get(i).get(1);
            if(c1!=c2){
                if(map.containsKey(c1)) map.get(c1).add(c2);
                else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(c2);
                    map.put(c1,set);
                }
                if(map.containsKey(c2)) map.get(c2).add(c1);
                else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(c1);
                    map.put(c2,set);
                }
            }
        }
       // System.out.println(map.toString());
        while(true){
            boolean noChange = true;
            for (int i : map.keySet()) {
                HashSet<Integer> seti = new HashSet<>(map.get(i));
                for (int j : seti) {
                    if(map.containsKey(j)){
                        HashSet<Integer> setj = new HashSet<>(map.get(j));
                        for (int k : setj) {
                            if(!seti.contains(k)){
                                noChange = false;
                                map.get(i).add(k);
                                if(map.containsKey(k))map.get(k).add(i);
                                else {
                                    HashSet<Integer> setk = new HashSet<>();
                                    setk.add(i);
                                    map.put(k,setk);
                                }
                            }
                        }
                    }
                }
            }
            if(noChange) break;
        }
        //System.out.println(map.toString());
        char[] cs = s.toCharArray();
        while(true){
            boolean noChange = true;
            for (int i : map.keySet()) {
                HashSet<Integer> seti = map.get(i);
                for (int j : seti) {
                    if(i<j && cs[i]>cs[j]){
                        char c = cs[i];
                        cs[i] = cs[j];
                        cs[j] = c;
                        noChange = false;
                    }
                    else if(i>j && cs[i]<cs[j]){
                        char c = cs[i];
                        cs[i] = cs[j];
                        cs[j] = c;
                        noChange = false;
                    }
                }
            }
            if(noChange) break;
        }

        return new String(cs);
    }
    //根据给定的交换索引，交换字符串中的元素，若干次，使得字符串字典序最小
    //此题未完成，因为交换索引的前置后置具有同等地位，都应该被考虑，而下面的思路没有考虑到
    public String smallestStringWithSwaps2(String s, List<List<Integer>> pairs) {
        Collections.sort(pairs, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if(o1.get(0)>o1.get(1)){
                    int i = o1.get(0);
                    o1.set(0,o1.get(1));
                    o1.set(1,i);
                }
                if(o2.get(0)>o2.get(1)){
                    int i = o2.get(0);
                    o2.set(0,o2.get(1));
                    o2.set(1,i);
                }
                return o1.get(0) - o2.get(0);
            }
        });
        System.out.println(pairs);
        char[] cs = s.toCharArray();
        while (true){
            //本轮没有交换则结束
            boolean noChange = true;
            //直接按照对应索引交换
            for (int i = 0; i < pairs.size(); i++) {
                int c1 = pairs.get(i).get(0);
                int c2 = pairs.get(i).get(1);
                if(cs[c1]>cs[c2]){
                    char t = cs[c1];
                    cs[c1] = cs[c2];
                    cs[c2] = t;
                    noChange = false;
                }
            }
            //深入对比两组相同前置索引，不同后置索引的 字符
            //
            for (int i = 0; i < pairs.size()-1; i++) {
                int c1 = pairs.get(i).get(0);
                int j = i+1;
                int c3 = pairs.get(j).get(0);
                while(c1==c3){
                    int c2 = pairs.get(i).get(1);
                    int c4 = pairs.get(i+1).get(1);
                    //直接交换 后置索引的字符
                    if(c4<c2 && cs[c4]>cs[c2]){
                        char t = cs[c4];
                        cs[c4] = cs[c2];
                        cs[c2] = t;
                        noChange = false;
                    }
                    if(++j<pairs.size())c3 = pairs.get(j).get(0);
                    else break;
                }
            }
            if (noChange)break;
        }
        return new String(cs);
    }
}
