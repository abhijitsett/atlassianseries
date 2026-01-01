package dsa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;
    Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(7);
        root.left.right = new Node(14);

        root.right.right = new Node(2);

        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);

        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);

        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        // Perform level order traversal and get the result
        ArrayList<ArrayList<Integer>> res = levelOrder(root);

        for (ArrayList<Integer> level : res) {
            for (int val : level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        if(root == null)
            return new ArrayList<>();

        Queue<Node> qu = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        qu.add(root);

        while(!qu.isEmpty()) {
            int sz = qu.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i=0;i<sz;i++) {
                Node n = qu.poll();
                level.add(n.data);

                if (n.left != null) qu.offer(n.left);
                if (n.right != null) qu.offer(n.right);
            }
            res.add(level);
        }
        return res;
    }
}
