
public class MergeSort {
	public static void main(String[] args) {
		Randomdata rd = new Randomdata();
		int[] result = rd.generate1d(10, 0, 500);
		
		System.out.println("Before Sorting :");
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		
		sort(result);
		System.out.println("\nAfter Sorting :");
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}
	
	public static void mergeSorted(int data[], int begin, int middle, int end) {
		int[] tmp = new int[middle - begin];
		System.arraycopy(data, begin, tmp, 0, tmp.length);
		int i = 0, j = middle, dest = begin;
		while ((i < tmp.length) && (j < end)) {
			data[dest++] = (tmp[i] < data[j]) ? tmp[i++] : data[j++];
		}
		while (i < tmp.length) {
			data[dest++] = tmp[i++];
		}
	}

	public static void sort(int[] data) {
		sort(data, 0, data.length);
	}

	public static void sort(int[] data, int begin, int end) {
		if ((end - begin) < 2) {
			return;
		}
		int middle = (end + begin) / 2;
		sort(data, begin, middle);
		sort(data, middle, end);
		mergeSorted(data, begin, middle, end);
	}
}
