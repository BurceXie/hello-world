package lc;

import lc.base.TreeNode;

public class N230 {

	public static void main(String[] args) {
		Solution s = new N230().new Solution();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		
		System.out.println(s.kthSmallest(root, 1));
		System.out.println(s.kthSmallest(root, 2));
		System.out.println(s.kthSmallest(root, 3));
		System.out.println(s.kthSmallest(root, 4));
	}

	class Solution {
		int n = -1;
	    public int kthSmallest(TreeNode root, int k) {
	    	n = -1;
	    	findNodeNum(root, k);
	    	return n;
	    }
	    
	    public int findNodeNum(TreeNode node, int k) {
	    	int l = 0, r = 0;
	    	if (node.left != null) {
	    		l = findNodeNum(node.left, k);
	    		if (n >= 0) {
	    			return l;
	    		}
	    	}
	    	if (node.right != null) {
	    		r = findNodeNum(node.right, k - 1 - l);
	    		if (n >= 0) {
	    			return l + 1 + r;
	    		}
	    	}
	    	if (k == l + 1) {
	    		n = node.val;
	    	}
	    	return l + 1 + r;
	    }
	}
}

