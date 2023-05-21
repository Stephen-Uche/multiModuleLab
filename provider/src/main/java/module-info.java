import org.example.provider.AdditionCalculator;
import org.example.provider.MultiplicationCalculator;
import org.example.provider.SubtractionCalculator;
import org.example.service.Calculator;

module org.example.provider {
    requires org.example.service;
    exports org.example.provider;
    provides Calculator with AdditionCalculator, MultiplicationCalculator, SubtractionCalculator;
}