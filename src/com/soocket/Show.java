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
public class Show {
    
    public void showResultNot(Word word,ArrayList<String> fileNames)
    {
        int j , i , num=1 ;
        if(word!=null)
        {
            if(word.getdocs().size()<fileNames.size())
            {
                System.out.println("not "+word.getName()+" :");
                for (i = 0 ; i < fileNames.size() ; i++)
                {
                    for (j = 0 ; j < word.getdocs().size() ; j++) 
                    {
                        if(word.getdocs().get(j).getDocStr() == null ? fileNames.get(i) == null : word.getdocs().get(j).getDocStr().equals(fileNames.get(i)))
                            break;
                    }
                    if(j == word.getdocs().size())
                    {
                        System.out.println(num+" - "+fileNames.get(i));
                        num++;
                    }
                }
            }
            else
            {
                System.out.println("not found");
            }
        }
        else
        {
            for (int k = 0; k < fileNames.size(); k++)
            {
                System.out.println(num+" - "+fileNames.get(k));
                num++;
            }
        }
    }
    
    public void showResult(Word word)
    {
        if(word!=null)
        {
            System.out.println(word.getName()+" :");
            for (int i = 0; i < word.getdocs().size(); i++) 
                System.out.println((i+1)+" - "+word.getdocs().get(i).getDocStr()+"["+word.getdocs().get(i).getPosition()+"]");
        }
        else
        {
            System.out.println("not found");
        }
    }
    
    public void showResultAnd(ArrayList<Data> datas,String query)
    {
        int num=1;
        if(datas!=null)
        {
            System.out.println(query +" :");
            for (int i = 0; i < datas.size(); i++)
            {
                if(i<datas.size()-1)
                {
                    if(datas.get(i).getDocId() == datas.get(i+1).getDocId())
                    {
                        System.out.print(num+" - ");
                        num++;
                    }
                }
                System.out.print(datas.get(i).getDocStr()+"["+datas.get(i).getPosition()+"]");
                if(i<datas.size()-1)
                {
                    if(datas.get(i).getDocId() == datas.get(i+1).getDocId())
                        System.out.print(",");
                    else
                        System.out.println(); 
                }
            }
        }
        else
        {
            System.out.println("not found");
        }
    }
    
    public void showResultOr(ArrayList<Data> datas,String query)
    {
        if(datas!=null)
        {
            System.out.println(query +" :");
            
            for (int i = 0; i < datas.size(); i++)
            {
                System.out.print((i+1)+"-"+ datas.get(i).getDocStr()+"["+datas.get(i).getPosition()+"]");
                if(i<datas.size()-1)
                {
                    System.out.println(); 
                }
            }
        }
        else
        {
            System.out.println("not found");
        }
    }
    
    public void showAllWords(ArrayList<Word> words)
    {
        if(words!=null)
        {
            for (int i = 0; i < words.size(); i++) 
            {
                System.out.print(words.get(i).getName()+" --> ");
                for (int j = 0; j < words.get(i).getdocs().size(); j++) 
                {
                    System.out.print(words.get(i).getdocs().get(j).getDocStr()+"["+words.get(i).getdocs().get(j).getPosition()+"]");
                    if(j < words.get(i).getdocs().size()-1)
                        System.out.print(" --> ");
                }
                System.out.println();
            }
        }
        else
        {
            System.out.println("not found");
        }
    }
}
