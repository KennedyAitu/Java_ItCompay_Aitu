package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static com.company.IT.statement;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int answer;
            System.out.print("1. Department\n" +
                    "2. Create project \n" +
                    "3. Info about project\n");
            answer = scanner.nextInt();

            switch (answer) {
                case 1:
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    ResultSet resultSet3 = statement.executeQuery("SELECT * FROM pubg");
                    System.out.println("founders \t Directors \t\tDepartment \t\t\t\t HeadOfDepartment \t ViceHeadOfDepartments \t\t Employess");
                    while(resultSet3.next()) {
                        System.out.println(resultSet3.getString(2) + "\t\t " +
                                resultSet3.getString(3) + "\t\t\t" +
                                resultSet3.getString(4) + "\t\t->\t\t\t\t" +
                                resultSet3.getString(5) + "\t\t\t\t\t" +
                                resultSet3.getString(6) + "\t\t\t\t\t" +
                                resultSet3.getString(7) + "\n");
                    }


                    System.out.println(" ");
                    break;
                case 2:
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    System.out.println("Enter project name");
                    String name = scanner.next();
                    statement.executeUpdate("INSERT INTO project(name) VALUES ('" + name + "') ");
                    System.out.println("Enter a period 6/12/18");
                    int peroid = scanner.nextInt();
                    if(peroid==6){
                        System.out.println("Choose Accountance");
                        ResultSet resultSetAccountance = statement.executeQuery("SELECT * FROM accounting");
                        while (resultSetAccountance.next()) {
                            System.out.println("Name: " + resultSetAccountance.getString(2) +
                                    " Salary: " + resultSetAccountance.getString(3) +
                                    " ID: " + resultSetAccountance.getInt(4) +
                                    " Level: " + resultSetAccountance.getInt(5));
                        }
                        System.out.println("Enter id of accountance ");
                        int idAccountance = scanner.nextInt();
                        if (idAccountance == 1) {
                            statement.executeUpdate("UPDATE project SET period = '2'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '1'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '100000'");
                            statement.executeUpdate("UPDATE project SET level = '2'");
                        } else if (idAccountance == 2) {
                            statement.executeUpdate("UPDATE project SET period = '2'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '2'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '200000'");
                            statement.executeUpdate("UPDATE project SET level = '1'");
                        }
                        else if (idAccountance == 3) {
                            statement.executeUpdate("UPDATE project SET period = '2'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '2'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '200000'");
                            statement.executeUpdate("UPDATE project SET level = '1'");
                        }
                        boolean flagAccountance = true;
                        while (flagAccountance) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerAccountance = scanner.nextInt();
                            switch (answerAccountance) {
                                case 1:
                                    System.out.println("Enter id of accountance ");
                                    int idAccountance1 = scanner.nextInt();
                                    if (idAccountance1 == 1) {
                                        statement.executeUpdate("UPDATE project SET period = '2'");
                                        statement.executeUpdate("UPDATE project SET idOfWorkers = '1'");
                                        statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                                        statement.executeUpdate("UPDATE project SET salary = '100000'");
                                        statement.executeUpdate("UPDATE project SET level = '2'");
                                    } else if (idAccountance1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','Accountance','200000','1') ");
                                    }
                                    else if(idAccountance1 == 3){
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '3','Accountance','300000','1') ");
                                    }
                                    break;
                                case 2:
                                    flagAccountance = false;
                                    break;
                            }
                        }
//---------------------------ACCOUNTANCE -------------------------------------------------

//---------------------------PROJECT MANAGER-------------------------------------------------
                        System.out.println("Choose Project Manager");
                        ResultSet resultSetProjectManager = statement.executeQuery("SELECT * FROM management");
                        while (resultSetProjectManager.next()) {
                            System.out.println("Name: " + resultSetProjectManager.getString(2) +
                                    " Salary: " + resultSetProjectManager.getString(3) +
                                    " ID: " + resultSetProjectManager.getInt(4) +
                                    " Level: " + resultSetProjectManager.getInt(5));
                        }
                        System.out.println("Enter id of Project Manager");
                        int idProjectManager = scanner.nextInt();
                        if (idProjectManager == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 6', '1','Project Manager','100000','2') ");
                        } else if (idProjectManager == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 6', '2','Project Manager','200000','1') ");
                        }
                        else if (idProjectManager == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 6', '3','Project Manager','300000','2') ");
                        }

                        boolean flagProjectManager = true;
                        while (flagProjectManager) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerProjectManager = scanner.nextInt();
                            switch (answerProjectManager) {
                                case 1:
                                    System.out.println("Enter id of Project Manager ");
                                    int idProjectManager1 = scanner.nextInt();
                                    if (idProjectManager1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 6', '1','Project Manager','100000','2') ");
                                    } else if (idProjectManager1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 6', '2','Project Manager','200000','1') ");
                                    }
                                    else if(idProjectManager1 == 3){
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 6', '3','Project Manager','300000','2') ");
                                    }
                                    break;
                                case 2:
                                    flagProjectManager = false;
                                    break;
                            }
                        }
//---------------------------PROJECT MANAGER-------------------------------------------------

