package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstarcts.CodeLanguageService;
import kodlama.io.Devs.entities.concretes.CodeLanguage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/codelanguages")
public class CodeLanguagesController {

    private CodeLanguageService codeLanguageService;


    public CodeLanguagesController(CodeLanguageService codeLanguageService) {
        this.codeLanguageService = codeLanguageService;
    }

    @PostMapping("/save")
    public void save(CodeLanguage codeLanguage){
        codeLanguageService.save(codeLanguage);
    }

    @PostMapping("/delete")
    public void delete(CodeLanguage codeLanguage){
        codeLanguageService.delete(codeLanguage);
    }

    @PostMapping("/update")
    public void update(CodeLanguage codeLanguage,String updatedName){
        codeLanguageService.update(codeLanguage, updatedName);
    }

    @GetMapping("/getall")
    public List<CodeLanguage> getAll(){
        return codeLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public CodeLanguage getById(int id){
        return codeLanguageService.getById(id);
    }
}
