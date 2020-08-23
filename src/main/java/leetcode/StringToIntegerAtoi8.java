package leetcode;

public class StringToIntegerAtoi8 {
    public static void main(String[] args){
        StringToIntegerAtoi8 p = new StringToIntegerAtoi8();

        System.out.println("   123 456 789  ".trim());
        System.out.println(p.myAtoi("   +123 456 789  "));
        System.out.println(p.myAtoi("-91283472332"));
        System.out.println(p.myAtoi("2147483648"));

        System.out.println(p.isPalindrome(123));
    }

    public int myAtoi(String str) {
        str = str.trim();
        int result =0;
        int flag = 1;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c <='9' && c>='0'){
                if(result==0 && i>0 && str.charAt(i-1)=='-'){
                    flag = -1;
                }
                if((result*10)/10 !=result)//result*10 可能越界
                    return flag ==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                result = result*10+(c-'0');
                if(result<0)//result + c也可能越界 2147483647
                    return flag ==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            else{
                //"+-123" 这种为非法的
                if(result==0 &&( c=='-'||c=='+')) {
                    if(i>0)break;
                }
                else break;
            }
        }
        return result*flag;
    }
    //一下为 回文数的解答
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        if(x%10 == 0)return false;
        int half =0;
        while (true){
            if (half>x)return false;
            if(x == half){
                return true;
            }
            int c = x%10;
            x=x/10;
            if(x == half){
                return true;
            }
            half =half*10+c;
        }
    }
    public boolean isPalindrome2(int x) {
        if(x<0)return false;
        String str = Integer.toString(x);
        for(int i=0;i<str.length();i++){
            int j = str.length()-i-1;
            if(i>j)break;
            if(str.charAt(i)==str.charAt(j)) {
            }
            else return false;
        }
        return true;
    }
}
