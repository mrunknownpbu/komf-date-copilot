package presentation.cli

import domain.updates.ChapterDateUpdater

class Commands(private val chapterDateUpdater: ChapterDateUpdater) {

    fun updateChapterDates() {
        // Logic to update chapter dates
        chapterDateUpdater.updateDates()
        println("Chapter dates updated successfully.")
    }

    fun showHelp() {
        println("Available commands:")
        println("1. updateChapterDates - Updates the publication dates of manga chapters.")
        println("2. help - Shows this help message.")
    }
}