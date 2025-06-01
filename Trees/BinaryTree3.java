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
        
        Node lca = path1.get(i-1);
        return lca;
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
    int n1 = 4, n2 = 5;
        Node lcaNode = lca(root, n1, n2);
        if (lcaNode != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is: " + lcaNode.data);
        } else {
            System.out.println("LCA not found.");
        }
    }
}