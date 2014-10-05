import java.util.Comparator;


public class lengthComp implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		return (len1==len2) ? 0 : (len1-len2)/Math.abs(len1-len2);
	}

}
