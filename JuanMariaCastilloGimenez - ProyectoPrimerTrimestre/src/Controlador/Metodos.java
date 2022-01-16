package Controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

import Modelo.Guerreros;
import Modelo.Magos;
import Modelo.Partida;
import Modelo.Personaje;

public class Metodos {
	
	public static void iniciaPrograma() {
		seleccionaMenu();
		generaTextoSalida();
	}
	
	/**
	 * Este m�todo genera texto que simula un menu para que el jugador pueda usar el programa
	 */
	public static void generaTexto () {
		System.out.println("------------------------------------------");
		System.out.println("| Bienvenid@ a FightersVerse		 |");
		System.out.println("| Pulsa:				 |");
		System.out.println("| 0 - Para Irte				 |");
		System.out.println("| 1 - Para Jugar Con Plantel Por Defecto |");
		System.out.println("| 2 - Para Crear tu Personaje		 |");
		System.out.println("------------------------------------------");
	}
	
	/**
	 * Este m�todo sirve para validar que se introduce la opci�n 
	 * correcta a la hora de seleccionar en el men�.
	 * @param frase: Recibe una frase
	 * @return: Devuelve el valor introducido por el usuario una vez se ha comprobado
	 */
	public static int validaMenu(String frase) {
		int resultado = 0;
		boolean valid = false;
		Scanner t = new Scanner(System.in);

		do {
			System.out.print(frase + ": ");
			try {
				resultado = t.nextInt();
				if (resultado >= 0 && resultado <= 2) {
					valid = true;
				} else {
					System.out.println("Opci�n Incorrecta, vuelve a intentarlo");
					valid = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Entero err�neo");
				t.next();
			}
		} while (!valid);
		return resultado;
	}
	
	/**
	 * Este m�todo sirve para seleccionar las opciones con las que interactuar con el programa
	 */
	public static void seleccionaMenu(/*Aqui recibe un parametro u objeto*/) {
		int opcion = -1;
		do {
			Time(1200);
			generaTexto();
			opcion = validaMenu("Elige una opci�n");
			switch (opcion) {
				case 0: //Salir del programa
					System.out.println("");
					break;
					
				case 1: 
					iniciaOpcion1();
					break;
					
				case 2: 
					iniciaOpcion2();
					break;
			}
		} while (opcion!=0);
	}
	
	/**
	 * Este m�todo ejecuta en el caso de haber elegido la primera opci�n en el menu
	 */
	public static void iniciaOpcion1() {
		Partida p1 = new Partida(10);

		Magos m1 = new Magos ("Dumbledore", 100, 85, 60, 100, "Origen: Saga Harry Potter."+
								"\nDescripci�n: Es el mago m�s poderoso de su universo y el director de la academia de magia de Howgarts."
								+ "");
		p1.insertaPersonaje(m1);
		//System.out.println(m1);
		//System.out.println();
		
		Magos m2 = new Magos ("Gandalf", 100, 76, 75, 100, "Origen: Saga del Se�or de los anillos."+
								"\nDescripci�n: Poderoso mago de la era media que sirvi� de gran ayuda para derrotar a Sauron y su"
								+ "\nej�rcito de Mordor.");
		p1.insertaPersonaje(m2);
		//System.out.println(m2);
		//System.out.println();
		
		Magos m3 = new Magos ("Odin", 100, 100, 80, 100, "Origen: Mitolog�a N�rdica."+
								"\nDescripci�n:	Padre de todos y rey de Asgard. Este mago de gran nivel tiene muchos conocimientos"
								+ "\nde la magia y experiencia en la guerra por lo que le convierte en un rival a temer.");
		p1.insertaPersonaje(m3);
		//System.out.println(m3);
		//System.out.println();
		
		Magos m4 = new Magos ("Doctor Strange", 100, 90, 95, 100, "Origen: Marvel Comics."+
								"\nDescripci�n: Conocido por muchos como el \"Hechicero supremo\", este mago tiene mucho conocimiento"
								+ "\ny control de la magia, del multiverso y de sus peligros. Puede alterar el tiempo a su placer lo"
								+ "\nque le vuelve un rival casi imposible de derrotar.");
		p1.insertaPersonaje(m4);
		//System.out.println(m4);
		//System.out.println();
		
		Magos m5 = new Magos ("Wanda Maximoff (Bruja Escarlata)", 100, 97, 95, 100, "Origen: Marvel Comics."+
								"\nDescripci�n: Esta bruja es una mutante capaz de controlar la magia del caos, "
								+ "\nla cual en su universo se considera la m�s poderosa de todas, capaz de superar en poder al "
								+ "\nhechicero supremo, lo que la vuelve peligrosa y la m�s poderosa de su multiverso.");
		p1.insertaPersonaje(m5);
		//System.out.println(m5);
		//System.out.println();
		
		Guerreros g1 = new Guerreros("Saitama",1,100000,1000000,100000, "Origen: One Punch Man."+
								"\nDescripci�n: Este h�roe entren� durante dos a�os todos los d�as. Su entrenamiento consist�a en:"
								+ "\nCorrer 10Kms, 100 abdominales, 100 flexiones, 100 sentadillas. Gracias a este entrenamiento"
								+ "\n(aparte de quedarse calvo) consigui� convertirse en la persona m�s poderosa de su universo,"
								+ "\nderrota a todos sus enemigos de un golpe, y se dice que si alg�n d�a usase el 100%"
								+ "\nde su fuerza ser�a capaz de destruir su universo.");
		p1.insertaPersonaje(g1);
		//System.out.println(g1);
		//System.out.println();
		
		Guerreros g2 = new Guerreros("Hulk",100,500,100,500, "Origen: Marvel Comics."+
								"\nDescripci�n: Bruce Banner era un cient�fico que estudiaba la energ�a gamma y un d�a en un experimento"
								+ "\nalgo sali� mal y la energ�a gamma se introdujo en su cuerpo, lo que cre� a Hulk"
								+ "\nun gran monstruo verde que destruye todo a su paso y sale cuando Banner se enfada y pierde el control.");
		p1.insertaPersonaje(g2);
		//System.out.println(g2);
		//System.out.println();
		
		Guerreros g3 = new Guerreros("Goku",100,5000,1000,5000, "Origen: Dragon Ball."+
								"\nDescripci�n: Es un Saiyajin enviado a la tierra cuando era peque�o debido a que su planeta de origen"
								+ "\nel \"Planeta Vegeta\" iba a ser destruido. Era muy violento debido a la condici�n de su raza,"
								+ "\nque era una raza de guerreros pero al darse un golpe en la cabeza se volvi� bueno. Siempre ha entrenado"
								+ "\npara ser el m�s fuerte y enfrentarse a gente m�s poderosa que �l, esto ha hecho que llegue"
								+ "\nal nivel del los dioses.");
		p1.insertaPersonaje(g3);
		//System.out.println(g3);
		//System.out.println();
		
		Guerreros g4 = new Guerreros("Roronoa Zoro",50,100,50,100, "Origen: One Piece."+
								"\nDescripci�n: Este espadach�n utiliza 3 katanas para combatir, actualmente puede cortar cualquier"
								+ "\ncosa con ellas. Su objetivo es volverse el espadach�n m�s fuerte del mundo y nada lo va a parar"
								+ "\nen su camino.");
		p1.insertaPersonaje(g4);
		//System.out.println(g4);
		//System.out.println();
		
		Guerreros g5 = new Guerreros("Thor",100,100,100,100, "Origen: Mitolog�a N�rdica."+
								"\nDescripci�n: Hijo de od�n y \"Dios del Trueno\", este dios (un poco borracho) es muy poderoso"
								+ "\nque junto con su martillo \"Mjolnir\" puede acabar con cualquier enemigo");
		p1.insertaPersonaje(g5);
		//System.out.println(g5);
		//System.out.println();
		
		System.out.println(p1);
		
		Time(1500);
		p1.iniciaPartida1();
	}
	
	public static void iniciaOpcion2() {

		Partida p1 = new Partida(10);

		Magos m1 = new Magos ("Dumbledore", 100, 85, 60, 100, "Origen: Saga Harry Potter."+
								"\nDescripci�n: Es el mago m�s poderoso de su universo y el director de la academia de magia de Howgarts."
								+ "");
		p1.insertaPersonaje(m1);
		//System.out.println(m1);
		//System.out.println();
		
		Magos m2 = new Magos ("Gandalf", 100, 76, 75, 100, "Origen: Saga del Se�or de los anillos."+
								"\nDescripci�n: Poderoso mago de la era media que sirvi� de gran ayuda para derrotar a Sauron y su"
								+ "\nej�rcito de Mordor.");
		p1.insertaPersonaje(m2);
		//System.out.println(m2);
		//System.out.println();
		
		Magos m3 = new Magos ("Odin", 100, 100, 80, 100, "Origen: Mitolog�a N�rdica."+
								"\nDescripci�n:	Padre de todos y rey de Asgard. Este mago de gran nivel tiene muchos conocimientos"
								+ "\nde la magia y experiencia en la guerra por lo que le convierte en un rival a temer.");
		p1.insertaPersonaje(m3);
		//System.out.println(m3);
		//System.out.println();
		
		Magos m4 = new Magos ("Doctor Strange", 100, 90, 95, 100, "Origen: Marvel Comics."+
								"\nDescripci�n: Conocido por muchos como el \"Hechicero supremo\", este mago tiene mucho conocimiento"
								+ "\ny control de la magia, del multiverso y de sus peligros. Puede alterar el tiempo a su placer lo"
								+ "\nque le vuelve un rival casi imposible de derrotar.");
		p1.insertaPersonaje(m4);
		//System.out.println(m4);
		//System.out.println();
		
		Magos m5 = new Magos ("Wanda Maximoff (Bruja Escarlata)", 100, 97, 95, 100, "Origen: Marvel Comics."+
								"\nDescripci�n: Esta bruja es una mutante capaz de controlar la magia del caos, "
								+ "\nla cual en su universo se considera la m�s poderosa de todas, capaz de superar en poder al "
								+ "\nhechicero supremo, lo que la vuelve peligrosa y la m�s poderosa de su multiverso.");
		p1.insertaPersonaje(m5);
		//System.out.println(m5);
		//System.out.println();
		
		Guerreros g1 = new Guerreros("Saitama",1,100000,1000000,100000, "Origen: One Punch Man."+
								"\nDescripci�n: Este h�roe entren� durante dos a�os todos los d�as. Su entrenamiento consist�a en:"
								+ "\nCorrer 10Kms, 100 abdominales, 100 flexiones, 100 sentadillas. Gracias a este entrenamiento"
								+ "\n(aparte de quedarse calvo) consigui� convertirse en la persona m�s poderosa de su universo,"
								+ "\nderrota a todos sus enemigos de un golpe, y se dice que si alg�n d�a usase el 100%"
								+ "\nde su fuerza ser�a capaz de destruir su universo.");
		p1.insertaPersonaje(g1);
		//System.out.println(g1);
		//System.out.println();
		
		Guerreros g2 = new Guerreros("Hulk",100,500,100,500, "Origen: Marvel Comics."+
								"\nDescripci�n: Bruce Banner era un cient�fico que estudiaba la energ�a gamma y un d�a en un experimento"
								+ "\nalgo sali� mal y la energ�a gamma se introdujo en su cuerpo, lo que cre� a Hulk"
								+ "\nun gran monstruo verde que destruye todo a su paso y sale cuando Banner se enfada y pierde el control.");
		p1.insertaPersonaje(g2);
		//System.out.println(g2);
		//System.out.println();
		
		Guerreros g3 = new Guerreros("Goku",100,5000,1000,5000, "Origen: Dragon Ball."+
								"\nDescripci�n: Es un Saiyajin enviado a la tierra cuando era peque�o debido a que su planeta de origen"
								+ "\nel \"Planeta Vegeta\" iba a ser destruido. Era muy violento debido a la condici�n de su raza,"
								+ "\nque era una raza de guerreros pero al darse un golpe en la cabeza se volvi� bueno. Siempre ha entrenado"
								+ "\npara ser el m�s fuerte y enfrentarse a gente m�s poderosa que �l, esto ha hecho que llegue"
								+ "\nal nivel del los dioses.");
		p1.insertaPersonaje(g3);
		//System.out.println(g3);
		//System.out.println();
		
		Guerreros g4 = new Guerreros("Roronoa Zoro",50,100,50,100, "Origen: One Piece."+
								"\nDescripci�n: Este espadach�n utiliza 3 katanas para combatir, actualmente puede cortar cualquier"
								+ "\ncosa con ellas. Su objetivo es volverse el espadach�n m�s fuerte del mundo y nada lo va a parar"
								+ "\nen su camino.");
		p1.insertaPersonaje(g4);
		//System.out.println(g4);
		//System.out.println();
		
		Guerreros g5 = new Guerreros("Thor",100,100,100,100, "Origen: Mitolog�a N�rdica."+
								"\nDescripci�n: Hijo de od�n y \"Dios del Trueno\", este dios (un poco borracho) es muy poderoso"
								+ "\nque junto con su martillo \"Mjolnir\" puede acabar con cualquier enemigo");
		p1.insertaPersonaje(g5);
		//System.out.println(g5);
		//System.out.println();
		
		Scanner t = new Scanner(System.in);
		System.out.println();
		Time(1500);
		tipoPersonaje();
		
		String nombre = "";
		int vida = 0;
		int ataque = 0;
		int defensa = 0;
		
		
		int opcion2 = validaMenu("Elige una opci�n");
		switch (opcion2) {
		case 0: //Salir del programa
			System.out.println("");
			break;
			
		case 1: 
			Magos jmago1 = new Magos();
			System.out.println("Vamos a crear un personaje");
			System.out.println("Indique su nombre");
			nombre = t.next();
			jmago1.setNombre(nombre);
			
			vida = leeEntero("Indique la vida");
			jmago1.setVida(vida);
			ataque = leeEntero("Indique el ataque");
			jmago1.setAtaque(ataque);
			defensa = leeEntero("Indique la defensa");
			jmago1.setDefensa(defensa);
			int defensaS = leeEntero("Indique la defensa especial");
			jmago1.setPoderDefensaEspecial(defensaS);
			jmago1.setLore(jmago1.getNombre()+" ha sido creado recientemente por una entidad superior"
					+ "\npor lo que todav�a no tiene historia");
			System.out.println(jmago1);
			
			Time(1500);
			p1.iniciaPartida2(jmago1);
			break;
			
		case 2: 
			Guerreros jguerrero1 = new Guerreros();
			System.out.println("Vamos a crear un personaje");
			System.out.println("Indique su nombre");
			nombre = t.next();
			jguerrero1.setNombre(nombre);
			
			vida = leeEntero("Indique la vida");
			jguerrero1.setVida(vida);
			ataque = leeEntero("Indique el ataque");
			jguerrero1.setAtaque(ataque);
			defensa = leeEntero("Indique la defensa");
			jguerrero1.setDefensa(defensa);
			int ataqueS = leeEntero("Indique el ataque especial");
			jguerrero1.setPoderAtaqueEspecial(ataqueS);
			jguerrero1.setLore(jguerrero1.getNombre()+" ha sido creado recientemente por una entidad superior"
					+ "\npor lo que todav�a no tiene historia");
			System.out.println(jguerrero1);
			
			Time(1500);
			p1.iniciaPartida2(jguerrero1);
			break;		
		}
	}
	
	/**
	 * Este m�todo sirve para determinar el tiempo de aparici�n de los mensajes que se imprimen
	 * por pantalla en los menus que creemos
	 * @param time: es el parametro que va a recibir y con el que se va a indicar cuanto tiempo
	 * va a tardar en salir el siguiente texto
	 */
	public static void Time(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Este m�todo sirve para validar que se introducen solo numeros enteros
	 * @param frase: recibe una frase
	 * @return el numero que ha sido introducido una vez se ha comprobado
	 */
	public static int leeEntero(String frase) {
		Scanner t = new Scanner(System.in);
		int numero = -1;
		boolean valid = false;
		
		do {
			try {
				System.out.print(frase);
				System.out.println();
				numero = t.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Entero err�neo");
				t.next();
			}
		} while (!valid);
		return numero;
	}
	
	/**
	 * Este m�todo genera un texto de entrada que simula un men� que muestra las opciones disponibles a la
	 * hora de iniciar el programa.
	 */
	public static void generaTextoSalida() {
		System.out.println("----------------------------");
		System.out.println("| Esperamos volver a verte |");
		System.out.println("----------------------------");
	}
	
	/**
	 * Este metodo sirve para verificar que el numero que vamos a introducir para elegir un personaje
	 * es un numero valido entre 0 y 9
	 * @param frase: este parametro es una frase que recibe
	 * @return numero comprobado que es v�lido
	 */
	public static int seleccionaPersonaje(String frase) {
		Scanner t = new Scanner(System.in);
		int numero = -1;
		boolean valid = false;
		
		do {
			try {
				System.out.print(frase);
				System.out.println();
				numero = t.nextInt();
				if (numero>=0 && numero<=9) {
					valid = true;
				} else {
					System.out.println("����POSICI�N NO V�LIDA!!!!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entero err�neo");
				t.next();
			}
		} while (!valid);
		return numero;
	}
	
	/**
	 * El m�todo seleccionaAleatorio sirve para generar un n�mero aleatorio para elegir
	 * un personaje del array al que te vas a enfrentar de forma aleatoria.
	 * @param limit: este parametro que se recibe es el n�mero m�ximo de jugadores que hay en
	 * el array
	 * @return un valor aleatorio entre 1 y el valor m�ximo introducido anteriormente
	 */
	public static int generaAleatorio(int limit) {
		int lower = 0;
		int valor = (int) (Math.random() * (limit - lower)) + lower;
		return valor;
	}
	
	/**
	 * El m�todo turnoAleatorio sirve para generar un n�mero aleatorio para elegir
	 * que personaje va a atacar primero en el combate
	 * @return un valor aleatorio entre 1 y 2
	 */
	public static int turnoAleatorio() {
		int lower = 1;
		int valor = (int) (Math.random() * (2)) + lower;
		return valor;
	}
	
	/**
	 * El m�todo generaAleatorio sirve para generar n�meros aleatorios que posteriormente 
	 * guardaremos en un array.
	 * @param limit: este parametro que se recibe es el ataque o defensa m�ximos del personaje
	 * @return un valor aleatorio entre 1 y el valor m�ximo introducido anteriormente
	 */
	public static int generaAtqDef(int limit) {
		int lower = 1;
		int valor = (int) (Math.random() * (limit - lower)) + lower;
		return valor;
	}
	
	/**
	 * Este m�todo sirve para generar un texto cuando se elige el rival de forma aleatoria
	 */
	public static void eligeRival() {
		System.out.print("El rival es");
		System.out.print(".");
		Metodos.Time(300);
		System.out.print(".");
		Metodos.Time(300);
		System.out.print(". ");
	}
	
	/**
	 * Este m�todo sirve para generar texto en el caso de que el combate haya sido perdido
	 */
	public static void resultadoDerrota() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("| Has perdido... sigue intent�ndolo, suerte para la pr�xima |");
		System.out.println("-------------------------------------------------------------");
	}
	
	/**
	 * Este m�todo sirve para generar texto en el caso de que el combate haya sido ganado
	 */
	public static void resultadoVictoriaCombate() {
		System.out.println("--------------------");
		System.out.println("| ����VICTORIA!!!! |");
		System.out.println("--------------------");
		System.out.println();
	}
	
	/**
	 * Este m�todo sirve para generar texto para indicar que se ha reestablecido la vida del personaje
	 */
	public static void restauraVida() {
		System.out.println("----------------------");
		System.out.println("| Vida reestablecida |");
		System.out.println("----------------------");
		System.out.println();
	}
	
	/**
	 * Este m�todo sirve para generar texto en el caso de que se hayan ganado todos los combates
	 */
	public static void resultadoVictoriaTotal() {
		System.out.println("-----------------------------------------");
		System.out.println("| ����HAS GANADO TODAS LAS BATALLAS!!!! |");
		System.out.println("-----------------------------------------");
		System.out.println();
		System.out.println();
		System.out.println("-------------------");
		System.out.println("| VICTORIA ROYALE |");
		System.out.println("-------------------");
		System.out.println();
	}
	
	/**
	 * Este m�todo sirve para generar texto simulando un menu de seleccion en el caso de que se elija
	 * la opcion de crear tu propio personaje
	 */
	public static void tipoPersonaje() {
		System.out.println("------------------------------------------");
		System.out.println("| Selecciona el tipo de tu personaje: 	 |");
		System.out.println("| 0 - Para Volver			 |");
		System.out.println("| 1 - Mago 				 |");
		System.out.println("| 2 - Guerrero				 |");
		System.out.println("------------------------------------------");
	}
}