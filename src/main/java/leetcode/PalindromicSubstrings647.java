package leetcode;

public class PalindromicSubstrings647 {
    public static void main(String[] args){
        PalindromicSubstrings647 p = new PalindromicSubstrings647();
        System.out.println(p.countSubstrings("abc"));
        System.out.println(p.countSubstrings("aaa"));
    }
    public int countSubstrings(String s) {
        int count = 0;
        int flag = 0;
        for (int i = 0; i < s.length(); ) {
            int j = i;
            int k = i+flag;
            i = i+flag;
            flag=flag==0?1:0;

            while (j>=0&&k<s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    count++;
                    j--;
                    k++;
                }
                else break;
            }
        }
        return count;
    }
}
