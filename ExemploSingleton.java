package model;

public class ExemploSingleton {
    private static ExemploSingleton exemploSingleton;
    
    private ExemploSingleton() {
        
    }
    
     public static ExemploSingleton getInstance() {
        if(exemploSingleton == null) {
            exemploSingleton = new ExemploSingleton();
        }
        return exemploSingleton;
    }
}
