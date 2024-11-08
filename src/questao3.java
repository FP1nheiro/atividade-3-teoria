import java.util.*;

public class questao3 {

    public static boolean verificaCadeia(Map<String, List<String>> gramatica, String cadeia) {
        return verificaRecursivamente(gramatica, "S", cadeia, 0);
    }

    private static boolean verificaRecursivamente(Map<String, List<String>> gramatica, String simbolo, String cadeia, int index) {
        if (index == cadeia.length() && simbolo.equals("ε")) {
            return true;
        }
        if (index >= cadeia.length()) {
            return false;
        }

        List<String> producoes = gramatica.getOrDefault(simbolo, new ArrayList<>());

        for (String producao : producoes) {
            if (producao.equals("ε")) {
                if (verificaRecursivamente(gramatica, "ε", cadeia, index)) {
                    return true;
                }
            } else {
                int i = 0;
                int j = index;
                while (i < producao.length() && j < cadeia.length() && producao.charAt(i) == cadeia.charAt(j)) {
                    i++;
                    j++;
                }
                if (i == producao.length()) {
                    if (verificaRecursivamente(gramatica, "ε", cadeia, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Map<String, List<String>> gramatica = new HashMap<>();
        gramatica.put("S", Arrays.asList("aA", "bB"));
        gramatica.put("A", Arrays.asList("aA", "ε"));
        gramatica.put("B", Arrays.asList("bB", "ε"));

        String cadeia = "aaa";
        System.out.println(verificaCadeia(gramatica, cadeia)); // true
    }
}
