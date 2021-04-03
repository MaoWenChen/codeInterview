package leetCode.test;

import java.util.*;

public class Leet90 {
	
	public static void main(String[] args) {
		Leet90 leet90 = new Leet90();
		System.out.println(leet90.subsetsWithDup(new int[] {1,2,2}));
	}

	private List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums.length==0) {
			return lists;
		}
		Arrays.sort(nums);
		dfs(nums, new ArrayList<Integer>(), 0);
		return lists;
	}

	public void dfs(int[] nums,List<Integer> list, int cur) {
		if (cur==nums.length) {
			if (!lists.contains(list)) {
				lists.add(new ArrayList<>(list));
			}
		}else {
			dfs(nums,list,cur+1);
			list.add(nums[cur]);
			dfs(nums,list,cur+1);
			list.remove(list.size()-1);
		}
	}
	
	public List<List<Integer>> subset(int[] nums) {
		 List<List<Integer>> res = new ArrayList<>();
	        if(nums.length == 0){
	            return res;
	        }
	        //分类
	        Map<Integer,Integer> map = new HashMap<>();
	        for(int i = 0; i < nums.length;++i){
	            if (map.containsKey(nums[i])){
	                map.put(nums[i],map.get(nums[i])+1);
	            }else{
	                map.put(nums[i],1);
	            }
	        }
	        res.add(new ArrayList<>());
	        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
	            int n = res.size();
	            for(int j = 0; j< n;++j){
	                List<Integer> temp = new ArrayList<>(res.get(j));
	                for(int i = 1; i <= entry.getValue();++i){
	                    temp.add(entry.getKey());
	                    res.add(new ArrayList<>(temp));
	                }
	            }
	        }
	        return res;
	    
	}

}
