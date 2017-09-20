package com.uwimonacs.computingsociety.models;

import android.widget.ImageView;

import com.activeandroid.Model;
import com.activeandroid.annotation.Table;

/**
 * Created by jourdanDunkley on 1/9/2017.
 */
@Table(name="Member")
public class Member extends Model {

    private String name, position;
    private int picId;

    public Member()
    {
        super();
    }

    public Member(String name, String position, int picId){
        this.name = name;
        this.position = position;
        this.picId = picId;
    }
    public String getName(){
        return name;
    }
    public String getPosition(){
        return position;
    }
    public int getPicId(){
        return picId;
    }
    public Member setName(String name){
        this.name = name;
        return this;
    }
    public Member setPosition(String position){
        this.position = position;
        return this;
    }
    public Member setPicId(int picId){
        this.picId = picId;
        return this;
    }
}
