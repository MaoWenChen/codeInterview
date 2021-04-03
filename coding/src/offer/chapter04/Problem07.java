package offer.chapter04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class Problem07 {

    public static char solution(char[] arr) {
        if (arr == null || arr.length < 1)
            throw new IllegalArgumentException("invalid input");

        Map<Character,Integer> map = new LinkedHashMap<>();
        for(int i =0;i<arr.length;i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return '\0';
    }
}
