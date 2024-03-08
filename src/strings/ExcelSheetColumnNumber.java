package strings;
//https://leetcode.com/problems/excel-sheet-column-number
public class ExcelSheetColumnNumber {

    /**
     * "B" = 2
     * "BC" = (2)26 + 3
     * "BCM" = (2(26) + 3)26 + 13
     * @param columnTitle
     * @return
     */
    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        for(char c : columnTitle.toCharArray()){
            ans = 26  * ans +  (c - 'A' + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }
}
