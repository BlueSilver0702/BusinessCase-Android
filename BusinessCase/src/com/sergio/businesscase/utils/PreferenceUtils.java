package com.sergio.businesscase.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

import com.sergio.businesscase.helper.Attributes;

public class PreferenceUtils {
	SharedPreferences sharePref;
	Editor editor;
	final String TAG="PreferenceUtils";
	@SuppressLint("CommitPrefEdits")
	public PreferenceUtils(Context context){
		
		sharePref=PreferenceManager.getDefaultSharedPreferences(context);
		editor=sharePref.edit();
	}
	public void clearSharedPref(){
		
		editor.clear();
		
		//sharePref.edit().clear();
		editor.commit();
		
	}
	public void setHeading(String heading){
		
		editor.putString(Attributes.ShPreference.HEADING, heading);
		editor.commit();
		
	}
	
	public String getHeading(){
		return sharePref.getString(Attributes.ShPreference.HEADING, null);
	}
	
	public void setTitle(String title){
		editor.putString(Attributes.ShPreference.TITLE, title);
		editor.commit();
	}
	public String getTilte(){
		return sharePref.getString(Attributes.ShPreference.TITLE, null);
		
	}
	
	public void setTema(String tema){
		editor.putString(Attributes.ShPreference.TEMA, tema);
		editor.commit();
	}
	public String getTema(){
		return sharePref.getString(Attributes.ShPreference.TEMA, null);
	}
	
	public void setObjective(String objective){
		editor.putString(Attributes.ShPreference.OBJECTIVE, objective);
		editor.commit();
	}
	public String getObjective(){
		return sharePref.getString(Attributes.ShPreference.OBJECTIVE, null);
	}
	
	public void setIntroduction(String intro){
		editor.putString(Attributes.ShPreference.INTRODUCTION, intro);
		editor.commit();
	}
	public String getIntroduction(){
		return sharePref.getString(Attributes.ShPreference.INTRODUCTION, null);
	}
	
	public void setConclusion(String conclusion){
		editor.putString(Attributes.ShPreference.CONCLUSION, conclusion);
		editor.commit();
	}
	public String getConclusion(){
		return sharePref.getString(Attributes.ShPreference.CONCLUSION, null);
	}
	
	public void setRecommendies(String recommend){
		editor.putString(Attributes.ShPreference.RECOMENDED, recommend);
		editor.commit();
	}
	
	public String getRecommendies(){
		return sharePref.getString(Attributes.ShPreference.RECOMENDED, null);
	}
	
	public void setSummary(String summary){
		editor.putString(Attributes.ShPreference.SUMMARY, summary);
		editor.commit();
	}
	public String getSummary(){
		return sharePref.getString(Attributes.ShPreference.SUMMARY, null);
	}
	
