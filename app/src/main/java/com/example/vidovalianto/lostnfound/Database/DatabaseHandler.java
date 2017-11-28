package com.example.vidovalianto.lostnfound.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.vidovalianto.lostnfound.Model.User;

/**
 * Created by    VidoValianto on 11/27/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "User.db";

    private SQLiteDatabase db;

    private SQLiteDatabase database;

    // Contacts table name
    public static final String TABLE_USER = "userData";

    // Contacts Table Columns names
    private static final String KEY_USER = "user";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_USER+ " STRING," + KEY_EMAIL + " STRING,"
                + KEY_PASSWORD+ " STRING" + ")" ;
        db.execSQL(CREATE_USER_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    // Adding new contact
    public void addLocation(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER, User.getUsername());
        values.put(KEY_EMAIL, User.getEmail());
        values.put(KEY_PASSWORD, User.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public Cursor fetch() {
        Cursor cursor = this.database.query(DatabaseHandler.TABLE_USER, new String[]{DatabaseHandler.KEY_USER, DatabaseHandler.KEY_PASSWORD, DatabaseHandler.KEY_EMAIL}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor finduser(String username)throws SQLException {
        String query = "SELECT * FROM userData WHERE KEY_USER=" + username;

        Cursor  cursor = db.rawQuery(query,null);

        if (cursor != null) {
            cursor.moveToFirst();

        }

        return cursor;

    }

    public Cursor findpassword(String password)throws SQLException {
        String query = "SELECT * FROM userData WHERE password=" + password;

        Cursor  cursor = db.rawQuery(query,null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }



}

