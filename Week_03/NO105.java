package com.example.demo.week3;

import java.util.HashMap;
import java.util.Map;

public class NO105 {
    Map<Integer,Integer> tmp = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            tmp.put(inorder[i],i);
        }
        return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode helper(int[] preorde,int[] inorder,int preLeft,int preRight,int inLeft,int inRight){
      if(preLeft > preRight){
          return null;
      }
      int inOrderRoot = tmp.get(preorde[preLeft]);
      TreeNode treeNode = new TreeNode(preorde[preLeft]);
      int sizeLeft = inOrderRoot - inLeft;
      treeNode.left = helper(preorde, inorder, preLeft + 1, preLeft+sizeLeft,inLeft,inOrderRoot-1);
      treeNode.right = helper(preorde, inorder, preLeft+sizeLeft+1,preRight,inOrderRoot+1,inRight);
      return treeNode;
    };

    public static void main(String[] args) {
        NO105 no105 = new NO105();
        TreeNode treeNode = no105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
