package com.designpattern.singleton;

import core.EstatisticasTurma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SingletonApplication {

    public static void main(String[] args) {

        //SpringApplication.run(SingletonApplication.class, args);
        EstatisticasTurma estatisticas = EstatisticasTurma.getInstance();
        EstatisticasTurma estatisticas2 = EstatisticasTurma.getInstance();

        System.out.println("Os objetos são iguais? " + estatisticas.equals(estatisticas2));

        estatisticas.addNotasTurma(List.of(7.0, 8.5, 9.0, 6.5, 10.0));
        System.out.println("Média das notas: " + estatisticas.getMediaNotas());
        System.out.println("Maior nota: " + estatisticas.getMaiorNota());
        System.out.println("Menor nota: " + estatisticas.getMinNota());

        System.out.println("Notas: " + estatisticas.getNotas());
    }

}