//---------------------------Lawyer-------------------------------------------------
                        System.out.println("Choose Lawyer");
                        ResultSet resultSetLawyer = statement.executeQuery("SELECT * FROM judicial");
                        while (resultSetLawyer.next()) {
                            System.out.println("Name: " + resultSetLawyer.getString(2) +
                                    " Salary: " + resultSetLawyer.getString(3) +
                                    " ID: " + resultSetLawyer.getInt(4) +
                                    " Level: " + resultSetLawyer.getInt(5));
                        }
                        System.out.println("Enter id of Lawyer");
                        int idLawyer = scanner.nextInt();
                        if (idLawyer == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 2', '1','Lawyer','500000','2') ");
                        } else if (idLawyer == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 2', '2','Lawyer','400000','1') ");
                        }


                        boolean flagLawyer = true;
                        while (flagLawyer) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerLawyer = scanner.nextInt();
                            switch (answerLawyer) {
                                case 1:
                                    System.out.println("Enter id of Lawyer ");
                                    int idLawyer1 = scanner.nextInt();
                                    if (idLawyer1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 2', '1','Lawyer','500000','2') ");
                                    } else if (idLawyer1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 2', '2','Lawyer','400000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagLawyer = false;
                                    break;
                            }
                        }
//---------------------------Lawyer-------------------------------------------------

//---------------------------HR-------------------------------------------------
                        System.out.println("Choose HR");
                        ResultSet resultSetHR = statement.executeQuery("SELECT * FROM hr");
                        while (resultSetHR.next()) {
                            System.out.println("Name: " + resultSetHR.getString(2) +
                                    " Salary: " + resultSetHR.getString(3) +
                                    " ID: " + resultSetHR.getInt(4) +
                                    " Level: " + resultSetHR.getInt(5));
                        }
                        System.out.println("Enter id of HR");
                        int idHR = scanner.nextInt();
                        if (idHR == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 1', '1','HR','300000','2') ");
                        } else if (idHR == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 1', '2','HR','200000','1') ");
                        }

                        boolean flagHR= true;
                        while (flagHR) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerHR = scanner.nextInt();
                            switch (answerHR) {
                                case 1:
                                    System.out.println("Enter id of HR ");
                                    int idHR1 = scanner.nextInt();
                                    if (idHR1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','HR','300000','2') ");
                                    } else if (idHR1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','HR','200000','1') ");
                                    }
                                    break;
                                case 2:
                                    flagHR = false;
                                    break;
                            }
                        }
//---------------------------HR-------------------------------------------------

//---------------------------ANALYST-------------------------------------------------
                        System.out.println("Choose Analyst");
                        ResultSet resultSetAnalyst = statement.executeQuery("SELECT * FROM analyst");
                        while (resultSetAnalyst.next()) {
                            System.out.println("Name: " + resultSetAnalyst.getString(2) +
                                    " Salary: " + resultSetAnalyst.getString(3) +
                                    " ID: " + resultSetAnalyst.getInt(4) +
                                    " Level: " + resultSetAnalyst.getInt(5));
                        }
                        System.out.println("Enter id of Analyst");
                        int idAnalyst = scanner.nextInt();
                        if (idAnalyst == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Analyst','500000','1') ");
                        } else if (idAnalyst == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Analyst','400000','2') ");
                        }
                        else if (idAnalyst == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '3','Analyst','300000','2') ");
                        }

                        boolean flagAnalyst= true;
                        while (flagAnalyst) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerAnalyst = scanner.nextInt();
                            switch (answerAnalyst) {
                                case 1:
                                    System.out.println("Enter id of Analyst ");
                                    int idAnalyst1 = scanner.nextInt();
                                    if (idAnalyst1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Analyst','500000','1') ");
                                    } else if (idAnalyst1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Analyst','400000','2') ");
                                    }
                                    else if (idAnalyst1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '3','Analyst','300000','2') ");
                                    }
                                    break;
                                case 2:
                                    flagAnalyst = false;
                                    break;
                            }
                        }
//---------------------------ANALYST-------------------------------------------------

//---------------------------BACKEND-------------------------------------------------
                        System.out.println("Choose Backend");
                        ResultSet resultSetBackend = statement.executeQuery("SELECT * FROM backend");
                        while (resultSetBackend.next()) {
                            System.out.println("Name: " + resultSetBackend.getString(2) +
                                    " Salary: " + resultSetBackend.getString(3) +
                                    " ID: " + resultSetBackend.getInt(4) +
                                    " Level: " + resultSetBackend.getInt(5));
                        }
                        System.out.println("Enter id of Backend");
                        int idBackend = scanner.nextInt();
                        if (idBackend == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '1','Backend','700000','1') ");
                        } else if (idBackend == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '2','Backend','600000','2') ");
                        }
                        else if (idBackend == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '3','Backend','500000','1') ");
                        }
                        else if (idBackend == 4) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '4','Backend','400000','2') ");
                        }
                        else if (idBackend == 5) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '5','Backend','300000','1') ");
                        }
                        else if (idBackend == 6) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '6','Backend','200000','2') ");
                        }


                        boolean flagBackend = true;
                        while (flagBackend) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerBackend = scanner.nextInt();
                            switch (answerBackend) {
                                case 1:
                                    System.out.println("Enter id of Backend ");
                                    int idBackend1 = scanner.nextInt();
                                    if (idBackend1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '1','Backend','700000','1') ");
                                    } else if (idBackend1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '2','Backend','600000','2') ");
                                    }
                                    else if (idBackend1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '3','Backend','500000','1') ");
                                    }
                                    else if (idBackend1 == 4) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '4','Backend','400000','2') ");
                                    }
                                    else if (idBackend1 == 5) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '5','Backend','300000','1') ");
                                    }
                                    else if (idBackend1 == 6) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '6','Backend','200000','2') ");
                                    }

                                    break;
                                case 2:
                                    flagBackend = false;
                                    break;
                            }
                        }
