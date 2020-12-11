package clases.arboles;

/**
 * The type Bst node.
 */
public class BSTNode {
    private int key;
    private BSTNode left, right;

    /**
     * Instantiates a new Bst node.
     * @param key the key
     */
    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }

    /**
     * Gets left.
     * @return the left
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Sets left.
     * @param left the left
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }

    /**
     * Gets right.
     * @return the right
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * Sets right.
     * @param right the right
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }

    /**
     * Gets key.
     * @return the key
     */
    public int getKey() {
        return key;
    }

    /**
     * Sets key.
     * @param key the key
     */
    public void setKey(int key) {
        this.key = key;
    }
}
