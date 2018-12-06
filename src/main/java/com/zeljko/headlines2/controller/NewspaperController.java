package com.zeljko.headlines2.controller;

import com.zeljko.headlines2.domain.Headline;
import com.zeljko.headlines2.domain.HeadlineList;
import com.zeljko.headlines2.repository.HeadlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/listNewspaper")
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

    @RequestMapping("/listBBCNews")
    public String listBBCNews() {
        newspaper = "bbc-news";
        newspaper1 = "BBC News";
        return "redirect:/listNewspaper";
    }

    @RequestMapping("/listGuardian")
    public String listGuardian() {
        newspaper = "the-guardian-uk";
        newspaper1 = "The Guardian (UK)";
        return "redirect:/listNewspaper";
    }

    @RequestMapping("/listWashingtonPost")
    public String listWashingtonPost() {
        newspaper = "the-washington-post";
        newspaper1 = "The Washington Post";
        return "redirect:/listNewspaper";
    }

    @RequestMapping("/listCNN")
    public String listCNN() {
        newspaper = "cnn";
        newspaper1 = "CNN";
        return "redirect:/listNewspaper";
    }

    @RequestMapping("/listDailyMail")
    public String listDailyMail() {
        newspaper = "daily-mail";
        newspaper1 = "Daily Mail";
        return "redirect:/listNewspaper";
    }

    @RequestMapping("/listTime")
    public String listTime() {
        newspaper = "time";
        newspaper1 = "Time";
        return "redirect:/listNewspaper";
    }

    @RequestMapping("/listNG")
    public String listNG() {
        newspaper = "national-geographic";
        newspaper1 = "National Geographic";
        return "redirect:/listNewspaper";
    }

    @RequestMapping(value = "/headlineNewspaper/{id}", method = RequestMethod.GET)
    public String headlineNewspaper(@PathVariable("id") long headlineID, Model model) {

        Headline headline = headlineRepository.findById(headlineID).get();

        model.addAttribute("headline", headline);
        return "headline";
    }

}
