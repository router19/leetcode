class Solution {
    int rows,cols;
    public void solve(char[][] board) {
        //We will use boundary DFS to solve this problem
        
      // Let's analyze when an 'O' cannot be flipped,
      // if it has atleast one 'O' in it's adjacent, AND ultimately this chain of adjacent 'O's is connected to some 'O' which lies on boundary of board
        
      //consider these two cases for clarity :
      /*
        O's won't be flipped          O's will be flipped
        [X O X X X]                   [X X X X X]     
        [X O O O X]                   [X O O O X]
        [X O X X X]                   [X O X X X] 
        [X X X X X]                   [X X X X X]
      
      So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped
      
      */
        
      //Steps to Solve :
      //1. Move over the boundary of board, and find O's 
      //2. Every time we find an O, perform DFS from it's position
      //3. In DFS convert all 'O' to '#'      (why?? so that we can differentiate which 'O' can be flipped and which cannot be)   
      //4. After all DFSs have been performed, board contains three elements,#,O and X
      //5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
      //6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'
       
        rows = board.length;
        if(rows == 0) return;

        cols = board[0].length;
        if(rows <=2 || cols <=2) return;

        //moving over first and last columns
        for(int row = 0;row < rows ;row++){
            if(board[row][0] == 'O')
                dfs(board,row,0);
            if(board[row][cols-1] == 'O')
                dfs(board,row,cols-1);    
        }
        //iterate over cols
        for(int col = 0;col < cols ;col++){
            if(board[0][col] == 'O')
                dfs(board,0,col);
            if(board[rows-1][col] == 'O')
                dfs(board,rows-1,col);    
        }


        for(int row=0;row <rows;row++){
            for(int col =0; col<cols;col++){
                if(board[row][col] == 'O')
                    board[row][col] = 'X';    
                if(board[row][col] == '#')
                    board[row][col] = 'O';
            }
        }

    }

    void dfs(char[][] board, int row,int col) {
        if(row < 0 || row >= rows || col <0 || col >=cols || board[row][col] != 'O') return;
        board[row][col] = '#';

        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col-1);
        dfs(board,row,col+1);
    }
}