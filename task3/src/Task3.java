import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;


public class Task3 {
	
	public static String testsFileName = "tests.json";
	public static String valuesFileName = "values.json";
	public static String reportFileName = "report.json";

	static class Tests{
		List<Test> tests;
		
//		public Tests(){
////			tests = new ArrayList<Test>();
//		}
		
		void fillValues(Map<Integer, String> values){
			for(Test test : this.tests)
				test.fillValues(values);
		}
	} 
	
	static class Test{
		int id;
		String title;
		String value;
		List<Test> values;
		
		public void setValue(String value){
			this.value = value;
		}

		void fillValues(Map<Integer, String> values){
			this.value = values.get(this.id);
			
			if (this.values != null)
				for(Test test : this.values)
					test.fillValues(values);
		}
	}
	
	static class Values{
		List<Value> values;
		
		public Map<Integer, String> listToMap(){
			Map<Integer, String> map = new HashMap<Integer, String>();
			for (Value val : values)
				map.put(val.id, val.value);
			
			return map;
		}
	}
	
	static class Value{
		int id;
		String value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			fillReport();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void fillReport() throws JsonParseException, IOException{
		Gson g = new Gson();
		Tests tests = g.fromJson(new FileReader(testsFileName), Tests.class);
		//ArrayList<Value> values = g.fromJson(new FileReader(valuesFileName), ArrayList<Value>.class);
		
		Gson gson = new Gson();
		Values values = g.fromJson(new FileReader(valuesFileName), Values.class);
		
		tests.fillValues(values.listToMap());
		
//		System.out.println(gson.toJson(tests, Tests.class));
		
		Gson gs = new Gson();
		FileWriter fw = new FileWriter(reportFileName);
		fw.write(gs.toJson(tests, Tests.class));
		fw.close();
		
	}
}
