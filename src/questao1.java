public class questao1 {

    public static boolean pertenceALinguagem(String cadeia) {
        if (cadeia.isEmpty()) return false;

        if (cadeia.charAt(0) == 'a') {
            return verificaA(cadeia, 1);
        } else if (cadeia.charAt(0) == 'b') {
            return verificaB(cadeia, 1);
        }
        return false;
    }

    private static boolean verificaA(String cadeia, int index) {
        while (index < cadeia.length()) {
            if (cadeia.charAt(index) != 'a') {
                return false;
            }
            index++;
        }
        return true;
    }

    private static boolean verificaB(String cadeia, int index) {
        while (index < cadeia.length()) {
            if (cadeia.charAt(index) != 'b') {
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(pertenceALinguagem("aaa")); // true
        System.out.println(pertenceALinguagem("b")); // true
        System.out.println(pertenceALinguagem("abba")); // false
    }
}
