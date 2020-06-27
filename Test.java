import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Scanner;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test {
    public static void main1(String[] args) {

        // 实现一个函数，检查二叉树是否平衡.
        // 平衡的定义如下: 对于树中的任意一个结点，其两颗子树的高度差不超过 1。
        // 给定指向树根结点的指针 TreeNode* root，请返回一个 bool，代表这棵树是否平衡.
    }

    public boolean isBalance(TreeNode root) {
        // 使用递归
        if (root == null) {
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (Math.abs(leftDepth - rightDepth) <= 1) {
            // Math.abs: 绝对值
            return true;
        }else {
            return false;
        }
    }
    public int getDepth(TreeNode root) {
        // 测量深度
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main2(String[] args) {

        //给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
        // A1 = 能被 5 整除的数字中所有偶数的和；
        // A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算 n1 - n2 + n3 - n4 ...；
        // A3 = 被 5 除后余 2 的数字的个数；
        // A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
        // A5 = 被 5 除后余 4 的数字中最大数字。

        // 输入描述:
        // 每个输入包含 1 个测试用例。
        // 每个测试用例先给出一个不超过 1000 的正整数 N，随后给出 N 个不超过 1000 的待分类的正整数。
        // 数字间以空格分隔。
        // 输出描述:
        // 对给定的 N 个正整数，按题目要求计算 A1 ~ A5 并在一行中顺序输出。
        // 数字间以空格分隔，但行末不得有多余空格。
        // 若其中某一类数字不存在，则在相应位置输出 “N”。

        // 示例:
        // 输入
        // 13 1 2 3 4 5 6 7 8 9 10 20 16 18
        // 输出
        // 30 11 2 9.7 9

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 正整数个数
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        num1(n, num);
        num2(n, num);
        num3(n, num);
        num4(n, num);
        num5(n, num);
    }
    public static void num1(int n, int[] num) {
        // A1
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] % 10 == 0) {
                sum += num[i];
                count++;
            }
        }
        if (count == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(sum + " ");
        }
    }
    public static void num2(int n, int[] num) {
        // A2
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] % 5 == 1) {
                sum += num[i] * (Math.pow(-1, count));
                // Math.pow(-1, count): -1 是底数, count 是次方根
                // 答案为 (-1) ^ count;
                count++;
            }
        }
        if (count == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(sum + " ");
        }
    }
    public static void num3(int n, int[] num) {
        // A3
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] % 5 == 2) {
                count++;
            }
        }
        if (count == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(count + " ");
        }
    }
    public static void num4(int n, int[] num) {
        // A4
        DecimalFormat df = new DecimalFormat("#.0");
        // 精确到小数点后 1 位.
        double sum = 0.0;
        double count = 0.0;
        for (int i = 0; i < n; i++) {
            if (num[i] % 5 == 3) {
                sum += num[i];
                count++;
            }
        }
        if (count == 0) {
            System.out.print("N" + " ");
        }else {
            System.out.print(df.format(sum / count) + " ");
            // format: 格式化一个字符串
        }
    }
    public static void num5(int n, int[] num) {
        // A5
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (num[i] % 5 == 4) {
                if (max < num[i]) {
                    max = num[i];
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.print("N");
        }else {
            System.out.print(max);
        }
    }
}
