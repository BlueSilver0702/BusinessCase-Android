package com.sergio.businesscase.db;

import com.sergio.businesscase.helper.Attributes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAHelper  extends SQLiteOpenHelper{

	public DBAHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(Attributes.Database.CREATE_BUSINESSCASE_QUERY);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	
		db.execSQL("Drop table is exits"+Attributes.Database.TABLE_NAME_BUSINESSCASE);
		
	}

}
