package main.hanjinxin.longestpalindromic;

import java.util.Date;

public class LongestPalindromicSubStringB {
    public static String longestPalindromicSubString(String s) {
        if(s == null || s.length()<=1) return s;
        String result = s.substring(0,1);
        char[] arr = s.toCharArray();
        for(int i=arr.length; i>0; i--){
            for(int j=0; j<arr.length-i+1; j++){
                result = s.substring(j, j+i);
                if(checkIsPalindromic(result)){
                    return result;
                }
            }
        }
        return result;
    }
    
    public static boolean checkIsPalindromic(String s){
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length/2; i++){
            if(arr[i] != arr[arr.length-i-1]){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(
                LongestPalindromicSubStringB.longestPalindromicSubString("whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone"));
        System.out.println(new Date().getTime() - date1.getTime());
    }
}
