fun main() {
    val russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    val customAlphabetOrder = intArrayOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

    print("Введите '1' для шифрования или '2' для дешифрования: ")
    val choice = readLine()
    when (choice) {
        "1" -> {
            print("Введите текст для шифрования: ")
            val originalText = readLine() ?: ""
            print("Введите ключевое слово: ")
            val keyword = readLine() ?: ""
            val encryptedText = encrypt(originalText, keyword, russianAlphabet, customAlphabetOrder)
            println("Зашифрованный текст: $encryptedText")
        }
        "2" -> {
            print("Введите зашифрованный текст: ")
            val ciphertext = readLine() ?: ""
            print("Введите ключевое слово: ")
            val keyword = readLine() ?: ""
            val decryptedText = decrypt(ciphertext, keyword, russianAlphabet, customAlphabetOrder)
            println("Расшифрованный текст: $decryptedText")
        }

    }
}

fun encrypt(text: String, keyword: String, alphabet: String, customAlphabetOrder: IntArray): String {
    val encryptedChars = mutableListOf<Char>()
    for (i in 0 until text.length) {
        val char = text[i].toString().uppercase().first()
        val keywordChar = keyword[i % keyword.length].toString().uppercase().first()
        val charIndex = customAlphabetOrder[alphabet.indexOf(char)]
        val keywordIndex = customAlphabetOrder[alphabet.indexOf(keywordChar)]
        if (charIndex != -1) {
            val newIndex = (charIndex + keywordIndex) % customAlphabetOrder.size
            encryptedChars.add(alphabet[customAlphabetOrder.indexOf(newIndex)])
        } else {
            encryptedChars.add(char)
        }
    }

    return encryptedChars.joinToString("")
}

fun decrypt(ciphertext: String, keyword: String, alphabet: String, customAlphabetOrder: IntArray): String {
    val decryptedChars = mutableListOf<Char>()

    for (i in 0 until ciphertext.length) {
        val char = ciphertext[i].toString().uppercase().first()
        val keywordChar = keyword[i % keyword.length].toString().uppercase().first()
        val charIndex = customAlphabetOrder[alphabet.indexOf(char)]
        val keywordIndex = customAlphabetOrder[alphabet.indexOf(keywordChar)]
        if (charIndex != -1) {
            val newIndex = (charIndex - keywordIndex + customAlphabetOrder.size) % customAlphabetOrder.size
            decryptedChars.add(alphabet[customAlphabetOrder.indexOf(newIndex)])
        } else {
            decryptedChars.add(char)
        }
    }

    return decryptedChars.joinToString("")
}