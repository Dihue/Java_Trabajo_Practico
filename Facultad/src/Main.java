import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Facultad utn = new Facultad("UTN-FRRe");

		int opcion = 0, datoNum = 0, datoNum2 = 0, indiceCarrera, indiceMateria;
		String dato = null, dato2 = null;
		Scanner scan = new Scanner(System.in);
		Carrera carreraSeleccionada = null;
		Materia materiaSeleccionada = null;

		bienvenida();
		do {
			menu();
			System.out.print("\nOpción: ");
			try {
				opcion = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Valor erróneo, se debe ingresar solo números enteros");
			}

			switch (opcion) {
				case 1:
					// Agregar Carrera a una Facultad
					System.out.println("\nIngrese nombre de la carrera: ");
					try {
						dato = scan.next().toUpperCase();
					} catch (Exception e) {
						System.out.println(">Error");
					}
					Carrera carrera = new Carrera(dato);
					utn.agregarCarrera(carrera);
					break;

				case 2:
					// Eliminar una Carrera de la Facultad
					indiceCarrera = selectorCarrera(utn, scan);
					String nombreCarrera = utn.getCarreras().get(indiceCarrera).getNombre();
					utn.eliminarCarrera(nombreCarrera);
					break;

				case 3:
					// Agregar Materia a una Carrera
					indiceCarrera = selectorCarrera(utn, scan);
					System.out.println("\nIngrese nombre de la materia: ");
					try {
						dato = scan.next().toUpperCase();
					} catch (Exception e) {
						System.out.println("Error");
					}
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);
					Materia materiaAgregada = new Materia(dato);
					carreraSeleccionada.agregarMateria(materiaAgregada);
					break;

				case 4:
					// Eliminar una materia
					indiceCarrera = selectorCarrera(utn, scan);
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);

					indiceMateria = selectorMateria(carreraSeleccionada, scan);
					materiaSeleccionada = carreraSeleccionada.getMaterias().get(indiceMateria);

					carreraSeleccionada.eliminarMateria(materiaSeleccionada.getNombre());
					break;

				case 5:
					// Encontrar una materia
					indiceCarrera = selectorCarrera(utn, scan);
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);

					if (carreraSeleccionada.getMaterias().isEmpty()) {
						System.out.println(">No hay materias en lista");
					}
					else{
						System.out.println("\nIngrese nombre de la materia que está buscando: ");
						try {
							dato = scan.next();
						} catch(Exception e){
							System.out.println("Error");
						}
						carreraSeleccionada.encontrarMateria(dato);
						System.out.println("¿Desea eliminar?");
						System.out.println("\n1. Si\n2. No");
						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch (Exception e){
							System.out.println("Error");
						}
						if (opcion == 1) {
							carreraSeleccionada.eliminarMateria(dato);
						}
					}
					break;

				case 6:
					// Agregar estudiante a una materia
					indiceCarrera = selectorCarrera(utn, scan);
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);

					indiceMateria = selectorMateria(carreraSeleccionada, scan);
					materiaSeleccionada = carreraSeleccionada.getMaterias().get(indiceMateria);

					System.out.println("\nIngrese nombre del alumno a agregar: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}
					System.out.println("\nIngrese apellido del alumno a agregar: ");
					try {
						dato2 = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}
					System.out.println("\nIngrese legajo del alumno a agregar: ");
					try {
						datoNum = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Error");
					}
					Estudiante estudianteNuevo = new Estudiante(dato, dato2, datoNum);
					materiaSeleccionada.agregarEstudiante(estudianteNuevo);
					break;

				case 7:
					// Eliminar Estudiante de una Materia
					indiceCarrera = selectorCarrera(utn, scan);
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);

					indiceMateria = selectorMateria(carreraSeleccionada, scan);
					materiaSeleccionada = carreraSeleccionada.getMaterias().get(indiceMateria);

					System.out.println("\nIngrese nombre del alumno a eliminar: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}
					materiaSeleccionada.eliminarEstudiante(dato);
					break;

				case 8:
					// Modificar un Profesor de una Materia
					indiceCarrera = selectorCarrera(utn, scan);
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);

					indiceMateria = selectorMateria(carreraSeleccionada, scan);
					materiaSeleccionada = carreraSeleccionada.getMaterias().get(indiceMateria);

					System.out.println("\nIngrese nombre del nuevo profesor titular: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}
					System.out.println("\nIngrese apellido del nuevo profesor titular: ");
					try {
						dato2 = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}
					System.out.println("\nIngrese legajo del nuevo profesor titular: ");
					try {
						datoNum = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Error");
					}
					System.out.println("\nIngrese antigüedad del nuevo profesor titular: ");
					try {
						datoNum2 = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Error");
					}
					Profesor profesorTitularNuevo = new Profesor(dato, dato2, datoNum, datoNum2);
					materiaSeleccionada.modificarTitular(profesorTitularNuevo);
					break;

				case 9:
					System.out.println("\nIngrese legajo del alumno a eliminar: ");
					try {
						datoNum = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Error");
					}
					utn.eliminarEstudianteFacultad(datoNum);
					break;

				case 10:
					System.out.println("\nListado de carreras en " + utn.getNombre() + ": ");
					System.out.println(utn.listarContenido());
					break;

				case 11:
					indiceCarrera = selectorCarrera(utn, scan);
					carreraSeleccionada = utn.getCarreras().get(indiceCarrera);
					System.out.println("\nListado de materias en la carrera " + carreraSeleccionada.getNombre() + ": ");
					System.out.println(carreraSeleccionada.listarContenido());
					break;
			}

		} while (opcion > 0);

		System.out.println("Programa finalizado.");
		scan.close();

		System.out.println(utn.toString());
	}

	static void bienvenida() {
		System.out.println("\n---------------------------------------------------");
		System.out.println(" Bienvenido/a al sistema de gestión de la facultad");
		System.out.println("---------------------------------------------------");
	}

	static void menu() {
		System.out.println("\n- - - - - - - - - - Menú Principal - - - - - - - - - -\n");
		System.out.println("-> 0. Salir");
		System.out.println("-> 1. Agregar una carrera");
		System.out.println("-> 2. Eliminar una carrera");
		System.out.println("-> 3. Agregar una materia");
		System.out.println("-> 4. Eliminar una materia");
		System.out.println("-> 5. Encontrar una materia");
		System.out.println("-> 6. Agregar un estudiante a una materia");
		System.out.println("-> 7. Eliminar un estudiante de una materia");
		System.out.println("-> 8. Modificar profesor de una materia");
		System.out.println("-> 9. Eliminar un estudiante de la facultad");
		System.out.println("-> 10. Listado de carreras");
		System.out.println("-> 11. Ver materias");
	}

	static int selectorCarrera(Facultad facultad, Scanner scan) {
		int num = 0, opcion = 0;
		if(facultad.getCarreras().isEmpty()){
			System.out.println(">No hay carreras en lista");
		}
		else {
			System.out.println("Primero, seleccione la carrera: ");
			for (Carrera carrera : facultad.getCarreras()) {
				System.out.println("-> " + (num+1) + ". " + carrera.getNombre().toUpperCase());
				num++;
			}
			System.out.print("\nOpción: ");
			try {
				opcion = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Valor erróneo, se debe ingresar solo números enteros");
			}
		}
		return opcion-1;
	}

	static int selectorMateria(Carrera carreraSeleccionada, Scanner scan) {
		int num = 0, opcion = 0;
		if(carreraSeleccionada.getMaterias().isEmpty()){
			System.out.println(">No hay materias en lista");
		}
		else {
			System.out.println("Segundo, seleccione la materia: ");
			for (Materia materia : carreraSeleccionada.getMaterias()) {
				System.out.println("-> " + (num+1) + ". " + materia.getNombre().toUpperCase());
				num++;
			}
			System.out.print("\nOpción: ");
			try {
				opcion = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Valor erróneo, se debe ingresar solo números enteros");
			}
		}
		return opcion-1;
	}
}