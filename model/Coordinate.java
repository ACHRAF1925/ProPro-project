/* (C) 2025 TUDA AI1 team - ProPro 2025 - Chess */
package tuda.ai1.propro25.model;

import java.util.Objects;

/**
 * Coordinates bzw. Koordinaten sind ein einfaches Datenpaar aus rank (Zeile)
 * und File (Linien)
 */
public final class Coordinate {
	private final int file;
	private final int rank;

	/**
	 * @param file
	 *            Spalte/Linie
	 * @param rank
	 *            Reihe/Zeile
	 */
	public Coordinate(int file, int rank) {
		this.file = file;
		this.rank = rank;
	}
	public int getFile() {
		return file;
	}

	public int getRank() {
		return rank;
	}
	
	/*
	 * Erstellen Sie in der Klasse Coordinate eine public Methode mit dem Namen getAlgebraicNotation(). Diese
		Methode soll einen String zurückgeben, der aus einem Buchstaben (für die Spalte) und einer Zahl (für die Zeile)
			besteht. Diese Darstellung eines Felds heißt algebraische (Schach)Notation1.
			Speichern Sie dazu die Buchstaben der Spalten ("a" bis "h") in einem Array vom Typ String. Dieses Array benötigen
	Sie, um den numerischen Spaltenwert (file) in den entsprechenden Buchstaben der algebraischen Schachnotation
	umzuwandeln. Verwenden Sie anschließend die Werte von file und rank, um die vollständige Notation zu erzeugen.
		 */
	public String getAlgebraicNotation() {
		String fileLetter;
		String[] fileLetters= { "a","b","c","d","e","f","g","h"};
		switch(file){
		case 1:
			fileLetter=fileLetters[0];
			break;
		case 2:
			fileLetter=fileLetters[1];
			break;
		case 3:
			fileLetter=fileLetters[2];
			break;
		case 4:
			fileLetter=fileLetters[3];
			break;
		case 5:
			fileLetter=fileLetters[4];
			break;
		case 6:
			fileLetter=fileLetters[5];
			break;
		case 7:
			fileLetter=fileLetters[6];
			break;
		case 8:
			fileLetter=fileLetters[7];
			break;
		default:
			fileLetter="wrong value entered";
		}
		
		String algebraicNotation=fileLetter + rank;
		return algebraicNotation;
	}
	

	/*
	 * Implementieren Sie in derselben Klasse eine Methode namens isOnBoard(). Diese Methode soll überprüfen, ob sich
		die Koordinate (gegeben durch file und rank) innerhalb des gültigen Schachbretts befindet, und entsprechend einen
		boolean-Wert zurückgeben.
		Verwenden Sie dabei ausschließlich die Konstante Board.BOARD_SIZE, um die Grenzen des Schachbretts zu definieren.
		Diese Konstante speichert die Anzahl an Spalten bzw. Reihen eines Bretts (also 8 beim normalen Schachbrett).
	 */
	public boolean isOnBoard() {
		if(this.file> Board.BOARD_SIZE || this.rank> Board.BOARD_SIZE) {
			return false;
		}
		return true;
	}

	/*
	 * Überschreiben Sie die Methode toString(), sodass sie die Koordinate im Format der algebraischen Schachnotation
		zurückgibt.
		Hinweis: Die Methode soll wirklich nur den Notations-String wie "e4" liefern, keine erklärenden Texte wie "Koordinate:
		e4".
	 */
	
	@Override
	public String toString() {
		String strToReturn= getAlgebraicNotation();
		return strToReturn;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		var that = (Coordinate) obj;
		return this.file == that.file && this.rank == that.rank;
	}

	@Override
	public int hashCode() {
		return Objects.hash(file, rank);
	}

}
