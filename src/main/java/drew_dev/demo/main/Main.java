package drew_dev.demo.main;

import drew_dev.demo.models.BrandsData;
import drew_dev.demo.models.Models;
import drew_dev.demo.services.ApiConsumerService;
import drew_dev.demo.services.DataConverterService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public Scanner sc = new Scanner(System.in);
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private  ApiConsumerService apiConsumerService = new ApiConsumerService();
    private DataConverterService dataConverterService = new DataConverterService();
    public void exhibitMenu(){
        var menu = """
                *** OPÇÕES***
                
                1 . Carro
                2 . Motocicleta
                3 . Caminhão
                
                *************
                Digite a opção: 
                """;
        System.out.println(menu);

        var choice = sc.nextLine();
        choice = choice.toLowerCase();

        String url;
        if (choice.contains("carr")){
            url =BASE_URL+ "carros/marcas";
        }else if(choice.contains("moto")){
            url = BASE_URL+"motos/marcas";
        }else if(choice.contains("camin")){
            url = BASE_URL+"caminhoes/marcas";
        }else{
            url = null;
        }

        var json = apiConsumerService.fetchData(url);
        System.out.println(json);
        var marcas = dataConverterService.getList(json, BrandsData.class);
        marcas.stream()
                .sorted(Comparator.comparing(BrandsData::code))
                .forEach(System.out::println);

        System.out.println("Selecione um codigo para marcas: ");
        var codigoMarca = sc.nextLine();

        url = url + "/" + codigoMarca +"/modelos";
        json = apiConsumerService.fetchData(url);

        var modelList = dataConverterService.getData(json, Models.class);

        modelList.modelos().stream()
                .sorted(Comparator.comparing(BrandsData::code))
                .forEach(System.out::println);


        System.out.println("\n Digite o nome do carro a ser buscado: ");

        var nomeVeiculo = sc.nextLine();

        List<BrandsData> modelosFiltrados = modelList.modelos().stream()
                .filter( n -> n.name().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("Modelos filtrados: ");
        modelosFiltrados.stream().forEach(System.out::println);
        System.out.println("Digite código de modelo para buscar avaliação: ");
        var codigoModelo = sc.nextLine();

        url = url + "/"+ codigoModelo +"/anos";
        json = apiConsumerService.fetchData(url);

        List<BrandsData> anos = dataConverterService.getList(json, BrandsData.class);

        List<Vehicle> veiculos = new ArrayList<>();

        for(int i =0; i < anos.size(); i++){
            var urlAnos = url + "/" + anos.get(i).code();
            json = apiConsumerService.fetchData(urlAnos);
            Vehicle veiculo = dataConverterService.getData(json, Vehicle.class);
            veiculos.add(veiculo);
        }
        System.out.println("\n Todos os veículos filtrados com os valores por ano: ");

        veiculos.forEach(System.out::println);









    }
}
