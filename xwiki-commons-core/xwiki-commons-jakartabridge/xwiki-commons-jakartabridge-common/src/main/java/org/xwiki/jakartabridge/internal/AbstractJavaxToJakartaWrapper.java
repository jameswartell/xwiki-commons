/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.jakartabridge.internal;

import org.xwiki.jakartabridge.JavaxToJakartaWrapper;

/**
 * @param <T> the type of the wrapped object
 * @version $Id$
 * @since 17.0.0RC1
 */
public abstract class AbstractJavaxToJakartaWrapper<T> implements JavaxToJakartaWrapper<T>
{
    protected final T jakarta;

    /**
     * @param wrapped the wrapped object
     */
    protected AbstractJavaxToJakartaWrapper(T wrapped)
    {
        this.jakarta = wrapped;
    }

    @Override
    public T getJakarta()
    {
        return this.jakarta;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof JavaxToJakartaWrapper<?> otherWrapper) {
            return this.jakarta.equals(otherWrapper.getJakarta());
        }

        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        return this.jakarta.hashCode();
    }
}
