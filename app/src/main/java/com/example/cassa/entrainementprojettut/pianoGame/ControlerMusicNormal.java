package com.example.cassa.entrainementprojettut.pianoGame;

import com.example.cassa.entrainementprojettut.PlayerUtils.PlayerLifes;

import java.util.List;

/**
 * Created by clement on 23/01/18.
 */

public class ControlerMusicNormal extends IControlerMusic {

    public ControlerMusicNormal() {

        lifes=new PlayerLifes();
        List<Note> noteList = generateNotes(8);
        this.music = new Music(noteList);
        size = 3;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);

    }

    ControlerMusicNormal(Music music) {
        lifes=new PlayerLifes();
        this.music = music;
        size=3;
        music.generateSequence(size);
        this.positionSequence = 0;
        actualKey = music.getSequence().get(positionSequence);
    }

    protected int goodAnswerConsequences() {
        if (sequenceFinished()) {
            if(!songFinished()){
                generateNewSequence(1);
                return 0;
            }
            return 1;
        }
        else{
            progressSequence();
            return 2;
        }
    }

}
