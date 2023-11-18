package top.javajianghu.myleetcode.leetcode.editor.cn;
//整数的 数组形式 num 是按照从左到右的顺序表示其数字的数组。
//
// 
// 例如，对于 num = 1321 ，数组形式是 [1,3,2,1] 。 
// 
//
// 给定 num ，整数的 数组形式 ，和整数 k ，返回 整数 num + k 的 数组形式 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：num = [1,2,0,0], k = 34
//输出：[1,2,3,4]
//解释：1200 + 34 = 1234
// 
//
// 示例 2： 
//
// 
//输入：num = [2,7,4], k = 181
//输出：[4,5,5]
//解释：274 + 181 = 455
// 
//
// 示例 3： 
//
// 
//输入：num = [2,1,5], k = 806
//输出：[1,0,2,1]
//解释：215 + 806 = 1021
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10⁴ 
// 0 <= num[i] <= 9 
// num 不包含任何前导零，除了零本身 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 数组 数学 👍 243 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 先把k装换为数组
        String[] kArr = String.valueOf(k).split("");

        // 比对num和kArr数组长度，谁的长，以谁的长度遍历
        int kArrLength = kArr.length;
        int numLength = num.length;
        int forLen = numLength;
        if(kArrLength > numLength){
            forLen = kArrLength;
        }

        // 结果最多多一位，所以设置结果的长度为forLen + 1
        int[] result = new int[forLen + 1];

        int moreAddNum = 0;
        for (int i = 1 ; i <= forLen ; i++) {
            int val = 0;
            if(num.length - i >= 0 ){
                val += num[num.length - i];
            }
            if(kArr.length - i >= 0 ){
                // 从后向前获取数组的某一位值，然后相加
                val += Integer.parseInt(kArr[kArr.length - i]);
            }

            // 如果刚才低位相加的值>0,那就加到当前数值上
            if(moreAddNum > 0){
                val += moreAddNum;
            }

            // 除以10，得到进位的数字
            moreAddNum = val / 10;
            // 取除以10的余数就是当前位数的值，小于10就是自己，大于10就是余数
            result[result.length - i] = val % 10;

            // 给结果的第0位赋值
            if(i == forLen && moreAddNum != 0){
                result[0] = moreAddNum;
            }
        }

        // 转换result数组为list
        List<Integer> list = Arrays.stream(result).boxed().collect(Collectors.toList());
        if(list.get(0) == 0){
            list.remove(0);
        }
        System.out.println(list);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
