package com.example.springboot.utils;

public class Constants {

	public static String message = "";
	
	public static String RutaFicheroAdjunto = "";
	public static String nombreArchivo = "";
	
	
	public static final String ADMIN = "Admin";
	public static final String CUSTOMER = "Customer";
	
///// EMAIL DE ALTA DE EMPLEADOS EN EL SISTEMA **************************************************	
	public static final String asuntoEmailAltaEmployee =
			"NUEVO EMPLEADO EN EL SISTEMA";
	public static final String msjEmailAltaEmployee = 
			"Hola te damos la Bienvenida, <br>Tu Empleado ha sido dado de alta en nuestro Sistema. <br>Hasta pronto!!";
	public static final String msjEmailAltaEmployeeDestinatarios = 
			"david.cortaberria@entelgy-ibai.com" + 
			", " + 
			"david.palanca@entelgy-ibai.com" + 
			", " +
			"rafael.rodriguez@entelgy-ibai.com";
///// EMAIL DE ALTA DE EMPLEADOS EN EL SISTEMA **************************************************	

///// EMAIL DE MODIFICACION DE EMPLEADOS EN EL SISTEMA **************************************************	
	public static final String asuntoEmailModifEmployee =
			"MODIFICACION DE EMPLEADO EN EL SISTEMA";
	public static final String msjEmailModifEmployee = 
			"Hola te damos la Bienvenida, <br>Tu Empleado ha sido dado de alta en nuestro Sistema. <br>Hasta pronto!!";
	public static final String msjEmailModifEmployeeDestinatarios = 
			"david.cortaberria@entelgy-ibai.com" + 
			", " + 
			"david.palanca@entelgy-ibai.com" + 
			", " +
			"rafael.rodriguez@entelgy-ibai.com";
///// EMAIL DE MODIFICACION DE EMPLEADOS EN EL SISTEMA **************************************************		
	
///// EMAIL DE BAJA DE EMPLEADOS EN EL SISTEMA **************************************************
	public static final String asuntoEmailBajaEmployee =
			"BAJA DE EMPLEADO EN EL SISTEMA";
	public static final String msjEmailBajaEmployee = 
			"Hola, <br>El Empleado ha sido eliminado de nuestro sistema. <br>Ciao Baby!!";
	
	public static final String msjEmailBajaEmployeeDestinatarios = 
			"david.cortaberria@entelgy-ibai.com" + 
			", " + 
			"david.palanca@entelgy-ibai.com" + 
			", " +
			"rafael.rodriguez@entelgy-ibai.com";
///// EMAIL DE BAJA DE EMPLEADOS EN EL SISTEMA **************************************************
	
///// EMAIL DE INFORME DIARIO DE EMPLEADOS EN EL SISTEMA **************************************************
	public static final String asuntoEmailInforme1Employee =
			"INFORME DIARIO DE LISTADO DE EMPLEADOS EN MyPeople";
	public static final String msjEmailInforme1Employee = 
			"<html><body><font size='3' face='verdana'>" + "Hola, <br>" + 
			"Se adjunta el informe diario de Empleados. <br><br>" + 
			"Atentamente.<br>" + 
			"____________________________<br>" + 
			" MyPeople RRHH | BILBAO <br>" + 
			" Tfno. 944 000 000 " + "</font></body></html>";
	
	public static final String msjEmailInforme1EmployeeDestinatarios = 
			"david.cortaberria@entelgy-ibai.com" + 
			", " + 
			"david.palanca@entelgy-ibai.com" + 
			", " +
			"rafael.rodriguez@entelgy-ibai.com";
///// EMAIL DE INFORME DIARIO DE EMPLEADOS EN EL SISTEMA **************************************************


}
