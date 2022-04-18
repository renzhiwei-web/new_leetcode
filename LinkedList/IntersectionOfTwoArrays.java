class IntersectionOfTwoArrays {
    // Leetcode 349 simple,2022/4/18
    // 使用归并排序的思想，难点是如何保证集合中元素的唯一性
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0,k = 0;
        int len1 = nums1.length,len2 = nums2.length;
        int[] ans = new int[len1 + len2];
        while(i < len1 && j < len2){
            int num1 = nums1[i],num2 = nums2[j];
            if(num1 == num2){
                //保证结果集合中元素的唯一性
                if(k == 0 || num1 != ans[k - 1]){
                    ans[k++] = num1;
                }
                i++;
                j++;
            }else if(num1 < num2){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(ans,0,k);
    }
}
