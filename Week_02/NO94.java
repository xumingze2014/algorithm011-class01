package com.example.demo.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 */
public class NO94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        helper(root,result);

        return result;
    }


    public static void helper(TreeNode root,List<Integer> result){
        if(root != null){
            if(root.left != null){
                helper(root.left,result);
            }
            result.add(root.val);
            if(root.right != null){
                helper(root.right,result);
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}