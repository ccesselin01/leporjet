module ProjetInfo {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;

    //opens com.insa.figures to javafx.graphics;
    opens com.insa.ccesselin01.interfacegraphique to javafx.graphics;

}
