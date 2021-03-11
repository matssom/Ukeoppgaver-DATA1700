package com.example.demo.rekursjon.service;

import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    /**
     * Statisk metode her er et bevisst valg ettersom fac() ikke behøver å
     * kommunisere med andre metoder og/eller objeter
     * @param number talet som skal beregnes fakultetet til
     * @return resultat med rekursjon
     */
    public static long fac(int number){
        if (number == 1){
            return 1;
        }
        return number * fac(number-1);
    }
}
