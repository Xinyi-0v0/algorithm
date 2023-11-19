package Assignment1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    // Minimum Depth of Binary Tree
    int minD = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return minD;

    }

    private void dfs(TreeNode root, int currD) {
        if (root == null || currD > minD) {
            return;
        }

        if (root.left == null && root.right == null) {
            minD = Math.min(minD, currD);
            return;
        }

        dfs(root.left, currD + 1);
        dfs(root.right, currD + 1);

    }

    // Count Complete Tree Nodes
    int sum = 0;

    public int countNodes(TreeNode root) {
        dfs2(root);
        return sum;

    }

    private void dfs2(TreeNode node) {
        if (node == null) {
            return;
        }

        sum++;
        dfs2(node.left);
        dfs2(node.right);

        return;
    }

    // Find Largest Value in Each Tree Row
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(curr.val, max);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(max);
        }

        return res;

    }

    // Leaf-Similar Trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        dfs3(root1, list1);
        dfs3(root2, list2);

        return list1.equals(list2);

    }

    private void dfs3(TreeNode node, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
        }

        dfs3(node.left, list);
        dfs3(node.right, list);

    }

    // Deepest Leaves Sum
    int maxD = Integer.MIN_VALUE;
    int leavesSum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs4(root, 0);
        return sum;
    }

    private void dfs4(TreeNode node, int currD) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (currD > maxD) {
                maxD = currD;
                leavesSum = node.val;
            } else if (currD == maxD) {
                leavesSum += node.val;
            }
        }

        dfs4(node.left, currD + 1);
        dfs4(node.right, currD + 1);

    }
}