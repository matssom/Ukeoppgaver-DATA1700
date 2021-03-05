package com.example.demo.klientTjener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    private final Integer[] tempArray = new Integer[]{-3,-2,2,7,12,16,18,17,12,7,3,-2};

    @GetMapping("/hentTemp")
    public int hentTemp(String maaned){
        int temp;
        switch (maaned){
            case "Januar" : temp = tempArray[0];
                break;
            case "Februar" : temp = tempArray[1];
                break;
            case "Mars" : temp = tempArray[2];
                break;
            case "April" : temp = tempArray[3];
                break;
            case "Mai" : temp = tempArray[4];
                break;
            case "Juni" : temp = tempArray[5];
                break;
            case "Juli" : temp = tempArray[6];
                break;
            case "August" : temp = tempArray[7];
                break;
            case "September" : temp = tempArray[0];
                break;
            case "Oktober" : temp = tempArray[1];
                break;
            case "November" : temp = tempArray[2];
                break;
            case "Desember" : temp = tempArray[3];
                break;
            default: temp=0;
        }
        return temp;
    }
}