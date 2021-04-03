package offer.chapter04;

import java.util.Comparator;

/**
 * 把数排成最小的数
 */
public class Problem05 {

     public static void solution(String[] arr){
        if (arr == null ||arr.length <1){
            throw new IllegalArgumentException("invalid input");
        }
        quitSort(arr, 0, arr.length - 1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo((o2+o1));
            }
        });

     }

     public static void quitSort(String[] arr, int start, int end, Comparator<String> comp){
         if (start<end){
             String tmp = arr[start];
             int lo = start;
             int hi = end;
             while(lo<hi){
                 while(lo<hi && comp.compare(tmp,arr[hi])<=0){
                     end --;
                 }
                 arr[lo]= arr[hi];
                 while (lo<hi&&comp.compare(tmp,arr[lo])>=0){
                     lo++;
                 }
                 arr[hi]=arr[lo];
             }
             arr[lo] = tmp;
             quitSort(arr,start,lo-1,comp);
             quitSort(arr,lo+1,end,comp);
         }

     }





}
