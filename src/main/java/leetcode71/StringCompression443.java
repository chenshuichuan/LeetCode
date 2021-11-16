package leetcode71;

public class StringCompression443 {
    public static void main(String[] agv){
        char[] chars = {'a','b','b','c','c','c'};
        new StringCompression443().compress(chars);
    }
    public int compress(char[] chars) {
        if(chars ==null)return 0;
        if(chars.length <2) return chars.length;
        int index = 0;
        char curr = chars[0];
        int rec = 1;
        for(int i=1;i<chars.length;i++){
            if(curr == chars[i])rec++;
            else{
                chars[index++] = curr;
                curr = chars[i];
                if(rec ==1);
                else if(rec<10)chars[index++] = (char)('0' + rec);
                else if(rec<100){
                    chars[index] =(char) ('0' +rec/10);
                    chars[index+1] = (char)('0' + rec%10);
                    index = index+2;
                }
                else if(rec<1000){
                    chars[index] = (char)('0' +rec/100);
                    chars[index+1] = (char)('0' +(rec/10)%10);
                    chars[index+2] = (char)('0' + rec%10);
                    index = index+3;
                }
                else {
                    chars[index] = (char)('0' +rec/1000);
                    chars[index+1] = (char)('0' +(rec/100)%10);
                    chars[index+2] = (char)('0' +(rec/10)%10);
                    chars[index+3] = (char)('0' + rec%10);
                    index = index+4;
                }
                rec = 1;
            }
        }
        chars[index++] = curr;
        if(rec ==1);
        else if(rec<10)chars[index++] = (char)('0' + rec);
        else if(rec<100){
            chars[index] =(char) ('0' +rec/10);
            chars[index+1] = (char)('0' + rec%10);
            index = index+2;
        }
        else if(rec<1000){
            chars[index] = (char)('0' +rec/100);
            chars[index+1] = (char)('0' +(rec/10)%10);
            chars[index+2] = (char)('0' + rec%10);
            index = index+3;
        }
        else {
            chars[index] = (char)('0' +rec/1000);
            chars[index+1] = (char)('0' +(rec/100)%10);
            chars[index+2] = (char)('0' +(rec/10)%10);
            chars[index+3] = (char)('0' + rec%10);
            index = index+4;
        }
        return index;
    }
}
