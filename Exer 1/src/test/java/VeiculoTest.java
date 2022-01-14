import org.junit.*;

import static org.junit.Assert.assertEquals;

public class VeiculoTest {
    private Veiculo veiculo;

    @Before
    public void setup() {
        veiculo = new Veiculo(
            "Hyundai",
            "HB20",
            "GFT2022",
            "Branco",
            42000L,
                60000.0
        );
    }

    @Test
    public void veiculoCriadoDeveEstarDesligado() throws Exception {
        assertEquals(false, veiculo.getIsLigado());
    }

    @Test
    public void deveLigarCarro() throws Exception {
        veiculo.ligar();

        assertEquals(true, veiculo.getIsLigado());
    }

    @Test
    public void deveEstarParado() throws Exception {
        assertEquals(0, veiculo.getVelocidade());
    }

    @Test
    public void naoDeveAcelerarSeEstiverParado() throws Exception {
        veiculo.acelerar();

        assertEquals(false, veiculo.getIsLigado());
        assertEquals(0, veiculo.getVelocidade());
    }

    @Test
    public void deveAcelerar() throws Exception {
        veiculo.ligar()
               .acelerar();

        assertEquals(20, veiculo.getVelocidade());
    }

    @Test
    public void deveAbastecer() throws Exception {
        veiculo.abastecer(40);

        assertEquals(40, veiculo.getLitrosCombustivel());
    }

    @Test
    public void deveAbastecerSeguindoOLimiteMaximoDoTanque() throws Exception {
        veiculo.abastecer(70);

        assertEquals(60, veiculo.getLitrosCombustivel());
    }

    @Test
    public void deveFrear() throws Exception {
        veiculo.setVelocidade(60);

        veiculo.frear().frear();

        assertEquals(20, veiculo.getVelocidade());
    }

    @Test
    public void naoFrearSeEstiverParado() throws Exception {
        veiculo.setVelocidade(0);

        veiculo.frear();

        assertEquals(0, veiculo.getVelocidade());
    }

    @Test
    public void devePintarVeiculo() throws Exception {
        veiculo.pintar("Prata");

        assertEquals("Prata", veiculo.getCor());
    }

    @Test
    public void deveDesligar() throws Exception {
        veiculo.setIsLigado(true);

        veiculo.desligar();

        assertEquals(false, veiculo.getIsLigado());
    }

    @Test
    public void naoDeveDesligarEmMovimento() throws Exception {
        veiculo.ligar()
                .acelerar()
                .desligar();

        assertEquals(true, veiculo.getIsLigado());
    }
}
