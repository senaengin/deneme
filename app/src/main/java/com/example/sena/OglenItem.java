package com.example.sena;

public class OglenItem {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private int calValue;

    public OglenItem( String text1, String text2, int calValue) {

        this.mText1 = text1;
        this.mText2 = text2;
        this.calValue=calValue;
    }



    public String getText1() {
        return this.mText1;
    }

    public String getText2() {
        return this.mText2;
    }

    public int getCalValue() {
        return calValue;
    }
}
