import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApplication {

    private static final int QUIZ_DURATION_SECONDS = 30;
    private static int score = 0;
    private static int questionIndex = 0;
    private static Timer timer;

    public static void main(String[] args) {
        initializeQuiz();

        // Create and schedule the timer
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Quiz ended.");
                displayScore();
                System.exit(0);
            }
        }, QUIZ_DURATION_SECONDS * 1000);

        startQuiz();
    }

    private static void initializeQuiz() {
        // Initialize questions and answers
        // You can replace these with your own set of questions
        Question[] questions = {
                new Question("What is the capital of France?", "A. Paris", "B. Rome", "C. Berlin", "D. Madrid", "A"),
                new Question("Which planet is known as the Red Planet?", "A. Venus", "B. Mars", "C. Jupiter", "D. Saturn", "B"),
                new Question("What is the largest mammal in the world?", "A. Elephant", "B. Giraffe", "C. Blue Whale", "D. Dolphin", "C")
                // Add more questions as needed
        };

        // Start the quiz with the first question
        askQuestion(questions[questionIndex]);
    }

    private static void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        while (questionIndex < Question.getQuestionCount()) {
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();

            if (checkAnswer(userAnswer)) {
                System.out.println("Correct! +1 point");
                score++;
            } else {
                System.out.println("Incorrect! The correct answer is: " + Question.getCorrectAnswer(questionIndex));
            }

            // Move to the next question
            questionIndex++;

            // Ask the next question or end the quiz
            if (questionIndex < Question.getQuestionCount()) {
                askQuestion(Question.getQuestion(questionIndex));
            } else {
                displayScore();
                break;
            }
        }

        // Stop the timer when the quiz ends
        timer.cancel();
        scanner.close();
    }

    private static void askQuestion(Question question) {
        System.out.println("\nQuestion " + (questionIndex + 1) + ": " + question.getQuestion());
        System.out.println(question.getChoices());
    }

    private static boolean checkAnswer(String userAnswer) {
        return userAnswer.equals(Question.getCorrectAnswer(questionIndex));
    }

    private static void displayScore() {
        System.out.println("\nQuiz completed!");
        System.out.println("Your score: " + score + "/" + Question.getQuestionCount());
    }
}

class Question {
    private String question;
    private String[] choices;
    private String correctAnswer;

    private static int questionCount = 0;

    public Question(String question, String... choicesAndAnswer) {
        this.question = question;
        this.choices = new String[choicesAndAnswer.length - 1];
        System.arraycopy(choicesAndAnswer, 0, this.choices, 0, choices.length);
        this.correctAnswer = choicesAndAnswer[choicesAndAnswer.length - 1].toUpperCase();
        questionCount++;
    }

    public String getQuestion() {
        return question;
    }

    public String getChoices() {
        StringBuilder choicesString = new StringBuilder();
        for (String choice : choices) {
            choicesString.append(choice).append("\n");
        }
        return choicesString.toString();
    }

    public static int getQuestionCount() {
        return questionCount;
    }

    public static String getCorrectAnswer(int index) {
        return Question.getQuestion(index).correctAnswer;
    }

    public static Question getQuestion(int index) {
        // You can replace this with your own method of fetching questions
        Question[] questions = {
                new Question("What is the capital of France?", "A. Paris", "B. Rome", "C. Berlin", "D. Madrid", "A"),
                new Question("Which planet is known as the Red Planet?", "A. Venus", "B. Mars", "C. Jupiter", "D. Saturn", "B"),
                new Question("What is the largest mammal in the world?", "A. Elephant", "B. Giraffe", "C. Blue Whale", "D. Dolphin", "C")
                // Add more questions as needed
        };

        return questions[index];
    }
}
