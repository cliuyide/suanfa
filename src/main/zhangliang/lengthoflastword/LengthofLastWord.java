package main.zhangliang.lengthoflastword;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 */
public class LengthofLastWord {

    public static void main(String[] args) {
        new LengthofLastWord().lengthOfLastWord("adf asdf   a  ");
    }

    /**
     * 59 / 59 test cases passed.Runtime: 8 ms, Your runtime beats 17.66 % of java submissions.
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int lengthOfLastWord = 0;
        if (s == null) {
            return 0;
        }
        String[] arr = s.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                lengthOfLastWord = arr[i].length();
                break;
            }
        }
        return lengthOfLastWord;
    }

    /**
     * 59 / 59 test cases passed.Runtime: 5 ms, Your runtime beats 99.92 % of java submissions.
     * 
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {
        int lengthOfLastWord = 0;
        if (s == null) {
            return 0;
        }
        boolean start = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (start) {
                if (s.charAt(i) != ' ') {
                    lengthOfLastWord++;
                } else {
                    break;
                }
            } else {
                if (s.charAt(i) != ' ') {
                    start = true;
                    lengthOfLastWord++;
                }
            }
        }
        return lengthOfLastWord;
    }
}
