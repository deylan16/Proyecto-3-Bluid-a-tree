package clases.arboles;

import java.io.IOException;
/**
 * <p>Esta clase se creo para hacer los arboles BTS
 * </p>
 * @author Deylan
 */
public class BTStree {
    private BSTNode root;
    public int depth;

    public BTStree() {
        this.root = null;
    }

    public void insert(int key)  {
        this.root = insert_Recursive(this.root, key);
    }

    /**
     * <p>Inserta el nodo revisando en que lugar debe ir</p>
     * @param root the root
     * @param key  the key
     * @return the bst node
     */
    BSTNode insert_Recursive(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.getKey()) {
            root.setLeft(insert_Recursive(root.getLeft(), key));
        }

        else if (key > root.getKey()){
            root.setRight(insert_Recursive(root.getRight(), key));
        }
        return root;
    }

    /**
     * <p>Se encarga de obtener la profundidad del árbol</p>
     * @return the int
     */
    public int maxDepth(){
        this.depth = maxDepth_Recursive(this.root);
        return this.depth;
    }

    /**
     *<p> Busca la maxima profundidad del nodo</p>
     * @param node the node
     * @return the int
     */
    public int maxDepth_Recursive(BSTNode node) {
        if (node == null) {
            return (-1);
        } else {
            int leftDepth = maxDepth_Recursive(node.getLeft());
            int rightDepth = maxDepth_Recursive(node.getRight());
            if (leftDepth > rightDepth )
                return (leftDepth + 1);
            else
                return (rightDepth + 1);
        }
    }

    public BSTNode getRoot() {
        return root;
    }

    public void empty(){
        this.root = null;
    }

}
