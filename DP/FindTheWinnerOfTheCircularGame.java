package stringclass;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTheWinnerOfTheCircularGame {
	//leetcode 1823 medium 2022/5/4
	// 首先容易想到暴力求解法，直接按照过程模拟即可
    public int findTheWinner1(int n, int k) {
    	 Deque<Integer> queue = new ArrayDeque<>();
    	 for(int i = 1;i <= n;i++) {
    		 queue.addLast(i);
    	 }
    	 while(queue.size() > 1) {
    		 for(int i = 1;i < k;i++) {
    			 queue.offer(queue.poll());
    		 }
    		 queue.poll();
    	 }
    	 return queue.peek();
    }
    
    // 约瑟夫环数学推导算法，递归做法
    // 核心思路是已知最后胜利者的位置为1，推出他最初的位置
    // 每进行一轮，胜利者的位置向前移动了k位(因为每次从杀掉的人后面一个开始重新报数，设重新报数的人编号为1，则胜利者的编号向前移动了k位)
    public int findTheWinner2(int n, int k) {
    	if (n == 1) {
			return 1;
		}
    	// 由于游戏每进行一次，胜利者的位置向前移动k位，则逆推每次加k位
    	return (findTheWinner2(n - 1, k) + k - 1) % n + 1;
    }
    
    // 迭代算法
    public int findTheWinner(int n, int k) {
    	int ans = 0;
    	for(int i = 2;i <= n;i++){//游戏要进行n-1次才能选出最终的胜利者,且最后一轮游戏，只有两个人参与
    		ans = (k + ans) % i;
    	}
    	return ans + 1;
    }
}
