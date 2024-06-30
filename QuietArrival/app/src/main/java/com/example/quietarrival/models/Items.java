package com.example.quietarrival.models;

public class Items{
    private  String itemName;
    private  String itemDesc;
    private  long iconId;

   public Items(String itemName,String itemDesc,long iconId){

        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.iconId = iconId;
   }

    public String getItemName() {
        return itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public long getIconId() {
        return iconId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
    public void setIconId(long iconId) {
        this.iconId = iconId;
    }
}


