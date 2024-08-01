package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV2 {

    public static void main(String[] args) {
        AnimalHospitalV2<Dog> dogAnimalHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catAnimalHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Integer> integerAnimalHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Object> objectAnimalHospital = new AnimalHospitalV2<>();
    }
}
