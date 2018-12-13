package com.android.yashika.andropedia.Model;

import java.io.Serializable;

/**
 * Created by Yashika on 19-07-2017.
 */

public class Interview_ques implements Serializable{
    String ques;
    String answer;

    public Interview_ques(String ques, String answer) {
        this.ques = ques;
        this.answer = answer;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
