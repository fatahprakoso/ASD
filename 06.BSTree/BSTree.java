// public class BSTree {
//   public static void main(String[] args) {
//     BSTree tree = new BSTree();
//     tree.insert(94);
//     tree.insert(58);
//     tree.insert(39);
//     tree.insert(86);
//     tree.insert(22);
//     tree.insert(44);
//     tree.insert(66);
//     tree.insert(65);
//     tree.insert(71);
//     tree.insert(97);
//     tree.insert(95);
//     tree.insert(99);
//     tree.insert(94);
//     tree.traversal();
//     System.out.println(tree.isExist(99));
//     System.out.println(tree.isExist(39));
//     System.out.println(tree.isExist(9));

//   }

//   class Node {
//     int data;
//     Node left, right;

//     Node(int data) {
//       this.data = data;
//     }
//   }

//   private Node root;

//   public boolean insert(int value) {
//     Node insertedNode = new Node(value);
//     return insert(insertedNode, root);
//   }

//   private boolean insert(Node input, Node parent) {
//     if (root == null) {
//       root = input;
//       return true;
//     } else if (input.data < parent.data) {
//       if (parent.left == null) {
//         parent.left = input;
//         return true;
//       } else {
//         return insert(input, parent.left);
//       }
//     } else if (input.data > parent.data) {
//       if (parent.right == null) {
//         parent.right = input;
//         return true;
//       } else {
//         return insert(input, parent.right);
//       }
//     }
//     return false;
//   }

//   public boolean isExist(int search) {
//     return isExist(search, root);
//   }

//   private boolean isExist(int search, Node parent) {
//     if (search == parent.data) {
//       return true;
//     } else if (search < parent.data) {
//       if (parent.left == null)
//         return false;
//       return isExist(search, parent.left);
//     } else if (search > parent.data) {
//       if (parent.right == null)
//         return false;
//       return isExist(search, parent.right);
//     }
//     return false;
//   }

//   public void inorder() {
//     inorder(root);
//   }

//   private void inorder(Node parent) {
//     if (parent == null)
//       return;
//     inorder(parent.left);
//     System.out.print(parent.data + ","); // output valuenya diantara fungsi rekursif
//     inorder(parent.right);
//   }

//   public void preorder() {
//     preorder(root);
//   }

//   private void preorder(Node parent) {
//     if (parent == null)
//       return;
//     System.out.print(parent.data + ","); // output valuenya sebelum fungsi rekursif
//     preorder(parent.left);
//     preorder(parent.right);
//   }

//   public void postorder() {
//     postorder(root);
//   }

//   private void postorder(Node parent) {
//     if (parent == null)
//       return;
//     postorder(parent.left);
//     postorder(parent.right);
//     System.out.print(parent.data + ","); // output valuenya sesudah fungsi rekursif
//   }

//   public void traversal() {
//     System.out.print("inorder  : ");
//     inorder();
//     System.out.print("\npreorder : ");
//     preorder();
//     System.out.print("\npostorder: ");
//     postorder();
//     System.out.println();
//   }
// }

// // 94,58,39,22,44,86,66,65,71,97,95,99

class BSTree {
  class Node {
    int data;
    Node kiri, kanan;

    Node(int data) {
      this.data = data;
    }
  }

  private Node root;

  public boolean insert(int data) {
    return insert(new Node(data), root);
  }

  private boolean insert(Node nodeBaru, Node parent) {
    if (root == null) {
      root = nodeBaru;
      return true;
    } else if (nodeBaru.data < parent.data) {
      if (parent.kiri == null) {
        parent.kiri = nodeBaru;
        return true;
      } else
        return insert(nodeBaru, parent.kiri);
    } else if (nodeBaru.data > parent.data) {
      if (parent.kanan == null) {
        parent.kanan = nodeBaru;
        return true;
      } else
        return insert(nodeBaru, parent.kanan);
    }

    return false;
  }

  public void inorder() {
    inorder(root);
  }

  // print anak kiri - parent - anak kanan
  private void inorder(Node parent) {
    if (parent == null)
      return;
    inorder(parent.kiri);
    System.out.print(parent.data + ",");
    inorder(parent.kanan);
  }

  public void preorder() {
    preorder(root);
  }

  // print parent - anak kiri - anak kanan
  private void preorder(Node parent) {
    if (parent == null)
      return;
    System.out.print(parent.data + ",");
    preorder(parent.kiri);
    preorder(parent.kanan);
  }

  public void postorder() {
    postorder(root);
  }

  // print anak kiri - anak kanan - parent
  private void postorder(Node parent) {
    if (parent == null)
      return;
    postorder(parent.kiri);
    postorder(parent.kanan);
    System.out.print(parent.data + ",");
  }

  // 50,30,10,40,70,55,99

  public static void main(String[] args) {
    BSTree tree = new BSTree();
    tree.insert(50);
    tree.insert(30);
    tree.insert(70);
    tree.insert(10);
    tree.insert(40);
    tree.insert(99);
    tree.insert(55);
    // tree.inorder();
    // tree.preorder();
    // tree.postorder();
  }
}
