package array;

public class CanPlaceFlowers {
	// leetcode 605 simple 2022/5/11
	// 首先容易想到使用贪心算法思想
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int len = flowerbed.length;
    	int i = 0;
    	while(i < len) {
    		if (flowerbed[i] == 1) {
				i += 2;// 说明当前已经种花且下个不能种花
			}else {
				if (i == len - 1 || flowerbed[i + 1] == 0) {
					n--;
					i += 2;// 说明当前没有种花，且下一个也没有种花或已经是末尾，则当前可以种花
				}else {
					i += 3;// 说明当前没有种花，且下一个已经种花，说明当前不可以种花，且下下个位置也不可以种花
				}
			}
    	}
    	return n <= 0;
    }
}
