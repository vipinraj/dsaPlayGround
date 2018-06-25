package epi.recursion;

import java.util.List;
import java.util.ArrayList;

class TreeDiameter {
	public static void main(String[] args) {
		
		TreeNode a = new TreeNode();
		TreeNode b = new TreeNode();
		TreeNode c = new TreeNode();
		TreeNode d = new TreeNode();
		TreeNode e = new TreeNode();
		TreeNode f = new TreeNode();
		TreeNode g = new TreeNode();
		TreeNode h = new TreeNode();
		TreeNode i = new TreeNode();
		TreeNode j = new TreeNode();
		TreeNode k = new TreeNode();
		TreeNode l = new TreeNode();
		TreeNode m = new TreeNode();
		TreeNode n = new TreeNode();
		TreeNode o = new TreeNode();
		TreeNode p = new TreeNode();
		TreeNode edges = new TreeNode();

		Edge bc = new Edge(c, 7.0);
		Edge ba = new Edge(a, 14.0);
		Edge cd = new Edge(d, 4.0);
		Edge de = new Edge(e, 6.0);
		Edge cf = new Edge(f, 3.0);
		Edge bg = new Edge(g, 3.0);
		Edge gh = new Edge(h, 2.0);
		Edge gi = new Edge(i, 1.0);
		Edge ij = new Edge(j, 6.0);
		Edge ik = new Edge(k, 4.0);
		Edge kl = new Edge(l, 4.0);
		Edge km = new Edge(m, 2.0);
		Edge mn = new Edge(n, 1.0);
		Edge mo = new Edge(o, 2.0);
		Edge mp = new Edge(p, 3.0);

		b.edges.add(bc);
		b.edges.add(ba);
		b.edges.add(bg);
		c.edges.add(cd);
		c.edges.add(cf);
		d.edges.add(de);
		g.edges.add(gh);
		g.edges.add(gi);
		i.edges.add(ij);
		i.edges.add(ik);
		k.edges.add(kl);
		k.edges.add(km);
		m.edges.add(mn);
		m.edges.add(mo);
		m.edges.add(mp);

		System.out.println(computeDiamter(b));
	}

	public static double computeDiamter(TreeNode T) {
		return T != null ? computeHeightAndDiameter(T).diameter : 0.0;
	}

	public static HeightAndDiameter computeHeightAndDiameter(TreeNode r) {
		double diameter = Double.MIN_VALUE;
		double[] heights = {0.0, 0.0};

		for (Edge e : r.edges ) {
			HeightAndDiameter heightAndDiameter = computeHeightAndDiameter(e.root);

			if (heightAndDiameter.height + e.length > heights[0]) {
				heights[1] = heights[0];
				heights[0] = heightAndDiameter.height + e.length;
			} else if (heightAndDiameter.height + e.length > heights[1]) {
				heights[1] = heightAndDiameter.height + e.length;
			}
			diameter = Math.max(diameter, heightAndDiameter.diameter);
		}

		return new HeightAndDiameter(heights[0], Math.max(diameter, heights[0] + heights[1]));

	}

	public static class Edge {
		public TreeNode root;
		public Double length;

		public Edge(TreeNode root, Double length) {
			this.root = root;
			this.length = length;
		}
	}

	public static class TreeNode {
		List<Edge> edges = new ArrayList<>();
	}

	public static class HeightAndDiameter {
		public Double height;
		public Double diameter;

		public HeightAndDiameter(Double height, Double diameter) {
			this.height = height;
			this.diameter = diameter;
		}
	}
}