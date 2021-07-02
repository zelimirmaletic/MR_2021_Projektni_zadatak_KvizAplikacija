package com.example.kvizologapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.kvizologapp.data.model.Pitanje;

public class PopulateDatabaseService extends Service {
    public PopulateDatabaseService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        //Run insert functions for all questions
        //PITANJA - GLAVNI GRADOVI
        Pitanje pitanje1 = new Pitanje(1,"Russia","Moscow","London","Kiev","Vladivostok", "Русија","Москва","Лондон","Кијев","Владивосток", "Moscow","Москва","Red square","Црвени трг","NO_IMAGE");
        Pitanje pitanje2 = new Pitanje(1,"Slovenia","Maribor","Ljubljana","Skopje","Belgrade", "Словенија","Марибор","Љубљана","Скопље","Београд", "Ljubljana","Љубљана","Dragon is the most recognizable symbol.","Најпрепознатљивији сибол града је змај.","NO_IMAGE");
        Pitanje pitanje3 = new Pitanje(1,"Serbia","Skopje","Blegrade","Novi Sad","Trebinje","Србија","Скопље","Београд","Нови Сад","Требиње","Belgrade","Београд","Biggest orthodox church in the Balkans","Највећа православна црква на Балкану","NO_IMAGE");
        Pitanje pitanje4 = new Pitanje(1, "United Kingdom","London","Berlin","Edinburg","Paris","Уједињено Краљевств","Лондон","Берлин","Единбург","Париз","London","Лондон","Big eye.","Велико око.","NO_IMAGE");
        Pitanje pitanje5 = new Pitanje(1,"Germany", "Hamburg","Berlin","Hanover","Munch","Њемачка","Хамбург","Берлин","Минхен","Хановер","Berlin","Берлин","Used to be divided by a wall.","Био је подијељен зидом.","NO_IMAGE");
        Pitanje pitanje6 = new Pitanje(1,"Greece","Heraklion","Athens","Thessaloniki","Berlin","Грчка","Херклион","Атина","Тесалоники","Берлин","Athens","Атина","Partenon","Партенон","NO_IMAGE");
        //INSERT TYPE 2 QUESTIONS
        Pitanje pitanje21 = new Pitanje(2,"","GREECE","","","","ГРЧКА","","","","","","","","","ic_greece");
        //INSERT TYPE 3 QUESTIONS

        //INSERT TYPE 4 QUESTIONS

    }
}