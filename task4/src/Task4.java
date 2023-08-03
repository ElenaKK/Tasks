import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.print(countSteps( getArrayFromFile(args[0])
					//new int[]{1, 14, 2, 9}
					));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static int countSteps(ArrayList<Integer> nums){
		int steps = 0;
		
		if (nums.size() > 0)
		{
			int avg;
			
		    double sum = 0;
		    for (int temp : nums) {
		         sum += temp;
		    }
		    avg = (int) Math.round(sum / nums.size());
		    
		    for(int temp : nums){
				steps += Math.abs(temp - avg);
			}
		    
		}		
		
		return steps;
	}
	
	static ArrayList<Integer> getArrayFromFile(String fileName) throws FileNotFoundException{
		
		Scanner s = new Scanner(new File(fileName));
		ArrayList<Integer> array = new ArrayList<Integer>();
		while(s.hasNext())
		    array.add(s.nextInt());
		s.close();
		
		return array;
	}

}
