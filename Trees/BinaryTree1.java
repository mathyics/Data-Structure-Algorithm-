package Trees;
import java.util.*;
public class BinaryTree1 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        static Node buildTree(int Nodes[]) {
            idx++;
            if (Nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(Nodes[idx]);
            newNode.left = buildTree(Nodes);
            newNode.right = buildTree(Nodes);
            return newNode;
        }
        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        //level order traversal
        public static void levelOrder(Node root) {
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode=q.remove();
                if(currNode==null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left!=null){
                        q.add(currNode.left);
                    }
                    if(currNode.right!=null){
                        q.add(currNode.right);
                    }
                }
            }

        }

        //height of the tree
        public static int height(Node root) {
            if(root==null){
                return 0;
            }
            int lh=height(root.left);
            int rh=height(root.right);
            return Math.max(lh, rh) + 1;
        }
        //count of nodes in the tree
        public static  int countNodes(Node root){
            if(root ==null){
                return 0;

            }
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount + rightCount + 1;
        }
        //sum of nodes in the tree
        public static int sumOfNodes(Node root){
            if(root==null)
            return 0;
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);
            return leftSum + rightSum + root.data;
        }

    }

    public static void main(String args[]) {
        int Nodes[] = { 1,2,4,8,-1,-1,9,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1 };
        BinaryTree tree=new BinaryTree();
        Node root = tree.buildTree(Nodes);
        // System.out.println("binary tree created successfully with root value:"+ root.data);
        // System.out.print("Preorder Traversal: ");
        // tree.preorder(root);
        // System.out.println("\nInorder Traversal: ");
        // tree.inorder(root);
        // System.out.println("\nPostorder Traversal: ");
        // tree.postorder(root);

        // System.out.println("\nLevel Order Traversal: ");
        // tree.levelOrder(root);

        // System.out.println("\nCount of the tree: " + tree.countNodes(root));
        System.out.print("sum of the nodes in thsb tree:"+tree.sumOfNodes(root));


    }
}