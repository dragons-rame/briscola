import java.util.ArrayList;
import java.util.Collections;

public class Mazzo {
	private ArrayList<Carta> carte = new ArrayList<>(); 
	
	public Mazzo() {
		for (int i=0;i<4;i++) {
			for (int j=0;j<10;j++) {
				Carta c=new Carta(Carta.Semi.values()[i],Carta.Numero.values()[j]);
				carte.add(c);
			}
		}
		Collections.shuffle(carte);
	}
	
	public Carta pescacarta() throws CarteFiniteException {
		try {
			return carte.remove(0);
		}catch (IndexOutOfBoundsException e) {
			throw new CarteFiniteException ();
		}
	}

}
