module org.example.consumer {

    requires java.base;
    requires org.example.service;
    uses org.example.service.Calculator;


}