package com.dsc.android.bootcamp1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RecyclerViewData {

    private String image;
    private String name;
    private String number;

   public class RecycleriewData implements Serializable{
       @SerializedName("image")
       @Expose
       private String image;

       @SerializedName("name")
       @Expose
       private String name;

       @SerializedName("number")
       @Expose
       private String number;

       public String getImage(){
           return image;
       }
   }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }


}

