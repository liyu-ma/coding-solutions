package btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInOrderTraversal {

    /**
     * Definition for a binary tree node.
     */
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    public List<Integer> inOrder(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         if (root == null) return res;

         Stack<TreeNode> stack = new Stack<>();
         TreeNode current = root;
         while (current != null || !stack.empty()) {
             while (current != null) {
                 current = current.left;
             }

             current = stack.pop();
             res.add(current.val);
             current = current.right;
         }

         return res;
    }

    public static void main(String[] args) {

    }
}
