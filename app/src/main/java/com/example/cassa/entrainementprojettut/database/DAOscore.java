package com.example.cassa.entrainementprojettut.database;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.cassa.entrainementprojettut.PlayerUtils.Score;
import com.example.cassa.entrainementprojettut.database.DBOpenHelper.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clement on 07/02/18.
 */

public class DAOscore extends DAOconnection {

    private static DAOscore instance;


    private DAOscore(Context context) {
        super(context);
    }

    public static DAOscore getInstance(Context context){
        if(instance==null){
            instance=new DAOscore(context);
        }
        return instance;
    }

    public List<Score> findScoreForAGame(String gameName,int difficulty){
        List<Score> resultSet=new ArrayList<>();
        String query="select "+Constants.COL_PLAYER_TABLE_4+","+Constants.COL_SCORE_TABLE_4+
                " from "+Constants.FOURTH_TABLE+
                " NATURAL JOIN "+Constants.THIRD_TABLE+" NATURAL JOIN "+Constants.FIRST_TABLE+
                " WHERE "+Constants.COL_NAME_TABLE_1+" =? and "+Constants.COL_DIFFICULTY_TABLE_3+"=?";
        Log.d("score",query);
        Cursor c=sqLiteDatabase.rawQuery(query,new String[]{gameName,String.valueOf(difficulty)});
        while (c.moveToNext()){
            String playerName=c.getColumnName(1);
            long score=c.getLong(2);
            resultSet.add(new Score(gameName,playerName,score,difficulty));
        }
        c.close();
        return resultSet;
    }
}
