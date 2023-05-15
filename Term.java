package MyQuizlet;

public class Term {
    
    private String termName;
    private String definition;
    
    public Term(String termName, String definition) {
        this.termName = termName;
        this.definition = definition;
    }

    public String getTerm() {
        return termName;
    }
    
    public String getDef() {
        return  definition;
    }

    
}
