package stringclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAndReplacePattern {
	// leetcode 890 medium 2022/6/12
	// �ѵ���û���뵽ʹ��˫ӳ���������
	// ��ϣ��Ҳ����������ӳ��
    public List<String> findAndReplacePattern(String[] words, String pattern) {
    	List<String> ans = new ArrayList<>();
    	// map��¼�����ӳ���ϵ��vis��¼��Щ�ַ��Ѿ���ӳ��
    	int[] map = new int[26],vis = new int[26];
    	for(String s : words) {
    		// ÿ����һ�����ʾ�ˢ��һ��ӳ���
    		Arrays.fill(map, -1);
    		Arrays.fill(vis, 0);
    		boolean ok = true;
    		for(int i = 0;i < pattern.length() && ok;i++) {
    			int c1 = s.charAt(i) - 'a',c2 = pattern.charAt(i) - 'a';
    			if (map[c1] == -1 && vis[c2] == 0) {
    				// ���ǵ�ǰ�ַ��ĳ���ӳ�䣬��s�е��ַ�ӳ�䵽pattern�У���¼pattern�ĵ�ǰ�ַ��Ѿ���ӳ��
					map[c1] = c2;
					vis[c2] = 1;
					// ����ǰ�ַ��Ѿ���ӳ�䵽pattern�У���鿴��ǰ�ַ�֮ǰ��ӳ���뵱ǰӳ���Ƿ���ͬ
				}else if (map[c1] != c2) {
					ok = false;
				}
    		}
    		if (ok) {
				ans.add(s);
			}
    	}
    	return ans;
    }

}