//---------------------------BACKEND-------------------------------------------------

//---------------------------FRONTEND-------------------------------------------------
                        System.out.println("Choose Frontend");
                        ResultSet resultSetFrontend = statement.executeQuery("SELECT * FROM frontend");
                        while (resultSetFrontend.next()) {
                            System.out.println("Name: " + resultSetFrontend.getString(2) +
                                    " Salary: " + resultSetFrontend.getString(3) +
                                    " ID: " + resultSetFrontend.getInt(4) +
                                    " Level: " + resultSetFrontend.getInt(5));
                        }
                        System.out.println("Enter id of Frontend");
                        int idFrontend = scanner.nextInt();
                        if (idFrontend == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Frontend','300000','2') ");
                        } else if (idFrontend == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Frontend','200000','1') ");
                        }
                        else if (idFrontend == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '3','Frontend','400000','2') ");
                        }
                        else if (idFrontend == 4) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '4','Frontend','500000','1') ");
                        }
                        else if (idFrontend == 5) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '5','Frontend','700000','2') ");
                        }
                        else if (idFrontend == 6) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '6','Frontend','600000','1') ");
                        }


                        boolean flagFrontend = true;
                        while (flagFrontend) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerFrontend = scanner.nextInt();
                            switch (answerFrontend) {
                                case 1:
                                    System.out.println("Enter id of Frontend ");
                                    int idFrontend1 = scanner.nextInt();
                                    if (idFrontend1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Frontend','300000','2') ");
                                    } else if (idFrontend1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Frontend','200000','1') ");
                                    }
                                    else if (idFrontend1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '3','Frontend','400000','2') ");
                                    }
                                    else if (idFrontend1 == 4) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '4','Frontend','500000','1') ");
                                    }
                                    else if (idFrontend1 == 5) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '5','Frontend','700000','2') ");
                                    }
                                    else if (idFrontend1 == 6) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '6','Frontend','600000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagFrontend = false;
                                    break;
                            }
                        }
//---------------------------FRONTEND-------------------------------------------------

//---------------------------MARKETING-------------------------------------------------
                        System.out.println("Choose Marketing");
                        ResultSet resultSetMarketing = statement.executeQuery("SELECT * FROM marketing");
                        while (resultSetMarketing.next()) {
                            System.out.println("Name: " + resultSetMarketing.getString(2) +
                                    " Salary: " + resultSetMarketing.getString(3) +
                                    " ID: " + resultSetMarketing.getInt(4) +
                                    " Level: " + resultSetMarketing.getInt(5));
                        }
                        System.out.println("Enter id of Marketing");
                        int idMarketing = scanner.nextInt();
                        if (idMarketing == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','Marketing','500000','2') ");
                        } else if (idMarketing == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','Marketing','400000','2') ");
                        }
                        else if (idMarketing == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '3','Marketing','300000','1') ");
                        }

                        boolean flagMarketing= true;
                        while (flagMarketing) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerMarketing = scanner.nextInt();
                            switch (answerMarketing) {
                                case 1:
                                    System.out.println("Enter id of Marketing ");
                                    int idMarketing1 = scanner.nextInt();
                                    if (idMarketing1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','Marketing','500000','2') ");
                                    }
                                    else if (idMarketing1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','Marketing','400000','2') ");
                                    }
                                    else if (idMarketing1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '3','Marketing','300000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagMarketing = false;
                                    break;
                            }
                        }
                    }
                    else if(peroid==12){
                        System.out.println("Choose Accountance");
                        ResultSet resultSetAccountance = statement.executeQuery("SELECT * FROM accounting");
                        while (resultSetAccountance.next()) {
                            System.out.println("Name: " + resultSetAccountance.getString(2) +
                                    " Salary: " + resultSetAccountance.getString(3) +
                                    " ID: " + resultSetAccountance.getInt(4) +
                                    " Level: " + resultSetAccountance.getInt(5));
                        }
                        System.out.println("Enter id of accountance ");
                        int idAccountance = scanner.nextInt();
                        if (idAccountance == 1) {
                            System.out.println("Enter the period of accountance");
                            statement.executeUpdate("UPDATE project SET period = '4'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '1'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '100000'");
                            statement.executeUpdate("UPDATE project SET level = '2'");
                        } else if (idAccountance == 2) {
                            System.out.println("Enter the period of accountance");
                            statement.executeUpdate("UPDATE project SET period = '4'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '2'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '200000'");
                            statement.executeUpdate("UPDATE project SET level = '1'");
                        }
                        else if (idAccountance == 3) {
                            System.out.println("Enter the period of accountance");
                            statement.executeUpdate("UPDATE project SET period = '4'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '2'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '200000'");
                            statement.executeUpdate("UPDATE project SET level = '1'");
                        }
                        boolean flagAccountance = true;
                        while (flagAccountance) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerAccountance = scanner.nextInt();
                            switch (answerAccountance) {
                                case 1:
                                    System.out.println("Enter id of accountance ");
                                    int idAccountance1 = scanner.nextInt();
                                    if (idAccountance1 == 1) {
                                        statement.executeUpdate("UPDATE project SET period = '4'");
                                        statement.executeUpdate("UPDATE project SET idOfWorkers = '1'");
                                        statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                                        statement.executeUpdate("UPDATE project SET salary = '100000'");
                                        statement.executeUpdate("UPDATE project SET level = '2'");
                                    } else if (idAccountance1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '2','Accountance','200000','1') ");
                                    }
                                    else if(idAccountance1 == 3){
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '3','Accountance','300000','1') ");
                                    }
                                    break;
                                case 2:
                                    flagAccountance = false;
                                    break;
                            }
                        }
