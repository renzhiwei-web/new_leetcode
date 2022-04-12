class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chs = s.toCharArray();
        int row = 0,lastWidth = 0;
        for(int i = 0;i < chs.length;i++){
            int temp = widths[chs[i] - 'a'];
            if (lastWidth + temp > 100){
                row++;
                lastWidth = temp;
            }else{
                lastWidth += temp;
            }
        }
        if( lastWidth != 0){
            row++; // 初试行数为0，若最后一行的宽度不是0，最行数+1.
        }
        return new int[]{row,lastWidth};
    }
}
