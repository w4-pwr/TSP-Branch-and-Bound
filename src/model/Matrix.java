package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rafal on 2015-10-31.
 */
public  class Matrix {

    private int[][] matrix;
    private boolean symmetric;

    public Matrix(final int size, boolean symmetric) {
        this.symmetric = symmetric;
        matrix = new int[size][size];
    }

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getEdgeCount() {
        return matrix.length;
    }

    public boolean isSymmetric() {
        return symmetric;
    }

    public void add(final Edge edge) {
        matrix[edge.vertex1][edge.vertex2] = edge.weight;
        if(symmetric) {
            matrix[edge.vertex2][edge.vertex1] = edge.weight;
        }
    }

    public int getWeight(int from, int to){
        return matrix[from][to];
    }
    public void remove(final Edge edge) {
        matrix[edge.vertex1][edge.vertex2] = Edge.NO_EXIST;
        if(symmetric) {
            matrix[edge.vertex2][edge.vertex1] = Edge.NO_EXIST;
        }
        edge.invalidate();
    }

    public void update(final Edge edge) {
        add(edge);
    }

    public Edge get(int vertex1, int vertex2) {
        return new Edge(vertex1, vertex2, matrix[vertex1][vertex2]);
    }

    public List<Edge> getEdgesFor(int vertex) {
        List<Edge> edges = new LinkedList<>();
        int[] adjacentEdges = matrix[vertex];
        for(int i = 0; i < adjacentEdges.length; i++) {
            Edge tmpEdge = new Edge(vertex, i, adjacentEdges[i]);
            if(tmpEdge.isExist()) {
                edges.add(tmpEdge);
            }
        }
        return edges;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getSize() {
        return matrix.length;
    }
}
