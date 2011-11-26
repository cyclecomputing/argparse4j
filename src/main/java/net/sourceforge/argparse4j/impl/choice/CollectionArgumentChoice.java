/*
 * Copyright (C) 2011 Tatsuhiro Tsujikawa
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS
 * BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN
 * ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.sourceforge.argparse4j.impl.choice;

import java.util.Arrays;
import java.util.Collection;

import net.sourceforge.argparse4j.helper.TextHelper;
import net.sourceforge.argparse4j.inf.ArgumentChoice;

/**
 * <p>
 * Choice from given collection of values.
 * </p>
 * <p>
 * {@link #contains(Object)} checks given {@code val} is contained in values
 * given in constructor argument.
 * </p>
 */
public class CollectionArgumentChoice implements ArgumentChoice {

    private Collection<?> values;

    /**
     * Initializes this object from given values.
     * 
     * @param values
     *            Valid values
     */
    public CollectionArgumentChoice(Object... values) {
        this.values = Arrays.asList(values);
    }

    /**
     * Initializes this object from given values.
     * 
     * @param values
     *            Valid values
     */
    public CollectionArgumentChoice(Collection<?> values) {
        this.values = values;
    }

    @Override
    public boolean contains(Object val) {
        return values.contains(val);
    }

    @Override
    public String textualFormat() {
        return TextHelper.concat(values, 0, ",", "{", "}");
    }

    @Override
    public String toString() {
        return textualFormat();
    }
}