//---------------------------ACCOUNTANCE -------------------------------------------------

//---------------------------PROJECT MANAGER-------------------------------------------------
                        System.out.println("Choose Project Manager");
                        ResultSet resultSetProjectManager = statement.executeQuery("SELECT * FROM management");
                        while (resultSetProjectManager.next()) {
                            System.out.println("Name: " + resultSetProjectManager.getString(2) +
                                    " Salary: " + resultSetProjectManager.getString(3) +
                                    " ID: " + resultSetProjectManager.getInt(4) +
                                    " Level: " + resultSetProjectManager.getInt(5));
                        }
                        System.out.println("Enter id of Project Manager");
                        int idProjectManager = scanner.nextInt();
                        if (idProjectManager == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '1','Project Manager','100000','2') ");
                        } else if (idProjectManager == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '2','Project Manager','200000','1') ");
                        }
                        else if (idProjectManager == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '3','Project Manager','300000','2') ");
                        }

                        boolean flagProjectManager = true;
                        while (flagProjectManager) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerProjectManager = scanner.nextInt();
                            switch (answerProjectManager) {
                                case 1:
                                    System.out.println("Enter id of Project Manager ");
                                    int idProjectManager1 = scanner.nextInt();
                                    if (idProjectManager1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '1','Project Manager','100000','2') ");
                                    } else if (idProjectManager1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '2','Project Manager','200000','1') ");
                                    }
                                    else if(idProjectManager1 == 3){
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '3','Project Manager','300000','2') ");
                                    }
                                    break;
                                case 2:
                                    flagProjectManager = false;
                                    break;
                            }
                        }
//---------------------------PROJECT MANAGER-------------------------------------------------

//---------------------------Lawyer-------------------------------------------------
                        System.out.println("Choose Lawyer");
                        ResultSet resultSetLawyer = statement.executeQuery("SELECT * FROM judicial");
                        while (resultSetLawyer.next()) {
                            System.out.println("Name: " + resultSetLawyer.getString(2) +
                                    " Salary: " + resultSetLawyer.getString(3) +
                                    " ID: " + resultSetLawyer.getInt(4) +
                                    " Level: " + resultSetLawyer.getInt(5));
                        }
                        System.out.println("Enter id of Lawyer");
                        int idLawyer = scanner.nextInt();
                        if (idLawyer == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','Lawyer','500000','2') ");
                        } else if (idLawyer == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','Lawyer','400000','1') ");
                        }


                        boolean flagLawyer = true;
                        while (flagLawyer) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerLawyer = scanner.nextInt();
                            switch (answerLawyer) {
                                case 1:
                                    System.out.println("Enter id of Lawyer ");
                                    int idLawyer1 = scanner.nextInt();
                                    if (idLawyer1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','Lawyer','500000','2') ");
                                    } else if (idLawyer1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','Lawyer','400000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagLawyer = false;
                                    break;
                            }
                        }
//---------------------------Lawyer-------------------------------------------------

//---------------------------HR-------------------------------------------------
                        System.out.println("Choose HR");
                        ResultSet resultSetHR = statement.executeQuery("SELECT * FROM hr");
                        while (resultSetHR.next()) {
                            System.out.println("Name: " + resultSetHR.getString(2) +
                                    " Salary: " + resultSetHR.getString(3) +
                                    " ID: " + resultSetHR.getInt(4) +
                                    " Level: " + resultSetHR.getInt(5));
                        }
                        System.out.println("Enter id of HR");
                        int idHR = scanner.nextInt();
                        if (idHR == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '1', '1','HR','300000','2') ");
                        } else if (idHR == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '1', '2','HR','200000','1') ");
                        }

                        boolean flagHR= true;
                        while (flagHR) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerHR = scanner.nextInt();
                            switch (answerHR) {
                                case 1:
                                    System.out.println("Enter id of HR ");
                                    int idHR1 = scanner.nextInt();
                                    if (idHR1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '1', '1','HR','300000','2') ");
                                    } else if (idHR1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '1', '2','HR','200000','1') ");
                                    }
                                    break;
                                case 2:
                                    flagHR = false;
                                    break;
                            }
                        }
//---------------------------HR-------------------------------------------------

//---------------------------ANALYST-------------------------------------------------
                        System.out.println("Choose Analyst");
                        ResultSet resultSetAnalyst = statement.executeQuery("SELECT * FROM analyst");
                        while (resultSetAnalyst.next()) {
                            System.out.println("Name: " + resultSetAnalyst.getString(2) +
                                    " Salary: " + resultSetAnalyst.getString(3) +
                                    " ID: " + resultSetAnalyst.getInt(4) +
                                    " Level: " + resultSetAnalyst.getInt(5));
                        }
                        System.out.println("Enter id of Analyst");
                        int idAnalyst = scanner.nextInt();
                        if (idAnalyst == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '1','Analyst','500000','1') ");
                        } else if (idAnalyst == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '2','Analyst','400000','2') ");
                        }
                        else if (idAnalyst == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '3','Analyst','300000','2') ");
                        }

                        boolean flagAnalyst= true;
                        while (flagAnalyst) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerAnalyst = scanner.nextInt();
                            switch (answerAnalyst) {
                                case 1:
                                    System.out.println("Enter id of Analyst ");
                                    int idAnalyst1 = scanner.nextInt();
                                    if (idAnalyst1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '1','Analyst','500000','1') ");
                                    } else if (idAnalyst1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '2','Analyst','400000','2') ");
                                    }
                                    else if (idAnalyst1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '3','Analyst','300000','2') ");
                                    }
                                    break;
                                case 2:
                                    flagAnalyst = false;
                                    break;
                            }
                        }
