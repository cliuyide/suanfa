package main.liuyi.implementstrstr;

public class KmpStrandard {
	public static void main(String[] args) {
		Long start=System.currentTimeMillis();
		System.out.println(new KmpStrandard().strStr("aabaaabaaac", "aabaaac"));
		System.out.println(System.currentTimeMillis()-start);

	}

	public int strStr(String haystack, String needle) {
		int[] N = getN(needle);
		int res = 0;
		int sourceLength = haystack.length();
		int patternLength = needle.length();
		for (int i = 0; i <= (sourceLength - patternLength);) {
			res++;
			String str = haystack.substring(i, i + patternLength);// 要比较的字符串
			p(str);
			int count = getNext(needle, str, N);
			p("移动" + count + "步");
			if (count == 0) {
				p("KMP：匹配成功");
				break;
			}
			i = i + count;
		}
		p("KMP：一共匹配" + res + "次数");
		return patternLength;
	}

	/**
     * 得到下一次要移动的次数
     * 
     * @param pattern
     * @param str
     * @param N
     * @return 0,字符串匹配；
     */
    private static int getNext(String pattern,String str,int[] N) {
        int n = pattern.length();
        char v1[] = str.toCharArray();
        char v2[] = pattern.toCharArray();
        int x = 0;
        while (n-- != 0) {
            if (v1[x] != v2[x]){
                if(x==0){
                    return 1;//如果第一个不相同，移动1步
                }
                return x-N[x-1];//x:第一次出现不同的索引的位置，即j
            }
            x++;
        }
        return 0;
    }
    private static int[] getN(String pattern) {
        char[] pat=pattern.toCharArray();
        int j=pattern.length()-1;
        int[] N=new int[j+1];
        for(int i=j;i>=2;i--){
            N[i-1]=getK(i,pat);
        }
        for(int a:N)
            p(a);
        return N;
    }
    private static int getK(int j, char[] pat) {
        int x=j-2;
        int y=1;
        while (x>=0 && compare(pat, 0, x, y, j-1)) {
            x--;
            y++;
        }
        return x+1;
    }
    private static boolean compare(char[] pat,int b1,int e1,int b2,int e2){
        int n = e1-b1+1;
        while (n-- != 0) {
            if (pat[b1] != pat[b2]){
                return true;
            }
            b1++;
            b2++;
        }
        return false;
    }
    public static void p(Object obj) {
        System.out.println(obj);
    }
}
