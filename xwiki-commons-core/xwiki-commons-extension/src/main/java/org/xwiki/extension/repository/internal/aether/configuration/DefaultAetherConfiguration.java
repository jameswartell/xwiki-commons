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
package org.xwiki.extension.repository.internal.aether.configuration;

import java.io.File;

import org.xwiki.component.annotation.Component;
import org.xwiki.component.annotation.Requirement;
import org.xwiki.component.logging.AbstractLogEnabled;
import org.xwiki.configuration.ConfigurationSource;
import org.xwiki.extension.ExtensionManagerConfiguration;

@Component
public class DefaultAetherConfiguration extends AbstractLogEnabled implements AetherConfiguration
{
    @Requirement("xwikiproperties")
    private ConfigurationSource configurationSource;

    @Requirement
    private ExtensionManagerConfiguration extensionManagerConfiguration;

    public File getLocalRepository()
    {
        String localRepositoryPath = this.configurationSource.getProperty("extension.aether.localRepository");

        return localRepositoryPath != null ? new File(localRepositoryPath) : new File(this.extensionManagerConfiguration
            .getLocalRepository().getParent(), "aether-repository");
    }
}
