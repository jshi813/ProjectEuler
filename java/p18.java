import java.lang.Math;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Arrays;
import java.util.List;

class P18 {
	
	static Map<List<Integer>, TreeNode> map;
	static List<List<Integer>> list;
	
	public static void main(String args[]) {
		list = buildList();
		map = new HashMap();

		TreeNode root = buildTree(0, 0);

		int max = maxSumOnNode(root);

		System.out.println(max);
	}

	static int maxSumOnNode(TreeNode node) {
		if (node == null) return 0;
		return node.val + Math.max(maxSumOnNode(node.left), maxSumOnNode(node.right));
	}

	static List<List<Integer>> buildList() {
		List<List<Integer>> list = new ArrayList();
		list.add(Arrays.asList(75));
		list.add(Arrays.asList(95,64));
		list.add(Arrays.asList(17,47,82));
		list.add(Arrays.asList(18,35,87,10));
		list.add(Arrays.asList(20,04,82,47,65));
		list.add(Arrays.asList(19,01,23,75,03,34));
		list.add(Arrays.asList(88,02,77,73,07,63,67));
		list.add(Arrays.asList(99,65,04,28,06,16,70,92));
		list.add(Arrays.asList(41,41,26,56,83,40,80,70,33));
		list.add(Arrays.asList(41,48,72,33,47,32,37,16,94,29));
		list.add(Arrays.asList(53,71,44,65,25,43,91,52,97,51,14));
		list.add(Arrays.asList(70,11,33,28,77,73,17,78,39,68,17,57));
		list.add(Arrays.asList(91,71,52,38,17,14,91,43,58,50,27,29,48));
		list.add(Arrays.asList(63,66,04,68,89,53,67,30,73,16,69,87,40,31));
		list.add(Arrays.asList(04,62,98,27,23,9,70,98,73,93,38,53,60,04,23));
		return list;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int v) {
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}

	static TreeNode buildTree(int row, int col) {
		// System.out.println("node val: " + node.val + " row: " + row + " col: " + col);
		if (row >= list.size()) {
			return null;
		}
		List<Integer> pos = Arrays.asList(row, col);
		
		if (map.containsKey(pos)) {
			return map.get(pos);
		}

		TreeNode node = new TreeNode(list.get(row).get(col));
		map.put(Arrays.asList(row, col), node);

		node.left = buildTree(row+1, col);
		node.right = buildTree(row+1, col+1);

		return node;
	}
}