package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
    ArrayList<String>paths=new ArrayList<>();
    paths.add("D:\\FCAI\\Second Term\\IR\\Labs\\docs\\test1.txt");
    paths.add("D:\\FCAI\\Second Term\\IR\\Labs\\docs\\test2.txt");
    paths.add("D:\\FCAI\\Second Term\\IR\\Labs\\docs\\test3.txt");
    paths.add("D:\\FCAI\\Second Term\\IR\\Labs\\docs\\test4.txt");
	Cosine cs=new Cosine();
    ArrayList<Double>finalArr=new ArrayList<>();
    finalArr.add(cs.ReadFile(paths.get(0), paths.get(1)));
    finalArr.add(cs.ReadFile(paths.get(0), paths.get(2)));
    finalArr.add(cs.ReadFile(paths.get(0), paths.get(3)));
    finalArr.add(cs.ReadFile(paths.get(1), paths.get(2)));
    finalArr.add(cs.ReadFile(paths.get(1), paths.get(3)));
    finalArr.add(cs.ReadFile(paths.get(2), paths.get(3)));
    ArrayList<String>output=new ArrayList<>();
    output.add("D1 and D2");
    output.add("D1 and D3");
    output.add("D1 and D4");
    output.add("D2 and D3");
    output.add("D2 and D4");
    output.add("D3 and D4");
        cs.sort(finalArr,output);
        }
}
