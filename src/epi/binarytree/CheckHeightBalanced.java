package epi.binarytree;

public class CheckHeightBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode<String> root = BinaryTreeTest.getSampleHeightBalancedTree();
		System.out.println(checkHeightBalanced(root).isBalanced);
	}
	
	public static BalanceStatusWithHeight checkHeightBalanced(BinaryTreeNode<String> root) {
		
		if (root == null) {
			return new BalanceStatusWithHeight(-1, true);
		}
		
		BalanceStatusWithHeight left = checkHeightBalanced(root.left);
		BalanceStatusWithHeight right = checkHeightBalanced(root.right);
		
		if (!left.isBalanced) {
			return left;
		}
		
		if (!right.isBalanced) {
			return right;
		}
		
		if (Math.abs(left.height - right.height) < 2) {
			return new BalanceStatusWithHeight(Math.max(left.height, right.height) + 1, true);
		} else {
			return new BalanceStatusWithHeight(Math.max(left.height, right.height) + 1, false);
		}
	}
	
}

class BalanceStatusWithHeight {
	public int height;
	public boolean isBalanced;
	
	public BalanceStatusWithHeight(int height, boolean isBalanced) {
		this.height = height;
		this.isBalanced = isBalanced;
	}
}