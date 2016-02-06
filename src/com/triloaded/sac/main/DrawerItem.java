
package com.triloaded.sac.main;


public class DrawerItem
{
    private int icon;
    private String title;

    public DrawerItem(){
        
    }

    public DrawerItem(String s, int i){
        title = s;
        icon = i;
        
    }

    public int getIcon(){
        return icon;
    }

    public String getTitle(){
        return title;
    }

    public void setIcon(int i){
        icon = i;
    }

    public void setTitle(String s){
        title = s;
    }
}
