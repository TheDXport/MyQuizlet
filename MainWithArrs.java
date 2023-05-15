package MyQuizlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainWithArrs {
    
    public static void main(String[] args) throws FileNotFoundException {

        int totalScore = 0;

        // Generators
    int start = 121; // MIN IS 1
    int end = 140; // MAX IS 395
    end += 1;
    
Term[] termsArr = new Term[end-start]; 
    Scanner scanner = new Scanner(
        new File("/Users/dx/Desktop/VS CODE PROJECTS/Class Projects/MyQuizlet/apushVOCAB.txt"));

    int currentLine = 0;
    while (currentLine < start-1) {
      scanner.nextLine();
      currentLine++;
    }
System.out.println(currentLine);
    for (int i = 0; i < end - start; i++) {
      String line = scanner.nextLine();
      termsArr[i] = (new Term(line.substring(firstSpace(line) + 1, firstDash(line)), line.substring(firstDash(line) + 3)));
    }
        ArrayList<String> wrongTermsList = new ArrayList<String>();

        Scanner s = new Scanner(System.in);
        Term[] questionsArr = randomizeArray(termsArr);
       
        int questionNum = 1;
        while (questionNum < 21) {

    
    Term question = questionsArr[questionNum-1];
    
    Term[] terms = termsArr;
    int rand1 =  (int)(Math.random() * (terms.length-1));
    Term answer1 = terms[rand1];
    terms = removeTerm(terms, answer1);

    int rand2 =  (int)(Math.random() * (terms.length-1));
    Term answer2 = terms[rand2];
    terms = removeTerm(terms, answer2);

    int rand3 =  (int)(Math.random() * (terms.length-1));
    Term answer3 = terms[rand3];
    terms = removeTerm(terms, answer3);

    int rand4 =  (int)(Math.random() * (terms.length-1));
    Term answer4 = terms[rand4];
    terms = removeTerm(terms, answer4);

    Term[] answerChoicesArr = {question, answer1, answer2, answer3, answer4};
    answerChoicesArr = randomizeArray(answerChoicesArr);
        
    System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    System.out.println(questionNum + ") " + question.getTerm());
    int ASCIVAL = 65;
    for (int i = 0; i < answerChoicesArr.length; i++) {
        System.out.println("  " + ((char)ASCIVAL) + ") " + answerChoicesArr[i].getDef());
        ASCIVAL++;
   }
        String userInput = s.nextLine();
        switch(userInput.toLowerCase()) {
            
            case "a":
                if (answerChoicesArr[0].getDef().equals(question.getDef())) {
                    totalScore++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! The answer was: " + question.getDef());
                    wrongTermsList.add(question.getTerm());
                    break;
                }
                break;
            case "b":
            if (answerChoicesArr[1].getDef().equals(question.getDef())) {
                totalScore++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The answer was " + question.getDef());
                wrongTermsList.add(question.getTerm());
                break;
            }
                break;
            case "c":
            if (answerChoicesArr[2].getDef().equals(question.getDef())) {
                totalScore++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The answer was " + question.getDef());
                wrongTermsList.add(question.getTerm());
                break;
            }
                break;
            case "d":
            if (answerChoicesArr[3].getDef().equals(question.getDef())) {
                totalScore++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The answer was " + question.getDef());
                wrongTermsList.add(question.getTerm());
                break;
            }
                break;
            case "e":
            if (answerChoicesArr[4].getDef().equals(question.getDef())) {
                totalScore++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect! The answer was " + question.getDef());
                wrongTermsList.add(question.getTerm());
                break;
            }
                break;
        }
        questionNum++;
        }




System.out.println("YOUR SCORE: " + totalScore);
System.out.println("NEED PRAC: " + wrongTermsList);
            
        }
    

        public static int firstSpace(String line) {
            int index = line.indexOf(" ");
            return index;
          }
        
          public static int firstDash(String line) {
            int index = line.indexOf(" - ");
            return index;
          }

   public static Term[] removeTerm(Term[] arr, Term element) {
    Term[] arr2 = new Term[arr.length - 1];
    int i = 0;
    for (Term t : arr) {
        if (!t.equals(element)) {
            arr2[i] = t;
            i++;
        }
    }
            return arr2;
    }


    public static Term[]  randomizeArray(Term[] arr) {
        int i = 0;
        while (i < arr.length) {
            int rand = (int)(Math.random() * (arr.length-1));
            Term t = arr[rand];
            arr[rand] = arr[i];
            arr[i] = t;
            i++;
            }
            return arr;
            }

}
