class Spellmate {
    var wordList: WordList = getStoredList()

    private fun getStoredList(): WordList {
        val cookie = Cookies.get(COOKIE_WORD_LIST);
        return if(cookie != undefined) {
            WordList(cookie)
        } else WordList.DEFAULT_MEDIUM;
    }
}