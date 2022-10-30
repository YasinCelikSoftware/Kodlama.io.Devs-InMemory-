package kodlama.io.Devs.dataaccess.concretes;

import kodlama.io.Devs.dataaccess.abstarcts.CodeLanguageRepository;
import kodlama.io.Devs.entities.concretes.CodeLanguage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class InMemoryCodeLanguageRepository implements CodeLanguageRepository {

    List<CodeLanguage> codeLanguages;

    public InMemoryCodeLanguageRepository() {
        codeLanguages = new ArrayList<CodeLanguage>();

        codeLanguages.add(new CodeLanguage(1,"Java"));
        codeLanguages.add(new CodeLanguage(2,"C#"));
        codeLanguages.add(new CodeLanguage(3,"Python"));

    }

    @Override
    public List<CodeLanguage> getAll() {

        return codeLanguages;

    }

    @Override
    public void save(CodeLanguage codeLanguage) {
        codeLanguages.add(codeLanguage);
    }

    @Override
    public void delete(CodeLanguage codeLanguage) {
        codeLanguages.remove(codeLanguage.getId()-1);
        System.out.println(codeLanguages.remove(codeLanguage));


    }

    @Override
    public void update(CodeLanguage codeLanguage, String updatedName) {

        codeLanguages.get(codeLanguage.getId()-1).setName(updatedName);
    }

    @Override
    public CodeLanguage getById(int id){

        for(CodeLanguage codeLanguage : codeLanguages){
            if(codeLanguage.getId() == id)
                return codeLanguage;
        }
        System.out.println("This id is not exist.");
        return null;

    }
}
