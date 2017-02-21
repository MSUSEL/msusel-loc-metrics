/**
 * The MIT License (MIT)
 *
 * SparQLine Lines of Code Metrics
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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
package com.sparqline.metrics.loc.internal;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparqline.metrics.loc.LoCProfile;

/**
 * Generates a JSON document containing the default LOC Profiles for several
 * languages.
 * 
 * @author Isaac Griffith
 * @version 1.1.0
 */
public class GenerateDefault {

    /**
     * Main method allows execution from the command line.
     * 
     * @param args
     *            Command line arguments
     */
    public static void main(String args[])
    {
        List<LoCProfile> profiles = Lists.newArrayList();

        // Java
        LoCProfile java = new LoCProfile.Builder("Java").extension("java")
                .language("Java")
                .lineComment("//")
                .blockComment("/*", "*/")
                .build();
        profiles.add(java);

        // C#
        LoCProfile csharp = new LoCProfile.Builder("C#").extension("cs")
                .language("C#")
                .lineComment("//")
                .blockComment("/*", "*/")
                .build();
        profiles.add(csharp);

        // Bourne Shell
        LoCProfile bourne = new LoCProfile.Builder("Bourne Shell").extension("sh")
                .language("Bourne Shell")
                .lineComment("#")
                .commentException("#!")
                .build();
        profiles.add(bourne);

        // Ruby
        LoCProfile ruby = new LoCProfile.Builder("Ruby").extension("rb").language("ruby").lineComment("#").build();
        profiles.add(ruby);

        // C
        LoCProfile c = new LoCProfile.Builder("C").extension("c")
                .language("C")
                .lineComment("//")
                .blockComment("/*", "*/")
                .build();
        profiles.add(c);

        // C++
        LoCProfile cpp = new LoCProfile.Builder("C++").extension("cpp")
                .extension("cc")
                .language("cpp")
                .lineComment("//")
                .blockComment("/*", "*/")
                .build();
        profiles.add(cpp);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(profiles);

        Path p = Paths.get("default.json");
        try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(p, StandardOpenOption.CREATE, StandardOpenOption.WRITE)))
        {
            pw.println(json);
        }
        catch (IOException e)
        {

        }

    }
}
