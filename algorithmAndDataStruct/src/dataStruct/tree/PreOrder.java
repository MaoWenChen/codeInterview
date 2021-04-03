package dataStruct.tree;

	 
	  
	
	import java.util.ArrayList;
	import java.util.Stack;
	public class PreOrder {
	    public ArrayList<Integer> preorderTraversal(TreeNode root) {
	        ArrayList<Integer> list = new ArrayList<>();
	        if(root == null)return list;
	        Stack<TreeNode> stack = new Stack<>();
	        TreeNode node = root;
	        do{
	            while(node != null){
	                list.add(node.val);
	                stack.push(node);
	                node = node.left;
	            }
	            node = stack.pop().right;
	            
	        }while(node != null || !stack.isEmpty());
	        return list;
	    }
	    class TreeNode {
		     int val;
		     TreeNode left;
		      TreeNode right;
		     TreeNode(int x) { val = x; }
		     }
	}

	 