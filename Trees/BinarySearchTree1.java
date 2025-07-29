
import java.util.*;
public class BinarySearchTree1 {
    public static class Node{
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
           
        }
    }
    
    public static Node insert(Node root , int data){
        if(root==null){
            root =new Node(data);
            return root;
        }
        if(data<root.data){
            root.left=insert(root.left, data);
        }else if(data>root.data){
            root.right=insert(root.right, data);
        }

    

        return root;
    }
    // search in BST
    public static boolean search(Node root, int data) {
        if(root==null){
            return false;
        }
        if(root.data==data){
            return true;
        }
        if(root.data>data){
            return search(root.left, data);
        }else{
            return search(root.right, data);
        }
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static Node delete(Node root, int data){
        if(root.data>data){
            root.left=delete(root.left, data);
    }else if(root.data<data){
            root.right=delete(root.right, data);
        }else{
            // node found
            // case 1: no child
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2: one child
            else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }
            // case 3: two children
            else{
                Node minNode = findInorderSuccessor(root.right);
                root.data = minNode.data;
                root.right = delete(root.right, minNode.data);
            }
        }
        return root;
    }
     
    // Print in Range from K1 to K2
    public static void printInRange(Node root , int k1, int k2){
        if(root==null){
            return ;
        }
        
        //case 1
        if(root.data>=k1 && root.data<=k2){
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        //case 2
        if (root.data < k1) {
            printInRange(root.left, k1, k2);
            
        }else{//case3
            printInRange(root.right, k1, k2);
        }
    }
    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }


    //print Root to leaf path
    public static void printRoottoLeafPath(Node root, ArrayList<Integer> path){

        if(root == null) {
            return;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            System.out.println("" + path);
        }
        printRoottoLeafPath(root.left, path);
        printRoottoLeafPath(root.right, path);

        path.remove(path.size()-1);
    }


    // validate BST

    public static boolean isvaldBST(Node root, Node min, Node max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.data<=min.data){
            return false;
        }
        else if(max!=null&& root.data>= max.data){
            return false;
        }

        return (isvaldBST(root.left, min, root)&&isvaldBST(root.right,root, max));
        
    }
    // Mirror BST
    public static Node Mirror(Node root){
        if(root==null){
            return null;
        }
        Node left=Mirror(root.left);
        Node right=Mirror(root.right);

        root.left= right;
        root.right=left;

    return root;
    }
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
    public static void main(String[] args) {
        int [] arr = {8,5,10,3,6,11};
        Node root = null;
        ArrayList<Integer> path = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            root = insert(root, arr[i]);
        }

        // printRoottoLeafPath(root, path);
        
        Mirror(root);
        preorder(root);
        
    }
}
