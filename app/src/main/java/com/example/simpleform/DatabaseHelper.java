package com.example.simpleform;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "simple_form_data";
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_Date_Of_Birth = "date_of_birth";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_SIGN_UP_DATE = "signup_date";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + " ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FIRST_NAME + " TEXT,"
                + KEY_LAST_NAME + " TEXT,"
                + KEY_GENDER + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_Date_Of_Birth + " TEXT,"
                + KEY_PASSWORD + " TEXT,"
                + KEY_SIGN_UP_DATE + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }


    public boolean addUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues user_values = new ContentValues();

        user_values.put(KEY_FIRST_NAME, user.getFirst_name());
        user_values.put(KEY_LAST_NAME, user.getLast_name());
        user_values.put(KEY_GENDER, user.getGender());
        user_values.put(KEY_EMAIL, user.getEmail());
        user_values.put(KEY_Date_Of_Birth, user.getDate_of_birth());
        user_values.put(KEY_PASSWORD, user.getPassword());
        user_values.put(KEY_SIGN_UP_DATE, user.getSignup_date());

        Log.d(DATABASE_NAME, "addUser: Adding " + user + " to " + TABLE_USERS);
        long result = db.insert(TABLE_USERS, null, user_values);
        if (result == -1)
            return false;
        else
            return true;
    }


    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        String select_query = "SELECT * FROM " + TABLE_USERS;
        Cursor cursor = db.rawQuery(select_query, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setFirst_name(cursor.getString(1));
                user.setLast_name(cursor.getString(2));
                user.setGender(cursor.getString(3));
                user.setEmail(cursor.getString(4));
                user.setDate_of_birth(cursor.getString(5));
                user.setPassword(cursor.getString(6));
                user.setSignup_date(cursor.getString(7));

                userList.add(user);

            } while (cursor.moveToNext());
        }
        return userList;
    }
}