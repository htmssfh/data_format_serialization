/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fangye.dataparser.utils;


import com.fangye.dataparser.utils.translate.AggregateTranslator;
import com.fangye.dataparser.utils.translate.CharSequenceTranslator;
import com.fangye.dataparser.utils.translate.JavaUnicodeEscaper;
import com.fangye.dataparser.utils.translate.LookupTranslator;
import com.fangye.dataparser.utils.translate.OctalUnescaper;
import com.fangye.dataparser.utils.translate.UnicodeUnescaper;

/**
 * <p>Escapes and unescapes {@code String}s for
 * Java, Java Script, HTML and XML.</p>
 *
 * <p>#ThreadSafe#</p>
 * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/StringEscapeUtils.html">
 * StringEscapeUtils</a> instead
 */
public class StringEscapeUtils {

    /**
     * Translator object for unescaping escaped Java.
     *
     * While {@link #unescapeJava(String)} is the expected method of use, this
     * object allows the Java unescaping functionality to be used
     * as the foundation for a custom translator.
     *
     * @since 3.0
     */
    // throw "illegal character: \92" as an Exception if a \ on the end of the Java (as per the compiler)?
    public static final CharSequenceTranslator UNESCAPE_JAVA =
            new AggregateTranslator(
                    new OctalUnescaper(),     // .between('\1', '\377'),
                    new UnicodeUnescaper(),
                    new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()),
                    new LookupTranslator(
                            new String[][] {
                                    {"\\\\", "\\"},
                                    {"\\\"", "\""},
                                    {"\\'", "'"},
                                    {"\\", ""}
                            })
            );

    /**
     * Translator object for escaping Json.
     *
     * While {@link #escapeJson(String)} is the expected method of use, this
     * object allows the Json escaping functionality to be used
     * as the foundation for a custom translator.
     *
     * @since 3.2
     */
    public static final CharSequenceTranslator ESCAPE_JSON =
        new AggregateTranslator(
                new LookupTranslator(
                      new String[][] {
                            {"\"", "\\\""},
                            {"\\", "\\\\"},
                            {"/", "\\/"}
                      }),
                new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()),
                JavaUnicodeEscaper.outsideOf(32, 0x7f)
        );

    /* ESCAPE TRANSLATORS */

    /**
     * Translator object for escaping Java.
     *
     * While {@link #escapeJava(String)} is the expected method of use, this
     * object allows the Java escaping functionality to be used
     * as the foundation for a custom translator.
     *
     * @since 3.0
     */
    public static final CharSequenceTranslator ESCAPE_JAVA =
            new LookupTranslator(
                    new String[][] {
                            {"\"", "\\\""},
                            {"\\", "\\\\"},
                    }).with(
                    new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())
            ).with(
                    JavaUnicodeEscaper.outsideOf(32, 0x7f)
            );


    /**
     * Translator object for escaping EcmaScript/JavaScript.
     *
     * While {@link #escapeEcmaScript(String)} is the expected method of use, this
     * object allows the EcmaScript escaping functionality to be used
     * as the foundation for a custom translator.
     *
     * @since 3.0
     */
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT =
            new AggregateTranslator(
                    new LookupTranslator(
                            new String[][] {
                                    {"'", "\\'"},
                                    {"\"", "\\\""},
                                    {"\\", "\\\\"},
                                    {"/", "\\/"}
                            }),
                    new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE()),
                    JavaUnicodeEscaper.outsideOf(32, 0x7f)
            );



    /**
     * Translator object for unescaping escaped EcmaScript.
     *
     * While {@link #unescapeEcmaScript(String)} is the expected method of use, this
     * object allows the EcmaScript unescaping functionality to be used
     * as the foundation for a custom translator.
     *
     * @since 3.0
     */
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT = UNESCAPE_JAVA;

    /**
     * Translator object for unescaping escaped Json.
     *
     * While {@link #unescapeJson(String)} is the expected method of use, this
     * object allows the Json unescaping functionality to be used
     * as the foundation for a custom translator.
     *
     * @since 3.2
     */
    public static final CharSequenceTranslator UNESCAPE_JSON = UNESCAPE_JAVA;



    /**
     * <p>Escapes the characters in a {@code String} using Json String rules.</p>
     * <p>Escapes any values it finds into their Json String form.
     * Deals correctly with quotes and control-chars (tab, backslash, cr, ff, etc.) </p>
     *
     * <p>So a tab becomes the characters {@code '\\'} and
     * {@code 't'}.</p>
     *
     * <p>The only difference between Java strings and Json strings
     * is that in Json, forward-slash (/) is escaped.</p>
     *
     * <p>See http://www.ietf.org/rfc/rfc4627.txt for further details. </p>
     *
     * <p>Example:</p>
     * <pre>
     * input string: He didn't say, "Stop!"
     * output string: He didn't say, \"Stop!\"
     * </pre>
     *
     * @param input  String to escape values in, may be null
     * @return String with escaped values, {@code null} if null string input
     *
     * @since 3.2
     */
    public static final String escapeJson(final String input) {
        return ESCAPE_JSON.translate(input);
    }

    // Java and JavaScript
    //--------------------------------------------------------------------------
    /**
     * <p>Escapes the characters in a {@code String} using Java String rules.</p>
     *
     * <p>Deals correctly with quotes and control-chars (tab, backslash, cr, ff, etc.) </p>
     *
     * <p>So a tab becomes the characters {@code '\\'} and
     * {@code 't'}.</p>
     *
     * <p>The only difference between Java strings and JavaScript strings
     * is that in JavaScript, a single quote and forward-slash (/) are escaped.</p>
     *
     * <p>Example:</p>
     * <pre>
     * input string: He didn't say, "Stop!"
     * output string: He didn't say, \"Stop!\"
     * </pre>
     *
     * @param input  String to escape values in, may be null
     * @return String with escaped values, {@code null} if null string input
     */
    public static final String escapeJava(final String input) {
        return ESCAPE_JAVA.translate(input);
    }

    /**
     * <p>Escapes the characters in a {@code String} using EcmaScript String rules.</p>
     * <p>Escapes any values it finds into their EcmaScript String form.
     * Deals correctly with quotes and control-chars (tab, backslash, cr, ff, etc.) </p>
     *
     * <p>So a tab becomes the characters {@code '\\'} and
     * {@code 't'}.</p>
     *
     * <p>The only difference between Java strings and EcmaScript strings
     * is that in EcmaScript, a single quote and forward-slash (/) are escaped.</p>
     *
     * <p>Note that EcmaScript is best known by the JavaScript and ActionScript dialects. </p>
     *
     * <p>Example:</p>
     * <pre>
     * input string: He didn't say, "Stop!"
     * output string: He didn\'t say, \"Stop!\"
     * </pre>
     *
     * @param input  String to escape values in, may be null
     * @return String with escaped values, {@code null} if null string input
     *
     * @since 3.0
     */
    public static final String escapeEcmaScript(final String input) {
        return ESCAPE_ECMASCRIPT.translate(input);
    }




    /**
     * <p>Unescapes any Json literals found in the {@code String}.</p>
     *
     * <p>For example, it will turn a sequence of {@code '\'} and {@code 'n'}
     * into a newline character, unless the {@code '\'} is preceded by another
     * {@code '\'}.</p>
     *
     * @see #unescapeJava(String)
     * @param input  the {@code String} to unescape, may be null
     * @return A new unescaped {@code String}, {@code null} if null string input
     *
     * @since 3.2
     */
    public static final String unescapeJson(final String input) {
        return UNESCAPE_JSON.translate(input);
    }


    /**
     * <p>Unescapes any Java literals found in the {@code String}.
     * For example, it will turn a sequence of {@code '\'} and
     * {@code 'n'} into a newline character, unless the {@code '\'}
     * is preceded by another {@code '\'}.</p>
     *
     * @param input  the {@code String} to unescape, may be null
     * @return a new unescaped {@code String}, {@code null} if null string input
     */
    public static final String unescapeJava(final String input) {
        return UNESCAPE_JAVA.translate(input);
    }

    /**
     * <p>Unescapes any EcmaScript literals found in the {@code String}.</p>
     *
     * <p>For example, it will turn a sequence of {@code '\'} and {@code 'n'}
     * into a newline character, unless the {@code '\'} is preceded by another
     * {@code '\'}.</p>
     *
     * @see #unescapeJava(String)
     * @param input  the {@code String} to unescape, may be null
     * @return A new unescaped {@code String}, {@code null} if null string input
     *
     * @since 3.0
     */
    public static final String unescapeEcmaScript(final String input) {
        return UNESCAPE_ECMASCRIPT.translate(input);
    }



}
