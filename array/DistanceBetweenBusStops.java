package array;

public class DistanceBetweenBusStops {
	// leetcode 1184 simple 2022/7/24
	// ¼òµ¥Ä£Äâ¼´¿É
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    	int n = distance.length;
    	int i = start,j = start;
    	int a = 0,b = 0;
    	while(i != destination) {
    		a += distance[i];
    		if (++i == n) {
				i = 0;
			}
    	}
    	
    	while(j != destination) {
    		if (--j < 0) {
				j = n - 1;
			}
    		b += distance[j];
    	}
    	return Math.min(a, b);
    }
}
