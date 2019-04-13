package com.njupt.sort;

import java.util.ArrayList;
import java.util.List;

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

       /**
        * 链表反转
        * */
       //一个结点的数据结构
       public static class ListNode {
           int val;
           ListNode next = null;

           ListNode(int val) {
               this.val = val;
           }
       }
       public static ListNode ReverseList(ListNode head) {
           if(head==null)
               return null;
           //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
           ListNode pre = null;
           ListNode next = null;
           //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
           //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
           //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
           //所以需要用到pre和next两个节点
           //1->2->3->4->5
           //1<-2<-3 4->5
           while(head!=null){
               //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
               //如此就可以做到反转链表的效果
               //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
               next = head.next;
               //保存完next，就可以让head从指向next变成指向pre了，代码如下
               head.next = pre;
               //head指向pre后，就继续依次反转下一个节点
               //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
               pre = head;
               head = next;
           }
           //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
           //直接输出pre就是我们想要得到的反转后的链表
           return pre;
       }

       public static ListNode reverse_test(ListNode head){
           if(head == null){
               return head;
           }

           ListNode pre = null;
           ListNode next = null;
           while (head != null){
               next = head.next;
               head.next = pre;
               pre = head;
               head = next;

           }
           return pre;

       }

       /**输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
        * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
        * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
        * */
       public static void reOrderArray(int [] array) {
           ArrayList<Integer> list_ji = new ArrayList<Integer>();
           ArrayList<Integer> list_ou = new ArrayList<Integer>();
           int len = array.length;
           for(int i = 0;i < len;i++){
               if(array[i]%2 != 0){
                   list_ji.add(array[i]);
               }else{
                   list_ou.add(array[i]);
               }
           }
           //把两个list合并
           for(int i:list_ou){
               list_ji.add(i);
           }
           //把list转为数组
           int[] newArray = new int[len];
           for(int i = 0;i<list_ji.size();i++){
               newArray[i] = list_ji.get(i);
           }
           for(int i = 0;i < len;i++){
               array[i] = newArray[i];
           }
       }

       /**输入两个单调递增的链表，输出两个链表合成后的链表，
        * 当然我们需要合成后的链表满足单调不减规则。
        * */
       /**
        * 主要思想就是类似于两路合排序的merge函数，关键就是这里操作的数据结构是单链表
        * 这里涉及了单链表的构造以及主函数里单链表的输出 不多赘述
        * */
       public static ListNode Merge(ListNode list1,ListNode list2) {
           ListNode list = null;
           ListNode p = null;
           ListNode p1 = list1;
           ListNode p2 = list2;
           //让我想起了两路合并排序的Merge函数
           while(p1 != null && p2 != null){
               if(p1.val < p2.val){
                   if(list == null){
                       list = p1;
                       p = list;
                   }else{
                       p.next = p1;
                       p = p1;
                   }
                   p1 = p1.next;
               }else{
                   if(list == null){
                       list = p2;
                       p = list;
                   }else{
                       p.next = p2;
                       p= p2;
                   }
                   p2 = p2.next;
               }
           }
           //把第一个链表中剩余的加到新的链表中
           while(p1 != null){
               p.next = p1;
               p = p1;
               p1 = p1.next;
           }
           //把第二个链表中剩余的加到新的链表中
           while(p2 != null){
               p.next = p2;
               p = p2;
               p2 = p2.next;
           }

           return list;
       }
       /**在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
        * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
        * */
       public static ListNode deleteDuplication(ListNode pHead)
       {
           //在头结点之前添加一个结点
           ListNode beforeH = new ListNode(-1);
           beforeH.next = pHead;
           ListNode beforeP = beforeH;

           ListNode p = pHead;

           while(p != null && p.next != null){
               if(p.next.val == p.val){
                   int val = p.val;
                   //找到一个相等的时候就继续再找
                   while(p != null && val == p.val ){
                       p = p.next;
                   }
                   //因为是有序的链表，所有重复的结点都是紧挨着的，一起找到之后，
                   //把重复结点的前一个结点的next指向重复结点的后一个结点
                   beforeP.next = p;
               }else{
                   beforeP = p;
                   p = p.next;
               }
           }
           return beforeH.next;
       }

    public static void main(String[] args){
       // String str =  "1010000000011111111";
       // zero_1Demo(str);

       /* ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        System.out.println(reverse_test(l1).val);*/

       /*int a[] = {1,8,7,4,66,5,11};
       reOrderArray(a);
        for (int n:a) {
            System.out.print(n+" ");
        }
        System.out.println("\n");*/

        ListNode l5 = new ListNode(15);
        ListNode l4 = new ListNode(14);
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(4);
        ListNode l1 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;

        //ListNode ll5 = new ListNode(56);
        //ListNode ll4 = new ListNode(49);
        ListNode ll3 = new ListNode(5);
        ListNode ll2 = new ListNode(3);
        ListNode ll1 = new ListNode(1);

        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = null;
       // ll4.next = ll5;
        //ll5.next = null;

        /*ListNode result = Merge(ll1,l1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }*/

        ListNode repeatResult = deleteDuplication(l1);
        while (repeatResult != null){
            System.out.println(repeatResult.val);
            repeatResult = repeatResult.next;
        }
        /*int [][] a = {{1,2,3,4,5}};
        ArrayList<Integer> list = printMatrix(a);
        for (int n:list) {
            System.out.println(n);
        }*/
    }
}
