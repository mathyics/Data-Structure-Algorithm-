

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

    // check if subtree is present in the binary tree
    public static boolean isSubtree(BinaryTree1.Node root, BinaryTree1.Node subRoot){
        if(root == null)
        return false;

        if(root.data==subRoot.data){
            if(isIdentical(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    public static boolean isIdentical(BinaryTree1.Node root, BinaryTree1.Node subRoot){
        if(root==null&&subRoot==null)return true;
        if((root==null || subRoot==null ) || root.data!=subRoot.data)return false;
        if(!isIdentical(root.left, subRoot.left)) return false;
        if(!isIdentical(root.right, subRoot.right)) return false;
        return true;

    }
    // Top view of Binary Tree
    public static class Info2{
        BinaryTree1.Node node;
        int horizontalDistance;

        Info2(BinaryTree1.Node node, int horizontalDistance){
            this.node=node;
            this.horizontalDistance=horizontalDistance;
        }
    }
    public static void topView(BinaryTree1.Node root){
        //Level order traversal with horizontal distance
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;
        Queue<Info2> q= new LinkedList<>();
        Map<Integer, BinaryTree1.Node> map= new HashMap<>();
        q.add(new Info2(root, 0));
        q.add(null);
        while(!q.isEmpty()){
            Info2 currInfo = q.remove();
            if(currInfo==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
            // first time we are visiting this horizontal distance
            // so we will add it to the map
            if(!map.containsKey(currInfo.horizontalDistance)){
                map.put(currInfo.horizontalDistance, currInfo.node);
            }
            if(currInfo.node.left!= null){
                q.add(new Info2(currInfo.node.left, currInfo.horizontalDistance-1));
                min =Math.min(min, currInfo.horizontalDistance-1);
            }
            if(currInfo.node.right!=null){
                q.add(new Info2(currInfo.node.right, currInfo.horizontalDistance+1));
                max=Math.max(max, currInfo.horizontalDistance+1);
            }
        }
        }
        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data + " ");
        }
    }
    public static void main(String[] args) {
        // int Nodes[] = { 1,2,4,8,-1,-1,9,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1 };
        // BinaryTree1.BinaryTree tree = new BinaryTree1.BinaryTree();
        // BinaryTree1.Node root = tree.buildTree(Nodes);
        // System.out.println("Diameter of the binary tree is: " + diameter(root));
        //  System.out.println("Optimized Diameter of the binary tree is: " + diameter2(root).diameter);
        BinaryTree1.BinaryTree tree = new BinaryTree1.BinaryTree();
        BinaryTree1.Node root = new BinaryTree1.Node(1);
        root.left = new BinaryTree1.Node(2);
        root.right = new BinaryTree1.Node(3);               
        root.left.left = new BinaryTree1.Node(4);
        root.left.right = new BinaryTree1.Node(5);
        root.right.left = new BinaryTree1.Node(6);
        root.right.right = new BinaryTree1.Node(7);
        

        // //subtree
        // BinaryTree1.Node subtree = new BinaryTree1.Node(2);
        // subtree.left = new BinaryTree1.Node(4);
        // subtree.right= new BinaryTree1.Node(5);
        // boolean isSubtreePresent = isSubtree(root, subtree);
        // if(isSubtreePresent) {
        //     System.out.println("The subtree is present in the binary tree.");
        // } else {
        //     System.out.println("The subtree is not present in the binary tree.");
        // }
        // Top view of the binary tree
        topView(root);
}

}