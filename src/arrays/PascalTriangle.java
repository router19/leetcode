package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle  = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        pascalTriangle.add(row);
//        if(numRows == 1)
//            return pascalTriangle;
//        row = new ArrayList<>();
//        row.add(1);
//        row.add(1);
//        pascalTriangle.add(row);
        for(int i = 2; i <= numRows; i++){
            List<Integer> previousRow = pascalTriangle.get(i-2);
            row = new ArrayList<>();
            row.add(1);
            for(int k =1; k< i-1; k++) {
                int num = previousRow.get(k) + (k - 1 >= 0 ? previousRow.get(k - 1) : 0);
                row.add(num);
            }
            row.add(1);
            pascalTriangle.add(row);
        }
        return pascalTriangle;
    }
    public static void main(String[] args) {
        List<List<Integer>> generate = generate(1);
        System.out.println(generate);
    }
}
