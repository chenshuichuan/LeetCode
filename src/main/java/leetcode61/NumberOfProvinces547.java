package leetcode61;

import java.util.HashSet;

public class NumberOfProvinces547 {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}};
        NumberOfProvinces547 p = new NumberOfProvinces547();

        System.out.println(p.findCircleNum(isConnected));
    }

    //一下深搜想的复杂了，不需要hashset，因为每次能进入递归，都说明此次深搜是一个独立的子图，深搜只是为了把该子图所有节点标记访问，
    //省份数量，深度优先搜索，
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];

        int res = 0;
        for(int i=0;i<isConnected.length;i++){
            if(visited[i])continue;
            else{
                visited[i] = true;
                HashSet<Integer> pathSet = new HashSet<>();
                pathSet.add(i);
                boolean flag = findConneted(isConnected,visited,i,pathSet);
                if(!flag) res++;
            }
        }
        return res;
    }
    //以某点开始深搜，和其他点联通返回true，否则返回false
    private boolean findConneted(int[][] isConnected,boolean[] visited, int i,HashSet<Integer> pathSet){
        boolean connected = false;
        for(int j=0;j<isConnected[i].length; j++){
            if(i==j)continue;
            if(isConnected[i][j] == 1){
                if(pathSet.contains(j))continue;
                if(visited[j])connected=true;
                else{
                    visited[j] = true;
                    pathSet.add(j);
                    connected = findConneted(isConnected,visited,j,pathSet);
                }
            }
        }
        return connected;
    }
}
