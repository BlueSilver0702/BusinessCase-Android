package com.sergio.businesscase.db;

import java.util.ArrayList;

import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.ui.AlcancesYLimites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBAdapter {

	private DBAHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;
	private Context context;
	ArrayList<String> position,value;
	AlcancesYLimites adapter;
	
	public DBAdapter( Context context) {
		this.context=context;
		position=new ArrayList<String>();
		value=new ArrayList<String>();
		
	}
	
	public DBAdapter open(){
		sqLiteHelper=new DBAHelper(context, Attributes.Database.DB_NAME, null, 1);
		sqLiteDatabase=sqLiteHelper.getWritableDatabase();
		
		return this;
		
	}
	
	public void close(){
		if(sqLiteDatabase!=null && sqLiteDatabase.isOpen()){
			sqLiteDatabase.close();
			if(sqLiteHelper!=null){
				sqLiteHelper.close();
			}
		}
	}
	
	public Cursor getFileName(){
		return sqLiteDatabase.rawQuery("select "+Attributes.Database.NOMBREDEARCHIVO+" from "+Attributes.Database.TABLE_NAME_BUSINESSCASE, null);
	}
	
	
	public ArrayList<String> getOpenFile(String filename){
		ArrayList<String> rowvalues=new ArrayList<String>();
		Cursor cursor;
		 cursor =sqLiteDatabase.query(Attributes.Database.TABLE_NAME_BUSINESSCASE, null, Attributes.Database.NOMBREDEARCHIVO+ "=?", new String []{String.valueOf(filename)}, null, null, null);
		
		 Log.d("TAG","column values is "+rowvalues);
		if (cursor != null)
			cursor.moveToFirst();
		if (cursor.moveToFirst()){
			   do{
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.TITULO)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.TEMA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.OBJECTIVE)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.INGRESOSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.INGRESOSDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.AHORROSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.AHORROSDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.EGRESOSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.EGRESOSDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.COSTOSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.COSTOSDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.INGRESOSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.INVERSIONDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.BENFICIOSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.BENFICIOSDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.IMPACTOSNEGATIVEDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.IMPACTOSNEGATIVEDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RIESGOSDESCSHORT)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RIESGOSDESCLONG)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.INTRODUCTION)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.TIEMPO)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.CAPACIDAD)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.HORARAIOS)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.COBERTURA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.COMERCIAL)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.PERSONAL)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DEMANDA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DURACION)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.SEGMENTACION)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.TECHNOLOGIA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.OTRO1)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.OTRO2)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.OTRO3)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DEPENDENDCIA1)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DEPENDENDCIA2)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DEPENDENDCIA3)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DEPENDENDCIA4)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RESULTADOS1)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RESULTADOS2)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RESULTADOS3)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RESULTADOS4)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.SUPESTOS1)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.SUPESTOS2)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.SUPESTOS3)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.CONCLUSION)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RECOMMENDED)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.SUMARIOEJECUTIO)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.CONTENGENCIADESLARGA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.DEPENDENCIADESLARGA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.RESULTADOSDESCLARGA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.SUPESTOS3DESCLARGA)));
				   rowvalues.add(cursor.getString(cursor.getColumnIndex(Attributes.Database.CHECKEDELEMENT)));
				   			     
			   }while(cursor.moveToNext());
			}
		cursor.close();
		Log.d("TAG","column values is "+rowvalues);
		
		return rowvalues;
				
		
	}
	
	
	public void insert(String fileName,String title,String tema,String objective,String ingresosorta, String ingresoslarge ,String ahrorrossort, String ahrorroslarge, String egresosort, String egresosLarge ,
			String costosSort,String costosLarge, String inversonsort, String inversionLarge, String beneficiosSort, String beneficiosLarge, String impactosSort, String impactosLarge ,String riesgosSort, String riesgosLarga,
			String introduction, String tiempo, String  capacida, String  horarios, String cobertura, String commercial, String personal, String demanda, String duracion, String segment, String technologia, String otro1, String otro2, String otro3,
			String dependencia1, String dependencia2, String dependencia3,String dependencia4, String resultados1,String resultados2,String resultados3,String resultados4,
			String supestos1, String supestos2, String supestos3, String conclusion, String recommend,String sumarioejecutivo, String conDesLarga, String depDesLarga, String resDesLarga, String susDesLarga ,String checkedEleement){
		ContentValues contentValues=new ContentValues();
		try{
			contentValues.put(Attributes.Database.NOMBREDEARCHIVO, fileName);
			contentValues.put(Attributes.Database.TITULO, title);
			contentValues.put(Attributes.Database.TEMA, tema);
			contentValues.put(Attributes.Database.OBJECTIVE, objective);
			contentValues.put(Attributes.Database.INGRESOSDESCSHORT, ingresosorta);
			contentValues.put(Attributes.Database.INGRESOSDESCLONG, ingresoslarge);
			contentValues.put(Attributes.Database.AHORROSDESCSHORT, ahrorrossort);
			contentValues.put(Attributes.Database.AHORROSDESCLONG, ahrorroslarge);
			contentValues.put(Attributes.Database.EGRESOSDESCSHORT, egresosort);
			contentValues.put(Attributes.Database.EGRESOSDESCLONG, egresosLarge);
			contentValues.put(Attributes.Database.COSTOSDESCSHORT, costosSort);
			contentValues.put(Attributes.Database.COSTOSDESCLONG, costosLarge);
			contentValues.put(Attributes.Database.INVERSIONDESCSHORT, inversonsort);
			contentValues.put(Attributes.Database.INVERSIONDESCLONG, inversionLarge);
			contentValues.put(Attributes.Database.BENFICIOSDESCSHORT, beneficiosSort);
			contentValues.put(Attributes.Database.BENFICIOSDESCLONG, beneficiosLarge);
			contentValues.put(Attributes.Database.IMPACTOSNEGATIVEDESCSHORT, impactosSort);
			contentValues.put(Attributes.Database.IMPACTOSNEGATIVEDESCLONG, impactosLarge);
			contentValues.put(Attributes.Database.RIESGOSDESCSHORT, riesgosSort);
			contentValues.put(Attributes.Database.RIESGOSDESCLONG, riesgosLarga);
			contentValues.put(Attributes.Database.INTRODUCTION, introduction);
			contentValues.put(Attributes.Database.TIEMPO, tiempo);
			contentValues.put(Attributes.Database.CAPACIDAD, capacida);
			contentValues.put(Attributes.Database.HORARAIOS, horarios);
			contentValues.put(Attributes.Database.COBERTURA, cobertura);
			contentValues.put(Attributes.Database.COMERCIAL, commercial);
			contentValues.put(Attributes.Database.PERSONAL, personal);
			contentValues.put(Attributes.Database.DEMANDA, demanda);
			contentValues.put(Attributes.Database.DURACION, duracion);
			contentValues.put(Attributes.Database.SEGMENTACION, segment);
			contentValues.put(Attributes.Database.TECHNOLOGIA, technologia);
			contentValues.put(Attributes.Database.OTRO1, otro1);
			contentValues.put(Attributes.Database.OTRO2, otro2);
			contentValues.put(Attributes.Database.OTRO3, otro3);
			contentValues.put(Attributes.Database.DEPENDENDCIA1, dependencia1);
			contentValues.put(Attributes.Database.DEPENDENDCIA2, dependencia2);
			contentValues.put(Attributes.Database.DEPENDENDCIA3, dependencia3);
			contentValues.put(Attributes.Database.DEPENDENDCIA4, dependencia4);
			contentValues.put(Attributes.Database.RESULTADOS1, resultados1);
			contentValues.put(Attributes.Database.RESULTADOS2, resultados2);
			contentValues.put(Attributes.Database.RESULTADOS3, resultados3);
			contentValues.put(Attributes.Database.RESULTADOS4, resultados4);
			contentValues.put(Attributes.Database.SUPESTOS1, supestos1);
			contentValues.put(Attributes.Database.SUPESTOS2, supestos2);
			contentValues.put(Attributes.Database.SUPESTOS3, supestos3);
			contentValues.put(Attributes.Database.CONCLUSION, conclusion);
			contentValues.put(Attributes.Database.RECOMMENDED, recommend);
			contentValues.put(Attributes.Database.SUMARIOEJECUTIO, sumarioejecutivo);
			contentValues.put(Attributes.Database.CONTENGENCIADESLARGA, conDesLarga);
			contentValues.put(Attributes.Database.DEPENDENCIADESLARGA, depDesLarga);
			contentValues.put(Attributes.Database.RESULTADOSDESCLARGA, resDesLarga);
			contentValues.put(Attributes.Database.SUPESTOS3DESCLARGA, susDesLarga);
			contentValues.put(Attributes.Database.CHECKEDELEMENT, checkedEleement);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		sqLiteDatabase.insert(Attributes.Database.TABLE_NAME_BUSINESSCASE, null, contentValues);
	}
	
	 public void updateRow(String fileName,String title,String tema,String objective,String ingresosorta, String ingresoslarge ,String ahrorrossort, String ahrorroslarge, String egresosort, String egresosLarge ,
				String costosSort,String costosLarge, String inversonsort, String inversionLarge, String beneficiosSort, String beneficiosLarge, String impactosSort, String impactosLarge ,String riesgosSort, String riesgosLarga,
				String introduction, String tiempo, String  capacida, String  horarios, String cobertura, String commercial, String personal, String demanda, String duracion, String segment, String technologia, String otro1, String otro2, String otro3,
				String dependencia1, String dependencia2, String dependencia3, String dependencia4, String resultados1,String resultados2,String resultados3, String resultados4,
				String supestos1, String supestos2, String supestos3, String conclusion, String recommend,String sumarioejecutivo, String conDesLarga, String depDesLarga, String resDesLarga, String susDesLarga,String checkedEleement){
			ContentValues contentValues=new ContentValues();
			try{
				contentValues.put(Attributes.Database.NOMBREDEARCHIVO, fileName);
				contentValues.put(Attributes.Database.TITULO, title);
				contentValues.put(Attributes.Database.TEMA, tema);
				contentValues.put(Attributes.Database.OBJECTIVE, objective);
				contentValues.put(Attributes.Database.INGRESOSDESCSHORT, ingresosorta);
				contentValues.put(Attributes.Database.INGRESOSDESCLONG, ingresoslarge);
				contentValues.put(Attributes.Database.AHORROSDESCSHORT, ahrorrossort);
				contentValues.put(Attributes.Database.AHORROSDESCLONG, ahrorroslarge);
				contentValues.put(Attributes.Database.EGRESOSDESCSHORT, egresosort);
				contentValues.put(Attributes.Database.EGRESOSDESCLONG, egresosLarge);
				contentValues.put(Attributes.Database.COSTOSDESCSHORT, costosSort);
				contentValues.put(Attributes.Database.COSTOSDESCLONG, costosLarge);
				contentValues.put(Attributes.Database.INVERSIONDESCSHORT, inversonsort);
				contentValues.put(Attributes.Database.INVERSIONDESCLONG, inversionLarge);
				contentValues.put(Attributes.Database.BENFICIOSDESCSHORT, beneficiosSort);
				contentValues.put(Attributes.Database.BENFICIOSDESCLONG, beneficiosLarge);
				contentValues.put(Attributes.Database.IMPACTOSNEGATIVEDESCSHORT, impactosSort);
				contentValues.put(Attributes.Database.IMPACTOSNEGATIVEDESCLONG, impactosLarge);
				contentValues.put(Attributes.Database.RIESGOSDESCSHORT, riesgosSort);
				contentValues.put(Attributes.Database.RIESGOSDESCLONG, riesgosLarga);
				contentValues.put(Attributes.Database.INTRODUCTION, introduction);
				contentValues.put(Attributes.Database.TIEMPO, tiempo);
				contentValues.put(Attributes.Database.CAPACIDAD, capacida);
				contentValues.put(Attributes.Database.HORARAIOS, horarios);
				contentValues.put(Attributes.Database.COBERTURA, cobertura);
				contentValues.put(Attributes.Database.COMERCIAL, commercial);
				contentValues.put(Attributes.Database.PERSONAL, personal);
				contentValues.put(Attributes.Database.DEMANDA, demanda);
				contentValues.put(Attributes.Database.DURACION, duracion);
				contentValues.put(Attributes.Database.SEGMENTACION, segment);
				contentValues.put(Attributes.Database.TECHNOLOGIA, technologia);
				contentValues.put(Attributes.Database.OTRO1, otro1);
				contentValues.put(Attributes.Database.OTRO2, otro2);
				contentValues.put(Attributes.Database.OTRO3, otro3);
				contentValues.put(Attributes.Database.DEPENDENDCIA1, dependencia1);
				contentValues.put(Attributes.Database.DEPENDENDCIA2, dependencia2);
				contentValues.put(Attributes.Database.DEPENDENDCIA3, dependencia3);
				contentValues.put(Attributes.Database.DEPENDENDCIA4, dependencia4);
				contentValues.put(Attributes.Database.RESULTADOS1, resultados1);
				contentValues.put(Attributes.Database.RESULTADOS2, resultados2);
				contentValues.put(Attributes.Database.RESULTADOS3, resultados3);
				contentValues.put(Attributes.Database.RESULTADOS4, resultados4);
				contentValues.put(Attributes.Database.SUPESTOS1, supestos1);
				contentValues.put(Attributes.Database.SUPESTOS2, supestos2);
				contentValues.put(Attributes.Database.SUPESTOS3, supestos3);
				contentValues.put(Attributes.Database.CONCLUSION, conclusion);
				contentValues.put(Attributes.Database.RECOMMENDED, recommend);
				contentValues.put(Attributes.Database.SUMARIOEJECUTIO, sumarioejecutivo);
				contentValues.put(Attributes.Database.CONTENGENCIADESLARGA, conDesLarga);
				contentValues.put(Attributes.Database.DEPENDENCIADESLARGA, depDesLarga);
				contentValues.put(Attributes.Database.RESULTADOSDESCLARGA, resDesLarga);
				contentValues.put(Attributes.Database.SUPESTOS3DESCLARGA, susDesLarga);
				contentValues.put(Attributes.Database.CHECKEDELEMENT, checkedEleement);
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			sqLiteDatabase.update(Attributes.Database.TABLE_NAME_BUSINESSCASE, contentValues, Attributes.Database.NOMBREDEARCHIVO+" = ?", new String[]{fileName});
	 }
	 
	 public String checkName(String value){
		 String username="";
	
		
		 try{
			 Cursor cursor =sqLiteDatabase.query(Attributes.Database.TABLE_NAME_BUSINESSCASE, null, Attributes.Database.NOMBREDEARCHIVO+ "=?", new String []{String.valueOf(value)}, null, null, null);	 
			 if(cursor==null){
				return username;
			 }else{
				cursor.moveToFirst();
				username=cursor.getString(cursor.getColumnIndex(Attributes.Database.NOMBREDEARCHIVO));
			 }
		 }catch (Exception e) {
	
		 }
		
		Log.d("tag", "checkname method is called ");
		return username;
		
		 
	 }
	 
	 public void deleteRecord(String fileName){
		 sqLiteDatabase.delete(Attributes.Database.TABLE_NAME_BUSINESSCASE, Attributes.Database.NOMBREDEARCHIVO+" = ?", new String[]{fileName} );
		 
	 }
	
}
