package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstarcts.CodeLanguageService;
import kodlama.io.Devs.dataaccess.abstarcts.CodeLanguageRepository;
import kodlama.io.Devs.entities.concretes.CodeLanguage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeLanguageManager implements CodeLanguageService {

    private CodeLanguageRepository codeLanguageRepository;

    public CodeLanguageManager(CodeLanguageRepository codeLanguageRepository) {
        this.codeLanguageRepository = codeLanguageRepository;
    }

    @Override
    public List<CodeLanguage> getAll() {
        return codeLanguageRepository.getAll();
    }

    @Override
    public void save(CodeLanguage codeLanguage) {
        if (CodeLanguageNameValidator(codeLanguage) && CodeLanguageExistValidator(codeLanguage)) {
            codeLanguageRepository.save(codeLanguage);
        }
    }

    @Override
    public void delete(CodeLanguage codeLanguage) {

        codeLanguageRepository.delete(codeLanguage);

    }

    @Override
    public void update(CodeLanguage codeLanguage, String updatedName) {
        if (!updatedName.isEmpty() && !CodeLanguageExistValidator(codeLanguage)) {

            codeLanguageRepository.update(codeLanguage, updatedName);

        } else
            System.out.println("This language name is empty or blank.");
    }

    @Override
    public CodeLanguage getById(int id) {

        return codeLanguageRepository.getById(id);

    }



    public boolean CodeLanguageNameValidator(CodeLanguage codeLanguage) {

        System.out.println("This language name is empty or blank.");
        return !codeLanguage.getName().isEmpty();

    }

    public boolean CodeLanguageExistValidator(CodeLanguage codeLanguage) {

        for (CodeLanguage tempCodeLanguage : codeLanguageRepository.getAll()) {
            if (tempCodeLanguage.getName().equalsIgnoreCase(codeLanguage.getName())) {

                System.out.println("This coding language is already exists.");
                return false;

            }
        }

        return true;

    }
}
