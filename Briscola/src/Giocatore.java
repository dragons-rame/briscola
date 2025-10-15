import java.util.ArrayList;

public class Giocatore {
	private String nome;
	private ArrayList <Carta> carte = new ArrayList <>();
	private ArrayList <Carta> pozzo = new ArrayList <>();
	
	public Giocatore(String nome) {
		this.nome=nome;
	}
	public void inseriscipozzo(Carta c) {
		pozzo.add(c);
		
	}
	public void pescacarta(Carta c) {
		carte.add(c);
	}
	
	public String toString() {
		String carteinmano="";
		for(Carta c: carte) {
			carteinmano+= c + " ";
		}
		String carteinpozzo="";
		for(Carta c: pozzo) {
			carteinpozzo+= c + " ";
		}
		return "Giocatore [nome=" + nome + ", carte=" + carteinmano + " ,pozzo=" + carteinpozzo + "]";
	}
	public ArrayList<Carta> getPozzo() {
		return pozzo;
	}
	public String getNome() {
		return nome;
	}
	public ArrayList<Carta> getCarte() {
		return carte;
	}
	public Carta gettacarta(int i) throws CartaSbagliataException {
		try {
			return carte.remove(i);
		}catch (IndexOutOfBoundsException e) {
			throw new CartaSbagliataException ();
		}
	}

}
