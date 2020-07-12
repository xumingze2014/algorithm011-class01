package com.example.demo.week3;

public class NO236 {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root,p,q);
        return ans;
    }

    public boolean helper(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return false;
        }

        boolean loon = helper(root.left,p,q);
        boolean roon = helper(root.right,p,q);

        if( (loon && roon) || ((root.val == p.val || root.val == q.val )) &&
                (roon || loon) ) {
            ans = root;
        }

        return loon || roon || (root.val == p.val || root.val == q.val ) ;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        NO236 no236 = new NO236();
        TreeNode root = no236.lowestCommonAncestor(treeNode1, treeNode4, treeNode5);
        System.out.println(no236.lowestCommonAncestor(treeNode1, treeNode4, treeNode5));
    }
}
