import java.util.*;


public class Briscola {
	private final static Scanner sca= new Scanner(System.in);
	public static void main(String[] args) throws CarteFiniteException, CartaSbagliataException {
		
		int var;
		while (true) {
			System.out.println("benvenuto nell menu");
			System.out.println("clicca 1: per giocare");
			System.out.println("clicca 2: per uscire");
			var=sca.nextInt();
			switch (var) {
			case 1:
				Mazzo m=new Mazzo();
				partita(m);
				
				
				
				break;
			
			case 2:
				
				return;

			default:
				break;
			}
		}
	}

	private static void partita(Mazzo m) throws CarteFiniteException, CartaSbagliataException {
		Giocatore giocatore1= new Giocatore("giocatore1");
		Giocatore giocatore2= new Giocatore("giocatore2");
		for (int i = 0;i<3;i++) {
			giocatore1.pescacarta(m.pescacarta());
			giocatore2.pescacarta(m.pescacarta());
			
		}
		Carta briscola= m.pescacarta();
		mano(giocatore1,giocatore2,briscola,m);
		int puntig1=conteggio(giocatore1.getPozzo());
		int puntig2=conteggio(giocatore2.getPozzo());
		System.out.println("punteggio finale");
		System.out.println("giocatore1: " +puntig1+ " " + "giocatore2: " +puntig2);
		if (puntig1> puntig2) {
			System.out.println("giocatore1 ha vinto");
		} else if (puntig1== puntig2) {
			System.out.println("è parita con " + puntig1+ "punti");
		} else {
			System.out.println("il giocatore 2 ha vinto");
		}
		
	}
	private static void mano(Giocatore g1,Giocatore g2,Carta briscola,Mazzo m) throws CartaSbagliataException {
		System.out.println(g1);
		System.out.println(g2);
		
		System.out.println("briscola: " + briscola);
		System.out.println("scegli la carta che deve giocare "+g1.getNome() );
		int mossag1=sca.nextInt();
		System.out.println("scegli la carta che deve giocare " + g2.getNome() );
		int mossag2=sca.nextInt();
		
		Carta cg1 = g1.gettacarta(mossag1);
		Carta cg2 = g2.gettacarta(mossag2);
		boolean g1win=true;
		
		if(cg1.getSeme().equals(cg2.getSeme())) {
			if(prelevanumero(cg1)> prelevanumero(cg2)) {
				g1.inseriscipozzo(cg1);
				g1.inseriscipozzo(cg2);
				
			}
			else {
				g2.inseriscipozzo(cg1);
				g2.inseriscipozzo(cg2);
				g1win=false;
				
			}
		}
		else {
			if(cg1.getSeme().equals(briscola)) {
				g1.inseriscipozzo(cg1);
				g1.inseriscipozzo(cg2);
				
			}
			else if(cg2.getSeme().equals(briscola)) {
				g2.inseriscipozzo(cg1);
				g2.inseriscipozzo(cg2);
				g1win=false;
			}
			else {
				g1.inseriscipozzo(cg1);
				g1.inseriscipozzo(cg2);
			}
		}
		
		
		
		if(g1.getCarte().size()!=0) {
			if (g1win) {
				System.out.println( g1.getNome() +" vince la mano");
				try {
					g1.pescacarta(m.pescacarta());
					g2.pescacarta(m.pescacarta());
				} catch (CarteFiniteException e) {
					System.out.println(e.getMessage());
				}
				mano(g1,g2,briscola,m);
			} else {
				System.out.println( g2.getNome() +"  vince la mano");
				try {
					g2.pescacarta(m.pescacarta());
					g1.pescacarta(m.pescacarta());
				} catch (CarteFiniteException e) {
					System.out.println(e.getMessage());
				}
				mano(g2,g1,briscola,m);
			}
			
			
		
		}
		
	}
	private static int conteggio (ArrayList <Carta> pozzo) {
		int ris=0;
		for(Carta c: pozzo) {
			if(c.getValore().equals(Carta.Numero.ASSO)) {
				ris += 11;
			} else if(c.getValore().equals(Carta.Numero.RE)) {
				ris += 4;
			} else if(c.getValore().equals(Carta.Numero.FANTE)) {
				ris += 2;
			} else if(c.getValore().equals(Carta.Numero.CAVALLO)) {
				ris += 3;
			} else if(c.getValore().equals(Carta.Numero.TRE)) {
				ris += 10;
			} 
			
		}
		return ris;
	}
	private static int prelevanumero(Carta c) {
		if(c.getValore().equals(Carta.Numero.ASSO)) 
			return 1;
		else if (c.getValore().equals(Carta.Numero.DUE)) 
			return 2;
		else if (c.getValore().equals(Carta.Numero.TRE)) 
			return 3;
		else if (c.getValore().equals(Carta.Numero.QUATRO)) 
			return 4;
		else if (c.getValore().equals(Carta.Numero.CINQUE)) 
			return 5;
		else if (c.getValore().equals(Carta.Numero.SEI)) 
			return 6;
		else if (c.getValore().equals(Carta.Numero.SETTE)) 
			return 7;
		else if (c.getValore().equals(Carta.Numero.FANTE)) 
			return 8;
		else if (c.getValore().equals(Carta.Numero.CAVALLO)) 
			return 9;
		else if (c.getValore().equals(Carta.Numero.RE)) 
			return 10;
		
		return -1;
		
	}
	

}
