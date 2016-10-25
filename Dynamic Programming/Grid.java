class Cell{
	int x;
	int y;
	boolean isLamp;
	boolean isLit;
	Cell(int x,int y){
		this.x = x;
		this.y = y;
		this.isLamp = false;
		this.isLit = false;
	}

	public void toggleLamp(boolean isOn){
		isLamp = isOn;
	}

	public void setLit(boolean lit){
		isLit = lit;
	}
}
class Grid{
	Cell[][] cells;
	ArrayList<Cell> lampCells;
	Grid(int n){
		cells = new Cell[n][n];
		lampCells = new ArrayList<>();
		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < n ; ++j){
				cells[i][j] = new Cell(i,j,false);
			}
		}
		cells[0][0].toggleLamp(true);
		lampCells.add(cell[0][0]);
	}

	public void litCells(){
		for(Cell c:lamps){
			for(int i = 0 ; i < n ; ++i){
				cells[i,c.y].setLit(true);
				cells[c.x,j].setLit(true);
			}
		}
	}

	public void getLampCells(){
		return lampCells;
	}

	public boolean isValidCell(int x, int y){
		if(x < 0 || x >= cells.length || y < 0 || y >= cells.length){
			return false;
		}
		return true;
	}
	public void getAdjacentCells(Cell c){
		ArrayList<Cell> adjacent = new ArrayList<>();
		int[] xadjacent = {-1,0,1,-1,1,-1,0,1}
		int[] yadjacent = {-1,-1,-1,0,0,1,1,1}
		for(int i = 0 ; i < xadjacent.length ; ++i){
			for(int j = 0 ; j < yadjacent.length ; ++j){
				if(isValidCell(c.x+xadjacent[i],c.yadjacent[j])){
					adjacent.add(c.x+xadjacent[i],c.yadjacent[j]);
				}
			}
		}
	}

	public void isCellLitByLamp(Cell lamp, Cell given){
		if(given.x == lamp.x){
			return true;
		}
		if(given.y == lamp.y){
			return true;
		}
	}

	public static void main(String[] args){
		Grid g = new Grid(2);
		int query1x = 1, query1y = 1;
		
	}
}