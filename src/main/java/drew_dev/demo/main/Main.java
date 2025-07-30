package drew_dev.demo.main;

import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);

    public void exhibitMenu(){
        var menu = """
                *** OPÇÕES***
                
                1 . Carro
                2 . Motocicleta
                3 . Caminhão
                
                *************
                """;
        System.out.println(menu);

        var choice = sc.nextLine();
        choice = choice.toLowerCase();

        String url;
        if (choice.contains("carr")){
            url = "/car";
        }else if(choice.contains("moto")){
            url = "/motorcycle";
        }else if(choice.contains("camin")){
            url = "/truck";
        }else{
            url = "/notfound";
        }
    }
}
