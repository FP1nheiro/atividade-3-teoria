import java.util.ArrayList;
import java.util.List;

public class questao2 {

    public static List<String> gerarCadeiasDeComprimentoN(int n) {
        List<String> result = new ArrayList<>();
        gerarCadeias("", n, result);
        return result;
    }

    private static void gerarCadeias(String cadeiaAtual, int n, List<String> result) {
        if (cadeiaAtual.length() == n) {
            result.add(cadeiaAtual);
            return;
        }

        if (cadeiaAtual.isEmpty()) {
            gerarCadeias(cadeiaAtual + "a", n, result);
            gerarCadeias(cadeiaAtual + "b", n, result);
            gerarCadeias(cadeiaAtual + "c", n, result);
        } else if (cadeiaAtual.endsWith("a")) {
            gerarCadeias(cadeiaAtual + "a", n, result);
        } else if (cadeiaAtual.endsWith("b")) {
            gerarCadeias(cadeiaAtual + "b", n, result);
        }
    }

    public static void main(String[] args) {
        int comprimento = 3;
        List<String> cadeias = gerarCadeiasDeComprimentoN(comprimento);
        for (String cadeia : cadeias) {
            System.out.println(cadeia);
        }
    }
}
