import java.util.ArrayList;

import javax.swing.JOptionPane;
public class Procesos {
	String nombre;
	int telefono;
	Double peso; 
	Double talla; 
	Double imc;
	
	ArrayList<String> nombreArr = new ArrayList<>();
	ArrayList<String> resultado = new ArrayList<>();
	
	public void menu() {
		
		int opcion;
		do {
			
		opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opcion\n" 
		+"1 - Registar\n" 
		+"2 - Consultar \n" 
		+"3 - Eliminar\n" 
		+"4 - Actualizar registros\n" 
		+"5 - Imprimir \n"));
		
		switch (opcion) {
		case 1:
			registrar();
			break;
			
		case 2:
			consultarporNombre();
			break;
			
		case 3: 
			eliminacion();
			break;
			
		case 4:
			actualizar();
			break;
			
		case 5: 
			imprimir();
		default:
			break;
		}
		
		} while (opcion != 6);
		
	}
	
	



	public void registrar() {
		
		String proceso ="";
		
		do {
			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
			nombreArr.add(nombre);
			peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese peso del paciente"));
			talla = Double.parseDouble(JOptionPane.showInputDialog("Ingrese estatura del paciente"));
			calculosIMC();
			
			proceso = JOptionPane.showInputDialog("¿Desea agregar un nuevo paciente?\n " + "Ingrese si para seguir\n");
			
		} while (proceso.equalsIgnoreCase("si"));
		
		System.out.println();		
		System.out.println(nombreArr);
		System.out.println(resultado+ "\n");
	}
	
	
	public void consultarporNombre() {
		
		System.out.println("Usuarios en sistema: " + nombreArr);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre de la persona para busscar:");
		
		if(nombreArr.contains(consulta)) {
			
		for (int i = 0; i < nombreArr.size(); i++) {
			
			if(nombreArr.get(i).equalsIgnoreCase(consulta)) {
				
				System.out.println(consulta + " si esta en el sistema");
				System.out.println("Y tiene como resultado = "+resultado.get(i));
				
				}
			}
		}else {
			System.out.println("El paciente no existe");
		}
	}
	
	public void eliminacion(){
		
		System.out.println("Usuarios en sistema: " + nombreArr);
		String consulta = JOptionPane.showInputDialog("Ingrese el nombre del paciente a elimianr");
		
		if(nombreArr.contains(consulta)) {
			for (int i = 0; i < nombreArr.size(); i++) {
				if(nombreArr.get(i).equalsIgnoreCase(consulta)) {
					nombreArr.remove(consulta);
					System.out.println("El paciente fue eliminado" + nombreArr);
				}
				
			}
		}else {
			
			System.out.println("El paciente no existe");
			
		}
	}
	
	public  void actualizar() {
		
		int consulta =0;
		
		do {
			
		
		consulta = Integer.parseInt(JOptionPane.showInputDialog("Que desea actualizar\n" +
		"1 - Nombre del paciente\n" +
		"2 - Salir al menú principal"));
		
		switch (consulta) {
		case 1:
			actualizarNombre();		
			break;
		case 2:
			menu();
			/*actualizacionPesoYEstatura(imc, imc);*/
			break;

		default:
			System.out.println("Ingrese un numero correcto");
			break;
		}
	} while (consulta != 3);	
}
	
	
	
	public void calculosIMC() {
		imc= 0.0;
		imc=peso/(talla*talla);
		
		String result="";
		
		if (imc<18) {
			result=("Anorexia");
		}else if (imc>=18 && imc <20) {
			result=("Delgadez");
		}else if (imc>=20 && imc <27) {
			result=("Normalidad");
		}else if (imc>=27 && imc <30) {
			result=("Obesidad grado 1");
		}else if (imc>=30 && imc <35) {
			result=("Obesidad grado 2");
		}else if (imc>=35 && imc <40) {
			result=("Obesidad  grado 3");
		}else if (imc>=40) {
			result=("Obesidad Morbida");
		}
		
		resultado.add(result);
		System.out.println("El Resultado es: "+result);
		}
	
	
	private void imprimir() {
		System.out.println("********RESULTADO**********\n");
		
		for (int i = 0; i < nombreArr.size(); i++) {
			System.out.println(nombreArr.get(i)+", resultado: "+resultado.get(i));
		}
		
		System.out.println();
		System.out.println("*****************************");
	}
		
	public void actualizarNombre() {
		
		System.out.println("Usuarios en sistema: " + nombreArr);
		
		String paciente = JOptionPane.showInputDialog("Ingrese el nombre del paciente que desea actualizar");
			
		
		
		if (nombreArr.contains(paciente)) {
			for (int i = 0; i < nombreArr.size(); i++) {
				if (nombreArr.get(i).equalsIgnoreCase(paciente)) {
					nombreArr.remove(paciente);
					
					nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente actualizado");
					nombreArr.add(nombre);
					System.out.println("El paciente ha sido actualizado correctamente");
				}
				
			}
		}else {
			System.out.println("El paciente no existe en el sistema");
		}
	}

}
