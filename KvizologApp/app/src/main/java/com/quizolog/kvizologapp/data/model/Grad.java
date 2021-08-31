package com.quizolog.kvizologapp.data.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.quizolog.kvizologapp.util.Constants;
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
                new Grad("Београд","Belgrade",44.81333916817276, 20.405385276230323,"https://www.ebrdgreencities.com/assets/headers/d3456b87c2/belgrade-header.jpg"),
                new Grad("Moсква","Moscow",55.755224586261605, 37.622779060216146,"https://www.tripsavvy.com/thmb/oEGnc1X8kgV9RNPN548KwN6EALY=/1885x1414/smart/filters:no_upscale()/closed-up-st--basil-s-cathedral--red-square--moscow--russia-1145977893-76b4eed962314f7a933fafccee9550c6.jpg"),
                new Grad("Кијев","Kiev",50.43381526432757, 30.50538997660183,"https://digitalnomads.world/wp-content/uploads/2021/05/kiev-digital-nomads.jpg"),
                new Grad("Владивосток","Vladivostok",43.11987671218387, 131.91698288123035,"https://cdni.rbth.com/rbthmedia/images/2020.07/article/5f23eddd85600a22cd1bcde9.jpg"),
                new Grad("Марибор", "Maribor", 46.551638615673454, 15.650041815403565, "https://res.cloudinary.com/dsmafmqwi/image/upload/c_fill,f_auto,h_1280,q_auto/v1/virtualtrips/locations/fn1jfcytffybnpipk6be"),
                new Grad("Љубљана", "Ljubljana", 46.06465253343343, 14.519050495837801,"https://i.natgeofe.com/n/a84d690a-541d-4fef-825f-789180fc2f4c/ljubljana-city-view-sunset_16x9.jpg?w=1200"),
                new Grad("Скопље", "Skopje", 42.01000274676726, 21.44825480033277, "https://www.momondo.com/rimg/dimg/98/9a/27fe7b67-city-18146-165110bb4da.jpg?width=1366&height=768&xhint=1084&yhint=1010&crop=true"),
                new Grad("Нови Сад", "Novi Sad",45.255717107932675, 19.8206354896711,"https://static.euronews.com/articles/stories/05/66/33/16/1440x810_cmsv2_74b60ed1-1b76-50fb-9470-8c6313bb6246-5663316.jpg"),
                new Grad("Требиње", "Trebinje", 42.712759690956474, 18.344160944858064, "https://tobosnia.com/wp-content/uploads/2018/09/to-bosnia-trebinje-_optimized.png"),
                new Grad("Лондон", "London", 51.50841446691904, -0.11744810108000202, "https://london.ac.uk/sites/default/files/styles/max_1300x1300/public/2018-10/london-aerial-cityscape-river-thames_1.jpg?itok=6LenFxuz"),
                new Grad("Берлин", "Berlin", 52.52879368297067, 13.407008832467843, "https://d2bgjx2gb489de.cloudfront.net/gbb-blogs/wp-content/uploads/2017/05/16213722/Berlin_city_viewXL.jpg"),
                new Grad("Единбург","Edinburg",55.95153694250245, -3.1826527507341145,"https://ak.picdn.net/offset/photos/5321f70f82359b9a6c407f25/medium/offset_87086.jpg"),
                new Grad("Париз", "Paris", 48.86378383241526, 2.3505006065777803, "https://media.tacdn.com/media/attractions-splice-spp-674x446/07/03/1c/9c.jpg"),
                new Grad("Хамбург","Hamburg", 53.529732509890636, 10.008713996863134,"https://d2bgjx2gb489de.cloudfront.net/gbb-blogs/wp-content/uploads/2017/04/15145242/Hamburg-city-center-with-town-hall-and-Alster-river_XXL.jpg"),
                new Grad("Хановер","Hanover",52.38340403854037, 9.74911603981307,"https://www.studying-in-germany.org/wp-content/uploads/2020/06/hanover-germany.jpg"),
                new Grad("Минхен", "Munich", 48.161589919360296, 11.559025323156291, "https://content.r9cdn.net/rimg/dimg/63/e1/a2a99d53-city-14057-54e213d9.jpg?crop=true&width=568&height=320&xhint=1432&yhint=877"),
                new Grad("Хераклион", "Heraklion",35.338534341187035, 25.133189305735215,"https://images.musement.com/cover/0001/94/heraklion-greece-jpg_header-93974.jpeg?w=1200&h=630&q=95&fit=crop"),
                new Grad("Атина", "Atina", 37.9916385043873, 23.738511383524774,"http://letoimore.com/wp-content/uploads/2014/05/athens.jpg"),
                new Grad("Тесалоники", "Thessaloniki", 40.63082182612092, 22.952728435419665,"https://www.swedishnomad.com/wp-content/images/2020/09/Things-to-do-in-Thessaloniki.jpg"),
                new Grad("Барселона", "Barcelona",41.40837997680301, 2.1745401063385335,"https://cdn.vox-cdn.com/thumbor/9zHVj4OnM5pYeO8rCX-W4aL-lw0=/0x0:4428x1993/1200x800/filters:focal(1872x1198:2580x1906)/cdn.vox-cdn.com/uploads/chorus_image/image/63371518/shutterstock_785442694.0.jpg"),
                new Grad("Севиља","Seville",37.391983945363926, -5.978738595164646,"https://www.tripsavvy.com/thmb/3lAaBP5SZFBDRNBIwW5o-zH8sHU=/2261x1326/filters:fill(auto,1)/plaza-espana-on-sunny-day--seville-963167474-5c7ac75bc9e77c000136a745.jpg"),
                new Grad("Мадрид","Madrid",40.40644577452384, -3.6960758796167834,"https://www.easyjet.com/ejcms/cache/medialibrary/Images/JSS/Destinations/Hero/Spain_Madrid_3840x2160.jpg?mw=1920&hash=E8335D1B8641F2150C395A3EC48BA45CC0B5BA6D"),
                new Grad("Билбао", "Bilbao", 43.27143629694159, -2.9273787808555873, "https://www.telegraph.co.uk/content/dam/Travel/Destinations/Europe/Spain/Bilbao/art-scene-bilbao-attractions-xlarge.jpg"),
                new Grad("Женева","Geneva", 46.20264317495788, 6.14254207863681, "https://www.roadaffair.com/wp-content/uploads/2020/11/aerial-view-geneva-switzerland-shutterstock_1065632078.jpg"),
                new Grad("Цирих","Zurich", 46.20346559186758, 6.137049398190749,"https://d2bgjx2gb489de.cloudfront.net/gbb-blogs/wp-content/uploads/2019/10/28144627/Zürich-city-center-with-river-Limmat-Switzerland-94844524.jpg"),
                new Grad("Луцерн", "Lucerne", 47.052162520149494, 8.304104648409517,"https://globetrottergirls.com/wp-content/uploads/2020/03/lucerne-switzerland.jpg"),
                new Grad("Берн", "Bern", 46.9573803833219, 7.458745582258314, "https://mediaim.expedia.com/destination/1/a4a139b306993b75b055ff49dbd940ec.jpg?impolicy=fcrop&w=536&h=384&q=high"),
                new Grad("Торонто", "Toronto", 43.74141259047214, -79.3924306329356, "https://upload.wikimedia.org/wikipedia/commons/6/65/Toronto_Skyline_Summer_2020.jpg"),
                new Grad("Ванкувер","Vancouver",49.255440663773236, -123.10674042518646,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Concord_Pacific_Master_Plan_Area.jpg/1200px-Concord_Pacific_Master_Plan_Area.jpg"),
                new Grad("Отава", "Ottawa", 45.32303780338626, -75.83565270278388,"http://www.bigsteelbox.com/content/uploads/2021/02/Moving-to-Ottawa-2100.jpg"),
                new Grad("Монтреал","Montreal",45.540516428518146, -73.69739088829719,"https://www.airtransat.com/getmedia/cafc7e6e-d0ff-497e-9998-e708f41aa191/Montreal-estival.aspx"),
                new Grad("Осака", "Osaka", 34.702682932556066, 135.4929281252652, "https://www.asgam.com/wp-content/uploads/2021/02/02-1140x760.jpg"),
                new Grad("Кјото", "Kyoto", 35.26416502896676, 135.4896034514501, "https://lh3.googleusercontent.com/proxy/b8eQnX9jmWOEszV5_lZ5Ya02Z2kBsMHMdQ2ZsbDPmKGYx7llx8CFMO4LWk4NTpiHJh8BMD95SLXc3wajwGHDfw"),
                new Grad("Токио", "Tokyo", 35.715950987038674, 139.4750838850984, "https://stillmed.olympics.com/media/Images/OlympicOrg/News/2021/03/11/2020-03-11-Session-Tokyo-thumbnail.jpg"),
                new Grad("Фукока", "Fukoka", 33.48442539635119, 130.6229537264634, "https://www.esl-languages.com/sites/default/files/styles/image_gallery/public/city/gallery/esl-fukuoka-language-stay-2%20%281%29.jpg?itok=aFx18x4r"),
                new Grad("Аархус","Aarhus", 56.169274640106195, 10.180242096391952, "https://www.themayor.eu/web/files/articles/2634/main_image/thumb_1024x663_Aarhus.jpg"),
                new Grad("Аалборг","Aalborg",57.046376705621945, 9.961747654559018, "https://www.seatrade-cruise.com/sites/seatrade-cruise.com/files/styles/article_featured_retina/public/uploads/2019/06/Port-of-Aalborg-tackles-over-tourism-with-one-cruise-ship-in-port-policy.jpg?itok=vrjRDzBe"),
                new Grad("Ејсбјерг", "Esbjerg", 55.53634808237403, 8.468337241658897, "https://img.itinari.com/page/content/original/4896d4c7-8d7c-48eb-baf7-ac2002a197d9-417_310133.jpg?ch=DPR&dpr=1&w=994&s=0e2732570fa02a20d0c7e456ea478121"),
                new Grad("Копенхаген", "Copenhagen", 55.68556586127794, 12.571181067856124, "https://www.flytap.com/-/media/Flytap/new-tap-pages/destinations/europe/denmark/copenhagen/destinations-copenhagen-banner-mobile-1024x553.jpg"),
                new Grad("Бразилија", "Brasilia", -15.753163939591374, -47.874069212279394, "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/11/70/e5/4a/photo0jpg.jpg?w=500&h=300&s=1"),
                new Grad("Рио де Жанеиро", "Rio de Janeiro", -22.937232402561563, -43.254874609093456, "https://www.clementoni.com/media/prod/dk/35032/rio-de-janeiro-500-pcs-high-quality-collection_S2p8zl4.jpg"),
                new Grad("Манаус", "Manaus", -3.052201121485795, -59.98530120902966, "https://live.staticflickr.com/4327/35073384644_ab3fb681a5_b.jpg"),
                new Grad("Сан Паоло", "Sao Paulo", -23.55728486475359, -46.6310352380355, "https://www.avianca.com/content/dam/avianca_new/destinos/gru/br_gru_ciudad_2880_1620_01.jpg"),
                new Grad("Да Нанг","Da Nang", 16.061745393603438, 108.16466285824035,"https://media.timeout.com/images/105273585/image.jpg"),
                new Grad("Ханои", "Hanoi", 21.034595522086914, 105.83516252563336, "https://res.cloudinary.com/enchanting/f_auto,q_70,w_768,h_512,c_fill/et-web/2020/01/Tran-Quoc-pagoda-the-oldest-temple-in-Hanoi-Vietnam-1.jpg"),
                new Grad("Хуе", "Hue", 16.469025038970784, 107.57677275292386, "https://cdn.britannica.com/23/185223-050-71EBC6C2/Thien-Mu-pagoda-Huong-River-Vietnam-Hue.jpg"),
                new Grad("Хо Ћи Мин","Ho Chi Minh",10.812354464750042, 106.66857454147166,"https://www.tripsavvy.com/thmb/gLcY6_ZtEKySRWnA0riYoz1bd24=/2780x2085/smart/filters:no_upscale()/saigon-ho-chi-minh-city-vietnam-5c489f50c9e77c000112d22b.jpg"),
                new Grad("Марсеј", "Marseille", 43.327913771593174, 5.422526920038208, "https://lp-cms-production.imgix.net/2019-06/b089c412c647e05341592171b6d34ba8-marseille.jpg"),
                new Grad("Ница", "Nice", 43.6830560667553, 7.2273949884386095, "https://lp-cms-production.imgix.net/2019-06/3cb45f6e59190e8213ce0a35394d0e11-nice.jpg?auto=compress&fit=crop&fm=auto&sharp=10&vib=20&w=1200&h=800"),
                new Grad("Лион", "Lyon", 45.764145428990176, 4.826887508433209, "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/33/f7/4d/lyon.jpg?w=700&h=500&s=1"),
                new Grad("Шангај", "Shanghai", 31.17215273733652, 121.43266459899165, "https://www.traveldailymedia.com/assets/2021/06/shutterstock_1488841433-1.jpg"),
                new Grad("Шенцен", "Schenzen", 22.53774003220887, 114.03918118021338, "https://cdn.shortpixel.ai/client/q_glossy,ret_img/https://jingdaily.com/wp-content/uploads/2020/09/shenzhen-china-hong-kong-chinese-luxury-1240x698.jpg"),
                new Grad("Бејжин", "Beijing", 39.94460228128576, 116.364511915139, "https://scx2.b-cdn.net/gfx/news/2020/2-beijing.jpg"),
                new Grad("Вухан", "Wuhan", 30.591636932060336, 114.27912401305798, "https://www.cofcointernational.com/media/1542/wuhan-istock-988899514.jpg?anchor=center&mode=crop&width=849&height=477&rnd=132391284480000000"),
                new Grad("Бања Лука <3", "Banja Luka", 44.7675867820816, 17.19073909879046, "https://emerging-europe.com/wp-content/uploads/2018/08/banja-luka-990x556.png"),
                new Grad("Сарајево", "Sarajevo", 43.85756118513731, 18.377116439431887, "https://www.mondotravel.hr/assets/images/08/08aa7f_sarajevo-2.jpg"),
                new Grad("Мостар", "Mostar", 43.34329160490544, 17.810427013018508, "https://media.tacdn.com/media/attractions-splice-spp-674x446/06/6e/ee/d5.jpg"),
                new Grad("Требиње", "Trebinje", 42.71162482860894, 18.343473600155544, "https://gotrebinje.com/wp-content/uploads/2017/07/Trebinje-aerial-panoramic-view-1.jpg"),
                new Grad("Краков", "Krakow", 50.0532682708454, 19.94445388029057, "https://s27957.pcdn.co/wp-content/uploads/2018/06/weekend-in-krakow-main-market-square.jpg"),
                new Grad("Вроцлав", "Wroclaw", 51.12559956910441, 17.006280876290507, "https://d1bvpoagx8hqbg.cloudfront.net/originals/erasmus-experience-wroclaw-poland-arzu-ab5c170959d763ae54e0658af5656029.jpg"),
                new Grad("Варшава", "Warsaw", 52.240385842836886, 21.017260936853603, "https://www.coe.int/documents/16695/27602693/varsovie.jpg/67d16b46-3306-d00b-bad3-59dee3b6ec18"),
                new Grad("Познан", "Poznan", 52.40914697522857, 16.91337044168818, "https://content.r9cdn.net/rimg/dimg/6b/e8/44c4338b-city-31124-16f7c72ff7b.jpg?crop=true&width=568&height=320&xhint=1691&yhint=1383"),
                new Grad("Рим", "Rome", 41.90022031465476, 12.509884379676679, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Colosseum_in_Rome%2C_Italy_-_April_2007.jpg/2560px-Colosseum_in_Rome%2C_Italy_-_April_2007.jpg"),
                new Grad("Милано", "Milan", 45.46894425832485, 9.189415247474809, "https://d2bgjx2gb489de.cloudfront.net/gbb-blogs/wp-content/uploads/2018/07/18174234/Milan-Cathedral.jpg"),
                new Grad("Венеција", "Venice", 45.44106689979242, 12.331077179504797, "https://idsb.tmgrup.com.tr/ly/uploads/images/2021/06/23/123886.jpg"),
                new Grad("Болоња", "Bologna", 44.504455911486524, 11.3423368133757, "https://linkitaly.sk/FileHandler.ashx?FileID=36937&TimeStamp=20201229202137"),
                new Grad("Осло", "Oslo", 59.91164598001455, 10.754273854934135, "https://blog-assets.busbud.com/wp-content/uploads/2019/11/Oslo.png"),
                new Grad("Берген", "Bergen", 60.370903843955944, 5.309709551995242, "http://res.cloudinary.com/simpleview/image/upload/v1574085889/clients/norway/bryggen_wharf_bergen_hordaland_fjord_norway_photo_florian_olbrechts_34ad36ea-f7bc-4150-b48b-af2c2c14628f.jpg"),
                new Grad("Трондхајм", "Trondheim", 63.42685582907096, 10.408216749329261, "https://shapeenergy.eu/wp-content/uploads/2017/09/Trondheim.jpg"),
                new Grad("Ставангер", "Stavanger", 58.96611049486791, 5.731559163039068, "https://cdn.turkishairlines.com/m/4bea9bbd2c1cac97/original/Travel-Guide-of-Stavanger-via-Turkish-Airlines.jpg"),
                new Grad("Беч", "Vienna", 48.21959635047358, 16.382804030965723, "https://www.worldtravelguide.net/wp-content/uploads/2017/03/shu-Austria-Vienna-StCharles-420505375-1440x823.jpg"),
                new Grad("Грац", "Graz", 47.066537778514, 15.431824968209762, "https://dynamic-media-cdn.tripadvisor.com/media/photo-o/15/4d/44/3e/graz.jpg?w=700&h=500&s=1")
        };
    }
}
