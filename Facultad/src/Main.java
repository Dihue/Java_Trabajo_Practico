import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Estudiante> estudiantesEnLista = new LinkedList<>();
		List<Carrera> carrerasEnLista = new LinkedList<>();
		List<Materia> materiasEnLista = new LinkedList<>();
		Profesor profesorBase = new Profesor(null, null, 0, 0, 0);
		Facultad utn = new Facultad("UTN-FRRe", carrerasEnLista);

		int num, num1, opcion = 0, opcion2 = 0, datoNum = 0;
		String dato = null, dato2 = null;
		Scanner scan = new Scanner(System.in);

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
						dato = scan.next();
					} catch (Exception e) {
						System.out.println(">Error");
					}

					Carrera carrera = new Carrera(dato, materiasEnLista);
					utn.agregarCarrera(carrera);
					break;

				case 2:
					// Eliminar una Carrera de la Facultad
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera a eliminar: ");
						num = 0;
						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " + carreraNombre.getNombre().toUpperCase());
							num++;
						}

						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch (Exception e) {
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						String nombreCarrera = carrerasEnLista.get(opcion-1).getNombre();
						utn.eliminarCarrera(nombreCarrera);
					}

					break;

				case 3:
					// Agregar Materia a una Carrera
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera: ");
						num = 0;

						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " +carreraNombre.getNombre().toUpperCase());
							num++;
						}

						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch (Exception e) {
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						System.out.println("\nIngrese nombre de la materia: ");
						try {
							dato = scan.next();
						} catch (Exception e) {
							System.out.println("Error");
						}

						Materia materiaAgregada = new Materia(dato, profesorBase, estudiantesEnLista);
						carrerasEnLista.get(opcion-1).agregarMateria(materiaAgregada);
					}

					break;

				case 4:
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else {
						System.out.println("Primero, seleccione la carrera: ");
						num = 0;

						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " +carreraNombre.getNombre().toUpperCase());
							num++;
						}

						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch (Exception e) {
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						if(materiasEnLista.isEmpty()){
							System.out.println(">No hay materias en lista");
						}
						else{
							System.out.println("\nIngrese nombre de la materia a eliminar: ");
							num=0;

							for (Materia materiaNombre: materiasEnLista) {
								System.out.println("-> " + (num+1)+ ". " + materiaNombre.getNombre());
								num++;
							}

							try {
								dato = scan.next();
							} catch (Exception e) {
								System.out.println(">Error");
							}

							carrerasEnLista.get(opcion-1).eliminarMateria(dato);
							System.out.println("Materia eliminada");
						}
						break;
					}

				case 5:
					// Encontrar una materia
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera: ");
						num=0;
						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " + carreraNombre.getNombre().toUpperCase());
							num++;
						}

						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch(Exception e) {
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						if(materiasEnLista.isEmpty()){
							System.out.println(">No hay materias en lista");
						}
						else{
							System.out.println("\nIngrese nombre de la materia que está buscando: ");
							try {
								dato = scan.next();
							} catch(Exception e){
								System.out.println("Error");
							}

							carrerasEnLista.get(opcion-1).encontrarMateria(dato);

							System.out.println("¿Desea eliminar?");
							System.out.println("\n1. Si\n2. No");
							try {
								opcion2=scan.nextInt();
							} catch (Exception e){
								System.out.println("Error");
							}
							if(opcion2==1){
								carrerasEnLista.get(opcion-1).eliminarMateria(dato);
								System.out.println("Materia eliminada");
							}
						}
					}
					break;

				case 6:
					// Agregar estudiante a una materia
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera: ");
						num = 0;

						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " + carreraNombre.getNombre().toUpperCase());
							num++;
						}
						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch(Exception e){
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						if(materiasEnLista.isEmpty()){
							System.out.println(">No hay materias en lista");
						}
						else{
							System.out.println("Segundo, seleccione la materia: ");
							num1 = 0;

							Carrera agregarEstudianteMateria = carrerasEnLista.get(opcion-1);

							for (Materia materiaAgregar: agregarEstudianteMateria.getMaterias()) {
								System.out.println("-> " + (num1+1)+ ". " + materiaAgregar.getNombre().toUpperCase());
								num1++;
							}

							System.out.print("\nOpción: ");
							try {
								opcion = scan.nextInt();
							} catch(Exception e){
								System.out.println("Valor erróneo, se debe ingresar solo números enteros");
							}

							Materia materiaSeleccionada = agregarEstudianteMateria.getMaterias().get(opcion-1);

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
						}
						}
					break;

				case 7:
					// Eliminar Estudiante de una Materia

					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera: ");
						num = 0;

						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " + carreraNombre.getNombre().toUpperCase());
							num++;
						}
						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch(Exception e){
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						if(materiasEnLista.isEmpty()){
							System.out.println(">No hay materias en lista");
						}
						else{
							System.out.println("Segundo, seleccione la materia: ");
							num1 = 0;

							Carrera eliminarEstudianteMateria = carrerasEnLista.get(opcion-1);

							for (Materia materiaAgregar: eliminarEstudianteMateria.getMaterias()) {
								System.out.println("-> " + (num1+1)+ ". " + materiaAgregar.getNombre().toUpperCase());
								num1++;
							}

							System.out.print("\nOpción: ");
							try {
								opcion = scan.nextInt();
							} catch(Exception e){
								System.out.println("Valor erróneo, se debe ingresar solo números enteros");
							}

							Materia materiaSeleccionadaEliminar = eliminarEstudianteMateria.getMaterias().get(opcion-1);

							System.out.println("\nIngrese nombre del alumno a eliminar: ");
							try {
								dato = scan.next();
							} catch (Exception e) {
								System.out.println("Error");
							}

							materiaSeleccionadaEliminar.eliminarEstudiante(dato);
						}
						}
					break;

				case 8:
					// Modificar un Profesor de una Materia
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera: ");
						num = 0;

						for (Carrera carreraNombre: carrerasEnLista) {
							System.out.println("-> " + (num+1)+ ". " + carreraNombre.getNombre().toUpperCase());
							num++;
						}
						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch(Exception e){
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						if(materiasEnLista.isEmpty()){
							System.out.println(">No hay materias en lista");
						}
						else{
							System.out.println("Segundo, seleccione la materia: ");
							num1 = 0;

							Carrera carerraSeleccionadaProfesor = carrerasEnLista.get(opcion-1);

							for (Materia materia: carerraSeleccionadaProfesor.getMaterias()) {
								System.out.println("-> " + (num1+1)+ ". " + materia.getNombre().toUpperCase());
								num1++;
							}

							System.out.print("\nOpción: ");
							try {
								opcion = scan.nextInt();
							} catch(Exception e){
								System.out.println("Valor erróneo, se debe ingresar solo números enteros");
							}
							Materia materiaSeleccionadaProfesor = carerraSeleccionadaProfesor.getMaterias().get(opcion-1);

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

							Profesor profesorTitularNuevo = new Profesor(dato, dato2, datoNum, 999.99, 0);
							materiaSeleccionadaProfesor.setTitular(profesorTitularNuevo);
						}
						}
					break;
				case 9:
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						num = 0;
						System.out.println(
								"\nListado de carreras en " + utn.getNombre() + ": ");
						for (Carrera carreraNombre : carrerasEnLista) {
							System.out.println(
									"-> " + (num + 1) + ". " + carreraNombre.getNombre()
											.substring(0, 1).toUpperCase() + carreraNombre.getNombre()
											.substring(1));
							num++;
						}
					}
					break;
				case 10:
					if(carrerasEnLista.isEmpty()){
						System.out.println(">No hay carreras en lista");
					}
					else{
						System.out.println("Primero, seleccione la carrera: ");
						num = 0;

						for (Carrera carreraNombre : carrerasEnLista) {
							System.out.println(
									"-> " + (num + 1) + ". " + carreraNombre.getNombre()
											.substring(0, 1).toUpperCase() + carreraNombre.getNombre()
											.substring(1));
							num++;
						}

						System.out.print("\nOpción: ");
						try {
							opcion = scan.nextInt();
						} catch (Exception e) {
							System.out.println("Valor erróneo, se debe ingresar solo números enteros");
						}

						num = 0;
						for (Materia materiaNombre : materiasEnLista) {
							System.out.println("-> " + (num + 1) + ". " + materiaNombre.getNombre());
							num++;
						}
					}

					break;
			}

		} while (opcion > 0);

		System.out.println("Programa finalizado.");
		scan.close();

	}

	private static void bienvenida() {
		System.out.println("\n---------------------------------------------------");
		System.out.println(" Bienvenido/a al sistema de gestión de la facultad");
		System.out.println("---------------------------------------------------");
	}

	private static void menu() {
		System.out.println("\n- - - - - - - - -Menú Principal - - - - - - - - - -\n");
		System.out.println("-> 0. Salir");
		System.out.println("-> 1. Agregar una carrera");
		System.out.println("-> 2. Eliminar una carrera");
		System.out.println("-> 3. Agregar una materia");
		System.out.println("-> 4. Eliminar una materia");
		System.out.println("-> 5. Encontrar una materia");
		System.out.println("-> 6. Agregar un estudiante a una materia");
		System.out.println("-> 7. Eliminar un estudiante de una materia");
		System.out.println("-> 8. Modificar profesor de una materia");
		System.out.println("-> 9. Ver carreras");
		System.out.println("-> 10. Ver materias");
	}
}