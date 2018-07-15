public class Test06 {  
2.     /**
3.      * 二叉树节点类
4.      */  
5.     public static class BinaryTreeNode {  
6.         int value;  
7.         BinaryTreeNode left;  
8.         BinaryTreeNode right;  
9.     }  
10.   
11.     /**
12.      * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
13.      *
14.      * @param preorder 前序遍历
15.      * @param inorder  中序遍历
16.      * @return 树的根结点
17.      */  
18.     public static BinaryTreeNode construct(int[] preorder, int[] inorder) {  
19.         // 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同  
20.         if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {  
21.             return null;  
22.         }  
23.   
24.         return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);  
25.     }  
26.   
27.     /**
28.      * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
29.      *
30.      * @param preorder 前序遍历
31.      * @param ps       前序遍历的开始位置
32.      * @param pe       前序遍历的结束位置
33.      * @param inorder  中序遍历
34.      * @param is       中序遍历的开始位置
35.      * @param ie       中序遍历的结束位置
36.      * @return 树的根结点
37.      */  
38.     public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {  
39.   
40.         // 开始位置大于结束位置说明已经没有需要处理的元素了  
41.         if (ps > pe) {  
42.             return null;  
43.         }  
44.         // 取前序遍历的第一个数字，就是当前的根结点  
45.         int value = preorder[ps];  
46.         int index = is;  
47.         // 在中序遍历的数组中找根结点的位置  
48.         while (index <= ie && inorder[index] != value) {  
49.             index++;  
50.         }  
51.   
52.         // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常  
53.         if (index > ie) {  
54.             throw new RuntimeException("Invalid input");  
55.         }  
56.   
57.         // 创建当前的根结点，并且为结点赋值  
58.         BinaryTreeNode node = new BinaryTreeNode();  
59.         node.value = value;  
60.   
61.         // 递归构建当前根结点的左子树，左子树的元素个数：index-is+1个  
62.         // 左子树对应的前序遍历的位置在[ps+1, ps+index-is]  
63.         // 左子树对应的中序遍历的位置在[is, index-1]  
64.         node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);  
65.         // 递归构建当前根结点的右子树，右子树的元素个数：ie-index个  
66.         // 右子树对应的前序遍历的位置在[ps+index-is+1, pe]  
67.         // 右子树对应的中序遍历的位置在[index+1, ie]  
68.         node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);  
69.   
70.         // 返回创建的根结点  
71.         return node;  
72.     }  
73.   
74.     // 中序遍历二叉树  
75.     public static void printTree(BinaryTreeNode root) {  
76.         if (root != null) {  
77.             printTree(root.left);  
78.             System.out.print(root.value + " ");  
79.             printTree(root.right);  
80.         }  
81.   
82.     }  
83.   
84.     // 普通二叉树  
85.     //              1  
86.     //           /     \  
87.     //          2       3  
88.     //         /       / \  
89.     //        4       5   6  
90.     //         \         /  
91.     //          7       8  
92.     private static void test1() {  
93.         int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};  
94.         int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};  
95.         BinaryTreeNode root = construct(preorder, inorder);  
96.         printTree(root);  
97.     }  
98.   
99.     // 所有结点都没有右子结点  
100.     //            1  
101.     //           /  
102.     //          2  
103.     //         /  
104.     //        3  
105.     //       /  
106.     //      4  
107.     //     /  
108.     //    5  
109.     private static void test2() {  
110.         int[] preorder = {1, 2, 3, 4, 5};  
111.         int[] inorder = {5, 4, 3, 2, 1};  
112.         BinaryTreeNode root = construct(preorder, inorder);  
113.         printTree(root);  
114.     }  
115.   
116.     // 所有结点都没有左子结点  
117.     //            1  
118.     //             \  
119.     //              2  
120.     //               \  
121.     //                3  
122.     //                 \  
123.     //                  4  
124.     //                   \  
125.     //                    5  
126.     private static void test3() {  
127.         int[] preorder = {1, 2, 3, 4, 5};  
128.         int[] inorder = {1, 2, 3, 4, 5};  
129.         BinaryTreeNode root = construct(preorder, inorder);  
130.         printTree(root);  
131.     }  
132.   
133.     // 树中只有一个结点  
134.     private static void test4() {  
135.         int[] preorder = {1};  
136.         int[] inorder = {1};  
137.         BinaryTreeNode root = construct(preorder, inorder);  
138.         printTree(root);  
139.     }  
140.   
141.     // 完全二叉树  
142.     //              1  
143.     //           /     \  
144.     //          2       3  
145.     //         / \     / \  
146.     //        4   5   6   7  
147.     private static void test5() {  
148.         int[] preorder = {1, 2, 4, 5, 3, 6, 7};  
149.         int[] inorder = {4, 2, 5, 1, 6, 3, 7};  
150.         BinaryTreeNode root = construct(preorder, inorder);  
151.         printTree(root);  
152.     }  
153.   
154.     // 输入空指针  
155.     private static void test6() {  
156.         construct(null, null);  
157.     }  
158.   
159.     // 输入的两个序列不匹配  
160.     private static void test7() {  
161.         int[] preorder = {1, 2, 4, 5, 3, 6, 7};  
162.         int[] inorder = {4, 2, 8, 1, 6, 3, 7};  
163.         BinaryTreeNode root = construct(preorder, inorder);  
164.         printTree(root);  
165.     }  
166.   
167.   
168.     public static void main(String[] args) {  
169.   
170.         test1();  
171.         System.out.println();  
172.         test2();  
173.         System.out.println();  
174.         test3();  
175.         System.out.println();  
176.         test4();  
177.         System.out.println();  
178.         test5();  
179.         System.out.println();  
180.         test6();  
181.         System.out.println();  
182.         test7();  
183.   
184.     }  
185. }  