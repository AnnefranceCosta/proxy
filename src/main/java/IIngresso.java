import java.util.List;

public interface IIngresso {
    List<String> obterDadosGerais();
    List<String> obterDadosFaturamento(Utilizador utilizador);
}
