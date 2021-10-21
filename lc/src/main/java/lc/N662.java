package lc;

import java.util.ArrayList;
import java.util.List;

import lc.base.TreeNode;

public class N662 {

	public static void main(String[] args) {
		Solution s = new N662().new Solution();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(9);
		System.out.println(s.widthOfBinaryTree(root));
	}

	class Solution {
		public int widthOfBinaryTree(TreeNode root) {
		    List<TreeNode> nodeList = new ArrayList<>();
		    
	    	int maxWidth = 1;
	    	if (root.left == null && root.right == null) {
	    		return maxWidth;
	    	}
	    	
	    	if (root.left != null) {
	    		root.left.val = -1;
	    		nodeList.add(root.left);
	    	}
	    	if (root.right != null) {
	    		root.right.val = 0;
	    		nodeList.add(root.right);
	    	}
	    	return widthOfBinaryTreeLevel(nodeList, maxWidth);
	    }
	    
		public int widthOfBinaryTreeLevel(List<TreeNode> nodeList, int maxWidth) {
			List<TreeNode> nextLevelList = new ArrayList<>();
			
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
			for (TreeNode node: nodeList) {
				if (node.val > max) {
					max = node.val;
				} 
				if (node.val < min) {
					min = node.val;
				}
				
				if (node.left != null) {
					node.left.val = node.val * 2;
					nextLevelList.add(node.left);
				}
				if (node.right != null) {
					node.right.val = node.val * 2 + 1;
					nextLevelList.add(node.right);
				}
			}
			if (max - min + 1 > maxWidth) {
				maxWidth = max - min + 1;
			}
			if (nextLevelList.isEmpty()) {
				return maxWidth;
			} else {
				return widthOfBinaryTreeLevel(nextLevelList, maxWidth);
			}
		}
	}
}

