package ch.mitti.mitarbeiter_kunden;

public class Chef extends Person{
	private int kaderstufe;
	private String abteilung;
	public Chef(String vorname, String nachname, int alter, int kaderstufe, String abteilung) {
		super(vorname, nachname, alter);
		this.kaderstufe = kaderstufe;
		this.abteilung = abteilung;
	}
	public Chef(String vorname, String nachname, int kaderstufe, String abteilung) {
		super(vorname, nachname);
		if(kaderstufe>0&&kaderstufe<6) this.kaderstufe = kaderstufe;
		else kaderstufe = 0;
		this.abteilung = abteilung;
	}
	public int getKaderstufe() {
		return kaderstufe;
	}
	public void setKaderstufe(int kaderstufe) {
		if (kaderstufe>0&&kaderstufe<6) this.kaderstufe = kaderstufe;
		else kaderstufe = 0;
	}
	public String getAbteilung() {
		return abteilung;
	}
	public void setAbteilung(String abteilung) {
		this.abteilung = abteilung;
	}
	
	public String datenAusgeben(){
		return (super.datenAusgeben()+"\nKaderstufe: "+kaderstufe+"\nAbteilung: "+abteilung);
	}
	
	
}
