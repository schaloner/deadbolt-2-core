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
package be.objectify.deadbolt.core;

import be.objectify.deadbolt.core.models.Permission;
import be.objectify.deadbolt.core.models.Role;
import be.objectify.deadbolt.core.models.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This carries out static (i.e. non-dynamic) checks.
 *
 * @author Steve Chaloner (steve@objectify.be)
 */
public class DeadboltAnalyzer
{
    /**
     * Checks if the subject has all the role names.  In other words, this gives AND support.
     *
     * @param subject the subject
     * @param roleNames  the role names.  Any role name starting with ! will be negated.
     * @return true if the subject meets the restrictions (so access will be allowed), otherwise false
     */
    public static boolean checkRole(Subject subject,
                                    String[] roleNames)
    {
        boolean roleOk = true;
        if (!hasAllRoles(subject,
                         roleNames))
        {
            roleOk = false;
        }
        return roleOk;
    }


    /**
     * Gets the role name of each role held.
     *
     * @param subject the subject
     * @return a non-null list containing all role names
     */
    public static List<String> getRoleNames(Subject subject)
    {
        List<String> roleNames = new ArrayList<String>();

        if (subject != null)
        {
            List<? extends Role> roles = subject.getRoles();
            if (roles != null)
            {
                for (Role role : roles)
                {
                    roleNames.add(role.getName());
                }
            }
        }

        return roleNames;
    }

    /**
     * Check if the subject has the given role.
     *
     * @param subject the subject
     * @param roleName the name of the role
     * @return true iff the subject has the role represented by the role name
     */
    public static boolean hasRole(Subject subject,
                                  String roleName)
    {
        return getRoleNames(subject).contains(roleName);
    }

    /**
     * Check if the {@link Subject} has all the roles given in the roleNames array.  Note that while a Subject must
     * have all the roles, it may also have other roles.
     *
     * @param subject the subject
     * @param roleNames the names of the required roles
     * @return true iff the subject has all the roles
     */
    public static boolean hasAllRoles(Subject subject,
                                      String[] roleNames)
    {
        boolean hasRole = false;
        if (subject != null)
        {
            List<? extends Role> roles = subject.getRoles();

            if (roles != null)
            {
                List<String> heldRoles = getRoleNames(subject);

                boolean roleCheckResult = true;
                for (int i = 0; roleCheckResult && i < roleNames.length; i++)
                {
                    boolean invert = false;
                    String roleName = roleNames[i];
                    if (roleName.startsWith("!"))
                    {
                        invert = true;
                        roleName = roleName.substring(1);
                    }
                    roleCheckResult = heldRoles.contains(roleName);

                    if (invert)
                    {
                        roleCheckResult = !roleCheckResult;
                    }
                }
                hasRole = roleCheckResult;
            }
        }
        return hasRole;
    }

    /**
     *
     * @param subject
     * @param pattern
     * @return
     */
    public static boolean checkRegexPattern(Subject subject,
                                            Pattern pattern)
    {
        boolean roleOk = false;
        if (subject != null)
        {
            List<? extends Permission> permissions = subject.getPermissions();
            if (permissions != null)
            {
                for (Iterator<? extends Permission> iterator = permissions.iterator(); !roleOk && iterator.hasNext(); )
                {
                    Permission permission = iterator.next();
                    roleOk = pattern.matcher(permission.getValue()).matches();
                }
            }
        }

        return roleOk;
    }

    /**
     *
     * @param subject
     * @param patternValue
     * @return
     */
    public static boolean checkPatternEquality(Subject subject,
                                               String patternValue)
    {
        boolean roleOk = false;
        if (subject != null)
        {
            List<? extends Permission> permissions = subject.getPermissions();
            if (permissions != null)
            {
                for (Iterator<? extends Permission> iterator = permissions.iterator(); !roleOk && iterator.hasNext(); )
                {
                    Permission permission = iterator.next();
                    roleOk = patternValue.equals(permission.getValue());
                }
            }
        }

        return roleOk;
    }
}
