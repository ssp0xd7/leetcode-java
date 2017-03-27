package leetCode5;

/**
 * Created by kevin on 17-3-27.
 */
public class Solution_5_1 {

    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        boolean[][] temp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i >= j) {//为什么要初始化为1？如果是s[3][4]的递推公式就要依赖s[4][3],在s[3]==s[4]的情况下，当然是=1的
                    temp[i][j] = true;
                } else {
                    temp[i][j] = false;
                }
            }
        }
        int i;
        int j = 1;
        int maxlen = 0;
        int ri = 0;
        int rj = 0;
        while (j < length) {
            i = j - 1;
            while (i >= 0) {
                if (s.charAt(i) != s.charAt(j)) {
                    temp[i][j] = false;
                } else {
                    temp[i][j] = temp[i + 1][j - 1];
                    if (temp[i][j] == true && (j - i + 1) > maxlen) {
                        ri = i;
                        rj = j;
                        maxlen = j - i + 1;
                    }
                }
                i--;
            }
            j++;
        }
        return s.substring(ri, rj + 1);
    }

    public static void main(String[] args) {
        String s = "\"kyyrjtdplseovzwjkykrjwhxquwxsfsorjiumvxjhjmgeueafubtonhlerrgsgohfosqssmizcuqryqomsipovhhodpfyudtusjhonlqabhxfahfcjqxyckycstcqwxvicwkjeuboerkmjshfgiglceycmycadpnvoeaurqatesivajoqdilynbcihnidbizwkuaoegmytopzdmvvoewvhebqzskseeubnretjgnmyjwwgcooytfojeuzcuyhsznbcaiqpwcyusyyywqmmvqzvvceylnuwcbxybhqpvjumzomnabrjgcfaabqmiotlfojnyuolostmtacbwmwlqdfkbfikusuqtupdwdrjwqmuudbcvtpieiwteqbeyfyqejglmxofdjksqmzeugwvuniaxdrunyunnqpbnfbgqemvamaxuhjbyzqmhalrprhnindrkbopwbwsjeqrmyqipnqvjqzpjalqyfvaavyhytetllzupxjwozdfpmjhjlrnitnjgapzrakcqahaqetwllaaiadalmxgvpawqpgecojxfvcgxsbrldktufdrogkogbltcezflyctklpqrjymqzyzmtlssnavzcquytcskcnjzzrytsvawkavzboncxlhqfiofuohehaygxidxsofhmhzygklliovnwqbwwiiyarxtoihvjkdrzqsnmhdtdlpckuayhtfyirnhkrhbrwkdymjrjklonyggqnxhfvtkqxoicakzsxmgczpwhpkzcntkcwhkdkxvfnjbvjjoumczjyvdgkfukfuldolqnauvoyhoheoqvpwoisniv\"";//result:bad
        System.out.println(Solution_5_1.longestPalindrome(s));
    }
}
