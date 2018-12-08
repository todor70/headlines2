package com.zeljko.headlines2.controller;

import com.zeljko.headlines2.domain.Headline;
import com.zeljko.headlines2.domain.HeadlineList;
import com.zeljko.headlines2.repository.HeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CountryController {

    private HeadlineRepository headlineRepository;

    @Autowired
    public CountryController(HeadlineRepository headlineRepository) {
        this.headlineRepository = headlineRepository;
    }

    private String country;
    private String country1;

    @GetMapping("/listCountry")
    public String list(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://newsapi.org/v2/top-headlines?country=";
        String apiKey = "&apiKey=fea65d43fecb4bc3870af0ce95d2362c";
        String url = baseUrl + country + apiKey;
        HeadlineList response = restTemplate.getForObject(url, HeadlineList.class);
        assert response != null;
        List<Headline> headlines = response.getArticles();
        for (Headline headline : headlines) {
            headlineRepository.save(headline);
        }
        model.addAttribute("headlines", headlines);
        model.addAttribute("country1", country1);
        return "country_headline_list";
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

    @GetMapping("/headlineCountry/{id}")
    public String headlineCountry(@PathVariable("id") long headlineID, Model model) {

        Headline headline = headlineRepository.findById(headlineID).get();

        model.addAttribute("headline", headline);
        return "headline";
    }

}
