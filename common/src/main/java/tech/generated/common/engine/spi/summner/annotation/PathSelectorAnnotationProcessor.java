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
package tech.generated.common.engine.spi.summner.annotation;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tech.generated.common.Constants;
import tech.generated.common.Context;
import tech.generated.common.annotation.Path;
import tech.generated.common.engine.spi.summner.NameGenerator;
import tech.generated.common.engine.spi.summner.selector.MatchedNameSelector;
import tech.generated.common.engine.spi.summner.selector.NameEqualsSelector;
import tech.generated.common.engine.spi.summner.selector.RootMatchSelector;
import tech.generated.common.engine.spi.summner.selector.SkipNameSelector;
import tech.generated.common.path.Selector;
import tech.generated.common.pc.path.parser.PathBaseListener;
import tech.generated.common.pc.path.parser.PathLexer;
import tech.generated.common.pc.path.parser.PathParser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Deque;
import java.util.LinkedList;

public class PathSelectorAnnotationProcessor extends SelectorAnnotationProcessor {

    @Override
    public Object process(AnnotationBasedConfigurationFactory factory, Object configuration, Method method, Annotation annotation) {
        final Path pathAnnotation = (Path) annotation;
        final CharStream stream = CharStreams.fromString(pathAnnotation.value());
        final PathLexer lexer = new PathLexer(stream);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final PathParser parser = new PathParser(tokenStream);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final Listener listener = new Listener(
                pathAnnotation.name().isEmpty() ? NameGenerator.nextName() : pathAnnotation.name(),
                pathAnnotation.metrics()
        );

        walker.walk(listener, parser.path());

        return listener.result;
    }

    @Override
    public long metrics() {
        return 10;
    }

    @Override
    public Class<? extends Annotation> annotationClass() {
        return Path.class;
    }

    private static class Listener extends PathBaseListener {

        private final String name;

        private final long metrics;

        final Deque<Object> stack = new LinkedList();

        Selector<Context<?>> result;

        private Listener(String name, long metrics) {
            this.name = name;
            this.metrics = metrics;
        }

        private long build(long def) {
            final long metrics;

            if (this.metrics == 0) {
                metrics = def;
            } else {
                if (this.result == null) {
                    metrics = this.metrics;
                } else {
                    metrics = 0L;
                }
            }

            return metrics;
        }

        @Override
        public void enterRoot(PathParser.RootContext ctx) {
            this.result = new RootMatchSelector(this.name, this.result, this.build(Constants.METRICS_UNIT));
        }

//        @Override
//        public void exitPath(PathParser.PathContext ctx) {
//            this.result = new RoutingSelector(this.name, null, this.build(Constants.METRICS_UNIT), this.result);
//        }

        @Override
        public void enterName(PathParser.NameContext ctx) {
            this.result = new NameEqualsSelector(this.name, this.result, this.build(Constants.METRICS_UNIT), ctx.getText());
        }

        @Override
        public void enterMatchedName(PathParser.MatchedNameContext ctx) {
            this.result = new MatchedNameSelector(this.name, this.result, this.build(Constants.METRICS_UNIT), ctx.getText());
        }

        @Override
        public void enterSkip(PathParser.SkipContext ctx) {
            this.stack.push(0);
        }

        @Override
        public void exitSkip(PathParser.SkipContext ctx) {
            int count = (int) this.stack.pop();
            this.result = new SkipNameSelector(this.name, this.result, this.build(count), count);
        }

        @Override
        public void enterSkipElememt(PathParser.SkipElememtContext ctx) {
            int count = (int) this.stack.pop();
            count += ctx.SKIP_NAME_COUNT() != null ? Integer.parseInt(ctx.SKIP_NAME_COUNT().getText()) : 1;

            this.stack.push(count);
        }

        @Override
        public void visitErrorNode(ErrorNode node) {
            throw new RuntimeException("Unexpected string: '" + node.getText() + "'");
        }
    }
}
