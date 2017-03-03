public class Recursion {
	public static boolean solve(int[][] board, int column){
		//Check placing for conflicts. If the queen can be placed here move onto the the next column, if not return false
		if(column > board.length){
			return true;
		}
		for(int row = 0; row<board.length; row++){	// steps through rows
			if(isSafe(board, column, row)){
				board[row][column] = 1;
				solve(board,column);
			} else{
				return false;
			}
		}
		return false;
	}
	
	public static boolean isSafe(int[][] board, int column, int row){
		for(int x = column-1; x>-1; x--){	//steps through columns
			for(int y=0; y<board[0].length; y++){	//steps through rows
				if(board[x][y] == 1 || board[x][row-(column-x)] == 1 || board[x][row+(column-x)] == 1){	//checks conflicts
					System.out.println("We didn't crash");
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static void main(String args[]){
		int[][]board = new int[8][8];
		solve(board, 0);
	}
}
