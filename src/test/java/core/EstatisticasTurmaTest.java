package core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstatisticasTurmaTest {

    List<Double> notas;

    @BeforeEach
    void setUp() {
        this.notas = List.of(7.0, 8.5, 9.0, 6.5, 10.0);
    }

    @Test
    @DisplayName("Deve retornar a mesma instância da classe EstatisticasTurma, isto é, objetos compartilhados conforme prevê o singleton")
    void getInstance() {
        EstatisticasTurma instancia1 = EstatisticasTurma.getInstance();
        EstatisticasTurma instancia2 = EstatisticasTurma.getInstance();

        assertEquals(instancia1, instancia2);
    }

    @Test
    @DisplayName("Deve adicionar as notas da turma e retornar true")
    void addNotasTurma() {
        assertTrue(EstatisticasTurma.getInstance().addNotasTurma(this.notas));
    }

    @Test
    @DisplayName("Deve calcular a média das notas da turma e retornar o valor esperado")
    void getMediaNotas() {
        Double expected = 8.2;
        EstatisticasTurma.getInstance().addNotasTurma(this.notas);

        assertEquals(expected, EstatisticasTurma.getInstance().getMediaNotas());
    }

    @Test
    @DisplayName("Deve calcular a maior nota da turma e retornar o valor esperado")
    void getMaiorNota() {
        Double expected = 10.0;
        EstatisticasTurma.getInstance().addNotasTurma(this.notas);

        assertEquals(expected, EstatisticasTurma.getInstance().getMaiorNota());
    }

    @Test
    @DisplayName("Deve calcular a menor nota da turma e retornar o valor esperado")
    void getMinNota() {
        Double expected = 6.5;
        EstatisticasTurma.getInstance().addNotasTurma(this.notas);

        assertEquals(expected, EstatisticasTurma.getInstance().getMinNota());
    }

    @Test
    @DisplayName("Deve retornar a lista de notas da turma")
    void getNotas() {
        EstatisticasTurma.getInstance().addNotasTurma(this.notas);

        assertEquals(this.notas, EstatisticasTurma.getInstance().getNotas());
    }

    @AfterEach
    void tearDown() {
        EstatisticasTurma.getInstance().getNotas().clear();
    }
}