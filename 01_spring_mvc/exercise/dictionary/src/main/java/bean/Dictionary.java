package bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public class Dictionary {

    String wordEng;
    String wordViet;

    public Dictionary(String red, String mau_do) {
    }

    public String getWordEng() {
        return wordEng;
    }

    public void setWordEng(String wordEng) {
        this.wordEng = wordEng;
    }

    public String getWordViet() {
        return wordViet;
    }

    public void setWordViet(String wordViet) {
        this.wordViet = wordViet;
    }
}
