package tree;

import java.util.*;

public class RemoveSubFoldersFromTheFilesystem {
    // leetcode 1233 medium 2023/2/9
    // 使用字典树进行解题
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<>();
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; ++i) {
            int m = ans.get(ans.size() - 1).length();
            int n = folder[i].length();
            if (m >= n || !(ans.get(ans.size() - 1).equals(folder[i].substring(0, m)) && folder[i].charAt(m) == '/')) {
                ans.add(folder[i]);
            }
        }
        return ans;
    }

    class Trie{
        private Map<String,Trie> children = new HashMap<>();
        private int fid = -1;// 用来存储当前节点对应的文件夹在数组folder中的下标

        public void insert(int fid,String f){
            Trie node = this;
            String[] ps = f.split("/");
            for (int i = 1; i < ps.length; i++) {
                String p = ps[i];
                if (!node.children.containsKey(p)){
                    node.children.put(p,new Trie());
                }
                node = node.children.get(p);
            }
            node.fid = fid;
        }

        public List<Integer> search(){
            List<Integer> ans = new ArrayList<>();
            dfs(this,ans);
            return ans;
        }

        private void dfs(Trie root, List<Integer> ans) {
            if (root.fid != -1){
                ans.add(root.fid);
                return;
            }
            for (var child : root.children.values()){
                dfs(child,ans);
            }
        }
    }

    public List<String> removeSubfolders1(String[] folder) {
        Trie trie = new Trie();
        for (int i = 0; i < folder.length; i++) {
            trie.insert(i,folder[i]);
        }
        List<String> ans = new ArrayList<>();
        for (int i : trie.search()) {
            ans.add(folder[i]);
        }
        return ans;
    }
}
