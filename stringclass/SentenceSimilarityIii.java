package stringclass;

public class SentenceSimilarityIii {
    // leetcode 1813 medium 2023/1/16
    // 双指针的使用
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length){
            return func(s2,s1);
        }
        return func(s1,s2);
    }

    /**
     * s1 的长度小于s2
     * @param s1
     * @param s2
     * @return
     */
    private boolean func(String[] s1, String[] s2) {
        int i = 0,j = 0;
        while(i < s1.length && s1[i].equals(s2[i])){
            i++;
        }
        while(j < s1.length && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])){
            j++;
        }
        return i + j >= s1.length;
    }
}
