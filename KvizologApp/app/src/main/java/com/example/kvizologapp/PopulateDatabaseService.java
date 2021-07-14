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
        Pitanje pitanje4 = new Pitanje(1,"United Kingdom","London","Berlin","Edinburg","Paris","Уједињено Краљевств","Лондон","Берлин","Единбург","Париз","London","Лондон","Big eye.","Велико око.","NO_IMAGE");
        Pitanje pitanje5 = new Pitanje(1,"Germany", "Hamburg","Berlin","Hanover","Munch","Њемачка","Хамбург","Берлин","Минхен","Хановер","Berlin","Берлин","Used to be divided by a wall.","Био је подијељен зидом.","NO_IMAGE");
        Pitanje pitanje6 = new Pitanje(1,"Greece","Heraklion","Athens","Thessaloniki","Berlin","Грчка","Херклион","Атина","Тесалоники","Берлин","Athens","Атина","Partenon","Партенон","NO_IMAGE");




        //PITANJA - ZASTAVE
        Pitanje pitanje21 = new Pitanje(2,"","GREECE","","","","ГРЧКА","","","","","","","Birthplace of philosopy...","Родно мјесто философије...","ic_greece");
        Pitanje pitanje22 = new Pitanje(2,"","SERBIA","","","","СРБИЈА","","","","","","","Biggest orthodox church in the Balkans","Највећа православна црква на Балкану","ic_serbia");
        Pitanje pitanje23 = new Pitanje(2,"","BHUTAN","","","","БУТАН","","","","","","","","","ic_bhutan");
        Pitanje pitanje24 = new Pitanje(2,"","JAPAN","","","","ЈАПАН","","","","","","","Country of rising sun.","Земља излазећег сунца.","ic_japan");
        Pitanje pitanje25 = new Pitanje(2,"","SPAIN","","","","ШПАНИЈА","","","","","","","Gaudi's home country.","Гаудијева земља рођења.","ic_spain");
        Pitanje pitanje26 = new Pitanje(2,"","BANGLADESH","","","","БАНГЛАДЕШ","","","","","","","","","ic_bangladesh");
        Pitanje pitanje27 = new Pitanje(4,"","BOSNIA AND HERZEGOVINA","","","","БОСНА И ХЕРЦЕГОВИНА","","","","","","","","","ic_bih");
        Pitanje pitanje28 = new Pitanje(4,"","BRAZIL","","","","БРАЗИЛ","","","","","","","","","ic_brazil");
        Pitanje pitanje29 = new Pitanje(4,"","CANADA","","","","КАНАДА","","","","","","","","","ic_canada");
        Pitanje pitanje30 = new Pitanje(4,"","CHAD","","","","ЧАД","","","","","","","","","ic_chad");
        Pitanje pitanje31 = new Pitanje(4,"","CHINA","","","","КИНА","","","","","","","","","ic_china");
        Pitanje pitanje32 = new Pitanje(4,"","DENMARK","","","","ДАНСКА","","","","","","","","","ic_denmark");
        Pitanje pitanje33 = new Pitanje(4,"","KYRGYZSTAN","","","","КИРГИСТАН","","","","","","","","","ic_kyrgyzstan");
        Pitanje pitanje34 = new Pitanje(4,"","NORTH MACEDONIA","","","","СЈЕВЕРНА МАКЕДОНИЈА","","","","","","","","","ic_north_macedonia");
        Pitanje pitanje35 = new Pitanje(4,"","PAPA NEW GUINEA","","","","НОВА ГВИНЕЈА","","","","","","","","","ic_papa_new_guinea");
        Pitanje pitanje36 = new Pitanje(4,"","RUSSIA","","","","РУСИЈА","","","","","","","","","ic_russia");
        Pitanje pitanje37 = new Pitanje(4,"","SWITZERLAND","","","","ШВАЈЦАРСКА","","","","","","","","","ic_switzerland");
        Pitanje pitanje38 = new Pitanje(4,"","UNITED KINGDOM","","","","ВЕЛИКА БРИТАНИЈА","","","","","","","","","ic_uk");
        Pitanje pitanje39 = new Pitanje(4,"","VIETNAM","","","","ВИЈЕТНАМ","","","","","","","","","ic_vietnam");
        Pitanje pitanje40 = new Pitanje(4,"","YEMEN","","","","ЈЕМЕН","","","","","","","","","ic_yemen");

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
        Pitanje pitanje67 = new Pitanje(4,"Colloseum","Spain","Greece","Italy","Portugal","Колосеум","Шпанија","Грчка","Италија","Португал","Italy","Италија","Birthplace of esspresso coffee.","Родно мјесто еспресо кафе.","colosseum");
        Pitanje pitanje68 = new Pitanje(4,"Easter Island","Mexico","Argentina","Chile","Brazil","Ускршње острво","Мексико","Аргентина","Чиле","Бразил","Chile","Чиле","Santiago","Сантијаго","easter_island");
        Pitanje pitanje69 = new Pitanje(4,"Forbidden City","Japan","South Korea","Mongolia","China","Забрањени Град","Јапан","Јужна Кореја","Монголија","Кина","China","Кина","Red flag with yelow stars.","Црвена застава са жутим звијездама.","forbidden_city");
        Pitanje pitanje70 = new Pitanje(4,"Great Wall","Japan","South Korea","Mongolia","China","Велики зид","Јапан","Јужна Кореја","Монголија","Кина","China","Кина","Red flag with yelow stars.","Црвена застава са жутим звијездама.","great_wall");
        Pitanje pitanje71 = new Pitanje(4,"Hampi","Bhutan","Nepal","India","Pakistan","Хампи","Бутан","Непал","Индија","Пакистан","India","Индија","The second populous country.","Друга земља на свијету по броју становника.","hampi");
        Pitanje pitanje72 = new Pitanje(4,"Machu Picchu","Argentina","Mexico","Brazil","Chile","Мачу Пикчу","Аргентина","Мексико","Бразил","Чиле","Mexico","Мексико","Tequila!","Текила!","machu_picchu");
        Pitanje pitanje73 = new Pitanje(4,"Notre Dame","Germany","France","Italy","Austria","Нотр Дам","Њемачка","Француска","Италија","Аустрија","France","Француска","Croissant!","Кроасан!","notre_dame");
        Pitanje pitanje74 = new Pitanje(4,"Petra","Saudi Arabia","Ethiopia","Jordan","Ruanda","Петра","Саудијска Арабија","Јордан","Руанда","Етиопија","Jordan","Јордан","Amman is the capital city of this coutry.","Аман је главни град ове државе.","petra_jordan");
        Pitanje pitanje75 = new Pitanje(4,"Pyramids Giza","Saudi Arabia","Sudan","Egypt","Ethiopia","Пирамиде у Гизи","Саудијска Арабија","Судан","Египат","Етиопија","Egypt","Египат","Great river Nile splits this country on two.","Велика ријека Нил дијели ову државу на два дијела.","pyramids_giza");
        Pitanje pitanje76 = new Pitanje(4,"Shinto Shrine","China","South Korea","Mongolia","Japan","Шинто Шрајн","Кина","Јужна Кореја","Монголија","Јапан","Japan","Јапан","Miso soup!","Мизо супа!","shinto_shrine");
        Pitanje pitanje77 = new Pitanje(4,"Taj Mahal","Bhutan","Nepal","India","Mongolia","Таџ Махал","Бутан","Непал","Индија","Монголија","India","Индија","Ghandi's country.","Гандијева земља.","taj_mahal");
        Pitanje pitanje78 = new Pitanje(4,"Uluru Kata Tjuta","USA","New Zeland","Australia","Somalia","Улуру Ката Тјута","САД","Нови Зеланд","Аустралија","Сомалија","Australia","Аустралија","Kangaroo!","Кенгур!","uluru_kata_tjuta");
        Pitanje pitanje79 = new Pitanje(4,"Yellowstone","Australia","USA","New Zeland","Brazil","Јелоустон","Аустралија","САД","Нови Зеланд","Бразил","USA","САД","Country which bought Alaska.","Земља која је купила Аљаску.","yellowstone");
        Pitanje pitanje80 = new Pitanje(4,"Church of Christ The Saviour","Bosnia and Herzegovina","Serbia","Montenegro","North Macedonia","Храм Христа Спаситеља","Босна и Херцеговина","Србија","Црна Гора","Сјеверна Македонија","Bosnia and Herzegovina","Босна и Херцеговина","Sarajevo is a capital city.","Сарајево је главни град.","christ_the_saviour");

        //CORRECT THIS RETURN STATEMENT!
        return null;
    }
}