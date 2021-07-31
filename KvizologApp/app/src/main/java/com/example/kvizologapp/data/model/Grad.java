package com.example.kvizologapp.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.example.kvizologapp.util.Constants;
import org.jetbrains.annotations.NotNull;
import java.io.Serializable;

@Entity(tableName = Constants.TABLE_NAME_GRAD)
public class Grad implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nazivSR;
    private String nazivEN;
    private double latitude;
    private double longitude;
    private String slika;

    public Grad(String nazivSR, String nazivEN, double latitude, double longitude, String slika) {
        this.nazivSR = nazivSR;
        this.nazivEN = nazivEN;
        this.latitude = latitude;
        this.longitude = longitude;
        this.slika = slika;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivSR() {
        return nazivSR;
    }

    public void setNazivSR(String nazivSR) {
        this.nazivSR = nazivSR;
    }

    public String getNazivEN() {
        return nazivEN;
    }

    public void setNazivEN(String nazivEN) {
        this.nazivEN = nazivEN;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    @Override
    public boolean equals(@Nullable @org.jetbrains.annotations.Nullable Object obj) {
        return super.equals(obj);
    }

    @NonNull
    @NotNull
    @Override
    public String toString() {
        return super.toString();
    }

    public static Grad[] populateData() {
        return new Grad[]{
                new Grad("Београд","Belgrade",44.81333916817276, 20.405385276230323,"belgrade"),
                new Grad("Moсква","Moscow",55.755224586261605, 37.622779060216146,"moscow"),
                new Grad("Кијев","Kiev",50.43381526432757, 30.50538997660183,"kiev"),
                new Grad("Владивосток","Vladivostok",43.11987671218387, 131.91698288123035,"vladivostok"),
                new Grad("Марибор", "Maribor", 46.551638615673454, 15.650041815403565, "maribor"),
                new Grad("Љубљана", "Ljubljana", 46.06465253343343, 14.519050495837801,"ljubljana"),
                new Grad("Скопље", "Skopje", 42.01000274676726, 21.44825480033277, "skopje"),
                new Grad("Нови Сад", "Novi Sad",45.255717107932675, 19.8206354896711,"novi_sad"),
                new Grad("Требиње", "Trebinje", 42.712759690956474, 18.344160944858064, "trebinje"),
                new Grad("Лондон", "London", 51.50841446691904, -0.11744810108000202, "london"),
                new Grad("Берлин", "Berlin", 52.52879368297067, 13.407008832467843, "berlin"),
                new Grad("Единбург","Edinburg",55.95153694250245, -3.1826527507341145,"edinburg"),
                new Grad("Париз", "Paris", 48.86378383241526, 2.3505006065777803, "paris"),
                new Grad("Хамбург","Hamburg", 53.529732509890636, 10.008713996863134,"hamburg"),
                new Grad("Хановер","Hanover",52.38340403854037, 9.74911603981307,"hanover"),
                new Grad("Минхен", "Munich", 48.161589919360296, 11.559025323156291, "munich"),
                new Grad("Хераклион", "Heraklion",35.338534341187035, 25.133189305735215,"heraklion"),
                new Grad("Атина", "Atina", 37.9916385043873, 23.738511383524774,"atina"),
                new Grad("Тесалоники", "Thessaloniki", 40.63082182612092, 22.952728435419665,"thessaloniki"),
                new Grad("Барселона", "Barcelona",41.40837997680301, 2.1745401063385335,"barcelona"),
                new Grad("Севиља","Seville",37.391983945363926, -5.978738595164646,"seville"),
                new Grad("Мадрид","Madrid",40.40644577452384, -3.6960758796167834,"madrid"),
                new Grad("Билбао", "Bilbao", 43.27143629694159, -2.9273787808555873, "bilbao"),
                new Grad("Женева","Geneva", 46.20264317495788, 6.14254207863681, "geneva"),
                new Grad("Цирих","Zurich", 46.20346559186758, 6.137049398190749,"zurich"),
                new Grad("Луцерн", "Lucerne", 47.052162520149494, 8.304104648409517,"lucerne"),
                new Grad("Берн", "Bern", 46.9573803833219, 7.458745582258314, "bern"),
                new Grad("Торонто", "Toronto", 43.74141259047214, -79.3924306329356, "toronto"),
                new Grad("Ванкувер","Vancouver",49.255440663773236, -123.10674042518646,"vancouver"),
                new Grad("Отава", "Ottawa", 45.32303780338626, -75.83565270278388,"ottawa"),
                new Grad("Монтреал","Montreal",45.540516428518146, -73.69739088829719,"montreal"),
                new Grad("Осака", "Osaka", 34.702682932556066, 135.4929281252652, "osaka"),
                new Grad("Кјото", "Kyoto", 35.26416502896676, 135.4896034514501, "kyoto"),
                new Grad("Токио", "Tokyo", 35.715950987038674, 139.4750838850984, "tokyo"),
                new Grad("Фукока", "Fukoka", 33.48442539635119, 130.6229537264634, "fukoka"),
                new Grad("Аархус","Aarhus", 56.169274640106195, 10.180242096391952, "aarhus"),
                new Grad("Аалборг","Aalborg",57.046376705621945, 9.961747654559018, "aalborg"),
                new Grad("Ејсбјерг", "Esbjerg", 55.53634808237403, 8.468337241658897, "esbjerg"),
                new Grad("Копенхаген", "Copenhagen", 55.68556586127794, 12.571181067856124, "copenhagen"),
                new Grad("Бразилија", "Brasilia", -15.753163939591374, -47.874069212279394, "brasilia"),
                new Grad("Рио де Жанеиро", "Rio de Janeiro", -22.937232402561563, -43.254874609093456, "rio"),
                new Grad("Манаус", "Manaus", -3.052201121485795, -59.98530120902966, "manaus"),
                new Grad("Сан Паоло", "Sao Paulo", -23.55728486475359, -46.6310352380355, "sao_paulo"),
                new Grad("Да Нанг","Da Nang", 16.061745393603438, 108.16466285824035,"da_nang"),
                new Grad("Ханои", "Hanoi", 21.034595522086914, 105.83516252563336, "hanoi"),
                new Grad("Хуе", "Hue", 16.469025038970784, 107.57677275292386, "hue"),
                new Grad("Хо Ћи Мин","Ho Chi Minh",10.812354464750042, 106.66857454147166,"ho_chi_minh"),
                new Grad("Марсеј", "Marseille", 43.327913771593174, 5.422526920038208, "marseille"),
                new Grad("Ница", "Nice", 43.6830560667553, 7.2273949884386095, "nice"),
                new Grad("Лион", "Lyon", 45.764145428990176, 4.826887508433209, "lyon"),
                new Grad("Шангај", "Shanghai", 31.17215273733652, 121.43266459899165, "shanghai"),
                new Grad("Шенцен", "Schenzen", 22.53774003220887, 114.03918118021338, "schenzen"),
                new Grad("Бејжин", "Beijing", 39.94460228128576, 116.364511915139, "beijing"),
                new Grad("Вухан", "Wuhan", 30.591636932060336, 114.27912401305798, "wuhan"),
                new Grad("Бања Лука <3", "Banja Luka", 44.7675867820816, 17.19073909879046, "banja_luka"),
                new Grad("Сарајево", "Sarajevo", 43.85756118513731, 18.377116439431887, "sarajevo"),
                new Grad("Мостар", "Mostar", 43.34329160490544, 17.810427013018508, "mostar"),
                new Grad("Требиње", "Trebinje", 42.71162482860894, 18.343473600155544, "trebinje"),
                new Grad("Краков", "Krakow", 50.0532682708454, 19.94445388029057, "krakow"),
                new Grad("Вроцлав", "Wroclaw", 51.12559956910441, 17.006280876290507, "wroclaw"),
                new Grad("Варшава", "Warsaw", 52.240385842836886, 21.017260936853603, "warsaw"),
                new Grad("Познан", "Poznan", 52.40914697522857, 16.91337044168818, "poznan"),
                new Grad("Рим", "Rome", 41.90022031465476, 12.509884379676679, "rome"),
                new Grad("Милано", "Milan", 45.46894425832485, 9.189415247474809, "milano"),
                new Grad("Венеција", "Venice", 45.44106689979242, 12.331077179504797, "venice"),
                new Grad("Болоња", "Bologna", 44.504455911486524, 11.3423368133757, "bologna"),
                new Grad("Осло", "Oslo", 59.91164598001455, 10.754273854934135, "oslo"),
                new Grad("Берген", "Bergen", 60.370903843955944, 5.309709551995242, "bergen"),
                new Grad("Трондхајм", "Trondheim", 63.42685582907096, 10.408216749329261, "trondheim"),
                new Grad("Ставангер", "Stavanger", 58.96611049486791, 5.731559163039068, "stavanger"),
                new Grad("Беч", "Vienna", 48.21959635047358, 16.382804030965723, "vienna"),
                new Grad("Грац", "Graz", 47.066537778514, 15.431824968209762, "graz")
        };
    }
}
