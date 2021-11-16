package leetcode71;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix54 {
    public static void main(String[] agv){
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        //int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}}
        SpiralMatrix54 p = new SpiralMatrix54();

        //System.out.println(p.spiralOrder(matrix));
        p.learnSet();
    }
    private Set<Integer> set ;
    public void learnSet(){
        set = new HashSet<>();
        set.add(658956);
        set.add(1);
        System.out.println(set.contains(658956));
        System.out.println(set.contains(1));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<m;j++){
                visited[i][j] = false;
            }
        }
        List<Integer> intList = new ArrayList<>();
        int i = 0; int j = 0;
        int flag = 0; //flag = 0,1,2,3 代表四个遍历方向
        while(true){
            intList.add(matrix[i][j]);
            visited[i][j] = true;

            switch(flag){
                case 0:{
                    j++;
                    if(j<n){
                        if(visited[i][j]){
                            flag = (flag+1)%4;
                            i++;
                            j--;
                        }
                    }
                    else if(j==n){
                        j--;
                        flag = (flag+1)%4;
                    }
                    continue;
                }
                case 1:{
                    i++;
                    continue;
                }
                case 2:{
                    j--;
                    continue;
                }
                case 3:{
                    i--;
                }
            }
        }

        //return intList;
    }

}
