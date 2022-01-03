import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {

		List<Employee2> list = new ArrayList<>(16);

		list.sort((a, b) -> {
			if (a.name.equals(b.name)) {
				if (a.age == b.age) {
					return a.phone - b.phone;
				} else
					return a.age - b.age;
			} else
				return a.name.compareTo(b.name);
		});
		
		

	}

}

class Employee2 {
	String name;
	int age;
	int phone;
}


/*SELECT A.CITY, E.AGE, COUNT(*)
FROM (
		SELECT
		CASE AGE:
			WHEN AGE<=10: "1 - 10"
				WHEN AGE<=10: "1 - 10"
		
		FROM 
		EMP
		
		) E




INNER JOIN ADDRESS A
ON E.ID = A.ID
GROUP BY A.CITY, E.AGE


HYD 1-10	10
HYD 11-20 	15
*/
 