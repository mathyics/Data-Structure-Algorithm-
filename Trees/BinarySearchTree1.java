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

    public static Node findInorderSuccessor(Node root) {
        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int [] arr = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        for(int i=0;i<arr.length;i++){
            root = insert(root, arr[i]);
        }

       System.out.println(search(root,7));
    }
}
