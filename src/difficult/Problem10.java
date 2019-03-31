package difficult;

/**
 * @description:
 * @author: Zhou Sihang
 * @date: 2019/03/31
 * @since: 1.0.1
 **/
public class Problem10 {
    public boolean isMatch(String s, String p) {
        boolean[][] output = new boolean[s.length() + 1][p.length() + 1];
        output[0][0] = true;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '*' && output[0][i-1]) {
                output[0][i+1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '.') {
                    output[i+1][j+1] = output[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    output[i+1][j+1] = output[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        output[i+1][j+1] = output[i+1][j-1];
                    } else {
                        output[i+1][j+1] = (output[i+1][j] || output[i][j+1] || output[i+1][j-1]);
                    }
                }
            }
        }
        return output[s.length()][p.length()];
    }

    public static void main(String[] args) {
        Problem10 problem10 = new Problem10();
        String s = "aaa";
        String p = "ab*ac*a";
        System.out.println(problem10.isMatch(s, p));
    }
}
