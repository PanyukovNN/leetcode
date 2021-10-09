package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinimumDepthOfBinaryTree {

    /**
     * Результат: 2
     *
     *      *
     *     / \
     *    *   *
     *       / \
     *      *   *
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        root.left = l1;
        TreeNode l2 = new TreeNode(2);
        root.right = l2;

        l2.left = new TreeNode(4);
        l2.right = new TreeNode(3);

        System.out.println(minDepthIterative(root));
    }

    public int minDepthIterative(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNodeDepth> queue = new LinkedList<>();

        TreeNodeDepth node = new TreeNodeDepth(root, 1);
        queue.add(node);
        while(!queue.isEmpty()) {
            node = queue.poll();

            if (node.left == null && node.right == null) {
                return node.depth;
            }

            if (node.left != null) {
                queue.add(new TreeNodeDepth(node.left, node.depth + 1));
            }

            if (node.right != null) {
                queue.add(new TreeNodeDepth(node.right, node.depth + 1));
            }
        }

        return 0;
    }

    private class TreeNodeDepth extends TreeNode {
        int depth;

        TreeNodeDepth(TreeNode node, int depth) {
            super(node.val, node.left, node.right);
            this.depth = depth;
        }
    }
}
