class IsSubsequence {
    // leetcode 392 simple 2022/4/18
    // 首先容易想到暴力求解，也就是贪心算法
    public boolean isSubsequence1(String s, String t) {
        int len1 = s.length(),len2 = t.length();
        char[] chss = s.toCharArray(),chts = t.toCharArray();
        int i = 0,j = 0;
        while(i < len1 && j < len2){
            if(chss[i] == chts[j]){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if (i == len1){
            return true;
        }
        return false;
    }

    // 动态规划算法
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];  // f[i][j] 表示字符串 t 中从位置 i 开始往后字符 j 第一次出现的位置，
        //所以填充矩阵时从t的末尾遍历
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    // 二分查找算法，由于字母是无序的，但是其索引是有序的，查找结果是索引
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> tHash = new HashMap<>();
    	char[] chts = t.toCharArray();
    	for(int i = 0;i < chts.length;i++) {
    		if(tHash.containsKey(chts[i])) {
    			tHash.get(chts[i]).add(i);
    		}else {
				List<Integer> indexList = new ArrayList<>();
				indexList.add(i);
				tHash.put(chts[i], indexList);
			}
    	}
    	
    	int lens = s.length();
    	char[] chss = s.toCharArray();
    	int lastIndex = -1;
    	for(int i = 0;i < lens;i++) {
    		if(!tHash.containsKey(chss[i])) {
    			return false;
    		}
    		List<Integer> indexes = tHash.get(chss[i]);
    		// 使用二分查找找到最近的索引点
    		int left = -1,right = indexes.size();//二分法第一步
    		while(left + 1 != right) {
    			int mid = (left + right) >> 1;
    			if (indexes.get(mid) > lastIndex) {// 二分法第二步，判断条件
					right = mid;
				}else {
					left = mid;
				}
    		}//二分法第三步，确定返回的值是left，还是right，本题是right
    		if(right == indexes.size()) {
    			return false;
    		}
    		lastIndex = indexes.get(right);
    	}
    	return true;
    }
}
