package io.definenulls.ethereumkit.decorations

class ContractCreationDecoration : TransactionDecoration() {

    override fun tags(): List<String> = listOf("contractCreation")

}
