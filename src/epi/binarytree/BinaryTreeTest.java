package epi.binarytree;

public class BinaryTreeTest {
 public static BinaryTreeNode<String> mNode;
 public static BinaryTreeNode<String> nNode;
 public static void main(String[] args) {
  
  BinaryTreeNode<String> root = getSampleBinaryTree();
  // pre-order
  preOrderTraversal(root);
  System.out.println("\n");
  // inorder
  inOrderTraversal(root);
  System.out.println("\n");
  // postorder
  postOrderTraversal(root);
 }
 
 public static BinaryTreeNode<String> getSampleBinaryTree() {
  // create a tree
  // nodes
  BinaryTreeNode<String> a = new BinaryTreeNode<>();
  a.data = "A";
  BinaryTreeNode<String> b = new BinaryTreeNode<>();
  b.data = "B";
  BinaryTreeNode<String> c = new BinaryTreeNode<>();
  c.data = "C";
  BinaryTreeNode<String> d = new BinaryTreeNode<>();
  d.data = "D";
  BinaryTreeNode<String> e = new BinaryTreeNode<>();
  e.data = "E";
  BinaryTreeNode<String> f = new BinaryTreeNode<>();
  f.data = "F";
  BinaryTreeNode<String> g = new BinaryTreeNode<>();
  g.data = "G";
  BinaryTreeNode<String> h = new BinaryTreeNode<>();
  h.data = "H";
  BinaryTreeNode<String> i = new BinaryTreeNode<>();
  i.data = "I";
  BinaryTreeNode<String> j = new BinaryTreeNode<>();
  j.data = "J";
  BinaryTreeNode<String> k = new BinaryTreeNode<>();
  k.data = "K";
  BinaryTreeNode<String> l = new BinaryTreeNode<>();
  l.data = "L";
  BinaryTreeNode<String> m = new BinaryTreeNode<>();
  m.data = "M";
  mNode = m;
  BinaryTreeNode<String> n = new BinaryTreeNode<>();
  n.data = "N";
  nNode = n;
  BinaryTreeNode<String> o = new BinaryTreeNode<>();
  o.data = "O";
  BinaryTreeNode<String> p = new BinaryTreeNode<>();
  p.data = "P";
  // additional node
  BinaryTreeNode<String> q = new BinaryTreeNode<>();
  //q.data = "Q";
  
  // create associations
  a.left = b;
  a.right = i;
  b.left = c;
  b.right = f;
  i.left = j;
  i.right = o;
  c.left = d;
  c.right = e;
  f.right = g;
  j.right = k;
  o.right = p;
  g.left = h;
  k.left = l;
  k.right = n;
  l.right = m;
  
  // return root node
  return a;
 }
 
 public static BinaryTreeNode<String> getSampleHeightBalancedTree() {
  // create a tree
  // nodes
  BinaryTreeNode<String> a = new BinaryTreeNode<>();
  a.data = "A";
  BinaryTreeNode<String> b = new BinaryTreeNode<>();
  b.data = "B";
  BinaryTreeNode<String> c = new BinaryTreeNode<>();
  c.data = "C";
  BinaryTreeNode<String> d = new BinaryTreeNode<>();
  d.data = "D";
  BinaryTreeNode<String> e = new BinaryTreeNode<>();
  e.data = "E";
  BinaryTreeNode<String> f = new BinaryTreeNode<>();
  f.data = "F";
  BinaryTreeNode<String> g = new BinaryTreeNode<>();
  g.data = "G";
  BinaryTreeNode<String> h = new BinaryTreeNode<>();
  h.data = "H";
  BinaryTreeNode<String> i = new BinaryTreeNode<>();
  i.data = "I";
  BinaryTreeNode<String> j = new BinaryTreeNode<>();
  j.data = "J";
  BinaryTreeNode<String> k = new BinaryTreeNode<>();
  k.data = "K";
  BinaryTreeNode<String> l = new BinaryTreeNode<>();
  l.data = "L";
  BinaryTreeNode<String> m = new BinaryTreeNode<>();
  m.data = "M";
  BinaryTreeNode<String> n = new BinaryTreeNode<>();
  n.data = "N";
  BinaryTreeNode<String> o = new BinaryTreeNode<>();
  o.data = "O";
  // additional node
  BinaryTreeNode<String> q = new BinaryTreeNode<>();
  q.data = "Q";
  
  // create associations
  a.left = b;
  a.right = k;
  b.left = c;
  b.right = h;
  k.left = l;
  k.right = o;
  c.left = d;
  c.right = g;
  h.left = i;
  h.right = j;
  l.left = m;
  l.right = n;
  d.left = e;
  d.right = f;
//  e.left = q;
  // return root
  return a;
 }
 
