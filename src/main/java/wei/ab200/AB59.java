package wei.ab200;

import java.util.*;

public class AB59 {

    /**
     * 计算可以坐满车的接待方案数量
     * @param delegates 代表团人数数组
     * @param capacity 汽车载客量
     * @return 方案数量
     */
    public static int countFullCarSchemes(int[] delegates, int capacity) {
        if (delegates == null || delegates.length == 0 || capacity <= 0) {
            return 0;
        }

        // dp[i] 表示凑出容量i的方案数量
        int[] dp = new int[capacity + 1];
        dp[0] = 1; // 凑出0容量有1种方案（不选任何代表团）

        // 对每个代表团进行处理
        for (int delegate : delegates) {
            // 从后往前遍历，避免重复使用同一个代表团
            for (int i = capacity; i >= delegate; i--) {
                dp[i] += dp[i - delegate];
            }
        }

        return dp[capacity];
    }

    /**
     * 使用回溯算法找出所有具体方案（可选功能）
     * @param delegates 代表团人数数组
     * @param capacity 汽车载客量
     * @return 所有可行方案的列表
     */
    public static List<List<Integer>> findAllSchemes(int[] delegates, int capacity) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentScheme = new ArrayList<>();

        backtrack(delegates, capacity, 0, 0, currentScheme, result);

        return result;
    }

    private static void backtrack(int[] delegates, int target, int start, int currentSum,
                                  List<Integer> currentScheme, List<List<Integer>> result) {
        if (currentSum == target) {
            result.add(new ArrayList<>(currentScheme));
            return;
        }

        if (currentSum > target) {
            return;
        }

        for (int i = start; i < delegates.length; i++) {
            currentScheme.add(delegates[i]);
            backtrack(delegates, target, i + 1, currentSum + delegates[i],
                    currentScheme, result);
            currentScheme.remove(currentScheme.size() - 1);
        }
    }

    // 主函数测试
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入代表团人数
        String[] delegateStr = scanner.nextLine().trim().split(",");
        int[] delegates = new int[delegateStr.length];
        for (int i = 0; i < delegateStr.length; i++) {
            delegates[i] = Integer.parseInt(delegateStr[i].trim());
        }

        // 输入汽车载客量
        int capacity = scanner.nextInt();

        // 计算方案数量
        int schemesCount = countFullCarSchemes(delegates, capacity);

        System.out.println(schemesCount);

        // 可选：打印所有具体方案
        if (schemesCount > 0) {
            List<List<Integer>> allSchemes = findAllSchemes(delegates, capacity);
            System.out.println("所有可行方案:");
            for (List<Integer> scheme : allSchemes) {
                System.out.println(scheme);
            }
        }

        scanner.close();
    }
}