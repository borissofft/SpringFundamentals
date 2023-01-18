package bg.softuni.mobilele;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// With this Class we can get the hash code of the password and copy it to the data.sql file

//@Component
//public class Temp implements CommandLineRunner {
//    private PasswordEncoder encoder;
//
//    @Autowired
//    public Temp(PasswordEncoder encoder) {
//        this.encoder = encoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(this.encoder.encode("topsecret"));
//    }
//
//}
