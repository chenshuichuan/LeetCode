package wei.ab200;

import java.util.Scanner;

public class AB2 {
    private static class State implements Comparable<State> {
        int turns;
        int clears;
        int x;
        int y;
        int direction;
        public State(int turns, int clears, int x, int y, int direction) {
            this.turns = turns;
            this.clears = clears;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
        @Override
        public int compareTo(State o) {
            if (turns != o.turns){
                return turns - o.turns;
            }
            return clears - o.clears;
        }
    }
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);

        // 读取输入
        int t = scanner.nextInt(); // 最多拐弯次数
        int c = scanner.nextInt(); // 可清
        // 除路障个数
        scanner.nextLine();
        int n = scanner.nextInt(); // 地图行数
        int m = scanner.nextInt(); // 地图列数

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 找到起点 S 和终点 T 的位置
        int sx = -1, sy = -1, tx = -1, ty = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (map[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }


    }
}
