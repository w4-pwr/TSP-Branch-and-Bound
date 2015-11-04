package model;

/**
 * Created by Rafal on 2015-10-31.
 */
public class Node {

    public int[] order;
    public int lowerBound;
    public int numberOfNodes;


    public Node(int size) {
        this.numberOfNodes = 1;
        order = new int[size];
    }

    public Node(Node currentNode,int nextPoint) {
        this.order = currentNode.order;
        order[numberOfNodes] = nextPoint;
        numberOfNodes= currentNode.numberOfNodes+1;
    }

    public boolean checkIfVisitedPoint(int point){
        for(int i = 0 ;i<numberOfNodes;i++)
            if(order[i]==point)
                return true;
        return false;
    }
}
