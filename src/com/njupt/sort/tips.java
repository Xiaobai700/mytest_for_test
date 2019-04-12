package com.njupt.sort;

import java.util.ArrayList;

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
/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */


    public static ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> list = new ArrayList<>();

            int rows = matrix.length;
            int column = matrix[0].length;

            if(rows == 0){
                return list;
            }

            //计算有多少层
            int ceng_num =(Math.min(rows,column)-1)/2+1;

            for(int k = 0;k < ceng_num;k++){
                //上方 列数递增
                for (int j = k;j<column-k;j++){
                    list.add(matrix[k][j]);
                }
                //右侧 层数递增
                for(int i = k+1;i<rows-k;i++){
                    list.add(matrix[i][column-1-k]);
                }
                //下方 列数递减
                //rows-1-k != k这个条件是为了处理出现一行多列的矩阵
                for(int j = column-2-k;(j>=k)&&(rows-1-k != k);j-- ){
                    list.add(matrix[rows-1-k][j]);
                }
                //左侧 行数递减
                //column-1-k != k这个条件是为了处理出现一列多行的情况
                for(int i =rows-2-k;(i>k)&&(column-1-k != k);i-- ){
                    list.add(matrix[i][k]);
                }
            }
            return list;

        }

    public static void main(String[] args){
       // String str =  "1010000000011111111";
       // zero_1Demo(str);
        int [][] a = {{1,2,3,4,5}};
        ArrayList<Integer> list = printMatrix(a);
        for (int n:list) {
            System.out.println(n);
        }
    }
}
