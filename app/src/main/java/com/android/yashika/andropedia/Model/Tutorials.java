package com.android.yashika.andropedia.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Yashika on 06-07-2017.
 */

public class Tutorials implements Serializable{

    String title;
    ArrayList<SubTutorial> subTutorials;

    public Tutorials(String title, ArrayList<SubTutorial> subTutorials) {

        this.title = title;
        this.subTutorials = subTutorials;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<SubTutorial> getSubTutorials() {
        return subTutorials;
    }

    public void setSubTutorials(ArrayList<SubTutorial> subTutorials) {
        this.subTutorials = subTutorials;
    }
}
