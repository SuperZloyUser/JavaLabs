package ru.xorsiphus.parser.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FilterAuthor
{
    @NotNull(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Некорректная длина имени автора")
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
