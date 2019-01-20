class QuestionList {

    fun take(choices: List<String> = getRandomMode()): List<Question> {
        return Question.values()
                .filter { n -> n.choices == choices }
                .shuffled()
                .take(6);
    }

    fun getRandomMode(): List<String> {
        return QUESTION_MODES.random()
    }
}

val HAS_HAVE_HAD = listOf("has", "have", "had")
val TO_TOO_TWO = listOf("to", "too", "two")
val WHO_WHOM = listOf("who", "whom")
val THERE_THEIR_THEYRE = listOf("there", "their", "they're")
val YOUR_YOURE = listOf("your", "you're")
val QUESTION_MODES = listOf(HAS_HAVE_HAD, TO_TOO_TWO, WHO_WHOM, THERE_THEIR_THEYRE, YOUR_YOURE)

enum class Question(val question: String, val choices: List<String>) {

    Q1("Mary (has) a book.", HAS_HAVE_HAD),
    Q2("A rabbit (has) long ears.", HAS_HAVE_HAD),
    Q3("Shiv (has) a new bicycle.", HAS_HAVE_HAD),
    Q4("They (had) breakfast at 6:30 this morning.", HAS_HAVE_HAD),
    Q5("Rohan (has) six pencils.", HAS_HAVE_HAD),
    Q6("I (have) many friends.", HAS_HAVE_HAD),
    Q7("We (had) a big house when I was a kid.", HAS_HAVE_HAD),
    Q8("Bonny (has) finished her project work.", HAS_HAVE_HAD),
    Q9("Do you (have) a balloon.", HAS_HAVE_HAD),
    Q10("This Hen (has) red wings.", HAS_HAVE_HAD),
    Q11("Sam (had) fun at the party last Sunday.", HAS_HAVE_HAD),

    Q12("I am going (to) read a book.", TO_TOO_TWO),
    Q13("Donald ran (two) miles.", TO_TOO_TWO),
    Q14("Is Ann coming (too)?", TO_TOO_TWO),
    Q15("She got (two) wrong on the test.", TO_TOO_TWO),
    Q16("My brother likes (to) play baseball.", TO_TOO_TWO),
    Q17("I was at the park (two) times today.", TO_TOO_TWO),
    Q18("Those clothes are (too) expensive.", TO_TOO_TWO),
    Q19("Cindy got (two) strikes in bowling.", TO_TOO_TWO),
    Q20("I need (to) write some pages for school.", TO_TOO_TWO),
    Q21("I needy you (to) help me, it's heavy!", TO_TOO_TWO),

    Q22("(Who) stole my ice cream?", WHO_WHOM),
    Q23("To (whom) do I owe my congratulations?", WHO_WHOM),
    Q24("With (whom) did you send the email?", WHO_WHOM),
    Q25("(Who) is your closest friend?", WHO_WHOM),
    Q26("(Who) should I ask to the dance?", WHO_WHOM),
    Q27("With (whom) did you go to the concert?", WHO_WHOM),
    Q28("You will be shocked when I tell you (who) called me!", WHO_WHOM),
    Q29("Do you know (who) delivered the package today?", WHO_WHOM),
    Q30("For (whom) should I vote?", WHO_WHOM),
    Q31("(Who) is helping dad tonight?", WHO_WHOM),

    Q32("Just stay (there) and don't move!", THERE_THEIR_THEYRE),
    Q33("(Their) house is very near.", THERE_THEIR_THEYRE),
    Q34("Can I drive (there) and back in a day?", THERE_THEIR_THEYRE),
    Q35("(They're) going to the party.", THERE_THEIR_THEYRE),
    Q36("They washed (their) hands and faces.", THERE_THEIR_THEYRE),
    Q37("Children are playing with (their) toys.", THERE_THEIR_THEYRE),
    Q38("(They're) really tired.", THERE_THEIR_THEYRE),
    Q39("(They're) going to be here until tomorrow.", THERE_THEIR_THEYRE),
    Q40("(Their) conversation turned to politics.", THERE_THEIR_THEYRE),
    Q41("Look out, over (there)!", THERE_THEIR_THEYRE),

    Q42("(You're) getting very sleepy.", YOUR_YOURE),
    Q43("(Your) laptop needs charged.", YOUR_YOURE),
    Q44("I'm so happy (you're) here.", YOUR_YOURE),
    Q45("Are your sure (you're) alright", YOUR_YOURE),
    Q46("Is that what (you're) here for?", YOUR_YOURE),
    Q47("(Your) dog needs fed.", YOUR_YOURE),
    Q48("Take off (your) hat.", YOUR_YOURE),
    Q49("It's (your) decision.", YOUR_YOURE),
    Q50("Open(your) eyes.", YOUR_YOURE),
    Q51("(You're) my best friend.", YOUR_YOURE),

    ;

    fun getCorrectAnswer(): String {
        return question.toLowerCase().match("(?<=\\()[A-Za-z]+(?=\\))")!![0]
    }

    fun getCorrectAnswerIndex(): Int {
        return choices.indexOf(getCorrectAnswer())
    }

    fun getBlankedQuestion(): String {
        return question.replace(Regex("\\([A-Za-z]+\\)"), "___")
    }
}