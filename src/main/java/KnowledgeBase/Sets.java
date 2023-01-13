//package KnowledgeBase;
//
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//import java.util.*;
//
//public class Sets {
//
//    List<String> medicineCollection = List.of("Herbitussin", "Bronchostop", "Bronchostop Duo", "Goldie sept", "Propolis", "Strepsils",
//            "Strepsils intensive", "Hexoraleten", "Hexoral", "Efizol", "Trahizan", "Homeogene 9", "See a doctor");
//    public Sets() {
//        init();
//    }
//
//    private void init()
//    {
//        //Contains all medicine that can be removed from main set if item is true
//        Set<String> Cough = new HashSet<>(medicineCollection);
//
//        Cough.remove("Stodal");
//        Cough.remove("Prospan");
//        Cough.remove("Tusavit");
//        Cough.remove("Bronchostop");
//        Cough.remove("Gelomirtol");
//        Cough.remove("ACC");
//        Cough.remove("Abroxol");
//        Cough.remove("Carbocistein");
//        Cough.remove("Bron");
//
//        Set<String> Throat = new HashSet<>(medicineCollection);
//
//        Throat.remove("Homeopathy");
//        Throat.remove("Trahizan");
//        Throat.remove("Efizol");
//        Throat.remove("Hexoraleten");
//        Throat.remove("Hexoral");
//        Throat.remove("Strepsils intensive");
//        Throat.remove("Strepsils");
//        Throat.remove("Propolis");
//        Throat.remove("Herbitussin");
//        Throat.remove("Bronchostop");
//        Throat.remove("Goldie sept");
//
//        Set<String> NotPregnant = new HashSet<>(medicineCollection);
//
//        NotPregnant.remove("Herbitussin");
//        NotPregnant.remove("Strepsils");
//
//        Set<String> Pregnant = new HashSet<>(medicineCollection);
//
//        Pregnant.remove("Bronchostop Duo");
//        Pregnant.remove("Goldie sept");
//        Pregnant.remove("Propolis");
//        Pregnant.remove("Strepsils intensive");
//        Pregnant.remove("Hexoraleten");
//        Pregnant.remove("Hexoral");
//        Pregnant.remove("Efizol");
//        Pregnant.remove("Trahizan");
//
//        Set<String> NotDiabetic = new HashSet<>(medicineCollection);
//
//        NotDiabetic.remove("Bronchostop Duo");
//        NotDiabetic.remove("");
//        NotDiabetic.remove();
//        NotDiabetic.remove();
//        NotDiabetic.remove();
//        NotDiabetic.remove();
//        NotDiabetic.remove();
//        NotDiabetic.remove();
//    }
//}
