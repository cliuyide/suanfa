package main.houpo.IsIsomorphic;

public class IsIsomorphic {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		int len = 256;
		int[] aMap = new int[len];
		int[] bMap = new int[len];
		for (int i = 0; i < s.length(); i++) {
			if (aMap[get(ss, i)] == 0) {
				aMap[get(ss, i)] = get(tt, i);
			} else if (aMap[get(ss, i)] != get(tt, i)) {
				return false;
			}
			if (bMap[get(tt, i)] == 0) {
				bMap[get(tt, i)] = get(ss, i);
			} else if (bMap[get(tt, i)] != get(ss, i)) {
				return false;
			}
		}
		return true;
	}
	
	public char get(char[] arr, int index) {
		if ((index < 0) || (index >= arr.length)) {
            throw new StringIndexOutOfBoundsException(index);
        }
		return arr[index];
	}
	
	public static void main(String[] args) {
		new IsIsomorphic().isIsomorphic("egg", "add");
	}
}

//char ns = get(ss, i);
//char nt = get(tt, i);
//if (aMap[ns] == 0) {
//	aMap[ns] = nt;
//} else if (aMap[ns] != nt) {
//	return false;
//}
//if (bMap[nt] == 0) {
//	bMap[nt] = ns;
//} else if (bMap[nt] != ns) {
//	return false;
//}
