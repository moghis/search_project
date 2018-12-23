/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soocket;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner inputQuery = new Scanner(System.in);
        Scanner inputPlan = new Scanner(System.in); 
        ReadFile readFile = new ReadFile();
        Show show = new Show();
        Search search = new Search();
        File folder = new File("data");
        ArrayList<String> stopWords = readFile.getStopWords("stopWord.txt");
        ArrayList<Word> words = readFile.getAllWords(folder,stopWords);
        
        System.out.println("ready");
        System.out.println("0- show all words");
        System.out.println("1- simple query");
        System.out.println("2- and query");
        System.out.println("3- or query");
        System.out.println("4- not query");
        System.out.println("5- near query");
        System.out.print("choose your plan:");
        int plan = inputPlan.nextInt();
        if(plan==0)
        {
            show.showAllWords(words);
        }
        else if(plan==1)
        {
            System.out.print("write your query:");
            String query = inputQuery.nextLine();
            Word result = search.find(words, query);
            show.showResult(result);
        }
        else if(plan==2)
        {
            System.out.print("write your query:");
            String query = inputQuery.nextLine();
            ArrayList<Data> result = search.findAnd(words, query.split(" ")[0],query.split(" ")[1]);
            show.showResultAnd(result,query.split(" ")[0]+" & "+query.split(" ")[1]);
        }
        else if(plan==3)
        {
            System.out.print("write your query:");
            String query = inputQuery.nextLine();
            ArrayList<Data> result = search.findOr(words, query.split(" ")[0],query.split(" ")[1]);
            show.showResultOr(result,query.split(" ")[0]+" or "+query.split(" ")[1]);
        }
        else if(plan==4)
        {
            System.out.print("write your query:");
            String query = inputQuery.nextLine();
            Word result = search.find(words, query);
            show.showResultNot(result,readFile.getFileName(folder));
        }
        else if(plan==5)
        {
            
        }
    }
}
