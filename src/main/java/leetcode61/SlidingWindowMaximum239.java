package leetcode61;

import java.util.PriorityQueue;
import java.util.Stack;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[][] nums= {{1,3,1,2,0,5},{1,3,-1,-3,5,3,6,7},{1},{9,11},{4,2},{1,-1}};
        int[] k = {3,3,1,2,2,1};
        SlidingWindowMaximum239 p = new SlidingWindowMaximum239();
        for (int i = 0; i < nums.length; i++) {
            int[]arr = p.maxSlidingWindow(nums[i],k[i]);
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+",");
            }
            System.out.println();
        }
    }
    //求滑动窗口内的最大值  --单调栈法//栈顶往下是递增的，有点像用双端队列了
    public int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] array = new int[length - k + 1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < (k - 1); i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
        }
        for (int i = k - 1; i < length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                stack.pop();
            }
            stack.push(i);
            if (i - stack.firstElement() >= k) {
                stack.removeElementAt(0);
            }
            array[i - k + 1] = nums[stack.firstElement()];
        }
        return array;
    }

    //求滑动窗口内的最大值  --优先队列维护大顶堆法
    class MyNode implements Comparable<MyNode> {
        int value;
        int index;
        @Override
        public int compareTo(MyNode o) {
            return Integer.compare(o.value, this.value);
        }

        public MyNode(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int[] maxSlidingWindow4(int[] nums, int k){
        //输出结果数组
        int[] result = new int[nums.length + 1 - k];
        //窗口容器
        PriorityQueue<MyNode> queue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            queue.add(new MyNode(nums[i], i));

            if (i + 1 >= k) {
                //移除当前'过期'的max
                int remove = i - k;
                while (!queue.isEmpty() && queue.peek().index <= remove) {
                    queue.poll();
                }
                result[i + 1 - k] = queue.peek().value;
            }
        }
        return result;
    }

    //求滑动窗口内的最大值---暴力法会超时
    //这个优化版本也超时了。。。。差一个例子没过
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];

        //preMax 记录前一个窗口最大值下标，进行优化
        int preMax = -1;
        for (int i = 0; i < arr.length; i++) {
            int right = (i+k-1);
            //如果该下标不在窗口内了，则重新寻找最大值，
            if(preMax<i){
                int j = i;
                preMax = j;
                while (j<=right){
                    if(nums[j]>=nums[preMax])preMax = j;
                    j++;
                }
                arr[i] = nums[preMax];
            }
            // 否则该次滑动沿用上一个最大值
            else {
                if(nums[right]>arr[i-1]){
                    arr[i] =nums[right];
                    preMax = right;
                }
                else arr[i] = arr[i-1];
            }
        }
        return arr;
    }

    //求滑动窗口内的最大值---双最值优化，就是复杂了
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] arr = new int[nums.length-k+1];

        //preMax 记录前一个窗口最大值下标，进行优化
        int[] preMax ={-1,-1};
        for (int i = 0; i < arr.length; i++) {
            int right = (i+k-1);
            //如果该下标不在窗口内了，则重新寻找最大值，
            if(preMax[0]<i){
               if(preMax[1]<i){
                   int j = i;
                   preMax[0] = j;
                   while (j<=right){
                       if(nums[j]>=nums[preMax[0]]){
                           preMax[1] = preMax[0];
                           preMax[0] = j;
                       }
                       else if(nums[j]>=nums[preMax[1]])preMax[1] = j;
                       j++;
                   }
                   arr[i] = nums[preMax[0]];
               }
               else{
                   if(nums[right]>=nums[preMax[1]]){
                       arr[i] =nums[right];
                       preMax[1] = right;
                   }
                   else arr[i] = nums[preMax[1]];
               }
            }
            // 否则该次滑动沿用上一个最大值
            else {
                if(nums[right]>=arr[i-1]){
                    arr[i] =nums[right];
                    preMax[1] =preMax[0];
                    preMax[0] = right;
                }
                else {
                    if(nums[right]>=nums[preMax[1]])preMax[1] =right;
                    arr[i] = arr[i-1];
                }
            }
        }
        return arr;
    }
}
