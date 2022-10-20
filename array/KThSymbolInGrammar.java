package array;

public class KThSymbolInGrammar {
    // leetcode 779 medium 2022/10/20
    // 类似树节点，所以使用递归，观察树的构造方式
    public int kthGrammar(int n, int k) {
        // 如果是顶层，则返回0
        if (n == 1){
            return 0;
        }else {
            // 如果不是顶层，则使用递归，
            // 当k是奇数，就是左孩子，与父节点保持一致
            // 当k是偶数，就是右孩子，对父节点的值进行取反
            if (k % 2 == 1){
                return kthGrammar(n - 1,(k + 1) / 2);
            }else{
                if(kthGrammar(n - 1,(k + 1) / 2) == 1){
                    return 0;
                }else {
                    return 1;
                }
            }
        }
    }
}
