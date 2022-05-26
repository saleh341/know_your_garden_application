package com.example.knowyourgarden;


  class Item {

    String Name;
      String Image;

    public Item(String Name,String Image)
    {
        this.Name=Name;
        this.Image=Image;
    }
    public String getbName()
    {
        return Name;
    }
    public String getbImage()
    {
        return Image;
    }
}