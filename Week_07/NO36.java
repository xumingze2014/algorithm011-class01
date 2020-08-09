package com.example.demo.week7;

public class NO36 {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.' && checkValid(board,i,j)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkValid(char[][] board,int i,int j){
        for(int k=0;k<9;k++){
            if(i!=k && board[k][j] == board[i][j]){
                return true;
            }
            if(j!=k && board[i][k] == board[i][j]){
                return true;
            }
            /**
             * 3 3      i/k * 3  + k/3       j/k* 3 + k%3
             */
            if((i/3 * 3 +k/3) !=i && (j/3 * 3 + k%3) != j && board[i/3 *3+k/3][j/ 3 * 3 + k%3] == board[i][j]){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        NO36 no36 = new NO36();
        System.out.println(no36.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
        System.out.println(no36.isValidSudoku(new char[][]{
                 {'8','3','.','.','7','.','.','.','.'},
                 {'6','.','.','1','9','5','.','.','.'},
                 {'.','9','8','.','.','.','.','6','.'},
                 {'8','.','.','.','6','.','.','.','3'},
                 {'4','.','.','8','.','3','.','.','1'},
                 {'7','.','.','.','2','.','.','.','6'},
                 {'.','6','.','.','.','.','2','8','.'},
                 {'.','.','.','4','1','9','.','.','5'},
                 {'.','.','.','.','8','.','.','7','9'}
        }));
    }
}
