import java.util.List;

public class SuffixQueries {

	public static void main(String[] args) {

	}

	public static int suffixQueries(String s, List<String> query) {
		int result = 0;
		final int M = 1000000007;

		for (String q : query) {
			int i = s.lastIndexOf(q);
			String rs = "";
			if (i != -1)
				rs = s.substring(i);
			while (true) {
				if (i <= 0)
					break;
				String temp = s.substring(0, i);
				i = temp.lastIndexOf(q);

				if (i == -1)
					break;

				String subString = s.substring(i);
				if (subString.compareTo(rs) < 0)
					rs = subString;

			}
			result += rs.length();
			while (result > M)
				result -= M;

		}

		return result;

	}

}
