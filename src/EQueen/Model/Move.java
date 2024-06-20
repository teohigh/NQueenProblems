/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EQueen.Model;

/**
 *
 * @author ADMIN
 */
public class Move implements Comparable<Move> {
    public int row, col, degree;

    public Move(int row, int col, int degree) {
        this.row = row;
        this.col = col;
        this.degree = degree;
    }

    public int compareTo(Move other) {
        return this.degree - other.degree; // Prioritize moves with fewer onward moves
    }
}
