package leetcode;

public class StringMulti {
    public static void main(String[] args){
        StringMulti stringMulti = new StringMulti();
        System.out.println(stringMulti.addStrings("123456789","987654321"));

        System.out.println(stringMulti.mutiStrings("123","456"));
        
    }
    public String mutiStrings(String num1, String num2){
        if("0".equals(num1) ||"0".equals(num2)){
            return "0";
        }
        String str = "0";
        StringBuilder zeroBuilder =new StringBuilder();
        for (int i = num1.length()-1; i >=0 ; i--) {
            int a = num1.charAt(i)-'0';
            int add =0;//进位
            if(i<num1.length()-1)zeroBuilder.append('0');//高位补零
            StringBuilder multiBuilder = new StringBuilder();
            for (int j =  num2.length()-1; j >=0; j--) {
                int b = num2.charAt(j)-'0';
                int multi = a*b+add;
                multiBuilder.append(multi<10?multi:multi%10);
                add = multi/10;
            }
            if(add>0)multiBuilder.append(add);
            multiBuilder.reverse();
            multiBuilder.append(zeroBuilder.toString());
            String str2 = multiBuilder.toString();
            str = addStrings(str,str2);
        }
        return str;
    }
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int add = 0;
        StringBuilder str =new StringBuilder();
        while(i>=0 || j>=0|| add >0){
            int a = i>=0?num1.charAt(i)-'0':0;
            int b = j>=0?num2.charAt(j)-'0':0;
            int result = a+b+add;
            str.append(result<10?result:result%10);
            add = result/10;
            i=i-1;
            j=j-1;
        }
        str.reverse();
        return str.toString();
    }
}
