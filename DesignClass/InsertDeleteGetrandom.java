class RandomizedSet {
    static int[] nums;
    Random random;
    Map<Integer,Integer> map;
    int idx;//下标
    public RandomizedSet() {
        nums = new int[200010];
        random = new Random();
        map = new HashMap();
        idx = -1;
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        nums[++idx] = val;
        map.put(val,idx);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int loc = map.remove(val);
        //将val值删除后，替换nums[loc]的值为最后一位数值，即nums[idx]
        if(loc != idx){
            map.put(nums[idx],loc);
        }
        nums[loc] = nums[idx--];
        return true;
    }
    
    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }
}
