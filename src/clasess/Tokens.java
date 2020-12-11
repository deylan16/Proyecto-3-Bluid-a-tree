package clasess;

/**
 *
 * @author johnn
 */
public class Tokens {
    //BST de profundidad n
    //AVL con m elementos
    //B Tree de orden n con m niveles
    //Splay con n elementos
    
    public int BST(){
        int profu = (int) Math.floor(Math.random()*4+1);
        return profu;
    }
    public int AVL(){
        int elem = (int) Math.floor(Math.random()*6+1);
        return elem;
    }
    public int BT(){
        int nivel = (int) Math.floor(Math.random()*3+1);
        return nivel;
    }
    public int Splay(){
        int elem = (int) Math.floor(Math.random()*6+1);
        return elem;
    }
}
