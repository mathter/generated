package tech.generated.common.dsl;

public class Test {
    public static void main(String[] args) {
        Dsl dsl = null;

        dsl
                .instanceBuilder((c) -> "Hi")
                .select(
                        dsl.strict(Strict.class).path("org/name")
                );
    }
}
