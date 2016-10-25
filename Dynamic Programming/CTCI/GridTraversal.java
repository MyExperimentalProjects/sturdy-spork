import java.util.*;

class GridTraversal{
	
	int[][] ways;
	String[][] path;

	class Point{
		int x,y;

		Point(int X, int Y){
			x = X;
			y = Y;
		}

		public String toString(){
			return "(" + x + " , " + y + ")";
		}
	}
	GridTraversal(){
		ways = new int[1+1][1+1];
		path = new String[2][2];
		for(int i = 0 ; i < 2 ; ++i){
			for(int j = 0 ; j < 2 ; ++j){
				path[i][j] = "";
			}
		}
	}
	/*public static int numWays(int m, int n){
		int[][] ways = new int[m][n];
		//List<List<Point>> paths = new ArrayList<List<>>();
		for(int i = 0 ; i < m ; ++i){
			for(int j = 0 ; j < n ; ++j){
				if(i == 0 || j == 0){
					ways[i][j] = 1;
				}else{
					ways[i][j] = ways[i-1][j] + ways[i][j-1];
				}
			}
		}
		return ways[m-1][n-1];
	}*/

	public String numWays(int m, int n){

		if(path[m][n].length() != 0){
			System.out.println(path[m][n]);
			return path[m][n];
		}

		Point point = new Point(m,n);
		path[m][n] = point.toString();
		//System.out.println(path[m][n]);
		if(m == 0 && n == 0){
			return path[m][n];
		}
		

		if(m == 0){	
			path[m][n] = path[m][n] + numWays(m,n-1);
		}
		else if(n == 0){
			path[m][n] = path[m][n] + numWays(m-1,n);
		}
		else{
			path[m][n] = path[m][n] + numWays(m,n-1) + numWays(m-1,n);
		}
		
		return path[m][n];
	}

	public static void main(String[] args){
		GridTraversal g = new GridTraversal();
		//ArrayList<Point> path = new ArrayList<Point>();
		System.out.println(g.numWays(1,1));
		//System.out.println(path);
	}
}