 public static BinaryTreeNode<Integer> getSampleSymmetricBinaryTree() {
   BinaryTreeNode<Integer> a = new BinaryTreeNode<Integer>();
   a.data = 314;
   BinaryTreeNode<Integer> b = new BinaryTreeNode<Integer>();
   b.data = 6;
   BinaryTreeNode<Integer> c = new BinaryTreeNode<Integer>();
   c.data = 2;
   BinaryTreeNode<Integer> d = new BinaryTreeNode<Integer>();
   d.data = 3;
   BinaryTreeNode<Integer> e = new BinaryTreeNode<Integer>();
   e.data = 6;
   BinaryTreeNode<Integer> f = new BinaryTreeNode<Integer>();
   f.data = 2;
   BinaryTreeNode<Integer> g = new BinaryTreeNode<Integer>();
   g.data = 3;
   
   a.left = b;
   a.right = e;
   b.right = c;
   c.right = d;
   e.left = f;
   f.left = g;
   
   return a;
 }
 
 public static BinaryTreeNode<Integer> getSampleNonSymmetricBinaryTree() {
   BinaryTreeNode<Integer> a = new BinaryTreeNode<Integer>();
   a.data = 314;
   BinaryTreeNode<Integer> b = new BinaryTreeNode<Integer>();
   b.data = 6;
   BinaryTreeNode<Integer> c = new BinaryTreeNode<Integer>();
   c.data = 2;
   BinaryTreeNode<Integer> d = new BinaryTreeNode<Integer>();
   d.data = 3;
   BinaryTreeNode<Integer> e = new BinaryTreeNode<Integer>();
   e.data = 6;
   BinaryTreeNode<Integer> f = new BinaryTreeNode<Integer>();
   f.data = 2;
   BinaryTreeNode<Integer> g = new BinaryTreeNode<Integer>();
   g.data = 1;
   
   a.left = b;
   a.right = e;
   b.right = c;
   c.right = d;
   e.left = f;
   f.left = g;
   
   return a;
 }
 
 public static BinaryTreeNode<Integer> getSampleBinaryDigitTree() {
   BinaryTreeNode<Integer> a = new BinaryTreeNode<Integer>();
   a.data = 1;
   BinaryTreeNode<Integer> b = new BinaryTreeNode<Integer>();
   b.data = 0;
   BinaryTreeNode<Integer> c = new BinaryTreeNode<Integer>();
   c.data = 0;
   BinaryTreeNode<Integer> d = new BinaryTreeNode<Integer>();
   d.data = 0;
   BinaryTreeNode<Integer> e = new BinaryTreeNode<Integer>();
   e.data = 1;
   BinaryTreeNode<Integer> f = new BinaryTreeNode<Integer>();
   f.data = 1;
   BinaryTreeNode<Integer> g = new BinaryTreeNode<Integer>();
   g.data = 1;
   BinaryTreeNode<Integer> h = new BinaryTreeNode<Integer>();
   h.data = 0;
   BinaryTreeNode<Integer> i = new BinaryTreeNode<Integer>();
   i.data = 1;
   BinaryTreeNode<Integer> j = new BinaryTreeNode<Integer>();
   j.data = 0;
   BinaryTreeNode<Integer> k = new BinaryTreeNode<Integer>();
   k.data = 0;
   BinaryTreeNode<Integer> l = new BinaryTreeNode<Integer>();
   l.data = 1;
   BinaryTreeNode<Integer> m = new BinaryTreeNode<Integer>();
   m.data = 1;
   BinaryTreeNode<Integer> n = new BinaryTreeNode<Integer>();
   n.data = 0;
   BinaryTreeNode<Integer> o = new BinaryTreeNode<Integer>();
   o.data = 0;
   BinaryTreeNode<Integer> p = new BinaryTreeNode<Integer>();
   p.data = 0;
   
   a.left = b;
   a.right = i;
   b.left = c;
   b.right = f;
   i.left = j;
   i.right = o;
   c.left = d;
   c.right = e;
   f.right = g;
   j.right = k;
   o.right = p;
   g.left = h;
   k.left = l;
   k.right = n;
   l.right = m;
   
   return a;
 }
 
