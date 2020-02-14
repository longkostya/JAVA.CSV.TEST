package com.dolgiy.test_question;

import com.dolgiy.test_question.entities.Event;
import com.dolgiy.test_question.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Component
public class TestQuestionApplication implements CommandLineRunner{

	@Autowired
	private EventService eventService;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(TestQuestionApplication.class, args);		//точка входа в spring-приложение
	}

	private static String[] splitText(String text){						//в некоторых URL-ах есть ";", костыль, но работает!
		List <String> splitedText = new ArrayList<String>();			//вспомогательный список
		String[] rezult = new String[12];								//результат сплита - 12 строк
		int sepCount=0;
		for (int i=0;i<text.length();i++)
		{
			if (text.charAt(i)==';')
				sepCount++;												//считаю количество разделителей в строке
		}
		if (sepCount==11) { rezult = text.split(";", 12); } //если их 11, то в URL ";" нет и использую обычный сплит
		else{
			String[] _splitedText = text.split(";", 6);		//спличу строку ДО URL,
			for(int i=0;i<5;i++)										//первые 5 подстрок не трогааю,
			{
				splitedText.add(_splitedText[i]);						//идут в вспомогательный массив
			}
																		//остальные подстроки остаются "склеенными"
			String[] _rightPart = _splitedText[5].split(";");	//спличу по ;
			int _rightSize= _rightPart.length;							//
			String Url="";
			for(int i=0;i<_rightPart.length-6;i++)						//выделяю границы подстроки, содержащей URL
			{
				Url+=_rightPart[i];										//склеиваю URl
			}
			splitedText.add(Url);										//добавляю URL в вспомогательный список
			for(int i=6;i>0;i--)
			{
				splitedText.add(_rightPart[_rightSize-i]);				//добавляю в вспомогательный список оставшиеся подстроки
			}
			for(int i=0;i<12;i++)
			{
				rezult[i]=splitedText.get(i);							//перекидываю подстроки из списка в массив
			}
		}
		return rezult;

	}


	private static List<Event> ParseEventCsv(String filePath) throws IOException{	//Функция, парсящая csv

		List <Event> listOfEvents = new ArrayList<Event>();							//Список событий
		List<String>fileLines =  Files.readAllLines(Paths.get(filePath));			//Список всех строк в csv-файле

		for(int i=1;i<fileLines.size();i++){// String  fileLine:fileLines){			//1-ую строку не читаю, т.к. в ней названия полей
			String[] splitedText=splitText(fileLines.get(i));						//массив с найденными подстроками

		Event event = new Event();													//создаю экземпляр класса Event
		event.setSsoid(splitedText[0]);												//передаю в качестве полей полученные подстроки
		event.setTs(Integer.parseInt(splitedText[1]));								//конверт из стринг в инт
		event.setGrp(splitedText[2]);
		event.setType(splitedText[3]);
		event.setSubtype(splitedText[4]);
		event.setUrl(splitedText[5]);
		event.setOrgid(splitedText[6]);
		event.setFormid(splitedText[7]);
		event.setCode(splitedText[8]);
		event.setLtpa(splitedText[9]);
		event.setSudirresponce(splitedText[10]);
		String[]splitedData=splitedText[11].split("-",4);				//разбиваю дату на массив [год, месяц, день, час]
		LocalDateTime tempData = LocalDateTime.of(Integer.parseInt(splitedData[0]), //хитрое приведение к нужному формату даты
											      Integer.parseInt(splitedData[1]),
												  Integer.parseInt(splitedData[2]),
												  Integer.parseInt(splitedData[3]),
																		0);
		Timestamp rezultData = Timestamp.valueOf(tempData);
		event.setYmdh(rezultData);
		listOfEvents.add(event);													//закидываю полученный экземпляр в список
		}
		return listOfEvents;														//возвращаю список экземпляров Event
	}

	@Override
	public void run(String... args) throws Exception {
		String filePath = "src/main/resources/test_case.csv";						//Путь до файла
		//List<Event> listOfEvents = ParseEventCsv(filePath);							//список экземпляров, полученных из файла csv
		//for (Event event : listOfEvents)
		//System.out.println(listOfEvents.get(i));
		{
			//Event save = eventService.addEvent(event);										//каждый экземпляр отправляем в БД
		}

		//List<Event> K = eventDao.findSsoid();
		//for(Event a:K) {System.out.print(a);}
		//List<Event> eventList = eventService.getEventInfoBySsoid("7693d80e-cd53-4534-8e2c-302de95a750f");
		//for (Event a: eventList) System.out.print(a);
		//List<String> z = eventService.getUserWho();
		//for (String a: z) System.out.println(a);
	}
}