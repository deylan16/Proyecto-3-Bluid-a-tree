package clases.arboles;

public class SplayNode {
    public SplayNode left, right, parent;
    int element;

    /** Constructor **/
    public SplayNode()
    {
        this(0, null, null, null);
    }
    /** Constructor **/
    public SplayNode(int ele)
    {
        this(ele, null, null, null);
    }
    /** Constructor **/
    public SplayNode(int ele, SplayNode left, SplayNode right, SplayNode parent)
    {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = ele;
    }

    /**
     * Gets left.
     * @return the left
     */
    public SplayNode getLeft() {
        return left;
    }

    /**
     * Sets left.
     * @param left the left
     */
    public void setLeft(SplayNode left) {
        this.left = left;
    }

    /**
     * Gets right.
     * @return the right
     */
    public SplayNode getRight() {
        return right;
    }
    public int getElement() {
        return element;
    }
}
