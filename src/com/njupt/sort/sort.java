package com.njupt.sort;

/**
 * Created by zhangqiao on 2019/4/10.
 */
public class sort {
    /**
     * 快速排序
     * */
    public static void quickSort(int a[],int low,int high){
        if(low < high){
            int pivotpos = partition(a,low,high);
            quickSort(a,low,pivotpos-1);
            quickSort(a,pivotpos+1,high);
        }
    }
    public static int partition(int a[],int low,int high){
        int pivot = a[low];
        while (low < high){
            while (low < high && a[high] >= pivot){
               --high;
            }
            a[low] = a[high];
            while (low < high && a[low] <= pivot){
                ++low;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return  low;
    }

    /**
     * 冒泡排序
     * */
    public static void bubble_sort(int a[]){
        int len = a.length;
        for(int i = 0;i < len-1;i++){
            for(int j = 0;j < len-1;j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    /**
     * 两路合并排序
     */
    public static void merge(int a[],int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= high){
            if(a[i] < a[j]){
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }
        //把左边剩下的移到数组中
        while (i <= mid){
            temp[k++] = a[i++];
        }
        //把右边剩下的移到数组中
        while (j <= high){
            temp[k++] = a[j++];
        }

        for (int x = 0;x <temp.length;x++){
            a[x+low] = temp[x];
        }


    }
    public static int[] mergeSort(int a[],int low,int high){
        int mid = (low+high)/2;
        if(low < high){
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            //左右合并
            merge(a,low,mid,high);

        }
        return a;
    }

    /**
     * 堆排序
     */

    public static void main(String[] args){
        int a[] = {4,6,3,2};
        //quickSort(a,0,a.length-1);
        //bubble_sort(a);
        //mergeSort(a,0,a.length-1);
        for (int num:a) {
            System.out.print(num);
        }
        //String str ="q ddscnkldclsclsd";
        // StringBuilder stringBuilder = new StringBuilder(str);
        //StringBuffer stringBuffer = new StringBuffer(str);
        //stringBuilder.replace(1,2,"%20");
        //stringBuffer.replace(1,2,"%20");
        //System.out.println(stringBuffer);
    }
}
