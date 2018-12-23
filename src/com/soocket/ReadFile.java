/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soocket;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author admin
 */
public class ReadFile {
    
    private boolean isStopWord(String word , ArrayList<String> stopWords)
    {
        boolean flag = false;
        for (int i = 0; i < stopWords.size() ; i++) {
            if(stopWords.get(i) == null ? word == null : stopWords.get(i).equals(word))
            {
                flag=true;
            }
        }
        return flag;
    }
    
    public ArrayList<String> getStopWords(String location) throws FileNotFoundException, IOException
    {
        File file = new File(location); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String line;
        String content="";
        while ((line = br.readLine()) != null) 
            content += line + " ";
        
        ArrayList<String> result = new ArrayList<String>();
        Pattern p = Pattern.compile("[a-zA-Z]+"); 
        Matcher matcher = p.matcher(content); 
        while (matcher.find()) 
        {
            result.add(matcher.group());
        }
        return result;
    }
    
    public ArrayList<Word> getAllWords(final File folder , ArrayList<String> stopWords) throws FileNotFoundException, IOException 
    {
        ArrayList<Word> allWords = new ArrayList<Word>();
        int docId=-1;
        for (final File fileEntry : folder.listFiles()) 
        {
            if (fileEntry.isFile()) 
            {
                docId++;
                File file = new File(fileEntry.toString()); 
                BufferedReader br = new BufferedReader(new FileReader(file)); 
  
                String line;
                String content="";
                while ((line = br.readLine()) != null) 
                    content += line + " ";
                
                Pattern p = Pattern.compile("[a-zA-Z]+"); 
                Matcher matcher = p.matcher(content);
                
                int pos = 0;
                while (matcher.find()) 
                {
                    pos++;
                    if(!isStopWord(matcher.group(),stopWords))
                    {
                        boolean flag = false;
                        Data data = new Data();
                        data.setDocStr(fileEntry.getName());
                        data.setPosition(pos);
                        data.setDocId(docId);
                        for (int i = 0; i < allWords.size(); i++)
                        {
                            if(allWords.get(i).getName() == null ? matcher.group() == null : allWords.get(i).getName().equals(matcher.group()))
                            {
                                flag=true;
                                allWords.get(i).setdoc(data);
                            }
                        }
                        
                        if(!flag)
                        {
                            Word word = new Word();
                            word.setName(matcher.group());
                            word.setdoc(data);
                            allWords.add(word);
                        }
                    }
                }
            }
        }
        return allWords;
    }
    
    public ArrayList<String> getFileName(final File folder)
    {
        ArrayList<String> fileNames = new ArrayList<String>();
        
        for (final File fileEntry : folder.listFiles())
            fileNames.add(fileEntry.getName());
        
        return fileNames;
    }
}
