import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		String input = "CHAKRA RAMA RAO";
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : input.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

		System.out.println(map);
		Arrays.stream(input.split("")).collect(Collectors.toMap(Function.identity(), i -> 1, Integer::sum))
				.forEach((k, v) -> System.out.println(k + " -> " + v));

		/*
		 * List<Employee> list = Arrays.asList(new Employee("Rama", 26), new
		 * Employee("Ashok", 30));
		 * 
		 * list.sort((a, b) -> { if (a.name.compareTo(b.name) == 0) return a.age -
		 * b.age; else return a.name.compareTo(b.name); });
		 * 
		 * System.out.println(list);
		 * 
		 * List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		 * 
		 * Thread t1 = new Thread(() -> numbers.stream().filter(a -> a % 2 == 0)
		 * .forEach(a -> System.out.println(Thread.currentThread() + " " + a)), "T1");
		 * Thread t2 = new Thread(() -> numbers.stream().filter(a -> a % 2 == 1)
		 * .forEach(a -> System.out.println(Thread.currentThread() + " " + a)), "T21");
		 * t1.start(); t2.start();
		 */ }

}

class Employee {
	String name;
	int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}

}