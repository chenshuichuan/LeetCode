package leetcode25;

public class ImplementStrstr28 {
    public static void main(String[] args){
        ImplementStrstr28 p = new ImplementStrstr28();
        String haystack="mississippi";
        String needle ="issipi";
        //needle.indexOf()
        System.out.println(p.strStr(haystack,needle));
    }
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0 )return 0;
        if(haystack.length()<needle.length())return -1;
        for (int i = 0; i < haystack.length(); i++) {
            if(haystack.length()-i<needle.length())break;
            int j = 0;
            while (haystack.charAt(i) == needle.charAt(j)){
                j++;i++;
                if(j==needle.length())return i-j;
            }
            i-=j;
        }
        return -1;
    }
}