	public void setDescriptionShort1(String descShort1){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTION1, descShort1);
		editor.commit();
	}
	
	public String getDescriptionShort1(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTION1, null);
	}
	public void setDescriptionLarge1(String descLarge1){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTION1, descLarge1);
		editor.commit();
	}
	
	public String getDescriptionLarge1(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTION1, null);
	}
	
			
	
	
	public void setContingenciaDesLarga(String contengenciaDesLarga){
		editor.putString(Attributes.ShPreference.CONTENGENCIADESLARGA, contengenciaDesLarga);
		editor.commit();
	}
	
	public String getContingenciaDeslarga(){
		return sharePref.getString(Attributes.ShPreference.CONTENGENCIADESLARGA, null);
	}
	
	public void setDependencia1(String dependencia1){
		editor.putString(Attributes.ShPreference.DEPENDENCIA1, dependencia1);
		editor.commit();
	}
	public String getDependencia1(){
		return sharePref.getString(Attributes.ShPreference.DEPENDENCIA1, null);
	}
	public void setDependencia2(String dependencia2){
		editor.putString(Attributes.ShPreference.DEPENDENCIA2, dependencia2);
		editor.commit();
	}
	public String getDependencia2(){
		return sharePref.getString(Attributes.ShPreference.DEPENDENCIA2, null);
	}
	public void setDependencia3(String dependencia3){
		editor.putString(Attributes.ShPreference.DEPENDENCIA3, dependencia3);
		editor.commit();
	}
	public String getDependencia3(){
		return sharePref.getString(Attributes.ShPreference.DEPENDENCIA3, null);
	}
	public void setDependencia4(String Dependencia4){
		editor.putString(Attributes.ShPreference.DEPENDENCIA4, Dependencia4);
		editor.commit();
	}
	
	public String getDependencia4(){
		return sharePref.getString(Attributes.ShPreference.DEPENDENCIA4, null);
	}

	public void setDependenciaDesLarga(String DependenciaDeslarga){
		editor.putString(Attributes.ShPreference.DEPENDENCIADESLARGA, DependenciaDeslarga);
		editor.commit();
	}
	
	public String getDependenciaDesLarga(){
		return sharePref.getString(Attributes.ShPreference.DEPENDENCIADESLARGA, null);
	}
	
	public void setResultados1(String resultados1){
		editor.putString(Attributes.ShPreference.RESULTADOS1, resultados1);
		editor.commit();
	}
	
	public String getResultados1(){
		return sharePref.getString(Attributes.ShPreference.RESULTADOS1, null);
	}
	public void setResultados2(String resultados2){
		editor.putString(Attributes.ShPreference.RESULTADOS2, resultados2);
		editor.commit();
	}
	
	public String getResultados2(){
		return sharePref.getString(Attributes.ShPreference.RESULTADOS2, null);
	}
	public void setResultados3(String resultados3){
		editor.putString(Attributes.ShPreference.RESULTADOS3, resultados3);
		editor.commit();
	}
	
	public String getResultados3(){
		return sharePref.getString(Attributes.ShPreference.RESULTADOS3, null);
	}
	public void setResultados4(String resultados4){
		editor.putString(Attributes.ShPreference.RESULTADOS4, resultados4);
		editor.commit();
	}
	
	public String getResultados4(){
		return sharePref.getString(Attributes.ShPreference.RESULTADOS4, null);
	}
	
	public void setResultadosDescLarga(String resultadosDescLarga){
		editor.putString(Attributes.ShPreference.RESULTADOSDESCLARGA, resultadosDescLarga);
		editor.commit();
	}
	
	public String getResultadosDesLarga(){
		return sharePref.getString(Attributes.ShPreference.RESULTADOSDESCLARGA, null);
	}
	
	public void setSupuestos1(String supuestos1){
		editor.putString(Attributes.ShPreference.SUPUESTOS1, supuestos1);
		editor.commit();
	}
	
	public String getSupuestos1(){
		return sharePref.getString(Attributes.ShPreference.SUPUESTOS1, null);
	}
	public void setSupuestos2(String supuestos2){
		editor.putString(Attributes.ShPreference.SUPUESTOS2, supuestos2);
		editor.commit();
	}
	
	public String getSupuestos2(){
		return sharePref.getString(Attributes.ShPreference.SUPUESTOS2, null);
	}
	public void setSupuestos3(String supuestos3){
		editor.putString(Attributes.ShPreference.SUPUESTOS3, supuestos3);
		editor.commit();
	}
	
	public String getSupuestos3(){
		return sharePref.getString(Attributes.ShPreference.SUPUESTOS3, null);
	}
	
	public void setSupuestos4(String supuestos4){
		editor.putString(Attributes.ShPreference.SUPUESTOS4, supuestos4);
		editor.commit();
	}
	
	public String getSupuestos4(){
		return sharePref.getString(Attributes.ShPreference.SUPUESTOS4, null);
	}
	
	public void setSupuestosDescLarga(String supuestos){
		editor.putString(Attributes.ShPreference.SUPUESTOSDESCLARGA, supuestos);
		editor.commit();
	}
	
	public String getSupuestosDescLarga(){
		return sharePref.getString(Attributes.ShPreference.SUPUESTOSDESCLARGA, null);
	}
	
	public void setDescriptionShortAhorros1(String descShort1){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONAH1, descShort1);
		editor.commit();
	}
	
	public String getDescriptionShortAhorros1(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONAH1, null);
	}
	public void setDescriptionLargeAhorros1(String descLarge1){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONAH1, descLarge1);
		editor.commit();
	}
	
	public String getDescriptionLargeAhorros1(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONAH1, null);
	}
	
	
	public void setDescriptionShortEgresos1(String descShort1){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONEGROS1, descShort1);
		editor.commit();
	}
	
	public String getDescriptionShortEgresos1(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONEGROS1, null);
	}
	public void setDescriptionLargeEgresos1(String descLarge1){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS1, descLarge1);
		editor.commit();
	}
	
	public String getDescriptionLargeEgresos1(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS1, null);
	}
	public void setDescriptionShortCostos(String descShortcos){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONEGROS2, descShortcos);
		editor.commit();
	}
	
	public String getDescriptionShortCostos(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONEGROS2, null);
	}
	public void setDescriptionLargeCostos(String descLargecos){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS2, descLargecos);
		editor.commit();
	}
	
	public String getDescriptionLargeCostos(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS2, null);
	}
	public void setDescriptionShortInversion(String descShortInv){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONEGROS3, descShortInv);
		editor.commit();
	}
	
	public String getDescriptionShortInversion(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONEGROS3, null);
	}
	public void setDescriptionLargeInversion(String descLargeInv){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS3, descLargeInv);
		editor.commit();
	}
	
	public String getDescriptionLargeInversion(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS3, null);
	}
	
	public void setDescriptionShortBeneficios(String descShortBen){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONEGROS4, descShortBen);
		editor.commit();
	}
	
	public String getDescriptionShortBeneficios(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONEGROS4, null);
	}
	
	public void setDescriptionLargeBeneficios(String descLargeBen){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS4, descLargeBen);
		editor.commit();
	}
	
	public String getDescriptionLargeBeneficios(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONEGROS4, null);
	}
	

	public void setDescriptionShortImpactos(String descShortimp){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONAH2, descShortimp);
		editor.commit();
	}
	
	public String getDescriptionShortImpactos(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONAH2, null);
	}
	public void setDescriptionLargeImpactos(String descLargeimp){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONAH2, descLargeimp);
		editor.commit();
	}
	
	public String getDescriptionLargeImpactos(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONAH2, null);
	}

	public void setDescriptionShortRiesgos(String descShortRig){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONAH3, descShortRig);
		editor.commit();
	}
	
	public String getDescriptionShortRiesgos(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONAH3, null);
	}
	public void setDescriptionLargeRiesgos(String descLargeRig){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONAH3, descLargeRig);
		editor.commit();
	}
	
	public String getDescriptionLargeRiesgos(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONAH3, null);
	}
	
	public void setVariable(String variable){
		Log.d(TAG,"valuuuuuuu"+variable);
		editor.putString(Attributes.ShPreference.SORTDESCRIPTION2, variable);
		editor.commit();
	}
	
	public String getVariable(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTION2, null);
	}
	public void setValor(String valor){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTION2, valor);
		editor.commit();
	}
	
	public String getValor(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTION2, null);
	}
	
	public void setSpinnerValue(String spinner){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTION3, spinner);
		editor.commit();
	}
	
	public String getSpinner(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTION3, null);
	}
	
	public void setInversionVariable(String variable){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTION3, variable);
		editor.commit();
	}
	
	public String getInversionVariable(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTION3, null);
	}
	
	public void setInversionSpinner(String spinner){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTION4, spinner);
		editor.commit();
	}
	
	public String getInversionSpinner(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTION4, null);
	}
	
	public void setInversionValor(String valor){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTION4, valor);
		editor.commit();
	}
	
	public String getInversionValor(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTION4, null);
	}
	
	public void setEgrossVariable(String egross){
		editor.putString(Attributes.ShPreference.EGROSESVARIABLE, egross);
		editor.commit();
	}
	
	public String getEgrossVariable(){
		return sharePref.getString(Attributes.ShPreference.EGROSESVARIABLE, null);
	}
	
	public void setEgrossSpinner(String spinner){
		editor.putString(Attributes.ShPreference.LARGEDESCRIPTIONAH4, spinner);
		editor.commit();
	}
	
	public String getEgrossSpinner(){
		return sharePref.getString(Attributes.ShPreference.LARGEDESCRIPTIONAH4, null);
	}
	
	public void setEgrossValor(String valor){
		editor.putString(Attributes.ShPreference.SORTDESCRIPTIONAH4, valor);
		editor.commit();
	}
	
	public String getEgrossValor(){
		return sharePref.getString(Attributes.ShPreference.SORTDESCRIPTIONAH4, null);
	}
	
	public void setAhorrosVariable(String egross){
		editor.putString(Attributes.ShPreference.AHORROSVARIABLE, egross);
		editor.commit();
	}
	
	public String getAhorrosVariable(){
		return sharePref.getString(Attributes.ShPreference.AHORROSVARIABLE, null);
	}
	
	public void setAhorrosSpinner(String spinner){
		editor.putString(Attributes.ShPreference.AHORROSSPINNER, spinner);
		editor.commit();
	}
	
	public String getAhorrosSpinner(){
		return sharePref.getString(Attributes.ShPreference.AHORROSSPINNER, null);
	}
	
	public void setAhorrosValor(String valor){
		editor.putString(Attributes.ShPreference.AHORROSVALUE, valor);
		editor.commit();
	}
	
	public String getAhorrosValor(){
		return sharePref.getString(Attributes.ShPreference.AHORROSVALUE, null);
	}
	
	public void setCostosVariable(String egross){
		editor.putString(Attributes.ShPreference.COSTOSVARIABLE, egross);
		editor.commit();
	}
	
	public String getCostosVariable(){
		return sharePref.getString(Attributes.ShPreference.COSTOSVARIABLE, null);
	}
	
	public void setCostosSpinner(String spinner){
		editor.putString(Attributes.ShPreference.COSTOSSPINNER, spinner);
		editor.commit();
	}
	
	public String getCostosSpinner(){
		return sharePref.getString(Attributes.ShPreference.COSTOSSPINNER, null);
	}
	
	public void setCostosValor(String valor){
		editor.putString(Attributes.ShPreference.COSTOSVALUE, valor);
		editor.commit();
	}
	
	public String getCostosValor(){
		return sharePref.getString(Attributes.ShPreference.COSTOSVALUE, null);
	}
	
	
	public void setAlcancesYLimits(String alcances){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMIT, alcances);
		editor.commit();
		
	}
	
	public String getAlcancesYLimit(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMIT, null);
	}
	
	public void setAlcancesYLimitsCapcidad(String alcances){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITCAPCACIDAD, alcances);
		editor.commit();
		
	}
	
	public String getAlcancesYLimitCapacidad(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITCAPCACIDAD, null);
	}
	public void setAlcancesYLimitsHorarios(String alcances){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITHORARIOS, alcances);
		editor.commit();
		
	}
	
	public String getAlcancesYLimitHorarios(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITHORARIOS, null);
	}
	
	public void setAlcancesYLimitsCobertura(String cobertura){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITCOBERTURA, cobertura);
		editor.commit();
	}
	
	public String getAlcancesYLimitsCobertura(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITCOBERTURA, null);
	}
	
	public void setAlcancesYLimitsComercial(String commercial){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITCOMERCIAL, commercial);
		editor.commit();
	}
	
	public String getAlcancesYLimitsComercial(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITCOMERCIAL, null);		
	}
	
	public void setAlcancesYLimitsPersonal(String personal){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITPERSONAL, personal);
		editor.commit();
	}
	
	public String getAlcancesYLimitsPersonal(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITPERSONAL, null);
	}
	
	public void setAlcancesYLimitsDemanda(String demanda){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITDEMANDA, demanda);
		editor.commit();
	}
	
	public String getAlcancesYLimitsDemanda(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITDEMANDA, null);		
	}
	public void setAlcancesYLimitsDuracion(String duracion){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITDURACION, duracion);
		editor.commit();
	}
	
	public String getAlcancesYLimitsDuracion(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITDURACION, null);
	}
	
	public void setAlcancesYLimitsSegmen(String segmen){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITSEGMEN, segmen);
		editor.commit();
	}
	
	public String getAlcancesYLimitsSegmen(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITSEGMEN, null);		
	}
	
	public void setAlcancesYLimitsTechnologia(String technologia){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITTECHNOLOGIA, technologia);
		editor.commit();
	}
	
	public String getAlcancesYLimitsTechnologia(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITTECHNOLOGIA, null);
	}
	
	public void setAlcancesYLimitsOtro1(String otro1){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITOTRO1, otro1);
		editor.commit();
	}
	
	public String getAlcancesYLimitsOtro1(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITOTRO1, null);		
	}
	public void setAlcancesYLimitsOtro2(String otro2){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITOTRO2, otro2);
		editor.commit();
	}
	
	public String getAlcancesYLimitsOtro2(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITOTRO2, null);		
	}
	public void setAlcancesYLimitsOtro3(String otro3){
		editor.putString(Attributes.ShPreference.ALCANCESYLIMITOTRO3, otro3);
		editor.commit();
	}
	
	public String getAlcancesYLimitsOtro3(){
		return sharePref.getString(Attributes.ShPreference.ALCANCESYLIMITOTRO3, null);		
	}
	public void setCheckedElement(String chec){
		editor.putString(Attributes.ShPreference.CHECKEDELEMENT, chec);
		editor.commit();
	}
	public String getCheckedElement(){
		return sharePref.getString(Attributes.ShPreference.CHECKEDELEMENT, null);
	}
	
	public void setFuntesIngresos(String ingresos){
		editor.putString(Attributes.ShPreference.FUNTESINGRESOS, ingresos);
		editor.commit();
	}
	public String getFuntesIngresos(){
		return sharePref.getString(Attributes.ShPreference.FUNTESINGRESOS, null);
	}
	
	public void set_Facebook_Token(String token){
		editor.putString(Attributes.ShPreference.FACEBOOK_TOKEN, token);
		editor.commit();
	}
	public String get_Facebook_Token(){
		return sharePref.getString(Attributes.ShPreference.FACEBOOK_TOKEN, null);
	}
	
	public void setExpires(long expires){
		editor.putLong(Attributes.ShPreference.FACEBOOK_EXPIRES, expires);
		editor.commit();
	}
	
	public long getExpires(){
		return sharePref.getLong(Attributes.ShPreference.FACEBOOK_EXPIRES, 0);
	}
	
}
