package com.unuse.p401_p450;

/**
 * @author Unuse
 * @date 2019/12/19
 */
public class P404_SumOfLeftLeaves {


	static class TreeNode {
	   int val;
	   TreeNode left;
	   TreeNode right;
	   TreeNode(int x) { val = x; }
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if (null == root) {
			return 0;
		}
		return sumOfLeftLeaves(root, false);
	}

	public static int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
		if (null == root.left && null == root.right) {
			if (isLeft) {
				return root.val;
			} else {
				return 0;
			}
		}
		int sum = 0;
		if (null != root.left) {
			sum += sumOfLeftLeaves(root.left, true);
		}
		if (null != root.right) {
			sum += sumOfLeftLeaves(root.right, false);
		}
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(sumOfLeftLeaves(root));
	}

}
