package wei.c;
import java.util.Scanner;
import java.util.regex.Pattern;

public class C16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取网络配置列表
        String configListStr = scanner.nextLine();
        String[] configList = configListStr.split(" ");

        // 读取用户的IMSI
        String imsi = scanner.nextLine();

        // 检查IMSI是否与配置列表中的任何一个配置匹配
        boolean isMatched = false;
        for (String config : configList) {
            if (match(config, imsi)) {
                isMatched = true;
                break;
            }
        }

        System.out.println(isMatched ? "Matched" : "Not Matched");
    }

    private static boolean match(String config, String imsi) {
        // 将配置转换为正则表达式
        StringBuilder regexBuilder = new StringBuilder();
        int wildcardCount = 0;
        for (int i = 0; i < config.length(); i++) {
            char c = config.charAt(i);
            if (c == '*') {
                wildcardCount++;
                if (wildcardCount > 1) {
                    return false; // 每个字符串中"*"不会超过一个
                }
                regexBuilder.append(".*");
            } else if (c == '?') {
                if (i % 2 == 0) {
                    return false; // "?"只能出现在下标为奇数的位置
                }
                regexBuilder.append(".");
            } else {
                regexBuilder.append(c);
            }
        }

        // 编译正则表达式并进行匹配
        Pattern pattern = Pattern.compile("^" + regexBuilder.toString() + "$");
        return pattern.matcher(imsi).matches();
    }
}