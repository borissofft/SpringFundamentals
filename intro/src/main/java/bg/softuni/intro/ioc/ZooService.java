package bg.softuni.intro.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ZooService {

    private final Animal animal1;
    private final Animal animal2;

    @Autowired
    public ZooService(@Qualifier("mySuperDog") Animal animal1,
                      @Qualifier("cat") Animal animal2) {
        this.animal1 = animal1;
        this.animal2 = animal2;
    }

    public void doWork() {
        this.animal1.makeNoise();
        this.animal2.makeNoise();
    }

//    private final List<Animal> animals;
//
//    @Autowired
//    public ZooService(List<Animal> animals) {
//        this.animals = animals;
//    }
//
//    public void doWork() {
//        this.animals.forEach(Animal::makeNoise);
//    }

}
