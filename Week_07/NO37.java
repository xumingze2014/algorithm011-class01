package com.example.demo.week7;

public class NO37 {
    public void solveSudoku(char[][] board) {
        helper(board);
    }

    private boolean helper(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
//                System.out.println(board[i][j]);
                if (board[i][j] == '.') {
                    for (char c = '1'; c <='9'; c++) {
                        board[i][j] = c;
                        if (isValid(board, i, j)){
                            if(helper(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }else{
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board,int i,int j){
        for(int k=0;k<9;k++){
//            if(){
//
//            }
            if(i!=k && board[k][j] == board[i][j]){
                return false;
            }
            if(j!=k && board[i][k] == board[i][j]){
                return false;
            }
            /**
             * 3 3      i/k * 3  + k/3       j/k* 3 + k%3
             */
            if((i/3 * 3 +k/3) !=i && (j/3 * 3 + k%3) != j && board[i/3 *3+k/3][j/ 3 * 3 + k%3] == board[i][j]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NO37 no37 = new NO37();
        no37.solveSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        });
//        no37.solveSudoku(new char[][]{
//                {'8','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        });
    }

}
