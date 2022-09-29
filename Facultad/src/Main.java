import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Estudiante> estudiantesEnLista = new LinkedList<>();
		Profesor profesorBase = new Profesor(null, null, 0, 0, 0);

		List<Carrera> carrerasEnLista = new LinkedList<>();
		Facultad utn = new Facultad("FRRe", carrerasEnLista);


		int opcion = 0;
		int opcion2 = 0;
		String dato = null;
		Scanner scan = new Scanner(System.in);


		System.out.println("Bienvenido/a al sistema de gestión de la facultad");
		do {
			System.out.println("\n- - - - - Menú Principal - - - - -\n");
			System.out.println("-> 1. Agregar una carrera");
			System.out.println("-> 2. Eliminar una carrera");
			System.out.println("-> 3. Agregar una materia");
			System.out.println("-> 4. Eliminar una materia");
			System.out.println("-> 5. Encontrar una materia");
			System.out.println("-> 6. Agregar un estudiante a una materia");
			System.out.println("-> 7. Eliminar un estudiante de una materia");
			System.out.println("-> 8. Modificar profesor de una materia");
			//System.out.println("-> 9. Salir");

			System.out.print("\nOpción: ");
			try {
				opcion = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Valor erróneo, se debe ingresar solo números enteros");
			}


			switch (opcion) {
				case 1:
					System.out.println("\nIngrese nombre de la carrera: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}

					List<Materia> materiasEnLista = new LinkedList<>();

					Carrera carrera = new Carrera(dato, materiasEnLista);
					utn.agregarCarrera(carrera);
					break;

				case 2:
					System.out.println("Primero, seleccione la carrera a eliminar: ");
					int num1 = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num1+1)+ ". " + carreraNombre.getNombre());
						num1++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Valor erróneo, se debe ingresar solo números enteros");
					}

					String nombreCarrera = carrerasEnLista.get(opcion-1).getNombre();
					utn.eliminarCarrera(nombreCarrera);
					break;

				case 3:

					System.out.println("Primero, seleccione la carrera: ");
					int num2 = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num2+1)+ ". " + carreraNombre.getNombre());
						num2++;
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
					break;

				case 4:
					System.out.println("Primero, seleccione la carrera: ");
					int num3 = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num3+1)+ ". " + carreraNombre.getNombre());
						num3++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia a eliminar: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}

					carrerasEnLista.get(opcion-1).eliminarMateria(dato);
					break;

				case 5:
					System.out.println("Primero, seleccione la carrera: ");
					int num4 = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num4+1)+ ". " + carreraNombre.getNombre());
						num4++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println("Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia que desea: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println("Error");
					}

					//buscar materia

					System.out.println("Materia encontrada - Desea eliminar?");
					System.out.println("Si = 1 / No =  ");
					try {
						opcion2=scan.nextInt();
					} catch (Exception e) {
						System.out.println("Error");
					}
					if(opcion2==1){
						carrerasEnLista.get(opcion-1).eliminarMateria(dato);
					}
					break;
				case 6:

					break;
				/*case 9:
					System.out.println("Programa finalizado.");
					System.exit(0);
				 */
			}

		} while (opcion > 0);

		//System.out.println(utn.toString());
	}

}