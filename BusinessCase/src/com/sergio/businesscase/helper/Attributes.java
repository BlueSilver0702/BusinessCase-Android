package com.sergio.businesscase.helper;

import java.util.ArrayList;

import android.graphics.drawable.GradientDrawable;

public class Attributes {
	
	public static String FLURRY_API_KEY = "MP7XSTQG4XHX8HVCGYTK";
	
	public static final String LABEL2 = "label2";
	public static final String LABEL3 = "label3";
	public static final String CHKBOXTIEMPO="Tiempo";
	public static final String CHKBOXCAPACIDAD="Capacidad instalada";
	public static final String CHKBOXHORARAIOS="Horarios de operacion";
	public static final String CHKBOXCOBERTURA="Cobertura geografic";
	public static final String CHKBOXCOMERCIAL="Productos y servicios a comercializar";
	public static final String CHKBOXPERSONAL="Moneda";
	public static final String CHKBOXDEMANDA="Distribución";
	public static final String CHKBOXSEGMEN="Almacenamiento";
	public static final String CHKBOXDURACION="Edificaciones";
	public static final String CHKBOXTECHNOLOGIA="Capital Requerido";
	public static final String CHKBOXOTRO1="Otro1";
	public static final String CHKBOXOTRO2="Otro2";
	public static final String CHKBOXOTRO3="Otro3";
	public static final String CHECKEDELEMENT = "checked elements";
	

	
	public static ArrayList<String> getParentList()
	{
		ArrayList<String> parentList=new ArrayList<String>();
		parentList.add("Esquema General");
		parentList.add("Propósito del Caso ");
		parentList.add("Introducción ");
		parentList.add("Riesgos");
		parentList.add("Modelo Financiero");
		parentList.add("Alcances y Límites");
		parentList.add("Contingencias \ny Dependencias ");
		parentList.add("Resultados \nNo Financieros");
		parentList.add("Supuestos ");
		parentList.add("Fuente de Datos \n     y Métodos ");
		parentList.add("Conclusiones \ny recomendaciones");
		parentList.add("Sumario Ejecutivo ");
		
		 
		
		return parentList;
	}
	
	public  static ArrayList<String> getSubDescription() {
		ArrayList<String> subscription = new ArrayList<String>();
		subscription.add("Enfoque de la propuesta");
		subscription.add("Beneficios e Impactos \nNegativos de la propuesta");
		subscription.add("Justificatión de la propuesta");
		subscription.add("¿Qué puede afectar la propuesta?");
		subscription.add("Cuantifica la propuesta");
		subscription.add("¿Qué es lo que cubre \nla propuesta?");
		subscription.add("¿De qué depende la propuesta?");
		subscription.add("No todo es rentabilidad");
		subscription.add("¿Qué es aquello que se tiene que dar?");
		subscription.add("¿Cómo se obtiene o calcula?");
		subscription.add("Opinión final, \n¿qué se debe cuidar?");
		subscription.add("Contar la historia en forma \nsimple y concreta");
	
		return subscription;
	}
	
	public static ArrayList<Object> getChildList()
	{
		ArrayList<Object> childList=new ArrayList<Object>();
		
		ArrayList<String> child1 = new ArrayList<String>();
		child1.add(" Titulo");
		child1.add(" Tema");
		child1.add(" Objetivo");
		
		ArrayList<String> child2=new ArrayList<String>();
		child2.add(" Beneficios Financieros ");
		child2.add(" Impactos Negativos Financieros ");
		child2.add(" Inversión ");
		child2.add(" Otros Aspectos No Financieros ");
		
		ArrayList<String> child5=new ArrayList<String>();
		child5.add(" Beneficios");
		child5.add(" Impactos Negativos");
		child5.add(" Inversión");
		
		ArrayList<String> child7=new ArrayList<String>();
		child7.add(" Contingencias");
		child7.add(" Dependencias ");
		
		ArrayList<String> child10=new ArrayList<String>();
		child10.add(" Ingresos");
		child10.add(" Ahorros");
		child10.add(" Gastos");
		child10.add(" Costos");
		child10.add(" Inversión");
		
		ArrayList<String> child11=new ArrayList<String>();
		child11.add(" Conclusiones");
		child11.add(" Recomendaciones");
		
		childList.add(child1);
		childList.add(child2);
		childList.add(null);
		childList.add(null);
		childList.add(child5);
		
		childList.add(null);
		childList.add(child7);
		childList.add(null);
		childList.add(null);
		childList.add(child10);
		childList.add(child11);
		childList.add(null);
		return childList;
	}
	public static ArrayList<Object> getHelpChildList()
	{
		ArrayList<Object> childList=new ArrayList<Object>();
		
		ArrayList<String> child1 = new ArrayList<String>();
		child1.add(" Titulo");
		child1.add(" Tema");
		child1.add(" Objetivo");
		
		ArrayList<String> child2=new ArrayList<String>();
		child2.add(" Beneficios Financieros ");
		child2.add(" Impactos Negativos Financieros ");
		child2.add(" Inversión ");
		child2.add(" Otros Aspectos No Financieros ");
		
		ArrayList<String> child5=new ArrayList<String>();
		child5.add(" Beneficios");
		child5.add(" Impactos Negativos");
		child5.add(" Inversión");
		
		ArrayList<String> child7=new ArrayList<String>();
		child7.add(" Contingencias");
		child7.add(" Dependencias ");
		
		
		
		
		childList.add(child1);
		childList.add(child2);
		childList.add(null);
		childList.add(null);
		childList.add(child5);
		
		childList.add(null);
		childList.add(child7);
		childList.add(null);
		childList.add(null);
		childList.add(null);
		childList.add(null);
		childList.add(null);
		return childList;
	}
	
