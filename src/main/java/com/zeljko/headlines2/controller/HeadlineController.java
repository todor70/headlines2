package com.zeljko.headlines2.controller;

import com.zeljko.headlines2.entity.Headline;
import com.zeljko.headlines2.entity.HeadlineList;
import com.zeljko.headlines2.repository.HeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class HeadlineController {

    private HeadlineRepository headlineRepository;

    @Autowired
    public HeadlineController(HeadlineRepository headlineRepository) {
        this.headlineRepository = headlineRepository;
    }

    private final String BASE_URL = "https://newsapi.org/v2/top-headlines?";
    private final String API_KEY = "&apiKey=fea65d43fecb4bc3870af0ce95d2362c";

    private String category;
    private String category1;
    private String country;
    private String country1;
    private String newspaper;
    private String newspaper1;

    @GetMapping("/listSerbia")
    public String listSerbia(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String urlSerbia = "country=rs&";
        String url = BASE_URL + urlSerbia + category + API_KEY;
        HeadlineList response = restTemplate.getForObject(url, HeadlineList.class);
        assert response != null;
        List<Headline> headlines = response.getArticles();
        for (Headline headline : headlines) {
            headlineRepository.save(headline);
        }
        model.addAttribute("headlines", headlines);
        model.addAttribute("category1", category1);
        return "headline_list";
    }

    @GetMapping("/listTop")
    public String listTop() {
        category = "";
        category1 = "";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listScience")
    public String listScience() {
        category = "category=science";
        category1 = "science";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listSports")
    public String listSports() {
        category = "category=sports";
        category1 = "sports";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listBusiness")
    public String listBusiness() {
        category = "category=business";
        category1 = "business";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listHealth")
    public String listHealth() {
        category = "category=health";
        category1 = "health";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listEntertainment")
    public String listentertainment() {
        category = "category=entertainment";
        category1 = "entertainment";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listTechnology")
    public String listTechnology() {
        category = "category=technology";
        category1 = "technology";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listCountry")
    public String listCountry(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String urlCountry = "country=";
        String url = BASE_URL + urlCountry + country + API_KEY;
        HeadlineList response = restTemplate.getForObject(url, HeadlineList.class);
        assert response != null;
        List<Headline> headlines = response.getArticles();
        for (Headline headline : headlines) {
            headlineRepository.save(headline);
        }
        model.addAttribute("headlines", headlines);
        model.addAttribute("country1", country1);
        return "headline_list";
    }

    @GetMapping("/listUSA")
    public String listUSA() {
        country = "us";
        country1 = "USA";
        return "redirect:/listCountry";
    }

    @GetMapping("/listRussia")
    public String listRussia() {
        country = "ru";
        country1 = "Russia";
        return "redirect:/listCountry";
    }

    @GetMapping("/listAustralia")
    public String listAustralia() {
        country = "au";
        country1 = "Australia";
        return "redirect:/listCountry";
    }

    @GetMapping("/listUnitedKingdom")
    public String listUnitedKingdom() {
        country = "gb";
        country1 = "United Kingdom";
        return "redirect:/listCountry";
    }

    @GetMapping("/listChina")
    public String listChina() {
        country = "cn";
        country1 = "China";
        return "redirect:/listCountry";
    }

    @GetMapping("/listJapan")
    public String listJapan() {
        country = "jp";
        country1 = "Japan";
        return "redirect:/listCountry";
    }

    @GetMapping("/listGermany")
    public String listGermany() {
        country = "de";
        country1 = "Germany";
        return "redirect:/listCountry";
    }

    @GetMapping("/listNewspaper")
    public String listNewspaper(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String urlNewspaper = "sources=";
        String url = BASE_URL + urlNewspaper + newspaper + API_KEY;
        HeadlineList response = restTemplate.getForObject(url, HeadlineList.class);
        assert response != null;
        List<Headline> headlines = response.getArticles();
        for (Headline headline : headlines) {
            headlineRepository.save(headline);
        }
        model.addAttribute("headlines", headlines);
        model.addAttribute("newspaper1", newspaper1);
        return "headline_list";
    }

    @GetMapping("/listBBCNews")
    public String listBBCNews() {
        newspaper = "bbc-news";
        newspaper1 = "BBC News";
        return "redirect:/listNewspaper";
    }

    @GetMapping("/listGuardian")
    public String listGuardian() {
        newspaper = "the-guardian-uk";
        newspaper1 = "The Guardian (UK)";
        return "redirect:/listNewspaper";
    }

    @GetMapping("/listWashingtonPost")
    public String listWashingtonPost() {
        newspaper = "the-washington-post";
        newspaper1 = "The Washington Post";
        return "redirect:/listNewspaper";
    }

    @GetMapping("/listCNN")
    public String listCNN() {
        newspaper = "cnn";
        newspaper1 = "CNN";
        return "redirect:/listNewspaper";
    }

    @GetMapping("/listDailyMail")
    public String listDailyMail() {
        newspaper = "daily-mail";
        newspaper1 = "Daily Mail";
        return "redirect:/listNewspaper";
    }

    @GetMapping("/listTime")
    public String listTime() {
        newspaper = "time";
        newspaper1 = "Time";
        return "redirect:/listNewspaper";
    }

    @GetMapping("/listNG")
    public String listNG() {
        newspaper = "national-geographic";
        newspaper1 = "National Geographic";
        return "redirect:/listNewspaper";
    }


    @GetMapping("/headline/{id}")
    public String headlineSerbia(@PathVariable("id") long headlineID, Model model) {

        Headline headline = headlineRepository.findById(headlineID).get();

        model.addAttribute("headline", headline);
        return "headline";
    }

}
