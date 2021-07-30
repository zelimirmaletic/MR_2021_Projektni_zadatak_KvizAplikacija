package com.example.kvizologapp.data.model;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.kvizologapp.util.Constants;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = Constants.TABLE_NAME_PITANJE)
public class Pitanje implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private int tipPitanja;
    private String tekstPitanjaEngleski;
    private String odgovorBr1Engleski;
    private String odgovorBr2Engleski;
    private String odgovorBr3Engleski;
    private String odgovorBr4Engleski;
    private String tekstPitanjaSrpski;
    private String odgovorBr1Srpski;
    private String odgovorBr2Srpski;
    private String odgovorBr3Srpski;
    private String odgovorBr4Srpski;
    private String tacniOdgovoriEngleski;
    private String tacniOdgovoriSrpski;
    private String hintEngleski;
    private String hintSrpski;
    private String slika;

    @Ignore
    public  Pitanje(){
    }

    public Pitanje(int tipPitanja, String tekstPitanjaEngleski, String odgovorBr1Engleski, String odgovorBr2Engleski, String odgovorBr3Engleski, String odgovorBr4Engleski, String tekstPitanjaSrpski, String odgovorBr1Srpski, String odgovorBr2Srpski, String odgovorBr3Srpski, String odgovorBr4Srpski,String tacniOdgovoriEngleski,String tacniOdgovoriSrpski, String hintEngleski, String hintSrpski, String slika) {
        this.tipPitanja = tipPitanja;
        this.tekstPitanjaEngleski = tekstPitanjaEngleski;
        this.odgovorBr1Engleski = odgovorBr1Engleski;
        this.odgovorBr2Engleski = odgovorBr2Engleski;
        this.odgovorBr3Engleski = odgovorBr3Engleski;
        this.odgovorBr4Engleski = odgovorBr4Engleski;
        this.tekstPitanjaSrpski = tekstPitanjaSrpski;
        this.odgovorBr1Srpski = odgovorBr1Srpski;
        this.odgovorBr2Srpski = odgovorBr2Srpski;
        this.odgovorBr3Srpski = odgovorBr3Srpski;
        this.odgovorBr4Srpski = odgovorBr4Srpski;
        this.tacniOdgovoriEngleski = tacniOdgovoriEngleski;
        this.tacniOdgovoriSrpski = tacniOdgovoriSrpski;
        this.hintEngleski = hintEngleski;
        this.hintSrpski = hintSrpski;
        this.slika = slika;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getTipPitanja() {
        return tipPitanja;
    }

    public void setTipPitanja(int tipPitanja) {
        this.tipPitanja = tipPitanja;
    }

    public String getTekstPitanjaEngleski() {
        return tekstPitanjaEngleski;
    }

    public void setTekstPitanjaEngleski(String tekstPitanjaEngleski) {
        this.tekstPitanjaEngleski = tekstPitanjaEngleski;
    }

    public String getOdgovorBr1Engleski() {
        return odgovorBr1Engleski;
    }

    public void setOdgovorBr1Engleski(String odgovorBr1Engleski) {
        this.odgovorBr1Engleski = odgovorBr1Engleski;
    }

    public String getOdgovorBr2Engleski() {
        return odgovorBr2Engleski;
    }

    public void setOdgovorBr2Engleski(String odgovorBr2Engleski) {
        this.odgovorBr2Engleski = odgovorBr2Engleski;
    }


    public String getOdgovorBr3Engleski() {
        return odgovorBr3Engleski;
    }

    public void setOdgovorBr3Engleski(String odgovorBr3Engleski) {
        this.odgovorBr3Engleski = odgovorBr3Engleski;
    }

    public String getTacniOdgovoriEngleski() {
        return tacniOdgovoriEngleski;
    }

    public void setTacniOdgovoriEngleski(String tacniOdgovoriEngleski) {
        this.tacniOdgovoriEngleski = tacniOdgovoriEngleski;
    }

    public String getTacniOdgovoriSrpski() {
        return tacniOdgovoriSrpski;
    }

    public void setTacniOdgovoriSrpski(String tacniOdgovoriSrpski) {
        this.tacniOdgovoriSrpski = tacniOdgovoriSrpski;
    }

    public String getOdgovorBr4Engleski() {
        return odgovorBr4Engleski;
    }

    public void setOdgovorBr4Engleski(String odgovorBr4Engleski) {
        this.odgovorBr4Engleski = odgovorBr4Engleski;
    }

    public String getTekstPitanjaSrpski() {
        return tekstPitanjaSrpski;
    }

    public void setTekstPitanjaSrpski(String tekstPitanjaSrpski) {
        this.tekstPitanjaSrpski = tekstPitanjaSrpski;
    }

    public String getOdgovorBr1Srpski() {
        return odgovorBr1Srpski;
    }

    public void setOdgovorBr1Srpski(String odgovorBr1Srpski) {
        this.odgovorBr1Srpski = odgovorBr1Srpski;
    }

    public String getOdgovorBr2Srpski() {
        return odgovorBr2Srpski;
    }

    public void setOdgovorBr2Srpski(String odgovorBr2Srpski) {
        this.odgovorBr2Srpski = odgovorBr2Srpski;
    }

    public String getOdgovorBr3Srpski() {
        return odgovorBr3Srpski;
    }

    public void setOdgovorBr3Srpski(String odgovorBr3Srpski) {
        this.odgovorBr3Srpski = odgovorBr3Srpski;
    }

    public String getOdgovorBr4Srpski() {
        return odgovorBr4Srpski;
    }

    public void setOdgovorBr4Srpski(String odgovorBr4Srpski) {
        this.odgovorBr4Srpski = odgovorBr4Srpski;
    }

    public String getHintEngleski() {
        return hintEngleski;
    }

    public void setHintEngleski(String hintEngleski) {
        this.hintEngleski = hintEngleski;
    }

    public String getHintSrpski() {
        return hintSrpski;
    }

    public void setHintSrpski(String hintSrpski) {
        this.hintSrpski = hintSrpski;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pitanje)) return false;
        Pitanje pitanje = (Pitanje) o;
        return getId() == pitanje.getId() &&
                getTipPitanja() == pitanje.getTipPitanja() &&
                Objects.equals(getTekstPitanjaEngleski(), pitanje.getTekstPitanjaEngleski()) &&
                Objects.equals(getOdgovorBr1Engleski(), pitanje.getOdgovorBr1Engleski()) &&
                Objects.equals(getOdgovorBr2Engleski(), pitanje.getOdgovorBr2Engleski()) &&
                Objects.equals(getOdgovorBr3Engleski(), pitanje.getOdgovorBr3Engleski()) &&
                Objects.equals(getOdgovorBr4Engleski(), pitanje.getOdgovorBr4Engleski()) &&
                Objects.equals(getTekstPitanjaSrpski(), pitanje.getTekstPitanjaSrpski()) &&
                Objects.equals(getOdgovorBr1Srpski(), pitanje.getOdgovorBr1Srpski()) &&
                Objects.equals(getOdgovorBr2Srpski(), pitanje.getOdgovorBr2Srpski()) &&
                Objects.equals(getOdgovorBr3Srpski(), pitanje.getOdgovorBr3Srpski()) &&
                Objects.equals(getOdgovorBr4Srpski(), pitanje.getOdgovorBr4Srpski()) &&
                Objects.equals(getHintEngleski(), pitanje.getHintEngleski()) &&
                Objects.equals(getHintSrpski(), pitanje.getHintSrpski()) &&
                Objects.equals(getSlika(), pitanje.getSlika());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTipPitanja(), getTekstPitanjaEngleski(), getOdgovorBr1Engleski(), getOdgovorBr2Engleski(), getOdgovorBr3Engleski(), getOdgovorBr4Engleski(), getTekstPitanjaSrpski(), getOdgovorBr1Srpski(), getOdgovorBr2Srpski(), getOdgovorBr3Srpski(), getOdgovorBr4Srpski(), getHintEngleski(), getHintSrpski(), getSlika());
    }

    @Override
    public String toString() {
        return "Pitanje{" +
                "Id=" + Id +
                ", tipPitanja=" + tipPitanja +
                ", tekstPitanjaEngleski='" + tekstPitanjaEngleski + '\'' +
                ", odgovorBr1Engleski='" + odgovorBr1Engleski + '\'' +
                ", odgovorBr2Engleski='" + odgovorBr2Engleski + '\'' +
                ", odgovorBr3Engleski='" + odgovorBr3Engleski + '\'' +
                ", odgovorBr4Engleski='" + odgovorBr4Engleski + '\'' +
                ", tekstPitanjaSrpski='" + tekstPitanjaSrpski + '\'' +
                ", odgovorBr1Srpski='" + odgovorBr1Srpski + '\'' +
                ", odgovorBr2Srpski='" + odgovorBr2Srpski + '\'' +
                ", odgovorBr3Srpski='" + odgovorBr3Srpski + '\'' +
                ", odgovorBr4Srpski='" + odgovorBr4Srpski + '\'' +
                ", hintEngleski='" + hintEngleski + '\'' +
                ", hintSrpski='" + hintSrpski + '\'' +
                ", slika='" + slika + '\'' +
                '}';
    }

    public static Pitanje[] populateData() {
        return new Pitanje[] {
                //PITANJA - GLAVNI GRADOVI
                new Pitanje(0,"Russia","Moscow","London","Kiev","Vladivostok", "Русија","Москва","Лондон","Кијев","Владивосток", "Moscow","Москва","Red square","Црвени трг",""),
                new Pitanje(0,"Slovenia","Maribor","Ljubljana","Skopje","Belgrade", "Словенија","Марибор","Љубљана","Скопље","Београд", "Ljubljana","Љубљана","Dragon is the most recognizable symbol.","Најпрепознатљивији сибол града је змај.",""),
                new Pitanje(0,"Serbia","Skopje","Belgrade","Novi Sad","Trebinje","Србија","Скопље","Београд","Нови Сад","Требиње","Belgrade","Београд","Biggest orthodox church in the Balkans","Највећа православна црква на Балкану",""),
                new Pitanje(0,"United Kingdom","London","Berlin","Edinburg","Paris","Уједињено Краљевств","Лондон","Берлин","Единбург","Париз","London","Лондон","Big eye.","Велико око.","NO_IMAGE"),
                new Pitanje(0,"Germany", "Hamburg","Berlin","Hanover","Munich","Њемачка","Хамбург","Берлин","Минхен","Хановер","Berlin","Берлин","Used to be divided by a wall.","Био је подијељен зидом.",""),
                new Pitanje(0,"Greece","Heraklion","Athens","Thessaloniki","Berlin","Грчка","Херклион","Атина","Тесалоники","Берлин","Athens","Атина","Partenon","Партенон",""),
                new Pitanje(0,"Spain","Barcelona","Seville","Madrid","Bilbao","Шпанија","Барселона","Севиља","Мадрид","Билбао","Barcelona","Барселона","The Oldest Restaurant In The World is located here.","Најстарији ресторан на свијету је лоциран у овом граду.",""),
                new Pitanje(0,"Switzerland","Geneva","Zurich","Lucerne","Bern","Швајцарска","Женева","Цирих","Луцерн","Берн","Bern","Берн","It's not Zurich.","Није Цирих.",""),
                new Pitanje(0,"Canada","Toronto","Vancouver","Ottawa","Montreal","Канада","Торонто","Ванкувер","Отава","Монтереал","Ottawa","Отава","Same-named river flows through this city.","Истоимена ријека протиче кроз овај град.",""),
                new Pitanje(0,"Japan","Osaka","Kyoto","Tokyo","Fukoka","Јапан","Осака","Кјото","Токио","Фукока","Tokyo","Токио","Extremely busy public transportation.","Екстремно велике гужве у јавном превозу.",""),
                new Pitanje(0,"Denmark","Aarhus","Aalborg","Esbjerg","Copenhagen","Данска","Архус","Алборг","Ејсборг","Копенхаген","Copenhagen","Копенхаген","Happiest city in the world!","Најсрећнији град на свијету!",""),
                new Pitanje(0,"Brazil","Brasilia","Rio de Janeiro","Manaus","Sao Paulo","Бразил","Бразилија","Рио де Жанеиро","Манаус","Сан Паоло","Brasilia","Бразилија","Similar name to the name of the country.","Назив сличан називу државе.",""),
                new Pitanje(0,"Vietnam","Da Nang","Hanoi","Hue","Ho Chi Minh","Вијетнам","Да Нанг","Ханои","Хуе","Хо Ћи Мин","Hanoi","Ханои","Name starts with H.","Назив почиње словом Х",""),
                new Pitanje(0,"France","Marseille","Nice","Lyon","Paris","Француска","Марсеј","Ница","Лион","Париз","Paris","Париз","Romance city.","Град романтичара.",""),
                new Pitanje(0,"China","Shanghai","Schenzen","Beijing","Wuhan","Кина","Шангај","Шенцен","Бејжинг","Вухан","Beijing","Бејжинг","Name does not start with the letter  S","Назив не почиње са словом Ш",""),
                new Pitanje(0,"Slovenia","Ljubljana","Maribor","Koper","Kranj","Словенија","Љубљана","Марибор","Копер","Крањ","Ljubljana","Љубљана","Prešeren Square","Прешеренов трг",""),
                new Pitanje(0,"Bosnia and Herzegovina","Banja Luka","Sarajevo","Mostar","Trebinje","Босна и Херцеговина","Бања Лука","Сарајево","Мостар","Требиње","Sarajevo","Сарајево","Walter defends...","Валтер брани...",""),
                new Pitanje(0,"Poland","Krakow","Wroclaw","Warsaw","Poznan","Пољска","Краков","Врошлав","Варшава","Познан","Warsaw","Варшава","Polin Museum","Полин музеј",""),
                new Pitanje(0,"Italy","Rome","Milan","Venice","Bologna","Италија","Рим","Милано","Венеција","Болоња","Rome","Рим","Another country is located in this town.","Још једна држава се налази у овом граду.",""),
                new Pitanje(0,"Germany","Munich","Berlin","Hamburg","Dresden", "Њемачка","Минхен","Берлин","Хамбург","Дрезден","Berlin","Берлин","Used to be divided by wall.","Град који је био подијељен зидом.",""),
                //PITANJA - ZASTAVE
                new Pitanje(1,"","GREECE","","","","ГРЧКА","","","","","","","Birthplace of philosopy...","Родно мјесто философије...","ic_greece"),
                new Pitanje(1,"","SERBIA","","","","СРБИЈА","","","","","","","Biggest orthodox church in the Balkans","Највећа православна црква на Балкану","ic_serbia"),
                new Pitanje(1,"","BHUTAN","","","","БУТАН","","","","","","","Country on the eastern side of the Himalayas.","Земља на источној страни Хималаја.","ic_bhutan"),
                new Pitanje(1,"","JAPAN","","","","ЈАПАН","","","","","","","Country of rising sun.","Земља излазећег сунца.","ic_japan"),
                new Pitanje(1,"","SPAIN","","","","ШПАНИЈА","","","","","","","Gaudi's home country.","Гаудијева земља рођења.","ic_spain"),
                new Pitanje(1,"","BANGLADESH","","","","БАНГЛАДЕШ","","","","","","","Starts with the letter B","Назив почиње на слово Б","ic_bangladesh"),
                new Pitanje(4,"","BOSNIA AND HERZEGOVINA","","","","БОСНА И ХЕРЦЕГОВИНА","","","","","","","Starts with the letter B","Назив почиње на слово Б","ic_bih"),
                new Pitanje(1,"","BRAZIL","","","","БРАЗИЛ","","","","","","","Great carnivals happen there.","Велики карневали се организују у овој земљи.","ic_brazil"),
                new Pitanje(1,"","CANADA","","","","КАНАДА","","","","","","","Part of the UK Commonwealth.","Британска колонија.","ic_canada"),
                new Pitanje(1,"","CHAD","","","","ЧАД","","","","","","","Starts with the letter C","Назив почиње на слово Ч","ic_chad"),
                new Pitanje(1,"","CHINA","","","","КИНА","","","","","","","Starts with the letter C","Назив почиње на слово К","ic_china"),
                new Pitanje(1,"","DENMARK","","","","ДАНСКА","","","","","","","Starts with the letter D","Назив почиње на слово Д","ic_denmark"),
                new Pitanje(1,"","KYRGYZSTAN","","","","КИРГИСТАН","","","","","","","Starts with the letter K","Назив почиње на слово К","ic_kyrgyzstan"),
                new Pitanje(1,"","NORTH MACEDONIA","","","","СЈЕВЕРНА МАКЕДОНИЈА","","","","","","","Starts with the letter N","Назив почиње на слово С","ic_north_macedonia"),
                new Pitanje(1,"","PAPA NEW GUINEA","","","","НОВА ГВИНЕЈА","","","","","","","Starts with the letter P","Назив почиње на слово П","ic_papa_new_guinea"),
                new Pitanje(1,"","RUSSIA","","","","РУСИЈА","","","","","","","Biggest country in the world.","Највећа држава на свијету.","ic_russia"),
                new Pitanje(1,"","SWITZERLAND","","","","ШВАЈЦАРСКА","","","","","","","Country of cheese, wine and clocks.","Земља сира, вина и сатова.","ic_switzerland"),
                new Pitanje(1,"","UNITED KINGDOM","","","","ВЕЛИКА БРИТАНИЈА","","","","","","","Great colonial country.","Велика колонијална сила.","ic_uk"),
                new Pitanje(1,"","VIETNAM","","","","ВИЈЕТНАМ","","","","","","","Starts with the letter V","Назив почиње на слово В","ic_vietnam"),
                new Pitanje(1,"","YEMEN","","","","ЈЕМЕН","","","","","","","Starts with the letter Y","Назив почиње на слово Ј","ic_yemen"),

                //INSERT TYPE 3 QUESTIONS
                new Pitanje(2,"Russia","Germany","China","Estonia","Ukraine","Русија","Њемачка","Кина","Украјина","Естонија","China:Estonia:Ukraine","Кина:Естонија:Украјина","One Baltic country is a neigbour.","Једна балтичка земља је сусједна","NO_IMAGE"),
                new Pitanje(2, "Germany","Russia","Austria","Poland","Switzerland","Њемачка","Русија","Аустрија","Пољаска","Швајцарска","Austria:Switzerland","Аустрија:Швајцарска","German speaking countries.","Државе њемачког говорног подручја.","NO_IMAGE"),
                new Pitanje(2,"France","Switzerland","Spain","Germany","Italy","Француска","Швајцарска","Шпанија","Њемачка","Италија","Switzerland:Spain:Germany:Italy","Швајцарска:Шпанија:Њемачка:Италија","One of them is a birthplace of esspresso coffee","Једна од земаља је родно мјесто еспресо кафе","NO_IMAGE"),
                new Pitanje(2, "Chad","Egypt","Sudan","Ethiopia","Nigeria","Чад","Египт","Судан","Етиопија","Нигерија","Sudan:Nigeria","Судан:Нигерија","Country hierogliphes is not a neigbouring country","Земља хијероглифа није сусједна.","NO_IMAGE"),
                new Pitanje(2,"Bhutan","Nepal","Bangladesh","China","India","Бутан","Непал","Бангладеш","Кина","Индија","China:India","Кина:Индија","Big countries are neighbours","Велике државе су јој сусједи.","NO_IMAGE"),
                new Pitanje(2,"Bangladesh","Nepal","China","India","Bhutan","Бангладеш","Непал","Кина","Индија","Бутан","India","Индија","It's a very lonely country on the map.","Врло усамљена земља на мапи.","NO_IMAGE"),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                new Pitanje(2,"","","","","","","","","","","","","","",""),
                //INSERT TYPE 4 QUESTIONS
                new Pitanje(3,"Acropolis","China","Greece","Italy","Macedonia","Акропољ","Кина","Грчка","Италија","Македонија","Greece","Грчка","Bitrhplace of phylosophy.","Родно мјесто философије.","acropolis"),
                new Pitanje(3,"Hegra","Nepal","Saudi Arabia","Kyrgistan","Bhutan","Хегра","Непал","Саудијска Арабија","Киргистан","Бутан","Saudi Arabia","Саудијска Арабија","Yemen is a neigbouring country","Јемен је сусједна држава.","al_hijr_madain"),
                new Pitanje(3,"Saint Basil's Cathedral","Poland","Belarus","Russia","Bulgaria","Црква Св. Василија Блаженог","Пољска","Бјелорусија","Русија","Бугарска","Russia","Русија","Biggest country in the world.","Највећа држава свијета.","basils_basilica"),
                new Pitanje(3,"Leshan Buddha","Nepal","Japan","China","Mongolia","Лешан Буда","Непал","Јапан","Кина","Монголја","China","Кина","Birthplace of the tea.","Мјесто постанка чаја.","buddha"),
                new Pitanje(3,"Chichen Itza","Argentina","Mexico","Portugal","Brazil","Чичен Ица","Аргентина","Мексико","Португал","Бразил","Mexico","Мексико","Tequila!","Текила!","chichen_itza"),
                new Pitanje(3,"Christ the Redeemer","Brazil","Mexico","Spain","Portugal","Христ Искупитељ","Бразил","Мексико","Шпанија","Португал","Brazil","Бразил","Rio de Janeiro","Рио Де Жанеиро","christ_rio"),
                new Pitanje(3,"Colloseum","Spain","Greece","Italy","Portugal","Колосеум","Шпанија","Грчка","Италија","Португал","Italy","Италија","Birthplace of esspresso coffee.","Родно мјесто еспресо кафе.","colosseum"),
                new Pitanje(3,"Easter Island","Mexico","Argentina","Chile","Brazil","Ускршње острво","Мексико","Аргентина","Чиле","Бразил","Chile","Чиле","Santiago","Сантијаго","easter_island"),
                new Pitanje(3,"Forbidden City","Japan","South Korea","Mongolia","China","Забрањени Град","Јапан","Јужна Кореја","Монголија","Кина","China","Кина","Red flag with yelow stars.","Црвена застава са жутим звијездама.","forbidden_city"),
                new Pitanje(3,"Great Wall","Japan","South Korea","Mongolia","China","Велики зид","Јапан","Јужна Кореја","Монголија","Кина","China","Кина","Red flag with yelow stars.","Црвена застава са жутим звијездама.","great_wall"),
                new Pitanje(3,"Hampi","Bhutan","Nepal","India","Pakistan","Хампи","Бутан","Непал","Индија","Пакистан","India","Индија","The second populous country.","Друга земља на свијету по броју становника.","hampi"),
                new Pitanje(3,"Machu Picchu","Argentina","Mexico","Brazil","Chile","Мачу Пикчу","Аргентина","Мексико","Бразил","Чиле","Mexico","Мексико","Tequila!","Текила!","machu_picchu"),
                new Pitanje(3,"Notre Dame","Germany","France","Italy","Austria","Нотр Дам","Њемачка","Француска","Италија","Аустрија","France","Француска","Croissant!","Кроасан!","notre_dame"),
                new Pitanje(3,"Petra","Saudi Arabia","Ethiopia","Jordan","Ruanda","Петра","Саудијска Арабија","Јордан","Руанда","Етиопија","Jordan","Јордан","Amman is the capital city of this coutry.","Аман је главни град ове државе.","petra_jordan"),
                new Pitanje(3,"Pyramids Giza","Saudi Arabia","Sudan","Egypt","Ethiopia","Пирамиде у Гизи","Саудијска Арабија","Судан","Египат","Етиопија","Egypt","Египат","Great river Nile splits this country on two.","Велика ријека Нил дијели ову државу на два дијела.","pyramids_giza"),
                new Pitanje(3,"Shinto Shrine","China","South Korea","Mongolia","Japan","Шинто Шрајн","Кина","Јужна Кореја","Монголија","Јапан","Japan","Јапан","Miso soup!","Мизо супа!","shinto_shrine"),
                new Pitanje(3,"Taj Mahal","Bhutan","Nepal","India","Mongolia","Таџ Махал","Бутан","Непал","Индија","Монголија","India","Индија","Ghandi's country.","Гандијева земља.","taj_mahal"),
                new Pitanje(3,"Uluru Kata Tjuta","USA","New Zeland","Australia","Somalia","Улуру Ката Тјута","САД","Нови Зеланд","Аустралија","Сомалија","Australia","Аустралија","Kangaroo!","Кенгур!","uluru_kata_tjuta"),
                new Pitanje(3,"Yellowstone","Australia","USA","New Zeland","Brazil","Јелоустон","Аустралија","САД","Нови Зеланд","Бразил","USA","САД","Country which bought Alaska.","Земља која је купила Аљаску.","yellowstone"),
                new Pitanje(3,"Church of Christ The Saviour","Bosnia and Herzegovina","Serbia","Montenegro","North Macedonia","Храм Христа Спаситеља","Босна и Херцеговина","Србија","Црна Гора","Сјеверна Македонија","Bosnia and Herzegovina","Босна и Херцеговина","Sarajevo is a capital city.","Сарајево је главни град.","christ_the_saviour"),
                //INSERT GRAD data
                //new Grad("Београд","Belgrade",44.79642985642653,20.471462575664354,"SLIKA_GRBA"),
                //new Grad("Mосква","Moscow",55.755125454817836, 37.61708451367523,"SLIKA_GRBA")

        };
    }
}

