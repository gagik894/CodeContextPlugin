package org.example.codecontextplugin.indexing

import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream

class MethodStubElementType(
    debugName: String,
    language: Language
) : IStubElementType<MethodStub, PsiMethod>(debugName, language) {
    override fun createPsi(p0: MethodStub): PsiMethod {
        throw UnsupportedOperationException("This method should not be called for standard Java PSI.")
    }

    override fun createStub(
        psi: PsiMethod,
        parentStub: StubElement<out PsiElement?>?
    ): MethodStub {
        return MethodStubImpl(parentStub, this, psi.name)
    }

    override fun getExternalId(): String = "codecontextplugin.method"

    override fun serialize(
        stub: MethodStub,
        dataStream: StubOutputStream
    ) {
        dataStream.writeName(stub.methodName)
    }

    override fun deserialize(
        dataStream: StubInputStream,
        parentStub: StubElement<*>?
    ): MethodStub {
        val methodNameRef = dataStream.readName()
        return MethodStubImpl(parentStub, this, methodNameRef?.string)
    }

    override fun indexStub(
        stub: MethodStub,
        sink: IndexSink
    ) {
        stub.methodName?.takeIf { it.isNotBlank() }?.let {
            sink.occurrence(MethodIndex.KEY, it)
        }
    }
}