	public static ArrayList<Object> getHelpChildListForTitle()
	{
		ArrayList<Object>	 childList=new ArrayList<Object>();
		
		ArrayList<String> child1 = new ArrayList<String>();
		child1.add(" Titulo");
		child1.add(" Tema");
		child1.add(" Objetivo");
		
		ArrayList<String> child2=new ArrayList<String>();
		child2.add(" Beneficios Financieros ");
		child2.add(" Impactos Negativos\n       Financieros ");
		child2.add(" Inversión ");
		child2.add(" Otros Aspectos\n No Financieros ");
		
		ArrayList<String> child5=new ArrayList<String>();
		child5.add(" Beneficios");
		child5.add(" Impactos Negativos");
		child5.add(" Inversión");
		
		ArrayList<String> child7=new ArrayList<String>();
		child7.add(" Contingencias");
		child7.add(" Dependencias ");
		
		
		
		
		childList.add(child1);
		childList.add(child2);
		childList.add(null);
		childList.add(null);
		childList.add(child5);
		
		childList.add(null);
		childList.add(child7);
		childList.add(null);
		childList.add(null);
		childList.add(null);
		childList.add(null);
		childList.add(null);
		return childList;
	}
	
	
	public static GradientDrawable getShape(int color1,int color2)
	{
		GradientDrawable gd=new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{color1,color2});
		gd.setCornerRadius(7f);
		return gd;
	}
	public static final int COLORS[]={0xFF72C270,0xFF52A2C4,0xFFE27F81,0xFFFF8040,0xFF00A2E8,0xFFD2C152,0xFFAB5ACA,0xFF6DE9E6,0xFFE47EA9,0xFF52A2C4,0xFFD26E71,0xFF6D62FF,0xFF6DD9E5,0xFFA5A5A5,0xFF72C270,0xFF52A2C4,0xFFE27F81,0xFFFF8040,0xFF00A2E8,0xFFD2C152,0xFFAB5ACA,0xFF6DE9E6,0xFFE47EA9,0xFF52A2C4,0xFFD26E71,0xFF6D62FF,0xFF6DD9E5,0xFFA5A5A5,0xFF72C270,0xFF52A2C4,0xFFE27F81,0xFFFF8040,0xFF00A2E8,0xFFD2C152,0xFFAB5ACA,0xFF6DE9E6,0xFFE47EA9,0xFF52A2C4,0xFFD26E71,0xFF6D62FF,0xFF6DD9E5,0xFFA5A5A5,0xFF72C270,0xFF52A2C4,0xFFE27F81,0xFFFF8040,0xFF00A2E8,0xFFD2C152,0xFFAB5ACA,0xFF6DE9E6,0xFFE47EA9,0xFF52A2C4,0xFFD26E71,0xFF6D62FF,0xFF6DD9E5,0xFFA5A5A5};
    
	public static final String LISTPOSIION = "position";
	public static final String LISTVALUE = "list value";
	public static final String TITLETEXT = "title";
	public static final String POSITION = "position";
	public static final String RIESGOS = "riesgos value";
	public static final String RESULTADOS = "Resultados";
	public static final String CHKPOSITION = "chkposition";
	public static final String BCASENAME = "filename";
	public static final String TABVALUE = "tabchange";
	public static final String OPEN = "penactivity";
	public static final String WELLCOME = "Un Business Case nace de una idea o una propuesta de solución ante una problemática actual o una mejora, un Business Case no puede ser empleado para evaluar y medir el impacto que tendrá implementar 2 propuestas.Esta aplicación tiene por objetivo guiarte para elaborar un Business Case de una forma más eficiente tomando como base nuestra experiencia mayor a 10 años elaborando Business Cases, de ahí su estructura y el orden en el que se ingresa la información. No obstante lo anterior, para elaborar un Business Case no se requiere seguir este orden, por lo cual puedes ingresar la información de acuerdo a tu preferencia.Los ejemplos que se presentan se originan de un Business Case real, no obstante las cifras no son reales, éstas son utilizadas para ofrecer un mejor entendimiento.No se requiere llenar todos los campos para exportar a Word o Excel, cualquier duda relacionada con esta aplicación favor de escribir a: support@bcaseapp.com";
	public static final String WORDFILEMETODOS = "Métrica financiera\n\tEl presente caso analiza la generación de ingresos durante un periodo de X años, tiempo en el cual se calcula la planta recicladora podría alcanzar su madurez en su mercado.\nValor Presente Neto\n\tEl método del Valor Presente Neto incorpora el valor del dinero en el tiempo en la determinación de los flujos de efectivo netos del proyecto con el propósito de hacer comparaciones correctas entre flujos de efectivo en diferentes períodos a lo largo del tiempo. Para este análisis en particular se consideró una tasa de interés anual mínima aceptada de X por ciento, tomando en cuenta el hecho de que si un inversionista invierte su dinero en un instrumento financiero, es muy probable que obtenga dicha tasa considerando el monto a invertir.";
	public static class Description{
		public static final String TITILMESSAGE[]={"",
			"",
			"\n\n\t La Introducción tiene por objetivo explicar con mayor detalle el contexto que engloba el Business Case, la problemática o situación actual que busca resolver la propuesta planteada y sus repercusiones, de igual forma explica detalladamente la propuesta y su entorno. En este apartado se debe aclarar el por qué se está realizando el Business Case, cuál es el entorno al cual enfrenta la empresa y qué es lo que hace importante su análisis, así como las expectativas que se tienen al desarrollarlo. La Introducción es el Tema ampliado y elaborarlo después de la sección Propósito del Caso nos ayuda a verificar si la problemática o situación actual y nuestra propuesta son lo suficientemente sólidos para ser medidas a través de un Business Case, es decir si vale la pena continuar con su elaboración. No es necesario desarrollar la Introducción en su totalidad dentro de la aplicación, lo importante es identificar si nuestros argumentos son sólidos para ser analizados en un Business Case y por ende continuar su elaboración.",
			"\n\n\t Esta sección identifica y describe los riesgos que se corren si la propuesta es implementada, a este momento ya tenemos identificados los beneficios e impactos negativos, ahora solo nos falta identificar los riesgos para poner todos en la balanza y analizar si los beneficios que aporta el implementar la propuesta son mayores que los impactos negativos y riesgos, y por lo tanto es conveniente seguir adelante con la elaboración de nuestro Business Case. Hasta el momento sólo contamos con argumentos, no hemos cuantificado los impactos, pero estos argumentos nos darán una idea general si es conveniente o no seguir con la elaboración de nuestro Business Case.",
			"",
			"\n\n\tCada uno de los aspectos fundamentales que conforman nuestra propuesta como es capacidad instalada, productos por comercializar, moneda,  tiempo de construcción, almacenamiento,  distribución, etc. tiene sus limitaciones, y por lo tanto debemos dejar claro hasta dónde consideramos dentro de nuestro análisis que llegue cada uno de estos. Esta sección incluye una serie de aspectos que generalmente son empleados para la elaboración de un Business Case y te pueden servir de referencia, si tu propuesta requiere otro, puedes emplear las casillas “Otro 1..3” y si éstas no son suficientes, puedes definirlas directamente en el archivo generado al exportar a Word.",
			"",
			"\n\n\t Rentabilidad no es sinónimo de tomar una buena decisión, en muchas ocasiones los aspectos No Financieros son fundamentales para tomar una decisión y por lo tanto deben ser evaluados. Este apartado incluye todos aquellos aspectos que son relevantes dentro de la propuesta, que generan un impacto positivo y/o negativo pero que éste no puede ser cuantificado en términos monetarios.  La aplicación importa automáticamente las “descripciones cortas” de la sección “Otros Aspectos No Financieros/Beneficios” para que los tomes de referencia y en caso de que no hayan podido ser cuantificados en términos monetarios y su impacto en la propuesta sea relevante, los desarrolles en esta sección.",
			"\n\n\t Como cualquier otro análisis sobre situaciones futuras (predicciones), un Caso presenta resultados financieros proyectados (futuros) que están determinados por otras variables que pueden cambiar en el tiempo como pueden ser: precios del mercado, tasa de interés, volumen de ventas, costos, salarios, entre otros.  Es importante especificar los supuestos sobre los cuales se calcula el comportamiento futuro de las variables consideradas para evaluar el Caso, mismo que permitirá a cualquier otro analista o lector entender mejor los resultados arrojados en el mismo o simplemente complementarlo de así requerirlo.",
			"\n\n\t Como cualquier otro análisis, se requiere de un apartado que presente el origen de los datos empleados, calculados y analizados a lo largo del documento, en particular en los análisis de costo/beneficio y análisis financiero. Este apartado es de gran importancia porque a lo largo del documento se presentan datos y análisis de forma resumida que no es conveniente por cuestiones de estructura aclarar su origen, ya que lo anterior en muchas ocasiones puede desviar la atención del lector del tema principal. Esta sección está enfocada a contestar al lector cualquier duda relacionada con los datos empleados en el documento, sin la necesidad de estar presente quien elaboró el Business Case para hacerlo, depende en gran medida de la elaboración de las demás secciones y de la información que en éstas se incluya, particularmente de la sección “Propósito del Caso”, de ahí que importe sus descripciones cortas y se recomienda elaborarlo una vez que tengamos conformado nuestro modelo financiero. ",
			"\n\n\tEste apartado es uno de los más importantes del Business Case, se elabora una vez que se han identificados y medidos los principales resultados y por lo tanto es muy probable que cuando lo estés elaborando sea directamente en el procesador de texto y no en esta aplicación, sin embargo puedes hacer un planteamiento general, ya que si estás en esta sección quiere decir que ya elaboraste parte de las demás secciones y por lo tanto cuentas con un panorama más amplio sobre tu propuesta. Debes presentar en forma concreta, pero sobretodo personal (basado en hechos), los principales resultados obtenidos en el proceso de elaboración del Business Case",
			"\n\n\tEsta es la sección más importante dentro del Business Case, ya que resume y presenta los aspectos más relevantes considerados y analizados en cada sección, esta es la sección que muy probablemente revisará en primera instancia quien leerá el Business Case y a través de la cual decidirá si continúa o no leyendo el resto del documento, es decir, si se interesa en la propuesta. El Sumario Ejecutivo debe ofrecer los elementos básicos para tomar una decisión, tiene que ser concreto de tal forma que el lector se sienta atraído a continuar revisando el Business Case y por ende nuestra propuesta, debemos generar en el lector una visión clara y concreta de ésta.",
			"\n\n\t Esta es la sección más importante dentro del Business Case, ya que resume y presenta los aspectos más relevantes considerados y analizados en cada sección, esta es la sección que muy probablemente revisará en primera instancia quien leerá el Business Case y a través de la cual decidirá si continúa o no leyendo el resto del documento, es decir, si se interesa en la propuesta. El Sumario Ejecutivo debe ofrecer los elementos básicos para tomar una decisión, tiene que ser concreto de tal forma que el lector se sienta atraído a continuar revisando el Business Case y por ende nuestra propuesta, debemos generar en el lector una visión clara y concreta de ésta.",
			};
		
		public static final String SUBLISTMESSAGE[]={"\n\n\tEl primer paso para elaborar un Business Case es definir un título que nos permita contar con un enfoque claro sobre lo que vamos a evaluar con nuestro Business Case, en segundo término, nos ayudará a su vez a que el lector relacione el objetivo de nuestro Business Case de una forma rápida y sencilla.",
			"\n\n\t"+"Una vez que contamos con un enfoque  (Título), el siguiente paso consiste en identificar si nuestros argumentos son lo suficiente sólidos para  elaborar un Business Case. En el Tema se aclara el origen y repercusiones de la situación actual que nos llevó a plantear una solución (propuesta), misma que será evaluada a través del Business Case.",
			"\n\n\tEste apartado puede ser elaborado en cualquier momento en el desarrollo del Business Case y debe de dejar claro al lector cuál es el objetivo del Business Case, qué es lo que buscará probar.",
			"\n\n\tUna vez desarrollado el Esquema General de nuestro Caso, se recomienda definir claramente cuáles serán los Beneficios que éste tendrá para a su vez compararlos contra los Impactos Negativos y los Riesgos para poder identificar si nuestros argumentos son lo suficientemente sólidos para continuar la elaboración de nuestro Business Case. Esta sección se concentra en identificar, establecer y definir todos aquellos beneficios a partir de la implementación de la propuesta, ya sea a través de la generación de ingresos o de ahorros.",
			"\n\n\tYa que hemos identificado los Beneficios que generará nuestra propuesta, debemos compararlos contra los Impactos Negativos para poder identificar si nuestros argumentos son lo suficientemente sólidos para continuar la elaboración de nuestro Business Case.Esta sección se concentra en identificar, establecer y definir todos aquellos impactos negativos a partir de la implementación de la propuesta, ya sea a través de por concepto de gastos o de costos. ",
			"\n\n\tEl apartado Inversión se concentra en identificar, establecer y definir las salidas de dinero (plata) relacionadas con el equipo, mobiliario, edificaciones, adecuaciones, capacitación, entre otros, necesarios para elaborar el producto y/o generar el servicio planteado. En esta etapa, estas Inversiones no deben ser cuantificadas (medidas), solo identificadas y definidas, una vez que elaboremos nuestro Modelo Financiero (apoyado de la sección Análisis Financiero (Inversión)) estaremos en posibilidad de cuantificar estos impactos, no antes.",
			"\n\n\tRentabilidad no es sinónimo de tomar una buena decisión, en muchas ocasiones los aspectos No Financieros son fundamentales para tomar una decisión y por lo tanto deben ser evaluados. En ciertos casos identificamos aspectos que son relevantes pero que consideramos que no pueden ser cuantificados en términos monetarios, este apartado te ayudará a definir aquellos aspectos de carácter no monetario o financiero, en los que el Caso muestra algún impacto sobre la propuesta.",
			"\n\n\tEn esta sección se identificarán las principales variables para calcular los “Ingresos y Ahorros” que generará la propuesta, así como sus valores. Tanto las variables como sus valores serán exportadas al Modelo Financiero en Excel que genera esta aplicación, sin embargo no es indispensable capturarlas dentro de la Aplicación, éstas también pueden ser capturadas en la hoja de cálculo generada.Es muy frecuente que a lo largo del desarrollo del Business Case los valores considerados para calcular los ingresos que generará nuestra propuesta cambien, por lo cual es recomendable detenerse a definir las variables que conformarán nuestro modelo, sus valores y las fórmulas que se alimentarán de estos valores y que al final nos ayudarán a calcular el impacto de nuestra propuesta. Definir las fórmulas y sus variables nos permitirá ahorrar mucho tiempo en el desarrollo del análisis financiero de nuestra propuesta y/o impacto en términos monetarios, y por lo tanto hacer un mejor uso de nuestro tiempo.",
			"\n\n\tEn esta sección se identificarán las principales variables para calcular los “Egresos y Costos” que generará la propuesta, así como sus valores. Tanto las variables como sus valores serán exportadas al Modelo Financiero en Excel que genera esta aplicación, sin embargo no es indispensable capturarlas dentro de la Aplicación, éstas también pueden ser capturadas en la hoja de cálculo generada.Es muy frecuente que a lo largo del desarrollo del Business Case los valores considerados para calcular los egresos y costos que generará nuestra propuesta cambien, por lo cual es recomendable detenerse a definir las variables que conformarán nuestro modelo, sus valores y las fórmulas que se alimentarán de estos valores y que al final nos ayudarán a calcular el impacto de nuestra propuesta. Definir las fórmulas y sus variables nos permitirá ahorrar mucho tiempo en el desarrollo del análisis financiero de nuestra propuesta y/o impacto en términos monetarios, y por lo tanto hacer un mejor uso de nuestro tiempo.",
			"\n\n\tEn esta sección se identificarán las principales variables que requerirá la propuesta para calcular la “Inversión”, así como sus valores. Tanto las variables como sus valores serán exportadas al Modelo Financiero en Excel que genera esta aplicación, sin embargo no es indispensable capturarlas dentro de la Aplicación, éstas también pueden ser capturadas en la hoja de cálculo generada.Es muy frecuente que a lo largo del desarrollo del Business Case los valores considerados para calcular las inversiones que requerirá nuestra propuesta cambien, por lo cual es recomendable detenerse a definir las variables que conformarán nuestro modelo, sus valores y las fórmulas que se alimentarán de estos valores y que al final nos ayudarán a calcular el impacto de nuestra propuesta. Definir las fórmulas y sus variables nos permitirá ahorrar mucho tiempo en el desarrollo del análisis financiero de nuestra propuesta y/o impacto en términos monetarios, y por lo tanto hacer un mejor uso de nuestro tiempo.",
			"\n\n\t Este apartado busca dejar claro al lector qué hacer en caso de que los Riesgos considerados se hagan presentes en la implementación de nuestra propuesta, consiste en definir un “plan B” para dada riesgo identificado, de ahí que la aplicación automáticamente importa la “descripciones cortas” de las sección “Riesgos” para que señales la contingencia a implementar.",
			"\n\n\t Este apartado se concentra en identificar y describir aquellos aspectos que son fundamentales para alcanzar los resultados señalados dentro de nuestro Business Case, como puede ser el hecho de contar con la totalidad del capital señalado en el Business Case, contar con los permisos para operar, contar con todo el personal requerido, entre otros."};
		
		public static final String FILLDETAILHELP[] = {"\n\n\t El apartado Ahorros se concentra en identificar, establecer y definir todos aquellos beneficios que a partir de la implementación de la propuesta, permitirán gastar menos dinero (plata) que lo que estamos gastando actualmente y generalmente se hacen presentes en propuesta de mejora, no en nuevos proyectos; un ahorro es un dinero (plata) que actualmente gasto y que con la implementación de la propuesta dejaré de hacerlo, o será menor el monto. En esta etapa, estos Ahorros no deben ser cuantificados (medidos), solo identificados y definidos, una vez que elaboremos nuestro Modelo Financiero (apoyado de la sección Análisis Financiero (Ingreso)) estaremos en posibilidad de cuantificar estos impactos, no antes.",
			"\n\n\tEl apartado Costos identifica, establece y define todos aquellos impactos negativos que a partir de la implementación de la propuesta, provocarán salida dinero (plata), un costo es aquel que se genera de manera en relación directa con la producción del bien o el servicio, como es la materia prima, la energía, el envase, entre otros. En esta etapa, estos Costos no deben ser cuantificados (medidos), solo identificados y definidos, una vez que elaboremos nuestro Modelo Financiero (apoyado de la sección Análisis Financiero (Costos)) estaremos en posibilidad de cuantificar estos impactos, no antes.",
			"\n\n\tRentabilidad no es sinónimo de tomar una buena decisión, en muchas ocasiones los aspectos No Financieros son fundamentales para tomar una decisión y por lo tanto deben ser evaluados. En ciertos casos identificamos aspectos que son relevantes pero que consideramos que no pueden ser cuantificados en términos monetarios, este apartado te ayudará a definir aquellos aspectos de carácter no monetario o financiero, en los que el Caso muestra algún impacto sobre la propuesta."};
	
		
	}
	
	public static class HelpMessage{
		
		public static final String RROPOSITOHELPMESSAGE[]={"Descripción Corta:\n\t “Generación de una fuente de ingresos permanente”\n\nDescripción Larga:\n\t “El modelo de negocio propuesto se estima genere un ingreso durante sus primeros 3 años de operaciones de aproximadamente de USD$690,000.”",
			"Descripción corta: \n\t Gatos de Oficina \n\nDescripción Larga:\n\t “La implementación de esta propuesta generará ahorros de aproximadamente USD$35,000 anuales por concepto de gastos de oficina que actualmente tienen los socios y que con esta propuesta se eliminarán al emplear las instalaciones y personal contemplados en la propuesta.”",
			"Descripción corta: \n\t Sueldos\n\nDescripción Larga:\n\t “Relacionados con el personal necesario para operar las oficinas, como es el caso de la Gerente y la Asistente Ejecutiva, monto que se calcula en USD$36,000 anuales.”",		
			"Descripción corta: \n\t Costos Operativos\n\nDescripción Larga: \n\t “Como resultado del pago mensual de energía, telefonía, limpieza y papelería necesarios para operar día a día las oficinas, lo que representa un costo anual de USD$6,000.”",
			"Descripción corta: \n\t Adecuación de Instalaciones\n\nDescripción Larga: \n\t “Se refiere al dinero empleado para desarrollar esta propuesta de negocio, el cual asciende a USD$195,000.”",
			"Descripción corta: \n\t Tranquilidad\n\nDescripción Larga: \n\t “Esta propuesta generará una fuente de ingresos permanente que ofrecerá tranquilidad financiera a los socios.”",
			"Descripción corta: \n\t Tiempo\n\nDescripción Larga: \n\t “Se refiere al tiempo requerido para arrancar el negocio, el cual implica para los accionistas distraer parte de su tiempo que normalmente es destinado a su actividad económica principal para dedic·rselo a iniciar y encaminar el negocio propuesto.”",
			"Descripción Corta: \n\t Insatisfacción en el Servicio\n\nDescripción Larga: \n\t “Que la demanda sobrepase la capacidad instalada en lo que refiere a la demanda de espacios físicos (horas de oficina) y de servicios complementarios y por ende se genere una insatisfacción por parte de los clientes.”"};

		public static final String TITULOHELPMESSAGE = "Es muy importante comenzar con un TÌtulo ya que Èste nos ayuda a establecer o definir la dirección que deseamos tomar para analizar nuestra propuesta, en su momento nos ayudar· a su vez a que el lector relacione el objetivo de nuestro Business Case de una forma r·pida y sencilla.Ejemplo: ìPropuesta para el Financiamiento de Equipos para Ventaî";
		public static final String TEMAHELPMESSAGE = " una breve introducción del por quÈ estamos elaborando el an·lisis de nuestra propuesta y lo que nos permite es identificar si tenemos argumentos sólidos que nos permitan justificar dicho an·lisis.";
		public static final String OBJECTIVEHELPMESSAGE = "Se debe dejar claro para quÈ ser· utilizado el an·lisis desarrollado en el Caso, quÈ es lo que busca probar o analizar el Business Case, no hace referencia a los objetivos que persigue la propuesta, sino al objetivo del Business Case en sÌ.";
		public static final String MODELOFINANCIERO[] = {"Variable: \n\t Espacios Disponibles, Precio de venta por Hora de Renta de Espacio \n\nValores:\n\t 16, USD$17.5 p/hr ",
			"Variable: \n\tSueldo por hora por empleado, Número de empleados \n\nValores: USD$4 p/hr, 2"};
		public static final String ALCANCESELEMENTHELP = "El análisis se concentra en tres esquemas de servicios principales:\n- Plan A, uso de 32 horas al mes de oficina, más otros servicios complementarios\n- Plan B, uso de 16 horas al mes de oficina, más otros servicios complementarios\n- Plan C, uso de domicilio comercial únicamente, más otros servicios complementarios";

		public static final String MODELFININVERSION = "Variable: \n\t Metros por remodelar, Costo de Remodelación por m2 \n\n Valores: \n\t 280 m2, USD$750 m2";

		public static final String FUENTESDESQORTA[] = {"En 2 o 3 palabras describe todo ingreso que generar· la propuesta, ya sea por la venta del producto y/o servicio relacionado con la propuesta o de ciertos bienes. Esta descripción se utilizar· tanto en el Modelo Financiero (hoja de c·lculo) como en el documento (Business Case).",
			"En 2 o 3 palabras describe todo ahorro que generar· la propuesta, un ahorro se genera siempre y cuando al implementar la propuesta se deja de gastar dinero que hoy en dÌa se gasta. Esta descripción se utilizar· tanto en el Modelo Financiero (hoja de c·lculo) como en el documento (Business Case).",
			"En 2 o 3 palabras describe todo ìegreso normalî que generar· la propuesta, ya sea por sueldos, rentas de inmuebles, etc. Esta descripción se utilizar· tanto en el Modelo Financiero (hoja de c·lculo) como en el documento (Business Case).",
			"En 2 o 3 palabras describe todo ìcosto normalî que generar· la propuesta, ya sea por materia prima, insumos, mano de obra, energÌa, etc. Esta descripción se utilizar· tanto en el Modelo Financiero (hoja de c·lculo) como en el documento (Business Case).",
			"En 2 o 3 palabras describe toda ìinversiónî que generar· la propuesta, ya sea por la compra de equipo o maquinaria, capacitación, edificación, etc. Esta descripción se utilizar· tanto en el Modelo Financiero (hoja de c·lculo) como en el documento (Business Case)."};
		 
		public static final String SUPESTOSHELPMESSAGE="Esta propuesta supone que se tendrá una adecuada supervisión del número de cliente y el tipo de planes contratados por lo que no se rebasará nuestra capacidad instalada";

		public static final String INTRODCTION_HELP = "Los avances tecnológicos de hoy día a través de la capacidad de la oficina automatizada para vincular a las personas electrónicamente, ha abierto nuevas posibilidades en la forma como se lleva a cabo el trabajo de oficina, al punto que incluso ha hecho que el trabajo de oficina no necesariamente se tenga que realizar en la propia oficina, puede efectuarse en cualquier lugar en el que la persona se encuentre siempre y cuando cuente con las herramientas necesarias. La oficina virtual no es más que la unión de una computadora (generalmente portátil), un teléfono digital móvil, software de red, componentes multimedia y algunos programas específicos de acuerdo a la labor que desempeña el trabajador, equipo que le permite realizar sus labores en donde lo crea conveniente. Esta situación trae consigo un cambio radical en la forma de trabajar y revoluciona el mundo empresarial y profesional, generando consigo incrementos de productividad y un mejor uso de recursos (tiempo y dinero), al grado que se calcula que usando tecnologías como las empleadas en la oficina virtual (telecomunicaciones avanzadas, multimedia, bases de datos, Internet, Intranet, redes, etc.) se puede incrementar de un 10% a un 20% la productividad del trabajo."+
		" En España el 98% de las empresas son PYMEs, dentro de este grupo las microempresas representan un 97.6 % del total de empresas del sector servicios, dentro de la cuales existe un número creciente de profesionales independientes quienes se encuentran iniciando su negocio o que residen en una ciudad distinta en la que se desarrolla su actividad profesional y por lo tanto no cuentan con el presupuesto para instalar una oficina normal o no desean incrementar considerablemente su nivel de egresos fijos. Se trata de un grupo de profesionales independiente en el que el factor “imagen” juega un papel muy importante, ya que no es lo mismo dar sólo un número celular o tener reuniones de negocios en algún restaurante, que tener un lugar en donde alguien responda las llamadas o que los clientes sepan que hay un lugar en donde lo pueden localizar. En este sentido la oficina virtual ofrece la oportunidad al profesional independiente de desarrollar su actividad de una manera productiva, rentable y confiable.Se calcula que 2.1 millones de personas en España tienen como actividad económica el prestar servicios profesionales, grupo que ha registrado el segundo crecimiento más importante en los últimos 5 años después de la construcción y que en aproximadamente 43% se concentra en la zona centro del país."+
				"\n Entre las ventajas de la oficina virtual tenemos:\n - Menor costo de instalación, permite reducir los costos de renta y expansión de oficinas. \n - Menor costo de equipo, se puede emplear equipo costoso sin la necesidad de tener que adquirirlo. \n - Red formal de comunicaciones, contar con una estructura eficiente para mantener comunicación con clientes y colaboradores como si estuviera en su propia oficina. \n- Menos interrupciones del trabajo, la oficina virtual hace factible continuar con las actividades, independiente que se encuentre fuera de su área habitual de trabajo.\nEl presente caso evalúa la viabilidad de comercializar espacios temporales en Madrid para ser utilizados como oficina bajo las siguientes premisas: \n - Un solo centro de oficinas virtuales\n- Comercialización de tres esquemas distintos de servicios \n - Comercialización de otros servicios complementarios \n - Capacidad instalada de 16 estaciones de trabajo \n El comercializar espacios temporales para ser utilizados como oficina generará beneficios tales como:\n - Una fuente de ingresos permanente \n - Aprovechamiento de un inmueble adquirido y no utilizado \n - Mejor uso de los recursos económicos disponibles \n- Identificar un nuevo modelo de negocio rentable a través del tiempo \n- Beneficios fiscales";

		public static final String CONTANGCIA_HELP = "Descripción Corta:\n\t “Insatisfacción en el Servicio”\n\nDescripción Larga:\n\t “En el caso de que se presente una insatisfacción en nuestros clientes, se ofrecerá un mes sin costo”.";

		public static final String DEPENDENCIA_HELP = "Descripción corta:\n\t “Adecuada comercialización”\n\nDescripción Larga: \n\t“El éxito del esquema de negocio planteado a lo largo de este Business Case depende en gran medida de la habilidad del equipo humano responsable de la promoción de los servicios en cuanto a generar el interés y poder cerrar los contratos de los planes ofrecidos”";

		public static final String RESLTADOS_HELP = "Observamos al realizar un análisis de los servicios ofrecidos por otras empresas similares a la planteada en este Business Case,  éstos son de carácter general, están diseñados para cualquier persona que requiera de un espacio físico temporal de oficina, no tienen un grado de especialización hacia un determinado segmento o tipo de cliente. Lo anterior ofrece una oportunidad de mercado para aquellos competidores que busquen especializarse en un determinado segmento de mercado, tal y como lo plantea este Business Case.";

		public static final String FUENTESTABHELP[] = {"De acuerdo al diseño arquitectónico presentado, el inmueble solo puede contar con 12 estaciones de trabajo (oficinas), mismas que si multiplicamos por 12 (horas al día que operará la oficina (8am - 6pm)), por 5 (días por semana), por 4 (semanas por mes):\n 12x12x5x4 = 2,880 horas disponibles para ser rentadas por mes.",
			"Hoy en día cada uno de los socios tiene un gasto promedio de $1,200 por mes por concepto de renta de oficinas, más $750 de una recepcionista y $250 por conceptos de energía y teléfono, por lo cual el ahorro que se generará para cada uno de los socios será de alrededor de $2,200 por mes.",
			"Los gastos variables están asociados con las ventas generadas y consideran un 7.5 por ciento para publicidad, 8.3% para comisiones por venta y un 5% para otros gastos.",
			"Los costos variables están determinados por la línea telefónica misma que tiene un costo mensual de $68 por línea, así como por la tarifa de energía que se calcula en $20 por usuario y $10 de consumibles, por lo cual los costos variables ascienden a $98 por usuario",
			"Se calcula que la adecuación de instalaciones tenga un costo de $750 por metro cuadrado por lo que el monto total será de $127,500 ($750 x 170 m2)"};

		public static final String CONCULSIONHELP = "Después de haber realizado el análisis incluido en este documento, podemos concluir que la propuesta o modelo de negocio analizado es una buena opción de inversión, consideramos que es una propuesta estable con un rendimiento muy atractivo y con un nivel de riesgo relativamente pequeño, ya que gran parte de la inversión a realizar se concentra en activos que de una u otra forma pueden ser convertidos si no se obtiene el rendimiento esperado, además del hecho que ya se cuenta con el inmueble. En el caso de decidir enfocarse en el segmento de abogados, podemos decir por experiencia propia que el modelo propuesto es una muy buena opción y por lo tanto cuenta con muchas posibilidades de éxito";

		public static final String RECOMENDIES = "Nuestras recomendaciones con relación a esta propuesta son las siguientes:\n- Es muy importante identificar una herramienta (software) para automatizar la comunicación entre la Asistente Ejecutiva y los clientes.\n- La mezcla de servicios y estructura de los mismos es una propuesta, lo ideal es que la comercialización se enfoque hacia el Plan B o C, ya que son los más rentables y permiten aprovechar al máximo la capacidad instalada.\n- Los precios no son definitivos, pero consideramos que son muy atractivos y pueden influir positivamente en la demanda de los servicios ofrecidos.\n- Se sugiere desarrollar un plan operativo que incluya manuales de políticas y procedimientos.";

		public static final String SUMARIOEJECTIVO = "Este caso examina los beneficios y costos probables de comercializar en Madrid espacios temporales para ser utilizados como oficina.\n El esquema aquí evaluado consiste en acondicionar un área de 280 m2 dentro de un edifico para rentar espacios que puedan ser utilizados de manera temporal (unas cuantas horas al mes) como área de trabajo, recibir llamadas o para atender a clientes y/o proveedores; es decir como una oficina temporal.\nEl presente caso evalúa entre otros aspectos:\n- Tipos de servicios por ofrecer\n- Niveles y esquemas de comercialización\n- Inversión requerida\n- Rentabilidad esperada\n- Riesgos asociados\nPara desarrollar el presente análisis se consideraron los siguientes aspectos:\n- El número de profesionales independientes en Madrid \n- Empresas que ofrecen servicios similares en Madrid \n- Tipos de planes y servicios que comercializan empresas que ofrecen servicios similares en Madrid"+
		" \n - Segmentos del mercado de profesionales independientes que requieren de una oficina virtual \n - Capacidad instalada de servicios \n- Requerimiento de equipo \n- Utilidad generada por cada servicio \n- Generación de utilidad de distintos niveles y esquemas de ventas \n- Determinación de capital disponible para arrancar la comercialización de los servicios \n El esquema analizado en este Business Case contempla destinar una cantidad de $195 mil Dólares aproximadamente para desarrollar un área de oficinas que permita comercializar espacios temporales de oficina (oficinas virtuales) y servicios complementarios, a partir de una inversión previamente realizada para adquirir el espacio físico.\nDespués de realizar el análisis se identificó que desarrollar esta propuesta de negocio generaría a la Empresa una fuente de ingresos permanente a partir de un área para oficinas que no está siendo utilizada actualmente de aproximadamente USD$230,000 anuales en promedio durante sus primeros 3 años de operaciones (USD$690,000 totales) con una tasa de crecimiento anual promedio de 65% durante el mismo lapso de tiempo";

		public static final String[] RROPOSITOHELPMESSAGE1 = {"Descripción Corta\n\t En 2 o 3 palabras describe todo ingreso que generará la propuesta, ya sea por la venta del producto y/o servicio relacionado con la propuesta o de ciertos bienes. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\nDescripción Larga\n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “ingreso” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe todo ahorro que generará la propuesta, un ahorro se genera siempre y cuando al implementar la propuesta se deja de gastar dinero que hoy en día se gasta. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\nDescripción Larga:\n\t Describe con mayor detalle pero en forma concreta, la descripción corta de “ahorro” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\n En 2 o 3 palabras describe todo “egreso normal” que generará la propuesta, ya sea por sueldos, renta de inmueble, telefonía, etc. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\n Descripción Larga:\n\t Describe con mayor detalle pero en forma concreta, la descripción corta de “egreso” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe todo “costo normal” que generará la propuesta, ya sea por materia prima, insumos, mano de obra, energía, etc. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\nDescripción Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “costo” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe toda “inversión” que generará la propuesta, ya sea por la compra de equipo o maquinaria, capacitación, edificación, etc. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\nDescripción Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “inversión” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe todo “beneficio no financiero” que a tu parecer no pueda ser expresado en términos de dinero y que se generará a partir de la implementación de la propuesta. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\nDescripción Larga\n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “beneficios no financiero” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe todo “efecto negativo no financiero” que a tu parecer no pueda ser expresado en términos de dinero (plata) y que se generará a partir de la implementación de la propuesta. Esta descripción se utilizará tanto en el Modelo Financiero (hoja de cálculo) como en el documento (Business Case).\n\nDescripción Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “costo no financiero” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe todo “riesgo”  que se puede enfrentar al implementar la propuesta y que puede llevar a no obtener los resultados planteados o esperados dentro del Business Case. Esta descripción se utilizará en el documento (Business Case). \n\n Descripción Larga: \n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “Riesgos” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla. Esta descripción se utilizará en el documento (Business Case)."};

		public static final String[] CONDEPRESHELP = {"Descripción Corta:\n\t En 2 o 3 palabras describe la “Contingencia”  que se puede implementar si es que el riesgo contemplado se hace presente y así asegurar disminuir los impactos negativos sobre la propuesta. Esta descripción se utilizará en el documento (Business Case).\n\n Descripción Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “Contingencia” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe la “Dependencia”  que se requiere dar para cumplir con los resultados planteados dentro del Business Case. Esta descripción se utilizará en el documento (Business Case). \n\n Descripción Larga: \n\tDescribe con mayor detalle pero en forma concreta, la descripción corta de “Dependencia” antes definida, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarla. Esta descripción se utilizará en el documento (Business Case).",
			"Descripción Corta: \n\t En 2 o 3 palabras describe el impacto no financieros que generará la propuesta. Esta descripción se utilizará en el documento (Business Case). \n\n Descripción Larga: \n\tDescribe con mayor detalle pero en forma concreta, la descripción corta del “impacto negativo” antes definido, de tal forma que la persona que lea esta descripción (larga) pueda entender su impacto sin necesidad de que estés presente para explicarlo, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripción se utilizará en el documento (Business Case)."};
	 }

