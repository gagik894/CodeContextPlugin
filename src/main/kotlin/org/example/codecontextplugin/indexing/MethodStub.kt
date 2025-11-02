package org.example.codecontextplugin.indexing

import com.intellij.psi.PsiMethod
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubBase
import com.intellij.psi.stubs.StubElement

/**
 * Defines the data contract for a lightweight, serialized representation of a [PsiMethod].
 * This interface holds the information that will be persisted in the stub index.
 */
interface MethodStub : StubElement<PsiMethod> {
    /**
     * The indexed name of the method.
     */
    val methodName: String?
}

/**
 * The concrete implementation of the [MethodStub].
 *
 * @param parent The parent stub in the stub tree, if any.
 * @param elementType The [IStubElementType] that governs this stub's behavior.
 * @param methodName The name of the method to be stored.
 */
class MethodStubImpl(
    parent: StubElement<*>?,
    elementType: IStubElementType<*, *>,
    override val methodName: String?
) : StubBase<PsiMethod>(parent, elementType), MethodStub