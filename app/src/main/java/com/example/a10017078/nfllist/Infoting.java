package com.example.a10017078.nfllist;

import java.io.Serializable;

public class Infoting implements Serializable {

    private String str;
    private int img;
    private int exp;
    private String pos;
    private String des;
    private int face;
    private int yds;
    private int tds;

    public Infoting(String s, int i, int xp, String p, String d, int f, int y, int t){
        str = s;
        img = i;
        exp = xp;
        pos = p;
        des = d;
        this.face = f;
        yds = y;
        tds = t;
    }

    public String getName(){
        return str;
    }

    public int getImg(){
        return img;
    }

    public int getExp() {
        return exp;
    }

    public String getPos() {
        return pos;
    }

    public String getDes() { return des; }

    public int getFace() {
        return face;
    }

    public int getTds() {
        return tds;
    }

    public int getYds() {
        return yds;
    }
}

