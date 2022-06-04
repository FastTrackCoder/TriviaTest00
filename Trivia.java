import java.util.*;

/**
 * This program will ask trivia questions and then
 * display the results of said quiz
 * @ Made by FastTrackCoder
 */

// Create an inner class for question prompt and answer
class Question
{
    private String prompt;
    private char answer;

    public Question(String p, char a)
    {
        prompt = p;
        answer = a;
    }

    public void setPrompt(String p)
    {
        prompt = p;
    }

    public void setAnswer(char a)
    {
        answer = a;
    }

    public String getPrompt()
    {
        return prompt;
    }

    public char getAnswer()
    {
        return answer;
    }
}

public class Trivia
{
    public static void main(String[] args)
    {
        int SIZE = 5;
        Scanner keyboard = new Scanner(System.in);

        // Create an array of the Question objects
        Question[] test = new Question[SIZE];
        // Initialize these test questions
        test[0] = new Question("What color is the ocean?" +
                "\nA) Red \nB) Blue \nC) Yellow \nD) Green \n", 'B');
        test[1] = new Question("What is 16km in miles" +
                "\nA) 32mi \nB) 46mi \nC) 8mi \nD) 10mi \n", 'D');
        test[2] = new Question("If a triangle has 3 sides, what do the sums of the angles add up to?" +
                "\nA) 180 \nB) 90 \nC) 145 \nD) 190 \n", 'A');
        test[3] = new Question("In what year did Covid-19 shut down the world?" +
                "\nA) 2022 \nB) 2019 \nC) 2021 \nD) 2020 \n", 'D');
        test[4] = new Question("A gallon is approximately how many Liters?" +
                "\nA) 5 \nB) 3 \nC) 4 \nD) 2 \n", 'C');

        // Create an array of chars for input
        // Will also need a string to get charat(0)
        String getInput;
        char[] input = new char[SIZE];

        // Display title
        System.out.println("\t\t\tTrivia!");
        System.out.println("-----------------------------------");
        System.out.println("Please use a, b, c, or d as your response");
        System.out.println("-----------------------------------");

        // Use a loop to ask the prompts and get the answers
        for(int i = 0; i < SIZE; i++)
        {
            System.out.print(test[i].getPrompt());
            System.out.print("Your Answer: ");
            getInput = keyboard.nextLine();

            // Make the input uppercase for ease of troubleshooting
            getInput = getInput.toUpperCase();

            while(getInput.charAt(0) < 'A' || getInput.charAt(0) > 'D')
            {
                System.out.println("You did not choose an answer, please answer this question: ");
                System.out.print(test[i].getPrompt());
                System.out.print("Your Answer: ");
                getInput = keyboard.nextLine();
                getInput = getInput.toUpperCase();
            }

            input[i] = getInput.charAt(0);
        }

        // Create a counter for the right answers, and use a loop to verify score
        // It will also display correct answer vs the player's answer
        double rightAnswers = 0;
        for(int i = 0; i < SIZE; i++)
        {
            System.out.println("Q" + (i+1) + " Answer: " + test[i].getAnswer() +
                    " :: Your Answer: " + input[i]);

            if(input[i] == test[i].getAnswer())
            {
                rightAnswers++;
            }
        }

        // Display the score
        System.out.println("\nCorrect Answers: " + rightAnswers + " / " + SIZE);
        System.out.println("Percent Score: " + (rightAnswers/SIZE * 100.0) + "%");

    }
}
