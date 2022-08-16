package designClass;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
	// leetcode 1656 simple 2022/8/16
	// ��ģ�⼴��
	// �������
	private String[] data;
	// ָ��
	private int ptr;

	public OrderedStream(int n) {
		data = new String[n];
		ptr = 0;
	}

	public List<String> insert(int idKey, String value) {
		data[idKey - 1] = value;
		List<String> ans = new ArrayList<>();
		// �ҵ�����������
		while (ptr < data.length && data[ptr] != null) {
			ans.add(data[ptr]);
			ptr++;
		}
		return ans;
	}
}
