/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
