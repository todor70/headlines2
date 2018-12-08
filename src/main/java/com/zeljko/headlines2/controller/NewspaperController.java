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
public class NewspaperController {

    private HeadlineRepository headlineRepository;

    @Autowired
    public NewspaperController(HeadlineRepository headlineRepository) {
        this.headlineRepository = headlineRepository;
    }

    private String newspaper;
    private String newspaper1;

    @GetMapping("/listNewspaper")
    public String list(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://newsapi.org/v2/top-headlines?sources=";
        String apiKey = "&apiKey=fea65d43fecb4bc3870af0ce95d2362c";
        String url = baseUrl + newspaper + apiKey;
        HeadlineList response = restTemplate.getForObject(url, HeadlineList.class);
        assert response != null;
        List<Headline> headlines = response.getArticles();
        for (Headline headline : headlines) {
            headlineRepository.save(headline);
        }
        model.addAttribute("headlines", headlines);
        model.addAttribute("newspaper1", newspaper1);
        return "newspaper_headline_list";
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

    @GetMapping("/headlineNewspaper/{id}")
    public String headlineNewspaper(@PathVariable("id") long headlineID, Model model) {

        Headline headline = headlineRepository.findById(headlineID).get();

        model.addAttribute("headline", headline);
        return "headline";
    }

}