//---------------------------ANALYST-------------------------------------------------

//---------------------------BACKEND-------------------------------------------------
                        System.out.println("Choose Backend");
                        ResultSet resultSetBackend = statement.executeQuery("SELECT * FROM backend");
                        while (resultSetBackend.next()) {
                            System.out.println("Name: " + resultSetBackend.getString(2) +
                                    " Salary: " + resultSetBackend.getString(3) +
                                    " ID: " + resultSetBackend.getInt(4) +
                                    " Level: " + resultSetBackend.getInt(5));
                        }
                        System.out.println("Enter id of Backend");
                        int idBackend = scanner.nextInt();
                        if (idBackend == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '1','Backend','700000','1') ");
                        } else if (idBackend == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '2','Backend','600000','2') ");
                        }
                        else if (idBackend == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '3','Backend','500000','1') ");
                        }
                        else if (idBackend == 4) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '4','Backend','400000','2') ");
                        }
                        else if (idBackend == 5) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '5','Backend','300000','1') ");
                        }
                        else if (idBackend == 6) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '6','Backend','200000','2') ");
                        }


                        boolean flagBackend = true;
                        while (flagBackend) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerBackend = scanner.nextInt();
                            switch (answerBackend) {
                                case 1:
                                    System.out.println("Enter id of Backend ");
                                    int idBackend1 = scanner.nextInt();
                                    if (idBackend1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '1','Backend','700000','1') ");
                                    } else if (idBackend1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '2','Backend','600000','2') ");
                                    }
                                    else if (idBackend1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '3','Backend','500000','1') ");
                                    }
                                    else if (idBackend1 == 4) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '4','Backend','400000','2') ");
                                    }
                                    else if (idBackend1 == 5) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '5','Backend','300000','1') ");
                                    }
                                    else if (idBackend1 == 6) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '8', '6','Backend','200000','2') ");
                                    }

                                    break;
                                case 2:
                                    flagBackend = false;
                                    break;
                            }
                        }
//---------------------------BACKEND-------------------------------------------------

//---------------------------FRONTEND-------------------------------------------------
                        System.out.println("Choose Frontend");
                        ResultSet resultSetFrontend = statement.executeQuery("SELECT * FROM frontend");
                        while (resultSetFrontend.next()) {
                            System.out.println("Name: " + resultSetFrontend.getString(2) +
                                    " Salary: " + resultSetFrontend.getString(3) +
                                    " ID: " + resultSetFrontend.getInt(4) +
                                    " Level: " + resultSetFrontend.getInt(5));
                        }
                        System.out.println("Enter id of Frontend");
                        int idFrontend = scanner.nextInt();
                        if (idFrontend == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '1','Frontend','300000','2') ");
                        } else if (idFrontend == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '2','Frontend','200000','1') ");
                        }
                        else if (idFrontend == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '3','Frontend','400000','2') ");
                        }
                        else if (idFrontend == 4) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '4','Frontend','500000','1') ");
                        }
                        else if (idFrontend == 5) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '5','Frontend','700000','2') ");
                        }
                        else if (idFrontend == 6) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '6','Frontend','600000','1') ");
                        }


                        boolean flagFrontend = true;
                        while (flagFrontend) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerFrontend = scanner.nextInt();
                            switch (answerFrontend) {
                                case 1:
                                    System.out.println("Enter id of Frontend ");
                                    int idFrontend1 = scanner.nextInt();
                                    if (idFrontend1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '1','Frontend','300000','2') ");
                                    } else if (idFrontend1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '2','Frontend','200000','1') ");
                                    }
                                    else if (idFrontend1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '3','Frontend','400000','2') ");
                                    }
                                    else if (idFrontend1 == 4) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '4','Frontend','500000','1') ");
                                    }
                                    else if (idFrontend1 == 5) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '5','Frontend','700000','2') ");
                                    }
                                    else if (idFrontend1 == 6) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '6','Frontend','600000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagFrontend = false;
                                    break;
                            }
                        }
//---------------------------FRONTEND-------------------------------------------------

