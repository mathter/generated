/*
 * Generated - testing becomes easier
 *
 * Copyright (C) 2020 mathter@mail.ru
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
package tech.generated.loly;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import tech.generated.configuration.dsl.Path;

import java.util.regex.Pattern;

final class PathSelectorBuilder {
    public static Selector build(tech.generated.configuration.dsl.Selector path, Selector next) {
        final CharStream stream = CharStreams.fromString(((Path) path).path());
        final PathLexer lexer = new PathLexer(stream);
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final PathParser parser = new PathParser(tokenStream);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final Listener listener = new Listener(path.name(), path.metrics(), next);

        walker.walk(listener, parser.path());

        return listener.last;
    }

    private PathSelectorBuilder() {
    }

    private static class Listener extends PathBaseListener {
        private static final int UNDEFINED = -1;

        private final String name;

        private final Integer metrics;

        private int index = 0;

        private int skipCount = UNDEFINED;

        private Selector last;

        public Listener(String name, Integer metrics, Selector next) {
            this.name = name;
            this.metrics = metrics;
            this.last = next;
        }

        @Override
        public void enterRoot(PathParser.RootContext ctx) {
            this.last = new RootMatchSelector(
                    this.name,
                    this.metrics != null ? this.metrics : Constants.METRICS_UNIT,
                    this.last
            );
        }

        @Override
        public void enterName(PathParser.NameContext ctx) {
            this.last = new NameEqualsSelector(
                    this.name + (index++),
                    this.metrics != null ? 0 : Constants.METRICS_UNIT,
                    this.last,
                    ctx.getText()
            );
        }

        @Override
        public void enterMatchedName(PathParser.MatchedNameContext ctx) {
            this.last = new MatchedNameSelector(
                    this.name + (index++),
                    this.metrics != null ? 0 : Constants.METRICS_UNIT,
                    this.last,
                    Pattern.compile(ctx.getText().replace("*", ".*"))
            );
        }

        @Override
        public void enterSkip(PathParser.SkipContext ctx) {
            this.skipCount = 0;
        }

        @Override
        public void exitSkip(PathParser.SkipContext ctx) {
            this.last = new SkipSelector(
                    this.name + (index++),
                    this.metrics != null ? 0 : Constants.METRICS_UNIT,
                    this.last,
                    this.skipCount
            );

            this.skipCount = -1;
        }

        @Override
        public void exitSkipElememt(PathParser.SkipElememtContext ctx) {
            if (this.skipCount < 0) {
                throw new IllegalStateException("skipCount not initialized!");
            }

            this.skipCount += ctx.SKIP_NAME_COUNT() != null ? Integer.parseInt(ctx.SKIP_NAME_COUNT().getText()) : 1;
        }

        @Override
        public void visitErrorNode(ErrorNode node) {
            throw new RuntimeException("Unexpected string: '" + node.getText() + "'");
        }
    }
}
