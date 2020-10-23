package com.example.cocoding.Flow;

import java.util.HashMap;
import java.util.Map;

public class Flow{
    public int id;
    public int number;
    public String text;

    public Flow(){

    }

    public Flow(int id, int number, String text){
        this.id = id;
        this.number = number;
        this.text = text;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("number", number);
        result.put("text", text);
        return result;
    }
}
