package com.android.yashika.andropedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.yashika.andropedia.Model.Questions;

import java.util.ArrayList;

/**
 * Created by Yashika on 28-07-2017.
 */

public class QuestionDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="AndroidQues";
    private static final String TABLE_NAME = "questions";
    private static final String QUE_NO = "que_no";
    private static final String QUESTION = "ques";
    private static final String OP_1 = "op_1";
    private static final String OP_2 = "op_2";
    private static final String OP_3 = "op_3";
    private static final String OP_4 = "op_4";
    private static final String CORRECT = "correct";

    private Context context;
    public QuestionDBHelper(Context context) {
        super(context, DB_NAME,null,1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+QUE_NO+" INTEGER PRIMARY KEY, "
                +QUESTION+" VARCHAR , "+OP_1+" VARCHAR, "+OP_2+" VARCHAR, "+ OP_3 +" VARCHAR, "
                +OP_4+" VARCHAR, "+CORRECT+" VARCHAR ) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME+"");
    }

    public boolean insertQuestion(Questions questions){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(QUESTION,questions.getQues());
        values.put(OP_1,questions.getOp_1());
        values.put(OP_2,questions.getOp_2());
        values.put(OP_3,questions.getOp_3());
        values.put(OP_4,questions.getOp_4());
        values.put(CORRECT,questions.getCorrect());
        database.insert(TABLE_NAME,null,values);
        database.close();
        return true;
    }

    public ArrayList<Questions> retrieveQuestion(){
        ArrayList<Questions> list = new ArrayList<>();
        String query = "SELECT * FROM "+ TABLE_NAME+" WHERE "+QUE_NO +" IN (SELECT "+QUE_NO+" FROM "+TABLE_NAME+" ORDER BY RANDOM() LIMIT 10)";
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery(query,null);
        if(cursor.getCount()>0) {
            while (cursor.moveToNext()) {
                list.add(new Questions(cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)));
            }
        }
        return list;
    }
}
