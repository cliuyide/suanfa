package main.hanjinxin.longestpalindromic;

import java.util.Date;

public class LongestPalindromicSubStringA {
    public static String longestPalindromicSubString(String s) {
        if(s == null || s.trim().length()<=1) return s;
        s = s.trim();
        char[] arr = s.toCharArray();
        String result = s.substring(0,1);
        for(int i=0; i<arr.length; i++){
            if(arr.length-i < result.length()){
                break;
            }
            for(int j=arr.length-1; j>i; j--){
                if(j-i < result.length()){
                    break;
                }
                String cmpStr = s.substring(i, j+1);
                if(checkIsPalindromic(cmpStr)){
                    result = cmpStr;
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
                LongestPalindromicSubStringA.longestPalindromicSubString("whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone"));
        System.out.println(new Date().getTime() - date1.getTime());
    }
}
