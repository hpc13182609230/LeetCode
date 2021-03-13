package leetcode.easy;

import org.assertj.core.util.Lists;

import java.util.List;

/* No.7 整数反转
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

 */
public class No7Reverse {

    @org.junit.Test
    public void test() {
        List<Integer> arr = Lists.newArrayList(123, -123, 120, 0, -2147483648, -2147483647, 2147483647);
        //输入：x = 123
        //输出：321
        //输入：x = -123
        //输出：-321
        //输入：x = 120
        //输出：21
        //输入：x = 0
        //输出：0
        for (Integer x : arr) {
            int y = reverse(x);
            System.out.println(y);
        }
    }

    int reverse(int x) {
         /*
         /check something
         */
        if (x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }

        //do main
        int flag = 1;
        if (x < 0) {
            flag *= -1;
            x *= -1;
        }
        int result = 0;
        while (x > 0) {

            int temp = x % 10;
            //判断溢出
            if (result > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE / 10 == result && (flag == 1 ? (temp > 7) : (temp > 8))))
                return 0;

            result = result * 10 + x % 10;
            x = x / 10;
        }
        return flag * result;
    }


    int leetcode(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
