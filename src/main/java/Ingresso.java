import java.util.Arrays;
import java.util.List;

public class Ingresso implements IIngresso{
    private Integer codigo;
    private String evento;
    private String setor;
    private String cpfComprador;
    private String valorPago;

    public Ingresso(int codigo) {
        this.codigo = codigo;
        Ingresso objetoReal = BancoDados.getIngresso(codigo);

        if (objetoReal != null) {
            this.evento = objetoReal.evento;
            this.setor = objetoReal.setor;
            this.cpfComprador = objetoReal.cpfComprador;
            this.valorPago = objetoReal.valorPago;
        }
    }

    public Ingresso(Integer codigo, String evento, String setor, String cpfComprador, String valorPago) {
        this.codigo = codigo;
        this.evento = evento;
        this.setor = setor;
        this.cpfComprador = cpfComprador;
        this.valorPago = valorPago;
    }

    public Integer getCodigo() {
        return codigo;
    }

    @Override
    public List<String> obterDadosGerais() {
        return Arrays.asList(this.evento, this.setor);
    }

    @Override
    public List<String> obterDadosFaturamento(Utilizador utilizador) {
        return Arrays.asList(this.cpfComprador, this.valorPago);
    }
}