//---------------------------MARKETING-------------------------------------------------
                        System.out.println("Choose Marketing");
                        ResultSet resultSetMarketing = statement.executeQuery("SELECT * FROM marketing");
                        while (resultSetMarketing.next()) {
                            System.out.println("Name: " + resultSetMarketing.getString(2) +
                                    " Salary: " + resultSetMarketing.getString(3) +
                                    " ID: " + resultSetMarketing.getInt(4) +
                                    " Level: " + resultSetMarketing.getInt(5));
                        }
                        System.out.println("Enter id of Marketing");
                        int idMarketing = scanner.nextInt();
                        if (idMarketing == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Marketing','500000','2') ");
                        } else if (idMarketing == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Marketing','400000','2') ");
                        }
                        else if (idMarketing == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '3','Marketing','300000','1') ");
                        }

                        boolean flagMarketing= true;
                        while (flagMarketing) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerMarketing = scanner.nextInt();
                            switch (answerMarketing) {
                                case 1:
                                    System.out.println("Enter id of Marketing ");
                                    int idMarketing1 = scanner.nextInt();
                                    if (idMarketing1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Marketing','500000','2') ");
                                    }
                                    else if (idMarketing1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Marketing','400000','2') ");
                                    }
                                    else if (idMarketing1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '3','Marketing','300000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagMarketing = false;
                                    break;
                            }
                        }

                    }
                    else if(peroid==18){System.out.println("Choose Accountance");
                        ResultSet resultSetAccountance = statement.executeQuery("SELECT * FROM accounting");
                        while (resultSetAccountance.next()) {
                            System.out.println("Name: " + resultSetAccountance.getString(2) +
                                    " Salary: " + resultSetAccountance.getString(3) +
                                    " ID: " + resultSetAccountance.getInt(4) +
                                    " Level: " + resultSetAccountance.getInt(5));
                        }
                        System.out.println("Enter id of accountance ");
                        int idAccountance = scanner.nextInt();
                        if (idAccountance == 1) {
                            statement.executeUpdate("UPDATE project SET period = '6'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '1'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '100000'");
                            statement.executeUpdate("UPDATE project SET level = '2'");
                        } else if (idAccountance == 2) {
                            System.out.println("Enter the period of accountance");
                            statement.executeUpdate("UPDATE project SET period = '6'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '2'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '200000'");
                            statement.executeUpdate("UPDATE project SET level = '1'");
                        }
                        else if (idAccountance == 3) {
                            System.out.println("Enter the period of accountance");
                            statement.executeUpdate("UPDATE project SET period = '6'");
                            statement.executeUpdate("UPDATE project SET idOfWorkers = '2'");
                            statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                            statement.executeUpdate("UPDATE project SET salary = '200000'");
                            statement.executeUpdate("UPDATE project SET level = '1'");
                        }
                        boolean flagAccountance = true;
                        while (flagAccountance) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerAccountance = scanner.nextInt();
                            switch (answerAccountance) {
                                case 1:
                                    System.out.println("Enter id of accountance ");
                                    int idAccountance1 = scanner.nextInt();
                                    if (idAccountance1 == 1) {
                                        statement.executeUpdate("UPDATE project SET period = '6'");
                                        statement.executeUpdate("UPDATE project SET idOfWorkers = '1'");
                                        statement.executeUpdate("UPDATE project SET Workers = 'Accountance'");
                                        statement.executeUpdate("UPDATE project SET salary = '100000'");
                                        statement.executeUpdate("UPDATE project SET level = '2'");
                                    } else if (idAccountance1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '2','Accountance','200000','1') ");
                                    }
                                    else if(idAccountance1 == 3){
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '6', '3','Accountance','300000','1') ");
                                    }
                                    break;
                                case 2:
                                    flagAccountance = false;
                                    break;
                            }
                        }
//---------------------------ACCOUNTANCE -------------------------------------------------

//---------------------------PROJECT MANAGER-------------------------------------------------
                        System.out.println("Choose Project Manager");
                        ResultSet resultSetProjectManager = statement.executeQuery("SELECT * FROM management");
                        while (resultSetProjectManager.next()) {
                            System.out.println("Name: " + resultSetProjectManager.getString(2) +
                                    " Salary: " + resultSetProjectManager.getString(3) +
                                    " ID: " + resultSetProjectManager.getInt(4) +
                                    " Level: " + resultSetProjectManager.getInt(5));
                        }
                        System.out.println("Enter id of Project Manager");
                        int idProjectManager = scanner.nextInt();
                        if (idProjectManager == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '18', '1','Project Manager','100000','2') ");
                        } else if (idProjectManager == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '18', '2','Project Manager','200000','1') ");
                        }
                        else if (idProjectManager == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '18', '3','Project Manager','300000','2') ");
                        }

                        boolean flagProjectManager = true;
                        while (flagProjectManager) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerProjectManager = scanner.nextInt();
                            switch (answerProjectManager) {
                                case 1:
                                    System.out.println("Enter id of Project Manager ");
                                    int idProjectManager1 = scanner.nextInt();
                                    if (idProjectManager1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '18', '1','Project Manager','100000','2') ");
                                    } else if (idProjectManager1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', ' 18', '2','Project Manager','200000','1') ");
                                    }
                                    else if(idProjectManager1 == 3){
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '18', '3','Project Manager','300000','2') ");
                                    }
                                    break;
                                case 2:
                                    flagProjectManager = false;
                                    break;
                            }
                        }
//---------------------------PROJECT MANAGER-------------------------------------------------

//---------------------------Lawyer-------------------------------------------------
                        System.out.println("Choose Lawyer");
                        ResultSet resultSetLawyer = statement.executeQuery("SELECT * FROM judicial");
                        while (resultSetLawyer.next()) {
                            System.out.println("Name: " + resultSetLawyer.getString(2) +
                                    " Salary: " + resultSetLawyer.getString(3) +
                                    " ID: " + resultSetLawyer.getInt(4) +
                                    " Level: " + resultSetLawyer.getInt(5));
                        }
                        System.out.println("Enter id of Lawyer");
                        int idLawyer = scanner.nextInt();
                        if (idLawyer == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Lawyer','500000','2') ");
                        } else if (idLawyer == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Lawyer','400000','1') ");
                        }


                        boolean flagLawyer = true;
                        while (flagLawyer) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerLawyer = scanner.nextInt();
                            switch (answerLawyer) {
                                case 1:
                                    System.out.println("Enter id of Lawyer ");
                                    int idLawyer1 = scanner.nextInt();
                                    if (idLawyer1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '1','Lawyer','500000','2') ");
                                    } else if (idLawyer1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '3', '2','Lawyer','400000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagLawyer = false;
                                    break;
                            }
                        }
