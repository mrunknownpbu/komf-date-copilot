package infrastructure.persistence

import domain.manga.Manga
import domain.manga.Chapter

class Repository {
    private val mangaList = mutableListOf<Manga>()

    fun saveManga(manga: Manga) {
        mangaList.add(manga)
    }

    fun getManga(title: String): Manga? {
        return mangaList.find { it.title == title }
    }

    fun saveChapter(mangaTitle: String, chapter: Chapter) {
        val manga = getManga(mangaTitle)
        manga?.chapters?.add(chapter)
    }

    fun getChapters(mangaTitle: String): List<Chapter>? {
        return getManga(mangaTitle)?.chapters
    }
}