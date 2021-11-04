import java.math.BigDecimal;
import java.text.DecimalFormat;
//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
public class LeetCode_4 {
    public static void main(String[] args){
        double answer = 0.0d;
        answer=findMedianSortedArrays_standard(new int[]{1,3,5,7},new int[]{2,4});
        DecimalFormat df = new DecimalFormat("#.00000");
        String str = df.format(answer);
        System.out.println(str);
    }
    //该方法非常丑陋
    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        double answer =0.0d;
        //都为空
        if(nums1.length==0 && nums2.length==0){
            return 0;
        }
        //有一个为空，一个长度为1
        if((nums1.length+nums2.length) ==1){
            return nums1.length==1?nums1[0]: nums2[0];
        }
        //有一个为空，一个正常...
        if(nums1.length ==0 || nums2.length ==0){
            if(nums1.length ==0){

            }
        }
        //正常情况...
        if(nums1.length%2 ==0){//偶数个
            answer = answer+nums1[nums1.length/2]+nums1[nums1.length/2+1];
        }else{
            answer = answer+nums1[nums1.length/2]*2;
        }
        if(nums2.length%2 ==0){//偶数个
            answer = answer+nums2[nums2.length/2]+nums2[nums2.length/2+1];
        }else{
            answer = answer+nums2[nums2.length/2]*2;
        }
        return answer/4;
    }
    //left为第一个数组的左侧，right为第一个数组的第一个数组的右侧。然后对第二个数组进行区分。
    public static double findMedianSortedArrays_standard(int[] nums1,int[] nums2){
        int leftLength = nums1.length;
        int rightLength = nums2.length;
        if(leftLength > rightLength){
            return findMedianSortedArrays_standard(nums2,nums1);
        }
        //拿到一半的数据量
        int totalLeft =(leftLength+rightLength+1)/2;
        int left =0,right=leftLength;
        //找到第一个数组中的切割线。
        while(left<right){
            int i = left+(right-left+1)/2;
            int j = totalLeft-i;
            if(nums1[i-1] > nums2[j]){
                right = i-1;
            }else{
                left =i;
            }
        }
        //第一个数组切割的部分
        int i = left;
        //第二个数组切割的部分
        int j = totalLeft -i;

        int nums1LeftMax = i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin = i==leftLength?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax = j ==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2LeftMin =j==rightLength?Integer.MAX_VALUE:nums2[j];

        if((leftLength+rightLength)%2 ==1){
            return Math.max(nums1LeftMax,nums2LeftMax);
        }else {
            return (double)((Math.max(nums1LeftMax,nums2LeftMax))+Math.min(nums1RightMin,nums2LeftMin))/2;
        }
    }
}
