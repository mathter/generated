package tech.generated.configuration.dsl;

import tech.generated.GeneratedException;

public class SuchSelectableAlredyExistsException extends GeneratedException {

    private final Selectable selectable;

    public SuchSelectableAlredyExistsException(Selectable selectable) {
        super("Selectable '" + selectable + "' with name '" + selectable.name() + "' already exists in configuration!");
        this.selectable = selectable;
    }

    public Selectable getSelectable() {
        return this.selectable;
    }
}
