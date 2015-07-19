/*
 * Copyright 2012-2015 Red Hat Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package org.ovirt.engineextensions.aaa.ldap;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Properties;

public class Config {
    public static final String PACKAGE_NAME;
    public static final String PACKAGE_VERSION;
    public static final String PACKAGE_DISPLAY_NAME;
    public static final String PROFILES_DIR;

    static {
        try (
            InputStream is = Config.class.getResourceAsStream("config.properties");
            Reader reader = new InputStreamReader(is, Charset.forName("UTF-8"));
        ) {
            Properties p = new Properties();
            p.load(reader);
            PACKAGE_NAME = p.getProperty("config.package.name");
            PACKAGE_VERSION = p.getProperty("config.package.version");
            PACKAGE_DISPLAY_NAME = p.getProperty("config.package.displayName");
            PROFILES_DIR = p.getProperty("config.dir.profiles");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

// vim: expandtab tabstop=4 shiftwidth=4
