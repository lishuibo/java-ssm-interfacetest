package com.litl.www.controller;

import com.litl.www.pojo.Paper;
import com.litl.www.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/paper")
public class PagerController {
    @Autowired
    private PaperService paperService;

    @RequestMapping("/allPaper")
    public String list(Model model) {
        List<Paper> paperlist = paperService.queryAllPaper();
        model.addAttribute("paperlist", paperlist);
        return "allPaper";
    }

    @RequestMapping("/toAddPaper")
    public String toAddPaper() {
        return "addPaper";
    }

    @RequestMapping("/addPaper")
    public String addPaper(Paper paper) {
        paperService.addPaper(paper);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("/del/{paperId}")
    public String deletePaper(@PathVariable("paperId") int id) {
        paperService.deletePaperById(id);
        return "redirect:/paper/allPaper";
    }

    @RequestMapping("toUpdatePaper")
    public String toUpdatePaper(Model model, int id) {
        Paper paper = paperService.queryById(id);
        model.addAttribute("paper", paper);
        return "updatePaper";
    }

    @RequestMapping("/updatePaper")
    public String updatePaper(Model model, Paper paper) {
        paperService.updatePaper(paper);
        paper = paperService.queryById(paper.getPaperId());
        model.addAttribute("paper", paper);
        return "redirect:/paper/allPaper";
    }
}
