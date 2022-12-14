package animales_aleatorios;

public class Animal {
    private int idAnimal;
    private String tipo;

    public Animal(int idAnimal){
        this.idAnimal = idAnimal;
        String tipos[] = {"León","Gato","Perro","Venado","Elefante"};
        int i = (int) (Math.random() * 5);
        tipo = tipos[i];
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Animal-> ID: "+this.idAnimal+" Tipo: "+this.tipo;
    }
}
