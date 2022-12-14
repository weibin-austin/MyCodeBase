package LeetcodeSolutions.dfs;

import LeetcodeSolutions.bfs.node.TreeNode;
import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
          1
           \
            2
           /
          3
 */
public class BinaryTreeInorderTraversal94 {

    @Test
    public void Recursion() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root)); // [1, 3, 2]
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root) {

        if (root.left != null) helper(res, root.left);
        res.add(root.val);
        if (root.right != null) helper(res, root.right);

    }

    @Test
    public void Iterative() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        TreeNode root = node6;

        root.left = node2;
        root.right = node7;

        node2.left = node1;
        node2.right = node4;

        node7.right = node8;

        node4.left = node3;
        node4.right = node5;
        /*         6                      |             |            |             |              |             |             |             |
                  / \                     |             |            |             |              |             |             |             |
                2    7                    |             |            |             |              |             |             |             |
              /  \    \                   |             |            |             |              |             |             |             |
             1   4     8                  |             | -------->  |             |    --------> |             | -------->   |             |
                / \                       |             |            |             |              |             |             |             |
               3   5                      |             |            |             |              |    1        |             |    (1)      |
                                          |             |            |    2        |              |    2        |             |    2        |
                                          |    6        |            |    6        |              |    6        |             |    6        |
                                          --------------             --------------               --------------              --------------
                                          res = []                     res = []                      res = []                    res = [1]

                                          |             |             |             |             |             |             |             |
                                          |             |             |             |             |             |             |             |
                                          |             |             |             |             |             |             |             |
                                          |             |             |             |             |             |             |             |
                              -------->   |             | -------->   |             | -------->   |    3        | -------->   |   (3)       |
                                          |             |             |    4        |             |    4        |             |    4        |
                                          |   (1)       |             |   (1)       |             |   (1)       |             |   (1)       |
                                          |   (2)       |             |   (2)       |             |   (2)       |             |   (2)       |
                                          |    6        |             |    6        |             |    6        |             |    6        |
                                          --------------              --------------              --------------              --------------
                                             res = [1,2]                res = [1,2]                 res = [1,2]                res = [1,2,3]

                                         |             |             |             |                |             |                |             |
                                         |             |             |             |                |             |                |             |
                                         |             |             |             |                |             |                |             |
                                         |             |             |    5        |                |   (5)       |                |   (5)       |
                             -------->   |   (3)       | -------->   |   (3)       |    -------->   |   (3)       |    -------->   |   (3)       |
                                         |   (4)       |             |   (4)       |                |   (4)       |                |   (4)       |
                                         |   (1)       |             |   (1)       |                |   (1)       |                |   (1)       |
                                         |   (2)       |             |   (2)       |                |   (2)       |                |   (2)       |
                                         |    6        |             |    6        |                |    6        |                |   (6)       |
                                         --------------              --------------                 --------------                 --------------
                                         res = [1,2,3,4]             res = [1,2,3,4]               res = [1,2,3,4,5]             res = [1,2,3,4,5,6]

                                        |             |               |             |                     |             |                    |             |
                                        |             |               |             |                     |    8        |                    |   (8)       |
                                        |    7        |               |   (7)       |                     |   (7)       |                    |   (7)       |
                                        |   (5)       |               |   (5)       |                     |   (5)       |                    |   (5)       |
                            -------->   |   (3)       |   -------->   |   (3)       |         -------->   |   (3)       |        -------->   |   (3)       |
                                        |   (4)       |               |   (4)       |                     |   (4)       |                    |   (4)       |
                                        |   (1)       |               |   (1)       |                     |   (1)       |                    |   (1)       |
                                        |   (2)       |               |   (2)       |                     |   (2)       |                    |   (2)       |
                                        |   (6)       |               |   (6)       |                     |   (6)       |                    |   (6)       |
                                        --------------                --------------                      --------------                     --------------
                                      res = [1,2,3,4,5,6]           res = [1,2,3,4,5,6,7]               res = [1,2,3,4,5,6,7]              res = [1,2,3,4,5,6,7,8]
         */
                
        System.out.println(iterative(root)); // [1, 2, 3, 4, 5, 6, 7, 8]
    }

    public List<Integer> iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {

            while(root != null) {
                stack.push(root);
                root = root.left; // ????????????????????????????????????root == null????????????????????????????????????????????????????????????????????????
            }

            root = stack.pop();  // stack?????????????????????????????????
            res.add(root.val);   // ????????????value????????????List???????????? '?????????'?????????????????????
            root = root.right;   // ????????????????????????????????????????????????????????????????????????while????????????????????????????????????????????????????????????????????????push???stack???
                                 // ????????????????????????????????????????????????????????????????????????while???????????????push???stack?????????????????????????????????List???
        }                        //???stack ????????????DFS????????? ??????????????? ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????so on so forth
        return res;
    }
}
