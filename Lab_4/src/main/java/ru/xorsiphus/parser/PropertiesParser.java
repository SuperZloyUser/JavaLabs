package ru.xorsiphus.parser;

import java.io.*;
import java.util.function.Function;

public class PropertiesParser<T>
{
    private final BufferedReader reader;
    private String message = "";
    private Function<String, T> parser = (s -> (T) s);
    private Function<T, Boolean> checker = (obj -> true);

    public PropertiesParser()
    {
        this(new FileInputStream(FileDescriptor.in));
    }

    public PropertiesParser(InputStream in)
    {
        this(new BufferedReader(new InputStreamReader(in)));
    }

    public PropertiesParser(BufferedReader reader)
    {
        this.reader = reader;
    }

    public PropertiesParser<T> hasMessage(String message)
    {
        this.message = message;
        return this;
    }

    public PropertiesParser<T> hasParser(Function<String, T> parser)
    {
        this.parser = parser;
        return this;
    }

    public PropertiesParser<T> hasChecker(Function<T, Boolean> checker)
    {
        this.checker = checker;
        return this;
    }

    public T readCycle()
    {
        while (true)
        {
            System.out.print(message);
            try
            {
                var parsed = parser.apply(reader.readLine());
                if (!checker.apply(parsed))
                {
                    throw new Exception("Не в промежутке или пустая строка");
                }
                return parsed;
            } catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
    }
}
