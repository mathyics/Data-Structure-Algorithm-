
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
    //Size of Largest BST in a Binary Tree

    static class Info{
        int size ;
        int min;
        int max;
        boolean isBST;

        Info(boolean isBST,int size, int min, int max) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    } 
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info left=largestBST(root.left);
        Info right=largestBST(root.right);
        int size=left.size+right.size+1;
        int min = Math.min(root.data,Math.min(left.min, right.min));
        int max = Math.max(root.data,Math.max(left.max, right.max));

        //check its valid bst or not
        if(root.data<=left.max||root.data>=right.min){
            return new Info(false, size, min,max);

        }
        if(left.isBST&&right.isBST){
            maxBST=Math.max(size, maxBST);
            return new Info(true, size, min, max);
        }

        return new Info (false, size ,min, max);
    }
    // Merge 2 BSt 

    public static Node mergeBST(Node root1, Node root2){
        ArrayList<Integer> inorder1=new ArrayList<>();
        ArrayList<Integer> inorder2=new ArrayList<>();
        inorder(root1, inorder1);
        inorder(root2, inorder2);
        ArrayList<Integer> mergedInorder = new ArrayList<>();

        int i=0,j=0;
        while(i<inorder1.size()&&j<inorder2.size()){

            if(inorder1.get(i)<inorder2.get(j)){
                mergedInorder.add(inorder1.get(i));
                i++;
            }else{
                mergedInorder.add(inorder2.get(j));
                j++;
            }
        }
        while(j!=inorder2.size()){
            mergedInorder.add(inorder2.get(j));
            j++;
        }
        while(i!=inorder1.size()){
            mergedInorder.add(inorder1.get(i));
            i++;
        }
        return createBST1(mergedInorder, 0, mergedInorder.size()-1);

    }

    public static void main(String[] args) {
        
        Node root = new Node(50);
        root.left=new Node(30);
        root.left.left=new Node(5);
        root.left.right=new Node(20);

        root.right= new Node(60);
        root.right.left= new Node(45);
        root.right.right= new Node(70);
        root.right.right.left= new Node(65);
        root.right.right.right= new Node(80);

    Info info = largestBST(root);
        System.out.println("Size of Largest BST in the Binary Tree: " + maxBST);
        
      
    }
    


}
