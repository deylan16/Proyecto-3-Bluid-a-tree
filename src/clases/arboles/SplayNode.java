package clases.arboles;
/**
 * <p>Esta clase se creo para los nodos de los arboles Splay
 * </p>
 * @author Deylan
 */
public class SplayNode {
    public SplayNode left, right, parent;
    int element;

    /** Constructor **/
    public SplayNode()
    {
        this(0, null, null, null);
    }
    public SplayNode(int ele)
    {
        this(ele, null, null, null);
    }
    public SplayNode(int ele, SplayNode left, SplayNode right, SplayNode parent)
    {
        this.left = left;
        this.right = right;
        this.parent = parent;
        this.element = ele;
    }

    public SplayNode getLeft() {
        return left;
    }

    public void setLeft(SplayNode left) {
        this.left = left;
    }

    public SplayNode getRight() {
        return right;
    }
    public int getElement() {
        return element;
    }
}
