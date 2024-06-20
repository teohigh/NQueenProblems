/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ADMIN
 */
// Java program for Knight Tour problem 


public class Knight1 {

    private static int[][] board;
    private static int boardSize;
    private static int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int x, y;

    public Knight1(int boardSize) {
        this.boardSize = boardSize;
        this.board = new int[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = -1; // -1 indicates unvisited
            }
        }
    }

    public boolean solveKnightTour(int[][] chessboard, int row, int col, int moveCount) {
        // Start from a corner square (usually a good starting point)
        board = chessboard;
        return tryMove(row, col, moveCount);
    }

    private boolean tryMove(int row, int col, int moveCount) {
        board[row][col] = moveCount;

        // Check if we've reached the final move
        if (moveCount == boardSize * boardSize) {
            return true;
        }
        

        // Get a list of potential next moves sorted by Warnsdorff's heuristic
        List<Move> nextMoves = getNextMoves(row, col);
        if(nextMoves.isEmpty())
            return false;       // No valid moves found, backtracking won't lead to a solution
        Collections.sort(nextMoves);
            
        // Try each potential move in order of heuristic priority
        for (Move move : nextMoves) {            
            if (tryMove(move.row, move.col, moveCount + 1)) {
                return true;
            }
        }

        // Backtrack if none of the moves lead to a solution
        board[row][col] = -1;
        return false;
    }

    private List<Move> getNextMoves(int row, int col) {
        List<Move> moves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];
            if (isValidMove(newRow, newCol)) {
                moves.add(new Move(newRow, newCol, getDegree(newRow, newCol)));
            }
        }
        return moves;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize && board[row][col] == -1;
    }

    private int getDegree(int row, int col) { // Warnsdorff's heuristic
        int degree = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];
            if (isValidMove(newRow, newCol)) {
                degree++;
            }
        }
        return degree;
    }

    public void printBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.printf("%5d ", board[i][j]);
            }
            System.out.println();
        }
    }
    
    public int[][] getChessBoard(){
        return this.board;
    }
    
    public void setChessBoard(int[][] board){
        this.board = board;
    }
    
    public void setChess(int row, int col, int step){
        board[row][col] = step;
    }

    public static void main(String[] args) {
        int boardSize = 7; // Adjust board size as needed, 5-80
        x = 0; y = 3;
        Knight1 knightTour = new Knight1(boardSize);
        board[x][y] = 1;

        if (knightTour.solveKnightTour(board, x, y, board[x][y])) {
            System.out.println("Knight's Tour solved successfully!");
            knightTour.printBoard(); // Print the solution board
        } else {
            System.out.println("No solution found for the given board size.");
        }
    }
}