//---------------------------Lawyer-------------------------------------------------

//---------------------------HR-------------------------------------------------
                        System.out.println("Choose HR");
                        ResultSet resultSetHR = statement.executeQuery("SELECT * FROM hr");
                        while (resultSetHR.next()) {
                            System.out.println("Name: " + resultSetHR.getString(2) +
                                    " Salary: " + resultSetHR.getString(3) +
                                    " ID: " + resultSetHR.getInt(4) +
                                    " Level: " + resultSetHR.getInt(5));
                        }
                        System.out.println("Enter id of HR");
                        int idHR = scanner.nextInt();
                        if (idHR == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','HR','300000','2') ");
                        } else if (idHR == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','HR','200000','1') ");
                        }

                        boolean flagHR= true;
                        while (flagHR) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerHR = scanner.nextInt();
                            switch (answerHR) {
                                case 1:
                                    System.out.println("Enter id of HR ");
                                    int idHR1 = scanner.nextInt();
                                    if (idHR1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '1','HR','300000','2') ");
                                    } else if (idHR1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '2', '2','HR','200000','1') ");
                                    }
                                    break;
                                case 2:
                                    flagHR = false;
                                    break;
                            }
                        }
//---------------------------HR-------------------------------------------------

//---------------------------ANALYST-------------------------------------------------
                        System.out.println("Choose Analyst");
                        ResultSet resultSetAnalyst = statement.executeQuery("SELECT * FROM analyst");
                        while (resultSetAnalyst.next()) {
                            System.out.println("Name: " + resultSetAnalyst.getString(2) +
                                    " Salary: " + resultSetAnalyst.getString(3) +
                                    " ID: " + resultSetAnalyst.getInt(4) +
                                    " Level: " + resultSetAnalyst.getInt(5));
                        }
                        System.out.println("Enter id of Analyst");
                        int idAnalyst = scanner.nextInt();
                        if (idAnalyst == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '1','Analyst','500000','1') ");
                        } else if (idAnalyst == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '2','Analyst','400000','2') ");
                        }
                        else if (idAnalyst == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '3','Analyst','300000','2') ");
                        }

                        boolean flagAnalyst= true;
                        while (flagAnalyst) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerAnalyst = scanner.nextInt();
                            switch (answerAnalyst) {
                                case 1:
                                    System.out.println("Enter id of Analyst ");
                                    int idAnalyst1 = scanner.nextInt();
                                    if (idAnalyst1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '1','Analyst','500000','1') ");
                                    } else if (idAnalyst1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '2','Analyst','400000','2') ");
                                    }
                                    else if (idAnalyst1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '3','Analyst','300000','2') ");
                                    }
                                    break;
                                case 2:
                                    flagAnalyst = false;
                                    break;
                            }
                        }
//---------------------------ANALYST-------------------------------------------------

//---------------------------BACKEND-------------------------------------------------
                        System.out.println("Choose Backend");
                        ResultSet resultSetBackend = statement.executeQuery("SELECT * FROM backend");
                        while (resultSetBackend.next()) {
                            System.out.println("Name: " + resultSetBackend.getString(2) +
                                    " Salary: " + resultSetBackend.getString(3) +
                                    " ID: " + resultSetBackend.getInt(4) +
                                    " Level: " + resultSetBackend.getInt(5));
                        }
                        System.out.println("Enter id of Backend");
                        int idBackend = scanner.nextInt();
                        if (idBackend == 1) {
                            System.out.println("Enter the period of Backend");
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '1','Backend','700000','1') ");
                        } else if (idBackend == 2) {
                            System.out.println("Enter the period of Backend");
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '2','Backend','600000','2') ");
                        }
                        else if (idBackend == 3) {
                            System.out.println("Enter the period of Backend");
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '3','Backend','500000','1') ");
                        }
                        else if (idBackend == 4) {
                            System.out.println("Enter the period of Backend");
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '4','Backend','400000','2') ");
                        }
                        else if (idBackend == 5) {
                            System.out.println("Enter the period of Backend");
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '5','Backend','300000','1') ");
                        }
                        else if (idBackend == 6) {
                            System.out.println("Enter the period of Backend");
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '6','Backend','200000','2') ");
                        }


                        boolean flagBackend = true;
                        while (flagBackend) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerBackend = scanner.nextInt();
                            switch (answerBackend) {
                                case 1:
                                    System.out.println("Enter id of Backend ");
                                    int idBackend1 = scanner.nextInt();
                                    if (idBackend1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '1','Backend','700000','1') ");
                                    } else if (idBackend1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '2','Backend','600000','2') ");
                                    }
                                    else if (idBackend1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '3','Backend','500000','1') ");
                                    }
                                    else if (idBackend1 == 4) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '4','Backend','400000','2') ");
                                    }
                                    else if (idBackend1 == 5) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '5','Backend','300000','1') ");
                                    }
                                    else if (idBackend1 == 6) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '12', '6','Backend','200000','2') ");
                                    }

                                    break;
                                case 2:
                                    flagBackend = false;
                                    break;
                            }
                        }
