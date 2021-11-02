package lc;

import lc.base.TreeNode;;

/**
 * 235. 二叉搜索树的最近公共祖先(1)
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class N235 {

	public static void main(String[] args) {
		Solution s = new N235().new Solution();
		
	}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode f = root;
        while (true) {
        	if (p.val == f.val || q.val == f.val || (p.val > f.val && q.val < f.val) || (p.val < f.val && q.val > f.val)) {
        		return f;
        	}
        	if (p.val < f.val) {
        		f = f.left;
        	} else {
        		f = f.right;
        	}
        }
    }
}
}

