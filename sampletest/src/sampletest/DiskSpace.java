package sampletest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DiskSpace {

	public static void main(String[] args) {
		
		System.out.println(isWritable(4	, 2, new HashSet<>(Arrays.asList(1,4))));
		System.out.println(isWritable(1, 1, new HashSet<>()));
		System.out.println(isWritable(1, 1, new HashSet<>(Arrays.asList(1))));
	}
	public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {

		int[] arr = new int[blockSize + 1];
		if (blockSize == 1 && fileSize <= blockSize) {
			if (occupiedSectors.isEmpty())
				return true;
			return false;
		}

		for (int i = 1; i < arr.length; i++) {
			if (occupiedSectors.contains(i))
				arr[i] = 1;
		}

		int counter = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == 0) {
				counter++;
				if (counter >= fileSize) {
					return true;
				}
			} else
				counter = 0;
		}
		return false;
	}
}
