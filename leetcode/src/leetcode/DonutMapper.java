package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DonutMapper {
	static String[][] matchDonuts(String[][] donutConstraintPairs, String[][] candidateConstraintPairs) {
		if (donutConstraintPairs == null || donutConstraintPairs.length == 0)
			return null;
		if (candidateConstraintPairs == null || candidateConstraintPairs.length == 0)
			return null;
		Map<String, List<String>> donutTypeMapping = new HashMap<>();
		//Each donut in the list belongs to exactly one type
        //Does that mean each donut is unique, but one type could be mapped to n donut?
		List<String> allTypes = new ArrayList<String>();
		for (String[] donutConstraintPair : donutConstraintPairs) {
			if (donutTypeMapping.containsKey(donutConstraintPair[1])) {
				donutTypeMapping.get(donutConstraintPair[1]).add(donutConstraintPair[0]);
			} else {
				List<String> donuts = new ArrayList<>();
				donuts.add(donutConstraintPair[0]);
				donutTypeMapping.put(donutConstraintPair[1], donuts);
			}
			allTypes.add(donutConstraintPair[0]);
		}
		donutTypeMapping.put("*", allTypes);
		List<String[]> results = new ArrayList<>();
		for (String[] candidatePreference : candidateConstraintPairs) {
			String candidate = candidatePreference[0];
			String preference = candidatePreference[1];
			if (donutTypeMapping.containsKey(preference)) {
				for (String donut : donutTypeMapping.get(preference)) {
					results.add(new String[] { candidate, donut });
				}
			}
		}
		Collections.sort(results, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int i = o1[0].compareTo(o2[0]);
				if (i == 0) {
					return o1[1].compareTo(o2[1]);
				} else {
					return i;
				}
			}

		});
		return (String[][]) results.toArray(new String[results.size()][]);
	}

}
