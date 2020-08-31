package leetcode11;

public class ShortestPalindrome214 {
    public static void main(String[] args){
        ShortestPalindrome214 p = new ShortestPalindrome214();
        System.out.println(p.shortestPalindrome("aab"));
        System.out.println(p.shortestPalindrome("aacecaaa"));
        System.out.println(p.shortestPalindrome("abcd"));
        System.out.println(p.shortestPalindrome("ba"));
        System.out.println(p.shortestPalindrome("aaaaa"));
    }
    public String shortestPalindrome(String s) {
        boolean singleFlag =true;
        int index = s.length()/2;//以中点字符为中心开始找，找到第一个能到达下标0处的中心即为所求，否则以下标0为中心；

        for (int i = index; i >=0; i--) {
            if(i+1>=s.length())continue;
            //单中心
            int j = i-1;
            int num = 1;
            for (; j >=0; j--) {
                if(s.charAt(j) == s.charAt(i+num)) num++;
                else break;
            }
            //j<0说明找到了
            if(j<0){
                singleFlag = true;
                index = i;
                break;
            }

             j = i-1;
             num = 0;
            //双中心
            for (; j >=0; j--) {
                if(s.charAt(j) == s.charAt(i+num)) num++;
                else break;
            }
            //j<0说明找到了,以i=0开始的只有单中心
            if(i>0 && j<0){
                singleFlag = false;
                index = i;
                break;
            }
        }
        int num = index;
        if(!singleFlag) num= index-1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-1; i >index+num; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString()+s;
    }
}
