import java.util.*;
import java.util.LinkedList;

public class BinaryTree {
    Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public List<Integer> bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(node);

        while (queue.size() != 0) {
            Node pollNode = queue.poll();
            result.add(pollNode.getValue());
            if (pollNode.getLeft() != null) {
                queue.add(pollNode.getLeft());
            }
            if (pollNode.getRight() != null) {
                queue.add(pollNode.getRight());
            }
        }
        return result;
    }

    public void preorderDFS(Node node, List<Integer> list) {
        list.add(node.getValue());
        if (node.getLeft() != null) {
            preorderDFS(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            preorderDFS(node.getRight(), list);
        }
    }

    public void inorderDFS(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            inorderDFS(node.getLeft(), list);
        }
        list.add(node.getValue());
        if (node.getRight() != null) {
            inorderDFS(node.getRight(), list);
        }
    }

    public void postorderDFS(Node node, List<Integer> list) {
        if (node.getLeft() != null) {
            postorderDFS(node.getLeft(), list);
        }
        if (node.getRight() != null) {
            postorderDFS(node.getRight(), list);
        }
        list.add(node.getValue());
    }
}
