import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		String input = "java,python,c,javascript,java,html,java,python";
		String[] arr = input.split(",");
		List<String> list = Arrays.asList(arr);
		Map<String, Integer> counts = new HashMap<>();
		for (String s : list) {
			if (counts.containsKey(s)) {
				counts.put(s, counts.get(s) + 1);
			} else {
				counts.put(s, 1);
			}
		}
		// list.stream()

		System.out.println(counts);

		input = "CHAKRA RAMA RAO ADABALA";

		System.out.println(input.chars().filter(a -> a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U').count());

		input = "[[][(]){]";
		Set<Character> openChars = new HashSet<>(Arrays.asList('[', '(', '{'));
		Set<Character> closedChars = new HashSet<>(Arrays.asList(']', ')', '}'));
		Map<Character, Integer> map = new HashMap<>();
		int count[] = new int[1];
		input.chars().parallel().forEach( c -> {
			switch(c) {
			case '[':
				if(map.containsKey('[')) {
					map.put('[', map.get('[') + 1);
				}else {
					map.put('[', 1);
				}
				break;
			case ']':
				if(map.containsKey(']')) {
					map.put('[', map.get('[') - 1);
				}else {
					map.put('[', -1);
				}
				break;
			}
		});
		
		System.out.println(map);
		
		
		System.out.println(map.get('[') == 0 ? "Balanced" : "Not Balanced");

	}

}





