import java.util.*;

public class SampleProgram {

	public static void main(String args[]) {
		String[] names =  {"John", "Martin"};
		boolean[] statuses = {false, false};
		int[] projects = {10, 9};
		int[] tasks = {10, 9};
		
		System.out.println(smartAssigning(names, statuses, projects, tasks));
	}

	static String smartAssigning(String[] names, boolean[] statuses, int[] projects, int[] tasks) {

		ArrayList<String> namesList = new ArrayList<>(Arrays.asList(names));
		HashMap<String, Integer> taskMap = new HashMap<String, Integer>();
		HashMap<String, Integer> projectMap = new HashMap<String, Integer>();

		// filter members, maintain maps
		for (int i = statuses.length - 1; i >= 0; i--) {
			if (!statuses[i]) {
				taskMap.put(namesList.get(i), tasks[i]);
				projectMap.put(namesList.get(i), projects[i]);
			} else {
				namesList.remove(i);
			}
		}

		if(namesList.size() == 1)
			return namesList.get(0);
		
		// sort the namesList based on tasksList
		Collections.sort(namesList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(taskMap.get(o1), taskMap.get(o2));
			}

		});
		
		String name1 = namesList.get(0);
		String name2 = namesList.get(1);
		
//		System.out.println(name1 + "|" + name2);
//		System.out.println(taskMap.get(name1) + "|"+taskMap.get(name2));
//		System.out.println(projectMap.get(name1)+"|"+projectMap.get(name2));

		if (taskMap.get(name1) < taskMap.get(name2)) {
			return name1;
		} else if (projectMap.get(name1) < projectMap.get(name2)) {
			return name1;
		} else {
			return name2;
		}

	}

}
