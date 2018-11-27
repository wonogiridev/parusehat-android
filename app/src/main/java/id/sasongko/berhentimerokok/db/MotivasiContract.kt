package id.sasongko.berhentimerokok.db

data class MotivasiContract(val id: Long?, val content: String?) {

    companion object {
        const val TABLE_MOTIVASI: String = "TABLE_MOTIVASI"
        const val ID: String = "ID_"
        const val CONTENT: String = "CONTENT"
    }
}
