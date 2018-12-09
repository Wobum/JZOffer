package Chapter02;

public class Algorithm07 {
/**
 * @Auther: Wobum
 * @Date: 2018/12/3 19:30
 * @Description: 根据二叉树的前序遍历和中序遍历重建该二叉树,遍历中不含重复数字
 */

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    // 根据前序遍历和中序遍历重构一棵树
    public static Node reconstructTree(int[] preorder, int[] inorder){
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }

        int headValue = preorder[0];
        int leftNum = 0; // 左子树节点的个数
        int len = preorder.length;
        Node head = new Node(headValue); // 构建根节点

        // 通过中序遍历确定左子树节点的个数
        for(int i = 0; i < len; i++){
            if(inorder[i] == headValue)
                break;
            else
                leftNum += 1;
        }

        int rightNum = len - 1 - leftNum; // 右子树节点的个数

        if (leftNum > 0){ // Base case
            int[] leftPreorder = new int[leftNum]; // 左子树的前序遍历序列
            int[] leftInorder = new int[leftNum];  // 左子树的中序遍历序列

            for (int i = 0; i < leftNum; i++){
                leftPreorder[i] = preorder[1 + i];
                leftInorder[i] = inorder[i];
            }

            head.left = reconstructTree(leftPreorder, leftInorder);
        }

        if (rightNum > 0){ // Base case
            int[] rightPreorder = new int[rightNum];
            int[] rightInorder = new int[rightNum];

            for (int i = 0; i < rightNum; i++){
                rightPreorder[i] = preorder[1 + leftNum + i]; // 右子树的前序遍历序列
                rightInorder[i] = inorder[1 + leftNum + i]; // 右子树的中序遍历序列
            }

            head.right = reconstructTree(rightPreorder, rightInorder);
        }

        return head;
    }

    // 后序遍历打印
    public static void posOrderPrint(Node head){
        if (head == null)
            return;
        posOrderPrint(head.left);
        posOrderPrint(head.right);
        System.out.print(head.value + " ");
    }

    // for test
    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};

        Node head =  reconstructTree(preorder,inorder);

        posOrderPrint(head);

    }
}
