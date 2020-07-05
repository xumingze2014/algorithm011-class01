package com.example.demo.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 */
public class NO144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res){
        if(root != null) {
            res.add(root.val);
            if(root.left != null){
                helper(root.left,res);
            }
            if(root.right != null){
                helper(root.right,res);
            }
        }
    }
}

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}