//	public static class HelpMessage{
//		
//		public static final String RROPOSITOHELPMESSAGE[]={"Descripci�n Corta:\n\t �Generaci�n de una fuente de ingresos permanente�\n\nDescripci�n Larga:\n\t �El modelo de negocio propuesto se estima genere un ingreso durante sus primeros 3 a�os de operaciones de aproximadamente de USD$690,000.�",
//			"Descripci�n corta: \n\t Gatos de Oficina \n\nDescripci�n Larga:\n\t �La implementaci�n de esta propuesta generar� ahorros de aproximadamente USD$35,000 anuales por concepto de gastos de oficina que actualmente tienen los socios y que con esta propuesta se eliminar�n al emplear las instalaciones y personal contemplados en la propuesta.�",
//			"Descripci�n corta: \n\t Sueldos\n\nDescripci�n Larga:\n\t �Relacionados con el personal necesario para operar las oficinas, como es el caso de la Gerente y la Asistente Ejecutiva, monto que se calcula en USD$36,000 anuales.�",		
//			"Descripci�n corta: \n\t Costos Operativos\n\nDescripci�n Larga: \n\t �Como resultado del pago mensual de energ�a, telefon�a, limpieza y papeler�a necesarios para operar d�a a d�a las oficinas, lo que representa un costo anual de USD$6,000.�",
//			"Descripci�n corta: \n\t Adecuaci�n de Instalaciones\n\nDescripci�n Larga: \n\t �Se refiere al dinero empleado para desarrollar esta propuesta de negocio, el cual asciende a USD$195,000.�",
//			"Descripci�n corta: \n\t Tranquilidad\n\nDescripci�n Larga: \n\t �Esta propuesta generar� una fuente de ingresos permanente que ofrecer� tranquilidad financiera a los socios.�",
//			"Descripci�n corta: \n\t Tiempo\n\nDescripci�n Larga: \n\t �Se refiere al tiempo requerido para arrancar el negocio, el cual implica para los accionistas distraer parte de su tiempo que normalmente es destinado a su actividad econ�mica principal para dedic�rselo a iniciar y encaminar el negocio propuesto.�",
//			"Descripci�n Corta: \n\t Insatisfacci�n en el Servicio\n\nDescripci�n Larga: \n\t �Que la demanda sobrepase la capacidad instalada en lo que refiere a la demanda de espacios f�sicos (horas de oficina) y de servicios complementarios y por ende se genere una insatisfacci�n por parte de los clientes.�"};
//
//		public static final String TITULOHELPMESSAGE = "Es muy importante comenzar con un T�tulo ya que �ste nos ayuda a establecer o definir la direcci�n que deseamos tomar para analizar nuestra propuesta, en su momento nos ayudar� a su vez a que el lector relacione el objetivo de nuestro Business Case de una forma r�pida y sencilla.Ejemplo: �Propuesta para el Financiamiento de Equipos para Venta�";
//		public static final String TEMAHELPMESSAGE = " una breve introducci�n del por qu� estamos elaborando el an�lisis de nuestra propuesta y lo que nos permite es identificar si tenemos argumentos s�lidos que nos permitan justificar dicho an�lisis.";
//		public static final String OBJECTIVEHELPMESSAGE = "Se debe dejar claro para qu� ser� utilizado el an�lisis desarrollado en el Caso, qu� es lo que busca probar o analizar el Business Case, no hace referencia a los objetivos que persigue la propuesta, sino al objetivo del Business Case en s�.";
//		public static final String MODELOFINANCIERO[] = {"Variable: \n\t Espacios Disponibles, Precio de venta por Hora de Renta de Espacio \n\nValores:\n\t 16, USD$17.5 p/hr ",
//			"Variable: \n\tSueldo por hora por empleado, N�mero de empleados \n\nValores: USD$4 p/hr, 2"};
//		public static final String ALCANCESELEMENTHELP = "El an�lisis se concentra en tres esquemas de servicios principales:\n- Plan A, uso de 32 horas al mes de oficina, m�s otros servicios complementarios\n- Plan B, uso de 16 horas al mes de oficina, m�s otros servicios complementarios\n- Plan C, uso de domicilio comercial �nicamente, m�s otros servicios complementarios";
//
//		public static final String MODELFININVERSION = "Variable: \n\t Metros por remodelar, Costo de Remodelaci�n por m2 \n\n Valores: \n\t 280 m2, USD$750 m2";
//
//		public static final String FUENTESDESQORTA[] = {"En 2 o 3 palabras describe todo ingreso que generar� la propuesta, ya sea por la venta del producto y/o servicio relacionado con la propuesta o de ciertos bienes. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).",
//			"En 2 o 3 palabras describe todo ahorro que generar� la propuesta, un ahorro se genera siempre y cuando al implementar la propuesta se deja de gastar dinero que hoy en d�a se gasta. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).",
//			"En 2 o 3 palabras describe todo �egreso normal� que generar� la propuesta, ya sea por sueldos, rentas de inmuebles, etc. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).",
//			"En 2 o 3 palabras describe todo �costo normal� que generar� la propuesta, ya sea por materia prima, insumos, mano de obra, energ�a, etc. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).",
//			"En 2 o 3 palabras describe toda �inversi�n� que generar� la propuesta, ya sea por la compra de equipo o maquinaria, capacitaci�n, edificaci�n, etc. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case)."};
//		 
//		public static final String SUPESTOSHELPMESSAGE="Esta propuesta supone que se tendr� una adecuada supervisi�n del n�mero de cliente y el tipo de planes contratados por lo que no se rebasar� nuestra capacidad instalada";
//
//		public static final String INTRODCTION_HELP = "Los avances tecnol�gicos de hoy d�a a trav�s de la capacidad de la oficina automatizada para vincular a las personas electr�nicamente, ha abierto nuevas posibilidades en la forma como se lleva a cabo el trabajo de oficina, al punto que incluso ha hecho que el trabajo de oficina no necesariamente se tenga que realizar en la propia oficina, puede efectuarse en cualquier lugar en el que la persona se encuentre siempre y cuando cuente con las herramientas necesarias. La oficina virtual no es m�s que la uni�n de una computadora (generalmente port�til), un tel�fono digital m�vil, software de red, componentes multimedia y algunos programas espec�ficos de acuerdo a la labor que desempe�a el trabajador, equipo que le permite realizar sus labores en donde lo crea conveniente. Esta situaci�n trae consigo un cambio radical en la forma de trabajar y revoluciona el mundo empresarial y profesional, generando consigo incrementos de productividad y un mejor uso de recursos (tiempo y dinero), al grado que se calcula que usando tecnolog�as como las empleadas en la oficina virtual (telecomunicaciones avanzadas, multimedia, bases de datos, Internet, Intranet, redes, etc.) se puede incrementar de un 10% a un 20% la productividad del trabajo."+
//		" En Espa�a el 98% de las empresas son PYMEs, dentro de este grupo las microempresas representan un 97.6 % del total de empresas del sector servicios, dentro de la cuales existe un n�mero creciente de profesionales independientes quienes se encuentran iniciando su negocio o que residen en una ciudad distinta en la que se desarrolla su actividad profesional y por lo tanto no cuentan con el presupuesto para instalar una oficina normal o no desean incrementar considerablemente su nivel de egresos fijos. Se trata de un grupo de profesionales independiente en el que el factor �imagen� juega un papel muy importante, ya que no es lo mismo dar s�lo un n�mero celular o tener reuniones de negocios en alg�n restaurante, que tener un lugar en donde alguien responda las llamadas o que los clientes sepan que hay un lugar en donde lo pueden localizar. En este sentido la oficina virtual ofrece la oportunidad al profesional independiente de desarrollar su actividad de una manera productiva, rentable y confiable.Se calcula que 2.1 millones de personas en Espa�a tienen como actividad econ�mica el prestar servicios profesionales, grupo que ha registrado el segundo crecimiento m�s importante en los �ltimos 5 a�os despu�s de la construcci�n y que en aproximadamente 43% se concentra en la zona centro del pa�s."+
//				"\n Entre las ventajas de la oficina virtual tenemos:\n - Menor costo de instalaci�n, permite reducir los costos de renta y expansi�n de oficinas. \n - Menor costo de equipo, se puede emplear equipo costoso sin la necesidad de tener que adquirirlo. \n - Red formal de comunicaciones, contar con una estructura eficiente para mantener comunicaci�n con clientes y colaboradores como si estuviera en su propia oficina. \n- Menos interrupciones del trabajo, la oficina virtual hace factible continuar con las actividades, independiente que se encuentre fuera de su �rea habitual de trabajo.\nEl presente caso eval�a la viabilidad de comercializar espacios temporales en Madrid para ser utilizados como oficina bajo las siguientes premisas: \n - Un solo centro de oficinas virtuales\n- Comercializaci�n de tres esquemas distintos de servicios \n - Comercializaci�n de otros servicios complementarios \n - Capacidad instalada de 16 estaciones de trabajo \n El comercializar espacios temporales para ser utilizados como oficina generar� beneficios tales como:\n - Una fuente de ingresos permanente \n - Aprovechamiento de un inmueble adquirido y no utilizado \n - Mejor uso de los recursos econ�micos disponibles \n- Identificar un nuevo modelo de negocio rentable a trav�s del tiempo \n- Beneficios fiscales";
//
//		public static final String CONTANGCIA_HELP = "Descripci�n Corta:\n\t �Insatisfacci�n en el Servicio�\n\nDescripci�n Larga:\n\t �En el caso de que se presente una insatisfacci�n en nuestros clientes, se ofrecer� un mes sin costo�.";
//
//		public static final String DEPENDENCIA_HELP = "Descripci�n corta:\n\t �Adecuada comercializaci�n�\n\nDescripci�n Larga: \n\t�El �xito del esquema de negocio planteado a lo largo de este Business Case depende en gran medida de la habilidad del equipo humano responsable de la promoci�n de los servicios en cuanto a generar el inter�s y poder cerrar los contratos de los planes ofrecidos�";
//
//		public static final String RESLTADOS_HELP = "Observamos al realizar un an�lisis de los servicios ofrecidos por otras empresas similares a la planteada en este Business Case,  �stos son de car�cter general, est�n dise�ados para cualquier persona que requiera de un espacio f�sico temporal de oficina, no tienen un grado de especializaci�n hacia un determinado segmento o tipo de cliente. Lo anterior ofrece una oportunidad de mercado para aquellos competidores que busquen especializarse en un determinado segmento de mercado, tal y como lo plantea este Business Case.";
//
//		public static final String FUENTESTABHELP[] = {"De acuerdo al dise�o arquitect�nico presentado, el inmueble solo puede contar con 12 estaciones de trabajo (oficinas), mismas que si multiplicamos por 12 (horas al d�a que operar� la oficina (8am - 6pm)), por 5 (d�as por semana), por 4 (semanas por mes):\n 12x12x5x4 = 2,880 horas disponibles para ser rentadas por mes.",
//			"Hoy en d�a cada uno de los socios tiene un gasto promedio de $1,200 por mes por concepto de renta de oficinas, m�s $750 de una recepcionista y $250 por conceptos de energ�a y tel�fono, por lo cual el ahorro que se generar� para cada uno de los socios ser� de alrededor de $2,200 por mes.",
//			"Los gastos variables est�n asociados con las ventas generadas y consideran un 7.5 por ciento para publicidad, 8.3% para comisiones por venta y un 5% para otros gastos.",
//			"Los costos variables est�n determinados por la l�nea telef�nica misma que tiene un costo mensual de $68 por l�nea, as� como por la tarifa de energ�a que se calcula en $20 por usuario y $10 de consumibles, por lo cual los costos variables ascienden a $98 por usuario",
//			"Se calcula que la adecuaci�n de instalaciones tenga un costo de $750 por metro cuadrado por lo que el monto total ser� de $127,500 ($750 x 170 m2)"};
//
//		public static final String CONCULSIONHELP = "Despu�s de haber realizado el an�lisis incluido en este documento, podemos concluir que la propuesta o modelo de negocio analizado es una buena opci�n de inversi�n, consideramos que es una propuesta estable con un rendimiento muy atractivo y con un nivel de riesgo relativamente peque�o, ya que gran parte de la inversi�n a realizar se concentra en activos que de una u otra forma pueden ser convertidos si no se obtiene el rendimiento esperado, adem�s del hecho que ya se cuenta con el inmueble. En el caso de decidir enfocarse en el segmento de abogados, podemos decir por experiencia propia que el modelo propuesto es una muy buena opci�n y por lo tanto cuenta con muchas posibilidades de �xito";
//
//		public static final String RECOMENDIES = "Nuestras recomendaciones con relaci�n a esta propuesta son las siguientes:\n- Es muy importante identificar una herramienta (software) para automatizar la comunicaci�n entre la Asistente Ejecutiva y los clientes.\n- La mezcla de servicios y estructura de los mismos es una propuesta, lo ideal es que la comercializaci�n se enfoque hacia el Plan B o C, ya que son los m�s rentables y permiten aprovechar al m�ximo la capacidad instalada.\n- Los precios no son definitivos, pero consideramos que son muy atractivos y pueden influir positivamente en la demanda de los servicios ofrecidos.\n- Se sugiere desarrollar un plan operativo que incluya manuales de pol�ticas y procedimientos.";
//
//		public static final String SUMARIOEJECTIVO = "Este caso examina los beneficios y costos probables de comercializar en Madrid espacios temporales para ser utilizados como oficina.\n El esquema aqu� evaluado consiste en acondicionar un �rea de 280 m2 dentro de un edifico para rentar espacios que puedan ser utilizados de manera temporal (unas cuantas horas al mes) como �rea de trabajo, recibir llamadas o para atender a clientes y/o proveedores; es decir como una oficina temporal.\nEl presente caso eval�a entre otros aspectos:\n- Tipos de servicios por ofrecer\n- Niveles y esquemas de comercializaci�n\n- Inversi�n requerida\n- Rentabilidad esperada\n- Riesgos asociados\nPara desarrollar el presente an�lisis se consideraron los siguientes aspectos:\n- El n�mero de profesionales independientes en Madrid \n- Empresas que ofrecen servicios similares en Madrid \n- Tipos de planes y servicios que comercializan empresas que ofrecen servicios similares en Madrid"+
//		" \n - Segmentos del mercado de profesionales independientes que requieren de una oficina virtual \n - Capacidad instalada de servicios \n- Requerimiento de equipo \n- Utilidad generada por cada servicio \n- Generaci�n de utilidad de distintos niveles y esquemas de ventas \n- Determinaci�n de capital disponible para arrancar la comercializaci�n de los servicios \n El esquema analizado en este Business Case contempla destinar una cantidad de $195 mil D�lares aproximadamente para desarrollar un �rea de oficinas que permita comercializar espacios temporales de oficina (oficinas virtuales) y servicios complementarios, a partir de una inversi�n previamente realizada para adquirir el espacio f�sico.\nDespu�s de realizar el an�lisis se identific� que desarrollar esta propuesta de negocio generar�a a la Empresa una fuente de ingresos permanente a partir de un �rea para oficinas que no est� siendo utilizada actualmente de aproximadamente USD$230,000 anuales en promedio durante sus primeros 3 a�os de operaciones (USD$690,000 totales) con una tasa de crecimiento anual promedio de 65% durante el mismo lapso de tiempo";
//
//		public static final String[] RROPOSITOHELPMESSAGE1 = {"Descripci�n Corta\n\t En 2 o 3 palabras describe todo ingreso que generar� la propuesta, ya sea por la venta del producto y/o servicio relacionado con la propuesta o de ciertos bienes. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\nDescripci�n Larga\n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �ingreso� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe todo ahorro que generar� la propuesta, un ahorro se genera siempre y cuando al implementar la propuesta se deja de gastar dinero que hoy en d�a se gasta. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\nDescripci�n Larga:\n\t Describe con mayor detalle pero en forma concreta, la descripci�n corta de �ahorro� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\n En 2 o 3 palabras describe todo �egreso normal� que generar� la propuesta, ya sea por sueldos, renta de inmueble, telefon�a, etc. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\n Descripci�n Larga:\n\t Describe con mayor detalle pero en forma concreta, la descripci�n corta de �egreso� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe todo �costo normal� que generar� la propuesta, ya sea por materia prima, insumos, mano de obra, energ�a, etc. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\nDescripci�n Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �costo� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe toda �inversi�n� que generar� la propuesta, ya sea por la compra de equipo o maquinaria, capacitaci�n, edificaci�n, etc. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\nDescripci�n Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �inversi�n� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe todo �beneficio no financiero� que a tu parecer no pueda ser expresado en t�rminos de dinero y que se generar� a partir de la implementaci�n de la propuesta. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\nDescripci�n Larga\n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �beneficios no financiero� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe todo �efecto negativo no financiero� que a tu parecer no pueda ser expresado en t�rminos de dinero (plata) y que se generar� a partir de la implementaci�n de la propuesta. Esta descripci�n se utilizar� tanto en el Modelo Financiero (hoja de c�lculo) como en el documento (Business Case).\n\nDescripci�n Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �costo no financiero� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla, en esta etapa no debes de buscar cuantificarla, solo describirla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe todo �riesgo�  que se puede enfrentar al implementar la propuesta y que puede llevar a no obtener los resultados planteados o esperados dentro del Business Case. Esta descripci�n se utilizar� en el documento (Business Case). \n\n Descripci�n Larga: \n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �Riesgos� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla. Esta descripci�n se utilizar� en el documento (Business Case)."};
//
//		public static final String[] CONDEPRESHELP = {"Descripci�n Corta:\n\t En 2 o 3 palabras describe la �Contingencia�  que se puede implementar si es que el riesgo contemplado se hace presente y as� asegurar disminuir los impactos negativos sobre la propuesta. Esta descripci�n se utilizar� en el documento (Business Case).\n\n Descripci�n Larga:\n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �Contingencia� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla. Esta descripci�n se utilizar� en el documento (Business Case).",
//			"Descripci�n Corta: \n\t En 2 o 3 palabras describe la �Dependencia�  que se requiere dar para cumplir con los resultados planteados dentro del Business Case. Esta descripci�n se utilizar� en el documento (Business Case). \n\n Descripci�n Larga: \n\tDescribe con mayor detalle pero en forma concreta, la descripci�n corta de �Dependencia� antes definida, de tal forma que la persona que lea esta descripci�n (larga) pueda entender su impacto sin necesidad de que est�s presente para explicarla. Esta descripci�n se utilizar� en el documento (Business Case)."};
//	 }

	
	public static class ShPreference{

		public static final String HEADING = "Heading";
		public static final String TITLE = "title";
		public static final String TEMA = "tema";
		public static final String OBJECTIVE = "objective";
		public static final String INTRODUCTION = "introduction";
		public static final String CONCLUSION = "conclusion";
		public static final String RECOMENDED = "recommended";
		public static final String SUMMARY = "summary";
		
		public static final String SORTDESCRIPTION1 = "sortDescription1";
		public static final String SORTDESCRIPTION2 = "sortDescription2";
		public static final String SORTDESCRIPTION3 = "sortDescription3";
		public static final String SORTDESCRIPTION4 = "sortDescription4";
		public static final String LARGEDESCRIPTION1 = "large Description1";
		public static final String LARGEDESCRIPTION2 = "large Description2";
		public static final String LARGEDESCRIPTION3 = "large Description3";
		public static final String LARGEDESCRIPTION4 = "large Description4";
		
		public static final String SORTDESCRIPTIONAH1 = "sortDescriptionah1";
		public static final String SORTDESCRIPTIONAH2 = "sortDescription2ah";
		public static final String SORTDESCRIPTIONAH3 = "sortDescriptionah3";
		public static final String SORTDESCRIPTIONAH4 = "sortDescriptionah4";
		public static final String LARGEDESCRIPTIONAH1 = "large Descriptionah1";
		public static final String LARGEDESCRIPTIONAH2 = "large Descriptionah2";
		public static final String LARGEDESCRIPTIONAH3 = "large Descriptionah3";
		public static final String LARGEDESCRIPTIONAH4 = "large Descriptionah4";
		public static final String EGROSESVARIABLE = "sortegroses_variable";
		
		public static final String SORTDESCRIPTIONEGROS1 = "sortDescriptionegr1";
		public static final String SORTDESCRIPTIONEGROS2 = "sortDescriptionegr2";
		public static final String SORTDESCRIPTIONEGROS3 = "sortDescriptionegr3";
		public static final String SORTDESCRIPTIONEGROS4 = "sortDescriptionegr4";
		public static final String LARGEDESCRIPTIONEGROS1 = "large Descriptionegr1";
		public static final String LARGEDESCRIPTIONEGROS2 = "large Descriptionegr2";
		public static final String LARGEDESCRIPTIONEGROS3 = "large Descriptionegr3";
		public static final String LARGEDESCRIPTIONEGROS4 = "large Descriptionegr4";
		
		public static final String TEMPO = "tempo";
		
		public static final String CAPACIDAD = "capacidad";
		
	//	public static final String CONTENGENCIA3 = "contengencia3";
		public static final String DEPENDENCIA1 = "dependencia1";
		public static final String DEPENDENCIA2 = "dependencia2";
		public static final String DEPENDENCIA3 = "dependencia3";
		public static final String DEPENDENCIA4 = "dependencia4";
		public static final String DEPENDENCIADESLARGA = "dependencia_des_larga";
		public static final String RESULTADOS1 = "resultados1";
		public static final String RESULTADOS2 = "resultados2";
		public static final String RESULTADOS3 = "resultados3";
		public static final String RESULTADOS4 = "resultados4";
		public static final String SUPUESTOSDESCLARGA = "supuestos_desc_larga";
		public static final String SUPUESTOS1 = "supuestos1";
		public static final String SUPUESTOS2 = "supuestos2";
		public static final String SUPUESTOS3 = "supuestos3";
		public static final String SUPUESTOS4 = "supuestos4";
		public static final String ALCANCESYLIMIT = "alceances";
		public static final String ALCANCESYLIMITCAPCACIDAD = "alceances capacidad";
		public static final String ALCANCESYLIMITHORARIOS = "alceances horarios";
		public static final String ALCANCESYLIMITCOBERTURA = "alcanes cobertura";
		public static final String ALCANCESYLIMITCOMERCIAL = "alcances comercial";
		public static final String ALCANCESYLIMITPERSONAL ="alcances personal";
		public static final String ALCANCESYLIMITDEMANDA = "alcances demanda";
		public static final String ALCANCESYLIMITDURACION = "alcances duracion";
		public static final String ALCANCESYLIMITSEGMEN ="alcances segment";
		public static final String ALCANCESYLIMITTECHNOLOGIA = "alcances technnologia";
		public static final String ALCANCESYLIMITOTRO1 = "alcances otro1";
		public static final String ALCANCESYLIMITOTRO2 = "alcances otra2";
		public static final String ALCANCESYLIMITOTRO3 = "alcances otra3";
		public static final String AHORROSVALUE = "ahross value";
		public static final String AHORROSVARIABLE = "ahross variable";
		public static final String AHORROSSPINNER = "ahross spinner";
		public static final String COSTOSVARIABLE = "costos variable";
		public static final String COSTOSSPINNER = "costos spinner";
		public static final String COSTOSVALUE = "costos value";
		public static final String CHECKEDELEMENT = "checked element";
		public static final String CONTENGENCIADESLARGA = "contengecia_des_larga";
		public static final String RESULTADOSDESCLARGA = "resultadoes_desc_larga";
		public static final String FUNTESINGRESOS = "funtes_ingresos";
				
		public static final String FACEBOOK_TOKEN = "facebook_access_token";
		public static final String FACEBOOK_EXPIRES = "facebook_expires";
	}
	
	public static class Database{
		
		public static final String TABLE_NAME_BUSINESSCASE="businesscase";
		
		public static final String DB_NAME="db_businesscases";
		
		
		public static final String NOMBREDEARCHIVO ="file_name";
		
		public static final String INGRESOSDESCSHORT = "ingross_desc_sort";
		public static final String AHORROSDESCSHORT = "ahorros_desc_sort";
		public static final String EGRESOSDESCSHORT = "egresos_desc_sort";
		public static final String COSTOSDESCSHORT = "costos_desc_sort";
		public static final String INVERSIONDESCSHORT = "invesion_desc_sort";
		public static final String BENFICIOSDESCSHORT = "beneficios_desc_sort";
		public static final String IMPACTOSNEGATIVEDESCSHORT = "impactos_negative_desc_sort";
		public static final String RIESGOSDESCSHORT = "riesgos_desc_sort";
		
		public static final String INGRESOSDESCLONG = "ingross_desc_long";
		public static final String AHORROSDESCLONG = "ahorros_desc_long";
		public static final String EGRESOSDESCLONG = "egresos_desc_long";
		public static final String COSTOSDESCLONG = "costos_desc_long";
		public static final String INVERSIONDESCLONG = "invesion_desc_long";
		public static final String BENFICIOSDESCLONG = "beneficios_desc_long";
		public static final String IMPACTOSNEGATIVEDESCLONG = "impactos_negative_desc_long";
		public static final String RIESGOSDESCLONG = "riesgos_desc_long";

		
		public static final String INTRODUCTION = "introduction";
		public static final String TITULO ="titulo";
		public static final String TEMA = "tema";
		public static final String OBJECTIVE = "objective";
		public static final String TIEMPO = "tiempo";
		public static final String CAPACIDAD="Capacidad_instalada";
		public static final String HORARAIOS="Horarios_de_operacion";
		public static final String COBERTURA="Cobertura_geografic";
		public static final String COMERCIAL="Comercializacion";
		public static final String PERSONAL="Personal";
		public static final String DEMANDA="Demanda_de_servicio";
		public static final String DURACION="Duracion";
		public static final String SEGMENTACION="Segmentacion";
		public static final String TECHNOLOGIA="Technologia";
		public static final String OTRO1="Otro1";
		public static final String OTRO2="Otro2";
		public static final String OTRO3="Otro3";
		
		
		public static final String DEPENDENDCIA1 = "dependencia1";
		public static final String DEPENDENDCIA2 = "dependencia2";
		public static final String DEPENDENDCIA3 = "dependencia3";
		public static final String DEPENDENDCIA4 = "dependencia4";
		public static final String RESULTADOS1 = "resultados1";
		public static final String RESULTADOS2 = "resultados2";
		public static final String RESULTADOS3 = "resultados3";
		public static final String RESULTADOS4 = "resultados4";
		
		public static final String DEPENDENCIADESLARGA = "dependencia_des_larga";
		public static final String CONTENGENCIADESLARGA = "contengecia_des_larga";
		public static final String RESULTADOSDESCLARGA = "resultadoes_desc_larga";
		
		public static final String SUPESTOS1 ="supestos1";
		public static final String SUPESTOS2 ="supestos2";
		public static final String SUPESTOS3 ="supestos3";
		public static final String SUPESTOS3DESCLARGA ="supestos_desc_larga";
		
		public static final String CONCLUSION = "conclusion";
		public static final String RECOMMENDED ="recommend";
		public static final String SUMARIOEJECUTIO = "sumarioejecutio";
		
		public static final String CHECKEDELEMENT = "checked_element";
		

		
		public static final String CREATE_BUSINESSCASE_QUERY= "create table "+TABLE_NAME_BUSINESSCASE+" (_id integer primary key autoincrement, "+NOMBREDEARCHIVO+" text not null, "+TITULO+" text, "+
				TEMA+" text, "+OBJECTIVE+" text, "+INGRESOSDESCSHORT+" text, "+INGRESOSDESCLONG+" text, "+AHORROSDESCSHORT+" text, "+AHORROSDESCLONG+" text, "+EGRESOSDESCSHORT+" text, "+EGRESOSDESCLONG+" text, "+
				COSTOSDESCSHORT+" text, "+COSTOSDESCLONG+" text, "+INVERSIONDESCSHORT+" text, "+INVERSIONDESCLONG+" text, "+BENFICIOSDESCSHORT+" text, "+BENFICIOSDESCLONG+" text, "+IMPACTOSNEGATIVEDESCSHORT+" text, "+
				IMPACTOSNEGATIVEDESCLONG+" text, "+RIESGOSDESCSHORT+" text, "+RIESGOSDESCLONG+" text, "+INTRODUCTION+" text, "+
				TIEMPO+" text, "+CAPACIDAD+" text, "+HORARAIOS+" text, "+COBERTURA+" text, "+COMERCIAL+" text, "+PERSONAL+" text, "+DEMANDA+" text, "+DURACION+" text, "+SEGMENTACION+" text, "+TECHNOLOGIA+" text, "+OTRO1+" text, "+OTRO2+" text, "+OTRO3+" text, "+
				DEPENDENDCIA1+" text, "+DEPENDENDCIA2+" text, "+DEPENDENDCIA3+" text, "+DEPENDENDCIA4+" text, "+RESULTADOS1+" text, "+RESULTADOS2+" text, "+RESULTADOS3+" text, "+RESULTADOS4+" text,"+
				SUPESTOS1+" text, "+SUPESTOS2+" text, "+SUPESTOS3+" text, "+CONCLUSION+" text, "+RECOMMENDED+" text, "+SUMARIOEJECUTIO+" text, "+CONTENGENCIADESLARGA+" text, "+DEPENDENCIADESLARGA+" text, "+RESULTADOSDESCLARGA+" text, "+SUPESTOS3DESCLARGA+" text, "+CHECKEDELEMENT+" text);";
		
	}
	
	
	
	
}
