package Modelo;

public class Guerreros extends Personaje {
	private int poderAtaqueEspecial;
	private String Lore;

	public Guerreros(String nombre, int vida, int ataque, int defensa, int poderAtaqueEspecial, String lore) {
		super(nombre, vida, ataque, defensa);
		this.poderAtaqueEspecial = poderAtaqueEspecial;
		this.Lore = lore;
	}
	
	public Guerreros() {
		super("", 0, 0, 0);
		this.poderAtaqueEspecial = 0;
		this.Lore = "";
	}

	public int getPoderAtaqueEspecial() {
		return poderAtaqueEspecial;
	}

	public void setPoderAtaqueEspecial(int poderAtaqueEspecial) {
		this.poderAtaqueEspecial = poderAtaqueEspecial;
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
		return "\nGuerrero"+ super.toString() +"\nAtaqueEspecial=" + poderAtaqueEspecial + "\nLore del Personaje: "+Lore+
				"\n----------------------------------------------------------------------------------------------------------";
	}
}