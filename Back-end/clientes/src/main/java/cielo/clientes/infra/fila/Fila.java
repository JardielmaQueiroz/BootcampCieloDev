package cielo.clientes.infra.fila;
import java.util.LinkedList;
import org.springframework.stereotype.Service;

@Service
public class Fila<T> {
    private LinkedList<T> fila = new LinkedList<>();

    public void adicionar(T item) {
        fila.addLast(item);
    }

    public boolean vazia() {
        return fila.isEmpty();
    }

    public int tamanho() {
        return fila.size();
    }

    public T retirar() {
        if (!vazia()) {
            return fila.removeFirst();
        }
        else return null;
    }

    public LinkedList<T> getFila()
    {
        return fila;
    }
}