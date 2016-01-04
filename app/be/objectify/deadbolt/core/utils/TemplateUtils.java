/*
 * Copyright 2012 Steve Chaloner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.objectify.deadbolt.core.utils;

import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Convenience methods for templates.
 *
 * @author Steve Chaloner
 */
public class TemplateUtils
{
    /**
     * Converts the roles into a String array.
     *
     * @param roles the roles
     * @return the roles as an array of strings
     */
    public static String[] roles(final Role... roles)
    {
        final List<String> names = new ArrayList<String>(roles.length);
        for (Role role : roles)
        {
            names.add(role.getName());
        }
        return names.toArray(new String[names.size()]);
    }

    /**
     * Converts the permissions into a String array.
     *
     * @param permissions the permissions
     * @return the permissions as an array of strings
     */
    public static String[] roles(final Permission... permissions)
    {
        final List<String> values = new ArrayList<String>(permissions.length);
        for (Permission permission : permissions)
        {
            values.add(permission.getValue());
        }
        return values.toArray(new String[values.size()]);
    }

    /**
     * Converts the arguments into a String array.
     *
     * @param args the arguments
     * @return the arguments as an array
     */
    public static String[] allOf(final String... args)
    {
        return args == null ? new String[0] : args;
    }

    /**
     * Converts the arguments into a String array.
     *
     * @param args the arguments
     * @return the arguments as an array
     * @deprecated  use {@link TemplateUtils#allOf} instead
     */
    @Deprecated
    public static String[] as(final String... args)
    {
        return allOf(args);
    }

    /**
     * Converts the argument array into a List of String arrays.
     *
     * @param args the arguments
     * @return a non-null list containing the arguments
     */
    public static List<String[]> anyOf(final String[]... args)
    {
        return Arrays.asList(args);
    }

    /**
     * Converts the argument array into a List of String arrays.
     *
     * @param args the arguments
     * @return a non-null list containing the arguments
     * @deprecated  use {@link TemplateUtils#anyOf} instead
     */
    public static List<String[]> la(final String[]... args)
    {
        return anyOf(args);
    }
}
