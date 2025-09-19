package wei;

import java.util.*;

public class Mian1 {
    public static void permute(int[] nums) {
        // 1. 先排序，确保遍历顺序是升序的
        Arrays.sort(nums); // 如果输入已有序，可省略

        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        dfs(nums, used, path);
    }

    private static void dfs(int[] nums, boolean[] used, List<Integer> path) {
        // 递归终止：已选够 n 个数
        if (path.size() == nums.length) {
            System.out.println(path); // 直接输出，已是字典序
            return;
        }

        // 按数组顺序遍历，确保先选小的数
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // 做选择
            used[i] = true;
            path.add(nums[i]);

            // 进入下一层
            dfs(nums, used, path);

            // 撤销选择（回溯）
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        permute(array);
    }
}