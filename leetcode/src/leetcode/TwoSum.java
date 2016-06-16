package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2
 */

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target){
		int[] ret = new int[2];
		Map<Integer, Integer > map = new HashMap<Integer, Integer>();
		for(int i =0; i<nums.length; i++ ){
			if(map.containsKey(nums[i])){
				int index = map.get(nums[i]);
				ret[0] = index +1;
				ret[1] = i+1;
				break;
			}else{
				map.put(target-nums[i], i);
			}
		}
		return ret;
	}

	public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i+1);
		}
		
		for(int i = 0; i < nums.length; i++) {
			int k = target - nums[i];
			if (map.containsKey(k) && map.get(k) != (i + 1)) {
				return new int[]{i+1, map.get(k)};
			}
		}
		return null;
    }
	
}
