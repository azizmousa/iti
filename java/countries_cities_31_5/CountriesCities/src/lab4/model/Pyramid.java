package lab4.model;

public class Pyramid {

    private String pharaoh;
    private String ancient_name;
    private String modern_name;
    private String site;
    private String type;
    private String lepsius;
    private String material;
    private String comment;
    private int dynasty;
    private double base1;
    private double base2;
    private double height;
    private double slope;
    private double volume;
    private double latitude;
    private double longitude;


    public Pyramid(){}

    public Pyramid(String pharaoh, String ancient_name, String modern_name, String site, String type, String lepsius,
                   String material, String comment, int dynasty, double base1, double base2, double height,
                   double slope, double volume, double latitude, double longitude) {
        this.pharaoh = pharaoh;
        this.ancient_name = ancient_name;
        this.modern_name = modern_name;
        this.site = site;
        this.type = type;
        this.lepsius = lepsius;
        this.material = material;
        this.comment = comment;
        this.dynasty = dynasty;
        this.base1 = base1;
        this.base2 = base2;
        this.height = height;
        this.slope = slope;
        this.volume = volume;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getAncient_name() {
        return ancient_name;
    }

    public void setAncient_name(String ancient_name) {
        this.ancient_name = ancient_name;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLepsius() {
        return lepsius;
    }

    public void setLepsius(String lepsius) {
        this.lepsius = lepsius;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getDynasty() {
        return dynasty;
    }

    public void setDynasty(int dynasty) {
        this.dynasty = dynasty;
    }

    public double getBase1() {
        return base1;
    }

    public void setBase1(double base1) {
        this.base1 = base1;
    }

    public double getBase2() {
        return base2;
    }

    public void setBase2(double base2) {
        this.base2 = base2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "pharaoh='" + pharaoh + '\'' +
                ", ancient_name='" + ancient_name + '\'' +
                ", modern_name='" + modern_name + '\'' +
                '}';
    }
}
