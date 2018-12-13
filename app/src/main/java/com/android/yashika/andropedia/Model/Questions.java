package com.android.yashika.andropedia.Model;

/**
 * Created by Yashika on 18-07-2017.
 */

public class Questions {
    String ques;
    String op_1;
    String op_2;
    String op_3;
    String op_4;
    String correct;

    public Questions(String ques, String op_1, String op_2, String op_3, String op_4, String correct) {
        this.ques = ques;
        this.op_1 = op_1;
        this.op_2 = op_2;
        this.op_3 = op_3;
        this.op_4 = op_4;
        this.correct = correct;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getOp_1() {
        return op_1;
    }

    public void setOp_1(String op_1) {
        this.op_1 = op_1;
    }

    public String getOp_2() {
        return op_2;
    }

    public void setOp_2(String op_2) {
        this.op_2 = op_2;
    }

    public String getOp_3() {
        return op_3;
    }

    public void setOp_3(String op_3) {
        this.op_3 = op_3;
    }

    public String getOp_4() {
        return op_4;
    }

    public void setOp_4(String op_4) {
        this.op_4 = op_4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}
