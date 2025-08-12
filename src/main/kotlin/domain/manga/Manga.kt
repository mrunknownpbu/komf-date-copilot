package domain.manga

data class Manga(
    val title: String,
    val author: String,
    val chapters: List<Chapter>
) {
    fun getLatestChapter(): Chapter? {
        return chapters.maxByOrNull { it.number }
    }
}