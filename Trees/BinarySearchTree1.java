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
        if(root.data>data){
            root.left=insert(root.left, data);
        }else if(root.data<data){
            root.right=insert(root.right, data);
        }

    

        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int [] arr = {5,1,3,4,2,7};
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = insert(root, arr[i]);
        }

        inorder(root);
    }
}
