package com.company;

import java.io.*;
import java.util.*;

public class Cosine {

    public double ReadFile(String file1,String file2) throws IOException {

        File myObj1 = new File(file1);
        Scanner myReader1 = new Scanner(myObj1);
        HashSet<String> list1 = new HashSet<String>();
        // Reading first file
        while (myReader1.hasNext()) {
            list1.add(myReader1.next());
        }
        myReader1.close();
        //Reading Second File
        File myObj2 = new File(file2);
        Scanner myReader2 = new Scanner(myObj2);
        HashSet<String> list2 = new HashSet<String>();
        while (myReader2.hasNext()) {
            list2.add(myReader2.next());
       }
        myReader2.close();
        double res= cosineSim(list1,list2);
        return res;


    }
    public double cosineSim(HashSet<String>doc1,HashSet<String>doc2) {

        HashSet<String> copyList = new HashSet<>(doc1);
       //Copy list Contains D1 union D2
        copyList.addAll(doc2);
        ArrayList<Integer> d1 = new ArrayList<Integer>();
        ArrayList<Integer> d2 = new ArrayList<Integer>();
        String[] arr = copyList.toArray(new String[copyList.size()]);

        // Loop To check if d1 contains word from copy list
        for (int i = 0; i < arr.length; i++) {
            if (doc1.contains(arr[i])) {
                d1.add(1);
            } else d1.add(0);
        }
        // Loop To check if d2 contains word from copy list
        for (int j = 0; j < arr.length; j++) {
            if (doc2.contains(arr[j])) {
                d2.add(1);
            } else d2.add(0);
        }

        int resDot = 0;
        double normA = 0, normB = 0;
        // Calculating the norm
        for (int i = 0; i < arr.length; i++) {
           // D1.D2
            resDot += d1.get(i) * d2.get(i);
            // Norm without square root
            normA += Math.pow(d1.get(i), 2);
            normB += Math.pow(d2.get(i), 2);
        }

        double finRes;
        ArrayList<Double> finarr = new ArrayList<Double>();
        // D1.D2/normA*normB
        finRes = resDot / (Math.sqrt(normA) * Math.sqrt(normB));
        finarr.add(finRes);
        double theta = 0;
        theta = Math.toDegrees(Math.acos(finRes));
        return finRes;

    }
    //To print the output sorted descendingly
    public void sort(ArrayList<Double>ans,ArrayList<String>output){

        for (int i = 0; i < ans.size(); i++)
        {
            for (int j = i + 1; j < ans.size(); j++)
            {
                double tmp = 0;
                String tempSt;

                if (ans.get(i) < ans.get(j))
                {
                    tmp = ans.get(i);
                    ans.set(i,ans.get(j));
                    ans.set(j,tmp);
                    tempSt = output.get(i);
                    output.set(i,output.get(j));
                    output.set(j,tempSt);

                }
            }
        }

        for (int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i)+" "+ans.get(i));

        }

    }
}