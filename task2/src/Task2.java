import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {
	
	public static int INSIDE = 1;
	public static int ON_CIRCLE = 0;
	public static int OUTSIDE = 2;
	public static String NO_CIRCLE_PARAMETERS = "ќтсутствуют координаты центра или радиус окружности";
	public static String NO_FILENAMES = "¬ведите имена файлов"; 

	public static void main(String[] args) {
		
		try {
			doDetermination(args[0], args[1]);
		} 
		catch (NoSuchElementException e) {
			
			System.out.println(e.getMessage());
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println(NO_FILENAMES);
		}

	}
	
	public static ArrayList<Point> getPointsFromFile(String fileName) throws FileNotFoundException{
		Scanner s = new Scanner(new File(fileName));
		ArrayList<Point> array = new ArrayList<Point>();
		
		while(s.hasNext())
		    array.add(new Point(s.nextFloat(), s.nextFloat()));
		
		s.close();
		
		return array;
	}
	
	public static ArrayList<Integer> determinePositions(Point centre, float radius, ArrayList<Point> points){
		float distance;
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(Point point : points){
			distance = (float)Math.pow((Math.pow(point.getX() - centre.getX(), 2) + Math.pow(point.getY() - centre.getY(), 2)), 0.5); 
			if(distance < radius)
				array.add(INSIDE);
			else if(distance == radius)
				array.add(ON_CIRCLE);
			else 
				array.add(OUTSIDE);
			
		}
		
		return array;
	}
	
	public static void doDetermination(String file1, String file2) throws FileNotFoundException, NoSuchElementException{
		Scanner s = new Scanner(new File(file1));
		Point centr;
		float rad;
		
		if(!s.hasNext()){
			s.close();
			
			throw new NoSuchElementException(NO_CIRCLE_PARAMETERS);
		}
		
		centr = new Point(s.nextFloat(), s.nextFloat());
		rad = s.nextFloat();
		

		s.close();
		
		ArrayList<Point> points = getPointsFromFile(file2);
		
		ArrayList<Integer> res = determinePositions(centr, rad, points);
		
		for(Integer r : res)
			System.out.println(r);
	}

}
