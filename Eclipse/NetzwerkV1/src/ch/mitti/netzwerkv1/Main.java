package ch.mitti.netzwerkv1;

public class Main {
	
	public static void main(String[] args) {
		NewsFeed newsfeed = new NewsFeed();
		FotoEinsendung fotoEinsendung1 = new FotoEinsendung("Fritz", "foto1.jpg", "Vogel");
		FotoEinsendung fotoEinsendung2 = new FotoEinsendung("Hans", "foto2.jpg", "Hund");
		NachrichtenEinsendung nachrichtenEinsendung1 = new NachrichtenEinsendung("Jean-Pierre", "Trump ist Pr�sident");
		NachrichtenEinsendung nachrichtenEinsendung2 = new NachrichtenEinsendung("Obama", "So ein Scheiss");
		
		newsfeed.erfasseEinsendung(fotoEinsendung1);
		newsfeed.erfasseEinsendung(fotoEinsendung2);
		newsfeed.erfasseEinsendung(nachrichtenEinsendung1);
		newsfeed.erfasseEinsendung(nachrichtenEinsendung2);
		
		newsfeed.zeigen();
		
		fotoEinsendung1.gefaellt();
		fotoEinsendung1.gefaellt();
		fotoEinsendung1.gefaellt();
		fotoEinsendung1.gefaellt();
		fotoEinsendung2.gefaellt();
		fotoEinsendung2.gefaellt();
		
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaellt();
		nachrichtenEinsendung1.gefaelltNicht();
		nachrichtenEinsendung1.gefaelltNicht();
		
		newsfeed.zeigen();
		
	}

}
