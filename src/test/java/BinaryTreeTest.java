import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    static Node node0;
    static Node node1;
    static Node node2;
    static Node node3;
    static Node node4;
    static Node node5;
    static Node node6;
    static Node node7;
    static Node node8;
    static Node node9;
    static Node node10;
    static BinaryTree binaryTree = new BinaryTree();

    @BeforeAll
    static void 이중트리_세팅() {
        node10 = new Node(10);
        node9 = new Node(9);
        node8 = new Node(8);
        node7 = new Node(7);
        node6 = new Node(6);
        node5 = new Node(5);
        node4 = new Node(4, node9, node10);
        node3 = new Node(3, node7, node8);
        node2 = new Node(2, node5, node6);
        node1 = new Node(1, node3, node4);
        node0 = new Node(0, node1, node2);
        binaryTree.setRoot(node0);
    }

    @Test
    public void bfs_테스트() {
        List<Integer> bfsResult = binaryTree.bfs(node0);
        assertEquals(bfsResult, Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
    }

    @Test
    public void 전위순회_dfs_테스트() {
        List<Integer> bfsResult = new ArrayList<>();
        binaryTree.preorderDFS(node0, bfsResult);
        assertEquals(bfsResult, Arrays.asList(0,1,3,7,8,4,9,10,2,5,6));
    }

    @Test
    public void 중위순회_dfs_테스트() {
        List<Integer> bfsResult = new ArrayList<>();
        binaryTree.inorderDFS(node0, bfsResult);
        assertEquals(bfsResult, Arrays.asList(7,3,8,1,9,4,10,0,5,2,6));
    }

    @Test
    public void 후위순회_dfs_테스트() {
        List<Integer> bfsResult = new ArrayList<>();
        binaryTree.postorderDFS(node0, bfsResult);
        assertEquals(bfsResult, Arrays.asList(7,8,3,9,10,4,1,5,6,2,0));
    }
}
