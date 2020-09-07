package leetcode11;

public class PermutationSequence60 {
    public static void main(String[] args){
        PermutationSequence60 p = new PermutationSequence60();
        System.out.println(p.dfs(4));
    }

    public String getPermutation(int n, int k) {
        int i = 1;
        while(k>i*(n-1))i++;
        StringBuilder str = new StringBuilder();
        for (int j = i; j <= i; j++) {
            str.append(j);
        }


        return str.toString();
    }
    public String dfs(int n){
        if(n==1)return String.valueOf(n);
        return dfs(n-1)+n;
    }
}
