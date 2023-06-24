import java.io.*;
import java.util.ArrayList;

public class Arquivo {

    // Método que serve para escrever no Arquivo
    public void escrever(Pratos pratos){
        // Instanciando os objetos que permitirão a escrita de dados
        OutputStream os=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;


        try{
            // Abrindo a saída de dados
            os=new FileOutputStream("pratos.txt",true); // Nome do arquivo onde será salvo
            osw=new OutputStreamWriter(os);
            bw= new BufferedWriter(osw);

            // Flag que indica onde começa as informações do Prato
            bw.write("++ Prato ++\n");
            bw.write(pratos.getNomePrato()+"\n");
            bw.write(pratos.getPreco()+"\n");


        }catch(Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            // Fechando a entrada de dados
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Pratos> ler(){
        ArrayList<Pratos> pratossEncontrados = new ArrayList<>();
        // Classes que permitem leitura de dados do arquivo
        InputStream is=null;
        InputStreamReader isr=null;
        BufferedReader br=null;

        // Variável auxiliar que servirá de flag para o while
        String linhaLer;

        try{
            // Instanciando os objetos
            is=new FileInputStream("pratos.txt");
            isr=new InputStreamReader(is);
            br=new BufferedReader(isr);

            // Colocando o cursor no inicio do arquivo
            linhaLer=br.readLine();

            while(linhaLer!=null){
                // Comparando se o que está em linhaLer é igual a minha flag
                if(linhaLer.contains("++ PRATO ++")){
                    // Variável auxiliar de filme
                    Pratos pratosAux=new Pratos();

                    // Criando um objeto do tipo prato com as variáveis auxiliares
                    pratosAux.setNomePrato(br.readLine());
                    pratosAux.setPreco(Double.parseDouble(br.readLine()));

                    // Adicionando o prato no array de pratos
                    pratossEncontrados.add(pratosAux);
                }
                linhaLer=br.readLine();
            }


        }catch(Exception e){
            System.out.println("ERRO: "+e);
        }finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("ERRO: "+e);
            }
        }
        return pratossEncontrados;
    }
}
