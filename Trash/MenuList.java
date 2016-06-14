package it.unibs.ing.fp.library;

import java.util.List;

public class MenuList <T> {
	private List <T> lista;
	
	public void addNewObject(T obj) {
		lista.add(obj);
	}
	
	public boolean matchObject(T search) {
		for(T obj : lista) {
			if(obj.equals(search)) return true;
		}
		return false;
	}
	
	
	public void newObject(String msgNew, String msgExist, String exit) {
		boolean finish = false;
		do {
			String nameObject = InputData.readStringNotEmpty(msgNew);
			if(nameObject.equals(exit)) finish = true;
			else if(lista.matchObject(nameObject)) System.out.println(msgExist);
			else lista.addNewObject(new T(nameObject));
		} while (!finish);
	}
	 

}
