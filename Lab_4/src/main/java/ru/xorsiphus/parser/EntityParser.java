package ru.xorsiphus.parser;

import ru.xorsiphus.entity.*;

public class EntityParser
{
    public static IEntity parseEntity(String s) throws NumberFormatException
    {
        return switch (s)
                {
                    case "Cinemas" -> new Cinemas();
                    case "Companies" -> new Companies();
                    case "Movies" -> new Movies();
                    case "Personal" -> new Personal();
                    case "Tickets" -> new Tickets();
                    default -> throw new NumberFormatException();
                };
    }
}
