package leetcode61;

public class NumberOfIslands200 {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}};

        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        NumberOfIslands200 p = new NumberOfIslands200();
        System.out.println(p.numIslands(grid));

    }
    /**
     * 计算联通岛数量
     * 并查集: 点p(x,y) 对应index = x*n +y
     * */
    public int numIslands(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);

        int l = grid.length;
        int r = grid[0].length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';//以防再次union
                    int x = i*r + j;
                    if(i>0 && grid[i-1][j] == '1') {
                        int y = (i-1)*r + j;
                        unionFind.union(x, y);
                    }
                    if(j<r-1 && grid[i][j+1] == '1') {
                        int y = i*r + (j+1);
                        unionFind.union(x, y);
                    }
                    if(i<l-1 && grid[i+1][j] == '1') {
                        int y = (i+1)*r + j;
                        unionFind.union(x, y);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind{

        private int[] parent ;
        private int[] rank;
        private int count;
        UnionFind(char[][] grid){
            int m = grid.length;
            int n = grid[0].length;
            count = 0;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }
        public void union(int x, int y){
            int parentx = find(x);
            int parenty = find(y);
            if (parentx != parenty) {
                if (rank[parentx] > rank[parenty]) {
                    parent[parenty] = parentx;
                } else if (rank[parentx] < rank[parenty]) {
                    parent[parentx] = parenty;
                } else {
                    parent[parenty] = parentx;
                    rank[parentx] += 1;
                }
                --count;
            }
        }
        public int find(int x){
            if(parent[x] != x ){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public int getCount(){
            return count;
        }
    }
}
