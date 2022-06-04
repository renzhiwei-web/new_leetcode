package stringclass;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	// leetcode 929 simple 2022/6/4
	// 要想到使用set数据结构来解题
    public int numUniqueEmails(String[] emails) {
    	Set<String> set = new HashSet<>();
    	for(String email : emails) {
    		int index = email.indexOf('@');
    		// 去掉本地名中+后面的所有字符
    		String local = email.substring(0,index).split("\\+")[0];
    		local = local.replace(".", "");
    		set.add(local + email.substring(index));
    	}
    	return set.size();
    }
}
