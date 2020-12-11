package com.ecommerce.microcommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ecommerce.microcommerce.model.Voiture;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MicrocommerceApplicationTests {

    @Test
    void contextLoads() {
        listerToutesLesVoituresFonctionne();
        chercherUneVoitureFonctionne();
        ajouterUneVoitureFonctionne();
        mettreAjourFonctionne();
        supprimerParId();
    }

    @Autowired
    private TestRestTemplate testRestTemplate;

    //@Test
    public void listerToutesLesVoituresFonctionne() {
        String result = this.testRestTemplate.getForObject("/Voitures", String.class);
        assertEquals("[{\"id\":1,\"modèle\":\"Polo\",\"marque\":\"Volkswagen\",\"couleur\":\"Rouge flash\"}," +
                "{\"id\":2,\"modèle\":\"Vanquish\",\"marque\":\"Aston Martin\",\"couleur\":\"Gris\"}," +
                "{\"id\":3,\"modèle\":\"Impreza\",\"marque\":\"Subaru\",\"couleur\":\"Pimpée\"}," +
                "{\"id\":4,\"modèle\":\"Gallardo\",\"marque\":\"Lamborghini\",\"couleur\":\"Carbone\"}," +
                "{\"id\":5,\"modèle\":\"Camaro\",\"marque\":\"Chevrolet\",\"couleur\":\"Jaune\"}]", result);
    }

    public void chercherUneVoitureFonctionne() {
        String result = this.testRestTemplate.getForObject("/Voitures/2", String.class);
        assertEquals("{\"id\":2,\"modèle\":\"Vanquish\",\"marque\":\"Aston Martin\",\"couleur\":\"Gris\"}", result);
    }

    public void ajouterUneVoitureFonctionne() {
        Voiture voiture = new Voiture(6, "Mini", "Austin", "vert bouteille");
        this.testRestTemplate.postForObject("/Voitures", voiture, String.class);
        String result = this.testRestTemplate.getForObject("/Voitures", String.class);
        assertEquals("[{\"id\":1,\"modèle\":\"Polo\",\"marque\":\"Volkswagen\",\"couleur\":\"Rouge flash\"}," +
                "{\"id\":2,\"modèle\":\"Vanquish\",\"marque\":\"Aston Martin\",\"couleur\":\"Gris\"}," +
                "{\"id\":3,\"modèle\":\"Impreza\",\"marque\":\"Subaru\",\"couleur\":\"Pimpée\"}," +
                "{\"id\":4,\"modèle\":\"Gallardo\",\"marque\":\"Lamborghini\",\"couleur\":\"Carbone\"}," +
                "{\"id\":5,\"modèle\":\"Camaro\",\"marque\":\"Chevrolet\",\"couleur\":\"Jaune\"}," +
                "{\"id\":6,\"modèle\":\"Mini\",\"marque\":\"Austin\",\"couleur\":\"vert bouteille\"}]", result);
        testRestTemplate.delete("/Voitures/{1}", 6);
    }

    public void mettreAjourFonctionne() {
        Voiture voiture = new Voiture(3, "Firebird", "Pontiac", "K2000");
        this.testRestTemplate.put("/Voitures/3", voiture, String.class);
        String result = this.testRestTemplate.getForObject("/Voitures/3", String.class);
        assertEquals("{\"id\":3,\"modèle\":\"Firebird\",\"marque\":\"Pontiac\",\"couleur\":\"K2000\"}", result);
    }

    public void supprimerParId() {
        testRestTemplate.delete("/Voiture/{1}", 5);
        String result = this.testRestTemplate.getForObject("/Voitures", String.class);
        assertEquals("[{\"id\":1,\"modèle\":\"Polo\",\"marque\":\"Volkswagen\",\"couleur\":\"Rouge flash\"}," +
                "{\"id\":2,\"modèle\":\"Vanquish\",\"marque\":\"Aston Martin\",\"couleur\":\"Gris\"}," +
                "{\"id\":3,\"modèle\":\"Firebird\",\"marque\":\"Pontiac\",\"couleur\":\"K2000\"}," +
                "{\"id\":4,\"modèle\":\"Gallardo\",\"marque\":\"Lamborghini\",\"couleur\":\"Carbone\"}," +
                "{\"id\":5,\"modèle\":\"Camaro\",\"marque\":\"Chevrolet\",\"couleur\":\"Jaune\"}]", result);
    }

}
