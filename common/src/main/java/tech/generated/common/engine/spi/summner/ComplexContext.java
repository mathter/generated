package tech.generated.common.engine.spi.summner;

import tech.generated.common.Bindings;
import tech.generated.common.Context;
import tech.generated.common.path.Path;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

abstract class ComplexContext<T, P> extends ValueContext<T, P> {

    private List<ValueContext<?, T>> members = new ArrayList<>();

    protected ComplexContext(Bindings parentBindings) {
        super(parentBindings);
    }

    protected ComplexContext(Context<P> parent) {
        super(parent);
    }

    void addMember(ValueContext<?, T> memberContext) {
        this.members.add(memberContext);
    }

    void removeMember(ValueContext<?, T> memberContext) {
        this.members.remove(memberContext);
    }

    Stream<ValueContext<?, T>> members() {
        return this.members.stream();
    }

    @Override
    public Stream<Path<?, ?>> child() {
        return this.members.stream().map(memberContext -> memberContext);
    }
}
