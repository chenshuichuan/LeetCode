package leetcode61;

public class RegionsCutBySlashes959 {
    public static void main(String[] args) {
        String[][] grids = {{" /","/ "}};

        RegionsCutBySlashes959 p = new RegionsCutBySlashes959();

        for (int i = 0; i < grids.length; i++) {
            System.out.println(p.regionsBySlashes(grids[i]));
        }
    }
    public int regionsBySlashes(String[] grid) {

        UnionFind unionFind = new UnionFind(4*grid.length*grid[0].length());
        for (int i = 0; i < grid.length; i++) {

        }
        return 0;
    }

    class UnionFind{
        private int parent[];
        private int numOfRoot;

        UnionFind(int numOfParent){
            numOfRoot = numOfParent;
            parent = new int[numOfParent];
            for (int i = 0; i < numOfParent; i++) {
                parent[i] = i;
            }
        }
        public void union(int x,int y){
            int px = find(x);
            int py = find(y);
            if(px == py)return;
            parent[y] = px;
            parent[py] = px;
            numOfRoot--;
        }
        public int  find(int x){
            if(parent[x] != parent[parent[x]]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public int getNumOfRoot(){
            return numOfRoot;
        }
    }
}
