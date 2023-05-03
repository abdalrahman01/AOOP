package lab3.E4;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Element {

    String name();

}