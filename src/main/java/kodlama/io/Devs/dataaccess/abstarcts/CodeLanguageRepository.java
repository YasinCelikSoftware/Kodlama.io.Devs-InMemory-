package kodlama.io.Devs.dataaccess.abstarcts;

import kodlama.io.Devs.entities.concretes.CodeLanguage;

import java.util.List;

public interface CodeLanguageRepository {

    List<CodeLanguage> getAll();
    CodeLanguage getById(int id);
    void save(CodeLanguage codeLanguage);
    void delete(CodeLanguage codeLanguage);
    void update(CodeLanguage codeLanguage, String updatedName);



}
