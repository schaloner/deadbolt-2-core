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

/**
 * @author Steve Chaloner (steve@objectify.be)
 */
public class PluginConfigKeys
{
    public static final String DEADBOLT_JAVA_HANDLER_KEY = "deadbolt.java.handler";

    public static final String CACHE_DEADBOLT_USER = "deadbolt.java.cache-user";

    public static final String BEFORE_AUTH_CHECK_TIMEOUT = "deadbolt.before-auth-check-timeout";

    public static final String GET_SUBJECT_TIMEOUT = "deadbolt.get-subject-timeout";

    private PluginConfigKeys()
    {
        // no-op
    }
}
