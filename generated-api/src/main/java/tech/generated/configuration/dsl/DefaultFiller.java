package tech.generated.configuration.dsl;

public interface DefaultFiller extends Selectable {

    public <T extends DefaultFiller> T including(String... field);

    public <T extends DefaultFiller> T excluding(String... field);
}
