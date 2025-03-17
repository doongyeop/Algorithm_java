class Solution {
    public int solution(int[] wallet, int[] bill) {
        int walletWidth = Math.min(wallet[0], wallet[1]);
        int walletHeight = Math.max(wallet[0], wallet[1]);
        int billWidth = Math.min(bill[0], bill[1]);
        int billHeight = Math.max(bill[0], bill[1]);
        
        return Math.min(foldCount(billWidth, billHeight, walletWidth, walletHeight),
                        foldCount(billHeight, billWidth, walletWidth, walletHeight));
    }

    private int foldCount(int billW, int billH, int walletW, int walletH) {
        int folds = 0;
        
        while (billW > walletW || billH > walletH) {
            if (billH > billW) {
                billH /= 2;
            } else {
                billW /= 2;
            }
            folds++;
        }
        
        return folds;
    }
}
