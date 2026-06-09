import java.util.List;

public class IngressoProxy implements IIngresso{
    private Ingresso ingressoReal;
    private Integer codigo;

    public IngressoProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosGerais() {
        if (this.ingressoReal == null) {
            this.ingressoReal = new Ingresso(this.codigo);
        }
        return this.ingressoReal.obterDadosGerais();
    }

    @Override
    public List<String> obterDadosFaturamento(Utilizador utilizador) {
        if (!utilizador.isAdministrador()) {
            throw new IllegalArgumentException("Utilizador não autorizado para ver dados de faturamento");
        }

        if (this.ingressoReal == null) {
            this.ingressoReal = new Ingresso(this.codigo);
        }
        return this.ingressoReal.obterDadosFaturamento(utilizador);
    }
}
