package designClass;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyurl {
	// leetcode 535 medium 2022/6/29
	// 理解题意，通过哈希表模拟即可
	
	private Map<Integer, String> dataBase = new HashMap<>();
	private Random random = new Random();
	
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key;
        while(true) {
        	key = random.nextInt();
        	if (!dataBase.containsKey(key)) {
				break;
			}
        }
        dataBase.put(key, longUrl);
        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int p = shortUrl.lastIndexOf('/') + 1;
        int key = Integer.parseInt(shortUrl.substring(p));
        return dataBase.get(key);
    }
}
