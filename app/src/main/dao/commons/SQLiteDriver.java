package br.com.bandoni.dao.commons;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class SQLiteDriver
{
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database=null;
    private static SQLiteDriver instance;
    private boolean writeable;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    private SQLiteDriver(Context context)
    {
        this.openHelper = new DatabaseOpenHelper(context);
        writeable = false;
    }

    /**
     * Return a singleton instance of SQLiteDriver.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static SQLiteDriver getInstance(Context context)
    {
        if (context != null)
          return new SQLiteDriver(context);
        else
          return null;
    }

    /**
     * Open the database connection.
     */
    public void open(Boolean openWrite)
    {
        if (database != null)
        {
            if (writeable == openWrite)
                return;
           this.close();
        }
        if (openWrite)
           this.database = openHelper.getWritableDatabase();
         else
            this.database = openHelper.getReadableDatabase();
        writeable = openWrite;
    }

    public SQLiteDatabase getDatabase()
    {
        return this.database;
    }

    /**
     * Close the database connection.
     */
    public void close()
    {
        if (database != null)
        {
            this.database.close();
        }
    }


    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<String> getBrowserFromTable(String tableName)
    {
        List<String> list = new ArrayList<>();
        List<String> fields = DAOFieldGroups.getTableBrowserColumns(tableName);

        String query = "Select ";
        int tamanho = fields.size();
        for (int i = 0;i < tamanho;i++)
        {
            query += fields.get(i) +(((i+1)==tamanho)?" ":"||'-'||");
        }
        query += " from "+tableName;
        //Log.d("DEBUG", "getBrowserFromTable: "+query);
        Cursor cursor = database.rawQuery(query, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            list.add(cursor.getString(0));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }

    public ArrayList<ArrayList<String>>  getMatrixDataFromTable(String tableName)
    {
        String[] fields = DAOFieldGroups.getArrBrowserColumns(tableName);

        String query = "Select ";
        int tamanho = fields.length;
        for (int i = 0;i < tamanho;i++)
        {
            query += fields[i] +(((i+1)==tamanho)?" ":",");
        }
        query += " from "+tableName;
        Cursor cursor = database.rawQuery(query, null);
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            ArrayList<String> item = new ArrayList<String>();
            for (int i = 0;i < tamanho;i++)
                item.add(cursor.getString(i));
            cursor.moveToNext();
            list.add(item);
        }
        cursor.close();
        return list;
    }
}