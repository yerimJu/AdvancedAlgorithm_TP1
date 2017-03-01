
public class SelectionSort {
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

	public static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static int minimumIndex(int[] data, int begin, int end) {
		int res = begin;
		for (int i = begin + 1; i != end; ++i) {
			if (data[i] < data[res]) {
				res = i;
			}
		}
		return res;
	}

	public static void sort(int[] data) {
		if (data.length < 2) 
			return;

		for (int i = 0; i != data.length - 1; ++i)
			swap(data, i, minimumIndex(data, i, data.length));
	}
}