 public static BinaryTreeNode<Integer> getSampleIntegerBinaryTree() {
   BinaryTreeNode<Integer> a = new BinaryTreeNode<Integer>();
   a.data = 314;
   BinaryTreeNode<Integer> b = new BinaryTreeNode<Integer>();
   b.data = 6;
   BinaryTreeNode<Integer> c = new BinaryTreeNode<Integer>();
   c.data = 271;
   BinaryTreeNode<Integer> d = new BinaryTreeNode<Integer>();
   d.data = 28;
   BinaryTreeNode<Integer> e = new BinaryTreeNode<Integer>();
   e.data = 0;
   BinaryTreeNode<Integer> f = new BinaryTreeNode<Integer>();
   f.data = 561;
   BinaryTreeNode<Integer> g = new BinaryTreeNode<Integer>();
   g.data = 3;
   BinaryTreeNode<Integer> h = new BinaryTreeNode<Integer>();
   h.data = 17;
   BinaryTreeNode<Integer> i = new BinaryTreeNode<Integer>();
   i.data = 6;
   BinaryTreeNode<Integer> j = new BinaryTreeNode<Integer>();
   j.data = 2;
   BinaryTreeNode<Integer> k = new BinaryTreeNode<Integer>();
   k.data = 1;
   BinaryTreeNode<Integer> l = new BinaryTreeNode<Integer>();
   l.data = 401;
   BinaryTreeNode<Integer> m = new BinaryTreeNode<Integer>();
   m.data = 641;
   BinaryTreeNode<Integer> n = new BinaryTreeNode<Integer>();
   n.data = 257;
   BinaryTreeNode<Integer> o = new BinaryTreeNode<Integer>();
   o.data = 271;
   BinaryTreeNode<Integer> p = new BinaryTreeNode<Integer>();
   p.data = 28;
   
   a.left = b;
   a.right = i;
   b.left = c;
   b.right = f;
   i.left = j;
   i.right = o;
   c.left = d;
   c.right = e;
   f.right = g;
   j.right = k;
   o.right = p;
   g.left = h;
   k.left = l;
   k.right = n;
   l.right = m;
   
   return a;
 }
 
 public static void preOrderTraversal(BinaryTreeNode<String> root) {
  if (root == null) {
   return;
  }
  System.out.print(root.data + ", ");
  preOrderTraversal(root.left);
  preOrderTraversal(root.right);
 }
 public static void inOrderTraversal(BinaryTreeNode<String> root) {
  if (root == null) {
   return;
  } 
  inOrderTraversal(root.left);
  System.out.print(root.data + ", ");
  inOrderTraversal(root.right);
 }
 public static void postOrderTraversal(BinaryTreeNode<String> root) {
  if (root == null) {
   return;
  } 
  postOrderTraversal(root.left);
  postOrderTraversal(root.right);
  System.out.print(root.data + ", ");
 }
}
