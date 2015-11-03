package model;

/**
 * Created by Rafal on 2015-10-31.
 */
public class Node {

    public int[][] original;
    public int[][] reduced;
    public Edge[] solution;
    public float lowerBound;
    public boolean leftChild;

    public Node(final int[][] matrix) {
        this.original = matrix;
        leftChild = false;
        lowerBound = 0;
    }
}
