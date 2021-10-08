package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class SameTrees {

    /**
     * Одинаковые
     * *          *
     * / \        / \
     * *   *      *   *
     * / \        / \
     * *   *      *   *
     */
    @Test
    public void test() {
        TreeNode root1 = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        root1.left = l1;
        TreeNode l2 = new TreeNode(20);
        root1.right = l2;

        TreeNode l3 = new TreeNode(15);
        l2.left = l3;
        TreeNode l4 = new TreeNode(7);
        l2.right = l4;

        TreeNode root2 = new TreeNode(3);
        TreeNode r2l1 = new TreeNode(9);
        root2.left = r2l1;
        TreeNode r2l2 = new TreeNode(20);
        root2.right = r2l2;

        TreeNode r2l3 = new TreeNode(15);
        r2l2.left = r2l3;
        TreeNode r2l4 = new TreeNode(7);
        r2l2.right = r2l4;

        System.out.println(isSameTreeIterative(root1, root2));
        System.out.println(isSameTreeIterative(root1, root2));
    }

    private boolean isSameTreeIterative(TreeNode root1, TreeNode root2) {
        Stack<Temp> stack = new Stack<>();
        Temp current = new Temp(root1, root2);
        stack.push(current);

        do {
            if ((current.node1 == null && current.node2 != null)
                    || (current.node1 != null && current.node2 == null)) {
                return false;
            }

            if (current.node1 != null) {
                if (current.node1.val != current.node2.val) {
                    return false;
                }

                stack.push(new Temp(current.node1.left, current.node2.left));
                stack.push(new Temp(current.node1.right, current.node2.right));
            }

            current = stack.pop();
        } while (!stack.isEmpty());

        return true;
    }

    public static boolean isSameTreeRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return ((root1.val == root2.val) &&
                    (isSameTreeRecursive(root1.left, root2.left)) &&
                    (isSameTreeRecursive(root1.right, root2.right)));
        }

        return false;
    }

    class Temp {
        TreeNode node1;
        TreeNode node2;

        public Temp(TreeNode node1, TreeNode node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }
}
