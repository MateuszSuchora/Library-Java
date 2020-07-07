package ovh.devnote.ksiegarnia.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "ksiazki")
public class Ksiazka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "wydawnictwo")
    private String wydawnictwo;
    @Column(name = "cena")
    private float cena;
    @ManyToOne
    @JoinColumn(name="kategoria_id")
    private Kategoria kategoria;
    @ManyToMany
    @JoinTable(name = "autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autorzy;
    public Ksiazka() { }
    public Ksiazka(String nazwa, String wydawnictwo, float cena) {
        this.nazwa = nazwa;
        this.wydawnictwo = wydawnictwo;
        this.cena = cena;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNazwa() {
        return nazwa;
    }
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
    public String getWydawnictwo() {
        return wydawnictwo;
    }
    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }
    public float getCena() {
        return cena;
    }
    public void setCena(float cena) {
        this.cena = cena;
    }
    public Kategoria getKategoria() {
        return kategoria;
    }
    public void setKategoria(Kategoria kategoria) {
        this.kategoria = kategoria;
    }
    public String getAutorzy() {
        return autorzy.get(0).toString();
    }
    public void setAutorzy(List<Autor> autorzy) {
        this.autorzy = autorzy;
    }
    public void addAutor(Autor autor) {
        if (autorzy == null)
            autorzy = new ArrayList<>();
        autorzy.add(autor);
    }
    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", wydawnictwo='" + wydawnictwo + '\'' +
                ", cena=" + cena +
//                ", kategoria=" + kategoria +
                '}';
    }
}
