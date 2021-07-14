package repository;

import bean.Dictionary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Repository
public class DictionaryRepositoryIml implements DictionaryRepository {
    static Map<String,String> wordMap;

    static {
        wordMap=new HashMap<>();
        Dictionary dictionary1=new Dictionary("red","mau do");
        Dictionary dictionary2=new Dictionary("yellow","mau vang");
        Dictionary dictionary3=new Dictionary("blue","xanh nuoc bien");
        Dictionary dictionary4=new Dictionary("green","xanh la cay");
        Dictionary dictionary5=new Dictionary("white","trang");
        Dictionary dictionary6=new Dictionary("black","đen");
        Dictionary dictionary7=new Dictionary("orange","mau cam");

        wordMap.put(dictionary1.getWordEng(),dictionary1.getWordViet());
        wordMap.put(dictionary2.getWordEng(),dictionary2.getWordViet());
        wordMap.put(dictionary3.getWordEng(),dictionary3.getWordViet());
        wordMap.put(dictionary4.getWordEng(),dictionary4.getWordViet());
        wordMap.put(dictionary5.getWordEng(),dictionary5.getWordViet());
        wordMap.put(dictionary6.getWordEng(),dictionary6.getWordViet());
        wordMap.put(dictionary7.getWordEng(),dictionary7.getWordViet());

    }



    @Override
    public String findWord(String english) {
        String word="khong tim thay tu nay";
        if (wordMap.get(english)!=null){
            return  wordMap.get(english);
        }
        return word;
    }

}
