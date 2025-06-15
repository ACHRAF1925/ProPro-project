/* (C) 2025 TUDA AI1 team - ProPro 2025 - Chess */
package tuda.ai1.propro25.model;

import java.util.Objects;

/**
 * Player repräsentiert die Spieler, welche Schach spielen. Ein Spieler muss
 * dabei nicht unbedingt menschlich sein
 */
public class Player {

	/*
	 * Wir beschäftigen uns nun mit der Spielerklasse Player.
	Erstellen Sie darin zunächst drei private Instanzvariablen: name vom Typ String, color vom Typ Color und
	remainingMilliseconds vom Typ int. Die Variablen name und color sollen final sein, da sie nach der Initialisierung
	nicht mehr verändert werden
	 */ 
	
	private final String name;
	private final Color color;
	private int remainingMilliseconds;
	

	/*
	 * Erstellen Sie anschließend einen Konstruktor der Klasse Player mit den Parametern name, color und remainingTime.
		Diese Parameter sind vom Typ String, Color bzw. int. Dieser soll die Datenfelder name, color und
		remainingMilliseconds mit den übergebenen Parametern initialisieren.
		
	/*
	 * Prüfen Sie zusätzlich, ob die übergebenen Parameter gültige Werte besitzen. Falls ein Parameter ungültig ist, werfen
		Sie eine IllegalArgumentException mit einer sinnvollen Fehlermeldung.
		Eine Eingabe gilt als ungültig, wenn:
		• name: gleich null oder ein leerer String ist,
		• color: gleich null ist,
		• remainingTime: kleiner als 0 ist.
		Hinweis: Der Parameter remainingTime wird in Millisekunden übergeben, z. B. 60000 entspricht einer Minute.
	 */
	

	public Player(String name, Color color,int remainingTime) throws Exception{
		if(name == null || name=="" || color==null || remainingTime <0) {
			if(name == null || name=="" )
				throw new Exception("invalid name");
			else if(color==null)
				throw new Exception("invalid color");
			else
				throw new Exception("invalid remaining time");
		}
		this.name=name;
		this.color=color;
		remainingMilliseconds=remainingTime;
		
	}
	
	public String getName() {
		return name;
	}
	public Color getColor() {
		return color;
	}
	public int getRemainingTime() {
		return remainingMilliseconds;
	}
	
	/*
		 * Erstellen Sie eine Methode setRemainingTime(int time). Diese Methode soll die verbleibende Spielzeit aktualisieren.
	Der im Parameter übergebene Wert wird in Millisekunden erwartet und direkt im Datenfeld
	remainingMilliseconds gespeichert.
	Überprüfen Sie vor dem Setzen, ob der übergebene Wert gültig ist. Falls der Parameter negativ ist, soll eine
	IllegalArgumentException mit einer aussagekräftigen Fehlermeldung geworfen werden.
		 */
	public void setRemainingTime(int time) throws Exception {
		if(time<0) {
			throw new Exception("Time can not be negative");
		}
		remainingMilliseconds = remainingMilliseconds + time;
	}
	/**
	 * Verringert die verbleibende Zeit des Spielers um die angegebene Dauer in
	 * Millisekunden.
	 *
	 * @param duration
	 *            Die zu subtrahierende Zeit in Millisekunden.
	 * @throws IllegalArgumentException
	 *             wenn die verbleibende Zeit dadurch negativ würde.
	 */
	public void reduceRemainingMilliseconds(int duration) {
		if (remainingMilliseconds < duration) {
			throw new IllegalArgumentException("Die verbleibende Zeit darf nicht negativ werden!");
		}
		this.remainingMilliseconds -= duration;
	}

	
	/*
		 * Vervollständigen Sie die Methode equals(Object o) in der Klasse Player, sodass zwei Player-Objekte als gleich
	gelten, wenn sie denselben Namen, dieselbe Farbe und dieselbe verbleibende Spielzeit haben.
	• Zwei Objekte können nur dann gleich sein, wenn sie derselben Klasse angehören.
	• Vergleichen Sie die Werte der Attribute name, color und remainingMilliseconds.
	• Verwenden Sie zum Vergleich von Objekten wie name die Methode Objects.equals(...).
	• Der Parameter o kann null sein – beachten Sie dies in Ihrer Implementierung. Werfen Sie in diesem Fall keine
	Exception.
	Hinweis: Überlegen Sie, wie das übergebene Objekt o in ein Player-Objekt umgewandelt werden kann.
	 */
	@Override
	public boolean equals(Object o) {
		if(o==null || o.getClass() != this.getClass()) {
			return false;
		}
		Player p= (Player) o;
		if(p.name.equals(this.name) || p.color.equals(this.color) || p.remainingMilliseconds != this.remainingMilliseconds ) {
			return false;
			 
		 }
		
		return p.name.equals(this.name) && p.color.equals(this.color) && p.remainingMilliseconds == this.remainingMilliseconds ;
	}

	@Override
	public int hashCode() {
		int result = Objects.hashCode(name);
		result = 31 * result + Objects.hashCode(color);
		result = 31 * result + remainingMilliseconds;
		return result;
	}

	@Override
	public String toString() {
		return "Player{" + "name='" + name + '\'' + ", color=" + color + ", remainingMilliseconds="
				+ remainingMilliseconds + '}';
	}
}
