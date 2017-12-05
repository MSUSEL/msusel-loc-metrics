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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.Lists;

/**
 * Class used to configure the LoCCounter for a given language.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class LoCProfile {

    /**
     * Name of the profile
     */
    private String       name;
    /**
     * Name of the language associated with this profile
     */
    private String       language;
    /**
     * List of file extensions associated with this profile
     */
    private List<String> extensions;
    /**
     * String indicating the start of a single line comment
     */
    private String       lineCommentStart;
    /**
     * String indicating the start of a multi-line, or block, comment
     */
    private String       blockCommentStart;
    /**
     * String indicating the end of a multi-line, or block, comment
     */
    private String       blockCommentEnd;
    /**
     * Exceptions to comment start rules
     */
    private List<String> commentStartExceptions;

    /**
     * Constructs a new LoCProfile with the given name
     * 
     * @param name
     *            Profile Name
     */
    private LoCProfile(String name)
    {
        this.name = name;
        extensions = Lists.newArrayList();
        commentStartExceptions = Lists.newArrayList();
    }

    /**
     * @return Profile name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return Profile language
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * @param language
     *            the new profile language
     */
    private void setLanguage(String language)
    {
        this.language = language;
    }

    /**
     * @return List of profile file extensions
     */
    public List<String> getExtensions()
    {
        return extensions;
    }

    /**
     * @param extension
     *            the extension to add
     */
    private void addExtension(String extension)
    {
        if (extension == null || extension.isEmpty())
            throw new IllegalArgumentException("Extension cannot be null or empty");
        if (extensions.contains(extension))
            return;

        this.extensions.add(extension);
    }

    /**
     * @return the lineCommentStart delimiter
     */
    public String getLineCommentStart()
    {
        return lineCommentStart;
    }

    /**
     * @param lineCommentStart
     *            the lineCommentStart delimiter to set
     */
    private void setLineCommentStart(String lineCommentStart)
    {
        this.lineCommentStart = lineCommentStart;
    }

    /**
     * @return the blockCommentStart delimiter
     */
    public String getBlockCommentStart()
    {
        return blockCommentStart;
    }

    /**
     * @param blockCommentStart
     *            the blockCommentStart delimiter to set
     */
    private void setBlockCommentStart(String blockCommentStart)
    {
        this.blockCommentStart = blockCommentStart;
    }

    /**
     * @return the blockCommentEnd delimiter
     */
    public String getBlockCommentEnd()
    {
        return blockCommentEnd;
    }

    /**
     * @param blockCommentEnd
     *            the blockCommentEnd delimiter to set
     */
    private void setBlockCommentEnd(String blockCommentEnd)
    {
        this.blockCommentEnd = blockCommentEnd;
    }

    /**
     * @return the List of comment start exceptions
     */
    public List<String> getCommentStartExceptions()
    {
        return commentStartExceptions;
    }

    /**
     * @param exception
     *            the comment start exceptions to add
     */
    private void addCommentStartException(String exception)
    {
        if (exception == null || exception.isEmpty())
            throw new IllegalArgumentException("Exception cannot be null or empty");
        if (commentStartExceptions.contains(exception))
            return;

        this.commentStartExceptions.add(exception);
    }

    /**
     * @author Isaac Griffith
     * @version 1.1.0
     */
    public static class Builder {

        /**
         * The profile to construct
         */
        private LoCProfile profile;

        /**
         * Constructs a new Builder for the LoCProfile with the given name
         * 
         * @param name
         *            Name of the new Profile
         */
        public Builder(String name)
        {
            profile = new LoCProfile(name);
        }

        /**
         * Sets the language of the profile.
         * 
         * @param language
         *            Name of the language.
         * @return this
         */
        @NonNull
        public Builder language(String language)
        {
            profile.setLanguage(language);

            return this;
        }

        /**
         * Adds a file extension to the profile under construction
         * 
         * @param extension
         *            File extension
         * @return this
         */
        @NonNull
        public Builder extension(String extension)
        {
            profile.addExtension(extension);

            return this;
        }

        /**
         * Sets the line comment delimiter
         * 
         * @param start
         *            Line comment delimiter
         * @return this
         */
        @NonNull
        public Builder lineComment(String start)
        {
            profile.setLineCommentStart(start);

            return this;
        }

        /**
         * Sets the block comment start and end delimiters
         * 
         * @param start
         *            The Block Comment start delimiter
         * @param end
         *            The Block Comment end delimiter
         * @return this
         */
        @NonNull
        public Builder blockComment(String start, String end)
        {
            profile.setBlockCommentStart(start);
            profile.setBlockCommentEnd(end);

            return this;
        }

        /**
         * Adds a comment start exception
         * 
         * @param exception
         *            Exception
         * @return this
         */
        @NonNull
        public Builder commentException(String exception)
        {
            profile.addCommentStartException(exception);

            return this;
        }

        /**
         * @return The newly constructed LoCProfile
         */
        @NonNull
        public LoCProfile build()
        {
            return profile;
        }
    }
}
