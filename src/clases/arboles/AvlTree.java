package clases.arboles;

public class AvlTree {
    private static final int ALLOWED_IMBALANCE =1;
    public AvlNode raiz = null;

    private int height(AvlNode t) {
        return t == null ? -1 : t.height;
    }

    public void crear(int x){
        this.raiz = this.insert(x,null);
    }
    public void insertar(int x){
        this.insert(x,raiz);
    }
    public AvlNode getRaiz(){
        return raiz;
    }
    private AvlNode insert(int x, AvlNode t) {
        if (t == null) {
            return new AvlNode(x);
        }
        if (x < t.element) {
            t.left = insert(x, t.left);
        } else if (x > t.element) {
            t.right = insert(x, t.right);
        }
        return balance(t);
    }

    private AvlNode balance(AvlNode t) {
        if (t == null)
            return t;
        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
                if(t.right == raiz){
                    raiz = t;
                }
            }else{
                t = doubleWithLeftChild(t);
                if(t.right == raiz){
                    raiz = t;}
            }
        } else {
            if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE) {
                if (height(t.right.right) >= height(t.right.left))
                    t = rotateWithRightChild(t);
                    if(t.left == raiz){
                        raiz = t;
                    }
                else
                    t = doubleWithRightChild(t);
                    if(t.left == raiz){
                        raiz = t;
                    }
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }
    private AvlNode rotateWithLeftChild(AvlNode k2) {
        AvlNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }
    private AvlNode doubleWithLeftChild(AvlNode k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }
    private AvlNode rotateWithRightChild(AvlNode k2) {
        AvlNode k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.right), height(k2.left)) + 1;
        k1.height = Math.max(height(k1.right), k2.height) + 1;
        return k1;
    }
    private AvlNode doubleWithRightChild(AvlNode k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

}


