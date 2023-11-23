fun main() {
    println("Введе слова (разделяйте пробелом):")
    val input = readLine()
    if (input != null) {
        val inputWords = input.split(" ")
        val groupedWords = groupWordsByLetterComposition(inputWords.toTypedArray())

        for (group in groupedWords.values) {
            println(group.joinToString(", "))
        }
    }
}

fun groupWordsByLetterComposition(words: Array<String>): Map<String, List<String>> {
    val groupedWords = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedWord = word.toCharArray().sorted().joinToString("")
        if (groupedWords.containsKey(sortedWord)) {
            groupedWords[sortedWord]!!.add(word)
        } else {
            groupedWords[sortedWord] = mutableListOf(word)
        }
    }

    return groupedWords
}