package com.sergio.businesscase.ui;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.apptentive.android.sdk.Apptentive;
import com.aspose.words.BreakType;
import com.aspose.words.CellVerticalAlignment;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.Font;
import com.aspose.words.ParagraphAlignment;
import com.aspose.words.StyleIdentifier;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.PreferenceUtils;


public class WordFile extends Activity{
	
	private static final String AFTERTABLEMETHODOS = "Dado lo anterior, el VPN acumulado que generar‡ esta propuesta al terminar el X a–o de su puesta en marcha ser‡ de $X,000.";
	private static final String TIPVALUE = "Considerando los mismos flujos de efectivos empleados en el c‡lculo del Valor Presente Neto se deriva la siguiente Tasa Interna de Retorno:\nTIR = X% anual";
	private static final String SECONDTABLEBELOWTEXT = "Como se puede observar en la tabla anterior, el VPN del flujo de efectivo acumulado comienza a ser positivo a partir del 4to a–o de operaciones, por lo que es en este a–o cuando se recupera la inversión, lo anterior como resultado del monto de inversión y la propia naturaleza del negocio";
	String sdCard;
	PreferenceUtils pref;
	Document doc;
	DocumentBuilder builder;
	File directory;
	
	String str1,str2,str3,str4,strlar1,strlar2,strlar3,strlar4;
	int sendmail_flag;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		View v= new View(this);
//		v.setBackgroundResource(R.drawable.splash);
		setContentView(R.layout.word_excel_results);
		
		Intent intent = getIntent();
		sendmail_flag = intent.getIntExtra("SendMail", 0);
		
