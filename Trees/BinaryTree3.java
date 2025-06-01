
import java.util.ArrayList;

class BinaryTree3{
    public static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    public static void kLevel(Node root, int level, int k){
        if(root==null)
        return ;
         if(level==k){
            System.out.print(root.data + " ");
            return;
        
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);

    }
    // Lowest Common Ancestor (LCA) of a Binary Tree
    public static boolean getPath(Node root , int n, ArrayList<Node> path){
        if(root==null){
            return false;
        }
        path.add(root);
        if(root.data==n){
            return true;
        }
        boolean FoundLeft=getPath(root.left,n, path);
        boolean FoundRight=getPath(root.right,n, path);
        if( FoundLeft || FoundRight)
        {
            return true;
        }

        path.remove(path.size()-1); // backtrack if not found
        return false;

    }
    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
         int i=0;
        for(;i<path1.size()&&i<path2.size();i++)
            if(path1.get(i)!=path2.get(i)){
                break;
            }

        Node Lca = path1.get(i-1);
        return Lca;
    }

    // Lowest Common Ancestor (LCA) of a Binary Tree (Optimized)
    public static Node lca2(Node root,int n1, int n2){
        if(root==null||root.data==n1||root.data==n2){
            return root;
        }
        Node leftLca=lca2(root.left, n1, n2);
        Node rightLca=lca2(root.right, n1, n2);

        if(leftLca==null)
        return rightLca;
        if(rightLca==null)
        return leftLca;

        return root;
    }

    //Minimum Distance Between Two Nodes in a Binary Tree
    public static int distanceFromLca(Node lca , int n ){
        if(lca==null){
            return -1;
        }
        if(lca.data==n){
            return 0;
        }
        int leftDistance = distanceFromLca(lca.left, n);
        int rightDistance = distanceFromLca(lca.right, n);
        if(leftDistance==-1 && rightDistance==-1){
            return -1;
        }else if(leftDistance==-1){
            return rightDistance + 1;
        }else{
            return leftDistance + 1;
        }
    }


    public static int MinDistance(Node root, int n1,int n2){
        Node lca =lca2(root,n1,n2);
        int d1 = distanceFromLca(lca, n1);
        int d2 = distanceFromLca(lca, n2);

        return d1 + d2;
    }
    //Kth Ancestor of a Node in a Binary Tree
    public static int KthAncestor(Node root, int n, int k){
        if(root==null) 
        return -1;

        if(root.data==n){
            return 0;
        }
       int  leftDist=KthAncestor(root.left, n, k);
        int rightDist=KthAncestor(root.right, n, k);

        int max= Math.max(leftDist,rightDist);
        if(max==-1){// left and right both are -1
            return -1;
        }
        if(max+1==k){
            System.out.println("The " + k + "th ancestor of node " + n + " is: " + root.data);
            return -1; // return -1 to indicate that we found the kth ancestor
        }
        return max+1;

    }
    // Transform a Binary Tree into Sum Tree
    public static int transform(Node root){
        if(root==null)   
        return 0;
        int leftChild= transform(root.left);
        int rightChild= transform(root.right);

        int oldValue = root.data;
        int newLeft= root.left==null?0:root.left.data;
        int newRight= root.right==null?0:root.right.data;
        root.data = leftChild + rightChild + newLeft + newRight;

        return oldValue;
    }
    public static void preOrder(Node root){
        if(root==null)
        return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

    //   int k =2;
    //     System.out.println("Nodes at level " + k + ":");
    //     kLevel(root, 0, k);
    //     System.out.println();
   
    // minDistance(root, 4, 5);
        // // int n1 = 4, n2 = 6;
        // int distance = MinDistance(root, n1, n2);
        // System.out.println("Minimum distance between " + n1 + " and " + n2 + " is: " + distance);
        // int n= 4, k=2;
        // KthAncestor(root, n, k);

        transform(root);
        System.out.println("Transformed tree (Sum Tree):");
        preOrder(root);
    }
}