package com.dolgiy.test_question;

import com.dolgiy.test_question.entities.Event;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TestQuestionApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestQuestionApplication.class, args);		//точка входа в spring-приложение
		String filePath = "src/main/resources/test_case.csv";			//Путь до файла
		List<Event> listOfEvents = ParseEventCsv(filePath);				//вызов функции
		//for(int i=0;i<5;i++)
		//System.out.println(listOfEvents.get(i));
	}
	private static List<Event> ParseEventCsv(String filePath) throws IOException{	//Функция, парсящая csv

		List <Event> listOfEvents = new ArrayList<Event>();
		List<String>fileLines =  Files.readAllLines(Paths.get(filePath));
		for(String  fileLine:fileLines){
			String[] splitedText=fileLine.split(";",12);
			ArrayList<String> columnList = new ArrayList<String>();
				for (int i =0 ; i < splitedText.length;i++){
					columnList.add(splitedText[i]);
				}
		Event event = new Event();
		event.setSsoid(columnList.get(0));
		event.setTs(columnList.get(1));
		event.setGrp(columnList.get(2));
		event.setType(columnList.get(3));
		event.setSubtype(columnList.get(4));
		event.setUrl(columnList.get(5));
		event.setOrgid(columnList.get(6));
		event.setFormid(columnList.get(7));
		event.setCode(columnList.get(8));
		event.setLtpa(columnList.get(9));
		event.setSudirresponce(columnList.get(10));
		event.setYmdh(columnList.get(11));
		listOfEvents.add(event);

		}
		return listOfEvents;
	}


}
