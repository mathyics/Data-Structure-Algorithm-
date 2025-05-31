import java.util.*;


public class BinaryTree2 {
    //diameter of binary tree
    public static int diameter(BinaryTree1.Node root){
        if(root==null) return 0;
        int leftDiameter = diameter(root.left);
        int lh =BinaryTree1.BinaryTree.height(root.left);
        int rightDiameter = diameter(root.right);
        int rh = BinaryTree1.BinaryTree.height(root.right);
        int selfDiameter=lh+rh+1;
        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));


    }
    static class Info{
        int height;
        int diameter;

        Info(int height, int diameter){
            this.height=height;
            this.diameter=diameter;
        }
    }
    // optimized diameter of Binary tree
    public static Info diameter2(BinaryTree1.Node root){
        if(root ==null)
        return new Info(0,0);

        Info leftInfo=diameter2(root.left);
        Info rightInfo=diameter2(root.right);
        int diam=Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int height=Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(height,diam);
    }
    public static void main(String[] args) {
        int Nodes[] = { 1,2,4,8,-1,-1,9,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1 };
        BinaryTree1.BinaryTree tree = new BinaryTree1.BinaryTree();
        BinaryTree1.Node root = tree.buildTree(Nodes);
        System.out.println("Diameter of the binary tree is: " + diameter(root));
         System.out.println("Optimized Diameter of the binary tree is: " + diameter2(root).diameter);
}

}