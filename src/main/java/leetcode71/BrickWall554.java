package leetcode71;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall554 {
    public static void main(String[] args){

    }
    //通过砖墙最少砖数
    /**
     * 遍历砖墙，通过hash map 记录砖的右侧
     * 遍历map 统计每个右侧数，则砖数 = 砖墙高 - 右侧数
     * */
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> rightEmpty = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> bricks = wall.get(i);
            int right = 0;
            int m = bricks.size()-1;
            for (int j =0; j<m; j++) {
                right+=bricks.get(j);
                rightEmpty.put(right, rightEmpty.getOrDefault(right,0)+1);
            }
        }

        int maxEmpty  = 0;
        for (Integer i: rightEmpty.keySet()) {
            int j = rightEmpty.get(i);
            maxEmpty = j>maxEmpty ? j: maxEmpty;
        }
        return n-maxEmpty;
    }
}
