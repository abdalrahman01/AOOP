package lab3.E4;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface ElementField {

    String name();
    String visibility() default "public";

}