		pref=new PreferenceUtils(this);
		init();
		
	}
	
	private void init() {
		try{
			generateDocument();			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onStart()
	{
		super.onStart();
		Apptentive.onStart(this);
		FlurryAgent.onStartSession(this, Attributes.FLURRY_API_KEY);
	}
	 
	@Override
	protected void onStop()
	{
		super.onStop();	
		Apptentive.onStop(this);
		FlurryAgent.onEndSession(this);
	}
	
	public void generateDocument() throws Exception{
		
//		Boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
//		
//		if(isSDPresent){
//			return;
//		}else{
//			
//		}
		
		//path of the sdCard
		File sdCard=Environment.getExternalStorageDirectory();
	
		directory=new File(sdCard.getAbsoluteFile()+"/BusinessCase");
		directory.mkdirs();
		
		final String str=directory+"/"+ pref.getHeading()+".docx";
		final File file =new File(str);
		//Generate word document
		doc=new Document();
		// Use the document builder to insert text and other elements into the document.
		builder=new DocumentBuilder(doc);
		
		getFontStyle("Business Case");
		if(pref.getTilte()!= null)
		builder.writeln(pref.getTilte());
		builder.insertBreak(BreakType.PAGE_BREAK);
		//builder.getFont().setSize(18);
		
		builder.writeln("Apreciación Global");
		builder.writeln("Fecha:");
		builder.writeln("Preparado para: ");
		builder.writeln("Título");
		if(pref.getTilte()!=null)
			builder.writeln(pref.getTilte());
		
		builder.writeln("Tema");
		if(pref.getTema()!=null)
			builder.writeln(pref.getTema());
		Log.d("TAG", "Word open");
		builder.writeln("Objetivo");
		if(pref.getObjective()!=null)
			builder.writeln(pref.getObjective());
		builder.writeln("Descargo de Responsabilidades:");
		builder.insertBreak(BreakType.PAGE_BREAK);
		
		getFontStyle("Sumario Ejecutivo");
		if(pref.getSummary()!=null)
			builder.writeln(pref.getSummary());
		builder.insertBreak(BreakType.PAGE_BREAK);
		
		getFontStyle("Introducción");
		if(pref.getIntroduction()!=null)
			builder.writeln(pref.getIntroduction());
		builder.insertBreak(BreakType.PAGE_BREAK);
		
		getFontStyle("MŽtodos");
		builder.writeln(Attributes.WORDFILEMETODOS);
		startNewTable("C‡lculo del Valor Presente Neto");	
	
		//Inserting cell to second row
		insertRow("Per’odo de Tiempo","Flujo de Efectivo Neto","Valor Presente Flujo");
		insertRow("A–o 0","","");
		insertRow("A–o 1","","");
		insertRow("A–o 2","","");
		insertRow("A–o 3","","");
		insertRow("A–o 4","","");
		insertRow("A–o 5","","");
		insertRow("A–o 6","","");
		insertRow("A–o 7","","");
		insertRow("A–o 8","","");
		insertRow("A–o 9","","");
		insertRow("A–o 10","","");
	
		//end the table
		builder.endTable();
		builder.writeln(AFTERTABLEMETHODOS);
		getFontStyle("Tasa interna de Rendimiento (TIR)");
		builder.writeln(TIPVALUE);
		getFontStyle("Tiempo de Recuperación");
		builder.writeln("Para el c‡lculo del tiempo de recuperación de la inversión se empleó la siguiente tabla:");
		startNewTable("C‡lculo del Tiempo de Recuperación");
		insertRow("Per’odo de Tiempo", "Valor Presente", "Valor Presente Acumulado");
		insertRow("A–o 0","","");
		insertRow("A–o 1","","");
		insertRow("A–o 2","","");
		insertRow("A–o 3","","");
		insertRow("A–o 4","","");
		insertRow("A–o 5","","");
		builder.endTable();
		builder.writeln(SECONDTABLEBELOWTEXT);
		builder.insertBreak(BreakType.PAGE_BREAK);
		
		getFontStyle("Supuestos, Alcances y Limites");
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Supuestos");
		builder.getFont().clearFormatting();
		builder.writeln("Supuestos1");
		if(pref.getSupuestos1()!=null){
			builder.writeln(pref.getSupuestos1());
		}
		builder.writeln("Supuestos2");
		if(pref.getSupuestos2()!=null){
			builder.writeln(pref.getSupuestos2());
		}
		builder.writeln("Supuestos3");
		if(pref.getSupuestos3()!=null){
			builder.writeln(pref.getSupuestos3());
		}
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Alcances y Límites");
		builder.getFont().clearFormatting();
				
		
		if(pref.getAlcancesYLimit()!=null){
			builder.writeln("Tiempo");
			builder.writeln(pref.getAlcancesYLimit());
		}
		
		if(pref.getAlcancesYLimitCapacidad()!=null){
			builder.writeln("Capacidad instalada");
			builder.writeln(pref.getAlcancesYLimitCapacidad());
		}
		
		if(pref.getAlcancesYLimitHorarios()!=null){
			builder.writeln("Horarios de operación");
			builder.writeln(pref.getAlcancesYLimitHorarios());
		}
		
		if(pref.getAlcancesYLimitsCobertura()!=null){
			builder.writeln("Cobertura geográfica");
			builder.writeln(pref.getAlcancesYLimitsCobertura());
		}
		
		if(pref.getAlcancesYLimitsComercial()!=null){
			builder.writeln("Comercialización");
			builder.writeln(pref.getAlcancesYLimitsComercial());
		}
		
		if(pref.getAlcancesYLimitsPersonal()!=null){
			builder.writeln("Personal");
			builder.writeln(pref.getAlcancesYLimitsPersonal());
		}
		
		if(pref.getAlcancesYLimitsDemanda()!=null){
			builder.writeln("Demanda de servicio");
			builder.writeln(pref.getAlcancesYLimitsDemanda());
		}
		
		if(pref.getAlcancesYLimitsSegmen()!=null){
			builder.writeln("Segmentación");
			builder.writeln(pref.getAlcancesYLimitsSegmen());
		}
		
		if(pref.getAlcancesYLimitsDuracion()!=null){
			builder.writeln("Duración");
			builder.writeln(pref.getAlcancesYLimitsDuracion());
		}
		
		if(pref.getAlcancesYLimitsTechnologia()!=null){
			builder.writeln("Tecnología");
			builder.writeln(pref.getAlcancesYLimitsTechnologia());
		}
		builder.writeln("Otros");
		if(pref.getAlcancesYLimitsOtro1()!=null){
			builder.writeln(pref.getAlcancesYLimitsOtro1());
		}
		if(pref.getAlcancesYLimitsOtro2()!=null){
			builder.writeln(pref.getAlcancesYLimitsOtro2());
		}
		if(pref.getAlcancesYLimitsOtro3()!=null){
			builder.writeln(pref.getAlcancesYLimitsOtro3());
		}
		
		
		builder.insertBreak(BreakType.PAGE_BREAK);
		
		getFontStyle("Modelos Costo/Beneficio");
		builder.writeln("Beneficio Monetarios");
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Ingresos");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShort1()!=null||pref.getDescriptionLarge1()!=null){
				try{
					str1=pref.getDescriptionShort1().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLarge1().split("~")[i];
					builder.writeln(strlar1);
					
					}catch (Exception e) {
						
					}
			}
		}
		builder.writeln("Ahorros");
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortAhorros1()!=null||pref.getDescriptionLargeAhorros1()!=null){
				try{
					str1=pref.getDescriptionShortAhorros1().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeAhorros1().split("~")[i];
					builder.writeln(strlar1);
					
					
				}catch (Exception e) {
						
				}
			}
		}
		builder.writeln("Otros Beneficios");
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortBeneficios()!=null || pref.getDescriptionLargeBeneficios()!=null){
				try{
					str1=pref.getDescriptionShortBeneficios().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeBeneficios().split("~")[i];
					builder.writeln(strlar1);
					
				}catch (Exception e) {
						
				}
			}
		}
		
		builder.insertBreak(BreakType.PAGE_BREAK);
		builder.writeln("Costos y/o Gastos Monetarios");
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Egresos");
		builder.getFont().clearFormatting();
		
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortEgresos1()!=null ||pref.getDescriptionLargeEgresos1()!=null){
				try{
					str1=pref.getDescriptionShortEgresos1().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeEgresos1().split("~")[i];
					builder.writeln(strlar1);
					
				}catch (Exception e) {
						
				}
			}
		}
		
		
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Costos");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortCostos()!=null ||pref.getDescriptionLargeCostos()!=null){
				try{
					str1=pref.getDescriptionShortCostos().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeCostos().split("~")[i];
					builder.writeln(strlar1);
					
				}catch (Exception e) {
						
				}
			}
		}
		
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Inversión");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortInversion()!=null ||pref.getDescriptionLargeInversion()!=null){
				try{
					str1=pref.getDescriptionShortInversion().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeInversion().split("~")[i];
					builder.writeln(strlar1);
					
				}catch (Exception e) {
						
				}
			}
		}
		
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Otros Impactos Negativos No Financieros ");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortImpactos()!=null ||pref.getDescriptionLargeImpactos()!=null){
				try{
					str1=pref.getDescriptionShortImpactos().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeImpactos().split("~")[i];
					builder.writeln(strlar1);				
				}catch (Exception e) {
						
				}
			}
		}
		builder.getBold();
		builder.writeln("Riesgos");
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortRiesgos()!=null ||pref.getDescriptionLargeRiesgos()!=null){
				try{
					str1=pref.getDescriptionShortRiesgos().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeRiesgos().split("~")[i];
					builder.writeln(strlar1);				
				}catch (Exception e) {
						
				}
			}
		}
		builder.insertBreak(BreakType.PAGE_BREAK);
		getFontStyle("Fuente de Datos y Métodos");
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Beneficios Financieros");
		builder.writeln("Ingresos");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShort1()!=null){
				try{
					str1=pref.getDescriptionShort1().split("~")[i];
					builder.writeln(str1);
				}catch (Exception e) {
					
				}
			}
		}
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Ahorros");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortAhorros1()!=null){
				try{
					str1=pref.getDescriptionShortAhorros1().split("~")[i];
					builder.writeln(str1);
				
				}catch (Exception e) {
					
				}
			}
		}
		
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Impactos Negativos Financieros");
		builder.writeln("Egresos Normales");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortEgresos1()!=null){
				try{
					str1=pref.getDescriptionShortEgresos1().split("~")[i];
					builder.writeln(str1);
				}catch (Exception e) {
					
				}
			}
		}
		
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Costos Normales");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortCostos()!=null){
				try{
					String str1=pref.getDescriptionShortCostos().split("~")[i];
					builder.writeln(str1);
				
				}catch (Exception e) {
					
				}
			}
		}
		builder.getFont().setColor(Color.rgb(129, 138, 143));
		builder.writeln("Inversión");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortInversion()!=null){
				try{
					String str1=pref.getDescriptionShortInversion().split("~")[i];
					builder.writeln(str1);
				
				}catch (Exception e) {
					
				}
			}
		}
		
		builder.insertBreak(BreakType.PAGE_BREAK);
		getFontStyle("Modelo Financiero");
		builder.writeln("Flujo de Efectivo Mensual Proyectado");
		builder.getFont().setColor(Color.RED);
		builder.writeln("Pegar celdas d5:p50 de la hoja “Flujo de Efectivo”,");
		builder.getFont().clearFormatting();
		
		builder.insertBreak(BreakType.PAGE_BREAK);
		builder.writeln("Flujo de Efectivo Anual Proyectado");
		builder.getFont().setColor(Color.RED);
		builder.writeln("Pegar de las celdas AF6:AL50 de la hoja “Flujo de Efectivo”,");
		builder.getFont().clearFormatting();
		
		builder.insertBreak(BreakType.PAGE_BREAK);
		builder.getBold();
		builder.writeln("Resultados no Financieros");
		if(pref.getResultados1()!=null){
			builder.writeln(pref.getResultados1());
		}
		if(pref.getResultados2()!=null){
			builder.writeln(pref.getResultados2());
		}
		if(pref.getResultados3()!=null){
			builder.writeln(pref.getResultados3());
		}
		
		builder.getFont().setColor(Color.BLUE);
		builder.writeln("Beneficios no Financieros");
		builder.getFont().clearFormatting();
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortBeneficios()!=null ||pref.getDescriptionLargeBeneficios()!=null);{
				try{
					str1=pref.getDescriptionShortBeneficios().split("~")[i];
					builder.writeln(str1);
					strlar1=pref.getDescriptionLargeBeneficios().split("~")[i];
					builder.writeln(strlar1);
					
					}catch (Exception e) {
						
					}
				
			}
		}
		
		builder.getBold();
		builder.writeln("Análisis de Riesgos");
		builder.getFont().setColor(Color.BLUE);
		builder.writeln("Simulación Montecarlo");
		
		builder.insertBreak(BreakType.PAGE_BREAK);
		getFontStyle("Contingencias y Dependencias");
		builder.writeln("Contingencia");
		for(int i=0;i<4;i++){
			if(pref.getDescriptionShortRiesgos()!=null ){
				try{
					str1=pref.getDescriptionShortRiesgos().split("~")[i];
					builder.writeln(str1);
					

				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		builder.writeln("Dependencia1");
		if(pref.getDependencia1()!=null){
			builder.writeln(pref.getDependencia1());
		}
		
		builder.writeln("Dependencia2");
		if(pref.getDependencia2()!=null){
			builder.writeln(pref.getDependencia2());
		}
		
		builder.writeln("Dependencia3");
		if(pref.getDependencia3()!=null){
			builder.writeln(pref.getDependencia3());
		}
		builder.writeln("Dependencia4");
		if(pref.getDependencia4()!=null){
			builder.writeln(pref.getDependencia4());
		}
		
		getFontStyle("Conclusiones y Recomendaciones");
		builder.writeln("Conclusiones");
		if(pref.getConclusion()!=null){
			builder.writeln(pref.getConclusion());
		}
		builder.writeln("Recomendaciones");
		if(pref.getRecommendies()!=null){
			builder.writeln(pref.getRecommendies()+"\n");
		}
		builder.insertBreak(BreakType.PAGE_BREAK);
		getFontStyle("Contenido");
		// Insert a table of contents at the beginning of the document.
		builder.getParagraphFormat().setStyleIdentifier(StyleIdentifier.HEADING_1);
		builder.writeln("Apreciación Global");
		builder.writeln("Apreciación Global");
		builder.writeln("Sumario Ejecutivo");
		builder.writeln("Introducción");
		builder.writeln("MŽtodos");
		builder.writeln("Supuestos, Alcances y L’mites");
		builder.writeln("Modelo Costo/Beneficio y Riesgos");
		builder.writeln("Fuente de Datos y MŽtodos");
		builder.writeln("Modelo Financiero");
		builder.writeln("Contingencias y Dependencias");
		builder.writeln("Conclusiones y Recomendaciones");
			
		doc.updateFields();
		//save the document with docx formats
		if(pref.getHeading()!=null){
			doc.save(str);	
		}else{
			doc.save(sdCard+"b-case.docx");
		}
		
		if(sendmail_flag != 5){
			
			Dialog dlg = new Dialog(this);
			dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dlg.setContentView(R.layout.document_open_dlg);
			
			TextView msg = (TextView)dlg.findViewById(R.id.docopen_title);
			msg.setText("El archivo fue guardado en:"+str+"\n¿Deseas abrirlo?");
			
			dlg.findViewById(R.id.docopen_yes).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent= new Intent(Intent.ACTION_VIEW);
					intent.setDataAndType(Uri.fromFile(file), "application/msword");
					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					try{
						startActivity(intent);
						finish();
					}catch (ActivityNotFoundException e) {
						//No application view ask to download
						AlertDialog.Builder builder= new AlertDialog.Builder(WordFile.this);
						builder.setTitle("No Application Found!");
						builder.setMessage("Download one from Google Play Store?");
						builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								finish();
								Intent markerIntent=new Intent(Intent.ACTION_VIEW);
								markerIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.infraware.polarisoffice4"));
								startActivity(markerIntent);
								
							}
						});
					    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								onBackPressed();
								
							}
						});
					    builder.show();
					}
				}
			});
			
			dlg.findViewById(R.id.docopen_cancel).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
			
			dlg.show();
			
			
			
			
			
