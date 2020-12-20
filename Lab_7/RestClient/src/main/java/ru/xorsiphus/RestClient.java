package ru.xorsiphus;

import org.springframework.web.client.RestTemplate;

public class RestClient
{
    // Входные аргументы определяют параметры запроса:
    // * Цифра = id сущности
    // * Пустой = все сущности
    public static void main( String[] args )
    {
        var param = "0";
        if (args.length != 0)
            param = args[0];
        String ret = retrieve(Integer.parseInt(param));
        System.out.println(ret);
    }

    public static String retrieve(int id)
    {
        if (id == 0)
            return new RestTemplate().getForObject(
                    "http://localhost:8081/books",
                    String.class);
        else
            return new RestTemplate().getForObject(
                "http://localhost:8081/books/{id}",
                String.class, id);
    }
}
