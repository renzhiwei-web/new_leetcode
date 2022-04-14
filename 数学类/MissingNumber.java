class MissingNumber {
    public int missingNumber1(int[] nums) {
        //leetcode 268 simple,2022/4/14
        //排序后查找
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        //leetcode 268 simple,2022/4/14
        //数学方法，累加
        int sumNums = 0;
        int n = nums.length;
        for (int i = 0;i < n;i++){
            sumNums += nums[i];
        }
        int sum = n * (n + 1) / 2;
        return sum - sumNums;
    }


    public int missingNumber3(int[] nums) {
        //leetcode 268 simple,2022/4/14
        //数组哈希方法，最优算法
        int len = nums.length;
        int[] hash = new int[len + 1];
        for(int num : nums){
            hash[num]++;
        }
        for(int i = 0;i <=len;i++){
            if(hash[i] != 1){
                return i;
            }
        }
        return len;
    }

    public int missingNumber(int[] nums) {
        //leetcode 268 simple,2022/4/14
        //位运算方法,空间复杂度最大
        int ans = 0;
        int len = nums.length;
        for(int i = 0;i <= len;i++){
            ans ^= i;
        }
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
