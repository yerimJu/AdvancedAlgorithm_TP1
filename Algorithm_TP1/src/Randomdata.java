
import java.util.Random;

public class Randomdata {
	public static int[] generate1d(int nbVals, int min, int max) {
		int[] res = new int[nbVals];
		Random generator = new Random();
		for (int i = 0; i != nbVals; ++i) {
			if (max!=min)
				res[i] = (int) ((generator.nextLong() % ((long) max - min)) + min);
			if (res[i] < 0)
				res[i] *= -1;
		}
		return res;
	}

	public int MinData(int[] tabrd) {
		int min = tabrd[0];
		for (int j = 0; j < tabrd.length; j++) {
			if (tabrd[j] < min) {
				min = tabrd[j];
			}
		}
		return min;
	}
}