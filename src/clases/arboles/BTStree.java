package clases.arboles;

import java.io.IOException;

public class BTStree {
    private BSTNode root;
    /**
     * The Depth.
     */
    public int depth;

    /**
     * Instantiates a new Bst.
     */
    public BTStree() {
        this.root = null;
    }

    /**
     * Insert.
     * Añade un nodo al árbol
     * @param key the key
     */
    public void insert(int key)  {
        this.root = insert_Recursive(this.root, key);
    }

    /**
     * Insert recursive bst node.
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
     * Max depth int.
     * Se encarga de obtener la profundidad del árbol
     * @return the int
     */
    public int maxDepth(){
        this.depth = maxDepth_Recursive(this.root);
        return this.depth;
    }

    /**
     * Max depth recursive int.
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

    /**
     * Gets root.
     * @return the root
     */
    public BSTNode getRoot() {
        return root;
    }

    /**
     * Empty.
     * Se encargar de vaciar el árbol
     */
    public void empty(){
        this.root = null;
    }

    /**
     * Preorder.
     * Se encarga de obtener loa nodos en forma de preorder
     * @param nodo the nodo
     * @throws IOException the io exception
     */
    public void preorder (BSTNode nodo) throws IOException {
        if (nodo == null){
            return;
        }
        preorder(nodo.getLeft());
        preorder(nodo.getRight());
    }
}
