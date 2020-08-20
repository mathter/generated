package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;
import tech.generated.common.GeneratedEngine;
import tech.generated.common.path.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

abstract class ComplexContext<T> extends ValueContext<T> {

    private List<ValueContext<?>> members = new ArrayList<>();

    protected ComplexContext(Bindings parentBindings, GeneratedEngine generatedEngine) {
        super(parentBindings, generatedEngine);
    }

    protected ComplexContext(Context<?> parent) {
        super(parent);
    }

    void addMember(ValueContext<?> memberContext) {
        this.members.add(memberContext);
    }

    void removeMember(ValueContext<?> memberContext) {
        this.members.remove(memberContext);
    }

    Stream<ValueContext<?>> members() {
        return this.members.stream();
    }

    @Override
    public Stream<Path<?, ?>> child() {
        return this.members.stream().map(memberContext -> memberContext);
    }
}
