package com.android.yashika.andropedia.Model;

import java.io.Serializable;

/**
 * Created by Yashika on 06-07-2017.
 */

public class SubTutorial implements Serializable{

    String title;
    String filename;

    public SubTutorial( String title, String filename)
    {
        this.title = title;
        this.filename=filename;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
