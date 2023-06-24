public class Lagosta extends Pratos{
    private String Adicional;
    private String  ModoDeServir;

    // Métodos reescritos da classe mãe (Pratos) - Polimorfismo
    public void mostraInfo(){
        System.out.println("-- INFORMAÇÕES DOS ADICIONAIS E MODO DE SERVIR--");
        // Agora adicionamos as particularidades do prato
        System.out.println("Adicional: "+this.Adicional);
        System.out.println("Modo de Servir : "+this.ModoDeServir);
    }

    public String getAdicional() {
        return Adicional;
    }

    public void setAdicional(String adicional) {
        Adicional = adicional;
    }

    public String getModoDeServir() {
        return ModoDeServir;
    }

    public void setModoDeServir(String modoDeServir) {
        ModoDeServir = modoDeServir;
    }
}
