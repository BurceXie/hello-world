package lc;

import java.util.HashMap;
import java.util.Map;

public class N211 {

	public static void main(String[] args) {
		WordDictionary s = new N211().new WordDictionary();
	
		s.addWord("at");
		s.addWord("and");
		s.addWord("an");
		s.addWord("add");
		System.out.println(s.search("a"));
		System.out.println(s.search(".at"));
		s.addWord("bat");
		System.out.println(s.search(".at"));
		System.out.println(s.search("an."));
		System.out.println(s.search("a.d."));
		System.out.println(s.search("b."));
		System.out.println(s.search("a.d"));
		System.out.println(s.search("."));
	}

	class WordDictionary {
		TreeNode root;
		
	    public WordDictionary() {
	    	root = new TreeNode("", new HashMap<String, TreeNode>());
	    }
	    
	    public void addWord(String word) {
			TreeNode node = root;
			for (int i = 0; i < word.length(); i++) {
				String nodeVal = String.valueOf(word.charAt(i));
				if (node.subMap == null) {
					node.subMap = new HashMap<>();
				}
				if (!node.subMap.containsKey(nodeVal)) {
					node.subMap.put(nodeVal, new TreeNode(nodeVal));
				}
				node = node.subMap.get(nodeVal);
			}
			node.word = word;
		}
	    
		public boolean search(String word) {
			return search(root, word);
		}
		
		public boolean search(TreeNode node, String subWord) {
			if (node.subMap == null) {
				return false;
			}

			if (subWord.length() == 1) {
				if (".".equals(subWord)) {
					for (TreeNode n: node.subMap.values()) {
						if (n.word != null) {
							return true;
						}
					}
				} else if (node.subMap.containsKey(subWord)) {
					return node.subMap.get(subWord).word != null;
				}
				return false;
			}

			String s1 = subWord.substring(0, 1), s2 = subWord.substring(1);
			if (".".equals(s1)) {
				for (TreeNode n: node.subMap.values()) {
					if (search(n, s2)) {
						return true;
					}
				}
			} else if (node.subMap.containsKey(s1)) {
				return search(node.subMap.get(s1), s2);
			}
			return false;
		}
	}
}

class TreeNode {
	public String val;
	public String word;
	public Map<String, TreeNode> subMap;
	
	public TreeNode() {
		
	}
	
	public TreeNode(String val) {
		this.val = val;
	}
	
	public TreeNode(String val, Map<String, TreeNode> subMap) {
		this.val = val;
		this.subMap = subMap;
	}
}

