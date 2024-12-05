package br.com.alura.TabelaFipe.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import br.com.alura.TabelaFipe.model.Dados;
import br.com.alura.TabelaFipe.model.Modelos;
import br.com.alura.TabelaFipe.model.Veiculo;
import br.com.alura.TabelaFipe.services.ConsumoApi;
import br.com.alura.TabelaFipe.services.ConverteDados;

public class Principal {

    Scanner leitura = new Scanner(System.in);

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private final ConsumoApi consumo = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();

    public void exibeMenu() {
        var menu = """
                 *** OPÇÕES ***
                 Carro
                 Moto
                 Caminhão

                 Digite uma da opções para consultar:
                """;

        System.out.println(menu);
        var opcao = leitura.nextLine();
        String endereco;

        if (opcao.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";
        } else if (opcao.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);

        var marcas = conversor.obterLista(json, Dados.class);

        marcas.stream().sorted(Comparator.comparing(Dados::codigo)).forEach(System.out::println);

        System.out.println("Informe o código da marca para consulta: ");
        var codMarca = leitura.nextLine();

        endereco = endereco + "/" + codMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);

        System.out.println("\nModelos dessa marca: ");

        modeloLista.modelos().stream().sorted(Comparator.comparing(Dados::codigo)).forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do veículo a ser buscado: ");
        var nomeVeiculo = leitura.nextLine();

        List<Dados> veiculosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase())).collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        veiculosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo para buscar os valores de avaliação: ");
        var codigoModelo = leitura.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";

        json = consumo.obterDados(endereco);

        List<Dados> anosModelo = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anosModelo.size(); i++) {
            var enderecoAux = endereco + "/" + anosModelo.get(i).codigo();
            json = consumo.obterDados(enderecoAux);

            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);

            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veiculos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);
    }
}
