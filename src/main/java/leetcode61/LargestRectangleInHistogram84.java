package leetcode61;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram84 {
    public static void main(String[] args) {
        LargestRectangleInHistogram84 p = new LargestRectangleInHistogram84();
        //10,2,3
        int[][] heights = {{2,1,5,6,2,3},{1,1},{2,1,2}};
        for (int[] height:heights) {
            System.out.println(p.largestRectangleArea(height));
        }
    }
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len==0)return 0;
        if(len==1)return heights[0];
        int max =0;
        //在原数组两边加上0,预防越界
        int[] newHeights = new int[len + 2];
        newHeights[0] = 0;
        System.arraycopy(heights, 0, newHeights, 1, len);
        newHeights[len + 1] = 0;
        len += 2;
        heights = newHeights;

        //单调栈处理
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        for (int i = 1; i < len; i++) {
            while (heights[stack.peekFirst()]>heights[i]){
                int height = heights[stack.pollFirst()];
                int width = i-stack.peekFirst()-1;
                max = Math.max(max,height*width);
            }
            stack.addFirst(i);
        }
        return max;
    }


}
