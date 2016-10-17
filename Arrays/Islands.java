class Islands{
	int[][] matrix;
	int row;
	int col;
	int ROW_MIN = 0, COL_MIN = 0;

	Islands(Scanner scan){
		row = scan.nextInt();
		col = scan.nextInt();
		
		matrix = new int[row][col];
		for(int i = 0 ; i < row ; ++i){
			for(int j = 0 ; j < col ; ++j){
				matrix[i][j] = scan.nextInt();
			}
		}
	}

	public void print(){
		for(int i = 0 ; i < row ; ++i){
			for(int j = 0 ; j < col ; ++j){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public int getNumberOfIslands(){
		boolean[][] visited = new boolean[row][col];
		int count = 0;
		for(int i = 0 ;  i < row ; ++i){
			for(int j = 0 ; j < col ; ++j){
				if(matrix[i][j] == 1 && !visited[i][j] && isSafeToVisit(i, j, visited)){
					//System.out.println("here" + i + "--" + j);
					scanNearByCells(i, j, visited);
					++count;
				}
			}
		}
		return count;
	}

	private boolean isSafeToVisit(int r, int c, boolean[][] visited){
		return (r >= ROW_MIN && r < row) && (c >= COL_MIN && c < row) && matrix[r][c] == 1 && !(visited[r][c]);
	}

	private void scanNearByCells(int r, int c, boolean[][] visited){
		int[] rowAdjacent = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] colAdjacent = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		visited[r][c] = true;
		int k = 8;
		for(int i = 0 ; i < 8; ++i){
			if(isSafeToVisit(r + rowAdjacent[i], c + colAdjacent[i] , visited)){
				scanNearByCells(r + rowAdjacent[i], c + colAdjacent[i] , visited);
			}
		}
	}
}
