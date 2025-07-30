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
    public static void main(String[] args) {
        int[] nums={3,5,6,8,10,11,12};
        Node root = creatBST(nums, 0, nums.length-1);
        preorder(root);

    }
    


}
