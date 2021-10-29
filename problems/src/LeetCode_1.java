import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 1.Arrays.toString() 可以将任意类型的数组转成字符串，包括基本类型数组和引用类型数组
* 2.由上面asList 源码我们可以看到返回的 Arrays 的内部类 ArrayList 构造方法接收的是一个类型为 T 的数组，
*   而基本类型是不能作为泛型参数的，所以这里参数 a 只能接收引用类型，
*   自然为了编译通过编译器就把上面的 int[] 数组当做了一个引用参数，所以 size 为 1，
*   要想修改这个问题很简单，将 int[] 换成 Integer[] 即可。
*   所以原始类型不能作为 Arrays.asList 方法的参数，否则会被当做一个参数。
* */
public class LeetCode_1 {
    public static void main(String[] args){
        System.out.println("1");
        int[] answer = new int[]{};
        int[] params1 ={2,7,11,15};
        int params2 =9;
        twoSum(params1,params2);
    }
    public static void twoSum(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    System.out.println(Arrays.toString(new int[]{i,j}));
                    Arrays.asList(new Integer[]{i,j}).stream().forEach(s-> System.out.print(s));
                    return;
                }
            }
        }
    }
    //参考答案-哈希映射
    public static void twoSum_2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                Arrays.asList(new Integer[]{map.get(target-nums[i])},i);
                return;
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two...");
    }
}
