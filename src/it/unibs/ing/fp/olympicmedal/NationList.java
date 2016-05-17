package it.unibs.ing.fp.olympicmedal;

import java.util.Vector;

public class NationList {
	private static final String NATION_FORMAT = "%s, ";
	private Vector <String> nations;
	
	public NationList() {
		nations = new Vector<String>();
	}
	
	public void addNewNation(String state) {
		nations.add(state);
	}
	
	/**
	 * 
	 * @param search
	 * @return 
	 */
	public boolean matchNation(String search) {
		for(String state : nations) {
			if(state.equalsIgnoreCase(search)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(String state : nations) {
			result.append(String.format(NATION_FORMAT, state));
		}
		return result.toString();
	}
}
