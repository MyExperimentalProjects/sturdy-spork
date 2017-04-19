import java.util.HashSet;

public class HappyNumber {
    public static boolean isHappy(int n) {
        if(n == 0){
            return false;
        }
        HashSet<Integer> numbers = new HashSet<>();
        int sum = 0;
        while(n != 1){
            numbers.add(n);
            String[] v = (""+n).split("");
            for(int j = 0 ; j < v.length ; ++j){
                sum = sum + (Integer.parseInt(v[j])*Integer.parseInt(v[j]));
            }
            if(numbers.contains(sum)){
                break;
            }
            n = sum;
            sum = 0;
        }
        if(n == 1){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println(isHappy(51));
    }
}
