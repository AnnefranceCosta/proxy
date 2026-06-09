import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class IngressoProxyTest {
    @BeforeEach
    public void setUp() {
        BancoDados.addIngresso(new Ingresso(1, "Rock in Rio", "Pista Premium", "123.456.789-00", "500.00"));
        BancoDados.addIngresso(new Ingresso(2, "Tomorrowland", "Vip Lounge", "987.654.321-11", "1200.00"));
    }

    @Test
    public void deveRetornarDadosGeraisIngresso() {
        IngressoProxy ingresso = new IngressoProxy(1);

        assertEquals(Arrays.asList("Rock in Rio", "Pista Premium"), ingresso.obterDadosGerais());
    }

    @Test
    public void deveRetornarDadosFaturamentoIngresso() {
        Utilizador utilizador = new Utilizador("Ana", true);
        IngressoProxy ingresso = new IngressoProxy(2);

        assertEquals(Arrays.asList("987.654.321-11", "1200.00"), ingresso.obterDadosFaturamento(utilizador));
    }

    @Test
    public void deveRetornarExcecaoUsuarioNaoAutorizadoConsultarFaturamento() {
        try {
            Utilizador utilizador = new Utilizador("Joana", false);
            IngressoProxy ingresso = new IngressoProxy(2);

            ingresso.obterDadosFaturamento(utilizador);
            fail("Deveria ter lançado IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            assertEquals("Utilizador não autorizado para ver dados de faturamento", e.getMessage());
        }
    }
}
