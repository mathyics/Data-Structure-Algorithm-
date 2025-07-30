
import java.util.ArrayList;

public class BinarySearchTree2 {
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
  
        public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node creatBST(int[] arr, int st,int end){
        if(st>end){
            return null;
        }
        int mid= (st + end) / 2;
        Node root = new Node(arr[mid]);
        root.left=creatBST(arr, st, mid-1);
        root.right=creatBST(arr, mid+1, end);
        return root;

    }

    //convert BST to Balanced BST
    public static void inorder(Node root, ArrayList<Integer> inorder){
        if(root==null) return;
        inorder(root.left,inorder);
        inorder.add(root.data);
        inorder(root.right,inorder);
    }
    public static Node createBST1(ArrayList<Integer> inorder,int st, int end){
        if(st>end){
            return null;
        }
        int mid=(st+end)/2;
        Node root= new Node(inorder.get(mid));
        root.left=createBST1(inorder, st, mid-1);
        root.right=createBST1(inorder,mid+1,end);
        return root;
    }
    public static Node convertToBalancedBST(Node root) {
       //inorder sequence
       ArrayList<Integer> inorder= new ArrayList<>();
       inorder(root, inorder);
       //create balanced BST from inorder sequence
       return createBST1(inorder, 0, inorder.size()-1);

    }
    public static void main(String[] args) {
        
        Node root = new Node(8);

        root.left= new Node(6);
        root.left.left=new Node(5);
        root.left.left.left=new Node(3);

        root.right= new Node(10);
        root.right.right=new Node(11);
        root.right.right.right=new Node(12);

        root= convertToBalancedBST(root);
        preorder(root);

    }
    


}
