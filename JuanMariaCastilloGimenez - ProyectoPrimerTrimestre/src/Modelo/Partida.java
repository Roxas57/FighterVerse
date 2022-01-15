package Modelo;

import java.util.Arrays;

import Controlador.Metodos;

public class Partida {
	private Personaje[] plantel;

	public Partida(int nPersonaje) {
		super();
		plantel = new Personaje[nPersonaje];
	}

	public Partida(Personaje[] personajes) {
		super();
		this.plantel = personajes;
	}

	@Override
	public String toString() {
		return "Plantel: \n" + Arrays.toString(plantel);
	}

	public void insertaPersonaje(Personaje a) {
		if (!this.isFull()) {
			if (a != null) {
				if (this.existePersonaje(a) == -1) {
					for (int i = 0; i < plantel.length; i++) {
						if (plantel[i] == null) {
							plantel[i] = a;
							i = plantel.length;
						}
					}
				} else {
					System.out.println("El personaje " + a.getNombre() + " ya está en el plantel");
				}
			} else {
				System.out.println("El personaje a insertar está vacío");
			}
		} else {
			System.out.println("Personaje no introducido,");
		}
	}

	/**
	 * Devuelve la posición en el array plantel del lugar que ocupa el personaje
	 * pasado como argumento
	 * @param a: objeto personaje que quiero buscar en el array
	 * @return -1 si no encuentra el personaje, o la posicion del personaje en el
	 *         array si lo encuentra
	 */
	public int existePersonaje(Personaje a) {
		int pos = -1;
		for (int i = 0; i < plantel.length; i++) {
			if (plantel[i] != null && plantel[i].equals(a)) {
				pos = i;
				i = plantel.length;
			}
		}
		return pos;
	}

	public boolean isFull() {
		boolean full = true;
		for (Personaje a : plantel) {
			if (a == null) {
				full = false;
			}
		}
		return full;
	}

	/**
	 * Método que elimina el personaje derrotado en combate a través del nombre pasado como atributo
	 * @param a: nombre del personaje que quiero eliminar
	 * @return el objeto personaje eliminado o null si el personaje no existe
	 */
	public Personaje eliminaPersonaje(Personaje a) {
		Personaje dev = new Personaje();
		if (this.existePersonaje(a) >= 0) {
			dev = this.plantel[this.existePersonaje(a)];
			this.plantel[this.existePersonaje(a)] = null;
			System.out.println("El personaje " + a.getNombre() + " está fuera de combate");
		}
		return dev;
	}

	/**
	 * Metodo que elimina el personaje del array que elige el jugador1 a través del nombre pasado como atributo 
	 * @param a: nombre del personaje que quiero eliminar
	 * @return el objeto personaje eliminado o null si el personaje no existe
	 */
	public Personaje eliminaSeleccion(Personaje a) {
		Personaje dev = new Personaje();
		if (this.existePersonaje(a) >= 0) {
			dev = this.plantel[this.existePersonaje(a)];
			this.plantel[this.existePersonaje(a)] = null;
		}
		return dev;
	}
	
	/**
	 * Este personaje sirve para seleccionar un jugador ya creado del array plantel
	 * @return el jugador elegido por la posicion
	 */
	public Personaje seleccionaPersonaje() {
		int pos = Metodos.seleccionaPersonaje("Indica la posición del personaje a jugar");
		System.out.print("Has elegido a");
		System.out.print(".");
		Metodos.Time(300);
		System.out.print(".");
		Metodos.Time(300);
		System.out.print(". ");
		Metodos.Time(300);
		return plantel[pos];
	}

	public Personaje seleccionaAleatorio() {
		int pos = Metodos.generaAleatorio(plantel.length);
		return plantel[pos];
	}
	
	/**
	 * El método iniciapartida1 es el que controla todo lo que pasa desde que inicia hasta que termina la partida
	 */
	public void iniciaPartida1() {
		boolean result = true;
		int cont = 0;
		Personaje jugador1 = seleccionaPersonaje();
		int vidaaux = jugador1.getVida();
		Personaje jugador2 = new Personaje();
		Metodos.Time(1500);
		System.out.println(jugador1.getNombre());
		System.out.println();
		Metodos.Time(1500);
		eliminaSeleccion(jugador1);
		while (result != false) {
			Metodos.eligeRival();
			do {
				jugador2 = seleccionaAleatorio();
			} while (jugador2 == null);
			Metodos.Time(1500);
			System.out.println(jugador2.getNombre());
			System.out.println("");
			Metodos.Time(1500);

			boolean lucha = lucha(jugador1, jugador2);
			
			Metodos.Time(1500);
			if (lucha == false) {
				Metodos.resultadoDerrota();
				result = false;
			} else if (lucha == true) {
				cont++;
				Metodos.resultadoVictoriaCombate();
				Metodos.Time(1500);
				if (cont >= plantel.length - 1) {
					Metodos.resultadoVictoriaTotal();
					result = false;
				} else {
					jugador1.setVida(vidaaux);
					Metodos.restauraVida();
				}
			}
		}
	}
	
