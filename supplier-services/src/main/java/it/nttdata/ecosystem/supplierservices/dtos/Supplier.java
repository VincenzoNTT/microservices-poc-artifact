package it.codingjam.supplierservices.dtos;

public class Supplier {

    private int articleCode;

    private String name;

    public int getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(int articleCode) {
        this.articleCode = articleCode;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}
