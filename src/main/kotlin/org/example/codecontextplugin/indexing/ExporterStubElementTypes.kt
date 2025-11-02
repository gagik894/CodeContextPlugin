package org.example.codecontextplugin.indexing

import com.intellij.lang.java.JavaLanguage

/**
 * A central holder for all stub element types defined by the plugin.
 */
object ExporterStubElementTypes {
    /**
     * The stub element type for Java methods.
     */
    @JvmField
    val JAVA_METHOD = MethodStubElementType("JAVA_METHOD", JavaLanguage.INSTANCE)
}