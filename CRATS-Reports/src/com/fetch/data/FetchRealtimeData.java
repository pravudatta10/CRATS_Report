package com.fetch.data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FetchRealtimeData {

	public static void main(String[] args) {
		// Original list
        List<String> stringList = Arrays.asList("Lesson Learnt", "Model", "Data here", "Author", "Data here");

        // Assuming you have actual data stored in a list
        List<String> dataList = Arrays.asList("ABC", "EFG");

        // Counter for iterating through dataList
        int[] counter = {0};

        // Replace "Data here" with actual data from dataList using streams and lambda expressions
        List<String> modifiedList = stringList.stream()
                .map(str -> str.equals("Data here") ? dataList.get(counter[0]++) : str)
                .collect(Collectors.toList());

        // Output the modified list
        System.out.println(modifiedList);
	}

}