//			AlertDialog.Builder adb= new AlertDialog.Builder(this);
//			adb.setMessage("FIle is save as"+str+"\n Do you want to Open");
//			adb.setCancelable(false);
//			adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//				
//				
//				public void onClick(DialogInterface dialog, int which) {
//					
//					Intent intent= new Intent(Intent.ACTION_VIEW);
//					intent.setDataAndType(Uri.fromFile(file), "application/msword");
//					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//					try{
//						startActivity(intent);
//						finish();
//					}catch (ActivityNotFoundException e) {
//						//No application view ask to download
//						AlertDialog.Builder builder= new AlertDialog.Builder(WordFile.this);
//						builder.setTitle("No Application Found!");
//						builder.setMessage("Download one from Google Play Store?");
//						builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//							
//							@Override
//							public void onClick(DialogInterface dialog, int which) {
//								finish();
//								Intent markerIntent=new Intent(Intent.ACTION_VIEW);
//								markerIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.infraware.polarisoffice4"));
//								startActivity(markerIntent);
//								
//							}
//						});
//					    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
//							
//							@Override
//							public void onClick(DialogInterface dialog, int which) {
//								onBackPressed();
//								
//							}
//						});
//					    builder.show();
//					}
//				}
//			});
//			adb.setNegativeButton("No,Thanks", new DialogInterface.OnClickListener() {
//				
//				
//				public void onClick(DialogInterface dialog, int which) {
//					finish();
//					
//				}
//			});
//			adb.show();
		} else{
			
			finish();
			
			Uri uri = Uri.fromFile(file);
			String path = uri.getPath();
			
			Intent email_intent = new Intent(Intent.ACTION_SEND);
			email_intent.setType("text/plan");
			
			ArrayList<Uri> uris = new ArrayList<Uri>();
			Uri u = Uri.fromFile(file);
			uris.add(u);
			email_intent.putExtra(Intent.EXTRA_STREAM,	Uri.parse("file://" + path));
			startActivity(Intent.createChooser(email_intent, "Choose an Email Client"));
		}
		
	}
	