	/**
	 * El método iniciapartida2 es el que controla todo lo que pasa desde que inicia hasta que termina la partida y
	 * llama a otros métodos
	 * @param jugador1: es el personaje que ha sido creado manualmente
	 */
	public void iniciaPartida2(Personaje jugador1) {
		boolean result = true;
		int cont = 0;
		int vidaaux = jugador1.getVida();
		Personaje jugador2 = new Personaje();
		Metodos.Time(1500);
		System.out.println(jugador1.getNombre()+" es tu personaje");
		System.out.println();
		Metodos.Time(1500);
		while (result != false) {
			Metodos.eligeRival();
			do {
				jugador2 = seleccionaAleatorio();
			} while (jugador2 == null);
			Metodos.Time(1500);
			System.out.println(jugador2.getNombre());
			System.out.println("");
			Metodos.Time(1500);

			boolean lucha = lucha(jugador1, jugador2);
			
			Metodos.Time(1500);
			if (lucha == false) {
				Metodos.resultadoDerrota();
				result = false;
			} else if (lucha == true) {
				cont++;
				Metodos.resultadoVictoriaCombate();
				Metodos.Time(1500);
				if (cont >= plantel.length - 1) {
					Metodos.resultadoVictoriaTotal();
					result = false;
				} else {
					jugador1.setVida(vidaaux);
					Metodos.restauraVida();
				}
			}
		}
	}
	
