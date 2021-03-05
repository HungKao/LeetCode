import java.util.HashMap;
import java.util.LinkedList;
import java.util.Arrays;
//import java.util.ArrayList;
import java.util.List; // 重要
import java.util.Stack;

public class LC {
    // no1
    static int[] twoSum(int[] nums, int target) {     
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    
        for(int i=0; i < nums.length; i++){      
            if(map.containsKey(target - nums[i])){
                int[] ans = {i, map.get(target-nums[i])};  
                return ans;
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    } 
    // no2
    static int lengthOfLongestSubstring(String s) {        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int ans = 0;
        int i = 0;
        int del = 0;     
        while(i < s.length()){         
            if(!map.containsKey(s.charAt(i))){            
                map.put(s.charAt(i), i);
                ans = Math.max(ans, map.size());
                i++;    
            }else{
                map.remove(s.charAt(del)); 
                del++;
            }
        }
        return ans; 
    }
    // no3
    static String longestPalindrome(String s) {      
        int start = 0, end = 0;     
        for(int i=0; i < s.length(); i++){
            int left = i-1, right = i+1;
            int c = s.charAt(i);
            while(left >= 0 && s.charAt(left) == c){    // to find the center
                left --;                
            }
            while(right < s.length() && s.charAt(right) == c){
                right ++;
            }
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){ // to find the palindrome
                left --;
                right ++;     
            }           
            left += 1;
            if(end - start < right - left){
                end = right;
                start = left;
            }        
        }
        return s.substring(start, end);
    }
    // no4
    static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j= height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }
    // no5
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<List<Integer>>(); 
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int j = i + 1, k = nums.length - 1, target = 0 - nums[i];
                while (j < k) {
                    if (nums[j] + nums[k] == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++; 
                        k--;
                    } 
                    else if (nums[j] + nums[k] < target) j++;
                    else k--;
               }
            }
        }
        return ans;
    }
    // no7
    static boolean isValid(String s) {    
        Stack<Character> stack = new Stack<Character>();  
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if( c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if(stack.empty()){
                return false;
            }
            else if( c == ')' && '(' == stack.peek()){
                stack.pop();
            }
            else if( c == '}' && '{' == stack.peek()){
                stack.pop();
            }
            else if( c == ']' && '[' == stack.peek()){
                stack.pop();
            }
            else {return false; }
        }
        return stack.empty();
    }
    public static void main(String[] args){

        int[] no1 = {2,4,6464,415,987,45,141,0,879,55,19,65};
        int target = 6;
        System.out.println("兩數相加為目標: " + twoSum(no1, target));

        String no2 = "ajcnddicmdjsxmzyeP";
        System.out.println("最長不重複字串: " + lengthOfLongestSubstring(no2));

        String no3 = "ajcnddicmdjsxmzyePbaaab";
        System.out.println("最長回文(鏡像字串): " + longestPalindrome(no3));

        int[] no4 = {5,9,95,52,21,1,0,51,0,2,56,4};
        System.out.println("最大裝水量: " + maxArea(no4));

        int[] no5 = {-9,-5,-3,-1,0,0,0,1,3,4,5,8,9};
        System.out.println("3數相加為0: " + threeSum(no5));

        String no7 = "({[{({[(()()[]{})]})}]})";
        System.out.println("檢查符號: " + isValid(no7));
    }
}