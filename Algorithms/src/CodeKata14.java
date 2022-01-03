import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeKata14 {

	public static void main(String[] args) {
		String input = "I wish I may I wish I might";
		Map<Key, List<String>> trigrams = new HashMap<>();

		String first = null, second = null, third = null;
		for (String s : input.split(" ")) {
			if (first == null) {
				first = s;
				continue;
			} else if (second == null) {
				second = s;
				continue;
			} else {
				third = s;
			}

			Key k = new Key(first, second);
			List<String> values = new ArrayList<String>();

			if (trigrams.containsKey(k)) {
				values = trigrams.get(k);
			} else {
				trigrams.put(k, values);
			}

			values.add(third);
			first = second;
			second = third;
		}

	}

	static class Key {
		String first, second;

		public Key(String first, String second) {
			super();
			this.first = first;
			this.second = second;
		}

	}

}
