package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.Stack;

public class SymmetricTree {

    /**
     * Симметричное
     *      *
     *     / \
     *    *   *
     *   / \ / \
     *  *  **  *
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        root.left = l1;
        TreeNode l2 = new TreeNode(2);
        root.right = l2;

        l1.left = new TreeNode(3);
        l1.right = new TreeNode(4);

        l2.left = new TreeNode(4);
        l2.right = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isSymmetricRecursive(root.left, root.right);
    }

    public boolean isSymmetricRecursive(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 != null && node2 != null) {
            return node1.val == node2.val
                    && isSymmetricRecursive(node1.left, node2.right)
                    && isSymmetricRecursive(node1.right, node2.left);
        }

        return false;
    }
}
