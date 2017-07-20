package leetCode12;

/**
 * Integer to Roman
 * <p/>
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author kevin(ssp0xd7@gmail.com) 2017/7/20
 */
public class Solution_12 {

    public static String intToRoman(int num) {
        String[][] roman = { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" }, //个
            { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" }, //十
            { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" }//百
        };
        StringBuilder result = new StringBuilder(8);
        int count = num / 1000;
        if (count > 0) {
            for (int i = 0; i < count; i++) {
                result.append("M");
            }
        }
        num %= 1000;
        count = num / 100;
        if (count > 0) {
            result.append(roman[2][count]);
        }
        num %= 100;
        count = num / 10;
        if (count > 0) {
            result.append(roman[1][count]);
        }
        num %= 10;
        count = num;
        if (count > 0) {
            result.append(roman[0][count]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution_12.intToRoman(12));
    }
}
