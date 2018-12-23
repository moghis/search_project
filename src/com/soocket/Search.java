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
public class Search {
    
    public Word find(ArrayList<Word> words , String query)
    {
        Word word = null;
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).getName() == null ? query == null : words.get(i).getName().equals(query))
            {
                word = words.get(i);
            }
        }
        return word;
    }
    
    public ArrayList<Data> findAnd(ArrayList<Word> words , String query1 , String query2)
    {
        ArrayList<Data> result = new ArrayList<Data>();
        int query1Word=-1,query2Word=-1;
        int m=0,n=0;
        
        for (int i = 0; i < words.size(); i++) 
        {
            if(words.get(i).getName() == null ? query1 == null : words.get(i).getName().equals(query1))
                query1Word = i;
        }
        
        for (int i = 0; i < words.size(); i++) 
        {
            if(words.get(i).getName() == null ? query2 == null : words.get(i).getName().equals(query2))
                query2Word = i;
        }
        
        if(query1Word!=-1 && query2Word!=-1)
        {
            while(m<words.get(query1Word).getdocs().size() && n<words.get(query2Word).getdocs().size())
            {
                if(words.get(query1Word).getdocs().get(m).getDocId() == words.get(query2Word).getdocs().get(n).getDocId())
                {
                    result.add(words.get(query1Word).getdocs().get(m));
                    result.add(words.get(query2Word).getdocs().get(n));
                    n++;
                    m++;
                }
                else
                {
                    if(words.get(query1Word).getdocs().get(m).getDocId() < words.get(query2Word).getdocs().get(n).getDocId())
                        m++;
                    else
                        n++;
                }
            }
        }
        else
        {
            result=null;
        }
        
        return result;
    }
    
    public ArrayList<Data> findOr(ArrayList<Word> words , String query1 , String query2)
    {
        ArrayList<Data> result = new ArrayList<Data>();
        int query1Word=-1,query2Word=-1;
        
        for (int i = 0; i < words.size(); i++) 
        {
            if(words.get(i).getName() == null ? query1 == null : words.get(i).getName().equals(query1))
                query1Word = i;
        }
        
        for (int i = 0; i < words.size(); i++) 
        {
            if(words.get(i).getName() == null ? query2 == null : words.get(i).getName().equals(query2))
                query2Word = i;
        }
        
        if(query1Word!=-1)
        {
            result.addAll(words.get(query1Word).getdocs());
        } 
        
        if(query2Word!=-1)
        {
            result.addAll(words.get(query2Word).getdocs());
            /*for (int i = 0 ; i < words.get(query2Word).getdocs().size() ; i++) {
                if(!result.contains(words.get(query2Word).getdocs().get(i)))
                    result.add(words.get(query2Word).getdocs().get(i));
            }*/
        }
        
        if(query1Word == -1 && query2Word == -1)
        {
            result=null;
        }
        
        return result;
    }
}
