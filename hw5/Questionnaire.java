package syr.edu.hw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeikertQuestion
{
	private String q;
    private String prompt1, prompt2, prompt3, prompt4, prompt5;
    private List<String> acceptableAnswers;
	
	public LeikertQuestion(String q, String prompt1, String prompt2, String prompt3, String prompt4, String prompt5,  List<String> acceptable)
    {
    	this.q = q;
    	this.prompt1 = prompt1;
    	this.prompt2 = prompt2;
    	this.prompt3 = prompt3;
    	this.prompt4 = prompt4;
    	this.prompt5 = prompt5;
    	this.acceptableAnswers = acceptable;
    }
	public void render(PrintStream p) {
		p.println(q);
		p.println(prompt1);
		p.println(prompt2);
		p.println(prompt3);
		p.println(prompt4);
		p.println(prompt5);
	}
	
	public boolean isAcceptableAnswerForLeikert(String s)
	{
		return acceptableAnswers.contains(s);
	}
}

class Question {
    private String q;
    private String prompt;
    private List<String> acceptableAnswers;
    
    public Question(String q, String prompt, List<String> acceptable) {
        this.q = q;
        this.prompt = prompt;
        acceptableAnswers = acceptable;
    }
    public void render(PrintStream p) {
        p.println(q);
        p.println(prompt);
    }
    public boolean isAcceptableAnswer(String s) {
        return acceptableAnswers.contains(s);
    }
}
public class Questionnaire {
    List<Question> questions;
    List<LeikertQuestion> lquestions;
    public Questionnaire() {
        questions = new ArrayList<>();
        lquestions = new ArrayList<>();
    }
    public void addQuestion(Question q) {
        questions.add(q);
    }
    public void addLeikertQuestion(LeikertQuestion q)
    {
    	lquestions.add(q);
    }
    public List<String> administerLeikertQuestionnaire(){
    	List<String> answers = new ArrayList<>();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	for(LeikertQuestion q: lquestions)
    	{
    		q.render(System.out);
			String response = "";
			do {
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!q.isAcceptableAnswerForLeikert(response));
			int ans;
			String res = "";
			ans = Integer.parseInt(response);
			switch (ans) {
			case 1:
				res += "Strongly Agree";
				break;
			case 2:
				res += "Somewhat Agree";
				break;
			case 3:
				res += "Neutral";
				break;
			case 4:
				res += "Somewhat Disagree";
				break;
			case 5:
				res += "Strongly Disagree";
				break;
			default:
				break;
			}
			answers.add(res);
    	}
    	return answers;
    }
    public List<String> administerQuestionnaire() {
        List<String> answers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (Question q: questions) {
            q.render(System.out);
            String response = "";
            do {
                try {
                    response = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (!q.isAcceptableAnswer(response));
            answers.add(response);
        }
        return answers;
    }

    public static void main(String[] args) {
        Questionnaire q = new Questionnaire();
        q.addQuestion(new Question("Are you awake?", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("Have you had coffee?", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        q.addQuestion(new Question("Are you ready to get to work?", "True or False: ", Arrays.asList("True", "False", "true", "false", "t", "f", "T", "F")));
        List<String> answers = q.administerQuestionnaire();
        System.out.println("complete!");
        System.out.println(answers);
        q.addLeikertQuestion(new LeikertQuestion("CSE 687 is awesome", "1 -> Strongly Agree", "2 -> Somewhat Agree", "3 -> Neutral", "4 -> Somewhat Disagree", "5 -> Strongly Disagree", Arrays.asList("1", "2", "3", "4", "5") ));
        List<String> leikertanswers = q.administerLeikertQuestionnaire();
        System.out.println("complete!");
        System.out.println(leikertanswers);
    }
}
