package ru.xorsiphus.parser.forms;

import javax.validation.constraints.NotNull;

public class FilterAuthor
{
    @NotNull(message = "Поле не должно быть пустым")
    private String filter;

    public String getFilter()
    {
        return filter;
    }

    public void setFilter(String filter)
    {
        this.filter = filter;
    }
}
