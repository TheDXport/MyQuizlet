package MyQuizlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainWithArrs {
    
    public static void main(String[] args) throws FileNotFoundException {

        int totalScore = 0;

        // Term t1 =  new Term("disenfranchise", "To take away the right to vote.");
        // Term t2 =  new Term("civil war", "A conflict between the citizens of inhabitants of the same country.");
        // Term t3 =  new Term("tidewater","The territory adjoining water affected by tides-this is, near the seacoast or coastal rivers.");
        // Term t4 =  new Term("middle passage", "That portion of a slave ship's journey in which slaves were carried from Africa to the Americas.");
        // Term t5 =  new Term("fertility", "The ability to mate and produce abundant young.");
        // Term t6 =  new Term("menial", "Fit for servants; humble or low.");
        // Term t7 =  new Term("militia","An armed force of citizens called out only in emergencies.");
        // Term t8 =  new Term("hierarchy", "a social group arranged in ranks or classes.");
        // Term t9 =  new Term("corporation", "A group or institution granted legal rights to carry on certain specified activities.");
        // Term t10 = new Term("jeremiad", "A sermon or prophecy warning of doom and calling for repentance.");
        // Term t11 = new Term("lynching","The illegal killing of an accused person by mob action without due process.");
        // Term t12 = new Term("hinterland","Inland region back from a port, river, or the seacoast.");
        // Term t13 = new Term("social structure", "The basic pattern of the distribution of status and wealth in a society.");
        // Term t14 = new Term("blue blood", "Of noble or upper-class descent.");
        // Term t15 = new Term("sect", "A small religious group that has broken away from some larger mainstream church");
        // Term t16 = new Term("agitators", "Those who seek to excite or persuade the public on some issue.");
        // Term t17 = new Term("stratification", "The visible arrangement of society into a hierarchical pattern, with distinct social groups layered one on top of the other.");
        // Term t18 = new Term("mobility", "The capacity to pass readily from one social or economic condition to another.");
        // Term t19 = new Term("elite", "The smaller group at the top of a society or institution, usually possessing wealth, power, or special privileges.");
        // Term t20 = new Term("almshouse", "A home for the poor, supported by charity or public funds.");
       
        // Term[] termsArr = {t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20};

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