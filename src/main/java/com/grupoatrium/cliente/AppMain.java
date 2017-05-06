/**
 * 
 */
package com.grupoatrium.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.grupoatrium.negocio.NegocioAutores;
import com.grupoatrium.negocio.NegocioDirecciones;
import com.grupoatrium.negocio.NegocioEditoriales;
import com.grupoatrium.negocio.NegocioLibros;

/**
 * Clase de inicio de la aplicación
 * 
 * @author Elena
 *
 */
public class AppMain {

	public static void main(String[] args) {
		/*
		 * Levantar el contexto de Spring Crear el contenedor de beans a partir
		 * de configuración XML
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
		
		//LIBRO---------------------------------

		NegocioLibros beanNegocio = (NegocioLibros) context.getBean("negocioLibro");
				
		System.out.println("READ");
		System.out.println("MOSTRAR TODOS LOS LIBROS:");
		beanNegocio.consultarLibros();

		System.out.println("MOSTRAR UN LIBRO ESPECÍFICO:");
		beanNegocio.buscarLibro("9788408163381");

		System.out.println("CREATE");
		beanNegocio.insertarLibro("1234567891231", "Las bicicletas", "Carlos Aljibes", "Mundo", 2, 19.95, "Novela");
		System.out.println("LIBROS TRAS INSERCIÓN:");
		beanNegocio.consultarLibros();

		System.out.println("UPDATE");
		beanNegocio.actualizarTitulo("9788408163381", "Titulo Modificado");
		System.out.println("LIBROS TRAS ACTUALIZACIÓN:");
		beanNegocio.consultarLibros();

		System.out.println("DELETE");
		beanNegocio.borrarLibro("9788408163381");
		System.out.println("LIBROS TRAS BORRADO:");
		beanNegocio.consultarLibros();

		//AUTOR---------------------------------
		
		NegocioAutores beanAutor = (NegocioAutores) context.getBean("negocioAutor");

		System.out.println("READ");
		System.out.println("MOSTRAR AUTORES");
		beanAutor.consultarAutor();

		System.out.println("MOSTRAR AUTOR ESPECÍFICO:");
		beanAutor.buscarAutor("Carlos Ruiz Zafon");

		System.out.println("CREATE");
		beanAutor.insertarAutor("Rafael Perez", "Colombiana", "Especialista en novela negra");
		System.out.println("AUTORES TRAS INSERCIÓN:");
		beanAutor.consultarAutor();

		System.out.println("UPDATE");
		beanAutor.actualizarNacionalidad("Rafael Perez", "Argentina");
		System.out.println("AUTORES TRAS ACTUALIZACIÓN:");
		beanAutor.consultarAutor();

		System.out.println("DELETE");
		beanAutor.borrarAutor("Rafael Perez");
		System.out.println("AUTORES TRAS BORRADO:");
		beanAutor.consultarAutor();

		//EDITORIAL---------------------------------
		
		NegocioEditoriales beanEditorial = (NegocioEditoriales) context.getBean("negocioEditorial");

		System.out.println("READ");
		System.out.println("MOSTRAR EDITORIALES");
		beanEditorial.consultarEditoriales();

		System.out.println("MOSTRAR EDITORIAL ESPECIFICA:");
		beanEditorial.buscarEditorial("PLANETA");

		System.out.println("CREATE");
		beanEditorial.insertarEditorial("EL BOSQUE", "Calle Gran Vía, 23", "34522624A");
		System.out.println("EDITORIALES TRAS INSERCIÓN:");
		beanEditorial.consultarEditoriales();

		System.out.println("UPDATE");
		beanEditorial.actualizarDireccion("EL BOSQUE", "Calle Bolivia, 32");
		System.out.println("EDITORIALES TRAS ACTUALIZACIÓN:");
		beanEditorial.consultarEditoriales();

		System.out.println("DELETE");
		beanEditorial.borrarEditorial("EL BOSQUE");
		System.out.println("EDITORIALES TRAS BORRADO:");
		beanEditorial.consultarEditoriales();

		//DIRECCION---------------------------------

		NegocioDirecciones beanDireccion = (NegocioDirecciones) context.getBean("negocioDireccion");

		System.out.println("READ");
		System.out.println("MOSTRAR DIRECCIONES:");
		beanDireccion.consultarDirecciones();

		System.out.println("MOSTRAR DIRECCION ESPECÍFICA:");
		beanDireccion.buscarDireccion("Calle Nueva");

		System.out.println("CREATE");
		beanDireccion.insertarDireccion("La molina", 45, "Valladolid", 46001, "Valladolid");
		System.out.println("DIRECCIONES TRAS INSERCIÓN:");
		beanDireccion.consultarDirecciones();

		System.out.println("UPDATE");
		beanDireccion.actualizarNumero("La molina", 87);
		System.out.println("DIRECCIONES TRAS ACTUALIZACIÓN:");
		beanDireccion.consultarDirecciones();

		System.out.println("DELETE");
		beanDireccion.borrarDireccion("La molina");
		System.out.println("DIRECCIONES TRAS BORRADO:");
		beanDireccion.consultarDirecciones();
	}

}
