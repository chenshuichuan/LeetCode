package wei.ab200;
import java.util.*;

public class AB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入字符串并分割成整数数组
        String input = scanner.nextLine();
        String[] numbersStr = input.split(" ");
        int[] numbers = new int[numbersStr.length];
        for (int i = 0; i < numbersStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStr[i]);
        }

        // 处理栈
        Stack<Integer> stack = new  Stack<>();
        for (int num : numbers) {
            stack.push(num);
            processStack(stack);
        }

        // 输出结果
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static void processStack(Stack<Integer> stack) {
        if (stack.size() < 2) return;

        int top = stack.peek();
        int sum = top;
        int count = 1;

        // 检查是否满足条件2
        while (count < stack.size() && sum <= 2 * top) {
            int next = stack.get(count);
            sum += next;
            if (sum == 2 * top) {
                for (int i = 0; i <= count; i++) {
                    stack.pop();
                }
                stack.push(2 * top);
                return;
            }
            count++;
        }

        // 检查是否满足条件1
        if (count >= 2 && stack.size() >= 2 && stack.peek() == stack.get(1)) {
            stack.pop();
            stack.pop();
            stack.push(2 * top);
        }
    }
}