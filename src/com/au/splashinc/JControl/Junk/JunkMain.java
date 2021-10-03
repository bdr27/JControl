/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.au.splashinc.JControl.Junk;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brendan
 */
public class JunkMain {
    public void execute(){
        albumsTest();
        dictionaryTest();
        helloWorld();
    }
    
    private static void helloWorld(){
        System.out.println("Hello World");
    }

    private void albumsTest(){
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        Gson gson = getGson();
        System.out.println(gson.toJson(albums));
    }
    
    private void dictionaryTest(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Test", 0);
        map.put("Another Test", 12);
        Gson gson = getGson();
        System.out.println(gson.toJson(map));
    }
    
    private Gson getGson(){
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        return gson;
    }
}
