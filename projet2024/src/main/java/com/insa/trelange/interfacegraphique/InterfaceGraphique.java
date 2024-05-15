package com.insa.trelange.interfacegraphique;

/**
 *
 * @author tomrelange
 */
import com.insa.trelange.calcul.Appartement;
import com.insa.trelange.calcul.Batiment;
import com.insa.trelange.calcul.CalculDevis;
import com.insa.trelange.calcul.Mur;
import com.insa.trelange.calcul.Niveau;
import com.insa.trelange.calcul.Piece;
import com.insa.trelange.calcul.Plafond;
import com.insa.trelange.calcul.Sol;
import com.insa.trelange.calcul.TextWriter;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Map;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class InterfaceGraphique extends Application {
    //private Map<String, String> piecesMap;
    //private Map<String, String> appartementsMap;
    //private Map<String, String> niveauxMap;
    private VBox previewBox;
    Stage primaryStage;
    ComboBox<Integer> niveauNumComboBox = new ComboBox<>();
    ComboBox<Integer> appartAajouterComboBox = new ComboBox<>();
    ComboBox<Integer> appartementNumComboBox = new ComboBox<>();
    ComboBox<Integer> pieceAajouterComboBox = new ComboBox<>();
    
    Canvas canvas = new Canvas(400, 400);
    

    GraphicsContext gc = canvas.getGraphicsContext2D();
    
   

    @Override
    public void start(Stage primaryStage) {
        //piecesMap = new HashMap<>();
        //appartementsMap = new HashMap<>();
        //niveauxMap = new HashMap<>();

        // Création de la fenêtre principale
        primaryStage.setTitle("Saisie");
        primaryStage.setWidth(900);
        primaryStage.setHeight(600);

        // Division de la fenêtre en deux parties
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.3);

        // Partie gauche de la fenêtre
        VBox leftPane = createLeftPane();

        // Partie droite de la fenêtre (zone d'aperçu)
        VBox rightPane = createRightPane();

        // Boutons Suivant et Précédent
        Button suivantButton = new Button("Générer le devis -->");
        Button precedentButton = new Button("Précédent");
        Button sauvegarderButton = new Button("Sauvegarder le projet");
        
        precedentButton.setOnAction(event -> {
            
            RenseignementDevis niv = new RenseignementDevis(); 
            niv.start(primaryStage);
            
        });
        
        sauvegarderButton.setOnAction(event -> {
            
            TextWriter.sauvegarde_projet(NouveauProjet.nomProj+".txt");
            
        });
        
        suivantButton.setOnAction(event -> {
            
            ArrayList<Niveau> listeValeurs = new ArrayList<>(Niveau.getNiveauMap().values());
            Batiment bat = new Batiment(NouveauProjet.idBat,NouveauProjet.nomProj,NouveauProjet.nbNiveaux,listeValeurs);
            primaryStage.close();
            CalculDevis cal = new CalculDevis();
            cal.getRevetementPrixSurface();
            TextWriter.genererDevisTexte(cal.getDevis(),"Devis.txt");
            System.out.println("succes");
            
        });
        
        
        HBox buttonsBox = new HBox(20, precedentButton,sauvegarderButton, suivantButton);
        buttonsBox.setPadding(new Insets(10));
        buttonsBox.setAlignment(Pos.BOTTOM_RIGHT);
        
        
        
        // Ajout des composants à la fenêtre principale
        splitPane.getItems().addAll(leftPane, rightPane);
        VBox mainBox = new VBox(splitPane, buttonsBox);
        Scene scene = new Scene(mainBox);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private VBox createLeftPane() {
        VBox leftPane = new VBox(10);
        leftPane.setPadding(new Insets(10));

        // Création des onglets
        TabPane tabPane = new TabPane();
        Tab pieceTab = createPieceTab();
        Tab appartementTab = createAppartementTab();
        Tab niveauTab = createNiveauTab();
        tabPane.getTabs().addAll(pieceTab, appartementTab, niveauTab);

        leftPane.getChildren().add(tabPane);
        return leftPane;
    }

    private Tab createPieceTab() {
        Tab tab = new Tab("Pièce");
        tab.setClosable(false);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        
        Button bApercu = new Button("Aperçu");
        
        bApercu.setOnAction(event -> {
            
            draw();
            
        });
        
        //HBox apercu = new HBox(20,bApercu );
        //apercu.setPadding(new Insets(10));
        //apercu.setAlignment(Pos.BOTTOM_LEFT);

        // Labels
       // Label mur1Label = new Label("Mur 1");
        //Label mur2Label = new Label("Mur 2");
       // Label mur3Label = new Label("Mur 3");
        //Label mur4Label = new Label("Mur 4");
        Label solLabel = new Label("Sol");
        Label plafondLabel = new Label("Plafond");
        Label nomPieceLabel = new Label("Nom de la pièce");

        // Listes déroulantes
        /*
        ComboBox<Integer> mur1ComboBox = new ComboBox<>();
        mur1ComboBox.getItems().addAll(Mur.getmurMap().keySet());
                
        ComboBox<Integer> mur2ComboBox = new ComboBox<>();
        mur2ComboBox.getItems().addAll(Mur.getmurMap().keySet());
        
        ComboBox<Integer> mur3ComboBox = new ComboBox<>();
        mur3ComboBox.getItems().addAll(Mur.getmurMap().keySet());
        
        ComboBox<Integer> mur4ComboBox = new ComboBox<>();
        mur4ComboBox.getItems().addAll(Mur.getmurMap().keySet());
        */
        
        ComboBox<Integer> solComboBox = new ComboBox<>();
        solComboBox.getItems().addAll(Sol.getSolMap().keySet());
        
        ComboBox<Integer> plafondComboBox = new ComboBox<>();
        plafondComboBox.getItems().addAll(Plafond.getplafondMap().keySet());
        TextField nomPieceTextField = new TextField();

        // Bouton Ajouter
        Button ajouterButton = new Button("Ajouter");
        
        
        ajouterButton.setOnAction(event -> {
            /*
            Integer mur1 = mur1ComboBox.getValue();
            Integer mur2 = mur2ComboBox.getValue();
            Integer mur3 = mur3ComboBox.getValue();
            Integer mur4 = mur4ComboBox.getValue();
            */
            Integer sol = solComboBox.getValue();
            Integer plafond = plafondComboBox.getValue();
            String nomPiece = nomPieceTextField.getText();
//mur1 != null && mur2 != null && mur3 != null && mur4 != null && 
            if (sol != null && plafond != null && nomPiece != null) {
                // Création de la pièce
                String pieceDescription =  " Sol: " + sol + ", Plafond: " + plafond;
                //piecesMap.put(nomPiece, pieceDescription);
                
                System.out.println(pieceDescription);
                
                Piece p = new Piece(Sol.getSol(sol).getM1(),Sol.getSol(sol).getM2(),Sol.getSol(sol).getM3(),Sol.getSol(sol).getM4(),Sol.getSol(sol),Plafond.getPlafond(plafond),nomPiece);

                // Mise à jour des listes déroulantes
                //updateComboBoxes();
            }
        });
        
        

        // Ajout des composants au GridPane
        /*
        gridPane.add(mur1Label, 0, 0);
        gridPane.add(mur1ComboBox, 1, 0);
        gridPane.add(mur2Label, 0, 1);
        gridPane.add(mur2ComboBox, 1, 1);
        gridPane.add(mur3Label, 0, 2);
        gridPane.add(mur3ComboBox, 1, 2);
        gridPane.add(mur4Label, 0, 3);
        gridPane.add(mur4ComboBox, 1, 3);
        */
        gridPane.add(solLabel, 0, 4);
        gridPane.add(solComboBox, 1, 4);
        gridPane.add(plafondLabel, 0, 5);
        gridPane.add(plafondComboBox, 1, 5);
        gridPane.add(nomPieceLabel, 0, 6);
        gridPane.add(nomPieceTextField, 1, 6);
        gridPane.add(ajouterButton, 1, 7);
        gridPane.add(bApercu, 1,8 );

        tab.setContent(gridPane);
        return tab;
    }

    private Tab createAppartementTab() {
        Tab tab = new Tab("Appartement");
        tab.setClosable(false);

        tab.setOnSelectionChanged(new EventHandler<Event>(){
            @Override
            public void handle(Event t) {
                
                updateComboBox();
                System.out.println("changed selec");
                
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        
        Button bApercu = new Button("Aperçu");
        
        bApercu.setOnAction(event -> {
            
            draw();
            
        });
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Labels
        Label appartementNumLabel = new Label("Appartement numéro");
        Label pieceAajouterLabel = new Label("Pièce à ajouter");

        // Listes déroulantes
        
        pieceAajouterComboBox.getItems().addAll(Piece.getPieceMap().keySet());
        appartementNumComboBox.getItems().addAll(Appartement.getAppartementMap().keySet());

        // Bouton Ajouter
        Button ajouterButton = new Button("Ajouter");
        
        ajouterButton.setOnAction(event -> {
            Integer appartementNum = appartementNumComboBox.getValue();
            Integer piece = pieceAajouterComboBox.getValue();
            if (appartementNum != null && piece != null) {
                // Ajout de la pièce à l'appartement
                Appartement.addPiece(appartementNum, Piece.getPiece(piece));
                //appartementsMap.put(appartementNum, piece);

                // Mise à jour des listes déroulantes
                //updateComboBoxes();
            } else {
                if (appartementNum == null){
                    Appartement apt = new Appartement();
                    apt.setPieces(Piece.getPiece(piece));
                    System.out.println(apt.toString());
                }
            }
            
        });

        // Ajout des composants au GridPane
        gridPane.add(appartementNumLabel, 0, 0);
        gridPane.add(appartementNumComboBox, 1, 0);
        gridPane.add(pieceAajouterLabel, 0, 1);
        gridPane.add(pieceAajouterComboBox, 1, 1);
        gridPane.add(ajouterButton, 1, 2);
        gridPane.add(bApercu, 1, 3);

        tab.setContent(gridPane);
        return tab;
    }

    private Tab createNiveauTab() {
        Tab tab = new Tab("Niveau");
        tab.setClosable(false);
        
        Button bApercu = new Button("Aperçu");
        
        bApercu.setOnAction(event -> {
            
            draw();
            
        });
        
        tab.setOnSelectionChanged(new EventHandler<Event>(){
            @Override
            public void handle(Event t) {
                
                updateComboBox();
                System.out.println("changed selecNIV");
                
                //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        
        
             
            
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Labels
        Label niveauNumLabel = new Label("Niveau numéro");
        Label pieceAajouterLabel = new Label("Appartement à ajouter");

        // Listes déroulantes
        
        niveauNumComboBox.getItems().addAll(Niveau.getNiveauMap().keySet());
        
        appartAajouterComboBox.getItems().addAll(Appartement.getAppartementMap().keySet());

        // Bouton Ajouter
        Button ajouterButton = new Button("Ajouter");
        ajouterButton.setOnAction(event -> {
            Integer niveauNum = niveauNumComboBox.getValue();
            Integer appartement = appartAajouterComboBox.getValue();
            if (niveauNum != null && appartement != null) {
                // Ajout de la pièce à l'appartement
                Niveau.addAppartement(niveauNum, Appartement.getAppart(appartement));
                //appartementsMap.put(appartementNum, piece);

                // Mise à jour des listes déroulantes
                //updateComboBoxes();
            } else {
                if (niveauNum == null){
                    Niveau niv = new Niveau();
                    niv.setAppart(Appartement.getAppart(appartement));
                }
            }
        });

        // Ajout des composants au GridPane
        gridPane.add(niveauNumLabel, 0, 0);
        gridPane.add(niveauNumComboBox, 1, 0);
        gridPane.add(pieceAajouterLabel, 0, 1);
        gridPane.add(appartAajouterComboBox, 1, 1);
        gridPane.add(ajouterButton, 1, 2);
        gridPane.add(bApercu, 1, 3);

        tab.setContent(gridPane);
        return tab;

    }

    private VBox createRightPane() {
        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(10));

        // Zone d'aperçu
        previewBox = new VBox();
        previewBox.setPrefSize(600, 600);
        previewBox.setStyle("-fx-border-color: black;");

        rightPane.getChildren().add(previewBox);
        return rightPane;
    }
    
    private void draw(){
        
        
        Canvas canvas = new Canvas(400, 400);
        previewBox.getChildren().setAll(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(3.0);
        
        //dessine les murs à l'aide des coordonnées
        for (Map.Entry<Integer, Mur> entry : Mur.getmurMap().entrySet()) {
            
            Mur value = entry.getValue();
            gc.strokeLine(value.getDebut().getX()*40, value.getDebut().getY()*40, value.getFin().getX()*40,value.getFin().getY()*40);
            
            
        }
    }
    
    
    private void updateComboBox(){
        niveauNumComboBox.getItems().clear();
        appartAajouterComboBox.getItems().clear();
        pieceAajouterComboBox.getItems().clear();
        appartementNumComboBox.getItems().clear();
        niveauNumComboBox.getItems().addAll(Niveau.getNiveauMap().keySet());
        System.out.println(Appartement.getAppartementMap());
        appartAajouterComboBox.getItems().addAll(Appartement.getAppartementMap().keySet());
        pieceAajouterComboBox.getItems().addAll(Piece.getPieceMap().keySet());
        appartementNumComboBox.getItems().addAll(Appartement.getAppartementMap().keySet());
        System.out.println("combo updated");
        
        
    }

}
