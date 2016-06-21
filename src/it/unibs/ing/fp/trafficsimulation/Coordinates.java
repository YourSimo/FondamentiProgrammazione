package it.unibs.ing.fp.trafficsimulation;

public class Coordinates {
	private int line;
	private int column;
	
	public Coordinates(int line, int column) {
		this.line = line;
		this.column = column;
	}
		
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}

	public boolean isInside(int maxLine, int maxColumn) {
		return (line < maxLine) && (column < maxColumn);
	}

	public String toString() {
		return "RIGA:" + (line + 1) + ";COLONNA:" + (column + 1);
	}
}
