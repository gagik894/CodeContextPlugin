package org.example.codecontextplugin.indexing

import com.intellij.psi.PsiMethod
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey

/**
 * Provides access to an index of method names.
 */
class MethodIndex : StringStubIndexExtension<PsiMethod>() {

    companion object {
        /**
         * The unique key identifying this index.
         */
        @JvmField
        val KEY: StubIndexKey<String, PsiMethod> = StubIndexKey.createIndexKey("codecontextplugin.method.name.index")
    }

    override fun getKey(): StubIndexKey<String, PsiMethod> = KEY

    /**
     * Returns the version of the index.
     * This number MUST be incremented whenever the serialized stub format changes.
     */
    override fun getVersion(): Int = 1
}