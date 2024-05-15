module ProjetInfo_S2 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;

    //opens com.insa.figures to javafx.graphics;
    opens com.insa.trelange.interfacegraphique to javafx.graphics;

}
