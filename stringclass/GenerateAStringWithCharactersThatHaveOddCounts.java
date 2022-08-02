package stringclass;

public class GenerateAStringWithCharactersThatHaveOddCounts {
	// leetcode 1374 2022/8/1
	// ¼òµ¥Ä£Äâ¼´¿É
	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder();
		if (n % 2 == 0 && --n >= 0) {
			sb.append('a');
		}
		while(n-- > 0) {
			sb.append('b');
		}
		return sb.toString();
	}
}
