import java.util.Scanner;

class DynamicProgramming{

	public static int fib(int n){
		if( n == 0 || n == 1){
			return n;
		}
		int prevToPrev = 0, prev = 1, current = 0;
		for(int i = 2; i <= n ; ++i){
			current = prev + prevToPrev;
			prevToPrev = prev;
			prev = current;
		}
		return current;
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(fib(n));
	}
}
