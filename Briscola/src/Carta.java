
public class Carta {
	public static enum Semi { BASTONI,DENARI,COPPE,SPADE};
	public static enum Numero { ASSO,DUE,TRE,QUATRO,CINQUE,SEI,SETTE,FANTE,CAVALLO,RE};
	private Semi seme;
	private Numero valore;
	public Carta(Semi seme,Numero valore) {
		this.seme=seme;
		this.valore=valore;
	}
	
	public Semi getSeme() {
		return seme;
	}

	public Numero getValore() {
		return valore;
	}

	public String toString() {
		return "Carta [seme=" + seme + ", valore=" + valore + "]";
	}
	
	
	
	
	
	
	

}
