package wei.ab200;

import java.util.*;

public class AB47 {

    /**
     * 找到最小的最大耗时
     * @param tasks 任务耗时数组
     * @param m 指定的天数
     * @return 最小的最大耗时
     */
    public static int minMaxTaskTime(int[] tasks, int m) {
        if (tasks == null || tasks.length == 0 || m <= 0) {
            return 0;
        }

        // 二分搜索的上下界
        int left = 0;
        int right = Arrays.stream(tasks).max().orElse(0);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canComplete(tasks, m, mid)) {
                right = mid;  // 可以完成，尝试更小的值
            } else {
                left = mid + 1;  // 无法完成，需要更大的值
            }
        }

        return left;
    }

    /**
     * 判断是否能在m天内完成任务，且每天的最大耗时不超过maxTime
     * @param tasks 任务耗时数组
     * @param m 天数
     * @param maxTime 每天的最大耗时限制
     * @return 是否能完成
     */
    private static boolean canComplete(int[] tasks, int m, int maxTime) {
        if (tasks.length == 0) {
            return true;
        }

        int days = 1;  // 当前天数
        int currentLoad = 0;  // 当前天的任务总耗时
        boolean skipUsed = false;  // 是否已使用跳过机会

        for (int task : tasks) {
            // 如果当前天的负载加上这个任务会超过限制
            if (currentLoad + task > maxTime) {
                // 如果还没有使用跳过机会，检查是否可以跳过这个任务
                if (!skipUsed && task <= maxTime) {
                    // 跳过这个任务，但记录它被跳过了
                    skipUsed = true;
                    continue;
                }

                // 否则需要开始新的一天
                days++;
                currentLoad = task;

                // 如果超过了可用天数，无法完成
                if (days > m) {
                    return false;
                }
            } else {
                // 可以将任务加入当前天
                currentLoad += task;
            }
        }

        return days <= m;
    }

    /**
     * 获取最优的任务分配方案
     * @param tasks 任务耗时数组
     * @param m 天数
     * @return 任务分配方案（每个元素表示当天的任务列表）
     */
    public static List<List<Integer>> getOptimalAllocation(int[] tasks, int m) {
        int optimalMaxTime = minMaxTaskTime(tasks, m);

        List<List<Integer>> allocation = new ArrayList<>();
        List<Integer> currentDay = new ArrayList<>();
        boolean skipUsed = false;

        for (int task : tasks) {
            // 尝试将任务加入当前天
            if (currentDay.isEmpty() ||
                    (currentDay.stream().mapToInt(Integer::intValue).sum() + task <= optimalMaxTime)) {
                currentDay.add(task);
            } else {
                // 当前天已满，检查是否可以跳过
                if (!skipUsed && task <= optimalMaxTime) {
                    skipUsed = true;
                    continue;
                }

                // 开始新一天
                allocation.add(new ArrayList<>(currentDay));
                currentDay.clear();
                currentDay.add(task);
            }
        }

        // 添加最后一天
        if (!currentDay.isEmpty()) {
            allocation.add(currentDay);
        }

        return allocation;
    }

    // 测试方法
    public static void main(String[] args) {
        int[] tasks = {5, 3, 8, 4, 6, 2};
        int m = 3;

        System.out.println("任务耗时: " + Arrays.toString(tasks));
        System.out.println("指定天数: " + m);

        int result = minMaxTaskTime(tasks, m);
        System.out.println("最小的最大耗时: " + result);

        List<List<Integer>> allocation = getOptimalAllocation(tasks, m);
        System.out.println("任务分配方案:");
        for (int i = 0; i < allocation.size(); i++) {
            System.out.println("第" + (i+1) + "天: " + allocation.get(i));
        }
    }
}