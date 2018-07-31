package main.liuyi.generateparentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {    
        List<String> list = generate(3);  // 生成3对括号的所有组合    
        for(String str : list) {    
            System.out.println(str);    
        }    
    }    
      
    /**  
     * 生成n对括号的全部有效组合  
     * @param num 有几对括号  
     * @return 装有所有括号组合的列表容器  
     */    
    public static List<String> generate(int num) {    
        char[] buffer = new char[num * 2];    
        List<String> list = new ArrayList<String>();    
        make(list, num, num, buffer, 0);    
        return list;    
    }    
    /**  
     * 通过递归生成n对括号的全部有效组合  
     * @param list 装括号组合的容器  
     * @param leftRem 左括号剩余数量  
     * @param rightRem 右括号剩余数量  
     * @param buffer 放括号的字符数组  
     * @param count 插入括号的位置  
     */    
    private static void make(List<String> list, int leftRem, int rightRem, char[] buffer, int count) {    
        if(leftRem < 0 || rightRem < leftRem) {   // 无效输入    
            return ;    
        }    
        if(leftRem == 0 && rightRem == 0) { // 木有括号了    
            String s = String.copyValueOf(buffer);    
            list.add(s);    
        }else {    
            if(leftRem > 0) {    // 还有左括号可用则加入左括号    
                buffer[count] = '(';    
                make(list, leftRem - 1, rightRem, buffer, count + 1);    
            }    
            if(rightRem > leftRem) { // 右括号比左括号跟多就可以加入右括号    
                buffer[count] = ')';    
                make(list, leftRem, rightRem - 1, buffer, count + 1);    
            }    
        }    
    }  
}
