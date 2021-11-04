import java.util.HashMap;
/*
* 1.滑动窗口，使用坐标作为跳转的值。
* 2。使用int[] last = new int[128];来标注字符出现的位置。
* concat && substring。
* */
public class LeetCode_3 {
    public static void main(String[] args){
        int len = lengthOfLongestSubstring_standard("abcabcbb");
        System.out.println(len);
    }
    public static int lengthOfLongestSubstring(String s){
        if(s.length()<=1){
            return s.length();
        }
        int answerLength = 0;
        String answer ="";
        String[] arr = s.split("");
        int i=0,j=0;
        while(j<=arr.length-1&&(i<=j)){
            if(!answer.contains(arr[j])){
                answer=answer.concat(arr[j]);
                answerLength=answerLength>answer.length()?answerLength:answer.length();
                j++;
            }else{
                while(answer.contains(arr[j])&&i<j){
                    answer=answer.substring(1);
                    i++;
                }
            }
        }
        return  answerLength;
    }
    public static int lengthOfLongestSubstring_standard(String s){
        int[] last = new int[128];
        for(int i = 0;i<128;i++){
            last[i] =-1;
        }
        int n = s.length();
        int res = 0;
        int start =0;
        for(int i  = 0;i<n;i++){
            int index = s.charAt(i);
            start = Math.max(start, last[index]+1);
            res = Math.max(res,i-start+1);
            last[index]=i;
        }
        return res;
    }
    public static int lengthOfLongestSubstring_standard_02(String s){
        if(s.length() ==0){
            return 0;
        }
        HashMap<Character,Integer> map =  new HashMap<>();
        int max =0;
        int left =0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                left =Math.max(left,map.get(s.charAt(i))+1);//直接跳到重复的地方的i，然后+1。
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}
