package com.njupt.sort;

/**
 * Created by zhangqiao on 2019/4/10.
 */
public class tips {

    /**
     * @author zhangqiao
     * 题目：把一个0 1 串（只包含0 1的串）进行排序，你可以交换任意两个位置，问最小交换的次数？
     * 思路： 快排 两个标杆  i代表从左往右   j代表 从右往左  ，i碰到0 和 j碰到1进行交换， 由于是0 -- length 所以是线性的。
     */
    public static void zero_1Demo(String str){
        char[] a = str.toCharArray();
        int len = a.length;
        int times= 0;
        for(int i = 0,j = len - 1;i < j;++i,--j){
            for(;i<j&&a[i]=='0';){
                ++i;
            }
            for(;i<j&&a[j]=='1';){
                --j;
            }
            if(i < j){
               ++times;
            }
        }
        System.out.println("最终交换的次数为："+times);
    }


    public static void main(String[] args){
        String str =  "1010000000011111111";
        zero_1Demo(str);
    }
}
