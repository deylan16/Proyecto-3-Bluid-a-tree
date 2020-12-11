package clases.arboles;

/**
 * <p>Esta clase se creo para los nodos de los arboles BTS
 * </p>
 * @author Deylan
 */
public class BSTNode {
    private int key;
    private BSTNode left, right;

    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
