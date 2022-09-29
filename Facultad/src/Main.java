import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		List<Estudiante> estudiantesEnLista = new LinkedList<>();
		Profesor profesorBase = new Profesor(null, null, 0, 0, 0);

		List<Carrera> carrerasEnLista = new LinkedList<>();
		List<Materia> materiasEnLista = new LinkedList<>();
		Facultad utn = new Facultad("FRRe", carrerasEnLista);


		int opcion = 0;
		int opcion2 = 0;
		int num;
		String dato = null;
		Scanner scan = new Scanner(System.in);

		System.out.println("\n---------------------------------------------------");
		System.out.println(" Bienvenido/a al sistema de gestión de la facultad");
		System.out.println("---------------------------------------------------");

		do {
			System.out.println("\n- - - - - - - - -Menú Principal - - - - - - - - - -\n");
			System.out.println("-> 0. Salir");
			System.out.println("-> 1. Agregar una carrera");
			System.out.println("-> 2. Eliminar una carrera");
			System.out.println("-> 3. Agregar una materia");
			System.out.println("-> 4. Eliminar una materia");
			System.out.println("-> 5. Encontrar una materia");
			System.out.println("-> 6. Agregar un estudiante a una materia"); //hacer
			System.out.println("-> 7. Eliminar un estudiante de una materia"); //hacer
			System.out.println("-> 8. Modificar profesor de una materia"); // hacer
			System.out.println("-> 9. Ver carreras");
			System.out.println("-> 10. Ver materias");


			//System.out.println("-> 9. Salir");

			System.out.print("\nOpción: ");
			try {
				opcion = scan.nextInt();
			} catch (Exception e) {
				System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
			}


			switch (opcion) {
				case 1:
					System.out.println("\nIngrese nombre de la carrera: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println(">Error");
					}

					//List<Materia> materiasEnLista = new LinkedList<>();

					Carrera carrera = new Carrera(dato, materiasEnLista);
					utn.agregarCarrera(carrera);
					break;

				case 2:
					System.out.println("Primero, seleccione la carrera a eliminar: ");
					num = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num+1)+ ". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					String nombreCarrera = carrerasEnLista.get(opcion-1).getNombre();
					utn.eliminarCarrera(nombreCarrera);
					break;

				case 3:

					System.out.println("Primero, seleccione la carrera: ");
					num = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num+1)+ ". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia: ");
					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println(">Error");
					}

					Materia materiaAgregada = new Materia(dato, profesorBase, estudiantesEnLista);
					carrerasEnLista.get(opcion-1).agregarMateria(materiaAgregada);
					break;

				case 4:
					System.out.println("Primero, seleccione la carrera: ");
					num = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num+1)+ ". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia a eliminar: ");

					//test
					num=0;
					for (Materia materiaNombre: materiasEnLista) {
						System.out.println("-> " + (num+1)+ ". " + materiaNombre.getNombre());
						num++;
					}
					//test

					try {
						dato = scan.next();
					} catch (Exception e) {
						System.out.println(">Error");
					}

					carrerasEnLista.get(opcion-1).eliminarMateria(dato);
					break;

				case 5:
					num=0;
					System.out.println("Primero, seleccione la carrera: ");

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num+1)+ ". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion=scan.nextInt();
					} catch(Exception e) {
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia que desea: ");
					try {
						dato=scan.next();
					} catch(Exception e){
						System.out.println(">Error");
					}

					num=0;
					for (Materia materiaNombre: materiasEnLista) {
						System.out.println("-> " + (num+1)+ ". " + materiaNombre.getNombre().toUpperCase());
						num++;
					}

					carrerasEnLista.get(opcion-1).encontrarMateria(dato);

					System.out.println("¿Desea eliminar?");
					System.out.println("\nSi = 1 / No =  0");
					try {
						opcion2=scan.nextInt();
					} catch (Exception e){
						System.out.println(">Error");
					}
					if(opcion2==1){
						carrerasEnLista.get(opcion-1).eliminarMateria(dato);
					}
					break;

				case 6: //hacer
					System.out.println("Primero, seleccione la carrera: ");
					num=0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> "+(num+1)+". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}
					System.out.print("\nOpción: ");
					try {
						opcion=scan.nextInt();
					} catch(Exception e){
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia que desea: ");
					try {
						dato=scan.next();
					} catch(Exception e) {
						System.out.println(">Error");
					}
					System.out.println("\nIngrese nombre del alumno a agregar: ");
					//agregar alumno
					break;

				case 7: //hacer
					System.out.println("Primero, seleccione la carrera: ");
					num=0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> "+(num+1)+". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}
					System.out.print("\nOpción: ");
					try {
						opcion=scan.nextInt();
					} catch(Exception e){
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia que desea: ");
					try {
						dato=scan.next();
					} catch(Exception e) {
						System.out.println(">Error");
					}
					System.out.println("\nIngrese nombre del alumno a eliminar: ");
					//eliminar alumno
					break;

				case 8: //hacer
					System.out.println("Primero, seleccione la carrera: ");
					num=0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> "+(num+1)+". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}
					System.out.print("\nOpción: ");
					try {
						opcion=scan.nextInt();
					} catch(Exception e){
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					System.out.println("\nIngrese nombre de la materia que desea: ");
					try {
						dato=scan.next();
					} catch(Exception e) {
						System.out.println(">Error");
					}

					num=0;
					for (Materia materiaNombre: materiasEnLista) {
						System.out.println("-> " + (num+1)+ ". " + materiaNombre.getNombre());
						num++;
					}

					carrerasEnLista.get(opcion-1).encontrarMateria(dato);

					System.out.println("\nIngrese nombre del nuevo profesor titular de la materia: ");
					try {
						dato=scan.next();
					} catch(Exception e) {
						System.out.println(">Error");
					}

					//traer materia - setTitular

					break;
				case 9:
					num=0;
					System.out.println("\nListado de carreras en "+utn.getNombre()+": ");
					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> "+(num+1)+". " +carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}
					break;
				case 10:
					System.out.println("Primero, seleccione la carrera: ");
					num = 0;

					for (Carrera carreraNombre: carrerasEnLista) {
						System.out.println("-> " + (num+1)+ ". " + carreraNombre.getNombre().substring(0, 1).toUpperCase() +carreraNombre.getNombre().substring(1));
						num++;
					}

					System.out.print("\nOpción: ");
					try {
						opcion = scan.nextInt();
					} catch (Exception e) {
						System.out.println(">Valor erróneo, se debe ingresar solo números enteros");
					}

					num=0;
					for (Materia materiaNombre: materiasEnLista) {
						System.out.println("-> " + (num+1)+ ". " + materiaNombre.getNombre());
						num++;
					}
					break;
			}

		} while (opcion > 0);
		System.out.println("Programa finalizado.");

		//System.out.println(utn.toString());

		/*case 9:
					System.exit(0);
				 */
	}

}