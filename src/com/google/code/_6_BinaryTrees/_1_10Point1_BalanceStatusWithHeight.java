package com.google.code._6_BinaryTrees;

class BalanceStatusWithHeight {
    boolean isBalanced;
    int height;

    BalanceStatusWithHeight(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}

public class _1_10Point1_BalanceStatusWithHeight {

    public static void main(String[] args) {
        TreeNode<Integer> tNode = new TreeNode<>(10, null, null);
        TreeNode<Integer> tNode1 = new TreeNode<>(20, null, null);
        TreeNode<Integer> tNode2 = new TreeNode<>(30, null, null);
        TreeNode<Integer> tNode3 = new TreeNode<>(40, null, null);
        TreeNode<Integer> tNode4 = new TreeNode<>(50, null, null);

//        tNode3.left = tNode4;
        tNode2.left = tNode3;
        tNode1.left = tNode2;
        tNode.left = tNode1;
        BalanceStatusWithHeight status = checkBalanced(tNode);
        System.out.println("isbalanced: " + status.isBalanced + "\nheight: " + status.height);

    }

    public static BalanceStatusWithHeight checkBalanced(TreeNode<Integer> root) {
        if (root == null) {
            return new BalanceStatusWithHeight(true, 0);
        }
        BalanceStatusWithHeight leftRes = checkBalanced(root.left);
        if (!leftRes.isBalanced) {// Optimization
            return leftRes;
        }
        BalanceStatusWithHeight rigthRes = checkBalanced(root.right);
        if (!rigthRes.isBalanced) { // Optimization
            return rigthRes;
        }

        int height = Math.max(leftRes.height, rigthRes.height) + 1;
        System.out.println("Height: " + height + " Data: " + root.data);
        boolean isBalanced = Math.abs(leftRes.height - rigthRes.height) <= 1;
        BalanceStatusWithHeight bsh = new BalanceStatusWithHeight(isBalanced, height);

        return bsh;
    }
}
