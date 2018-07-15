public class Test06 {  
2.     /**
3.      * �������ڵ���
4.      */  
5.     public static class BinaryTreeNode {  
6.         int value;  
7.         BinaryTreeNode left;  
8.         BinaryTreeNode right;  
9.     }  
10.   
11.     /**
12.      * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
13.      *
14.      * @param preorder ǰ�����
15.      * @param inorder  �������
16.      * @return ���ĸ����
17.      */  
18.     public static BinaryTreeNode construct(int[] preorder, int[] inorder) {  
19.         // ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ  
20.         if (preorder == null || inorder == null || preorder.length != inorder.length || inorder.length < 1) {  
21.             return null;  
22.         }  
23.   
24.         return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);  
25.     }  
26.   
27.     /**
28.      * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
29.      *
30.      * @param preorder ǰ�����
31.      * @param ps       ǰ������Ŀ�ʼλ��
32.      * @param pe       ǰ������Ľ���λ��
33.      * @param inorder  �������
34.      * @param is       ��������Ŀ�ʼλ��
35.      * @param ie       ��������Ľ���λ��
36.      * @return ���ĸ����
37.      */  
38.     public static BinaryTreeNode construct(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {  
39.   
40.         // ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����  
41.         if (ps > pe) {  
42.             return null;  
43.         }  
44.         // ȡǰ������ĵ�һ�����֣����ǵ�ǰ�ĸ����  
45.         int value = preorder[ps];  
46.         int index = is;  
47.         // ������������������Ҹ�����λ��  
48.         while (index <= ie && inorder[index] != value) {  
49.             index++;  
50.         }  
51.   
52.         // ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣  
53.         if (index > ie) {  
54.             throw new RuntimeException("Invalid input");  
55.         }  
56.   
57.         // ������ǰ�ĸ���㣬����Ϊ��㸳ֵ  
58.         BinaryTreeNode node = new BinaryTreeNode();  
59.         node.value = value;  
60.   
61.         // �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-is+1��  
62.         // ��������Ӧ��ǰ�������λ����[ps+1, ps+index-is]  
63.         // ��������Ӧ�����������λ����[is, index-1]  
64.         node.left = construct(preorder, ps + 1, ps + index - is, inorder, is, index - 1);  
65.         // �ݹ鹹����ǰ����������������������Ԫ�ظ�����ie-index��  
66.         // ��������Ӧ��ǰ�������λ����[ps+index-is+1, pe]  
67.         // ��������Ӧ�����������λ����[index+1, ie]  
68.         node.right = construct(preorder, ps + index - is + 1, pe, inorder, index + 1, ie);  
69.   
70.         // ���ش����ĸ����  
71.         return node;  
72.     }  
73.   
74.     // �������������  
75.     public static void printTree(BinaryTreeNode root) {  
76.         if (root != null) {  
77.             printTree(root.left);  
78.             System.out.print(root.value + " ");  
79.             printTree(root.right);  
80.         }  
81.   
82.     }  
83.   
84.     // ��ͨ������  
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
99.     // ���н�㶼û�����ӽ��  
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
116.     // ���н�㶼û�����ӽ��  
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
133.     // ����ֻ��һ�����  
134.     private static void test4() {  
135.         int[] preorder = {1};  
136.         int[] inorder = {1};  
137.         BinaryTreeNode root = construct(preorder, inorder);  
138.         printTree(root);  
139.     }  
140.   
141.     // ��ȫ������  
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
154.     // �����ָ��  
155.     private static void test6() {  
156.         construct(null, null);  
157.     }  
158.   
159.     // ������������в�ƥ��  
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