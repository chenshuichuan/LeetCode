package leetcode11;

public class ReverseWordsInString557 {
    public static void main(String[] args){
        ReverseWordsInString557 p = new ReverseWordsInString557();

        //System.out.println(p.reverseWords("I am chen"));
        System.out.println(p.reverseWords("Let's take LeetCode contest"));
    }
    public String reverseWords(String s) {
        char[] words = s.trim().toCharArray();
        int start = s.length()-1;
        int length = 0;
        for (int i = s.length()-1; i>=0; i--) {

            char c= s.charAt(i);
            if(c==' ' || i==0){
                start = i+1;
                if(i==0) {
                    start =i;
                    length++;
                }
                for (int j = 0; j < length/2; j++) {
                    c = words[start+j];
                    words[start+j] = words[start+length-j-1];
                    words[start+length-j-1] = c;
                }
                length = 0;
            }
            else length++;
        }
        return String.valueOf(words);
    }
    public String reverseWords3(String s) {
        char[] words = new char[s.length()];
        int end = s.length()-1;
        for (int i = s.length()-1; i>=0; i--) {
            StringBuilder word = new StringBuilder();
            while (i>=0){
                char c= s.charAt(i);
                if(c==' '){
                    words[i] = ' ';
                    for (int j = i+1; j <=end ; j++) {
                        words[j] = word.charAt(j-i-1);
                    }
                    end = i-1;
                    break;
                }
                word.append(c);
                i--;
            }
            if(i<0 && s.charAt(0)!=' '){
                for (int j = 0; j <word.length() ; j++) {
                    words[j] = word.charAt(j);
                }
            }
        }
        return String.valueOf(words);
    }
    public String reverseWords2(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = s.length()-1; i>=0; i--) {
            StringBuilder word = new StringBuilder();
            while (i>=0){
                char c= s.charAt(i);
                if(c==' '){
                    word.insert(0,' ');
                    break;
                }
                word.append(c);
                i--;
            }
            stringBuilder.insert(0,word);
        }
        return stringBuilder.toString();
    }
}
