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

        //PITANJA - ZASTAVE
        Pitanje pitanje21 = new Pitanje(2,"","GREECE","","","","ГРЧКА","","","","","","","Birthplace of philosopy...","Родно мјесто философије...","ic_greece");
        Pitanje pitanje22 = new Pitanje(2,"","SERBIA","","","","СРБИЈА","","","","","","","","","ic_serbia");
        Pitanje pitanje23 = new Pitanje(2,"","BHUTAN","","","","БУТАН","","","","","","","","","ic_bhutan");
        Pitanje pitanje24 = new Pitanje(2,"","JAPAN","","","","ЈАПАН","","","","","","","","","ic_japan");
        Pitanje pitanje25 = new Pitanje(2,"","SPAIN","","","","ШПАНИЈА","","","","","","","","","ic_spain");
        Pitanje pitanje26 = new Pitanje(2,"","BANGLADESH","","","","БАНГЛАДЕШ","","","","","","","","","ic_bangladesh");
        Pitanje pitanje27 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje28 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje29 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje30 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje31 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje32 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje33 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje34 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje35 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje36 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje37 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje38 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje39 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje40 = new Pitanje(4,"","","","","","","","","","","","","","","");

        //INSERT TYPE 3 QUESTIONS
        Pitanje pitanje41 = new Pitanje(3,"Russia","Germany","China","Estonia","Ukraine","Русија","Њемачка","Кина","Украјина","Естонија","China:Estonia:Ukraine","Кина:Естониа:Украјина","One Baltic country is a neigbour.","Једна балтичка земља је сусједна","NO_IMAGE");
        Pitanje pitanje42 = new Pitanje(3, "Germany","Russia","Austria","Poland","Switzerland","Њемачка","Русија","Аустрија","Пољаска","Швајцарска","Austria:Switzerland","Аустрија:Швајцарска","German speaking countries.","Државе њемачког говорног подручја.","NO_IMAGE");
        Pitanje pitanje43 = new Pitanje(3,"France","Switzerland","Spain","Germany","Italy","Француска","Швајцарска","Шпанија","Њемачка","Италија","Switzerland:Spain:Germany:Italy","Швајцарска:Шпанија:Њемачка:Италија","One of them is a birthplace of esspresso coffee","Једна од земаља је родно мјесто еспресо кафе","NO_IMAGE");
        Pitanje pitanje44 = new Pitanje(3, "Chad","Egypt","Sudan","Ethiopia","Nigeria","Чад","Египт","Судан","Етиопија","Нигерија","Sudan:Nigeria","Судан:Нигерија","Country hierogliphes is not a neigbouring country","Земља хијероглифа није сусједна.","NO_IMAGE");
        Pitanje pitanje45 = new Pitanje(3,"Bhutan","Nepal","Bangladesh","China","India","Бутан","Непал","Бангладеш","Кина","Индија","China:India","Кина:Индија","Big countries are neighbours","Велике државе су јој сусједи.","NO_IMAGE");
        Pitanje pitanje46 = new Pitanje(3,"Bangladesh","Nepal","China","India","Bhutan","Бангладеш","Непал","Кина","Индија","Бутан","India","Индија","It's a very lonely country on the map.","Врло усамљена земља на мапи.","NO_IMAGE");
        Pitanje pitanje47 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje48 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje49 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje50 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje51 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje52 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje53 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje54 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje55 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje56 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje57 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje58 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje59 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje60 = new Pitanje(4,"","","","","","","","","","","","","","","");

        //INSERT TYPE 4 QUESTIONS
        Pitanje pitanje61 = new Pitanje(4,"Acropolis","China","Greece","Italy","Macedonia","Акропољ","Кина","Грчка","Италија","Македонија","Greece","Грчка","Bitrhplace of phylosophy.","Родно мјесто философије.","acropolis");
        Pitanje pitanje62 = new Pitanje(4,"Hegra","Nepal","Saudi Arabia","Kyrgistan","Bhutan","Хегра","Непал","Саудијска Арабија","Киргистан","Бутан","Saudi Arabia","Саудијска Арабија","Yemen is a neigbouring country","Јемен је сусједна држава.","al_hijr_madain");
        Pitanje pitanje63 = new Pitanje(4,"Saint Basil's Cathedral","Poland","Belarus","Russia","Bulgaria","Црква Св. Василија Блаженог","Пољска","Бјелорусија","Русија","Бугарска","Russia","Русија","Biggest country in the world.","Највећа држава свијета.","basils_basilica");
        Pitanje pitanje64 = new Pitanje(4,"Leshan Buddha","Nepal","Japan","China","Mongolia","Лешан Буда","Непал","Јапан","Кина","Монголја","China","Кина","Birthplace of the tea.","Мјесто постанка чаја.","buddha");
        Pitanje pitanje65 = new Pitanje(4,"Chichen Itza","Argentina","Mexico","Portugal","Brazil","Чичен Ица","Аргентина","Мексико","Португал","Бразил","Mexico","Мексико","Tequila!","Текила!","chichen_itza");
        Pitanje pitanje66 = new Pitanje(4,"Christ the Redeemer","Brazil","Mexico","Spain","Portugal","Христ Искупитељ","Бразил","Мексико","Шпанија","Португал","Brazil","Бразил","Rio de Janeiro","Рио Де Жанеиро","christ_rio");
        Pitanje pitanje67 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje68 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje69 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje70 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje71 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje72 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje73 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje74 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje75 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje76 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje77 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje78 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje79 = new Pitanje(4,"","","","","","","","","","","","","","","");
        Pitanje pitanje80 = new Pitanje(4,"","","","","","","","","","","","","","","");

        //CORRECT THIS RETURN STATEMENT!
        return null;
    }
}