class Spellmate {
    var wordList: WordList = getStoredList()
    var questionList: QuestionList = QuestionList()

    init {
        saveStoredList()
    }

    private fun getStoredList(): WordList {
        val param = Parameters.get(PARAM_WORD_LIST)
        val cookie = Cookies.get(COOKIE_WORD_LIST)

        return if(param != null) { // First checks URL param
            WordList(param)
        } else if(cookie != undefined) { // Next checks cookies
            WordList(cookie)
        } else { // Finally uses default if no other lists available
            WordList.DEFAULT_HARD
        }
    }

    private fun saveStoredList() {
        Cookies.set(COOKIE_WORD_LIST, wordList.toString())
    }
}