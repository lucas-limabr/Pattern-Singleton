package core;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class EstatisticasTurma {

    private static EstatisticasTurma estatisticasTurma;

    private static DoubleSummaryStatistics estatisticas;
    private static final List<Double> notas = new ArrayList<>();

    private EstatisticasTurma() {

    }

    public static EstatisticasTurma getInstance() {
        if (estatisticasTurma == null) {
            estatisticasTurma = new EstatisticasTurma();
        }

        return estatisticasTurma;
    }

    public boolean addNotasTurma(List<Double> notas) {
        estatisticas = notas.stream().mapToDouble(Double::doubleValue).summaryStatistics();
        return EstatisticasTurma.notas.addAll(notas);
    }

    public Double getMediaNotas() {
        return estatisticas.getAverage();
    }

    public Double getMaiorNota() {
        return estatisticas.getMax();
    }

    public Double getMinNota() {
        return estatisticas.getMin();
    }

    public List<Double> getNotas() {
        return notas;
    }
}
