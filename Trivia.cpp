//
//  Trivia.cpp
//  Trivia
//
//  Created by FastTrackCoder on 6/3/22.
//

//#include "Trivia.hpp"   // Optional header class, I did not use it
#include <iostream>
#include <string>
#include <cctype>
using namespace std;

// Use a struct to control data for questions
struct Question
{
    string prompt;
    char answer;
};

int main()
{
    const int SIZE = 5;
    // Create a structure array to hold the questions and answers to the trivia
    Question test[SIZE];
    test[0] = {"What color is the ocean?"
        "\nA) Red \nB) Blue \nC) Yellow \nD) Green \n", 'B'};
    test[1] = {"What is 16km in miles"
        "\nA) 32mi \nB) 46mi \nC) 8mi \nD) 10mi \n", 'D'};
    test[2] = {"If a triangle has 3 sides, what do the sums of the angles add up to?"
        "\nA) 180 \nB) 90 \nC) 145 \nD) 190 \n", 'A'};
    test[3] = {"In what year did Covid-19 shut down the world?"
        "\nA) 2022 \nB) 2019 \nC) 2021 \nD) 2020 \n", 'D'};
    test[4] = {"A gallon is approximately how many Liters?"
        "\nA) 5 \nB) 3 \nC) 4 \nD) 2 \n", 'C'};
    
    // Create an array of chars to compare to test array
    char input[SIZE];
    
    cout << "\t\t\tTrivia!" << endl;
    cout << "-----------------------------------" << endl;
    cout << "Please use a, b, c, or d as your response" << endl;
    cout << "-----------------------------------" << endl;
    
    // Use a loop to ask the prompts and get the answers
    for(int i = 0; i < SIZE; i++)
    {
        cout << test[i].prompt << "Your answer: ";
        cin.get(input[i]);
        cin.clear();
        cin.ignore(200, '\n');
        cout << endl;
        
        // Make the input uppercase if lowercase
        input[i] = toupper(input[i]);
        
        // Make sure it is between A and D
        while(input[i] < 'A' || input[i] > 'D')
        {
            cout << "You did not choose an answer, please answer this question:\n"
            << test[i].prompt << "Your answer: ";
            cin.get(input[i]);
            cin.clear();
            cin.ignore(200, '\n');
            input[i] = toupper(input[i]);
            cout << endl;
        }
    }
    
    // Create a counter for right answers and use a loop to see which ones they got right
    // Also, display the correct answer vs player answer
    double rightAnswers = 0;
    for(int i = 0; i < SIZE; i++)
    {
        cout << "Q" << (i+1) << " Answer: " << test[i].answer << " :: Your answer: " << input[i] << endl;
        
        if(input[i] == test[i].answer)
        {
            rightAnswers++;
        }
    }
    
    // Display the score
    cout << endl << "Correct Answers: " << rightAnswers << " / " << SIZE << endl;
    cout << "Percent Score: " << static_cast<double>(rightAnswers/SIZE * 100.0) // static_cast is optional here actually
    << "%" << endl;
    
    //cout << "Success!" << endl;
    return 0;
}
