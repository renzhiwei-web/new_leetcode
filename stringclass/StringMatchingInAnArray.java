package stringclass;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {
	// leetcode 1408 simple 2022/8/6
	// ¼òµ¥Ä£Äâ¼´¿É
	public List<String> stringMatching(String[] words) {
		List<String> ans = new ArrayList<>();
		int n = words.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (words[j].indexOf(words[i]) >= 0) {
					ans.add(words[i]);
					break;
				}
			}
		}
		return ans;
	}

}
