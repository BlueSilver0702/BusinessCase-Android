package com.sergio.businesscase.ui;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Locale;

import com.apptentive.android.sdk.Apptentive;
import com.flurry.android.FlurryAgent;
import com.sergio.businesscase.R;
import com.sergio.businesscase.helper.Attributes;
import com.sergio.businesscase.utils.PreferenceUtils;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class BusinCaseExcelFileActivity  extends Activity{
	
	String excelFileName="Test"+".xls";
	WritableSheet sheet;
	 WritableCellFormat nb,rightWithBcolor;
		WritableWorkbook wbook;
		PreferenceUtils pref;
		WritableCellFormat lCurrencyFormat;
	
	private int sendmail_flag = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.word_excel_results);
			
			Intent intent = getIntent();
			sendmail_flag = intent.getIntExtra("SendMail", 0);
			init();
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

	private void init() {
		
		pref = new PreferenceUtils(this);
		File sdCard=Environment.getExternalStorageDirectory();
		File directory=new File(sdCard.getAbsoluteFile()+"/BusinessCase");
		directory.mkdirs();
		
		final File file=new File(directory, pref.getHeading()+".xls");
		WorkbookSettings  wbSettings=new WorkbookSettings();
		wbSettings.setLocale(new Locale("en", "EN"));
		
	
		try
		{
			//creating xls file
			wbook=Workbook.createWorkbook(file, wbSettings);
			//wbook.createSheet("Report", 0);
			//Creating sheets
           sheet = wbook.createSheet("FlujoEfectivo", 0);
          
        //    WritableSheet sheet1=wbook.createSheet("Second sheet", 1);
         
            // setting column view 
            sheet.setColumnView(0, 22);
           
            
            WritableFont font = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD,false, UnderlineStyle.SINGLE_ACCOUNTING, Colour.BLUE);
            WritableCellFormat ulb=new WritableCellFormat(font);
            
            
            rightWithBcolor=new WritableCellFormat();
          	rightWithBcolor.setAlignment(Alignment.RIGHT);
			rightWithBcolor.setBackground(Colour.LIGHT_GREEN);
	
			WritableCellFormat rightWithoutBcolor=new WritableCellFormat();
          	rightWithoutBcolor.setAlignment(Alignment.RIGHT);
          	
          	WritableCellFormat centreGreen=new WritableCellFormat(new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.GRAY_50));
          	centreGreen.setAlignment(Alignment.CENTRE);
          	
          	
          	WritableFont wf1=new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE, WritableFont.NO_BOLD, false,UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
            nb=new WritableCellFormat(wf1);
            
            WritableFont wf=new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false,UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
            WritableCellFormat bb=new WritableCellFormat(wf);
            
            WritableFont wf2=new WritableFont(WritableFont.ARIAL, WritableFont.DEFAULT_POINT_SIZE, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,Colour.GREY_40_PERCENT);
            WritableCellFormat bg=new WritableCellFormat(wf2);
            
          //  writeFormulaSheet(sheet1);
           
            NumberFormat currencyFormat = new NumberFormat(NumberFormat.CURRENCY_DOLLAR + " ###,###", NumberFormat.COMPLEX_FORMAT); 
            lCurrencyFormat = new WritableCellFormat(currencyFormat);
            lCurrencyFormat.setBackground(Colour.LIGHT_GREEN);
            
            // Add in the formulas
            Formula f = null;
          	Label l = null;
          	
          	for(int i=0;i<4;i++){
          		if(pref.getDescriptionShortInversion()!=null){
          	        	try{
          	        	String str=pref.getDescriptionShortInversion().split("~")[i];
          	        l = new Label(3, 7+i,str);
          	        sheet.addCell(l);
          	        	}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
							
						}
          	        } 
          	      if(pref.getDescriptionShortEgresos1()!=null){
        	        	try{
        	        		String str=pref.getDescriptionShortEgresos1().split("~")[i];
        	        		l = new Label(3, 16+i,str);
        	        		sheet.addCell(l);
        	        	}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
						}
        	        }
          	    if(pref.getDescriptionShortCostos()!=null){
      	        	try{
      	        		String str=pref.getDescriptionShortCostos().split("~")[i];
      	        		l = new Label(3, 25+i,str);
      	        		sheet.addCell(l);
      	        	}catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
						
					}
      	        }
          	  if(pref.getDescriptionShort1()!=null){
    	        	try{
    	        	String str=pref.getDescriptionShort1().split("~")[i];
    	        l = new Label(3, 36+i,str);
    	        sheet.addCell(l);
    	        	}catch (ArrayIndexOutOfBoundsException e) {
						e.printStackTrace();
						
					}
    	        }
          	if(pref.getDescriptionShortAhorros1()!=null){
  	        	try{
  	        	String str=pref.getDescriptionShortAhorros1().split("~")[i];
  	        l = new Label(3, 45+i,str);
  	        sheet.addCell(l);
  	        	}catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
					
				}
  	        }
          }
          	        for(int i=0;i<7;i++){
          	        	if(pref.getVariable()!=null){
          	        		try{
          	        			String str=pref.getVariable().split("~")[i];
          	        			l=new Label(0,6+i,str);
          	        			sheet.addCell(l);
          	        		}catch (ArrayIndexOutOfBoundsException e) {
								e.printStackTrace();
							}
          	        	}
          	        	if(pref.getValor()!=null){
          	        		try{
          	        			String str=pref.getValor().split("~")[i];
          	        			l=new Label(1,6+i,str,rightWithBcolor);
          	        			sheet.addCell(l);
          	        		}catch (ArrayIndexOutOfBoundsException e) {
								e.printStackTrace();
								l=new Label(1,6+i,"",rightWithBcolor);
          	        			sheet.addCell(l);
							}
          	        	}else{
          	        		l=new Label(1,6+i,"",rightWithBcolor);
      	        			sheet.addCell(l);
          	        	}
          	        }
          	       
          	      for(int i=0;i<8;i++){
          	    	  Log.d("TAG", "enter ahroo");
        	        	if(pref.getAhorrosValor()!=null){
        	        		try{
        	        			String str=pref.getAhorrosVariable().split("~")[i];
        	        			l=new Label(0,15+i,str);
        	        			sheet.addCell(l);
        	        			Log.d("TAG", "str is "+str);
        	        		}catch (ArrayIndexOutOfBoundsException e) {
								e.printStackTrace();
							}
        	        	}
        	        	if(pref.getAhorrosValor()!=null){
        	        		try{
        	        			String str=pref.getAhorrosValor().split("~")[i];
        	        			l=new Label(1,15+i,str,rightWithBcolor);
        	        			sheet.addCell(l);
        	        		}catch (ArrayIndexOutOfBoundsException e) {
								e.printStackTrace();
								l=new Label(1,15+i,"",rightWithBcolor);
        	        			sheet.addCell(l);
							}
        	        	}else{
        	        		l=new Label(1,15+i,"",rightWithBcolor);
    	        			sheet.addCell(l);
        	        	}
        	        }
          	    for(int i=0;i<8;i++){
      	        	if(pref.getEgrossVariable()!=null){
      	        		try{
      	        			String str=pref.getEgrossVariable().split("~")[i];
      	        			l=new Label(0,35+i,str);
      	        			sheet.addCell(l);
      	        		}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
						}
      	        	}
      	        	if(pref.getEgrossValor()!=null){
      	        		try{
      	        			String str=pref.getEgrossValor().split("~")[i];
      	        			l=new Label(1,35+i,str,rightWithBcolor);
      	        			sheet.addCell(l);
      	        		}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
							l=new Label(1,35+i,"",rightWithBcolor);
      	        			sheet.addCell(l);
						}
      	        	}else{
      	        		l=new Label(1,35+i,"",rightWithBcolor);
  	        			sheet.addCell(l);
      	        	}
      	        }
          	  for(int i=0;i<8;i++){
    	        	if(pref.getCostosVariable()!=null){
    	        		try{
    	        			String str=pref.getCostosVariable().split("~")[i];
    	        			l=new Label(0,44+i,str);
    	        			sheet.addCell(l);
    	        		}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
						}
    	        	}
    	        	if(pref.getCostosValor()!=null){
    	        		try{
    	        			String str=pref.getCostosValor().split("~")[i];
    	        			l=new Label(1,44+i,str,rightWithBcolor);
    	        			sheet.addCell(l);
    	        		}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
							l=new Label(1,44+i,"",rightWithBcolor);
    	        			sheet.addCell(l);
						}
    	        	}else{
    	        		l=new Label(1,44+i,"",rightWithBcolor);
	        			sheet.addCell(l);
    	        	}
    	        }
          	 for(int i=0;i<8;i++){
   	        	if(pref.getInversionVariable()!=null){
   	        		try{
   	        			String str=pref.getInversionVariable().split("~")[i];
   	        			l=new Label(0,53+i,str);
   	        			sheet.addCell(l);
   	        		}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
						}
   	        	}
   	        	if(pref.getInversionValor()!=null){
   	        		try{
   	        			String str=pref.getInversionValor().split("~")[i];
   	        			l=new Label(1,53+i,str,rightWithBcolor);
   	        			sheet.addCell(l);
   	        		}catch (ArrayIndexOutOfBoundsException e) {
							e.printStackTrace();
							l=new Label(1,53+i,"",rightWithBcolor);
   	        			sheet.addCell(l);
						}
   	        	}else{
   	        		l=new Label(1,53+i,"",rightWithBcolor);
	        			sheet.addCell(l);
   	        	}
   	        }
          	 NumberFormat no=new NumberFormat(NumberFormat.CURRENCY_DOLLAR+ "###,###",NumberFormat.COMPLEX_FORMAT);
             
             WritableCellFormat dollar=new WritableCellFormat(no);
             String str[]={"E","F","G","H","I","J","K","L","M","N","O"};
             for(int i=0;i<str.length;i++){
          	 
          	        f = new Formula(5+i, 5, str[i]+59);
          	        f.setCellFormat(dollar);
       	        	sheet.addCell(f);
             }
             
             
             String formulaArray[]={"P","S","T","U","V","W","X","Y","Z","AA","AB","AC"};
             for(int i=0;i<formulaArray.length;i++){
   	        	f=new Formula(18+i, 5, formulaArray[i]+59);
   	        	f.setCellFormat(dollar);
   	        	sheet.addCell(f);
             }
             String formulaArr[]={"AG","AH","AI","AJ","AK","AL","AM","AN","AO"};
             for(int i=0;i<formulaArr.length;i++){
            	 f=new Formula(33+i, 5,formulaArr[i]+59);
                 f.setCellFormat(dollar);
                 sheet.addCell(f);
             }
            
             
          	        
       	        	f=new Formula(32, 5, "E6");
       	        	f.setCellFormat(dollar);
	                sheet.addCell(f);
	                
	                String formulaArray1[]={"SUM(E8:P8)","SUM(E9:P9)","SUM(E10:P10)","SUM(E11:P11)","SUM(E12:P12)","SUM(E13:P13)","SUM(AG8:AG13)",
    						"SUM(E17:P17)","SUM(E18:P18)","SUM(E19:P19)","SUM(E20:P20)","SUM(E21:P21)","SUM(E22:P22)","SUM(AG17:AG22)",
    						"SUM(E26:P26)","SUM(E27:P27)","SUM(E28:P28)","SUM(E29:P29)","SUM(E30:P30)","SUM(E31:P31)","SUM(AG26:AG31)","AG14+AG23+AG32",
    						"SUM(E37:P37)","SUM(E38:P38)","SUM(E39:P39)","SUM(E40:P40)","SUM(E41:P41)","SUM(E42:P42)","SUM(AG37:AG42)",
    						"SUM(E46:P46)","SUM(E47:P47)","SUM(E48:P48)","SUM(E49:P49)","SUM(E50:P50)","SUM(E51:P51)","SUM(AG46:AG51)",
    						"AG43+AG52","SUM(E56:P56)","SUM(E57:P57)","AG6+AG54+SUM(AG56:AG57)-AG34"};
	                int intArr[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,55,56,58};
	                for(int i=0;i<formulaArray1.length;i++){
	                	f=new Formula(32, intArr[i], formulaArray1[i]);
	                	f.setCellFormat(dollar);
	                	sheet.addCell(f);
	                }
	                
	                String formulaArray2[]={"SUM(S8:AD8)","SUM(S9:AD9)","SUM(S10:AD10)","SUM(S11:AD11)","SUM(S12:AD12)","SUM(S13:AD13)","SUM(AH8:AH13)",
    						"SUM(S17:AD17)","SUM(S18:AD18)","SUM(S19:AD19)","SUM(S20:AD20)","SUM(S21:AD21)","SUM(S22:AD22)","SUM(AH17:AH22)",
    						"SUM(S26:AD26)","SUM(S27:AD27)","SUM(S28:AD28)","SUM(S29:AD29)","SUM(S30:AD30)","SUM(S31:AD31)","SUM(AH26:AH31)","AH14+AH23+AH32",
    						"SUM(S37:AD37)","SUM(S38:AD38)","SUM(S39:AD39)","SUM(S40:AD40)","SUM(S41:AD41)","SUM(S42:AD42)","SUM(AH37:AH42)",
    						"SUM(S46:AD46)","SUM(S47:AD47)","SUM(S48:AD48)","SUM(S49:AD49)","SUM(S50:AD50)","SUM(S51:AD51)","SUM(AH46:AH51)",
    						"AH43+AH52","SUM(S56:AD56)","SUM(S57:AD57)","AH6+AH54+SUM(AH56:AH57)-AH34"};
	                
	                int intArr1[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,55,56,58};
	                for(int i=0;i<formulaArray2.length;i++){
	                	f=new Formula(33, intArr1[i], formulaArray2[i]);
	                	f.setCellFormat(dollar);
	                	sheet.addCell(f);
	                }
	                String formulaArray3[]={"AH8*AI$7","AH9*AI$7","AH10*AI$7","AH11*AI$7","AH12*AI$7","AH13*AI$7","SUM(AI8:AI13)",
	            			"AH17*AI$16","AH18*AI$16","AH19*AI$16","AH20*AI$16","AH21*AI$16","AH22*AI$16","SUM(AI17:AI22)",
	            			"AH26*AI$25","AH27*AI$25","AH28*AI$25","AH29*AI$25","AH30*AI$25","AH31*AI$25","SUM(AI26:AI31)","AI14+AI23+AI32",
	            			"AH37*AI$36","AH38*AI$36","AH39*AI$36","AH40*AI$36","AH41*AI$36","AH42*AI$36","SUM(AI37:AI42)",
	            			"AH46*AI$45","AH47*AI$45","AH48*AI$45","AH49*AI$45","AH50*AI$45","AH51*AI$45","SUM(AI46:AI51)",
	            			"AI43+AI52","AI6+AI54+SUM(AI56:AI57)-AI34"};

	               			int intArr2[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
	            			for(int i=0;i<formulaArray3.length;i++){
	            			f=new Formula(34, intArr2[i], formulaArray3[i]);
	            			f.setCellFormat(dollar);
	            			sheet.addCell(f);
	            			}

	            	String formulaArray4[]={"AI8*AJ$7","AI9*AJ$7","AI10*AJ$7","AI11*AJ$7","AI12*AJ$7","AI13*AJ$7","SUM(AJ8:AJ13)",
	         						"AI17*AJ$16","AI18*AJ$16","AI19*AJ$16","AI20*AJ$16","AI21*AJ$16","AI22*AJ$16","SUM(AJ17:AJ22)",
	         						"AI26*AJ$16","AI27*AJ$16","AI28*AJ$16","AI29*AJ$16","AI30*AJ$16","AI31*AJ$16","SUM(AJ26:AJ31)","AJ14+AJ23+AJ32",
	         						"AI37*AJ$36","AI38*AJ$36","AI39*AJ$36","AI40*AJ$36","AI41*AJ$36","AI42*AJ$36","SUM(AJ37:AJ42)",
	         						"AI46*AJ$45","AI47*AJ$45","AI48*AJ$45","AI49*AJ$45","AI50*AJ$45","AI51*AJ$45","SUM(AJ46:AJ51)",
	         						"AJ43+AJ52","AJ6+AJ54+SUM(AJ56:AJ57)-AJ34"};

	         		int intArr3[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
	         		for(int i=0;i<formulaArray4.length;i++){
	         			f=new Formula(35, intArr3[i], formulaArray4[i]);
	         			f.setCellFormat(dollar);
	         			sheet.addCell(f);
	         		}
	         		
				 String formulaArray5[]={"AJ8*AK$7","AJ9*AK$7","AJ10*AK$7","AJ11*AK$7","AJ12*AK$7","AJ13*AK$7","SUM(AK8:AK13)",
     									"AJ17*AK$16","AJ18*AK$16","AJ19*AK$16","AJ20*AK$16","AJ21*AK$16","AJ22*AK$16","SUM(AK17:AK22)",
     									"AJ26*AK$16","AJ27*AK$16","AJ28*AK$16","AJ29*AK$16","AJ30*AK$16","AJ31*AK$16","SUM(AK26:AK31)","AK14+AK23+AK32",
     									"AJ37*AK$36","AJ38*AK$36","AJ39*AK$36","AJ40*AK$36","AJ41*AK$36","AJ42*AK$36","SUM(AK37:AK42)",
     									"AJ46*AK$45","AJ47*AK$45","AJ48*AK$45","AJ49*AK$45","AJ50*AK$45","AJ51*AK$45","SUM(AK46:AK51)",
     									"AK43+AK52","AK6+AK54+SUM(AK56:AK57)-AK34"};

	   			int intArr4[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
				for(int i=0;i<formulaArray5.length;i++){
						f=new Formula(36, intArr4[i], formulaArray5[i]);
						f.setCellFormat(dollar);
						sheet.addCell(f);
				}

	                
	         						String formulaArray6[]={"AK8*AL$7","AK9*AL$7","AK10*AL$7","AK11*AL$7","AK12*AL$7","AK13*AL$7","SUM(AL8:AL13)",
											"AK17*AL$16","AK18*AL$16","AK19*AL$16","AK20*AL$16","AK21*AL$16","AK22*AL$16","SUM(AL17:AL22)",
											"AK26*AL$16","AK27*AL$16","AK28*AL$16","AK29*AL$16","AK30*AL$16","AK31*AL$16","SUM(AL26:AL31)","AL14+AL23+AL32",
											"AK37*AL$36","AK38*AL$36","AK39*AL$36","AK40*AL$36","AK41*AL$36","AK42*AL$36","SUM(AL37:AL42)",
											"AK46*AL$45","AK47*AL$45","AK48*AL$45","AK49*AL$45","AK50*AL$45","AK51*AL$45","SUM(AL46:AL51)",
											"AL43+AL52","AL6+AL54+SUM(AL56:AL57)-AL34"};

								   			int intArr5[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
											for(int i=0;i<formulaArray6.length;i++){
											f=new Formula(37, intArr5[i], formulaArray6[i]);
											f.setCellFormat(dollar);
											sheet.addCell(f);
											}
											
											
						String formulaArray7[]={"AL8*AM$7","AL9*AM$7","AL10*AM$7","AL11*AM$7","AL12*AM$7","AL13*AM$7","SUM(AM8:AM13)",
													"AL17*AM$16","AL18*AM$16","AL19*AM$16","AL20*AM$16","AL21*AM$16","AL22*AM$16","SUM(AM17:AM22)",
													"AL26*AM$16","AL27*AM$16","AL28*AM$16","AL29*AM$16","AL30*AM$16","AL31*AM$16","SUM(AM26:AM31)","AM14+AM23+AM32",
													"AL37*AM$36","AL38*AM$36","AL39*AM$36","AL40*AM$36","AL41*AM$36","AL42*AM$36","SUM(AM37:AM42)",
													"AL46*AM$45","AL47*AM$45","AL48*AM$45","AL49*AM$45","AL50*AM$45","AL51*AM$45","SUM(AM46:AM51)",
													"AM43+AM52","AM6+AM54+SUM(AM56:AM57)-AM34"};
							
							int intArr6[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
							for(int i=0;i<formulaArray7.length;i++){
									f=new Formula(38, intArr6[i], formulaArray7[i]);
									f.setCellFormat(dollar);
									sheet.addCell(f);
							}

							
							String formulaArray8[]={"AM8*AN$7","AM9*AN$7","AM10*AN$7","AM11*AN$7","AM12*AN$7","AM13*AN$7","SUM(AN8:AN13)",
									"AM17*AN$16","AM18*AN$16","AM19*AN$16","AM20*AN$16","AM21*AN$16","AM22*AN$16","SUM(AN17:AN22)",
									"AM26*AN$16","AM27*AN$16","AM28*AN$16","AM29*AN$16","AM30*AN$16","AM31*AN$16","SUM(AN26:AN31)","AN14+AN23+AN32",
									"AM37*AN$36","AM38*AN$36","AM39*AN$36","AM40*AN$36","AM41*AN$36","AM42*AN$36","SUM(AN37:AN42)",
									"AM46*AN$45","AM47*AN$45","AM48*AN$45","AM49*AN$45","AM50*AN$45","AM51*AN$45","SUM(AN46:AN51)",
									"AN43+AN52","AN6+AN54+SUM(AN56:AN57)-AN34"};

						   			int intArr7[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
									for(int i=0;i<formulaArray8.length;i++){
									f=new Formula(39, intArr7[i], formulaArray8[i]);
									f.setCellFormat(dollar);
									sheet.addCell(f);
									}
	                
									String formulaArray9[]={"AN8*AO$7","AN9*AO$7","AN10*AO$7","AN11*AO$7","AN12*AO$7","AN13*AO$7","SUM(AO8:AO13)",
											"AN17*AO$16","AN18*AO$16","AN19*AO$16","AN20*AO$16","AN21*AO$16","AN22*AO$16","SUM(AO17:AO22)",
											"AN26*AO$16","AN27*AO$16","AN28*AO$16","AN29*AO$16","AN30*AO$16","AN31*AO$16","SUM(AO26:AO31)","AO14+AO23+AO32",
											"AN37*AO$36","AN38*AO$36","AN39*AO$36","AN40*AO$36","AN41*AO$36","AN42*AO$36","SUM(AO37:AO42)",
											"AN46*AO$45","AN47*AO$45","AN48*AO$45","AN49*AO$45","AN50*AO$45","AN51*AO$45","SUM(AO46:AO51)",
											"AO43+AO52","AO6+AO54+SUM(AO56:AO57)-AO34"};

								   	int intArr8[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
									for(int i=0;i<formulaArray9.length;i++){
											f=new Formula(40, intArr8[i], formulaArray9[i]);
											f.setCellFormat(dollar);
											sheet.addCell(f);
											}
	                
									String formulaArray10[]={"AO8*AP$7","AO9*AP$7","AO10*AP$7","AO11*AP$7","AO12*AP$7","AO13*AP$7","SUM(AP8:AP13)",
													"AO17*AP$16","AO18*AP$16","AO19*AP$16","AO20*AP$16","AO21*AP$16","AO22*AP$16","SUM(AP17:AP22)",
													"AO26*AP$16","AO27*AP$16","AO28*AP$16","AO29*AP$16","AO30*AP$16","AO31*AP$16","SUM(AP26:AP31)","AP14+AP23+AP32",
													"AO37*AP$36","AO38*AP$36","AO39*AP$36","AO40*AP$36","AO41*AP$36","AO42*AP$36","SUM(AP37:AP42)",
													"AO46*AP$45","AO47*AP$45","AO48*AP$45","AO49*AP$45","AO50*AP$45","AO51*AP$45","SUM(AP46:AP51)",
													"AP43+AP52","AP6+AP54+SUM(AP56:AP57)-AP34"};

									int intArr9[]={7,8,9,10,11,12,13,16,17,18,19,20,21,22,25,26,27,28,29,30,31,33,36,37,38,39,40,41,42,45,46,47,48,49,50,51,53,58};
									for(int i=0;i<formulaArray10.length;i++){
											f=new Formula(41, intArr9[i], formulaArray10[i]);
											f.setCellFormat(dollar);
											sheet.addCell(f);
										}
	                
	                for(int i=34;i<42 ;i++){
	                	Label lb=new Label(i,55,"",rightWithBcolor);
	                	sheet.addCell(lb);
	                	lb=new Label(i,56,"",rightWithBcolor);
	                	sheet.addCell(lb);
	                }
	                
	                for(int i=18;i<30 ;i++){
	                	Label lb1=new Label(i,55,"",rightWithBcolor);
	                	sheet.addCell(lb1);
	                	lb1=new Label(i,56,"",rightWithBcolor);
	                	sheet.addCell(lb1);
	                }
	                for(int i=4;i<16 ;i++){
	                	Label lb1=new Label(i,55,"",rightWithBcolor);
	                	sheet.addCell(lb1);
	                	lb1=new Label(i,56,"",rightWithBcolor);
	                	sheet.addCell(lb1);
	                }
	                
	                
	                
	                
	                
	                
       	        	f=new Formula(4, 13, "SUM(E8:E13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(5, 13, "SUM(F8:F13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 13, "SUM(G8:G13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 13, "SUM(H8:H13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 13, "SUM(I8:I13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 13, "SUM(J8:J13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 13, "SUM(K8:K13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 13, "SUM(L8:L13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 13, "SUM(M8:M13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(13, 13, "SUM(N8:N13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 13, "SUM(O8:O13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 13, "SUM(P8:P13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(18, 13, "SUM(S8:S13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 13, "SUM(T8:T13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 13, "SUM(U8:U13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 13, "SUM(V8:V13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 13, "SUM(W8:W13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 13, "SUM(X8:X13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 13, "SUM(Y8:Y13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 13, "SUM(Z8:Z13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(26, 13, "SUM(AA8:AA13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 13, "SUM(AB8:AB13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 13, "SUM(AC8:AC13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 13, "SUM(AD8:AD13)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	f=new Formula(4, 22, "SUM(E17:E22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(5, 22, "SUM(F17:F22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 22, "SUM(G17:G22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 22, "SUM(H17:H22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 22, "SUM(I17:I22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 22, "SUM(J17:J22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 22, "SUM(K17:K22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 22, "SUM(L17:L22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 22, "SUM(M17:M22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(13, 22, "SUM(N17:N22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 22, "SUM(O17:O22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 22, "SUM(P17:P22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(18, 22, "SUM(S17:S22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 22, "SUM(T17:T22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 22, "SUM(U17:U22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 22, "SUM(V17:V22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 22, "SUM(W17:W22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 22, "SUM(X17:X22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 22, "SUM(Y17:Y22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 22, "SUM(Z17:Z22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(26, 22, "SUM(AA17:AA22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 22, "SUM(AB17:AB22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 22, "SUM(AC17:AC22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 22, "SUM(AD17:AD22)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	f=new Formula(4, 31, "SUM(E26:E31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(5, 31, "SUM(F26:F31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 31, "SUM(G26:G31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 31, "SUM(H26:H31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 31, "SUM(I26:I31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 31, "SUM(J26:J31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 31, "SUM(K26:K31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 31, "SUM(L26:L31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 31, "SUM(M26:M31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(13, 31, "SUM(N26:N31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 31, "SUM(O26:O31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 31, "SUM(P26:P31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	
       	        	f=new Formula(18, 31, "SUM(S26:S31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 31, "SUM(T26:T31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 31, "SUM(U26:U31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 31, "SUM(V26:V31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 31, "SUM(W26:W31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 31, "SUM(X26:X31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 31, "SUM(Y26:Y31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 31, "SUM(Z26:Z31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	f=new Formula(26, 31, "SUM(AA26:AA31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 31, "SUM(AB26:AB31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 31, "SUM(AC26:AC31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 31, "SUM(AD26:AD31)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	f=new Formula(4, 33, "E14+E23+E32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(5, 33, "F14+F23+F32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 33, "G14+G23+G32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 33, "H14+H23+H32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 33, "I14+I23+I32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 33, "J14+J23+J32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 33, "K14+K23+K32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 33, "L14+L23+L32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 33, "M14+M23+M32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(13, 33, "N14+N23+N32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 33, "O14+O23+O32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 33, "P14+P23+P32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(18, 33, "S14+S23+S32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 33, "T14+T23+T32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 33, "U14+U23+U32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 33, "V14+V23+V32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 33, "W14+W23+W32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 33, "X14+X23+X32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 33, "Y14+Y23+Y32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 33, "Z14+Z23+Z32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(26, 33, "AA14+AA23+AA32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 33, "AB14+AB23+AB32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 33, "AC14+AC23+AC32)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 33, "AD14+AD23+AD32");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);

       	        	
       	        	
       	        	
       	        	f=new Formula(4, 42, "SUM(E37:E42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(5, 42, "SUM(F37:F42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 42, "SUM(G37:G42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 42, "SUM(H37:H42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 42, "SUM(I37:I42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 42, "SUM(J37:J42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 42, "SUM(K37:K42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 42, "SUM(L37:L42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 42, "SUM(M37:M42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(13, 42, "SUM(N37:N42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 42, "SUM(O37:O42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 42, "SUM(P37:P42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(18, 42, "SUM(S37:S42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 42, "SUM(T37:T42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 42, "SUM(U37:U42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 42, "SUM(V37:V42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 42, "SUM(W37:W42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 42, "SUM(X37:X42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 42, "SUM(Y37:Y42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 42, "SUM(Z37:Z42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(26, 42, "SUM(AA37:AA42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 42, "SUM(AB37:AB42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 42, "SUM(AC37:AC42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 42, "SUM(AD37:AD42)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	//**
       	        	f=new Formula(4, 51, "SUM(E45:E51)");
          	     f.setCellFormat(dollar);
          	        sheet.addCell(f);
       	        	
       	        	f=new Formula(5, 51, "SUM(F46:F51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 51, "SUM(G46:G51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 51, "SUM(H46:H51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 51, "SUM(I46:I51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 51, "SUM(J46:J51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 51, "SUM(K46:K51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 51, "SUM(L46:L51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 51, "SUM(M46:M51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(13, 51, "SUM(N46:N51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 51, "SUM(O46:O51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 51, "SUM(P46:P51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(18, 51, "SUM(S46:S51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 51, "SUM(T46:T51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 51, "SUM(U46:U51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 51, "SUM(V46:V51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 51, "SUM(W46:W51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 51, "SUM(X46:X51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 51, "SUM(Y46:Y51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 51, "SUM(Z46:Z51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(26, 51, "SUM(AA46:AA51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 51, "SUM(AB46:AB51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 51, "SUM(AC46:AC51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 51, "SUM(AD46:AD51)");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	f=new Formula(4, 53, "E43+E52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(5, 53, "F43+F52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(6, 53, "G43+G52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(7, 53, "H43+H52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(8, 53, "I43+I52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(9, 53, "J43+J52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(10, 53, "K43+K52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(11, 53, "L43+L52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(12, 53, "M43+M52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	
       	        	f=new Formula(13, 53, "N43+N52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(14, 53, "O43+O52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(15, 53, "P43+P52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(18, 53, "S43+S52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(19, 53, "T43+T52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(20, 53, "U43+U52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(21, 53, "V43+V52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(22, 53, "W43+W52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(23, 53, "X43+X52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(24, 53, "Y43+Y52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(25, 53, "Z43+Z52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(26, 53, "AA43+AA52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(27, 53, "AB43+AB52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(28, 53, "AC43+AC52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	f=new Formula(29, 53, "AD43+AD52");
       	         f.setCellFormat(dollar);
       	        	sheet.addCell(f);
       	        	

          	        f = new Formula(4, 58, "E54+SUM(E56:E57)-E34");
          	      f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(5, 58, "F6+F54+SUM(F56:F57)-F34");
          	      f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(6, 58, "G6+G54+SUM(G56:G57)-G34");
          	      f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(7, 58, "H6+H54+SUM(H56:H57)-H34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(8, 58, "I6+I54+SUM(I56:I57)-I34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(9, 58, "J6+J54+SUM(J56:J57)-J34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(10, 58, "K6+K54+SUM(K56:K57)-K34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(11, 58, "L6+L54+SUM(L56:L57)-L34");
          	      f.setCellFormat(dollar);
          	      
        	        sheet.addCell(f);
        	        f = new Formula(12, 58, "M6+M54+SUM(M56:M57)-M34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(13, 58, "N6+N54+SUM(N56:N57)-N34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(14, 58, "O6+O54+SUM(O56:O57)-O34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(15, 58, "P6+P54+SUM(P56:P57)-P34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(18, 58, "S6+S54+SUM(S56:S57)-S34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(19, 58, "T6+T54+SUM(T56:T57)-T34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(20, 58, "U6+U54+SUM(U56:U57)-U34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(21, 58, "V6+V54+SUM(V56:V57)-V34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(22, 58, "W6+W54+SUM(W56:W57)-W34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(23, 58, "X6+X54+SUM(X56:X57)-X34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(24, 58, "Y6+Y54+SUM(Y56:Y57)-Y34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(25, 58, "Z6+Z54+SUM(Z56:Z57)-Z34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(26, 58, "AA6+AA54+SUM(AA56:AA57)-AA34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(27, 58, "AB6+AB54+SUM(AB56:AB57)-AB34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
        	        f = new Formula(28, 58, "AC6+AC54+SUM(AC56:AC57)-AC34");
        	        f.setCellFormat(dollar);
          	        sheet.addCell(f);
          	        f = new Formula(29, 58, "AD6+AD54+SUM(AD56:AD57)-AD34");
          	      f.setCellFormat(dollar);
        	        sheet.addCell(f);
          	        
          	 Label lr0 = new Label(3, 0, "FLUJO DE EFECTIVO",centreGreen);
          	 sheet.mergeCells(3, 0, 15, 0);
          	 sheet.addCell(lr0); 
          	 
          	lr0 = new Label(17, 0, "FLUJO DE EFECTIVO",centreGreen);
          	 sheet.mergeCells(17, 0, 29, 0);
          	 sheet.addCell(lr0);
          	    
          	 Label lr1 = new Label(3, 1, "(Mensual)",centreGreen);
          	 sheet.mergeCells(3, 1, 15, 1);
          	 sheet.addCell(lr1);
          	 
          	lr1 = new Label(17, 1, "(Mensual)",centreGreen);
          	 sheet.mergeCells(17, 1, 29, 1);
          	 sheet.addCell(lr1);
          	       
          	Label lr2 = new Label(3, 2, "Dólares",centreGreen);
         	 sheet.mergeCells(3, 2, 15, 2);
         	 sheet.addCell(lr2);
			
         	lr2 = new Label(17, 2, "Dólares",centreGreen);
         	sheet.mergeCells(17, 2, 29, 2);
        	sheet.addCell(lr2);
                     
            //filling label in xls sheet
            
            Label lbl00 = new Label(0, 0, "Modelo Financiero",ulb);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 1, "Variables Generales del modelo");
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 2, "Moneda");
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 3, "Tipo de Cambio");
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 5, "Variables de Ingresos",bb);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 13,"Meses a evaluar");
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 14,"Variables de Ahorros",bb);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 23,"Variables de Gastos",bb);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 24,"Sueldos y comisiones",bg);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 33,"Comisión por ventas");
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 34,"Gastos Operativos Mensuales",bg);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 43,"Variables de Costos",bb);
	            sheet.addCell(lbl00);
	            lbl00 = new Label(0, 52,"Variables de Inversión",bb);
	            sheet.addCell(lbl00);
            
            Label lbl01 = new Label(1, 2, "Dólares",rightWithBcolor);
	            sheet.addCell(lbl01);
	            lbl01 = new Label(1,3,"0",rightWithBcolor);
	            sheet.addCell(lbl01);
	            
            
          CommomColumn(03);
          CommomColumn(17);
          CommomColumn(31);
          for(int i=4;i<16;i++){
          setCellBackgroundColor(i,7);
          }
          for(int i=18;i<30;i++){
          setCellBackgroundColor(i,7);
          }
          
          for(int i=4;i<16;i++){
              setCellBackgroundColor(i,16);
              }
          for(int i=18;i<30;i++){
              setCellBackgroundColor(i,16);
              }
          
          for(int i=4;i<16;i++){
              setCellBackgroundColor(i,25);
              }
          for(int i=18;i<30;i++){
              setCellBackgroundColor(i,25);
              }

          for(int i=4;i<16;i++){
              setCellBackgroundColor(i,36);
              }
          for(int i=18;i<30;i++){
              setCellBackgroundColor(i,36);
              }

          for(int i=4;i<16;i++){
              setCellBackgroundColor(i,45);
              }
          for(int i=18;i<30;i++){
              setCellBackgroundColor(i,45);
              }


            Label lbl04 =new Label(4, 3, "35%", rightWithBcolor);
            sheet.addCell(lbl04);
           
            Label lbl0503 =new Label(5, 3, "50%", rightWithBcolor);
            Label lbl0603 =new Label(6, 3, "60%", rightWithBcolor);
            Label lbl0703 =new Label(7, 3, "65%", rightWithBcolor);
            Label lbl0803 =new Label(8, 3, "70%", rightWithBcolor);
            Label lbl0903 =new Label(9, 3, "70%", rightWithBcolor);
            Label lbl1003 =new Label(10, 3, "70%", rightWithBcolor);
            Label lbl1103 =new Label(11, 3, "70%", rightWithBcolor);
            Label lbl1203 =new Label(12, 3, "70%", rightWithBcolor);
            Label lbl1303 =new Label(13, 3, "70%", rightWithBcolor);
            Label lbl1403 =new Label(14, 3, "80%", rightWithBcolor);
            Label lbl1503 =new Label(15, 3, "90%", rightWithBcolor);
            
           
            for(int i=4, j=1;i<16 ;i++,j++){
            	Label lb=new Label(i,4,"Mes"+j,nb);
            	sheet.addCell(lb);
            }
            for(int i=18, j=13;i<30 ;i++,j++){
            	Label lb= new Label(i,3,"100%",rightWithBcolor);
            	sheet.addCell(lb);
            	lb=new Label(i,4,"Mes"+j,nb);
            	sheet.addCell(lb);
            }
            for(int i=32,j=1;i<42;i++,j++){
            	Label lb=new Label(i,4,"Año"+j,nb);
            	sheet.addCell(lb);
            	
            }
            
            for(int i=34;i<42;i++){
            	Label lb=new Label(i,6,"0%",rightWithBcolor);
            	sheet.addCell(lb);
            }
            
            fillPercent(33, 15);
            fillPercent(33, 24);
            

            for(int i=33;i<42;i++){
            	Label lb = new Label(i,35,"0%",rightWithBcolor);
            	if(i==34){
            		lb=new Label(i,35,"115%",rightWithBcolor);
            	sheet.addCell(lb);
            	}else if(i==35){
            		lb=new Label(i,35,"110%",rightWithBcolor);
            	sheet.addCell(lb);
            	}else
                	sheet.addCell(lb);
            	
            }
            fillPercent(33, 44);
            
           
            setFormula(17);
            setFormula(31);
            
    
           try {      //add value to F column
                    sheet.addCell(lbl0503);
                    sheet.addCell(lbl0603);
                    sheet.addCell(lbl0703);
                    sheet.addCell(lbl0803);
                    sheet.addCell(lbl0903);
                    sheet.addCell(lbl1003);
                    sheet.addCell(lbl1103);
                    sheet.addCell(lbl1203);
                    sheet.addCell(lbl1303);
                    sheet.addCell(lbl1403);
                    sheet.addCell(lbl1503);
           
                 
                   
                           
                           
                     } catch (RowsExceededException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                   
                     }
       

           wbook.write();
           try {
                            wbook.close();
                     } catch (WriteException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                     }
           
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (WriteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		if(sendmail_flag != 5){
			
			
			Dialog dlg = new Dialog(this);
			dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dlg.setContentView(R.layout.document_open_dlg);
			
			TextView msg = (TextView)dlg.findViewById(R.id.docopen_title);
			msg.setText("El archivo fue guardado en:"+file+"\n¿Deseas abrirlo?");
			
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
						AlertDialog.Builder builder= new AlertDialog.Builder(BusinCaseExcelFileActivity.this);
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
			
			
		
//			final AlertDialog.Builder adb= new AlertDialog.Builder(this);
//			adb.setCancelable(false);
//			adb.setMessage("FIle is save as"+file+"\n Do you want to Open");
//			adb.setPositiveButton("YES", new DialogInterface.OnClickListener() {
//				
//				@Override
//				public void onClick(DialogInterface dialog, int which) {
//					
//					
//					Intent intent= new Intent(Intent.ACTION_VIEW);
//					intent.setDataAndType(Uri.fromFile(file), "application/vnd.ms-excel");
//					intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//					try {
//					    startActivity(intent);
//					    finish();
//					} 
//					catch (ActivityNotFoundException e) {
//						//No application view ask to download
//						AlertDialog.Builder builder= new AlertDialog.Builder(BusinCaseExcelFileActivity.this);
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
//								
//								onBackPressed();
//							}
//						});
//					    builder.show();
//					}
//					
//				}
//			});
//			 
//			adb.setNegativeButton("No,Thanks", new DialogInterface.OnClickListener() {
//				
//				@Override
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
			
			finish();
			Intent email_intent = new Intent(Intent.ACTION_SEND);
			email_intent.setType("text/plan");
			
			ArrayList<Uri> uris = new ArrayList<Uri>();
			Uri u = Uri.fromFile(file);
			uris.add(u);
			email_intent.putExtra(Intent.EXTRA_STREAM,	Uri.parse("file://" + path));
			startActivity(Intent.createChooser(email_intent, "Choose an Email Client"));
		}


		
	}
	private void CommomColumn(int colname){
		 sheet.setColumnView(colname, 20);
		  Label lbl = new Label(colname, 5, "Flujo de Efectivo Inicial",nb);
     	try {
			sheet.addCell(lbl);
		
     	lbl = new Label(colname, 06,"Inversión requerida",nb);
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 13,"Subtotal Inversión");
     	sheet.addCell(lbl);
     	lbl  = new Label(colname, 15,"Egresos normales",nb);
     	sheet.addCell(lbl);
     	lbl = new Label(colname,22,"Subtotal Egresos Normales");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 24,"Costos normales",nb);
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 31,"Subtotal Egresos Normales");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 31,"Subtotal Egresos Normales");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 33,"Total Salidas");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 35,"Ingresos",nb);
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 42,"Subtotal Ingresos");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 44,"Ahorros",nb);
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 51,"Subtotal Ahorros");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 53,"Total Entradas");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 55,"Financiamiento");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 56,"Aportación de Capital");
     	sheet.addCell(lbl);
     	lbl = new Label(colname, 58,"Flujo de Efectivo Final");
     	sheet.addCell(lbl);
     	} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	private void setCellBackgroundColor(int ColumnName,int rowno){
		try {
			int row=rowno+6;
			for(int i=rowno;i<row;i++){
			Label green=new Label(ColumnName,i,"",lCurrencyFormat);
			sheet.addCell(green);
			}
		} catch (RowsExceededException e) {
			
			e.printStackTrace();
		} catch (WriteException e) {
			
			e.printStackTrace();
		}
	}
	
	private void fillPercent(int colname,int row){
		for(int i=colname;i<42;i++){
			Label l=new Label(i, row,"0%",rightWithBcolor);
			try {
			if(i==34 || i==35){
				if(row!=44){
				l=new Label(i, row,"110%",rightWithBcolor);
				sheet.addCell(l);
				}else{
					l=new Label(i, row,"105%",rightWithBcolor);
					sheet.addCell(l);
					
				}
				
			}else
				sheet.addCell(l);
			} catch (RowsExceededException e) {
			
				e.printStackTrace();
			} catch (WriteException e) {
			
				e.printStackTrace();
			}
			
		}
	}
	
	private void setFormula(int colName){
		Formula f=null;
		try{
		 f=new Formula(colName, 7, "D8");
        sheet.addCell(f);
        f=new Formula(colName, 8, "D9");
        sheet.addCell(f);
        f=new Formula(colName, 9, "D10");
        sheet.addCell(f);
        f=new Formula(colName, 10, "D11");
        sheet.addCell(f);
        f=new Formula(colName, 11, "D12");
        sheet.addCell(f);
        f=new Formula(colName, 12, "D13");
        sheet.addCell(f);
        
        f=new Formula(colName, 16, "D17");
        sheet.addCell(f);
        f=new Formula(colName, 17, "D18");
        sheet.addCell(f);
        f=new Formula(colName, 18, "D19");
        sheet.addCell(f);
        f=new Formula(colName, 19, "D20");
        sheet.addCell(f);
        f=new Formula(colName, 20, "D21");
        sheet.addCell(f);
        f=new Formula(colName, 21, "D22");
        sheet.addCell(f);
        
        f=new Formula(colName, 25, "D26");
        sheet.addCell(f);
        f=new Formula(colName, 26, "D27");
        sheet.addCell(f);
        f=new Formula(colName, 27, "D28");
        sheet.addCell(f);
        f=new Formula(colName, 28, "D29");
        sheet.addCell(f);
        f=new Formula(colName, 29, "D30");
        sheet.addCell(f);
        f=new Formula(colName, 30, "D31");
        sheet.addCell(f);
        
        f=new Formula(colName, 36, "D37");
        sheet.addCell(f);
        f=new Formula(colName, 37, "D38");
        sheet.addCell(f);
        f=new Formula(colName, 38, "D39");
        sheet.addCell(f);
        f=new Formula(colName, 39, "D40");
        sheet.addCell(f);
        f=new Formula(colName, 40, "D41");
        sheet.addCell(f);
        f=new Formula(colName, 41, "D42");
        sheet.addCell(f);

        f=new Formula(colName, 45, "D46");
        sheet.addCell(f);
        f=new Formula(colName, 46, "D47");
        sheet.addCell(f);
        f=new Formula(colName, 47, "D48");
        sheet.addCell(f);
        f=new Formula(colName, 48, "D49");
        sheet.addCell(f);
        f=new Formula(colName, 49, "D50");
        sheet.addCell(f);
        f=new Formula(colName, 50, "D51");
        sheet.addCell(f);
        
       
		} catch (RowsExceededException e) {
			
			e.printStackTrace();
		} catch (WriteException e) {
		
			e.printStackTrace();
		}
				
	}

}