//---------------------------BACKEND-------------------------------------------------

//---------------------------FRONTEND-------------------------------------------------
                        System.out.println("Choose Frontend");
                        ResultSet resultSetFrontend = statement.executeQuery("SELECT * FROM frontend");
                        while (resultSetFrontend.next()) {
                            System.out.println("Name: " + resultSetFrontend.getString(2) +
                                    " Salary: " + resultSetFrontend.getString(3) +
                                    " ID: " + resultSetFrontend.getInt(4) +
                                    " Level: " + resultSetFrontend.getInt(5));
                        }
                        System.out.println("Enter id of Frontend");
                        int idFrontend = scanner.nextInt();
                        if (idFrontend == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '1','Frontend','300000','2') ");
                        } else if (idFrontend == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '2','Frontend','200000','1') ");
                        }
                        else if (idFrontend == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '3','Frontend','400000','2') ");
                        }
                        else if (idFrontend == 4) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '4','Frontend','500000','1') ");
                        }
                        else if (idFrontend == 5) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '5','Frontend','700000','2') ");
                        }
                        else if (idFrontend == 6) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '6','Frontend','600000','1') ");
                        }


                        boolean flagFrontend = true;
                        while (flagFrontend) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerFrontend = scanner.nextInt();
                            switch (answerFrontend) {
                                case 1:
                                    System.out.println("Enter id of Frontend ");
                                    int idFrontend1 = scanner.nextInt();
                                    if (idFrontend1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '1','Frontend','300000','2') ");
                                    } else if (idFrontend1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '2','Frontend','200000','1') ");
                                    }
                                    else if (idFrontend1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '3','Frontend','400000','2') ");
                                    }
                                    else if (idFrontend1 == 4) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '4','Frontend','500000','1') ");
                                    }
                                    else if (idFrontend1 == 5) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '5','Frontend','700000','2') ");
                                    }
                                    else if (idFrontend1 == 6) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '9', '6','Frontend','600000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagFrontend = false;
                                    break;
                            }
                        }
//---------------------------FRONTEND-------------------------------------------------

//---------------------------MARKETING-------------------------------------------------
                        System.out.println("Choose Marketing");
                        ResultSet resultSetMarketing = statement.executeQuery("SELECT * FROM marketing");
                        while (resultSetMarketing.next()) {
                            System.out.println("Name: " + resultSetMarketing.getString(2) +
                                    " Salary: " + resultSetMarketing.getString(3) +
                                    " ID: " + resultSetMarketing.getInt(4) +
                                    " Level: " + resultSetMarketing.getInt(5));
                        }
                        System.out.println("Enter id of Marketing");
                        int idMarketing = scanner.nextInt();
                        if (idMarketing == 1) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '1','Marketing','500000','2') ");
                        } else if (idMarketing == 2) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '2','Marketing','400000','2') ");
                        }
                        else if (idMarketing == 3) {
                            statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '3','Marketing','300000','1') ");
                        }

                        boolean flagMarketing= true;
                        while (flagMarketing) {
                            System.out.println("Do you want to add one more?");
                            System.out.print("1. Yes\n" +
                                    "2. No \n");
                            int answerMarketing = scanner.nextInt();
                            switch (answerMarketing) {
                                case 1:
                                    System.out.println("Enter id of Marketing ");
                                    int idMarketing1 = scanner.nextInt();
                                    if (idMarketing1 == 1) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '1','Marketing','500000','2') ");
                                    }
                                    else if (idMarketing1 == 2) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '2','Marketing','400000','2') ");
                                    }
                                    else if (idMarketing1 == 3) {
                                        statement.executeUpdate("INSERT INTO project(name, period, idOfWorkers,Workers,salary,level) VALUES (' " + name + "', '4', '3','Marketing','300000','1') ");
                                    }

                                    break;
                                case 2:
                                    flagMarketing = false;
                                    break;
                            }
                        }

                    }
                    else{
                        System.out.println("Error function");
                    }




//---------------------------ACCOUNTANCE -------------------------------------------------

//---------------------------MARKETING-------------------------------------------------



                    break;
                case 3:

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    statement.executeUpdate("UPDATE project SET total = salary * period");
                    ResultSet resultSet100 = statement.executeQuery("SELECT Sum(total) FROM project");
                    while (resultSet100.next()) {
                        System.out.println("Total cost is: " + resultSet100.getString(1) + "тенге");
                    }
                    ResultSet resultSet02 = statement.executeQuery("SELECT Max(period ) FROM project");
                    while (resultSet02.next()) {
                        System.out.println("Project period  is: " + resultSet02.getString(1) + " month");
                    }


                    Class.forName("com.mysql.cj.jdbc.Driver");
                    ResultSet resultSet1000 = statement.executeQuery("SELECT * FROM project");
                    System.out.println("name \t\t period \t\t Workers \t\t\t\t salary \t\t\t level \t\t\t total");
                    while (resultSet1000.next()) {
                        System.out.println(resultSet1000.getString(2) + "\t\t " +
                                resultSet1000.getInt(3) + "\t\t\t" +
                                resultSet1000.getString(5) + "\t\t\t\t\t"  +
                                resultSet1000.getString(6) + "\t\t\t\t" +
                                resultSet1000.getInt(7) + "\t\t\t\t\t" +
                                resultSet1000.getString(8) + "\n");
                    }

                    break;
                default:
                    System.out.println("Error");

            }
        }
    }
}