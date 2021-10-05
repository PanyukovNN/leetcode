package com.panyukovnn.leetcode;

import com.panyukovnn.leetcode.model.TreeNode;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxDepthOfBinaryTree {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        root.left = l1;
        TreeNode l2 = new TreeNode(20);
        root.right = l2;

        TreeNode l3 = new TreeNode(15);
        l2.left = l3;
        TreeNode l4 = new TreeNode(7);
        l2.right = l4;

//        TreeNode l5 = new TreeNode(1);
//        l4.left = l5;
//        TreeNode l6 = new TreeNode(2);
//        l4.right = l6;
//
//
//        TreeNode l7 = new TreeNode(3);
//        l6.left = l7;
//        TreeNode l8 = new TreeNode(4);
//        l6.right = l8;


        System.out.println(maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        return leftMaxDepth > rightMaxDepth
                ? leftMaxDepth + 1
                : rightMaxDepth + 1;
    }
}
