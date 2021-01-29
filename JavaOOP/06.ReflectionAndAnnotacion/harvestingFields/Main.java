package harvestingFields;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		//за да е по-бързо може и
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(System.in);
		Class<RichSoilLand> clazz = RichSoilLand.class;//взимаме всички полета на класа

		//така взимаме всички полета на класа (getDeclaredField връща всички,а getFields само public
		Set<Field> fields = Arrays.stream(clazz.getDeclaredFields()).collect(Collectors.toCollection(LinkedHashSet::new));

		//String input = reader.readLine()
		StringBuilder output = new StringBuilder();
		String input = scanner.nextLine();
		while (!input.equals("HARVEST")){
			String modifier = input;

			fields.stream().filter(f ->
					Modifier.toString(f.getModifiers()).equals(modifier) || modifier.equals("all"))
					.forEach(f -> System.out.printf("%s %s %s%n",
							Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName()));
			/*печатането е бавна операция и за да не печатим всеки път може да използваме StringBuilder
			fields.stream().filter(f ->
					Modifier.toString(f.getModifiers()).equals(modifier) || modifier.equals("all"))
					.forEach(f -> output.append(String.format("%s %s %s%n",
							Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName())));


			switch (input){
				пускаме switch по възможните команди и след това stream по Set с полета като ги филтрираме
				и после печатим,за да им вземем името на modifier трябва да е с Modifier.toString() който приема int
				f.getModifiers() връща int за modifier (примерно 1)
				case "private":
					fields.stream()
							.filter(f -> Modifier.isPrivate(f.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n" ,
									Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName()));
					break;
				case "protected":
					fields.stream()
							.filter(f -> Modifier.isProtected(f.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n" ,
									Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName()));
					break;
				case "public":
					fields.stream()
							.filter(f -> Modifier.isPublic(f.getModifiers()))
							.forEach(f -> System.out.printf("%s %s %s%n" ,
									Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName()));
					break;
				case "all":
					fields.forEach(f -> System.out.printf("%s %s %s%n",
							Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName()));
					break;
			} */
			//input = reader.readLine();
			input = scanner.nextLine();
		}
	}
}
