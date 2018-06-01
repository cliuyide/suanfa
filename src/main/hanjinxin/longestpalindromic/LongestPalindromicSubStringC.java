package main.hanjinxin.longestpalindromic;

import java.util.Date;

public class LongestPalindromicSubStringC {  // Runtime: 36 ms
    public static String longestPalindrome(String s) {
        if(s == null || s.length()<=1) return s;
        String result = "";
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){ // 轴位置
            String oddStr = checkOddPalindromic(i, arr, s);
            String evenStr = checkEvenPalindromic(i, arr, s);
            String cmpStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if(cmpStr.length() > result.length()){
                result = cmpStr;
            }
        }
        return result;
    }
    
    public static String checkOddPalindromic(int position, char[] arr, String s){ // 奇数逻辑
        int cut = position;
        for(int i=position; i>0; i--){
            if(position-(i-1)+position >= arr.length){ // 对称取值到尽头了
                break;
            }
            if(arr[i-1] == arr[position-(i-1)+position]){
                cut = i-1;
            }else{
                break;
            }
        }
        return s.substring(cut, position-(cut-1)+position);
    }
    
    public static String checkEvenPalindromic(int position, char[] arr, String s){ // 偶数逻辑
        int cut = position;
        for(int i=position-1; i>=0; i--){
            if(position-i-1+position >= arr.length){
                break;
            }
            if(arr[i] == arr[position-i-1+position]){
                cut = i;
            }else{
                break;
            }
        }
        return s.substring(cut, position-cut+position);
    }
    
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(
                LongestPalindromicSubStringC.longestPalindrome("whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone"));
        System.out.println(new Date().getTime() - date1.getTime());
    }
}
