/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soocket;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Word {
    
    private String name;
    private ArrayList<Data> docs = new ArrayList<Data>();
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public ArrayList<Data> getdocs()
    {
        return docs;
    }
    
    public void setdoc(Data doc)
    {
        docs.add(doc);
    }
}
