import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;

/**
 * 
 */

/**
 * @author ben
 * 
 */
public class TestJSONParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test3();
	}

	public static void test2() {
		String jsonstr = "{\"firstName\": \"John\",     \"lastName\": \"Smith\",     \"sex\": \"third\",     \"age\": 25     }";
		StringReader sr = new StringReader(jsonstr);
		JSONObject res = null;
		try {
			res = JSONParser.parse(sr);
			display(res, "");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void test1() {
		String filePath = "jsonexp.txt";
		JSONObject res = null;
		try {
			res = JSONParser.parse(filePath);
			display(res, "");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void test3() {
		String filePath = "jsonexp.txt";
		JSONObject res = null;
		try {
			res = JSONParser.parse(filePath);
			System.out.println(res.getAllNames().length);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public static void display(JSONObject json, String pre) {
		String[] names = json.getAllNames();
		String ppre = pre + "\t";
		String pppre = ppre + "\t";
		System.out.println(pre + "{");
		for (String n : names) {
			System.out.println();
			Object v = json.getValue(n);
			System.out.println(ppre + "name: " + n);
			System.out.print(ppre + "value: ");
			if(v instanceof String) {
				System.out.println("<String>" + v.toString());
			} else if(v instanceof Integer) {
				System.out.println("<Integer>" + v.toString());
			} else if(v instanceof JSONObject) {
				System.out.println();
				display((JSONObject)v, ppre);
			} else if(v.getClass().isArray()){
				Object[] arr = (Object[]) v;
				System.out.println();
				System.out.println(ppre + "[");
				for(Object b : arr) {
					if(b instanceof JSONObject) {
						display((JSONObject)b, pppre);
					} else {
						System.out.println(pppre + b.toString());
					}
				}
				System.out.println(ppre + "]");
			}
			System.out.println();
		}
		System.out.println(pre + "}");
	}

}
