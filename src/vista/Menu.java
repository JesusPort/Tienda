package vista;

import java.util.Scanner;

import modelo.dao.ComponenteDao;
import modelo.dao.TipoDao;
import modelo.data.Componente;
import modelo.data.Tipo;
/*
 * 1-CREAR  UN TIPO
2-BORRAR TIPO (este lo ponemos por ponerlo pero en teoria solo se podrian borrar los tipo que no actuan como clave ajena en otro sito)
3-MODIFICAR UN TIPO( )
4-MOSTRAR TODOS LOS TIPOS()
5-MOSTRAR UN TIPO EN ESPECIFICO
6-CREAR UN componente
7-BORRAR UN componenete
8-MODIFICAR UN PRODUCTO
	9-MOSTRAR AL USUARIO TODOS LOS PRODUCTOS Y QUE SELECCIONE AL ID
	-OFRECER UN MENU PARA LA MODIFICACION DEL COMPONENTE
		-1-MODIFICAR EL NOMBRE
		-MODIFICAR FABRICANTE
		-MODIFICAR EL PRECIO
		-MODICICAR LA DESCRIPCION
		- SALIR DE LA OPCION DE MODIFICACION
 */
public class Menu {
	   private Scanner scanner;

	   public Menu() {
	       scanner = new Scanner(System.in);
	   }

	   public void displayMenu() {
	       int option;
	       do {
	    	   System.out.println("1.Crea un tipo");
	    	   System.out.println("2.Borra un tipo");
	    	   System.out.println("3.Modificar un tipo");
	    	   System.out.println("4.Mostrar todos los tipos");
	    	   System.out.println("5.Mostrar un tipo que se introduzca");
	           System.out.println("6. Crea un nuevo componente");
	           System.out.println("7. Lista los componentes");
	           System.out.println("8.Borrar un componente");
	           System.out.println("9.Modificar un producto");
	           System.out.println("11. Salir");
	           System.out.print("Introduce la opcion ");
	           option = scanner.nextInt();

	           switch (option) {
	           		case 1:
	           			crearNuevoTipo();
	           			break;
	           		case 2:
	           			borrarTipo();
	           		case 3:
	           			//modificarTipo();
	                    break;
	           		case 4:
	                    mostrarTodosLosTipos();
	                    break;
	                case 5:
	                    //mostrarTipoEspecifico();
	                    break;
	                case 6:
	                    crearComponente();
	                    break;
	                case 7:
	                    listarComponentes();
	                    break;
	                case 8:
	                    //borrarComponente();
	                    break;
	                case 9:
	                    //modificarComponente();
	                    break;
	           
	               case 11:
	                  System.out.println("Saliendo...");
	                  break;
	               default:
	                  System.out.println("Opcion Incorrecta.");
	           }
	       } while (option != 11);
	   }
	   private void mostrarTodosLosTipos() {
		TipoDao.seleccionarTipos().forEach(System.out::println);
		
	   }

	/*
	    * Creamos un nuevo tipo con el nombre que nos de el usuario
	    */
	   public void crearNuevoTipo() {
		    Scanner scanner = new Scanner(System.in);
		    System.out.println("Ingrese el nombre del nuevo tipo:");
		    String nombreTipo = scanner.nextLine();
		    Tipo nuevoTipo = new Tipo(0,nombreTipo);
		    TipoDao.insertarUnTipo(nuevoTipo);
		}
	   /**
	    * Borramos un tipo de los creados,tambien borra el componente si esta asociado, primero mostramos los que hay
	    */
	   public void borrarTipo() {
		   TipoDao.seleccionarTipos().forEach(System.out::println);
		    System.out.println("Ingrese el ID del tipo que desea borrar:");
		    int idTipo = scanner.nextInt();
		    boolean borrado = TipoDao.deleteTipo(idTipo);
		    if (borrado) {
		        System.out.println("Tipo eliminado correctamente.");
		    } else {
		        System.out.println("No se pudo eliminar el tipo.");
		    }
		}

	   private void crearComponente() {
		   Scanner scanner = new Scanner(System.in);

		   System.out.println("Introduce el ID del componente:");
		   int id = scanner.nextInt();

		   System.out.println("Introduce el nombre del componente:");
		   scanner.nextLine(); 
		   String nombre = scanner.nextLine();

		   System.out.println("Introduce el fabricante del componente:");
		   String fabricante = scanner.nextLine();

		   System.out.println("Introduce el precio del componente:");
		   double precio = scanner.nextDouble();

		   System.out.println("Introduce la descripción del componente:");
		   scanner.nextLine(); 
		   String descripcion = scanner.nextLine();

		   System.out.println("Introduce el id del tipo del componente:");
		   int idTipo = scanner.nextInt();
		   
		   System.out.println("Introduce el tipo del componente:");
		   String tipo = scanner.nextLine();

		   
		   Componente c = new Componente(id, nombre, fabricante, precio, descripcion, new Tipo(idTipo, tipo));
		   ComponenteDao.insertarUnComponente(c);
		
	   	}

	   private void listarComponentes() {
		ComponenteDao.seleccionarComponente().forEach(System.out::println);
	   }
	}

