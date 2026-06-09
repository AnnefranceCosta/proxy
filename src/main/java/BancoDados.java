import java.util.HashMap;
import java.util.Map;

public class BancoDados {
    private static Map<Integer, Ingresso> ingressos = new HashMap<>();

    public static Ingresso getIngresso(Integer codigo) {
        return ingressos.get(codigo);
    }

    public static void addIngresso(Ingresso ingresso) {
        ingressos.put(ingresso.getCodigo(), ingresso);
    }
}
