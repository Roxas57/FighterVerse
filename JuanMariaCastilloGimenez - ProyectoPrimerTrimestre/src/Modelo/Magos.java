package Modelo;

public class Magos extends Personaje {
	private int poderDefensaEspecial;
	private String Lore;
	
	public Magos(String nombre, int vida, int ataque, int defensa, int poderDefensaEspecial, String lore) {
		super(nombre, vida, ataque, defensa);
		this.poderDefensaEspecial = poderDefensaEspecial;
		this.Lore = lore;
	}
	
	public Magos() {
		super("", 0, 0, 0);
		this.poderDefensaEspecial = 0;
		this.Lore = "";
	}

	public int getPoderDefensaEspecial() {
		return poderDefensaEspecial;
	}

	public void setPoderDefensaEspecial(int poderDefensaEspecial) {
		this.poderDefensaEspecial = poderDefensaEspecial;
	}
	
	public String getLore() {
		return Lore;
	}

	public void setLore(String lore) {
		Lore = lore;
	}

	public boolean fakeEquals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "\nMago"+ super.toString() +"\nDefensaEspecial=" + poderDefensaEspecial + "\nLore del Personaje: "+Lore+
				"\n----------------------------------------------------------------------------------------------------------";
	}
}