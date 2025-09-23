package wei.c;
import java.util.*;

public class C1 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取总人数N
        int N = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        // 读取确诊病例人员编号
        String[] confirmedCasesStr = scanner.nextLine().split(",");

        // 读取接触矩阵
        int[][] contactMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = scanner.nextLine().split(",");
            for (int j = 0; j < N; j++) {
                contactMatrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        // 使用DFS找到所有需要核酸检测的人
        boolean[] visited = new boolean[N];
        Arrays.fill(visited, false);
        for (String caseStr : confirmedCasesStr) {
            int caseIndex = Integer.parseInt(caseStr);
            if (!visited[caseIndex]) {
                visited[caseIndex] = true;
                for (int i = 0; i < N; i++){
                    if(contactMatrix[caseIndex][i] == 1 && i!=caseIndex && !visited[i]){
                        dfs(contactMatrix, visited, i);
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] contactMatrix, boolean[] visited, int current) {
        visited[current] = true;
        count++;
        for (int i = 0; i < contactMatrix.length; i++) {
            if (contactMatrix[current][i] == 1 && !visited[i] && i != current) {
                dfs(contactMatrix, visited, i);
            }
        }
    }
}