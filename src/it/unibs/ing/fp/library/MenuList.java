package it.unibs.ing.fp.library;

public interface MenuList {
	//	public abstract void addObject(Object obj);
	//	public abstract boolean matchObject(String search);
	
	public void removeObject(Object obj);
	public boolean isEmpty();
	public Object choiceObject(String question);
}
