package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lc.base.TreeNode;

/**
 * 1305. 两棵二叉搜索树中的所有元素(2)
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 *
 */
public class N1305 {

	public static void main(String[] args) {
		Solution s = new N1305().new Solution();
		
	}

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    	List<TreeNode> thisList = new ArrayList<TreeNode>(), subList = new ArrayList<TreeNode>();
    	thisList.add(root1);
    	thisList.add(root2);
    	
    	List<Integer> list = new ArrayList<Integer>();
    	while (!thisList.isEmpty()) {
    		for (TreeNode node: thisList) {
    			if (node == null) {
    				continue;
    			}
    			list.add(node.val);
    			if (node.left != null) {
    				subList.add(node.left);
    			}
    			if (node.right != null) {
    				subList.add(node.right);
    			}
    		}
    		thisList.clear();
    		thisList.addAll(subList);
    		subList.clear();
    	}

    	return list.stream().sorted().collect(Collectors.toList());
    }
}
}

