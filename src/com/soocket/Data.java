/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soocket;

/**
 *
 * @author admin
 */
public class Data {
    private int position ;
    private String docStr;
    private int docId;
    
    public void setPosition(int position)
    {
        this.position = position;
    }
    
    public int getPosition()
    {
        return position;
    }
    
    public void setDocStr(String docStr)
    {
        this.docStr = docStr;
    }
    
    public String getDocStr()
    {
        return docStr;
    }
    
    public void setDocId(int docId)
    {
        this.docId = docId;
    }
    
    public int getDocId()
    {
        return docId;
    }
    
}