//	public void onActivityResult(int requestcode, int resultcode, Intent data){
//		if (requestcode == 1000){
//			finish();
//		}
//	}
	
	private void startNewTable(String string) {
		//inserting table to word
		 builder.startTable();
		 //inserting cell to first row table
		 builder.insertCell();
		 //set header row color
		 builder.getCellFormat().getShading().setBackgroundPatternColor(Color.rgb(129, 138, 143));
		 builder.getParagraphFormat().setAlignment(ParagraphAlignment.CENTER);
		 builder.writeln(string);
		 builder.endTable();
	}

	private void insertRow(String cell1,String cell2, String cell3){
		 builder.getCellFormat().getShading().setBackgroundPatternColor(Color.WHITE);			
		 builder.getCellFormat().setVerticalAlignment(CellVerticalAlignment.CENTER);
		 builder.insertCell();
		 builder.write(cell1);
		 
		 builder.insertCell();
		 builder.write(cell2);
		
		 builder.insertCell();
		 builder.write(cell3);
		 builder.endRow();
		
		
	}
	
	private void getFontStyle(String text){
		Font font=builder.getFont();
		font.setSize(22);
		font.setBold(true);
		builder.writeln(text);
		// Revert to default formatting.
		builder.getFont().clearFormatting();
	}

}
