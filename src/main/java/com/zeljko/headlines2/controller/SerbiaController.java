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
public class SerbiaController {

    private HeadlineRepository headlineRepository;

    @Autowired
    public SerbiaController(HeadlineRepository headlineRepository) {
        this.headlineRepository = headlineRepository;
    }

    private String category;
    private String category1;

    @GetMapping("/listSerbia")
    public String list(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://newsapi.org/v2/top-headlines?country=rs&";
        String apiKey = "apiKey=fea65d43fecb4bc3870af0ce95d2362c";
        String url = baseUrl + category + apiKey;
        HeadlineList response = restTemplate.getForObject(url, HeadlineList.class);
        assert response != null;
        List<Headline> headlines = response.getArticles();
        for (Headline headline : headlines) {
            headlineRepository.save(headline);
        }
        model.addAttribute("headlines", headlines);
        model.addAttribute("cat", category1);
        return "serbia_headline_list";
    }

    @GetMapping("/listTop")
    public String listTop() {
        category = "";
        category1 = "";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listScience")
    public String listScience() {
        category = "category=science&";
        category1 = "science";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listSports")
    public String listSports() {
        category = "category=sports&";
        category1 = "sports";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listBusiness")
    public String listBusiness() {
        category = "category=business&";
        category1 = "business";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listHealth")
    public String listHealth() {
        category = "category=health&";
        category1 = "health";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listEntertainment")
    public String listentertainment() {
        category = "category=entertainment&";
        category1 = "entertainment";
        return "redirect:/listSerbia";
    }

    @GetMapping("/listTechnology")
    public String listTechnology() {
        category = "category=technology&";
        category1 = "technology";
        return "redirect:/listSerbia";
    }

    @GetMapping("/headlineSerbia/{id}")
    public String headlineSerbia(@PathVariable("id") long headlineID, Model model) {

        Headline headline = headlineRepository.findById(headlineID).get();

        model.addAttribute("headline", headline);
        return "headline";
    }

}
