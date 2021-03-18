package harvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		StringBuilder sb = new StringBuilder();
		String command = reader.readLine();
		while (!command.equals("HARVEST")){
			String modifier = command;
			Arrays.stream(fields).filter(f ->
					Modifier.toString(f.getModifiers()).equals(modifier) || modifier.equals("all"))
					.forEach(f -> System.out.printf("%s %s %s%n",
							Modifier.toString(f.getModifiers()) , f.getType().getSimpleName() , f.getName()));
//			if (modifier.equals("all")){
//				Arrays.stream(methods).forEach(f -> sb.append(f.toString()).append(System.lineSeparator()));
//			} else {
//				Arrays.stream(methods).filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
//						.forEach(f -> sb.append(String.format("%s %s %s", Modifier.toString(f.getModifiers()) ,
//								f.getType().getSimpleName() , f.getName())).append(System.lineSeparator()));
//			}
			command = reader.readLine();
		}
		System.out.println(sb);
	}
}
