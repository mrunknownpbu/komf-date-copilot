class ChapterDateUpdater {

    fun updateChapterDates(chapters: List<Chapter>, newDate: String): List<Chapter> {
        return chapters.map { chapter ->
            chapter.copy(publicationDate = newDate)
        }
    }

    fun updateChapterDate(chapter: Chapter, newDate: String): Chapter {
        return chapter.copy(publicationDate = newDate)
    }
}