package offer.chapter04;

/**
 * 数组中次数超过一半的数
 */
public class Problem01 {
    public static int solution(int[] arr){
        if (arr== null || arr.length <1)
            throw new IllegalArgumentException("array length less than 0");
        int num = arr[0];
        int count = 1;
        for(int i = 1;i <arr.length;i++){
            if (count == 0){
                num = arr[i];
                count++;
            }else if(arr[i] == num){
                count++;
            }else {
                count--;
            }
        }

        count = 0;
        for(int number:arr){
            if (num == number)
                count++;
        }
        if (count>arr.length/2){
            return num;
        }else {
            throw new RuntimeException("invalid input");
        }
    }
}
