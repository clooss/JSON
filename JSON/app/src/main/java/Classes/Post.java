package Classes;

/**
 * Created by maciejgalos on 19.01.15.
 */
public class Post {
    private String date,author,topic,image_url,text;
    private String[] keywords;

    public Post(String date, String author, String topic, String image_url, String text, String[] keywords){
        this.date = date;
        this.author = author;
        this.topic = topic;
        this.image_url=image_url;
        this.text = text;
        this.keywords = keywords;
    }
    public Post(){
        this.date="";
        this.author="";
        this.topic="";
        this.image_url="";
        this.text="";
        this.keywords=new String[0];

    }

    public String getDate(){
        return date;
    }
    public String getAuthor(){
        return author;
    }
    public String getTopic(){
        return topic;
    }
    public String getImage_url(){
        return image_url;
    }
    public String getText(){
        return text;
    }
    public String[] getKeywords(){
        return keywords;
    }

    public void setDate(String date){
        this.date=date;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setTopic(String topic){
        this.topic=topic;
    }
    public void setImage_url(String url){
        this.image_url=url;
    }
    public void setText(String text){
        this.text=text;
    }
    public void setKeywords(String[] keywords){
        this.keywords=keywords;
    }









//    "date": "10.02.2013",
//            "author": "Paweł Sporysz",
//            "topic": "Wyniki z PSiO - katastrofa",
//            "image_url": "http://pulpypics.com/wp-content/uploads/2014/09/emoticon.jpg",
//            "text": "W przeciągu ostatniego roku wyniki zdoywane przez uczniów z przedmiotu programowanie strukturalne i obiektowe pokazały, ze poziom umiejetosci osiagany przez uczniow z tej dziedziny informatyki spada na leb na szyje. Bla bla bla...",
//            "keywords":
}
