import annotation.Calculation;
import org.example.service.Calculator;

module org.example.consumer {

    requires java.base;
    requires org.example.service;
    uses Calculator;
    uses Calculation;


}