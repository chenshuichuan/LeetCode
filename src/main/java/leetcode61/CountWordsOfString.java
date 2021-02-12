package leetcode61;

public class CountWordsOfString {
    public static void main(String[] args) {
        String[] strings = {"000B111222B111B222B333000B444000B55B66B6600","BaaBbbbBccccBaaaBaaBaaBddd"};

        for (String str :strings) {
            countWord1(str,'0');
        }
    }
    //以c为分隔符计算字符串的单词数
    //"BaaBbbbBccccBaaaBaaBaaBddd" B是起始符
    public static void countWord1(String str, char c){
        System.out.println(str);
        int start = -1;
        char pre = c ;
        for (int i = 0; i < str.length(); i++) {
            char p =str.charAt(i);
            //不相等就是分隔符
            if(pre != p){
                //前面是c就是新word开始
                if(pre ==c ) start = i;
                else{
                    if(pre == 'B'){
                        pre = p;
                        continue;
                    }
                    System.out.println("("+start+","+(i-1)+")");
                    //前面非c 当前为B，则是结束旧word，开始新word
                   //if(p=='B')//新词开始//因为和前面不相等，且前面非O非B起始，那也有可能是新词以I起始
                    start = i;
                   //当前为c，结束旧word
                }
                pre = p;
            }
        }
    }
    //以c为分隔符计算字符串的单词数
    //"000111222333000444000556600"
    public static void countWord(String str, char c){
        System.out.println(str);
        int start = -1;
        char pre = c ;
        for (int i = 0; i < str.length(); i++) {
            char p =str.charAt(i);
            if(pre != p){
                //前一个是分隔符，所以新word开始
                if(pre!=c) System.out.println("("+start+","+(i-1)+")");

                pre = p;
                //新词开始
                start = i;
            }
            //pre != str.charAt(i)
            //分割

        }
    }
}
