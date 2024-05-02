package org.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Question {

    private int questionId;

    private String question;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer_key;

    private int score;


    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setAnswer_key(String answer_key) {
        this.answer_key = answer_key;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer_key() {
        return answer_key;
    }

    public int getScore() {
        return score;
    }


    ConnectionUser connectionUser = new ConnectionUser();


    public void addEasyQuestionToDatabase(String question, String option1, String option2, String option3, String option4, String answer_key) {
        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "INSERT INTO question_easy1 (question, option1, option2,option3,option4,answer_key) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, question);
            statement.setString(2, option1);
            statement.setString(3, option2);
            statement.setString(4, option3);
            statement.setString(5, option4);
            statement.setString(6, answer_key);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " Question Level Easy Added Successfully");

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error adding question: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
    }


    public void addMediumQuestionToDatabase(String question, String option1, String option2, String option3, String option4, String answer_key) {
        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "INSERT INTO question_medium2 (question, option1, option2,option3,option4,answer_key) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, question);
            statement.setString(2, option1);
            statement.setString(3, option2);
            statement.setString(4, option3);
            statement.setString(5, option4);
            statement.setString(6, answer_key);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " Question Level Easy Added Successfully");

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error adding question: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
    }


    public void addHardQuestionToDatabase(String question, String option1, String option2, String option3, String option4, String answer_key) {
        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "INSERT INTO question_hard (question, option1, option2,option3,option4,answer_key) VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, question);
            statement.setString(2, option1);
            statement.setString(3, option2);
            statement.setString(4, option3);
            statement.setString(5, option4);
            statement.setString(6, answer_key);

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " Question Level Easy Added Successfully");

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error adding question: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
    }


    public ArrayList<Question> getAllEasyQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "SELECT * FROM question_easy1";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question q = new Question();
                int questionId = resultSet.getInt("questionid");
                String questionName = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");
                String answer = resultSet.getString("answer_key");
                q.setQuestionId(questionId);
                q.setQuestion(questionName);
                q.setOption1(option1);
                q.setOption2(option2);
                q.setOption3(option3);
                q.setOption4(option4);
                q.setAnswer_key(answer);
                questions.add(q);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
        return questions;
    }

    public ArrayList<Question> getAllMediumQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "SELECT * FROM question_medium2";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question q = new Question();
                int questionId = resultSet.getInt("questionid");
                String questionName = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");
                String answer = resultSet.getString("answer_key");
                q.setQuestionId(questionId);
                q.setQuestion(questionName);
                q.setOption1(option1);
                q.setOption2(option2);
                q.setOption3(option3);
                q.setOption4(option4);
                q.setAnswer_key(answer);
                questions.add(q);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
        return questions;
    }

    public ArrayList<Question> getAllHardQuestions() {

        ArrayList<Question> questions = new ArrayList<>();

        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "SELECT * FROM question_hard";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question q = new Question();
                int questionId = resultSet.getInt("questionid");
                String questionName = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");
                String answer = resultSet.getString("answer_key");
                q.setQuestionId(questionId);
                q.setQuestion(questionName);
                q.setOption1(option1);
                q.setOption2(option2);
                q.setOption3(option3);
                q.setOption4(option4);
                q.setAnswer_key(answer);
                questions.add(q);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }
        return questions;
    }




    public void getQuestions(int id) {

        try {
            Connection connection = connectionUser.initializeConnection();
            String query = "SELECT * FROM question_easy WHERE questionid = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int questionId = resultSet.getInt("questionid");
                String questionName = resultSet.getString("question");
                String option1 = resultSet.getString("option1");
                String option2 = resultSet.getString("option2");
                String option3 = resultSet.getString("option3");
                String option4 = resultSet.getString("option4");
                String answer = resultSet.getString("answer_key");
                setQuestionId(questionId);
                setQuestion(questionName);
                setOption1(option1);
                setOption2(option2);
                setOption3(option3);
                setOption4(option4);
                setAnswer_key(answer);


            } else {
                System.out.println("Question not found with");

            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();
        }

    }

    public int getQuestionsCount() {
        Connection connection = connectionUser.initializeConnection();
        int qId = getQuestionId();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;

        try {
            String query = "SELECT COUNT(*) AS total FROM question_easy";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt("total");


            } else {
                System.out.println("Question not found");

            }

        } catch (SQLException e) {
            System.out.println("Error retrieving user data: " + e.getMessage());
        } finally {
            connectionUser.closeConnection();

        }

        return count;

    }

}

