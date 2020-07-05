package com.example.demo.week2;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 */
public class NO589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList();
        helper(root,result);
        return result;
    }

    public void helper(Node node,List<Integer> res){
        if(node != null){
            res.add(node.val);

            for(Node s : node.children){
                helper(s,res);
            }

        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
