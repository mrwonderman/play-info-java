package ch.halcyon.playinfo;

import com.google.gson.Gson;

public class PackageInfo {

    private String title;
    private String category;
    private String price;
    private String updated;
    private String totalInstalls;
    private String size;
    private String currentVersion;
    private String requiresAndroid;
    private String contentRating;
    private String email;
    private String website;
    private String score;
    private String votes;
    private String developer;
    private String whatsNew;
    private String description;

    public PackageInfo() {
        // TODO Auto-generated constructor stub
    }

    public PackageInfo(String title, String category, String price,
                       String updated, String totalInstalls, String size,
                       String currentVersion, String requiresAndroid,
                       String contentRating, String email, String website, String score,
                       String votes, String developer, String whatsNew, String description) {
        super();
        this.title = title;
        this.category = category;
        this.price = price;
        this.updated = updated;
        this.totalInstalls = totalInstalls;
        this.size = size;
        this.currentVersion = currentVersion;
        this.requiresAndroid = requiresAndroid;
        this.contentRating = contentRating;
        this.email = email;
        this.website = website;
        this.score = score;
        this.votes = votes;
        this.developer = developer;
        this.whatsNew = whatsNew;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getTotalInstalls() {
        return totalInstalls;
    }

    public void setTotalInstalls(String totalInstalls) {
        this.totalInstalls = totalInstalls;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    public String getRequiresAndroid() {
        return requiresAndroid;
    }

    public void setRequiresAndroid(String requiresAndroid) {
        this.requiresAndroid = requiresAndroid;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getWhatsNew() {
        return whatsNew;
    }

    public void setWhatsNew(String whatsNew) {
        this.whatsNew = whatsNew;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toJSON() {
        return new Gson().toJson(this);
    }

}
