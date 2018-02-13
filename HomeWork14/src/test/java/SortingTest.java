import com.app.ParallelSorter;
import org.junit.Test;
import java.util.Arrays;

public class SortingTest {

	private Integer[] testArray;


	private void prepareArray(int u) {
		testArray=new Integer[u];
		for(int i=0;i<testArray.length;i++){
			testArray[i]= (int)(Math.random()*1000000);
		}
	}

	@Test
	public void firstTest() {
		prepareArray(10);
		Integer[] copyArray=testArray.clone();
		Arrays.sort(copyArray);
		ParallelSorter.sort(testArray,1);
		assert(Arrays.equals(copyArray,testArray));
	}

	@Test
	public void secondTest() {
		prepareArray(103);
		Integer[] copyArray=testArray.clone();
		Arrays.sort(copyArray);
		ParallelSorter.sort(testArray,7);
		assert(Arrays.equals(copyArray,testArray));
	}

	@Test
	public void thirdTest() {
		testArray=new Integer[1];
		for(int i=0;i<testArray.length;i++){
			testArray[i]= 0;
		}
		Integer[] copyArray=testArray.clone();
		Arrays.sort(copyArray);
		ParallelSorter.sort(testArray,1);
		assert(Arrays.equals(copyArray,testArray));
	}
	@Test
	public void fourTest() {
		prepareArray(20);
		Integer[] copyArray=testArray.clone();
		Arrays.sort(copyArray);
		ParallelSorter.sort(testArray,45);
		assert(Arrays.equals(copyArray,testArray));
	}

}
