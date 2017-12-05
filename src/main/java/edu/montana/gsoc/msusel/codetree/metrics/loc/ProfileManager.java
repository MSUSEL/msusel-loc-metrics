/**
 * The MIT License (MIT)
 *
 * MSUSEL Lines of Code Metrics
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.codetree.metrics.loc;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Class to manage the use of LoCProfiles including the loading and selection of
 * profile.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProfileManager {

    /**
     * Map of known profiles where the served extensions are the key
     */
    private Map<String, LoCProfile> profileByExtension;
    /**
     * Map of known profiles where the served language is the key
     */
    private Map<String, LoCProfile> profileByLanguage;

    /**
     * Constructs a new empty ProfileManager
     */
    public ProfileManager()
    {
        profileByExtension = Maps.newHashMap();
        profileByLanguage = Maps.newHashMap();
    }

    /**
     * Adds the given profile to this profile manager
     * 
     * @param profile
     *            Profile to add
     */
    public void addProfile(LoCProfile profile)
    {
        for (String ext : profile.getExtensions())
        {
            profileByExtension.put(ext.toLowerCase(), profile);
        }

        profileByLanguage.put(profile.getLanguage().toLowerCase(), profile);
    }

    /**
     * Requests a profile for a given file extension (excluding the dot)
     * 
     * @param ext
     *            File extension
     * @return The profile registered to the provided extension.
     * @throws UnknownProfileException
     *             When the provided extension has no registered profile
     * @throws IllegalArgumentException
     *             When the provided extension is null or empty
     */
    public LoCProfile getProfileByExtension(String ext) throws UnknownProfileException
    {
        if (ext == null || ext.isEmpty())
            throw new IllegalArgumentException("Extension cannot be null or empty");
        if (!profileByExtension.containsKey(ext))
            throw new UnknownProfileException("No known LoC profile for extension " + ext);

        return profileByExtension.get(ext.toLowerCase());
    }

    /**
     * Requests a profile for a given language
     * 
     * @param lang
     *            Language name
     * @return The profile registered to the provided language
     * @throws UnknownProfileException
     *             When the provided language has no registered profile.
     * @throws IllegalArgumentException
     *             When the provided extension is null or empty
     */
    public LoCProfile getProfileByLanguage(String lang) throws UnknownProfileException
    {
        if (lang == null || lang.isEmpty())
            throw new IllegalArgumentException("Language cannot be null or empty");
        if (!profileByExtension.containsKey(lang))
            throw new UnknownProfileException("No known LoC profile for language " + lang);

        return profileByLanguage.get(lang.toLowerCase());
    }

    /**
     * Loads the default profiles from the JAR file
     */
    public void loadProfiles()
    {
        InputStream is = ProfileManager.class.getResourceAsStream("/com/sparqline/metrics/loc/profiles/default.json");

        Gson gson = new Gson();
        Type list = new TypeToken<List<LoCProfile>>() {
        }.getType();
        List<LoCProfile> profiles = gson.fromJson(gson.newJsonReader(new InputStreamReader(is)), list);

        for (LoCProfile profile : profiles)
        {
            this.addProfile(profile);
        }
    }
}
