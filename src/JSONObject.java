import java.util.ArrayList;

/**
 * 
 */

/**
 * @author ben
 * 
 */
public final class JSONObject {

	private ArrayList<JSONCollection> nvpairs = new ArrayList<JSONCollection>();
	
	public boolean addPair(JSONCollection nvp) {
		this.nvpairs.add(nvp);
		return true;
	}
	
	public Object getValue(String name) {
		for(JSONCollection col : nvpairs) {
			if(col.name.equals(name)) {
				return col.value;
			}
		}
		return null;
	}
	
	/**
	 * @return 所有name
	 */
	public String[] getAllNames() {
		int len = nvpairs.size();
		String[] ret = new String[len];
		for(int i = 0; i < len; i++) {
			ret[i] = nvpairs.get(i).name;
		}
		return ret;
	}
	
	public int size() {
		return nvpairs.size();
	}

}
