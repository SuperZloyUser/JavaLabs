package ru.xorsiphus.parser.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Id
{
    @NotNull(message = "Поле не должно быть пустым")
    @PositiveOrZero(message = "Должно быть не отрицательным")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
