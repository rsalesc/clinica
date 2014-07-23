package gerenciadorclinica.extras;

import java.util.Arrays;

public class Utils {
	public static String join(String s, Object[] a) {
	    return a.length == 0 ? "" : a[0] + (a.length == 1 ? "" : s + join(s, Arrays.copyOfRange(a, 1, a.length)));
	}
	public static String join(String s, Object a, int times) {
	    return times == 0 ? "" : a + (times == 1 ? "" : s + join(s, a, times-1));
	}
}