	/**
	 * El método lucha sirve para crear un combate entre dos personajes que le pasemos
	 * @param jugador1: personaje que va a usar el jugador
	 * @param jugador2: el npc que va a usar la máquina
	 * @return false si se acaba el combate, es decir, en el momento en el que uno de los personajes muera
	 */
	public boolean lucha(Personaje jugador1, Personaje jugador2) {
		boolean lucha = true;
		boolean combat = true;
		int turno = Metodos.turnoAleatorio();
		System.out.println("------------------------------------------");
		System.out.println("|    ¡¡¡¡QUE COMIENCE EL COMBATE!!!!     |");
		System.out.println("------------------------------------------");
		System.out.println();
		Metodos.Time(1500);
		if (turno == 1) {
			System.out.println(jugador1.getNombre() + " ataca primero");
			Metodos.Time(1500);
			do {
				int atqj1 = Metodos.generaAtqDef(jugador1.getAtaque());
				if (jugador1.getClass() == Guerreros.class) {
					Guerreros j1 = (Guerreros) jugador1;
					int atqSj1 = Metodos.generaAtqDef(j1.getPoderAtaqueEspecial());
					atqj1 += atqSj1;
				}

				int defj2 = Metodos.generaAtqDef(jugador2.getDefensa());
				if (jugador2.getClass() == Magos.class) {
					Magos j2 = (Magos) jugador2;
					int defSj2 = Metodos.generaAtqDef(j2.getPoderDefensaEspecial());
					defj2 += defSj2;
				}
				
				if (atqj1 > defj2) {
					int resultatqj1 = atqj1 - defj2;
					int vidaj2 = jugador2.getVida();
					System.out.println(
							jugador1.getNombre() + " ha asestado el golpe, le ha hecho " + resultatqj1 + " de daño");
					Metodos.Time(1500);
					if (vidaj2 > resultatqj1) {
						vidaj2 -= resultatqj1;
						jugador2.setVida(vidaj2);
						System.out.println(
								"Al rival " + jugador2.getNombre() + " le queda " + jugador2.getVida() + " PS");
						Metodos.Time(1500);
					} else if (vidaj2 <= resultatqj1) {
						eliminaPersonaje(jugador2);
						Metodos.Time(1500);
						combat = false;
					}
				} else if (atqj1 <= defj2) {
					System.out.println("El ataque de " + jugador1.getNombre() + " no tuvo efecto");
					Metodos.Time(1500);
				}

				if (jugador2.getVida() > 0 && combat == true) {
					int atqj2 = Metodos.generaAtqDef(jugador2.getAtaque());
					if (jugador2.getClass() == Guerreros.class) {
						Guerreros j2 = (Guerreros) jugador2;
						int atqSj2 = Metodos.generaAtqDef(j2.getPoderAtaqueEspecial());
						atqj2 += atqSj2;
					}
					
					int defj1 = Metodos.generaAtqDef(jugador1.getDefensa());
					if (jugador1.getClass() == Magos.class) {
						Magos j1 = (Magos) jugador1;
						int defSj1 = Metodos.generaAtqDef(j1.getPoderDefensaEspecial());
						defj1 += defSj1;
					}

					if (atqj2 > defj1) {
						int resultatqj2 = atqj2 - defj1;
						int vidaj1 = jugador1.getVida();
						System.out.println(jugador2.getNombre() + " ha asestado el golpe, le ha hecho " + resultatqj2
								+ " de daño");
						Metodos.Time(1500);
						if (vidaj1 > resultatqj2) {
							vidaj1 -= resultatqj2;
							jugador1.setVida(vidaj1);
							System.out.println("A " + jugador1.getNombre() + " le queda " + jugador1.getVida() + " PS");
							Metodos.Time(1500);
						} else if (vidaj1 <= resultatqj2) {
							System.out.println(jugador1.getNombre() + " está fuera de combate");
							eliminaPersonaje(jugador1);
							combat = false;
							lucha = false;
						}
					} else if (atqj2 <= defj1) {
						System.out.println("El ataque de " + jugador2.getNombre() + " no tuvo efecto");
						Metodos.Time(1500);
					}
				}
			} while (combat != false);
		} else if (turno == 2) {
			System.out.println(jugador2.getNombre() + " ataca primero");
			Metodos.Time(1500);
			do {
				int atqj2 = Metodos.generaAtqDef(jugador2.getAtaque());
				if (jugador2.getClass() == Guerreros.class) {
					Guerreros j2 = (Guerreros) jugador2;
					int atqSj2 = Metodos.generaAtqDef(j2.getPoderAtaqueEspecial());
					atqj2 += atqSj2;
				}
				
				int defj1 = Metodos.generaAtqDef(jugador1.getDefensa());
				if (jugador1.getClass() == Magos.class) {
					Magos j1 = (Magos) jugador1;
					int defSj1 = Metodos.generaAtqDef(j1.getPoderDefensaEspecial());
					defj1 += defSj1;
				}

				if (atqj2 > defj1) {
					int resultatqj2 = atqj2 - defj1;
					int vidaj1 = jugador1.getVida();
					System.out.println(
							jugador2.getNombre() + " ha asestado el golpe, le ha hecho " + resultatqj2 + " de daño");
					Metodos.Time(1500);
					if (vidaj1 > resultatqj2) {
						vidaj1 -= resultatqj2;
						jugador1.setVida(vidaj1);
						System.out.println("A " + jugador1.getNombre() + " le queda " + jugador1.getVida() + " PS");
						Metodos.Time(1500);
					} else if (vidaj1 <= resultatqj2) {
						System.out.println(jugador1.getNombre() + " está fuera de combate");
						eliminaPersonaje(jugador1);
						Metodos.Time(1500);
						combat = false;
						lucha = false;
					}
				} else if (atqj2 <= defj1) {
					System.out.println("El ataque de " + jugador2.getNombre() + " no tuvo efecto");
					Metodos.Time(1500);
				}

				if (jugador1.getVida() > 0 && combat == true) {
					int atqj1 = Metodos.generaAtqDef(jugador1.getAtaque());
					if (jugador1.getClass() == Guerreros.class) {
						Guerreros j1 = (Guerreros) jugador1;
						int atqSj1 = Metodos.generaAtqDef(j1.getPoderAtaqueEspecial());
						atqj1 += atqSj1;
					}
					int defj2 = Metodos.generaAtqDef(jugador2.getDefensa());
					if (jugador2.getClass() == Magos.class) {
						Magos j2 = (Magos) jugador2;
						int defSj2 = Metodos.generaAtqDef(j2.getPoderDefensaEspecial());
						defj2 += defSj2;
					}

					if (atqj1 > defj2) {
						int resultatqj1 = atqj1 - defj2;
						int vidaj2 = jugador2.getVida();
						System.out.println(jugador1.getNombre() + " ha asestado el golpe, le ha hecho " + resultatqj1
								+ " de daño");
						Metodos.Time(1500);
						if (vidaj2 > resultatqj1) {
							vidaj2 -= resultatqj1;
							jugador2.setVida(vidaj2);
							System.out.println(
									"Al rival " + jugador2.getNombre() + " le queda " + jugador2.getVida() + " PS");
							Metodos.Time(1500);
						} else if (vidaj2 <= resultatqj1) {
							eliminaPersonaje(jugador2);
							Metodos.Time(1500);
							combat = false;
						}
					} else if (atqj1 <= defj2) {
						System.out.println("El ataque de " + jugador1.getNombre() + " no tuvo efecto");
						Metodos.Time(1500);
					}
				}
			} while (combat != false);
		}
		System.out.println();
		return lucha;
	}
}