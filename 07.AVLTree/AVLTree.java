public class AVLTree {
  private class Node {
    int data;

    /**
     * tinggi dihitung dari bawah
     *
     * A (root) --> tingginya 3
     * B C (anak root) --> tingginya 2
     * D E F G (cucu root) --> tingginya 1
     *
     * Secara default tingginya 1
     */
    int height;

    // left child right child
    Node left, right;

    Node(int data) {
      this.data = data;
      this.height = 1;
    }
  }

  Node root;

  // method insert yang digunakan user
  public void insert(int data) {
    Node newNode = new Node(data);
    root = insert(root, newNode);
  }

  // method insert untuk keperluan rekursif
  private Node insert(Node parent, Node insertedNode) {

    if (parent == null) {
      return insertedNode;
    }

    if (insertedNode.data < parent.data) {
      parent.left = insert(parent.left, insertedNode);
    } else if (insertedNode.data > parent.data) {
      parent.right = insert(parent.right, insertedNode);
    } else {
      return parent;
    }

    // update parent height
    parent.height = updateHeight(parent);

    Node result = balance(parent, insertedNode.data);

    return result;
  }

  // ambil tinggi dari suatu node
  private int getHeight(Node N) {
    if (N == null)
      return 0;

    return N.height;
  }

  // ambil nilai balance (jika balance < -1 atau balance > 1, lakukan rotate)
  private int getBalance(Node N) {
    if (N == null)
      return 0;

    // jika negatif, maka lebih tinggi subtree kanan
    return getHeight(N.left) - getHeight(N.right);
  }

  private int updateHeight(Node n) {
    return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
  }

  /**
   * lakukan balancing agar selisih tinggi subtree kiri dan subtree kanan tidak
   * lebih dari 1
   */
  private Node balance(Node parent, int key) {
    int balance = getBalance(parent);

    if (balance > 1 && key < parent.left.data) {
      parent = rightRotate(parent);
    } else if (balance < -1 && key > parent.right.data) {
      parent = leftRotate(parent);
    } else if (balance > 1 && key > parent.left.data) {
      parent.left = leftRotate(parent.left);
      parent = rightRotate(parent);
    } else if (balance < -1 && key < parent.right.data) {
      parent.right = rightRotate(parent.right);
      parent = leftRotate(parent);
    }

    return parent;
  }

  private Node leftRotate(Node oldParent) {
    Node parent = oldParent.right;
    Node movedSubtree = oldParent.right.left;

    parent.left = oldParent;
    oldParent.right = movedSubtree;

    oldParent.height = updateHeight(oldParent);
    parent.height = updateHeight(parent);

    return parent;
  }

  private Node rightRotate(Node oldParent) {
    Node parent = oldParent.left;
    Node movedSubtree = oldParent.left.right;

    parent.right = oldParent;
    oldParent.left = movedSubtree;

    oldParent.height = updateHeight(oldParent);
    parent.height = updateHeight(parent);
    System.out.println(oldParent.data);
    return parent;
  }

  public void preorder() {
    preorder(root);
  }

  // print parent - anak kiri - anak kanan
  private void preorder(Node parent) {
    if (parent == null) {
      return;
    }
    System.out.print(parent.data + ",");
    preorder(parent.left);
    preorder(parent.right);
  }

  public void inorder() {
    inorder(root);
  }

  // print anak kiri - parent - anak kanan
  private void inorder(Node parent) {
    if (parent == null)
      return;
    inorder(parent.left);
    System.out.print(parent.data + ",");
    inorder(parent.right);
  }

  public void postorder() {
    postorder(root);
  }

  // print anak kiri - anak kanan - parent
  private void postorder(Node parent) {
    if (parent == null)
      return;
    postorder(parent.left);
    postorder(parent.right);
    System.out.print(parent.data + ",");
  }

  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
    tree.insert(9);
    tree.insert(8);
    tree.insert(7);
    tree.insert(6);
    tree.insert(5);
    tree.insert(4);
    tree.insert(3);
    tree.insert(2);
    tree.insert(1);

    tree.preorder();
    System.out.println();
    tree.inorder();
    System.out.println();
    tree.postorder();

    // 6,4,2,1,3,5,8,7,9
  }
}

/**
 * AVL Tree
 * 1. setiap node parent memiliki 2 child dimana child kiri lebih kecil dari
 * parent dan child kanan lebih besar dari parent atau dengan kata lain
 * merupakan turunan dari binary search tree
 * 2. setiap parent harus dilakukan check balance yaitu selisih tinggi subtree
 * kanan dan subtree kiri, jika selisih tersebut lebih dari 1, maka lakukan
 * balance(rotasi)
 */
