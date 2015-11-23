import java.util.*;

public class LCA {

  public static class Node {
    public int value;
    public Node left;
    public Node right;
    public Node(int v, Node l, Node r) {
      this.value = v;
      this.left = l;
      this.right = r;
    }
  }

  public static Node LCA(Node n, int x, int y) {
     if (n == null) return null;
     System.out.println(" .LCA(" + n.value + "," + x + "," + y + ")");
     if (n.value == x || n.value == y) { return n; }
     Node n1 = LCA(n.left, x, y);
     Node n2 = LCA(n.right, x, y);
     if (n1!=null && n2==null) return n1;
     if (n1==null && n2!=null) return n2;
     if (n1!=null && n2!=null) return n;
     return null;
  }

  public static void main(String[] args) {
    Node root = new Node (3, new Node(5, new Node(1, null, null),
                                         new Node(2, null, null)),
                             new Node(7, new Node(4, null, null),
                                         new Node(6, null, null)));
    int x = 1;
    int y = 6;
    Node lca = LCA(root, x, y);
    System.out.println("LCA(" + x + "," + y + ")=" + lca.value);
  }
}
