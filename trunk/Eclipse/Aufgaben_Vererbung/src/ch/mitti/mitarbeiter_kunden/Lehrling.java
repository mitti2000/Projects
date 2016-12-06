package ch.mitti.mitarbeiter_kunden;

public class Lehrling extends Person{
	private int aktuellesLehrjahr;
	private int anzahlLehrjahre;
	public Lehrling(String vorname, String nachname, int alter, int aktuellesLehrjahr, int anzahlLehrjahre) {
		super(vorname, nachname, alter);
		this.aktuellesLehrjahr = aktuellesLehrjahr;
		this.anzahlLehrjahre = anzahlLehrjahre;
	}
	public Lehrling(String vorname, String nachname, int aktuellesLehrjahr, int anzahlLehrjahre) {
		super(vorname, nachname);
		this.aktuellesLehrjahr = aktuellesLehrjahr;
		this.anzahlLehrjahre = anzahlLehrjahre;
	}
	public int getAktuellesLehrjahr() {
		return aktuellesLehrjahr;
	}
	public void setAktuellesLehrjahr(int aktuellesLehrjahr) {
		this.aktuellesLehrjahr = aktuellesLehrjahr;
	}
	public int getAnzahlLehrjahre() {
		return anzahlLehrjahre;
	}
	public void setAnzahlLehrjahre(int anzahlLehrjahre) {
		this.anzahlLehrjahre = anzahlLehrjahre;
	}
	
	public String datenAusgeben(){
		return (super.datenAusgeben()+"\nAnzahl Lehrjahre: "+ anzahlLehrjahre+"\nAktuelles Lehrjahr: "+aktuellesLehrjahr);
		}
	
}
