package syr.edu.hw4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Questionnaire {
	List<String> questions;
	List<String> liekertScaleQuestions;

	public Questionnaire() {
		questions = new ArrayList<>();
		liekertScaleQuestions = new ArrayList<>();
	}

	public void addQuestion(String s) {
		questions.add(s);
	}

	public void addLeikertQuestion(String t) {
		liekertScaleQuestions.add(t);

	}

	protected static String isValid(String str) {

		if (str.equals("True".toLowerCase())) {
			return "True";
		} else if (str.equals("False".toLowerCase())) {
			return "False";
		}

		else {
			return "Not valid";
		}

	}

	public List<String> administerQuestionnaire() {
		List<String> answers = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < questions.size(); ++i) {
			System.out.println("True or False: ");
			System.out.println(questions.get(i));
			String response = "";
			try {

				response = isValid((reader.readLine()).toLowerCase());
				if (response.equals("Not valid")) {
					System.out.println("Invalid entry, Please use below options only-");
					i--;
				} else {
					answers.add(response);
				}
			}

			catch (IOException e) {
				e.printStackTrace();
			}

		}
		return answers;
	}
//-----------Leikert Scale implementation-----------------
	
	
	public List<String> administerLeikertQuestionnaire() {
		List<String> leikertanswers = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < liekertScaleQuestions.size(); i++) {
			System.out.println("Options:");
			System.out.println("1 -> Strongly Agree");
			System.out.println("2 -> Somewhat Agree");
			System.out.println("3 -> Neutral");
			System.out.println("4 -> Somewhat Disagree");
			System.out.println("5 -> Strongly Disagree" + '\n');
			System.out.println(liekertScaleQuestions.get(i));
			int response;
			String ans = "";
			try {
				response = Integer.parseInt(reader.readLine());
				switch (response) {
				case 1:
					ans = "Strongly Agree";
					break;
				case 2:
					ans = "Somewhat Agree";
					break;
				case 3:
					ans = "Neutral";
					break;
				case 4:
					ans = "Somewhat Disagree";
					break;
				case 5:
					ans = "Strongly Disagree";
					break;
				default:
					System.out.println("Invalid entry!!, please try option 1 - 5");
					if(Integer.parseInt(ans) > 5 || Integer.parseInt(ans) == 0)
					{
						break;
					}
					i--;
					leikertanswers.clear();

				}
				leikertanswers.add(ans);

			} catch (IOException e) {
				e.printStackTrace();
			} catch (NumberFormatException nfe) {
				leikertanswers.clear();
				System.out.println("Invalid entry!! Enter option 1 - 5 ");
				i--;
			}
			
		}
		return leikertanswers;
	}

	public static void main(String[] args) {
		Questionnaire q = new Questionnaire();
		q.addQuestion("Are you awake?");
		q.addQuestion("Have you had coffee?");
		q.addQuestion("Are you ready to get to work?");
		List<String> answers = q.administerQuestionnaire();

		System.out.println("complete!");
		System.out.println(answers);
		System.out.println("Answer the below survey question:");
		q.addLeikertQuestion("Please provide ratings for: CSE 687 is awesome");
		List<String> leikertanswer = q.administerLeikertQuestionnaire();
		System.out.println(leikertanswer);

	}
}
