import java.util.*;

public class LongestPalindrome {
    public static int getLongestPalindromeV1(String s) {
        if(s.length() < 2){
            return s.length();
        }
        char[] ch=s.toCharArray();
        HashMap<Character, Integer> charSet = new HashMap<Character, Integer>();
        for(int i = 0 ; i < ch.length ; ++i){
            if(charSet.containsKey(ch[i])){
                charSet.put(ch[i],charSet.get(ch[i])+1);
            }else{
                charSet.put(ch[i],1);
            }
        }
        int lengthOfLongestPal = 0;
        boolean oddValue = false;
        for(Map.Entry<Character, Integer> entry:charSet.entrySet()){
            if(entry.getValue() % 2 == 0){
                lengthOfLongestPal = lengthOfLongestPal + entry.getValue();
            }else{
                lengthOfLongestPal = lengthOfLongestPal + entry.getValue() - 1;
                oddValue = true;
            }
        }
        if(oddValue){
            lengthOfLongestPal = lengthOfLongestPal+1;
        }
        return lengthOfLongestPal;
    }

    public static int getLongestPalindromeV2(String s) {
        if(s.length() < 2){
            return s.length();
        }
        char[] ch=s.toCharArray();
        HashSet<Character> charSet = new HashSet<Character>();
        int lengthOfLongestPal = 0;
        for(int i = 0 ; i < ch.length ; ++i){
            if(charSet.contains(ch[i])){
                charSet.remove(ch[i]);
                lengthOfLongestPal++;
            }else{
                charSet.add(ch[i]);
            }
        }
        
        lengthOfLongestPal = lengthOfLongestPal * 2;
        if(!charSet.isEmpty()){
            lengthOfLongestPal = lengthOfLongestPal + 1;
        }
        return lengthOfLongestPal;
    }

    public static void main(String[] args){
        System.out.println(getLongestPalindromeV1("abccccdd"));
        System.out.println(getLongestPalindromeV2("abccccdd"));
    }
}
