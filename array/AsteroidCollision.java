package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
    	Deque<Integer> queue = new ArrayDeque<>();
    	for(int aster : asteroids) {
    		boolean alive = true;
    		while (alive && aster < 0 && !queue.isEmpty() && queue.peek() > 0) {
				alive = queue.peek() < -aster;//aster �Ƿ����
				if (queue.peek() <= -aster) {// ջ�����Ǳ�ը
					queue.pop();
				}
			}
    		if (alive) {
				queue.push(aster);
			}
    	}
    	int size = queue.size();
    	int[] ans = new int[size];
    	for(int i = size - 1;i >= 0;i--) {
    		ans[i] = queue.pop();
    	}
    	return ans;
    }
}
