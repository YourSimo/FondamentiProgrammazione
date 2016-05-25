package it.unibs.ing.fp.library;

public class Sort {
	Sortable [] list = null;
	
	public Sort(Sortable [] list) {
		this.list = list.clone();
	}
	
	private int indexMin(int startPoint) {
		int minPosition = startPoint, currentPosition = startPoint + 1;
		  
		while (currentPosition < list.length) {
			if(list[currentPosition].lessThan(list[minPosition])) minPosition = currentPosition;
			currentPosition++;
		}
		return minPosition;
	}

	public Sortable [] selectionSortA_Z() {
		for (int i = 0; i < list.length - 1; i++) {
			int minPositionOfRemainder = indexMin(i);
		    Sortable tmp = list[i];
			list[i] = list[minPositionOfRemainder];
			list[minPositionOfRemainder] = tmp;
		}
		return list;	 
	}
}
