package com.example.safarpe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "safarpe.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_ROUTE = "routes";
    public static final String COL_ID = "id";
    public static final String COL_ORIGIN = "origin";
    public static final String COL_DESTINATION = "destination";
    public static final String COL_FARE = "fare";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createRouteTable = "CREATE TABLE " + TABLE_ROUTE + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_ORIGIN + " TEXT, " +
                COL_DESTINATION + " TEXT, " +
                COL_FARE + " TEXT)";
        db.execSQL(createRouteTable);

        String createBookingTable = "CREATE TABLE" + TABLE_BOOKING + "(" +
                COL_BOOKING_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_BOOKING_ORIGIN + " TEXT," +
                COL_BOOKING_DESTINATION + " TEXT," +
                COL_BOOKING_FARE + " TEXT)";
        db.execSQL(createBookingTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROUTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKING);
        onCreate(db);
    }


    public boolean insertRoute(String origin, String destination, String fare) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ORIGIN, origin);
        values.put(COL_DESTINATION, destination);
        values.put(COL_FARE, fare);
        long result = db.insert(TABLE_ROUTE, null, values);
        return result != -1;
    }


    public Cursor getAllRoutes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ROUTE, null);
    }

    //booking table / insert method
    public static final String TABLE_BOOKING = "bookings";
    public static final String COL_BOOKING_ID = "id";
    public static final String COL_BOOKING_ORIGIN = "origin";
    public static final String COL_BOOKING_DESTINATION = "destination";
    public static final String COL_BOOKING_FARE = "fare";

    public boolean insertBooking(String origin, String destination, String fare) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_BOOKING_ORIGIN, origin);
        values.put(COL_BOOKING_DESTINATION, destination);
        values.put(COL_BOOKING_FARE, fare);
        long result = db.insert(TABLE_BOOKING, null, values);
        return result != -1;
    }
    public Cursor getAllBookings() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_BOOKING, null);
    }
}
