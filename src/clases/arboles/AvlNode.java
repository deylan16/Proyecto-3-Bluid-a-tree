package clases.arboles;

/**
 * <p>Esta clase se creo para los nodos de los arboles AVL
 * </p>
 * @author Deylan
 */
public class AvlNode {
    int element;
    AvlNode left;
    AvlNode right;
    int height;
    public AvlNode(int element) {
        this(element, null, null);
    }
    public AvlNode(int element, AvlNode left, AvlNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
        this.height = 0;
    }
    public int getElement(){
        return element;
    }

    public AvlNode getRight(){
        return right;
    }
    public AvlNode getLeft(){
        return left;
    }

}

