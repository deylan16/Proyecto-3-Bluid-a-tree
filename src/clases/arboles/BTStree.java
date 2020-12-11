package clases.arboles;

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
}
