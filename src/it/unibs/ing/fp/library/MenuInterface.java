package it.unibs.ing.fp.library;

public interface MenuInterface <T> {
	
	
	
	public void addObject(T obj);
	public boolean matchObject(T search);
	
	/*
	public boolean matchObject(T search) {
		for(
	 */
	
	public void removeObject(T obj);
	public boolean isEmpty();
	public T choiceObject(String question);
}
