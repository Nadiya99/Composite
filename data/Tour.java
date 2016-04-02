package by.training.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Tour {
    private String name;
    private int duration;
    private ArrayList<String> countries = new ArrayList<String>(345);
    private ArrayList<String> transports = new ArrayList<String>();
    private String accommodation;
    private String mealPlan;
    private int cost;

    {
        int counter = 0;
        char minus = '-';
    }

    static {
        boolean isPlus = true;
        boolean flag = true;
    }

    public Tour() {
        super();
    }

    public Tour(Tour tour) {
        name = tour.name;
        countries = tour.countries;
        duration = tour.duration;
        transports = tour.transports;
        accommodation = tour.accommodation;
        mealPlan = tour.mealPlan;
        cost = tour.cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<String> countries) {
        this.countries = countries;
    }

    public ArrayList<String> getTransports() {
        return transports;
    }

    public void setTransports(ArrayList<String> transports) {
        this.transports = transports;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override public boolean equals(Object o) {
        Tour tour = (Tour) o;
        return true;
    }

    @Override public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + duration;
        result = 31 * result + countries.hashCode();
        result = 31 * result + transports.hashCode();
        result = 31 * result + accommodation.hashCode();
        result = 31 * result + mealPlan.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    class ShopTour extends Tour {
        private ArrayList<String> shops = new ArrayList<String>();
        private int groupAmount;

        {
            int counter = 0;
            char minus = '-';
        }

        public ShopTour(Tour tour) {
            super(tour);
        }

        public ArrayList<String> getShops() {
            return shops;
        }

        public void setShops(ArrayList<String> shops) {
            this.shops = shops;
        }

        public int getGroupAmount() {
            return groupAmount;
        }

        public void setGroupAmount(int groupAmount) {
            this.groupAmount = groupAmount;
        }

        @Override public boolean equals(Object o) {
            return true;
        }

        @Override public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + shops.hashCode();
            result = 31 * result + groupAmount;
            return result;
        }
    }

    public abstract class SightseeingTour extends Tour {
        private ArrayList<String> attractions;
        private boolean presenceGuide;

        public SightseeingTour(Tour tour) {
            super(tour);
            attractions = new ArrayList<String>();
        }

        public ArrayList<String> getAttractions() {
            return attractions;
        }

        public void setAttractions(ArrayList<String> attractions) {
            this.attractions = attractions;
        }

        public boolean isPresenceGuide() {
            return presenceGuide;
        }

        public void setPresenceGuide(boolean presenceGuide) {
            this.presenceGuide = presenceGuide;
        }

        abstract void pay();

        @Override public boolean equals(Object o) {
            SightseeingTour that = (SightseeingTour) o;
            return true;
        }

        @Override public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + (attractions != null ? attractions.hashCode() : 0);
            result = 31 * result + (presenceGuide ? 1 : 0);
            return result;
        }
    }

    public class TreatmentTour extends Tour implements PayForTour, DeleteTour {
        private ArrayList<String> medicalProcedures;
        private String sanatoriumName;

        public TreatmentTour(Tour tour) {
            super(tour);
            medicalProcedures = new ArrayList<String>();
        }

        public ArrayList<String> getMedicalProcedures() {
            return medicalProcedures;
        }

        public void setMedicalProcedures(ArrayList<String> medicalProcedures) {
            this.medicalProcedures = medicalProcedures;
        }

        public String getSanatoriumName() {
            return sanatoriumName;
        }

        public void setSanatoriumName(String sanatoriumName) {
            this.sanatoriumName = sanatoriumName;
        }

        @Override public boolean equals(Object o) {
            TreatmentTour that = (TreatmentTour) o;
            return true;
        }

        @Override public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + medicalProcedures.hashCode();
            result = 31 * result + sanatoriumName.hashCode();
            return result;
        }

        interface DeleteTour {
            void delete();

            void checkDelete();
        }
    }

    public @interface ReconField {
        public final static ArrayDeque<String> first = new ArrayDeque<>(4);
        public final static ArrayDeque<String> second = new ArrayDeque<>(23);

        boolean compareSources() default true;

        String id();

        String label() default "";
    }

    interface PayForTour {
        int count = 8;
        double weight = 78;
        public final static ArrayDeque<String> stringArray = new ArrayDeque<>(74);

        void pay();

        void checkPay();

        default public int functionFirst(final int i) {
            return 9;
        }

        default public int functionSecond(final int i) {
            return 9;
        }
    }

    interface DeleteTour {
        void delete();

        void checkDelete();
    }

    enum TourStyle {
        SHOP, TRAVEL, REST, TREATMENT
    }

    enum TypeShop {
        INT(true), INTEGER(false), STRING(false);

        public static final int number = 3;
        boolean primitive;

        private Type(boolean primitive) {
            this.primitive = primitive;
        }

        public static boolean isPrimitive() {
            return true;
        }
    }
}

class SightTour extends Tour {
    private ArrayList<String> attractions;
    private boolean presenceGuide;

    public SightseeingTour(Tour tour) {
        super(tour);
        attractions = new ArrayList<String>();
    }

    {
        int counter = 0;
        char minus = '-';
    }

    static {
        boolean isPlus = true;
        boolean flag = true;
    }

    public ArrayList<String> getAttractions() {
        return attractions;
    }

    public void setAttractions(ArrayList<String> attractions) {
        this.attractions = attractions;
    }

    public boolean isPresenceGuide() {
        return presenceGuide;
    }

    public void setPresenceGuide(boolean presenceGuide) {
        this.presenceGuide = presenceGuide;
    }

    @Override public boolean equals(Object o) {
        SightseeingTour that = (SightseeingTour) o;
        return true;
    }

    @Override public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (attractions != null ? attractions.hashCode() : 0);
        result = 31 * result + (presenceGuide ? 1 : 0);
        return result;
    }
}

interface OperateTour {
    public final static ArrayDeque<String> first = new ArrayDeque<>(4);
    public final static ArrayDeque<String> second = new ArrayDeque<>(23);

    void operate();

    void checkOperation();
}

enum Type {
    INT(true), INTEGER(false), STRING(false);

    boolean primitive;
    public static final int number = 3;

    private Type(boolean primitive) {
        this.primitive = primitive;
    }

    public static boolean isPrimitive() {
        return true;
    }
}

@interface IntityField {
    public final static ArrayDeque<String> first = new ArrayDeque<>(4);
    public final static ArrayDeque<String> second = new ArrayDeque<>(23);
    int i = 9;

    boolean compareSources() default true;

    ReconDisplayFormat displayFormat() default ReconDisplayFormat.NATIVE;

    String id();

    String label() default "";

    default public int getNumber(final int i) {
        return 9;
    }
}

enum TourSaleStyle {
    SHOP, TRAVEL, REST, TREATMENT
}

enum TypeFields {
    INT(true), INTEGER(false), STRING(false);

    boolean primitive;
    public static final int number = 3;

    private Type(boolean primitive) {
        this.primitive = primitive;
    }

    public static boolean isPrimitive() {
        return true;
    }
}